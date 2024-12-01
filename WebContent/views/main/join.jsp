<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	
<!DOCTYPE html>
<html lang="en">
<head>
    <title>회원가입 페이지</title>
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
  
    </style>
  </head>
</head>
<body>
    <div class="col-sm-8">
        <h4>회원가입</h4>
        
        <hr>
        <!-- action정보 생략되었을 때 현제 페이지의 url위치로 이동(전달,제출) -->
        <form class="form-horizontal" method="post" onsubmit="valid(event)"><!-- event키워드 그대로 사용 --> 
          <div class="form-group">
            <label for="id" class="control-label col-sm-2">아이디<span class="rq"> *</span></label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="id" name="mem_id" 
              placeholder="첫자는 영문으로 시작" required pattern="[a-zA-Z][a-zA-Z0-9]{3,15}"><!-- [a-zA-Z]\w{3,7} -->
                                                  <!-- 첫자는 무조건 영문만, 나머지 3~7자리 영문+숫자 -->
            </div>
            <div class="col-sm-6" style="text-align: left;">
<!--               <button type="button" class="btn btn-success btn-sm" id="idChk">중복검사</button> -->
              <span id="disp"></span>
            </div>
          </div>
          
          <div class="form-group">
            <label for="pass" class="control-label col-sm-2">비밀번호<span class="rq"> *</span></label>
            <div class="col-sm-4">
              <input type="password" class="form-control" id="pass" name="mem_pass"
              placeholder="대문자 알파벳을 포함" pattern="(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#\$%\^&amp;\*\(\)_\+\|]).{8,}">
            </div>
          </div>
          
         <div class="form-group">
   		 <label for="passConfirm" class="control-label col-sm-2">비밀번호 확인<span class="rq"> *</span></label>
   		 	<div class="col-sm-4">
        <input type="password" class="form-control" id="passConfirm" name="mem_passConfirm" required>
  		 	</div>
		</div>
          
          <div class="form-group">
            <label for="name" class="control-label col-sm-2">이름<span class="rq"> *</span></label>
            <span class="sp"></span>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="name" name="mem_name"
              pattern="[가-힣]{2,8}">
            </div>
          </div>
          
          <div class="form-group">
            <label for="bir" class="control-label col-sm-2">생년월일</label>
            <div class="col-sm-4">
              <input type="date" class="form-control" id="bir" name="mem_bir">
            </div>
          </div>
          
          <div class="form-group">
            <label for="hp" class="control-label col-sm-2">연락처<span class="rq"> *</span></label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="tel" name="mem_tel" 
              placeholder="010-0000-0000" required pattern="[0-9]{2,3}-\d{3,4}-[0-9]{4}">
            </div>
          </div>
          
          <div class="form-group">
            <label for="mail" class="control-label col-sm-2">이메일</label>
            <div class="col-sm-4">
              <input type="email" class="form-control" id="email" name="mem_email"
              pattern="[0-9a-zA-Z]+@[0-9a-zA-Z]+(\.[a-z]+){1,2}"><!-- \w+@\w+(\.[a-z]+){1,2} -->
                                      <!-- 주소@naver.com / 주소@google.co.kr -->
            </div>
          </div>
          
          <div class="form-group">
            <label for="add1" class="control-label col-sm-2">우편번호<span class="rq"> *</span></label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="postno" name="mem_postno" required>
            </div>
            <div class="col-sm-6" style="text-align: left;">
              <button type="button" id="addrBtn" class="btn btn-info btn-sm">주소검색</button>
            </div>
          </div>
          
          <div class="form-group">
            <label for="addr1" class="control-label col-sm-2">주소<span class="rq"> *</span></label>
            <div class="col-sm-6">
              <input type="text" class="form-control" id="addr1" name="mem_addr1" required>
            </div>
          </div>
          
          <div class="form-group">
            <label for="addr2" class="control-label col-sm-2">상세주소<span class="rq"> *</span></label>
            <div class="col-sm-6">
              <input type="text" class="form-control" id="addr2" name="mem_addr2" required>
            </div>
          </div>
          
          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-6">
              <button class="btn btn-default" id="joinBtn">가입하기</button>
              <span id="joinspan"></span>
            </div>
          </div>
        </form>
      </div>
      <div>
      	<button class="btn btn-default" id="main">메인으로</button>
      </div>
  
  <!-- 다음주소api --> 
  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  <script>
  
  document.addEventListener("DOMContentLoaded", function() {
      document.getElementById("main").addEventListener("click", function() {
          window.location.href = "<%= request.getContextPath() %>/main.do";///////////////
      });
  });
  
   $('#id').on('keyup',function(){
       $.ajax({
          url: '<%= request.getContextPath() %>/views/main/idChk.jsp?id=' + $('#id').val(),
          success:function(res){
              if(res.rst == "ok"){
                  $('#disp').text(res.msg).css('color','green');
              }else{
                  $('#disp').text(res.msg).css('color','red');
              }
              
          },
          error:function(xhr){
              alert("상태 : " + xhr.status);
          }
          ,dataType: 'json'
       });
       
   });
   
   
   $('#addrBtn').on('click',addrApi);
  
   function addrApi() {
       new daum.Postcode({
           oncomplete: function(data) {
  
               document.getElementById('postno').value = data.zonecode;
               document.querySelector("#addr1").value = data.roadAddress;
           }
       }).open();
   }
   
   
   
   function valid(e){ 
      e.preventDefault(); //action위치로 이동하는 기능 중지
      
	    let pass = document.getElementById('pass').value;
	    let passConfirm = document.getElementById('passConfirm').value;

	    if (pass !== passConfirm) {
	    	swal("비밀번호가 일치하지 않습니다!", "비밀번호 확인하기.", "error");
// 	        alert("비밀번호가 일치하지 않습니다.");
	        return false;
	    }
      
      //제이쿼리의 serialize()가 입력양식요소들의 name속성을 가지고 자동으로 url인코딩 형식 정보를 제공 
      let formData = $('form').serialize(); //key1=value1&key2=value2&....&key9=value9 
      console.log(formData);
       
      $.ajax({
          type: 'post',
          url: '<%= request.getContextPath() %>/Join.do',
          data: formData, //url인코딩(%인코딩)
          success:function(res){
               console.log("응답>>", res);
               if(res == 1){
            	   swal("회원가입 성공!", "로그인 페이지로 이동합니다.", "success");
                   $('#joinspan').text("가입성공!!").css('color','green');
                   setTimeout(function() {
                	   location.href = "<%= request.getContextPath() %>/Login.do";
                   }, 3000); // 3초 후에 페이지 이동
               }else{
                   $('#joinspan').text("가입실패..").css('color','red');
               }
          },
          error:function(xhr){
              alert("상태 확인: " + xhr.status);
          }
  // 	 	,dataType: '' 
       })
   }
   
   
   
   </script> 

</body>
</html>