<%@page import="kr.or.ddit.vo.NewsVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%
  	List<NewsVO> newsList = (List<NewsVO>) request.getAttribute("newsList");
  
  	String msg = session.getAttribute("msg") == null ? ""
  			: (String) session.getAttribute("msg");
  	
  	session.removeAttribute("msg");
  	
  	 String memId = (String) session.getAttribute("memId");
  	 
 	//페이징
 	List<NewsVO> list = (List<NewsVO>) request.getAttribute("list");
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
	<title>도서 소식지 목록</title>
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<%@include file="/include/boardList.jsp" %>
</head>
<body>
<%@include file="/include/header.jsp"%>
    <div class="container">
    <%@include file="/include/boardSidebar.jsp"%>
    	<div class="content" style="position:relative; left: 200px;">
	<br><h1>도서 소식지</h1>
	
    <!-- 검색창 -->
   <div class = "searchButton">
    <form action="<%=request.getContextPath() %>/news/search.do" method="post" style="margin: 0;">
		<input type="text" name="searchKeyword" placeholder="제목 입력" maxlength="30" style="margin-right: 10px;" required>
        <button type="submit">검색</button>
    </form>
   </div>
   
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>첨부파일</th>
			<th>등록일</th>
			
		</tr>
<%
// 	int newsSize = newsList.size();
	int newsSize = list.size();
	if (newsSize > 0) {
// 		for (NewsVO nv : newsList) {
		for (NewsVO nv : list) {
%>
		<tr>
			<td><%=nv.getNewsNo() %></td>
			<td><a = href = " <%=request.getContextPath() %>/news/detail.do?newsNo=<%=nv.getNewsNo() %>"><%=nv.getNewsTitle() %></a></td>
			<td><%=nv.getAdmId()%></td>
			<td><% 
			if(nv.getAtchFileId()!=-1){
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
			<td><%=nv.getNewsDate() %></td>
		</tr>
<%
		}	// else 문
	} else {
%>

	<tr>
		<td colspan="4">도서 소개 영상 정보가 없습니다.</td>
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
	    <li <% if(i==currentPage) {%> class="active" <% } else {}%>><a href="<%=request.getContextPath() %>/news/list.do?page=<%=i%>"><%=i %></a></li>
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
	      <a href="<%=request.getContextPath() %>/news/insert.do"><span class="glyphicon glyphicon-pencil"></span>   글 등록</a>
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
    
    <%request.setAttribute("active", "newsList"); %>
<%@include file="/include/footer.jsp"%>

</body>
</html>