<%@page import="kr.or.ddit.contest.vo.BookReportVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	List<BookReportVO> reportList = (List<BookReportVO>) request.getAttribute("reportList");
	String memId =  session.getAttribute("memId") == null ? "" : (String) session.getAttribute("memId");
	
	List<BookReportVO> list = (List<BookReportVO>) request.getAttribute("list");
	int start = (int) request.getAttribute("start");
	int startPage = (int) request.getAttribute("startPage");
	int endPage = (int) request.getAttribute("endPage");
	int totalPage = (int) request.getAttribute("totalPage");
	int totalCount = (int) request.getAttribute("totalCount");
	int currentPage = (int) request.getAttribute("currentPage");

	
	String msg =session.getAttribute("msg") ==null ? "" :
		(String)session.getAttribute("msg");
	
	session.removeAttribute("msg");  
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글쓰기 목록</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> -->
<!--   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<%@include file="/include/boardList.jsp" %>
<style>
#search {
/* display: inline-block; */
 display: inline;
}
#paging {
 display: inline-block;
/*  display: inline; */
}


</style>
</head>
<body>
<%@include file="/include/header.jsp"%>
  <div class="container">
   <%@include file="/include/contestSidebar.jsp"%>
    <div class="content" style="position:relative; left: 200px; width:1024px; max-width:1024px">
    
    <br><h1>글쓰기</h1>
	<div class = "searchButton2">
	<form action="<%=request.getContextPath() %>/report/search.do" method="post" enctype="multipart/form-data" style="margin: 0;">
		<select id="sel" name=selValue style ="height:25px; margin-right: 13px; padding: 2px;">
		    <option value="memId">회원 ID</option>
		    <option value="bookTitle" >도서명</option>
		    <option value="rptTitle">제목</option>
		    <option value="rptContent">내용</option>
	  	</select>
	    
	    <input type="text" name="searchWord"  placeholder="검색어 입력"
				maxlength="30" style="margin-right: 10px;" required>
	    <input id="search" type="submit" value="검색">
    </form>
    </div>
    
	<table border="1" style="width:100%;">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>도서명</th>
			<th>회원ID</th>
			<th>첨부파일</th>
			<th>작성날짜</th>
		</tr>
		
<%
	int reportSize = list.size();
		if(reportSize > 0){
			for(BookReportVO rv : list){
%>		
		<tr>
			<td><%=rv.getRptNo() %></td>
			<td><a href="<%=request.getContextPath()%>/report/detail.do?rptNo=<%=rv.getRptNo() %>"><%=rv.getRptTitle() %></a></td>
			<td><%=rv.getBookTitle() %></td>
			<td><%=rv.getMemId() %></td>
			<td>
			<% 
				if(rv.getAtchFileId()!=-1){
			%>
			<img src="<%=request.getContextPath()%>/images/atchIcon.png" alt="" width="10" height="10">
			
			<%
				}else{
			%>
				&nbsp;
			<%
				}
			%>
			</td>
			<td><%=rv.getRptDate() %></td>
		</tr>
<%
			}
		}else{
%>				
	<tr align="center">
		<td colspan="5">글쓰기 정보가 존재하지 않습니다.</td>
	</tr>
<%
		}
%>	
	</table>

    <!-- 페이징처리 -->
    <div class = "pagingButton2">
		<!-- <div id="paging" style="text-align:center; "> -->
		<ul class="pagination" style="margin: 0;">
		<%
			for(int i=1 ; i <= totalPage; i++){
		%>
			
		<%-- <a href="<%=request.getContextPath() %>/report/list.do?page=<%=i%>">&nbsp;<% if(i==currentPage) out.print("["+i+"]"); else out.print(i); %>&nbsp;</a> --%>
			
			
  		<!-- <ul class="pagination"> -->
		<%--     <li><a href="<%=request.getContextPath() %>/report/list.do?page=<%=i%>"><%=i %></a></li> --%>
    		<li <% if(i==currentPage) {%> class="active" <% } else {}%>><a href="<%=request.getContextPath() %>/report/list.do?page=<%=i%>"><%=i %></a></li>
		<%		
		}
		%>
  		</ul>
  	</div>
	
	<div class = "writingButton2">
    <%
		if(memId!=null && memId !=""){
	%>	
		<div class="actions">
			<a href="<%=request.getContextPath() %>/report/insert.do"><span class="glyphicon glyphicon-pencil"></span>   글 등록</a>
		</div>
	<%	
		}
	%>
   </div>
	   
	   	
	<%
		if(msg.equals("SUCCESS")){
	%>
	<script>
		alert("정상적으로 처리되었습니다.");
	</script>
	<%		
		
		}
	%>
	</div>
	</div>
     <script>
    
     let active = "<%=request.getAttribute("active") %>"
    
    </script>
    
    <%request.setAttribute("active", "listR"); %>
   
<!-- Footer -->
<%@include file="/include/footer.jsp"%>
</body>
</html>