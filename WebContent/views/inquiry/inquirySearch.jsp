<%@page import="kr.or.ddit.vo.InquiryVO"%>
<%@page import="kr.or.ddit.vo.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<InquiryVO> inquiryList = (List<InquiryVO>) request.getAttribute("inquiryList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관에 바란다 검색 목록</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<%@include file="/include/boardList.jsp"%>
</head>
<body>
    <%@include file="/include/header.jsp"%>
		<div class="container">
    		<%@include file="/include/boardSidebar.jsp"%>
    		<div class="content" style="position:relative; left: 200px;">
	<br><h1>검색창</h1><br><br>
   <div style="margin-top: 20px;"></div>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>분류코드</th>
			<th>작성자ID</th>
			<th>등록일</th>
			<th>상태</th>
		</tr>
<%
	int inquirySize = inquiryList.size();
    if(inquirySize > 0){
    	for(InquiryVO iv : inquiryList){
    	        String inqStatus = iv.getInqStatus().equals("진행완료") ? "status-complete" : "status-pending";

%>
	<tr>
		 <td><%=iv.getInqNo() %></td>
         <td><a href="<%=request.getContextPath() %>/inquiry/detail.do?inqNo=<%=iv.getInqNo() %>"><%=iv.getInqTitle() %></a></td>
         <td><%=iv.getInqCategoryCode() %></td>
         <td><%=iv.getMemId() %></td>
         <td><%=iv.getInqDate() %></td>
         <td class="<%= inqStatus %>"><%=iv.getInqStatus() %></td>
	
	</tr>
<%
		} //for문
	} else {
%>
	<tr>
    	<td colspan="6">정보가 없습니다.</td>
	</tr>
	
<%
	}	// if 문
%>
  </table>
	
	<div class = "searchButton">
		<div class="actions">
			<a href="<%=request.getContextPath() %>/inquiry/list.do"><span class="glyphicon glyphicon-th-list"></span>전체 목록</a>
	</div>
</div>
</div>		
</div>
<%@include file="/include/footer.jsp"%>

</body>
</html>

