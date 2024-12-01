<%@page import="kr.or.ddit.comm.vo.AtchFileDetailVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="kr.or.ddit.vo.NewsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	NewsVO nv = (NewsVO) request.getAttribute("nv");
AtchFileVO atchFileVO = (AtchFileVO) request.getAttribute("atchFileVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 소식지 변경</title>
<%@include file="/include/boardDetail.jsp"%>
</head>
<body>
	<%@include file="/include/header.jsp"%>
	<div style="margin-top: 20px;"></div>
	<div class="container">
		<div class="header">
			<h1>소식지 수정</h1>
		</div>
		<form action="<%=request.getContextPath()%>/news/update.do"
			method="post" enctype="multipart/form-data">
			<div class="content">
				<div style="margin-top: 20px;"></div>
				<input type="hidden" name="newsNo" value="<%=nv.getNewsNo()%>">
				<input type="hidden" name="atchFileId"
					value="<%=nv.getAtchFileId()%>">

				<table>
					<tr>
						<th>번호</th>
						<td><%=nv.getNewsNo()%></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="newsTitle"
							value="<%=nv.getNewsTitle()%>"></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><%=nv.getAdmId()%></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="newsContent"><%=nv.getNewsContent()%></textarea></td>
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
 	} // for
 } // if
 %>
						</td>
					</tr>

					<tr>
						<th>신규첨부파일</th>
						<td><input type="file" name="atchFile" multiple="multiple"></td>
					</tr>
				</table>
				<div class="buttons">
					<button type="submit">저장하기</button>
					<a href="<%=request.getContextPath()%>/news/list.do" class="button">목록보기</a>
				</div>
		</form>
	</div>
	</div>
	<%@include file="/include/footer.jsp"%>
</body>
</html>