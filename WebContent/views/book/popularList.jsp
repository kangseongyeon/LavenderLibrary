<%@page import="kr.or.ddit.comm.service.AtchFileServiceImpl"%>
<%@page import="kr.or.ddit.comm.service.IAtchFileService"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileDetailVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.book.vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	List<BookVO> bookList = (List<BookVO>) request.getAttribute("bookList");
IAtchFileService fileService = AtchFileServiceImpl.getInstance();
String msg = session.getAttribute("msg") == null ? "" : (String) session.getAttribute("msg");
session.removeAttribute("msg"); // 한번 사용한 데이터 삭제
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인기도서 목록</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> -->
<!--   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
<%@ include file="/include/eventList.jsp" %>
</head>
<body>
	<!-- Header -->
	<%@include file="/include/header.jsp"%>
	<div class="container">
     <%@include file="/include/bookSidebar.jsp"%> 
     
       <div class="content" style="position:relative; left: 200px;">
     	<br><h1>베스트 리스트</h1>

	<div class = "searchButton">
		<form action="<%=request.getContextPath()%>/book/search.do" method="post" style="margin: 0;">
			<select name="searchOption" style ="height:25px; margin-right: 13px; padding: 2px;">
				<option value="bookAll">제목+저자</option>
				<option value="bookName">제목</option>
			</select> <input type="text" name="searchKeyword" placeholder="검색어 입력"
				maxlength="30" style="margin-right: 10px;" required>
			<button type="submit">검색</button>
		</form>
	</div>
	
	
	<div class="content-wrapper">
		<!-- Main Content -->
		<main class="main-content">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>도서표지</th>
						<th>도서ID</th>
						<th>도서제목</th>
						<th>저자</th>
					</tr>
				</thead>
				<tbody>
					<%
						if (bookList != null && !bookList.isEmpty()) {
						for (BookVO bv : bookList) {
							AtchFileVO fileVO = new AtchFileVO();
							fileVO.setAtchFileId(bv.getAtchFileId());
							AtchFileVO atchFileVO = fileService.getAtchFile(fileVO);
					%>
					<tr>
						<td>
							<%
								if (atchFileVO != null && !atchFileVO.getAtchFileDetailList().isEmpty()) {
								AtchFileDetailVO fileDetail = atchFileVO.getAtchFileDetailList().get(0);
								System.out.println(fileDetail.getFileStreCours()+"."+fileDetail.getFileExtsn());
							%> 
<%-- 							<img src="<%=request.getContextPath()%>/image?atchFileId=<%=fileDetail.getAtchFileId()%>&fileSn=<%=fileDetail.getFileSn()%>" alt="도서 표지" class="book-image">  --%>
								<img alt="표지" src="/image/<%=fileDetail.getStreFileNm()+"."+fileDetail.getFileExtsn()%>" class="book-image">
<!-- 								<img alt="표지" src="‪/img/4b46cb3669c846ac9b4a0e998132342b.jpg" class="book-image"> -->
								
							<%
							
 	} else {
 %> <img src="<%=request.getContextPath()%>/images/no-image.jpg" alt="이미지 없음" class="book-image"> <%
 	}
 %>
						</td>
						<td><%=bv.getBookId()%></td>
						<td><a href="<%=request.getContextPath()%>/book/detail.do?bookId=<%=bv.getBookId()%>"><%=bv.getBookName()%></a></td>
						<td><%=bv.getBookWriter()%></td>
					</tr>
					<%
						} // for문 끝
					} else {
					%>
					<tr>
						<td colspan="4">도서정보가 없습니다.</td>
					</tr>
					<%
						} // if-else문 끝
					%>
						</tbody>
					</table>

					<div class = "writingButton">
						<c:set var="loginCode" value="${sessionScope.loginCode}" />
						<c:if test="${loginCode == 'b1a4'}">
							<%-- <tr align="right">
								<td colspan="4"><a href="<%=request.getContextPath()%>/book/insert.do">[도서등록]</a></td>
							</tr> --%>
							
							<div class="actions" style="margin-right: 50px;">
								    <a href="<%=request.getContextPath() %>/book/insert.do"><span class="glyphicon glyphicon-book"></span>도서등록</a>
							</div>
						</c:if>
					</div>
			<%
				if (msg.equals("SUCCESS")) {
			%>
			<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
			<script>
				swal("성공!", "정상적으로 처리 되었습니다.", "success");
			</script>
			<%
				}
			%>
		</main>
	</div>
  </div>
</div>

    <script>
    
     let active = "<%=request.getAttribute("active") %>"
    
    </script>
    
    <%request.setAttribute("active", "popularList"); %>
	<!-- Footer -->
<%@include file="/include/footer.jsp"%>
 

</body>
</html>