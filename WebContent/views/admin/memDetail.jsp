<%@page import="kr.or.ddit.book.vo.RentalVO"%>
<%@page import="kr.or.ddit.book.vo.ReservVO"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	MemberVO mv = (MemberVO) request.getAttribute("mv");
List<ReservVO> revList = (List<ReservVO>) request.getAttribute("revList");
List<RentalVO> rentalList = (List<RentalVO>) request.getAttribute("rentalList");
String msg = session.getAttribute("msg") == null ? "" : (String) session.getAttribute("msg");
session.removeAttribute("msg"); // 한번 사용한 데이터 삭제
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 관리</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%-- <%@ include file="/include/boardList.jsp" %> --%>
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

h1 {

/* 	position: relative;
    left: 100px;
    width: 400px; */

}
h3 {

	position: relative;
    left: 20px;

}

table {
	border: 3px solid #c4bee2;
	
	width: 100%;
	table-layout: pixed;
	margin: auto;
}

th {
	background-color: #e0dbef;
	text-align: center !important;
}

td {
	text-align: center;
}
/* .actions {
	text-align: center;
} */

.attions {
 margin-left: 100px;
 }
.actions button {
  	margin-left: 10px;
/*  	margin-left: 10px 10px 10px 10px; */
	padding: 10px 15px;
	text-decoration: none;
	background-color: #9986b3;
	color: white;
	border-radius: 5px;
	font-size: 14px;
	border: 3px;
	
}
#mem {
	position: relative;
	right : 10px
/*     left: 1300px; */
   


    
}

</style>
</head>
<body>
	<%@include file="/include/header.jsp"%>
	<br>
<%-- 	<h1><%=mv.getMemId()%>님의 회원정보 --%>
	<h1 align="center" ><%=mv.getMemId()%>님의 회원정보</h1>
	<div>
<!-- 	<table border="1" style="font-size: 15px;"> -->
	<table border="1"  style="width:90%">
<%-- 	 <caption><%=mv.getMemId()%>님의 회원정보</caption> --%>
		<tr>
			<th>회원ID</th>
			<th>회원이름</th>
			<th>회원 전화번호</th>
			<th>회원 이메일</th>
			<th>회원 주소</th>
			<th>상세주소</th>
			<th>블랙리스트 유뮤</th>
			<th>경고 횟수</th>
			<th>광고수신 유무</th>
			<th>우편번호</th>
			<th>회원 생일</th>
		</tr>
		<tr>
			<td><%=mv.getMemId()%></td>
			<td><%=mv.getMemName()%></td>
			<td><%=mv.getMemTel()%></td>
			<td><%=mv.getMemEmail()%></td>
			<td><%=mv.getMemAddr1()%></td>
			<td><%=mv.getMemAddr2()%></td>
			<td><%=mv.getBanYn()%></td>
			<td><%=mv.getWarnCnt()%></td>
			<td><%=mv.getAdYn()%></td>
			<td><%=mv.getMemPostno()%></td>
			<td><%=mv.getMemBir()%></td>
		</tr>
	</table>
	</div>
	<br>
	<br>
	<br>

	<div class="content-wrapper">
		<!-- Main Content -->
		<main class="main-content">
			<table class="table table-hover" style="width:90%">
<%-- 	 <caption><%=mv.getMemId()%>님의 예약목록</caption> --%>
<%-- 	 <caption><strong><%=mv.getMemId()%>님의 예약목록</strong></caption> --%>
	 
				<thead>
					<tr>
						<th>예약번호</th>
						<th>도서ID</th>
						<th>도서제목</th>
						<th>회원ID</th>
						<th>예약날짜</th>
						<th>대기순위</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
 					<h3 align="center" ><%=mv.getMemId()%>님의 예약목록</h3>
					<%
						int revsize = revList.size();
					if (revsize > 0) {
						for (ReservVO rv : revList) {
					%>
					<tr>
						<td><%=rv.getRevNo()%></td>
						<td><%=rv.getBookId()%></td>
						<td><%=rv.getBookName()%></td>
						<td><%=rv.getMemId()%></td>
						<td><%=rv.getRevDate()%></td>
						<td><%=rv.getWaitCount()%></td>
					</tr>
					<%
						} //for문
					} else {
					%>
					<tr>
						<td colspan="6">예약정보가 없습니다.</td>
					</tr>
					<%
						} //if문
					%>

				</tbody>


			</table>


		</main>
		<main class="main-content">
			<table class="table table-hover" style="width:90%">
<%-- 	 <caption><%=mv.getMemId()%>님의 대여목록</caption> --%>
				<thead>
					<tr>
						<th>대여번호</th>
						<th>도서ID</th>
						<th>도서제목</th>
						<th>회원ID</th>
						<th>대여날짜</th>
						<th>반납예정일</th>
						<th>반납유무</th>
					</tr>
				</thead>
				<tbody>
 					<h3 align="center" ><%=mv.getMemId()%>님의 대여목록</h3>
					<%
						int rentalsize = rentalList.size();
					if (rentalsize > 0) {
						for (RentalVO rv : rentalList) {
					%>
					<tr>
						<td><%=rv.getRentalNo()%></td>
						<td><%=rv.getBookId()%></td>
						<td><%=rv.getBookName()%></td>
						<td><%=rv.getMemId()%></td>
						<td><%=rv.getRentalDate()%></td>
						<td><%=rv.getReturnDate()%></td>
						<td><%=rv.getReturnYn()%></td>

					</tr>
					<%
						} //for문
					} else {
					%>
					<tr>
						<td colspan="7">대여정보가 없습니다.</td>
					</tr>
					<%
						} //if문
					%>

				</tbody>
			</table>


		</main>
	</div>

	<form action="<%=request.getContextPath()%>/member/detail.do"
		method="post">
		<input type="hidden" name="memId" value="<%=mv.getMemId()%>">
		<input type="hidden" name="action" value="">
		
		
		<div class = "actions">
			<button type="submit"
				onclick="document.querySelector('input[name=action]').value='blacklist';">
				블랙리스트 추가</button>
	
			<button type="submit"
				onclick="document.querySelector('input[name=action]').value='warnIncrease';">
				경고 1 증가</button>
	
			<button type="submit"
				onclick="document.querySelector('input[name=action]').value='warnDecrease';">
				경고 1 감소</button>
			<button id="mem" type="button"  style="float: right;" onClick="location.href='/LavenderLibrary/member/list.do'">회원목록</button>
		</div>
		
<br>
		
	</form>
	



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



	<%@include file="/include/footer.jsp"%>



</body>
</html>