<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	
<!DOCTYPE html>
<html lang="en">
<head>
    <title>아이디 찾기</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<!--     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <!-- fullCalendar.jsp -->
  <link href='https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.css' rel='stylesheet' />
  <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.js'></script>
  <!-- fullCalendar.jsp -->
  
    
    <style>
        .rq {
    color: red;
    }
    .pager {
    float: left;
    }
    #page {
    display: flex;
    justify-content: center;
    }
    
        body {
            font-family: Arial, sans-serif;
            background-color: #c4bee2;
            color: #333;
        }

        .col-sm-8 {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin: 50px auto;
            max-width: 800px;
        }

        h4 {
            color: #6c5a72;
            border-bottom: 2px solid #c4bee2;
            padding-bottom: 10px;
            font-size: 24px; /* 글자 크기 조정 */
            text-align: center; /* 중앙 배열 */
        }

        .form-horizontal .form-group {
            margin-bottom: 15px;
        }

        .form-horizontal .control-label {
            color: #9986b3;
            text-align: right;
        }

        .form-control {
            border: 1px solid #6c5a72;
            border-radius: 4px;
            padding: 10px;
            width: 100%;
        }

        .btn {
            background-color: #9986b3;
            border: none;
            color: #fff;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .btn:hover {
            background-color: #c4bee2;
        }

        .btn-success {
            background-color: #9986b3;
        }

        .btn-info {
            background-color: #c4bee2;
        }

        .btn-default {
            background-color: #e0dbef;
            color: #333;
        }


        .form-group .col-sm-6, .form-group .col-sm-4 {
            display: flex;
            align-items: center;
        }

        .form-group .col-sm-6 button, .form-group .col-sm-4 button {
            margin-left: 10px;
        }

        .form-group .col-sm-6 span, .form-group .col-sm-4 span {
            margin-left: 10px;
        }

        hr {
            border: 1px solid #c4bee2;
        }    
        
.actions {
    margin-left: 20px;
    padding: 10px 18px;
    text-decoration: none;
    color: white;
    border-radius: 5px;
    font-size: 14px;
    display: flex;
    justify-content: center;
    /* align-items: center; */
    margin-top: 5px;
    margin-bottom: 10px;
    flex-direction: row;
    flex-wrap: nowrap;
    align-content: flex-start;
}
  
    </style>
  </head>

<body>
    <div class="col-sm-8">
        <h4>아이디 찾기</h4>
        <p><b>아이디를</b> 잃어버리셨군요?! (책을 좀 읽으면 나아 질지도...)</p>
        <hr>

        <form class="form-horizontal" method="post" >
            <div class="form-group">
                <label for="hp" class="control-label col-sm-2">연락처<span class="rq"> *</span></label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="tel" name="mem_tel" 
                    placeholder="010-0000-0000" required pattern="[0-9]{2,3}-\d{3,4}-[0-9]{4}">
                </div>
            </div>

            <div class="form-group">
                <label for="mail" class="control-label col-sm-2">이메일<span class="rq"> *</span></label>
                <div class="col-sm-4">
                    <input type="email" class="form-control" id="email" name="mem_email"
                    pattern="[0-9a-zA-Z]+@[0-9a-zA-Z]+(\.[a-z]+){1,2}">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-6">
                    <button type="button" class="btn btn-default" id="findIdBtn">찾기</button>
                    <span id="findId"></span>
                </div>
            </div>
        </form>
    </div>
    
       <div class = "actions">
      	<button class="btn btn-default" id="logibGo" >로그인으로</button>
      </div>

    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


    <script>
    document.addEventListener("DOMContentLoaded", function() {
        document.getElementById("logibGo").addEventListener("click", function() {
            window.location.href = "<%= request.getContextPath() %>/Login.do";///////////////
        });
    });
    
    
    //ajax 사용시 서브밋으로 하면 안됀다!!!!!!!!!
    document.querySelector('#findIdBtn').addEventListener('click',function(){
  		
	      $.ajax({
	          type: 'post',
	          url: '<%=request.getContextPath() %>/FindId.do',
	          data: {mem_tel: $("input[name=mem_tel]").val(), mem_email: $("input[name=mem_email]").val()}, //url인코딩(%인코딩)
	          success:function(res){
// 	               console.log("응답>>", res.memId);
	               
	               //null 문자열이다!
	               if(res.memId != 'null'){
	            	   alert("회원님의 ID는"+res.memId+"입니다.");
	                  
//	                   setTimeout(function() {
//	                       location.href = "login.jsp";
//	                   }, 3000); // 3초 후에 페이지 이동
	               }else{
	            	   
	            	   swal("이상하네..", "정보가 일치 하지 않습니다.", "error");
	               }
	          },
	          error:function(xhr){
	              alert("상태 확인: " + xhr.status);
	          }
	   	 	,dataType: 'json' 
	       })
	       
    
  });
        



    
    </script>

</body>
</html>