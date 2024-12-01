<%@page import="kr.or.ddit.contest.vo.OneSentenceVO"%>
<%@page import="kr.or.ddit.contest.vo.BookReportVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%

List<OneSentenceVO> sentenceList = (List<OneSentenceVO>) request.getAttribute("sentenceList");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1일 1일문장 검색 목록</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <%@include file="/include/boardList.jsp"%>
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> -->
<!--   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
</head>
<body>
<%@include file="/include/header.jsp"%>
	<div class="container">
    		<%@include file="/include/contestSidebar.jsp"%>
    		<div class="content" style="position:relative; left: 200px;">
	<br><h1>검색창</h1><br>
   <div style="margin-top: 20px;"></div>

	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>도서명</th>
			<th>회원ID</th>
			<th>작성날짜</th>
		</tr>
		
<%
		int sentenceSize = sentenceList.size();
		if(sentenceSize > 0){
		for(OneSentenceVO ov : sentenceList){
%>		
		<tr>
			<td><%=ov.getSenNo() %></td>
			<td><a href="<%=request.getContextPath()%>/sentence/detail.do?senNo=<%=ov.getSenNo() %>"><%=ov.getSenTitle() %></a></td>
			<td><%=ov.getBookTitle() %></td>
			<td><%=ov.getMemId() %></td>
			<td><%=ov.getSenDate() %></td>
		</tr>
<%
			}
		}else{
%>				
	<tr align="center">
		<td colspan="5">1일 1문장 정보가 존재하지 않습니다.</a></td>
	</tr>

<%
		}

%>			
		
	<%-- <tr align="center">
		<td colspan="7"><a href="<%=request.getContextPath() %>/sentence/list.do">[전체 목록]</a></td>
	</tr> --%>
	</table>
			<div class = "searchButton">
				<div class="actions">
				    <a href="<%=request.getContextPath() %>/sentence/list.do"><span class="glyphicon glyphicon-th-list"></span>전체 목록</a>
				</div>
		</div>
		</div>
	</div>
	    <%@include file="/include/footer.jsp"%>
</body>
</html>