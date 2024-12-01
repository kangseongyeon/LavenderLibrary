<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.InquiryVO"%>
<%@page import="kr.or.ddit.vo.InqCategoryVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	InquiryVO iv = (InquiryVO) request.getAttribute("iv");
List<InqCategoryVO> categoryList = (List<InqCategoryVO>) request.getAttribute("categoryList");
String memId = (String) session.getAttribute("memId");
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
			<h1>문의사항 수정</h1>
		</div>
		<form action="<%=request.getContextPath()%>/inquiry/update.do"
			method="post">
			<div class="content">
				<div style="margin-top: 20px;"></div>
				<input type="hidden" name="inqNo" value="<%=iv.getInqNo()%>">
				<table>
					<tr>
						<th>번호</th>
						<td><%=iv.getInqNo()%></td>
					</tr>
					<tr>
						<th>문의 유형</th>
						<td><select name="inqCategoryCode">
								<%
									for (InqCategoryVO category : categoryList) {
								%>
								<option value="<%=category.getInqCategoryCode()%>"
									<%=category.getInqCategoryCode().equals(iv.getInqCategoryCode()) ? "selected" : ""%>>
									<%=category.getCategoryName()%>
								</option>
								<%
									}
								%>
						</select></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="inqTitle"
							value="<%=iv.getInqTitle()%>"></td>
					</tr>
					<tr>
						<th>작성자</th>
						<%-- <td><input type="text" name="memId" value="<%=session.getAttribute("memId")%>" readonly></td> --%>
						<td><%=iv.getMemId()%></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="inqContent"><%=iv.getInqContent()%></textarea></td>
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
