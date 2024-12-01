<%@page import="kr.or.ddit.contest.vo.OneSentenceVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileDetailVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="kr.or.ddit.contest.vo.BookReportVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	OneSentenceVO ov = (OneSentenceVO) request.getAttribute("ov");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1일 1문장 수정</title>
<%@include file="/include/boardDetail.jsp"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> -->
<!--   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
</head>
<body>
	<%@include file="/include/header.jsp"%>
	<div style="margin-top: 20px;"></div>
	<div class="container">
		<div class="header">
			<h1>1일 1문장 수정</h1>
		</div>
		<form action="<%=request.getContextPath()%>/sentence/update.do"
			method="post" enctype="multipart/form-data">
			<div class="content">
				<input type="hidden" name="senNo" value="<%=ov.getSenNo()%>">
				<table>
					<tr>
						<th>도서명</th>
						<td><%=ov.getBookTitle()%></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="senTitle"
							value="<%=ov.getSenTitle()%>"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="senContent"><%=ov.getSenContent()%></textarea></td>
					</tr>
				</table>
				<div class="buttons">
					<button type="submit">1일 1문장 수정</button>
					<a href="<%=request.getContextPath()%>/sentence/list.do"
						class="button">목록보기</a>
				</div>
		</form>
	</div>
	</div>
	<%@include file="/include/footer.jsp"%>
</body>
</html>