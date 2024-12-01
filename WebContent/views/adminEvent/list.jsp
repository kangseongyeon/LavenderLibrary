<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="kr.or.ddit.vo.EventVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	List<EventVO> eventList = (List<EventVO>) request.getAttribute("eventList");
String msg = session.getAttribute("msg") == null ? "" : (String) session.getAttribute("msg");
session.removeAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>행사 일정 리스트</title>
<style>
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

table {
	border:1px solid black;
	margin:auto;
	width : 40%;
}

</style>
</head>
<body>
<%@include file="/include/header.jsp"%>
<div class="container">
<%@include file="/include/eventSidebar.jsp"%>
<div class="content" style="position:relative; left: 200px;">
	

	<div class="content-wrapper">
		<main class="main-content">
			<table class="table table-hover">
			<colgroup>
			<col style="width:15%">
			<col style="width:20%">
			<col style="width:20%">
			<col style="width:20%">
			<col style="width:15%">
		</colgroup>
				<thead>
					<tr>
						<th>번호</th>
						<th>타입</th>
						<th>행사 이름</th>
						<th>행사 기간</th>
						<th>신청 기간</th>
						<th>장소</th>
						<th>정원</th>
					</tr>
				</thead>
				<tbody>
		<%
			if(eventList != null && !eventList.isEmpty()) {
				for(EventVO ev : eventList){
					
        	
		%>

	<tr>
    	<td style="display:none"><%=ev.getEventNo()%></td>
    	<td><%=ev.getEventRow()%></td>
    	<td><%=ev.getEventType()%></td>
    	<td><a href="<%=request.getContextPath()%>/adminEvent/eventDetail.do?eventNo=<%=ev.getEventNo()%>"><%=ev.getEventName()%></a></td>
    	<td><%=ev.getEventDateStr()%>~<%=ev.getEventDateEnd()%></td>
    	<td><%=ev.getEventRegDateStr()%>~<%=ev.getEventRegDateEnd()%></td>
    	<td><%=ev.getEventPlace()%></td>
    	<td><%=ev.getEventPeople()%></td>
	</tr>

	<%
    	    
    	}
	}
	%>
					
					<%-- <%
                    String memId=(String)request.getSession().getAttribute("loginCode");
                    if(memId!=null&&!memId.equals("b1a4")){
                %>
                 <%
                if(memId!=null&&memId.equals("b1a4")){
                %> --%>
                <c:set var="loginCode" value="${sessionScope.loginCode}" />
					<c:if test="${loginCode == 'b1a4'}">
						<tr align="right">
					<tr align="cneter">
						<td colspan="6"><a
							href="<%=request.getContextPath()%>/adminEvent/insert.do">[행사등록]</a></td>
							</tr>
					</c:if>
				<%--  <%
                    }
                    }
                %> --%>
				
				</tbody>
			</table>
		</main>
		</div>
	<!-- 	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
		<script>
			function adjustFooter() {
				var docHeight = document.documentElement.offsetHeight;
				var windowHeight = window.innerHeight;
				var footer = document.querySelector('footer');

				if (docHeight <= windowHeight) {
					footer.style.position = 'fixed';
					footer.style.bottom = '0';
					footer.style.width = '100%';
				} else {
					footer.style.position = 'static';
				}
			}

			window.addEventListener('load', adjustFooter);
			window.addEventListener('resize', adjustFooter); -->
		</script>

	 </div>
	 </div>
	<%-- <%@include file="/include/footer.jsp"%> --%>
	</body>
</html>