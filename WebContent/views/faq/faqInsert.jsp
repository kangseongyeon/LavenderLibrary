<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Faq 등록</title>
<%@include file="/include/boardDetail.jsp"%>
</head>
<body>
	<%@include file="/include/header.jsp"%>
	<div style="margin-top: 20px;"></div>
	<div class="container">
		<div class="header">
			<h1>FAQ등록</h1>
		</div>

		<form action="<%=request.getContextPath()%>/faq/insert.do"
			method="post">
			<div class="content">
				<div style="margin-top: 20px;"></div>
				<table>
					<tr>
						<th>Question</th>
						<td><input type="text" name="faqQuestion" value=""></td>
					</tr>
					<tr>
						<th>Answer</th>
						<td><input type="text" name="faqAnswer" value=""></td>
					</tr>
				</table>
				<div class="buttons">
					<button type="submit">저장하기</button>
					<a href="<%=request.getContextPath()%>/faq/list.do" class="button">목록보기</a>
				</div>
		</form>
	</div>
	</div>
	<%@include file="/include/footer.jsp"%>
</body>
</html>