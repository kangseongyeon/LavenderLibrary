<%@page import="kr.or.ddit.comm.vo.AtchFileDetailVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="kr.or.ddit.contest.vo.BookReportVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	BookReportVO rv = (BookReportVO) request.getAttribute("rv");

AtchFileVO atchFileVO = (AtchFileVO) request.getAttribute("atchFileVO");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 수정</title>
<%@include file="/include/boardDetail.jsp"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> -->
<!--   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
</head>
<body>
	<%@include file="/include/header.jsp"%>
	<div style="margin-top: 20px;"></div>
	<div class="container">
		<div class="header">
			<h1>글쓰기 수정</h1>
		</div>
		<form action="<%=request.getContextPath()%>/report/update.do"
			method="post" enctype="multipart/form-data">
			<div class="content">
				<input type="hidden" name="rptNo" value="<%=rv.getRptNo()%>">
				<table>
					<tr>
						<th>도서명</th>
						<td><%=rv.getBookTitle()%></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="rptTitle"
							value="<%=rv.getRptTitle()%>"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="rptContent"><%=rv.getRptContent()%></textarea></td>
					</tr>
					<tr>
						<th>기존첨부파일</th>
						<td>
							<%
								if (atchFileVO != null) {
								for (AtchFileDetailVO detailVO : atchFileVO.getAtchFileDetailList()) {
							%>
							<div>
								<a
									href="<%=request.getContextPath()%>/download.do?atchFileId=<%=detailVO.getAtchFileId()%>&fileSn=<%=detailVO.getFileSn()%>"><%=detailVO.getOrignlFileNm()%></a>
							</div> <%
 	} //for
 } //if
 %>
						</td>
					</tr>
					<tr>
						<th>신규첨부파일</th>
						<td><input type="file" name="atchFile" multiple="multiple">
						</td>

					</tr>
				</table>
				<div class="buttons">
					<button type="submit">글쓰기 수정</button>
					<a href="<%=request.getContextPath()%>/report/list.do"
						class="button">목록보기</a>
				</div>
		</form>
	</div>
	</div>
	<%@include file="/include/footer.jsp"%>
</body>
</html>