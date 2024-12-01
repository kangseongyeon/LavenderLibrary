<%@page import="kr.or.ddit.vo.BookVideoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%
  	List<BookVideoVO> bookVideoList = (List<BookVideoVO>) request.getAttribute("bookVideoList");
  
  	String msg = session.getAttribute("msg") == null ? ""
  			: (String) session.getAttribute("msg");
  	
  	session.removeAttribute("msg");
  	
  	String memId = (String) session.getAttribute("memId");
  	
  	//페이징처리위해 추가
  	List<BookVideoVO> list = (List<BookVideoVO>) request.getAttribute("list");
	int start = (int) request.getAttribute("start");
	int startPage = (int) request.getAttribute("startPage");
	int endPage = (int) request.getAttribute("endPage");
	int totalPage = (int) request.getAttribute("totalPage");
	int totalCount = (int) request.getAttribute("totalCount");
	int currentPage = (int) request.getAttribute("currentPage");

  %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>도서 소개 영상 목록</title>
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<%@include file="/include/boardList.jsp" %>
</head>
<body>
<%@include file="/include/header.jsp"%>
    <div class="container">
    <%@include file="/include/boardSidebar.jsp"%>
    	<div class="content" style="position:relative; left: 200px;">
    
    <br><h1>도서 소식 영상</h1>
    
	<!-- 검색창 -->
   <div class = "searchButton">
	<form action="<%=request.getContextPath()%>/bookVideo/search.do" method="post" style="margin: 0;">
        <input type="text" name="searchKeyword" placeholder="제목 입력" maxlength="30" style="margin-right: 10px;" required>
        <button type="submit">검색</button>
    </form>
   </div>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
		</tr>
		
	<%
	// 	int bookVideoSize = bookVideoList.size();
		int bookVideoSize = list.size();
		if (bookVideoSize > 0) {
	// 		for (BookVideoVO bv : bookVideoList) {
			for (BookVideoVO bv : list) {
	%>
			<tr>
				<td><%=bv.getBookVideoNo() %></td>
				<td><a = href = " <%=request.getContextPath() %>/bookVideo/detail.do?bookVideoNo=<%=bv.getBookVideoNo() %>"><%=bv.getBookVideoTitle() %></a></td>
				<td><%=bv.getAdmId() %></td>
				<td><%=bv.getBookVideoDate() %></td>
			</tr>
	<%
			}	// else 문
		} else {
	%>

	<tr>
		<td colspan="4">도서 정보가 없습니다.</td>
	</tr>
		
	<%
		}	// if 문
	%>
	   </table>
   
   
   	<!-- 페이징처리 -->
	<div class = "pagingButton">
        <ul class="pagination" style="margin: 0;">
		<%
		for(int i=1 ; i <= totalPage; i++){
		%>
	    <li <% if(i==currentPage) {%> class="active" <% } else {}%>><a href="<%=request.getContextPath() %>/bookVideo/list.do?page=<%=i%>"><%=i %></a></li>
		<%		
			}
		%>
	  </ul>
	</div>
		
	   
	<div class = "writingButton">
	<%
	   if ("b1a4".equals(memId)) {
	%>
	   <div class = "actions">
	      <a href="<%=request.getContextPath() %>/bookVideo/insert.do"><span class="glyphicon glyphicon-pencil"></span>   글 등록</a>
	   </div>
	<%
	   }
	%>
	<% 
	   if (msg.equals("SUCCESS")) { 
	%>
	
	   <script>
	      alert('정상적으로 처리되었습니다.');
	   </script>
	
	<%
	   }
	%>
	</div>
</div>
</div>

<script>
	let active = "<%=request.getAttribute("active") %>"
</script>
    
<%request.setAttribute("active", "bookVideoList"); %>
<%@include file="/include/footer.jsp"%>

</body>
</html>