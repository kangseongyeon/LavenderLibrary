<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>비밀번호 찾기</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- fullCalendar.jsp -->
<link
	href='https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.css'
	rel='stylesheet' />
<script
	src='https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.js'></script>
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

#loading_spinner{
    display: none;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    z-index: 99;
}
.cv_spinner{
    height: 100%;
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    align-content: stretch;
    justify-content: center;
    align-items: baseline;
    position: relative;
}
.spinner {
  width: 100px;
  height: 100px;
  border: 15px #e0dbef solid;
  border-top: 15px #9983bc solid;
  border-radius: 50%;
  animation: sp-anime 0.8s infinite linear;
}

        
@keyframes sp-anime {
  100% {
    transform: rotate(360deg);
  }
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
</head>
<body>

<%@include file="/include/loading.jsp"%>
    <div class="col-sm-8">
        <h4>비밀번호 찾기</h4>
        <p><b>비밀번호를</b> 잃어버리셨군요?! (에릭 캔들의 '기억을 찾아서'를 추천드려요!)</p>
        <hr>

        <form class="form-horizontal" method="post" >
          <div class="form-group">
            <label for="id" class="control-label col-sm-2">아이디<span class="rq"> *</span></label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="mem_id" name="mem_id" 
              placeholder="아이디 입력" required pattern="[a-zA-Z][a-zA-Z0-9]{3,15}"><!-- [a-zA-Z]\w{3,7} -->
                                                  <!-- 첫자는 무조건 영문만, 나머지 3~15자리 영문+숫자 -->
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
            <label for="mail" class="control-label col-sm-2">이메일</label><span class="rq"> *</span></label>
            <div class="col-sm-4">
              <input type="email" class="form-control" id="email" name="mem_email"
              pattern="[0-9a-zA-Z]+@[0-9a-zA-Z]+(\.[a-z]+){1,2}">
            </div>
         </div>


          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-6">
                <button type="button" class="btn btn-default" id="findPwBtn"><b>확인 필수</b></button>
            </div>
        </div>
        
        <div class="form-group">
         <input type="button"  id="get_vld_num" value="임시비밀번호 받기"></button>
      </div>
        
       <div id="loading_spinner">
    	<div class="cv_spinner">
        <span class="spinner"></span>
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

    // 버튼 서밋으로 하면 안됀다! 폼 액셕이 없이 서밋하면 해당 페이지 한번더 실행!!
	document.querySelector('#findPwBtn').addEventListener('click',function(){
		
		
  		
	      $.ajax({
	          type: 'post',
	          url: '<%=request.getContextPath() %>/FindPw.do',
	          data: {mem_id: $("#mem_id").val(), mem_tel: $("input[name=mem_tel]").val(), mem_email: $("input[name=mem_email]").val()}, //url인코딩(%인코딩)
	          success:function(res){
	               console.log("응답>>", res.memPw);
	               if(res.memPw != 'null'){
	            	   swal("정보 확인!", "임시 비밀번호를 받아주세요!", "success");
	                  
	            	   
	               	document.querySelector('#get_vld_num').addEventListener('click', function() {
	            	    function generateRandomString(length) {
	            	        const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
	            	        let result = '';
	            	        const charactersLength = characters.length;
	            	        for (let i = 0; i < length; i++) {
	            	            result += characters.charAt(Math.floor(Math.random() * charactersLength));
	            	        }
	            	        return result;
	            	    }

	            	    let vld_num = generateRandomString(6); // 6자리 랜덤 문자열 생성
	            	    
	            		   $.ajax({
	            		      type:'get',
	            		      url:'<%=request.getContextPath() %>/mailsender.do',
	            		      data:{
	            		           "to":$('#email').val(),
	            		           "num":vld_num,
	            		           // 아이디 값 보내기!!
	            		           mem_id: $("#mem_id").val()
	            		           },
	            		      success:function(res) {
//	             		         console.log("응답 >>" res);
	            		         if(res = 1) {
	            		        	 swal("전송 완료!", "임시 비밀번호가 발송되었습니다!", "success");
	            		         } else {

	            		         }
	            		      },
	            		      error:function(xhr) {
	            		         alert(`상태확인 ${xhr.status}`);
	            		         console.log(xhr);
	            		      }
//	             		      ,dataType: 'json' 
	            		  })    		   
	            	  });
	               	
// 	                   setTimeout(function() {
// 	                       location.href = "login.jsp";
// 	                   }, 3000); // 3초 후에 페이지 이동
	               }else{
	            	   swal("이상하네..", "정보가 일치 하지 않습니다.", "error");
	               }
	          },
	          
	          beforeSend: function () {
	              $('#loading_spinner').show();
	          },
	          complete: function () {
	              $('#loading_spinner').hide();
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