<%@page import="kr.or.ddit.vo.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    NoticeVO nv = (NoticeVO) request.getAttribute("nv");
    String memId = (String) session.getAttribute("memId");
    String contentEnter = nv.getNoticeContent().replaceAll("\n", "<br>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 정보 상세</title>
<%@include file="/include/boardDetail.jsp"%>
</head>
<body>
<%@include file="/include/header.jsp"%>
<div style="margin-top: 20px;"></div>
<div class="container">
    <%@include file="/include/boardSidebar.jsp"%>
        
    <div class="header">
        <h1><%=nv.getNoticeTitle() %></h1>
        <span><%=nv.getNoticeDate() %></span>
    </div>
    <div class="details">
        <div><span style="font-weight: bold;">작성자:</span> <span><%=nv.getAdmId() %></span></div>
    </div>
    <div class="content">
        <%=contentEnter %>
    </div>
    <div class="actions">
        <a href="<%=request.getContextPath()%>/notice/list.do">[목록보기]</a>
        <%
            if ("b1a4".equals(memId)) {
        %>
        <a href="<%=request.getContextPath()%>/notice/update.do?noticeNo=<%=nv.getNoticeNo() %>">[공지 수정]</a>
        <a href="<%=request.getContextPath()%>/notice/delete.do?noticeNo=<%=nv.getNoticeNo() %>">[공지 삭제]</a>
        <%
            }
        %>
    </div>
</div>
<%@include file="/include/footer.jsp"%>
</body>
</html>
 