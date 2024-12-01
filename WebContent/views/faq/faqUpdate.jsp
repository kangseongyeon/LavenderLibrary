<%@page import="kr.or.ddit.vo.FaqVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	FaqVO fv = (FaqVO) request.getAttribute("fv");
List<FaqVO> faqList = (List<FaqVO>) request.getAttribute("faqList");
String msg = session.getAttribute("msg") == null ? "" : (String) session.getAttribute("msg");

session.removeAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ 변경</title>
<%@include file="/include/boardDetail.jsp"%>
</head>
<body>
	<%@include file="/include/header.jsp"%>
	<div style="margin-top: 20px;"></div>
	<div class="container">
		<div class="header">
			<h1>FAQ 수정</h1>
		</div>
		<form action="<%=request.getContextPath()%>/faq/update.do"
			method="post">
			<div class="content">
				<div style="margin-top: 20px;"></div>
				<input type="hidden" name="faqNo" value="<%=fv.getFaqNo()%>">
				<table>
					<tr>
						<th>번호</th>
						<td><%=fv.getFaqNo()%></td>
					</tr>
					<tr>
						<th>Question</th>
						<td><input type="text" name="faqQuestion"
							value="<%=fv.getFaqQuestion()%>"></td>
					</tr>
					<tr>
						<th>Answer</th>
						<td><input type="text" name="faqAnswer"
							value="<%=fv.getFaqAnswer()%>"></td>
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