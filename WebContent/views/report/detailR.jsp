<%@page import="kr.or.ddit.comm.vo.AtchFileDetailVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="kr.or.ddit.contest.vo.BookReportVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    BookReportVO rv = (BookReportVO) request.getAttribute("rv");
    AtchFileVO atchFileVO = (AtchFileVO) request.getAttribute("atchFileVO");
    String memId = session.getAttribute("memId") == null ? "" : (String) session.getAttribute("memId");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 정보 상세</title>
<%@include file="/include/boardDetail.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<%@include file="/include/header.jsp"%>
<div style="margin-top: 20px;"></div>
<div class="container">
	<%@include file="/include/contestSidebar.jsp"%>
    <div class="header">
        <h1><%= rv.getRptTitle() %></h1>
        <span><%= rv.getRptDate() %></span>
    </div>
    <div class="details">
    <div>
    	<dl>
        <dt>첨부파일:</dt>
        <dd>
            <%
                if(atchFileVO != null){
                    for(AtchFileDetailVO detailVO : atchFileVO.getAtchFileDetailList()){   
            %>
                    <span>
                        <a href="<%= request.getContextPath() %>/download.do?atchFileId=<%= detailVO.getAtchFileId() %>&fileSn=<%= detailVO.getFileSn() %>"><%= detailVO.getOrignlFileNm() %></a>
                    </span>
            <%
                    } // for
                } // if
            %>
        </dd>
        </dl>
        </div>
    	<div><span style class="bold-color">도서명:</span> <span><%= rv.getBookTitle() %></span></div>
    	<div><span style class="bold-color">작성자:</span> <span><%= rv.getMemId() %></span></div>
    	<br>
        <div class="content"><%= rv.getRptContent().replaceAll("\n", "<br>") %></div>
  	</div>
    <div class="actions">
        <a href="<%= request.getContextPath() %>/report/list.do">[글쓰기 목록]</a>
        <%
            if(rv.getMemId().equals(memId) || memId.equals("b1a4")){
        %>
        <a href="<%= request.getContextPath() %>/report/update.do?rptNo=<%= rv.getRptNo() %>">[글쓰기 수정]</a>
        <a href="<%= request.getContextPath() %>/report/delete.do?rptNo=<%= rv.getRptNo() %>">[글쓰기 삭제]</a>
        <%
            }            
        %>
    </div>
</div>

     <script>
    
     let active = "<%=request.getAttribute("active") %>"
    
    </script>
    
    <%request.setAttribute("active", "listR"); %>
<%@include file="/include/footer.jsp"%>
</body>
</html>
