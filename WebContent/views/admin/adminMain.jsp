<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="../favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>도서관 관리자 페이지</title>
    <style>
    	@font-face {
		    font-family: 'GangwonEdu_OTFBoldA';
		    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/GangwonEdu_OTFBoldA.woff') format('woff');
		    font-weight: normal;
		    font-style: normal;
		}
		
       body {
       		font-family: 'GangwonEdu_OTFBoldA';
		    background-image: url('./CK_cb2140002356.jpg');
		    background: linear-gradient(rgba(255, 255, 255, 0.4), rgba(255, 255, 255, 0.2)), url('<%=request.getContextPath()%>/images/CK_cb2140002356.jpg');
		    /* font-family: Arial, sans-serif; */
		    margin: 0;
		    padding: 0;
		    background-color: #d4cae3;
		    background-size: cover;
		    background-position: center; 
		    height: 100vh; 
		}

        .header {
            padding: 10px;
            text-align: left;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .header h1 {
            margin: 0;
            font-size: 24px;
            font-weight: bolder;
            padding: 10px;
        }
        .nav {
            text-align: right;
            padding: 10px;
            display: flex;
            justify-content: flex-end;
        }
        .nav a {
            margin: 0 5px;
            padding: 5px 10px;
            background-color: #e6e6fa;
            text-decoration: none;
            color: #000;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .nav a:hover {
            background-color: #d4cae3;
        }
        .big-box5 {
            border: 3px dotted pink;
            padding: 10px;
            margin: 0 auto;
            width: 80%;
            text-align: center;
            padding: 10px; 
            margin-bottom: 5px; 
        }
        .big-box5 h2 {
            color: black; 
            font-size: 20px; 
            margin-top: 0;
        }
        .big-box1 {
            border: 3px dotted #D6C8AD;
            padding: 10px; 
            margin : 0px 5px 5px 5px;
            box-sizing: border-box; 
            float: left; 
            width: 16%; 
        }
        .big-box1 h2 {
            font-size: 20px;
            margin-top: 0;
            text-align: center;
        }
        .big-box2_1 {
            border: 3px dotted #CFB4C3; 
            padding: 10px; 
            margin-bottom: 10px; 
            box-sizing: border-box; 
            float: left; 
            width: 32%;
            margin-left: 10%; 
        }
        .big-box2_1 h2 {
            font-size: 20px; 
            margin-top: 0; 
            text-align: center; 
        }
        .big-box2_2 {
            border: 3px dotted #8AB7BC; 
            padding: 10px; 
            padding-left: 3px;
            margin-bottom: 10px; 
            box-sizing: border-box; 
            float: left; 
            width: 31%;
        }
        .big-box2_2 h2 {
            font-size: 20px;
            margin-top: 0;
            text-align: center; 
        }
        .big-box3_1 {
            border: 3px dotted #8BAFE3;
            padding: 10px;
            margin-bottom: 10px;
            box-sizing: border-box; 
            float: left;
            width: 39.9%; 
            margin-left: 11%;
        }
        .big-box3_1 h2 {
            font-size: 20px; 
            margin-top: 0; 
            text-align: center; 
        }
        .big-box3_2 {
            border: 3px dotted #CCAD7E; 
            padding: 10px; 
            margin-bottom: 10px; 
            box-sizing: border-box; 
            float: left;
            width: 39.9%;
            margin-right: 9%;
        }
        .big-box3_2 h2 {
            font-size: 20px; 
            margin-top: 0; 
            text-align: center; 
        }
        .link-container {
            display: flex;
            justify-content: space-around;
        }
        .link-container a {
            margin: 0 5px; 
        }
        .row {
            display: flex;
            justify-content: space-around;
            margin-bottom: 10px;
            width: 100%;
        }
        .box {
            background-color: #e6e6fa;
            margin: 10px;
            padding: 20px;
            box-sizing: border-box;
            text-align: center;
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }
        .box a:hover {
            background-color: #d4cae3;
        }
        .box-2_5 {
            width: calc(48.8% - 10px); 
        }
        .big-box3_1 a img,
        .big-box3_2 a img {
            max-width: 100%; 
        }
    </style>
</head>
<body>
<div class="header">
    <h1><b>도서관 관리자 페이지</b></h1>
    <div class="nav">
        <a href="<%=request.getContextPath()%>/main.do">
        	<span class="glyphicon glyphicon-user"></span> Home</a>
        <a href="<%=request.getContextPath()%>/Logout.do">
        	<span class="glyphicon glyphicon-log-out"></span> Logout</a>
        
        <a href="<%= request.getContextPath() %>/book/list.do">
        	<span class="glyphicon glyphicon-book"></span> 도서 목록</a>
    </div>
</div>

<div class="big-box5">
    <h2>커뮤니티 관리</h2>
    <div class="link-container">
        <a href="<%= request.getContextPath() %>/notice/list.do">
            <img src="<%= request.getContextPath() %>/images/5_1.공지사항.png" alt="공지사항 목록">
        </a>
        <a href="<%= request.getContextPath() %>/inquiry/list.do">
            <img src="<%= request.getContextPath() %>/images/5_2.도서관에바란다.png" alt="도서관에 바란다 목록">
        </a>
        <a href="<%= request.getContextPath() %>/faq/list.do">
            <img src="<%= request.getContextPath() %>/images/5_3.FAQ.png" alt="FAQ목록">
        </a>
        <a href="<%= request.getContextPath() %>/bookVideo/list.do">
            <img src="<%= request.getContextPath() %>/images/5_4.도서소개영상.png" alt="도서 소개 영상 목록">
        </a>
        <a href="<%= request.getContextPath() %>/news/list.do">
            <img src="<%= request.getContextPath() %>/images/5_5.도서소식지.png" alt="도서관 소식지 목록">
        </a>
    </div>
</div>

<div class="big-box2_1">
    <h2>대여 관리</h2>
    <div class="link-container">
        <a href="<%= request.getContextPath() %>/rental/list.do">
            <img src="<%= request.getContextPath() %>/images/2_1.대여목록.png" alt="대여 목록">
        </a>
        <a href="<%= request.getContextPath() %>/rental/overRental.do">
            <img src="<%= request.getContextPath() %>/images/2_2.연체목록.png" alt="연체 목록">
        </a>
    </div>
</div>

<div class="big-box1">
    <h2>예약 관리</h2>
    <a href="<%= request.getContextPath() %>/reserv/list.do">
        <img src="<%= request.getContextPath() %>/images/1.예약목록.png" alt="예약 목록">
    </a>
</div>

<div class="big-box2_2">
    <h2>회원 관리</h2>
    <div class="link-container">
        <a href="<%= request.getContextPath() %>/member/list.do">
            <img src="<%= request.getContextPath() %>/images/2_3.회원관리.png" alt="회원 목록">
        </a>
        <a href="<%=request.getContextPath()%>/main/listBlack.do">
            <img src="<%= request.getContextPath() %>/images/2_4.블랙리스트관리.png" alt="블랙리스트 목록">
        </a>
    </div>
</div>

<div class="row">
    <div class="big-box3_1">
        <h2>참여광장 관리</h2>
        <a href="<%= request.getContextPath() %>/report/list.do">
            <img src="<%= request.getContextPath() %>/images/3_1.글쓰기.png" alt="글쓰기 목록">
        </a>
       	<a href="<%= request.getContextPath() %>/debate/list.do">
            <img src="<%= request.getContextPath() %>/images/3_2.토론.png" alt="토론 목록">
        </a>
        <a href="<%= request.getContextPath() %>/sentence/list.do">
            <img src="<%= request.getContextPath() %>/images/3_3.1일1문장.png" alt="1일 1문장 쓰기 목록">
        </a>
    </div>

    <div class="big-box3_2">
        <h2>행사 관리</h2>
        <a href="<%=request.getContextPath()%>/adminEvent/libraryList.do">
            <img src="<%= request.getContextPath() %>/images/3_4.행사.png" alt="도서관 행사 목록">
        </a>
        <a href="<%=request.getContextPath()%>/adminEvent/fieldStudyList.do">
            <img src="<%= request.getContextPath() %>/images/3_5.체험학습.png" alt="도서관 체험학습 관리">
        </a>
        <a href="<%=request.getContextPath()%>/adminEvent/movieList.do">
            <img src="<%= request.getContextPath() %>/images/3_6.영화.png" alt="영화 상영 목록">
        </a>
    </div>
</div>

</body>
</html>
