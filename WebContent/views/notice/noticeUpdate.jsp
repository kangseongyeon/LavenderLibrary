<%@page import="kr.or.ddit.vo.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	NoticeVO nv = (NoticeVO) request.getAttribute("nv");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 정보 변경</title>
<%@include file="/include/boardDetail.jsp"%>
</head>
<body>
	<%@include file="/include/header.jsp"%>
	<div style="margin-top: 20px;"></div>
	<div class="container">
		<div class="header">
			<h1>공지사항 수정</h1>
		</div>
		<form action="<%=request.getContextPath()%>/notice/update.do"
			method="post">
			<div class="content">
				<div style="margin-top: 20px;"></div>
				<input type="hidden" name="noticeNo" value="<%=nv.getNoticeNo()%>">
				<table>
					<tr>
						<th>번호</th>
						<td><%=nv.getNoticeNo()%></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="noticeTitle"
							value="<%=nv.getNoticeTitle()%>"></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><%=nv.getAdmId()%></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="noticeContent"><%=nv.getNoticeContent()%></textarea></td>
					</tr>
				</table>
				<div class="buttons">
					<button type="submit">저장하기</button>
					<a href="<%=request.getContextPath()%>/notice/list.do"
						class="button">목록보기</a>
				</div>
		</form>
	</div>
	</div>
	<%@include file="/include/footer.jsp"%>
</body>
</html>