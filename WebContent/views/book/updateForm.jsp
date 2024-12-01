<%@page import="kr.or.ddit.book.vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	BookVO bv = (BookVO) request.getAttribute("bv");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서정보 변경</title>
<%@include file="/include/boardDetail.jsp"%>
</head>
<body>
	<%@include file="/include/header.jsp"%>
	<div style="margin-top: 20px;"></div>
	<div class="container">
		<div class="header">
			<h1>도서정보 수정</h1>
		</div>
		<form action="<%=request.getContextPath()%>/book/update.do"
			method="post" enctype="multipart/form-data">
			<div class="content">
				<div style="margin-top: 20px;"></div>
				<input type="hidden" name="bookId" value="<%=bv.getBookId()%>">
				<table>
					<tr>
						<th>도서 I D</th>
						<td><%=bv.getBookId()%></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="bookName"
							value="<%=bv.getBookName()%>"></td>
					</tr>
					<tr>
						<th>저자</th>
						<td><input type="text" name="bookWriter"
							value="<%=bv.getBookWriter()%>"></td>
					</tr>
					<tr>
						<th>출판사</th>
						<td><input type="text" name="bookPublisher"
							value="<%=bv.getBookPublisher()%>"></td>
					</tr>
					<tr>
						<th>카테고리</th>
						<td><textarea name="bookCategory"><%=bv.getBookCategory()%></textarea></td>
					</tr>
					<tr>
						<th>이미지 파일</th>
						<td><input type="file" name="atchFile" multiple="multiple"></td>
					</tr>

				</table>
				<div class="buttons">
					<button type="submit">도서수정</button>
					<a href="<%=request.getContextPath()%>/book/list.do" class="button">목록보기</a>
				</div>
		</form>
	</div>
	</div>
	<%@include file="/include/footer.jsp"%>
</body>
</html>