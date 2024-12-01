<%@page import="kr.or.ddit.contest.vo.OneSentenceVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%
	OneSentenceVO ov = (OneSentenceVO) request.getAttribute("ov");
	String memId =  session.getAttribute("memId") == null ? "" : (String) session.getAttribute("memId");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1일 1문장 상세 정보</title>
<%@include file="/include/boardDetail.jsp"%>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> -->
<!--   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
</head>
<body>
<%@include file="/include/header.jsp"%>
<div style="margin-top: 20px;"></div>
   <div class="container">
    <%@include file="/include/contestSidebar.jsp"%>
	<div class="header">
        <h1><%=ov.getSenTitle() %></h1>
        <span><%=ov.getSenDate() %></span>
    </div>
	<div class="details">
		<div><span style class="bold-color">도서명:</span> <span><%=ov.getBookTitle() %></span></div>
    	<div><span style class="bold-color">작성자:</span> <span><%=ov.getMemId() %></span></div>
    	<br>
        <div class="content"><%= ov.getSenContent().replaceAll("\n", "<br>") %></div>
	</div>
	<div class="actions">
        <a href="<%=request.getContextPath() %>/sentence/list.do">[1일 1문장 목록]</a>
        <%
        	if(ov.getMemId().equals(memId)  || memId.equals("b1a4")){
        %>
			<a href="<%=request.getContextPath() %>/sentence/update.do?senNo=<%=ov.getSenNo()%>">[1일 1문장 수정]</a>
			<a href="<%=request.getContextPath() %>/sentence/delete.do?senNo=<%=ov.getSenNo()%>">[1일 1문장 삭제]</a>
        <%
            }            
        %>
    </div>
</div>	
<%@include file="/include/footer.jsp"%>
</body>
</html>