<%@page import="kr.or.ddit.comm.vo.AtchFileDetailVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="kr.or.ddit.vo.NewsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	NewsVO nv = (NewsVO)request.getAttribute("nv");
	String memId = (String) session.getAttribute("memId");
	AtchFileVO atchFileVO = (AtchFileVO) request.getAttribute("atchFileVO");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 소식지 상세</title>
<%@include file="/include/boardDetail.jsp"%>
</head>
<body>
<%@include file="/include/header.jsp"%>
<div style="margin-top: 20px;"></div>
<div class="container">
	<%@include file="/include/boardSidebar.jsp"%>
    <div class="header">
        <h1><%=nv.getNewsTitle() %></h1>
        <span><%=nv.getNewsDate() %></span>
    </div>
	<div class="details">
	<div>
		<dl>
		<dt>첨부파일:</dt>
        	<dd>
        	<%
				if(atchFileVO != null){
					for(AtchFileDetailVO detailVO :atchFileVO.getAtchFileDetailList()){   
			%>
					<span>
						<a href="<%=request.getContextPath() %>/download.do?atchFileId=<%=detailVO.getAtchFileId()%>&fileSn=<%=detailVO.getFileSn() %>"><%=detailVO.getOrignlFileNm() %></a>
					</span>
			
			<%
					} //for
				} //if
			%>	
            </dd>
        	</dl>
		</div>
        <div><span style class="bold-color">작성자:</span> <span><%= nv.getAdmId() %></span></div>

    </div>
    <div class="content">
        <%=nv.getNewsContent() %>
    </div>
		
		<div class="actions">
       		<a href="<%=request.getContextPath()%>/news/list.do">[목록보기]</a>
        <%
        	if ("b1a4".equals(memId)) {
        %>
			<a href="<%=request.getContextPath()%>/news/update.do?newsNo=<%=nv.getNewsNo() %>">[도서 소식지 수정]</a>
			<a href="<%=request.getContextPath()%>/news/delete.do?newsNo=<%=nv.getNewsNo() %>">[도서 소식지 삭제]</a>
        <%
        	}
        %>
    	</div>
    </div>
<%@include file="/include/footer.jsp"%>
</body>
</html>