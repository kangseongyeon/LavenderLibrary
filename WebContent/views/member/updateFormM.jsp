<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="kr.or.ddit.contest.vo.BookReportVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   
   MemberVO mv = (MemberVO) request.getAttribute("mv");
	String msg = session.getAttribute("msg") == null ? "" : (String) session.getAttribute("msg");
	session.removeAttribute("msg"); // 한번 사용한 데이터 삭제




%>
   
<!DOCTYPE html>
<html lang="en">
<head>
    <title>회원정보 수정 페이지</title>
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
    .find-btn{
   text-align: center;

	}
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
        	display :inline-block;
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
        <h4>회원 정보 수정</h4>
        
        <hr>
        <!-- action정보 생략되었을 때 현제 페이지의 url위치로 이동(전달,제출) -->
        <form class="form-horizontal" method="post" onsubmit="valid(event)"><!-- event키워드 그대로 사용 --> 
          <div class="form-group">
            <label for="id" class="control-label col-sm-2">아이디</label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="id" name="mem_id" value="<%=mv.getMemId() %>"
              readonly="readonly">
            </div>
          </div>
          
          <div class="form-group">
            <label for="pass" class="control-label col-sm-2">비밀번호<span class="rq"> *</span></label>
            <div class="col-sm-4">
              <input type="password" class="form-control" id="pass" name="mem_pass" value=""
              required pattern="(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#\$%\^&amp;\*\(\)_\+\|]).{8,}">
            </div>
          </div>
          
         <div class="form-group">
          <label for="passConfirm" class="control-label col-sm-2">비밀번호 확인<span class="rq"> *</span></label>
             <div class="col-sm-4">
        <input type="password" class="form-control" id="passConfirm" name="mem_passConfirm" required>
            </div>
      </div>
      
        <input type="hidden" class="form-control" id="name" name="mem_name" value="<%=mv.getMemName() %>">
    
        <input type="hidden" class="form-control" id="bir" name="mem_bir" value="<%=mv.getMemName() %>">
          
          
          <div class="form-group">
            <label for="hp" class="control-label col-sm-2">연락처<span class="rq"> *</span></label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="tel" name="mem_tel" 
              value="<%=mv.getMemTel() %>" required pattern="[0-9]{2,3}-\d{3,4}-[0-9]{4}">
            </div>
          </div>
          
          <div class="form-group">
            <label for="mail" class="control-label col-sm-2">이메일</label>
            <div class="col-sm-4">
              <input type="email" class="form-control" id="email" name="mem_email" value="<%=mv.getMemEmail() %>"
              pattern="[0-9a-zA-Z]+@[0-9a-zA-Z]+(\.[a-z]+){1,2}"><!-- \w+@\w+(\.[a-z]+){1,2} -->
                                      <!-- 주소@naver.com / 주소@google.co.kr -->
            </div>
          </div>
          
          <div class="form-group">
            <label for="add1" class="control-label col-sm-2">우편번호<span class="rq"> *</span></label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="postno" name="mem_postno" value="<%=mv.getMemPostno() %>" required>
            </div>
            <div class="col-sm-6" style="text-align: left;">
              <button type="button" id="addrBtn" class="btn btn-info btn-sm">주소검색</button>
            </div>
          </div>
          
          <div class="form-group">
            <label for="addr1" class="control-label col-sm-2">주소<span class="rq"> *</span></label>
            <div class="col-sm-6">
              <input type="text" class="form-control" id="addr1" name="mem_addr1" value="<%=mv.getMemAddr1() %>" required>
            </div>
          </div>
          
          <div class="form-group">
            <label for="addr2" class="control-label col-sm-2">상세주소<span class="rq"> *</span></label>
            <div class="col-sm-6">
              <input type="text" class="form-control" id="addr2" name="mem_addr2" value="<%=mv.getMemAddr2() %>" required>
            </div>
          </div>
          
          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-6">
              <button class="btn btn-default" id="joinBtn">수정하기</button>
              <span id="Upspan"></span>
            </div>
          </div>
        </form>
      </div>
      	<div class="find-btn" >
         <button class="btn btn-default" id="main">메인으로</button>
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <button class="btn btn-default" id="withDraw">회원탈퇴</button>
      	</div>
<%--          <a href="<%= request.getContextPath() %>/member/memberWithDraw.do?memId=<%=mv.getMemId() %>" id="withDraw">회원 탈퇴</a><br><br><hr> --%>
  
  <!-- 다음주소api --> 
  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  <script>
  
  
 	document.getElementById('withDraw').onclick=function(){
		
		
		// 1. 탈퇴를 진행하시겠습니까?
		// 2. 탈퇴를 하시게 되면, 데이터는 절대 복구 불가능합니다.
		
		if(window.confirm("탈퇴를 진행하시겠습니까?") && window.confirm("탈퇴를 하시게 되면, 데이터는 절대 복구 불가능합니다."))
		{
           window.location.href = "/LavenderLibrary/member/memberWithDraw.do";///하드코딩했음
			return true;
		}else
		{
			return false;
		}

		
		
	};
  
  
  
  
  document.addEventListener("DOMContentLoaded", function() {
      document.getElementById("main").addEventListener("click", function() {
       
//           window.location.href = "/views/main/main.jsp";
           window.location.href = "/LavenderLibrary/main.do";///하드코딩했음
      });
  });

/*   document.addEventListener("DOMContentLoaded", function() {
      document.getElementById("deleteMem").addEventListener("click", function() {
//           window.location.href = "/views/main/main.jsp";
           confirm("정말 회원탈퇴하시겠습니까?")
           window.location.href = "/LavenderLibrary/member/memberWithDraw.do";///하드코딩했음
      });
  }); */
   
   
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
//            alert("비밀번호가 일치하지 않습니다.");
           return false;
       }
      
      //제이쿼리의 serialize()가 입력양식요소들의 name속성을 가지고 자동으로 url인코딩 형식 정보를 제공 
      let formData = $('form').serialize(); //key1=value1&key2=value2&....&key9=value9 
      console.log(formData);
       
      $.ajax({
          type: 'post',
         url : '<%=request.getContextPath() %>/member/update.do',
          data: formData, //url인코딩(%인코딩)
          success:function(res){
               console.log("응답>>", res);
               if(res == 1){
                  swal("수정 성공!", "나의 도서관 페이지로 이동합니다.", "success");
                   $('#Upspan').text("수정성공!!").css('color','green');
                   setTimeout(function() {
                       location.href = "/LavenderLibrary/views/member/myInfo.jsp";
                   }, 3000); // 3초 후에 페이지 이동
               }else{
                   $('#Upspan').text("수정실패..").css('color','red');
               }
          },
          error:function(xhr){
              alert("상태 확인: " + xhr.status);
          }
  //        ,dataType: '' 
       })
       
       
   }
   
   
   
   </script> 

</body>
</html>