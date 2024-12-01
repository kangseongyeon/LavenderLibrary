<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>이용안내</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
}

/* 메인 콘텐츠 스타일 */
main {
	max-width: 800px;
	/*   margin: 0 auto; */
	/*   margin: 0 ; */
	padding: 20px;
}

h1, h2 {
	color: #333;
}

b {
	color: #9986b3;
}

ul, ol {
	list-style-type: none;
	padding: 0;
}

li {
	margin-bottom: 10px;
}

section h2 {
	margin-bottom: 12px;
	color: #B57EDC;
	margin-top: 0px;
}

section li {
	margin-left: 30px;
}

section p {
	margin-left: 30px;
}
section ul {
	margin-bottom: 30px;
}
section ol {
	margin-bottom: 30px;
}
</style>
</head>
<body>
	<%@include file="/include/header.jsp"%>
	<div class="container">

		<%@include file="/include/libSidebar.jsp"%>

		<div class="content" style="position: relative; left: 200px;">

			<main>
				<br>
				<h1>
					<b>이용안내</b>
				</h1>
				<br>

				<section>
					<h2>
						<img src="<%=request.getContextPath()%>/images/라벤더.png" alt="라벤더"> 대출회원(정회원) 가입 안내
					</h2>
					<ul>
						<li>가입대상 (근거: 대전광역시 라벤더도서관 조례 시행규칙 제3조)</li>
						<li>대전광역시에 주민등록이 되어 있는 사람</li>
						<li>대전광역시 소재 직장 또는 학교에 재직하거나 재학 중인 사람</li>
						<li>대전광역시에 거주하는 외국인</li>
					</ul>
				</section>

				<br>
				<section>
					<h2>
						<img src="<%=request.getContextPath()%>/images/라벤더.png" alt="라벤더"> 가입에 필요한 서류
					</h2>
					<ul>
						<li>본인 방문시: 신분증</li>
						<li>신분증에 대전광역시 내 주소가 기재되어 있지 않은 경우 3개월이내 발급된 주민등록등본 1부</li>
						<li>대전광역시 소재 학교나 직장에 재학 or 재직 중인 경우: 재직증명서 or 재학증명서 1부</li>
						<li>14세 미만 이용자 가입시: 부모님 신분증, 3개월 이내 발급된 주민등록등본 1부</li>
						<li>14세 미만 이용자의 회원가입 시 부모님이 직접 방문하셔야 합니다.</li>
						<li>대리인(주민등록상 동거인(신분)에 한함) 방문시: 대리인(신분) 신분증, 회원가입 대상자 신분증,
							3개월이내 발급된 주민등록등본 1부</li>
					</ul>
				</section>

				<br>
				<section>
					<h2>
						<img src="<%=request.getContextPath()%>/images/라벤더.png" alt="라벤더"> 가입절차
					</h2>
					<ol>
						<li>대전 공공도서관 통합홈페이지<a href="https://www.u-library.kr/">(https://www.u-library.kr/)</a>에서
							회원가입
						</li>
						<li>가입에 필요한 서류(신분증 등)를 지참하고 대전지역 공공도서관 방문 후 회원등록 및 카드발급</li>
					</ol>
				</section>

				<br>
				<section>
					<h2>
						<img src="<%=request.getContextPath()%>/images/라벤더.png" alt="라벤더"> 이용방법
					</h2>
					<p>도서관대출반납 정책 등 이용방법은 각 도서관별 운영 정책에 따르므로 이용하실 해당 도서관의 홈페이지를
						참조하시기 바랍니다.</p>
				</section>
			</main>
		</div>
		<div style="height: 100px;"></div>
	</div>
	<script>
    
     let active = "<%=request.getAttribute("active")%>
		
	</script>

	<%
		request.setAttribute("active", "use");
	%>
	<%@include file="/include/footer.jsp"%>
</body>
</html>