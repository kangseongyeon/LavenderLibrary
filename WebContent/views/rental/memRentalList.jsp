<%@page import="kr.or.ddit.book.vo.RentalVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<RentalVO> rentalList = (List<RentalVO>) request.getAttribute("rentalList");
String msg = session.getAttribute("msg") == null ? "" : (String) session.getAttribute("msg");
session.removeAttribute("msg"); // 한번 사용한 데이터 삭제
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대여 목록</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> -->
<!--   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
<style>
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

body {
	display: flex;
	flex-direction: column;
}

.content-wrapper {
	flex: 1 0 auto;
	display: flex;
}

.main-content {
	flex: 1;
	padding: 20px;
}

.book-image {
	width: 100px;
	height: 150px;
	object-fit: cover;
}
</style>
</head>
<body>
	<!-- Header -->
	<%@include file="/include/header.jsp"%>


	<div class="content-wrapper">
		<!-- Main Content -->
		<main class="main-content">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>대여번호</th>
						<th>도서ID</th>
						<th>도서제목</th>
						<th>대여날짜</th>
						<th>반납예정일</th>
						<th>반납유무</th>
					</tr>
				</thead>
				<tbody>
					<%
						int rentalsize = rentalList.size();
					if (rentalsize > 0) {
						for (RentalVO rv : rentalList) {
					%>
					<tr>
						<td><%=rv.getRentalNo()%></td>
						<td><%=rv.getBookId()%></td>
						<td><%=rv.getBookName()%></td>
						<td><%=rv.getRentalDate()%></td>
						<td><%=rv.getReturnDate()%></td>
						<td><%=rv.getReturnYn()%></td>
					</tr>
					<%
						} //for문
					} else {
					%>
					<tr>
						<td colspan="5">대여정보가 없습니다.</td>
					</tr>
					<%
						} //if문
					%>

				</tbody>
			</table>


		</main>
	</div>

	<!-- Footer -->
	<%@include file="/include/footer.jsp"%>

	<script>
		function adjustFooter() {
			var docHeight = document.documentElement.offsetHeight;
			var windowHeight = window.innerHeight;
			var footer = document.querySelector('footer');

			if (docHeight <= windowHeight) {
				footer.style.position = 'fixed';
				footer.style.bottom = '0';
				footer.style.width = '100%';
			} else {
				footer.style.position = 'static';
			}
		}

		window.addEventListener('load', adjustFooter);
		window.addEventListener('resize', adjustFooter);
	</script>
</body>
</html>