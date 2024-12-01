<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신규 도서관 소식지 등록</title>
<%@include file="/include/boardDetail.jsp"%>
</head>
<body>
	<%@include file="/include/header.jsp"%>
	<div style="margin-top: 20px;"></div>
	<div class="container">

		<div class="header">
			<h1>도서 소개 영상 등록</h1>
		</div>

		<form action="<%=request.getContextPath()%>/news/insert.do"
			method="post" enctype="multipart/form-data">
			<div class="content">
				<div style="margin-top: 20px;"></div>
				<table>
					<tr>
						<th>제목</th>
						<td><input type="text" name="newsTitle" value=""></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>b1a4</td>
					</tr>
					<tr>
						<th>내용</th>
						<td><input type="text" name="newsContent" value=""></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td><input type="file" name="atchFile" multiple="multiple">
						</td>
					</tr>
				</table>
				<div class="buttons">
					<button type="submit">저장하기</button>
					<a href="<%=request.getContextPath()%>/news/list.do" class="button">목록보기</a>
				</div>
		</form>
	</div>
	</div>

	<%@include file="/include/footer.jsp"%>
</body>
</html>