<%@page import="kr.or.ddit.vo.InquiryVO"%>
<%@page import="kr.or.ddit.vo.AnswerVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.InqCategoryVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	InquiryVO iv = (InquiryVO) request.getAttribute("iv");
List<AnswerVO> answers = (List<AnswerVO>) request.getAttribute("answers");
String memId = (String) session.getAttribute("memId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신규 문의 등록</title>
<%@include file="/include/boardDetail.jsp"%>
</head>
<body>
	<%@include file="/include/header.jsp"%>
	<div style="margin-top: 20px;"></div>
	<div class="container">
		<div class="header">
			<h1>문의사항 등록</h1>
		</div>
		<form action="<%=request.getContextPath()%>/inquiry/insert.do"
			method="post">
			<div class="content">
				<div style="margin-top: 20px;"></div>
				<table>
					<tr>
						<th>문의 유형</th>
						<td><select id="inqCategoryCode" name="inqCategoryCode"
							required>
								<option value="" disabled selected>*문의유형*</option>
								<%
									List<InqCategoryVO> categoryList = (List<InqCategoryVO>) request.getAttribute("categoryList");
								if (categoryList != null) {
									for (InqCategoryVO category : categoryList) {
								%>
								<option value="<%=category.getInqCategoryCode()%>"><%=category.getCategoryName()%></option>
								<%
									}
								} else {
								%>
								<option value="" disabled>No Categories Available</option>
								<%
									}
								%>
						</select></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="inqTitle" required></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><%=session.getAttribute("memId")%></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="inqContent" required></textarea></td>
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
