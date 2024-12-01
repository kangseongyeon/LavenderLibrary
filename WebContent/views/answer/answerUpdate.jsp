<%@page import="kr.or.ddit.vo.AnswerVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.InquiryVO"%>
<%@page import="kr.or.ddit.vo.InqCategoryVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	AnswerVO av = (AnswerVO) request.getAttribute("av");
List<InqCategoryVO> categoryList = (List<InqCategoryVO>) request.getAttribute("categoryList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 변경</title>
<%@include file="/include/boardDetail.jsp"%>
</head>
<body>
	<%@include file="/include/header.jsp"%>
	<div style="margin-top: 20px;"></div>
	<div class="container">
		<div class="header">
			<h1>답글 수정</h1>
		</div>
		<form action="<%=request.getContextPath()%>/answer/update.do"
			method="post">
			<div class="content">
				<div style="margin-top: 20px;"></div>
				<input type="hidden" name="inqNo" value="<%=av.getInqNo()%>">
				<table>
					<tr>
						<th>번호</th>
						<td><%=av.getInqNo()%></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="answerTitle"
							value="<%=av.getAnswerTitle()%>"></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><%=av.getAdmId()%></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="answerContent"><%=av.getAnswerContent()%></textarea></td>
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