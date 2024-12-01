<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>라벤더 도서관</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="../favicon.ico" type="image/x-icon">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>

.navbar {
    margin-bottom: 0;
    border-radius: 0;
    background-color: #9370DB;
    position: sticky;
    top: 0;
    z-index: 1000;
}

.navbar-inverse .navbar-brand {
    color: white;
    font-weight: bold;
    transition: all 0.3s ease;
}

.navbar-inverse .navbar-brand:hover, .navbar-inverse .navbar-brand:focus {
    transform: scale(1.05);
}

.navbar-inverse .navbar-brand, .navbar-inverse .navbar-nav>li>a {
    cursor: pointer;
}

.navbar-inverse .navbar-nav>li>a {
    color: white;
    transition: all 0.3s ease;
    padding: 15px 20px; 
}

.navbar-nav .dropdown-menu {
    background-color: #9370DB;
    display: none;
    margin-top: 0;
    width: 220px; 
    position: absolute;
    top: 100%;
    left: 0;
    z-index: 1000; 
}

.dropdown-menu>li>a {
    color: white;
    padding: 10px 15px; 
    display: block;
}

.navbar-nav>li:hover .dropdown-menu {
    display: block;
}

.navbar-nav .dropdown-menu {
    margin-top: 5px;
    padding: 10px 0;
}

.navbar-nav .dropdown-menu li {
    width: 100%; 
    text-align: left; 
}

</style>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand"
					href="<%=request.getContextPath()%>/main.do">라벤더 도서관</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">도서관소개 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a
								href="<%=request.getContextPath()%>/library/intro.do">인사말</a></li>
							<li><a
								href="<%=request.getContextPath()%>/library/info.do">도서관
									현황</a></li>
							<li><a
								href="<%=request.getContextPath()%>/library/find.do">찾아오시는길</a></li>
							<li><a href="<%=request.getContextPath()%>/library/use.do">이용안내</a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">도서정보 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<%=request.getContextPath()%>/book/list.do">전체도서</a></li>
							<li><a href="<%=request.getContextPath()%>/book/newList.do">신작도서</a></li>
							<li><a href="<%=request.getContextPath()%>/book/popularList.do">베스트</a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">도서관행사 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<%=request.getContextPath()%>/views/adminEvent/calender.jsp">도서관 달력</a></li>
							<li><a href="<%=request.getContextPath()%>/adminEvent/libraryList.do">도서관 행사</a></li>
							<li><a href="<%=request.getContextPath()%>/adminEvent/fieldStudyList.do">도서관 체험학습</a></li>
							<li><a href="<%=request.getContextPath()%>/adminEvent/movieList.do">영화 상영</a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">참여광장 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<%=request.getContextPath()%>/report/list.do">글쓰기</a></li>
							<li><a href="<%=request.getContextPath()%>/debate/list.do">토론</a></li>
							<li><a
								href="<%=request.getContextPath()%>/sentence/list.do">1일1문장
									쓰기</a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">커뮤니티 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<%=request.getContextPath()%>/notice/list.do">공지사항</a></li>
							<li><a
								href="<%=request.getContextPath()%>/inquiry/list.do">도서관에
									바란다</a></li>
							<li><a href="<%=request.getContextPath()%>/faq/list.do">FAQ</a></li>
							<li><a
								href="<%=request.getContextPath()%>/bookVideo/list.do">도서
									소개영상</a></li>
							<li><a href="<%=request.getContextPath()%>/news/list.do">도서관
									소식지</a></li>
						</ul></li>

				</ul>
				<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${empty sessionScope.loginCode}">
							<!-- 로그인하지 않은 경우 -->
							<li><a href="<%=request.getContextPath()%>/Login.do"><span
									class="glyphicon glyphicon-log-in"></span> Login</a></li>
						</c:when>
						<c:otherwise>
							<!-- 로그인한 경우 -->
							<c:choose>
								<c:when test="${sessionScope.loginCode eq 'b1a4'}">
									<!-- 관리자인 경우 -->
									<li><a
										href="<%=request.getContextPath()%>/admin/main.do"><span
											class="glyphicon glyphicon-user"></span> Admin Page</a></li>
								</c:when>
								<c:otherwise>
									<!-- 일반 사용자인 경우 -->
									<li><a
										href="<%=request.getContextPath()%>/member/main.do"><span
											class="glyphicon glyphicon-user"></span> My Page</a></li>
								</c:otherwise>
							</c:choose>
							<li><a href="<%=request.getContextPath()%>/Logout.do"><span
									class="glyphicon glyphicon-log-out"></span> Logout</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>

</body>
</html>