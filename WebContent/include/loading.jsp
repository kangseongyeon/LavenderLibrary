<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>로딩중</title>
    <style>
        .loader-wrapper {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: #e9e6ef;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column; /* 수직으로 정렬 */
            z-index: 20;
        }

        .loader {
            border: 16px solid #e0dbef; /* Light grey - border 전체 색상 지정*/
            border-top: 16px solid #9983bc; /* Blue - 로딩 영역 색상 지정 */
            border-radius: 50%; /* 둥근 모서리 효과 */
            width: 80px; /* 크기 지정 */
            height: 80px;
            animation: spin 2s linear infinite;
            /* 키프레임 애니메이션값 2초 가속도없이 일정하게 연속적인 로딩 */
        }

        .loading-text {
            color: white;
            font-size: 20px;
            margin-top: 20px;
            position: relative;
            top: 20px; /* 텍스트를 아래로 20px 이동 */
        }

        @keyframes spin {
            0% { transform: rotate(0deg); }
            100% { transform: rotate(360deg); }
        }
    </style>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
    <div class="loader-wrapper">
        <div class="loader"></div>
        <div class="loading-text"><b>로딩중 입니다...</b></div>
    </div>

    <script>
        $(document).ready(function(){
            $('.loader-wrapper').fadeOut();
        });
    </script>
</body>
</html>
