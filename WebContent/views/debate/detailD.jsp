<%@page import="kr.or.ddit.contest.vo.DebateVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%
	DebateVO dv = (DebateVO) request.getAttribute("dv");
	String memId =  session.getAttribute("memId") == null ? "" : (String) session.getAttribute("memId");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>토론 상세 정보</title>
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
        <h1><%= dv.getDebateTopic() %></h1>
        <span><%=dv.getDebateDate() %></span>
    </div>
    <div class="details">
		<div><span style class="bold-color">도서명:</span> <span><%=dv.getBookTitle() %></span></div>
    	<div><span style class="bold-color">작성자:</span> <span><%= dv.getAdmId() %></span></div>
    	<br>
        <div class="content"><%= dv.getDebateContent().replaceAll("\n", "<br>") %></div>
	</div>
	<div class="actions">
        <a href="<%=request.getContextPath() %>/debate/list.do">[토론 목록]</a>
        <%
        	if(memId.equals("b1a4")){
        %>
			<a href="<%=request.getContextPath() %>/debate/update.do?debateNo=<%=dv.getDebateNo()%>">[토론 수정]</a>
			<a href="<%=request.getContextPath() %>/debate/delete.do?debateNo=<%=dv.getDebateNo()%>">[토론 삭제]</a>
        <%
            }            
        %>
    </div>
</div>
<%@include file="/include/footer.jsp"%>
</body>
</html>