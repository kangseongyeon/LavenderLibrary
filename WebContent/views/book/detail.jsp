<%@page import="kr.or.ddit.book.vo.BookVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileDetailVO"%>
<%@page import="kr.or.ddit.comm.service.AtchFileServiceImpl"%>
<%@page import="kr.or.ddit.comm.service.IAtchFileService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	BookVO bv = (BookVO) request.getAttribute("bv");
int revCnt = Integer.parseInt(request.getAttribute("revCnt").toString());

IAtchFileService fileService = AtchFileServiceImpl.getInstance();
AtchFileVO fileVO = new AtchFileVO();
fileVO.setAtchFileId(bv.getAtchFileId());
AtchFileVO atchFileVO = fileService.getAtchFile(fileVO);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 상세 정보</title>
<style>
.book-container {
	display: flex;
	margin-top: 20px;
	align-items: flex-start;
}

.book-image {
	width: 300px;
	margin-right: 30px;
}

.book-info {
	flex: 1;
	padding-left: 50px;
}
</style>
</head>
<body>
	<%@include file="/include/header.jsp"%>
	<div class="content">
		<div class="jumbotron">
			<div class="container">
				<h1 class="display-3">도서 정보</h1>
			</div>
		</div>

		<div class="container">
			<div class="book-container">
				<div class="book-image">
					<%
						if (atchFileVO != null && !atchFileVO.getAtchFileDetailList().isEmpty()) {
						AtchFileDetailVO fileDetail = atchFileVO.getAtchFileDetailList().get(0);
					%>
					<img alt="표지"
						src="/image/<%=fileDetail.getStreFileNm() + "." + fileDetail.getFileExtsn()%>"
						class="book-image" style="width: 100%;">
					<%
						} else {
					%>
					<img src="<%=request.getContextPath()%>/images/no-image.jpg"
						alt="이미지 없음" style="width: 100%;">
					<%
						}
					%>
				</div>
				<div class="book-info">
					<h3><%=bv.getBookName()%></h3>
					<p>
						<b>도서 코드 : </b><span class="badge badge-danger"><%=bv.getBookId()%></span>
					</p>
					<p>
						<b>저자</b> :
						<%=bv.getBookWriter()%></p>
					<p>
						<b>출판사</b> :
						<%=bv.getBookPublisher()%></p>
					<p>
						<b>대여가능 여부</b> :
						<%=bv.getBookRentalYN()%></p>
					<p>
						<b>등록일</b> :
						<%=bv.getRegdt()%></p>
					<p>
						<b>조회수</b> :
						<%=bv.getViewCnt()%></p>
					<%
						String memId = (String) request.getSession().getAttribute("loginCode");
					if (memId != null && !memId.equals("b1a4")) {
					%>
					<p>
						<a
							href="<%=request.getContextPath()%>/wishlist/insert.do?bookId=<%=bv.getBookId()%>"
							class="btn btn-info"> 찜하기 &raquo;</a>
					</p>
					<%
						} else {
					%>
					<p>
						<a href="<%=request.getContextPath()%>/Login.do"
							class="btn btn-info"> 찜하기 &raquo;</a>
					</p>
					<%
						}
					%>
					<a href="<%=request.getContextPath()%>/book/list.do"
						class="btn btn-secondary">도서 목록 &raquo;</a>

					<%
						if (bv.getBookRentalYN().equals("N")) {
					%>
					<p>
						<b>대기인원수</b> :
						<%=revCnt%>
						<a
							href="<%=request.getContextPath()%>/reserv/insert.do?bookId=<%=bv.getBookId()%>"
							class="btn btn-secondary">도서 예약 &raquo;</a>
					</p>
					<%
						}
					%>

					<%
						if (memId != null && memId.equals("b1a4")) {
					%>
					<a
						href="<%=request.getContextPath()%>/book/update.do?bookId=<%=bv.getBookId()%>">[도서정보
						수정]</a> <a
						href="<%=request.getContextPath()%>/book/delete.do?bookId=<%=bv.getBookId()%>">[도서정보
						삭제]</a>
					<%
						}
					%>
				</div>
			</div>
		</div>
	</div>

	<%@include file="/include/footer.jsp"%>
</body>
</html>