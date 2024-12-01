<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질의답변</title>
<%@include file="/include/boardDetail.jsp"%>
</head>
<body>
	<%@include file="/include/header.jsp"%>
	<div style="margin-top: 20px;"></div>

	<!-- 
	1. footer.jsp에서 적용하고 있던 js는 content를 찾아서  높이를 조절함
	2. noticeInsert.jsp에서는 'content' 이름을 가진 class가 없어서 에러가 발생함
	3. noticeInsert.jsp에서 클래스 content를 추가해서 높이를 조절함
 -->
	<div class="container content">
		<div class="header">
			<h1>공지사항 등록</h1>
		</div>

		<form action="<%=request.getContextPath()%>/notice/insert.do"
			method="post">
			<div class="content">
				<div style="margin-top: 20px;"></div>
				<table>
					<tr>
						<th>제목</th>
						<td><input type="text" name="noticeTitle" required></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>b1a4</td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="noticeContent" rows="10" required></textarea></td>
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
