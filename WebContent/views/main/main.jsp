<%@page import="kr.or.ddit.vo.EventVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileDetailVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="kr.or.ddit.comm.service.AtchFileServiceImpl"%>
<%@page import="kr.or.ddit.comm.service.IAtchFileService"%>
<%@page import="kr.or.ddit.book.vo.BookVO"%>
<%@page import="kr.or.ddit.vo.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
   String popupMode = "on";
Cookie[] cookies = request.getCookies();
if (cookies != null) {
   for (Cookie c : cookies) {
      String cookieName = c.getName();
      String cookieValue = c.getValue();
      if (cookieName.equals("PopupClose")) {
   popupMode = cookieValue;
   break;
      }
   }
}
%>
<!doctype html>
<html lang="en" data-bs-theme="auto">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
   content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
   
<meta name="generator" content="Hugo 0.122.0">

<title>LavenderLibrary</title>

<!--     <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/carousel/"> -->


<!--     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3"> -->

<%--    <link href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" rel="stylesheet"> --%>



<style>
.bd-placeholder-img {
   font-size: 1.125rem;
   text-anchor: middle;
   -webkit-user-select: none;
   -moz-user-select: none;
   user-select: none;
}

@media ( min-width : 768px) {
   .bd-placeholder-img-lg {
      font-size: 3.5rem;
   }
}

.b-example-divider {
   width: 100%;
   height: 3rem;
   background-color: rgba(0, 0, 0, .1);
   border: solid rgba(0, 0, 0, .15);
   border-width: 1px 0;
   box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
      rgba(0, 0, 0, .15);
}

.b-example-vr {
   flex-shrink: 0;
   width: 1.5rem;
   height: 100vh;
}

.bi {
   vertical-align: -.125em;
   fill: currentColor;
}

.nav-scroller {
   position: relative;
   z-index: 2;
   height: 2.75rem;
   overflow-y: hidden;
}

.nav-scroller .nav {
   display: flex;
   flex-wrap: nowrap;
   padding-bottom: 1rem;
   margin-top: -1px;
   overflow-x: auto;
   text-align: center;
   white-space: nowrap;
   -webkit-overflow-scrolling: touch;
}

.btn-bd-primary { -
   -bd-violet-bg: #712cf9; -
   -bd-violet-rgb: 112.520718, 44.062154, 249.437846; -
   -bs-btn-font-weight: 600; -
   -bs-btn-color: var(- -bs-white); -
   -bs-btn-bg: var(- -bd-violet-bg); -
   -bs-btn-border-color: var(- -bd-violet-bg); -
   -bs-btn-hover-color: var(- -bs-white); -
   -bs-btn-hover-bg: #6528e0; -
   -bs-btn-hover-border-color: #6528e0; -
   -bs-btn-focus-shadow-rgb: var(- -bd-violet-rgb); -
   -bs-btn-active-color: var(- -bs-btn-hover-color); -
   -bs-btn-active-bg: #5a23c8; -
   -bs-btn-active-border-color: #5a23c8;
}

.bd-mode-toggle {
   z-index: 1500;
}

.bd-mode-toggle .dropdown-menu .active .bi {
   display: block !important;
}

div#popup {
   position: absolute;
   top: 100px;
   left: 50px;
   color: yellow;
   width: 270px;
   height: 100px;
   background-color: gray;
}

div#popup>div {
   position: relative;
   background-color: #ffffff;
   top: 0px;
   border: 1px solid gray;
   padding: 10px;
   color: black;
}

div#popup {
   position: fixed;
   top: 50px;
   right: 50px;
   width: 300px;
   height: auto;
   background-color: #ffffff;
   border: 1px solid #000000;
   z-index: 9999;
}

.content-section {
   display: flex;
   justify-content: space-between;
   flex-wrap: wrap;
}

.column {
   width: calc(50% - 20px);
   /* margin-bottom: 20px; */
   display: inline-block;
   vertical-align: top;
}

.column h2 {
   margin-bottom: 10px;
}

.column ul {
   /* list-style-type: disc;
   	  padding-left: 0px; */
   list-style-image:url(./images/라벤더.png); 
   padding-left: 30px;
}
	
.column ul li {
/*    margin-bottom: 8px;
   font-size: 16px; */
    margin-bottom: -2px;
    font-size: 21px;
}

.header {
   display: flex;
   justify-content: space-between;
   align-items: center;
   background-color: #e0dbef;
   border-radius: 5px;
   padding: 12px;
   margin-bottom: 15px;
   align-items: center;
}

.header h2 {
   margin: 0;
   position: relative;
   top : 5px;
}

.header a {
   text-decoration: none;
   font-size: 24px;
   color: black;
}

.detail {
   border: 1px solid black;
   /* border-radius: 5px; */
   /* padding: 5px; */
   background-color: white;
   text-align: center;
   width: 7%;
}

.detail:hover {
   transition: all 1s;
   transform: rotate(360deg);
}


.text-right {
  text-align: right;
   margin-left: 300px;
}

</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function() {
    if ("<%=popupMode%>" != "on") {
        $("#popup").hide();
    }

    $('#closeBtn').on('click', function() {
        $('#popup').hide();
        if ($('#inactiveToday').prop('checked')) {
            $.ajax({
//                 url: './views/main/PopupCookie.jsp',
                url: '<%=request.getContextPath()%>/views/main/PopupCookie.jsp',
                                             type : 'get',
                                             data : {
                                                inactiveToday : "1"
                                             },
                                             dataType : "text",
                                             success : function(
                                                   resData) {
                                                if (resData != '') {
                                                   console
                                                         .log("쿠키 설정 성공");
                                                }
                                             }
                                          });
                                 }
                              });
               });
</script>

<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/resources/css/carousel.css"
   rel="stylesheet">
<%--     <link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/images/favicon.ico"> --%>
</head>
<body>


  <%@include file="/include/header.jsp"%>
	<main>
		<%
			if (popupMode.equals("on")) {
		%>
		<div id="popup">
			<a href="<%=request.getContextPath()%>/library/use.do">
				<img src="<%=request.getContextPath()%>/images/도서관 이용안내.png" width="298" height="400">
			</a>
	
			<div align="right" style="color: #000000;">
				<form name="popFrm">
					<label for="inactiveToday" style="color: #000000;">
					<input type="checkbox" id="inactiveToday" value="1" /> 오늘 하루 동안 열지 않음
					</label>
					<button type="button" id="closeBtn" style="color: #000000;">닫기</button>
				</form>
			</div>
		</div>
		<%
			}
		%>


      <div id="myCarousel" class="carousel slide mb-6"
         data-bs-ride="carousel">

         <div class="carousel-inner">
            <div class="carousel-item active">
               <img src="<%=request.getContextPath()%>/images/메인페이지 배너.gif"
                  alt="도서관 내부" width="100%" height="100%" >

               <div class="container" style="position:relative; left: 300px ">
                  <div class="carousel-caption text-start">
                     
                     <p class="text-right">
                        <a class="btn btn-lg btn-primary"
                           href="<%=request.getContextPath()%>/library/intro.do">도서관  정보</a>
                     </p>
                  </div>
               </div>
            </div>

         </div>
      </div>


      <!-- Marketing messaging and featurettes
  ================================================== -->
      <!-- Wrap the rest of the page in another container to center all the content. -->

	<div class="container marketing">
			<br>
			<!-- Three columns of text below the carousel -->
			<div class="row">
				<h1>신작도서</h1><br>
				<%
					List<BookVO> bookList = (List<BookVO>) request.getAttribute("bookList");
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				for (int i = 0; i < 3 && i < bookList.size(); i++) {
					BookVO bv = bookList.get(i);
					AtchFileVO fileVO = new AtchFileVO();
					fileVO.setAtchFileId(bv.getAtchFileId());
					AtchFileVO atchFileVO = fileService.getAtchFile(fileVO);
				%>
				<div class="col-lg-4">
					<%
						if (atchFileVO != null && !atchFileVO.getAtchFileDetailList().isEmpty()) {
						AtchFileDetailVO fileDetail = atchFileVO.getAtchFileDetailList().get(0);
						System.out.println(fileDetail.getFileStreCours() + "." + fileDetail.getFileExtsn());
					%>
					<img
						src="/image/<%=fileDetail.getStreFileNm() + "." + fileDetail.getFileExtsn()%>"
						alt="<%=bv.getBookName()%>" width="140" height="190">
					<h2 class="fw-normal"><%=bv.getBookName()%></h2>
					<%
						} else {
					%>
					<img src="<%=request.getContextPath()%>/images/no-image.jpg"
						alt="이미지 없음" class="book-image">
					<%
						}
					%>
					<p>
						<a class="btn btn-secondary"
							href="<%=request.getContextPath()%>/book/detail.do?bookId=<%=bv.getBookId()%>">View
							details &raquo;</a>
					</p>
				</div>
				<%
					}
				%>
			</div>
			<!-- </div> -->


         <!-- START THE FEATURETTES -->

         <hr class="featurette-divider">


         <div class="content-section">
            <div class="column">
               <div class="header">
                  <h2>공지사항</h2>
                  <div class="detail">
                     <h2>
                        <a href="<%=request.getContextPath()%>/notice/list.do">+</a>
                     </h2>
                  </div>
               </div>
               <ul>
    <%
        List<NoticeVO> noticeList = (List<NoticeVO>) request.getAttribute("noticeList");
        if (noticeList != null && !noticeList.isEmpty()) {
            for (int i = 0; i < 5 && i < noticeList.size(); i++) {
                NoticeVO notice = noticeList.get(i);
    %>
    <li><a href="<%=request.getContextPath()%>/notice/detail.do?noticeNo=<%=notice.getNoticeNo()%>"><%=notice.getNoticeTitle()%></a></li>
    <%
            }
        } else {
    %>
    <li>공지사항이 없습니다.</li>
    <%
        }
    %>
</ul>
            </div>
            <div class="column">
               <div class="header">
                  <h2>행사안내</h2>
                  <div class="detail">
                     <h2>
                        <a
                           href="<%=request.getContextPath()%>/adminEvent/libraryList.do">+</a>
                     </h2>
                  </div>
               </div>
                  <ul>
               <%
               List<EventVO> eventList = (List<EventVO>) request.getAttribute("eventList");
               if (eventList != null && !eventList.isEmpty()) {
                  for (int i = 0; i < 5 && i < eventList.size(); i++) {
                     EventVO ev = eventList.get(i);
               %>
                  <li><a href="<%=request.getContextPath()%>/adminEvent/eventDetail.do?eventNo=<%=ev.getEventNo()%>"><%=ev.getEventName() %></a></li>
               <%
                     }
                  } else {
               %>
                  <li>공지사항이 없습니다.</li>
                  <%
                     }
                  %>
               </ul>
            </div>
         </div>

         <hr class="featurette-divider">

         <div class="row featurette">
            <div class="col-md-7">
               <h2 class="featurette-heading fw-normal lh-1">라벤더 도서관 공식 SNS</h2>
               <p class="lead">
              	안녕하세요! 라벤더 도서관의 공식 SNS 페이지에 오신 것을 환영합니다.
				<br> 이곳에서는 최신 도서 정보, 이벤트 소식, 독서 추천, 그리고 다양한 문화 프로그램에 
				<br> 대한 정보를 확인하실 수 있습니다.
				<br> 여러분의 독서 생활을 더욱 풍부하게 만들어 드리기 위해 항상 노력하겠습니다.
				<br> 팔로우하시고 다양한 소식을 놓치지 마세요!
               </p>
            </div>
            <div class="col-md-5">
               <div>
                  <a href="https://www.instagram.com/lavender_b1a4/" target='_blank'>
                     <img src="<%=request.getContextPath()%>/images/인스타.png" alt="인스타"
                     width="400px">
                  </a>
               </div>
            </div>
         </div>

         <hr class="featurette-divider">

         <!-- /END THE FEATURETTES -->

      </div>
      <!-- /.container -->


      <!-- FOOTER -->
      <%@include file="/include/footer.jsp"%>
   </main>

   <script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.bundle.min.js"></script>
	<script>
		function getParameterByName(name) {
			name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
			var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"), results = regex
					.exec(location.search);
			return results === null ? "" : decodeURIComponent(results[1]
					.replace(/\+/g, " "));
		}
		var message2 = getParameterByName('message2');
		if (message2) {
			swal("회원탈퇴 되었습니다", "좋은 하루 되세요!", "success");
		}

		var message = getParameterByName('message');
		if (message) {
			swal("로그아웃 되었습니다", "좋은 하루 되세요!", "success");
		}

		
	    <%
	    String Welcome = (String) session.getAttribute("Welcome");
	    if (Welcome != null && !Welcome.isEmpty()) {
	    %>
	    
	  
	    Swal.fire({
	    	  title: "라벤더 도서관에 오신 걸 환영합니다.",
	    	  width: 600,
	    	  padding: "3em",
	    	  color: "#716add",
	    	  background: "#fff url('<%=request.getContextPath()%>/images/라벤더01.png') center / contain no-repeat",

	    	}).then(function() {
	    	    
	    	    <% session.setAttribute("Welcome", ""); %>
	    	});
	  
	    <%
	    }
	    %>
	</script>

</body>
</html>