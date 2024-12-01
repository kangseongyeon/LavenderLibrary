<%@page import="kr.or.ddit.vo.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    List<NoticeVO> noticeList = (List<NoticeVO>)request.getAttribute("noticeList");
    String msg = session.getAttribute("msg")==null?"":(String) session.getAttribute("msg");
    session.removeAttribute("msg"); // 한번 사용한 데이터 삭제
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
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
			<th>공지번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
		</tr>
<%
	int noticeSize = noticeList.size();
    if(noticeSize > 0){
    	for(NoticeVO nv : noticeList){
%>
	<tr>
    	<td><%=nv.getNoticeNo() %></td>
        <td><a href="<%=request.getContextPath() %>/notice/detail.do?noticeNo=<%=nv.getNoticeNo()%>"><%=nv.getNoticeTitle()%></a></td>
        <td><%=nv.getAdmId() %></td>
        <td><%=nv.getNoticeDate() %></td>
	</tr>
<%
		} //for문
	} else {
%>
	<tr>
    	<td colspan="4">공지가 없습니다.</td>
	</tr>
	
<%
	}	// if 문
%>
  </table>
<% 
	if (msg.equals("SUCCESS")) { 
%>

	<script>
		alert('정상적으로 처리되었습니다.');
	</script>

<%
	}
%>
	<div class = "searchButton">
		<div class="actions">
			<a href="<%=request.getContextPath() %>/notice/list.do"><span class="glyphicon glyphicon-th-list"></span>전체 목록</a>
		</div>
	</div>
</div>
</div>		
<%@include file="/include/footer.jsp"%>

</body>
</html>

