<%@page import="kr.or.ddit.vo.AnswerVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.InquiryVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    InquiryVO iv = (InquiryVO)request.getAttribute("iv");
    List<AnswerVO> answers = (List<AnswerVO>) request.getAttribute("answers");
    String memId = (String) session.getAttribute("memId");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관에 바라다 상세</title>
<%@include file="/include/boardDetail.jsp"%>
</head>
<body>
<%@include file="/include/header.jsp"%>
<div style="margin-top: 20px;"></div>
<div class="container">
	<%@include file="/include/boardSidebar.jsp"%>

	<div class="header">
        <h1><%=iv.getInqTitle() %></h1>
        <span><%=iv.getInqDate() %></span>
    </div>
    <div class="details">
        <div><span style="font-weight: bold;">작성자:</span> <span><%=iv.getMemId() %></span></div>
    </div>
    <div class="content">
        <%=iv.getInqContent()%>
    </div>
    <div class="actions">
		<a href="<%=request.getContextPath()%>/inquiry/list.do">[목록]</a>
	    <% if(memId != null && memId.equals(iv.getMemId())) { %>
	    	<a href="<%=request.getContextPath()%>/inquiry/update.do?inqNo=<%=iv.getInqNo() %>">[글수정]</a>
	        <a href="<%=request.getContextPath()%>/inquiry/delete.do?inqNo=<%=iv.getInqNo() %>">[글삭제]</a>
		<% } %>
	 	<% if("b1a4".equals(memId)) { %>
	    	<a href="<%=request.getContextPath()%>/answer/insert.do?inqNo=<%=iv.getInqNo() %>">[답글 작성]</a>
	    <% } %>
	</div>
</div>

<hr>


<% if (answers != null && !answers.isEmpty()) { %>
 <div style="margin-top: 20px;"></div>
<div class="container">
    
    <div class="header">
    	<% for (AnswerVO answer : answers) { %>
        <h1><%=answer.getAnswerTitle() %></h1>
        <span><%=answer.getAnswerDate() %></span>
    </div>
    <div class="details">
        <div><span style="font-weight: bold;">작성자:</span> <span><%=answer.getAdmId() %></span></div>
    </div>
    <div class="content">
        <%=answer.getAnswerContent() %>
    </div>
    <div class="actions">
        <%
        	if ("b1a4".equals(memId)) {
        %>
        <a href="<%=request.getContextPath()%>/inquiry/list.do">[목록]</a>
        <a href="<%=request.getContextPath()%>/answer/update.do?inqNo=<%=iv.getInqNo() %>">[답변 수정]</a>
        <a href="<%=request.getContextPath()%>/answer/delete.do?inqNo=<%=iv.getInqNo()%>">[답변 삭제]</a>
        <%
        	}
        %>
    </div>
		<% } %>
	<% } %>
</div>
<%@include file="/include/footer.jsp"%>
</body>
</html>
 