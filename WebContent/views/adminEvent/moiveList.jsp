<%@page import="kr.or.ddit.comm.service.AtchFileServiceImpl"%>
<%@page import="kr.or.ddit.comm.service.IAtchFileService"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileDetailVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="kr.or.ddit.vo.EventVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    List<EventVO> eventList = (List<EventVO>) request.getAttribute("eventList");
    IAtchFileService fileService = AtchFileServiceImpl.getInstance();
    String msg = session.getAttribute("msg") == null ? "" : (String) session.getAttribute("msg");
    session.removeAttribute("msg");
    
	//페이징
	List<EventVO> list = (List<EventVO>) request.getAttribute("list");
	int start = (int) request.getAttribute("start");
	int startPage = (int) request.getAttribute("startPage");
	int endPage = (int) request.getAttribute("endPage");
	int totalPage = (int) request.getAttribute("totalPage");
	int totalCount = (int) request.getAttribute("totalCount");
	int currentPage = (int) request.getAttribute("currentPage");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>영화 상영 일정</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/include/eventList.jsp" %>

</head>
<body>
<%@include file="/include/header.jsp"%>
<div class="container">
<%@include file="/include/eventSidebar.jsp"%>
<div class="content" style="position:relative; left: 200px;">
	<br><h1>영화 상영 정보</h2>
	<div class = "searchButton">
						<form action="<%=request.getContextPath()%>/adminEvent/search.do" method="post" style="margin: 0;">
						<select name="searchOption" style ="height:25px; margin-right: 13px; padding: 2px;">
							<option value="eventName">제목</option>
							<option value="eventNameType">제목+타입</option>
						</select>
	                	<input type="text" name="keyWord" placeholder="검색어 입력"
							maxlength="30" style="margin-right: 10px;" required>
	                	<button type="submit">검색</button>
            		</form>
					</div>
	<div class="content-wrapper">
		<main class="main-content">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>영화포스터</th>
						<th>행사 이름</th>
						<th>행사 기간</th>
						<th>신청 기간</th>
						<th>작성자</th>
						<th>장소</th>
						<th>정원</th>
						
					</tr>
				</thead>
				<tbody>
	<%
// if(eventList != null && !eventList.isEmpty()) {
if(list != null && !list.isEmpty()) {
//     for(EventVO ev : eventList) {
    for(EventVO ev : list) {
        AtchFileVO fileVO = new AtchFileVO();
        fileVO.setAtchFileId(ev.getAtchFileId());
        AtchFileVO atchFileVO = fileService.getAtchFile(fileVO);
//         if("movie".equals(ev.getEventType())) {
%>
<tr>
    <td>
    <%
        if (atchFileVO != null && !atchFileVO.getAtchFileDetailList().isEmpty()) {
        AtchFileDetailVO fileDetail = atchFileVO.getAtchFileDetailList().get(0);
        System.out.println(fileDetail.getFileStreCours()+"."+fileDetail.getFileExtsn());
    %>
        <img alt="포스터" src="/image/<%=fileDetail.getStreFileNm()+"."+fileDetail.getFileExtsn()%>" class="movie-image">
    </td>
    <%
        }else {
        	 %> 
        	 
        	 <img src="<%=request.getContextPath()%>/images/no-image.jpg" alt="이미지 없음" class="book-image"> 
        	 
        	 <%
     	}
     %>
    <td style="display:none"><%=ev.getEventNo()%></td>
    <td><a href="<%=request.getContextPath()%>/adminEvent/eventDetail.do?eventNo=<%=ev.getEventNo()%>"><%=ev.getEventName()%></a></td>
    <td><%=ev.getEventDateStr()%>~<%=ev.getEventDateEnd()%></td>
    <td><%=ev.getEventRegDateStr()%>~<%=ev.getEventRegDateEnd()%></td>
    <td><%=ev.getAdminId()%></td>
    <td><%=ev.getEventPlace()%></td>
    <td><%=ev.getEventPeople()%></td>
    
</tr>
<%
//         } // if movie 끝
    } // for문 끝
} // if-else 끝
%>
					
				</tbody>
			</table>
			
			<!-- 페이징처리 -->
			<div class = "pagingButton">
					<ul class="pagination" style="margin: 0;">
				<%
				for(int i=1 ; i <= totalPage; i++){
				%>
					  <li <% if(i==currentPage) {%> class="active" <% } else {}%>><a href="<%=request.getContextPath() %>/adminEvent/movieList.do?page=<%=i%>"><%=i %></a></li>
				<%		
				}
				%>
					</ul>
			</div>
			
			<div class = "writingButton">
			<c:set var="loginCode" value="${sessionScope.loginCode}" />
								<c:if test="${loginCode == 'b1a4'}">
									<%-- <tr align="right">
										<td colspan="6"><a
											href="<%=request.getContextPath()%>/adminEvent/insert.do">[행사등록]</a>
										</td>
									</tr> --%>
									<div class="actions" style="margin-right: 50px;">
									    <a href="<%=request.getContextPath() %>/adminEvent/insert.do"><span class="glyphicon glyphicon-pencil"></span>   행사 등록</a>
									</div>
								</c:if>
			</div>
							
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
		</div>
		
		</main>
					
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
		

	 </div>
	 </div>
	     <script>
    
     let active = "<%=request.getAttribute("active") %>"
    
    </script>
    
    <%request.setAttribute("active", "moiveList"); %>
	<%@include file="/include/footer.jsp"%>
	</body>
</html>