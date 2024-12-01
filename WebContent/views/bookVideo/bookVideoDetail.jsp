<%@ page import="kr.or.ddit.vo.BookVideoVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    BookVideoVO bv = (BookVideoVO) request.getAttribute("bv");
    String memId = (String) session.getAttribute("memId");

    String contentUrl = "";
    if (bv != null && bv.getBookVideoContent() != null) {
        String content = bv.getBookVideoContent();
        String urlPattern = "(https?://[\\w-]+(\\.[\\w-]+)+(/[^\\s]*)?)";
        contentUrl = content.replaceAll(urlPattern, "<a href=\"$1\" target=\"_blank\">$1</a>");
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 소개 영상 상세</title>
<%@include file="/include/boardDetail.jsp" %>
</head>
<body>
<%@include file="/include/header.jsp" %>
<div style="margin-top: 20px;"></div>
<div class="container">
    <%@include file="/include/boardSidebar.jsp" %>
    <div class="header">
        <h1><%= bv.getBookVideoTitle() %></h1>
        <span><%= bv.getBookVideoDate() %></span>
    </div>
    <div class="details">
        <div><span style="font-weight: bold;">작성자:</span> <span><%= bv.getAdmId() %></span></div>
    </div>
    <div class="content">
        <%= contentUrl %>
    </div>
    <div class="actions">
        <a href="<%= request.getContextPath() %>/bookVideo/list.do">[목록보기]</a>
        <%
            if ("b1a4".equals(memId)) {
        %>
        <a href="<%= request.getContextPath() %>/bookVideo/update.do?bookVideoNo=<%= bv.getBookVideoNo() %>">[도서 소개 수정]</a>
        <a href="<%= request.getContextPath() %>/bookVideo/delete.do?bookVideoNo=<%= bv.getBookVideoNo() %>">[도서 소개 삭제]</a>
        <%
            }
        %>
    </div>
</div>
<%@include file="/include/footer.jsp" %>
</body>
</html>
