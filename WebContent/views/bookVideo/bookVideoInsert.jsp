<%@page import="kr.or.ddit.vo.BookVideoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	BookVideoVO bv = (BookVideoVO) request.getAttribute("bv");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신규 도서 소개 등록</title>
<%@include file="/include/boardDetail.jsp"%>
</head>
<body>
	<%@include file="/include/header.jsp"%>
	<div style="margin-top: 20px;"></div>
	<div class="container">
		<div class="header">
			<h1>도서 소개 영상 등록</h1>
		</div>
		<form action="<%=request.getContextPath()%>/bookVideo/insert.do"
			method="post">
			<div class="content">
				<div style="margin-top: 20px;"></div>
				<table>
					<tr>
						<th>제목</th>
						<td><input type="text" name="bookVideoTitle" value=""></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>b1a4</td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="bookVideoContent" rows="10" required></textarea></td>
					</tr>
				</table>
				<div class="buttons">
					<button type="submit">저장하기</button>
					<a href="<%=request.getContextPath()%>/bookVideo/list.do"
						class="button">목록보기</a>
				</div>
		</form>
	</div>
	</div>
	<%@include file="/include/footer.jsp"%>
</body>
</html>