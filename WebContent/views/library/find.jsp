<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>길 안내</title>
<style>
@import
	url("https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800,900&display=swap")
	;

.w-btn {
	position: relative;
	border: none;
	display: inline-block;
	padding: 15px 30px;
	border-radius: 15px;
	font-family: "paybooc-Light", sans-serif;
	text-decoration: none;
	font-weight: 600;
	transition: 0.25s;
}

.w-btn-indigo {
	background-color: #f5f3f8;
	color: #8e76b0;
}

.w-btn-indigo-outline {
	border: 3px solid #eae8f2;
	color: #9986b3;
}

.w-btn-indigo-outline:hover {
	color: #9986b3;
	background: #e0dbef;
}

.w-btn:hover {
	letter-spacing: 2px;
	transform: scale(1.2);
	cursor: pointer;
}

.w-btn-outline:hover {
	letter-spacing: 2px;
	transform: scale(1.2);
	cursor: pointer;
}

.w-btn:active {
	transform: scale(1.5);
}

.w-btn-outline:active {
	transform: scale(1.5);
}

#bobo {
	display: flex;
	justify-content: center;
	align-items: flex-start;
	flex-direction: column;
	height: 80vh;
	margin-top: 150px; 
	margin-bottom: 150px;
	margin-right: 400px;
}

.board {
	border: 2px solid #ccc;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	background-color: #e8e6f0;
	width: 800px;
	margin-right: 100px;
	margin-bottom: 165px;
}

#map {
	width: 755px;
	height: 400px;
	margin-bottom: 10px;
}

#calendar {
	width: 0px;
	height: 0px;
}

.ddit_info li {
	margin: 5px 0;
}

#aa {
	margin-right: 130px;
	color: #9986b3;
}

footer {
	position: static;
}

b {
	
}
</style>

</head>
<body>
	<%@include file="/include/header.jsp"%>
	<div class="container">
		<%pageContext.setAttribute("active", "find"); %>
		<%@include file="/include/libSidebar.jsp"%>
		<div class="content" style="position: relative; left: 200px;">
			<br>
			<div id="bobo">
				<h1 id="aa">찾아오시는 길</h1><br>
				<div class="board">
					<div id="map"></div>
					<div id="calendar"></div>

					<h1>사랑이 넘치는 라벤더 도서관</h1>
					<ul class="ddit_info">

						<button class="w-btn w-btn-indigo" type="button" id="m1">
							큰지도 보기</button>
						&nbsp
						<button class="w-btn w-btn-indigo" type="button" id="m2">
							길찾기</button>
						<hr>

						<li class="addr"><i class="fas fa-map-marker-alt"></i>주소 :
							대전광역시 중구 계룡로 846, 1층</li>
						<li class="tel"><i class="fas fa-phone-volume"></i>전화 :
							042-000-0000</li>
						<li class="subway"><i class="fas fa-subway"></i>지하철 : 서대전네거리역
							4번출구, 오룡역 1번출구</li>
						<li class="bus"><i class="fas fa-bus"></i>번호 : 101, 103, 315,
							603, 614, 618</li>
					</ul>
				</div>
			</div>

			<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
			<script type="text/javascript"
				src="//dapi.kakao.com/v2/maps/sdk.js?appkey=282942db7efa577302229ef09c2571de"></script>
			<script>
	//문서준비 코드를 꼭 써줘야한다.
	$(document).ready(function(){
		var container = document.getElementById('map');
		var options = {
			center : new kakao.maps.LatLng(36.32441048399925, 127.40955777127694),
			level : 3
		};

		var map = new kakao.maps.Map(container, options);

		var markerPosition = new kakao.maps.LatLng(36.32441048399925,
				127.40955777127694);

		var marker = new kakao.maps.Marker({
			position : markerPosition
		});
		marker.setMap(map);

		var iwContent = '<div style="padding:5px;">라벤더 도서관 <br><a href="https://map.kakao.com/link/map/ 라벤더 도서관,36.32441048399925, 127.40955777127694" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/ 라벤더 도서관,36.32441048399925, 127.40955777127694" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		iwPosition = new kakao.maps.LatLng(36.32441048399925,
				127.40955777127694);

		var infowindow = new kakao.maps.InfoWindow({
			position : iwPosition,
			content : iwContent
		});

		infowindow.open(map, marker);
	});
	
	document.querySelector("#m1").addEventListener('click',function(){
		   window.location.href = "https://map.kakao.com/link/map/라벤더 도서관,36.32441048399925,127.40955777127694";
		})

		document.querySelector("#m2").addEventListener('click',function(){
		   window.location.href = "https://map.kakao.com/link/to/ 라벤더 도서관,36.32441048399925, 127.40955777127694";
		})
		
	</script>
		</div>

	</div>
	<script>
    
     let active = "<%=request.getAttribute("active") %>"
    
    </script>

	<%request.setAttribute("active", "find"); %>
	<%@include file="/include/footer.jsp"%>
</body>
</html>