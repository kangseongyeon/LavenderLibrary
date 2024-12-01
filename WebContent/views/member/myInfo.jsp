<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 도서관</title>
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
	color: blue;
	background-image: url('./CK_cb2140002356.jpg');
	background: linear-gradient(rgba(255, 255, 255, 0.5),
		rgba(255, 255, 255, 0.3)),
		url('<%=request.getContextPath()%>/images/CK_cb2140002356.jpg');
	display: flex;
	flex-direction: column;
	background-size: cover;
	background-repeat: no-repeat;
	background-position: center;
	height: 100vh;
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

img {
	position: relative;
	top: 25%;
	left: 50%;
	transform: translate(-50%, -50%);
}

h3 {
	font-size: 2em;
	text-align: center;
}

#main {
	top: 500%;
	font-size: 3em;
	text-align: center;
}

#list {
	margin: 0 auto;
	top: 30px;
	/*   left: 810px; */
	/*   position: relative; */
	/*     border: 1px; */
	padding: 40px;
	background-color: white;
	border-radius: 20px;
	/* width: 80%; */
	text-align: center;
	height: 300px;
	width: 300px;
}

a {
	font-size: 1.4em;
	text-align: center;
}
</style>
</head>
<body>
	<%@include file="/include/header.jsp"%>

	<div class="content">
		<img class="mb-4" src="<%=request.getContextPath()%>/images/도서01.png"
			alt="" width="280" height="300">
		<h3 style='color: #337ab7'>" "</h3>
		<p style='color: #337ab7'>" "</p>
		<div id="main" style='color: #337ab7'>My Library</div>

		<div id="list">
			<a href="<%=request.getContextPath()%>/member/update.do">개인정보수정</a>
			<br>
			<hr>
			<a href="<%=request.getContextPath()%>/rental/memRental.do">나의
				대여현황</a><br>
			<hr>
			<a href="<%=request.getContextPath()%>/reserv/memReserv.do">나의
				예약현황</a><br>
			<hr>
			<a href="<%=request.getContextPath()%>/wishlist/memWishlist.do">찜목록</a><br>

		</div>
	</div>



	<%@include file="/include/footer.jsp"%>

</body>
</html>