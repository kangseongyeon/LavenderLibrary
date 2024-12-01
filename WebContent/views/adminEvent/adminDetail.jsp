<%@page import="kr.or.ddit.vo.EventVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="kr.or.ddit.comm.service.AtchFileServiceImpl"%>
<%@page import="kr.or.ddit.comm.service.IAtchFileService"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileDetailVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	EventVO ev = (EventVO) request.getAttribute("ev");
IAtchFileService fileService = AtchFileServiceImpl.getInstance();
AtchFileVO fileVO = new AtchFileVO();
fileVO.setAtchFileId(ev.getAtchFileId());
AtchFileVO atchFileVO = fileService.getAtchFile(fileVO);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>행사 정보 상세보기</title>
<%@include file="/include/boardDetail.jsp"%>
<!-- style>
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
	max-width: 50%;
	height: auto;
}

table {
	border: 1px solid black;
	margin: auto;
}
</style> -->
</head>
<body>
	<%@include file="/include/header.jsp"%>
	<div style="margin-top: 20px;"></div>
	<div class="container">
		<%@include file="/include/eventSidebar.jsp"%>
		<div class="content-wrapper">
			<main class="main-content">

				<%
					if (ev.getEventType().equals("hoilday")) {
				%>

				<div class="header">
					<h1><%=ev.getEventName()%></h1>
					<span>작성자 : <%=ev.getAdminId()%></span>
				</div>
				<div class="details">
					<div>
						<span style="font-weight: bold;">행사기간:</span> <span><%=ev.getEventDateStr()%>
							~ <%=ev.getEventDateEnd()%></span>
					</div>
				</div>
				<div class="content">
					<%=ev.getEventName()%>의 의미 :<br>
					<%=ev.getEventContent()%>
				</div>
				<%
					} else {
				%>

				<div class="header">
					<h1><%=ev.getEventName()%></h1>
					<span><%=ev.getEventType()%></span> <span>작성자 : <%=ev.getAdminId()%></span>
				</div>
				<div class="details">
					<div>
						<span style="font-weight: bold;">행사기간:</span> <span><%=ev.getEventDateStr()%>
							~ <%=ev.getEventDateEnd()%></span>
					</div>
					<div>
						<span style="font-weight: bold;">신청기간:</span> <span><%=ev.getEventRegDateStr()%>
							~ <%=ev.getEventRegDateEnd()%></span>
					</div>
				</div>
				<div class="content">
					<%
						if (atchFileVO != null && !atchFileVO.getAtchFileDetailList().isEmpty() && ev.getEventType().equals("movie")) {
						AtchFileDetailVO fileDetail = atchFileVO.getAtchFileDetailList().get(0);
					%>
					<div class="book-image">
						<img alt="표지"
							src="/image/<%=fileDetail.getStreFileNm() + "." + fileDetail.getFileExtsn()%>"
							class="book-image" style="width: 100%;">
					</div>
				</div>
				<%
					}
				%>
				<%=ev.getEventContent()%>
				<%
					}
				%>
				<div class="actions">
					<a
						href="<%=request.getContextPath()%>/views/adminEvent/calender.jsp">[달력으로]</a>
					<c:set var="loginCode" value="${sessionScope.loginCode}" />
					<c:if test="${loginCode == 'b1a4'}">

						<a
							href="<%=request.getContextPath()%>/adminEvent/update.do?eventNo=<%=ev.getEventNo()%>">[행사정보
							수정]</a>
						<a
							href="<%=request.getContextPath()%>/adminEvent/delete.do?eventName=<%=ev.getEventName()%>">[행사정보
							삭제]</a>
						</th>
					</c:if>
				</div>

			</main>

			<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
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
				window.addEventListener('resize', adjustFooter);
			</script>

		</div>
	</div>
	</div>
	<%@include file="/include/footer.jsp"%>
</body>
</html>
