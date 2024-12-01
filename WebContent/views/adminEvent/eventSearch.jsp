
<%@page import="kr.or.ddit.comm.vo.AtchFileDetailVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="kr.or.ddit.comm.service.AtchFileServiceImpl"%>
<%@page import="kr.or.ddit.comm.service.IAtchFileService"%>
<%@page import="kr.or.ddit.vo.EventVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    List<EventVO> eventList = (List<EventVO>) request.getAttribute("eventList");
    IAtchFileService fileService = AtchFileServiceImpl.getInstance();
    String msg = session.getAttribute("msg") == null ? "" : (String) session.getAttribute("msg");
    session.removeAttribute("msg");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>이벤트 목록</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <!--   <style>
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

body {
	display: flex;
	flex-direction: column;
}

.content-wrapper {
	flex: 1 0 auto;
	display: flex;
}

.main-content {
	flex: 1;
	padding: 20px;
}

.book-image {
	width: 100px;
	height: 150px;
	object-fit: cover;
}
</style> -->
<%@ include file="/include/eventList.jsp" %>
</head>
<body>
   <%@include file="/include/header.jsp"%>
	<div class="container">
	<%@include file="/include/eventSidebar.jsp"%>

	<div class="content" style="position:relative; left: 200px;">
	<br><h1>검색창</h1>
		
	<div class = "searchButton">	
	<form action="<%=request.getContextPath()%>/book/search.do"  method="post" style="margin: 0;">
		<select name="searchOption" style ="height:25px; margin-right: 13px; padding: 2px;">
			<option value="eventNameType">제목+타입</option>
			<option value="eventName">제목</option>
		</select> <input type="text" name="searchKeyword" placeholder="검색어 입력"
			maxlength="30" style="margin-right: 10px;" required>
		<button type="submit">검색</button>
	</form>
	</div>
	
	<div class="content-wrapper">
		<!-- Main Content -->
		<main class="main-content">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>행사 제목</th>
						<th>헹사시간</th>
						<th>신청기간</th>
						<th>작성자</th>
					</tr>
				</thead>
				<tbody>
				<%
					if(eventList != null && !eventList.isEmpty()) {
						for(EventVO ev : eventList) {
				%>
					<tr>
						<td><a href="<%=request.getContextPath()%>/adminEvent/eventDetail.do?eventNo=<%=ev.getEventNo()%>"><%=ev.getEventName() %></a></td>
						<td><%=ev.getEventDateStr() %>~<%=ev.getEventDateEnd() %></td>
						<td><%=ev.getEventRegDateStr() %>~<%=ev.getEventRegDateEnd() %></td>
						<td><%=ev.getAdminId() %></td>
					</tr>
					
				<%			
						}
					} else {
				
				%>
					<tr>
						<td colspan="4">행사정보가 없습니다.</td>
					</tr>
					<%
						} // if-else문 끝
					%>
			
				</tbody>
			</table>
			
			<tr>
				<td>		
            	<div class="actions" style="margin-right: 50px;">
              	  <a href="<%= request.getContextPath() %>/adminEvent/libraryList.do">[도서관 행사 목록]</a>
              	  <a href="<%= request.getContextPath() %>/adminEvent/fieldStudyList.do">[체험학습 목록]</a>
              	  <a href="<%= request.getContextPath() %>/adminEvent/movieList.do">[영화상영 목록]</a>
              	  <a href="<%= request.getContextPath() %>/views/adminEvent/calender.jsp">[달력으로]</a>
           		 </div>
            	</td>
            </tr>
            
			<%
				if (msg.equals("SUCCESS")) {
			%>
			<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
			<script>
				swal("성공!", "정상적으로 처리 되었습니다.", "success");
			</script>
			<%
				}
			%>
		</main>
		
		
	</div>
	</div>
	</div>
	
      
    <%@include file="/include/footer.jsp"%>
</body>
</html>
