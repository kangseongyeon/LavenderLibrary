<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.AnswerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	AnswerVO av = (AnswerVO) request.getAttribute("av");
%>
<html>
<head>
<meta charset="UTF-8">
<title>답글 등록</title>
<%@include file="/include/boardDetail.jsp"%>
</head>
<body>
	<%@include file="/include/header.jsp"%>
	<div style="margin-top: 20px;"></div>
	<div class="container">
		<div class="header">
			<h1>답변 작성</h1>
		</div>
		<form action="<%=request.getContextPath()%>/answer/insert.do"
			method="post">
			<div class="content">
				<div style="margin-top: 20px;"></div>
				<input type="hidden" name="inqNo"
					value="<%=session.getAttribute("inqNo")%>"> <input
					type="hidden" name="memId"
					value="<%=session.getAttribute("memId")%>">
				<table>
					<tr>
						<th>번호</th>
						<td><%=session.getAttribute("inqNo")%></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="answerTitle" required></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><%=session.getAttribute("memId")%></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="answerContent" required></textarea></td>
					</tr>
				</table>
				<div class="buttons">
					<button type="submit">저장하기</button>
					<a href="<%=request.getContextPath()%>/inquiry/list.do"
						class="button">목록보기</a>
				</div>
		</form>
	</div>
	</div>
	<%@include file="/include/footer.jsp"%>
</body>
</html>
