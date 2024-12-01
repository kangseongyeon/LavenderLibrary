<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<style>

        .form-signin {
           background-color: rgba(255, 255, 255, 0.6);;
      		border: 1px solid #ccc;
      		padding: 20px;
     	 border-radius: 10px;
        }

        .form-signin .form-floating:focus-within {
            z-index: 2;
        }

        .form-signin input[type="text"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }

        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }

        #create-account-wrap {
  text-align: center;
  margin-top: 20px;
}

        .create-account-link {
  font-size: 18px;
  color: #9986b3;
  text-decoration: none;
  border: 2px solid #9986b3;
  padding: 10px 20px;
  border-radius: 5px;
  transition: all 0.3s ease;
    display: inline-block; 
  margin-left: 100px;
}

        .create-account1 {
  font-size: 14px;
  color: #9986b3;
  text-decoration: none;
  border: 2px solid #9986b3;
  padding: 5px 10px;
  border-radius: 5px;
  transition: all 0.3s ease;
  margin-right: 5px;


}

.create-account-link:hover {
  background-color: #6c5a72;
  color: white;
}

.create-account1:hover {
  background-color: #6c5a72;
  color: white;
}



        .find-link {
  font-size: 14px;
  color: #2c3e50;
  text-decoration: none;
}

.find-link:hover {
  color: #9986b3;
}
body {
  background: linear-gradient(rgba(255, 255, 255, 0.5), rgba(255, 255, 255, 0.3)), url('<%=request.getContextPath()%>/images/CK_cb2140002356.jpg');
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
  height: 100vh;
 }

.form-signin {
  max-width: 330px;
  padding: 1rem;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}

input[type="submit"] {
    border: none;
    display: inline-block; /* inline-block으로 변경 */
    background-color: #c4bee2;
    color: #fff;
    font-weight: bold;
    text-transform: uppercase;
    cursor: pointer;
    -webkit-transition: all 0.2s ease;
    transition: all 0.2s ease;
    font-size: 18px;
    text-align: center;
}
input[type="submit"]:hover {
  background-color: #9986b3;
  -webkit-transition: all 0.2s ease;
  transition: all 0.2s ease;
}

input[type="text"]:focus,
input[type="password"]:focus {
  border-color: #e0dbef;
}
input[type="text"]:focus:invalid,
input[type="password"]:focus:invalid {
  color: #cc1e2b;
  border-color: #cc1e2b;
}
input[type="text"]:valid ~ .validation,
input[type="password"]:valid ~ .validation {
  display: block;
  border-color: #0C0;
}
input[type="text"]:valid ~ .validation span,
input[type="password"]:valid ~ .validation span {
  background: #0C0;
  position: absolute;
  border-radius: 6px;
}
input[type="text"]:valid ~ .validation span:first-child,
input[type="password"]:valid ~ .validation span:first-child {
  top: 30px;
  left: 14px;
  width: 20px;
  height: 3px;
  -webkit-transform: rotate(-45deg);
          transform: rotate(-45deg);
}
input[type="text"]:valid ~ .validation span:last-child,
input[type="password"]:valid ~ .validation span:last-child {
  top: 35px;
  left: 8px;
  width: 11px;
  height: 3px;
  -webkit-transform: rotate(45deg);
          transform: rotate(45deg);
}

</style>

 </head>
  <body class="d-flex align-items-center py-4 bg-body-tertiary">
  
  
  <%@include file="/include/loading.jsp"%>
  
  
      <symbol id="check2" viewBox="0 0 16 16">
        <path d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z"/>
      </symbol>
      <symbol id="circle-half" viewBox="0 0 16 16">
        <path d="M8 15A7 7 0 1 0 8 1v14zm0 1A8 8 0 1 1 8 0a8 8 0 0 1 0 16z"/>
      </symbol>
      <symbol id="moon-stars-fill" viewBox="0 0 16 16">
        <path d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278z"/>
        <path d="M10.794 3.148a.217.217 0 0 1 .412 0l.387 1.162c.173.518.579.924 1.097 1.097l1.162.387a.217.217 0 0 1 0 .412l-1.162.387a1.734 1.734 0 0 0-1.097 1.097l-.387 1.162a.217.217 0 0 1-.412 0l-.387-1.162A1.734 1.734 0 0 0 9.31 6.593l-1.162-.387a.217.217 0 0 1 0-.412l1.162-.387a1.734 1.734 0 0 0 1.097-1.097l.387-1.162zM13.863.099a.145.145 0 0 1 .274 0l.258.774c.115.346.386.617.732.732l.774.258a.145.145 0 0 1 0 .274l-.774.258a1.156 1.156 0 0 0-.732.732l-.258.774a.145.145 0 0 1-.274 0l-.258-.774a1.156 1.156 0 0 0-.732-.732l-.774-.258a.145.145 0 0 1 0-.274l.774-.258c.346-.115.617-.386.732-.732L13.863.1z"/>
      </symbol>
      <symbol id="sun-fill" viewBox="0 0 16 16">
        <path d="M8 12a4 4 0 1 0 0-8 4 4 0 0 0 0 8zM8 0a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 0zm0 13a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 13zm8-5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2a.5.5 0 0 1 .5.5zM3 8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2A.5.5 0 0 1 3 8zm10.657-5.657a.5.5 0 0 1 0 .707l-1.414 1.415a.5.5 0 1 1-.707-.708l1.414-1.414a.5.5 0 0 1 .707 0zm-9.193 9.193a.5.5 0 0 1 0 .707L3.05 13.657a.5.5 0 0 1-.707-.707l1.414-1.414a.5.5 0 0 1 .707 0zm9.193 2.121a.5.5 0 0 1-.707 0l-1.414-1.414a.5.5 0 0 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .707zM4.464 4.465a.5.5 0 0 1-.707 0L2.343 3.05a.5.5 0 1 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .708z"/>
      </symbol>
    



    
<main class="form-signin w-100 m-auto">
  <form method="post" action="<%=request.getContextPath() %>/Login.do" id="login-form">
    <img class="mb-4" src="<%=request.getContextPath()%>/images/도서01.png" alt="" width="280" height="300">
    <h1 class="h3 mb-3 fw-normal">Login</h1>

    <div class="form-floating">
      <input type="text" class="form-control" id="username" name="userId" placeholder="Username" required>
      <label for="username">Username</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="password" name="userPw" placeholder="Password" required>
      <label for="password">Password</label>
    </div>

  
    <input type="submit" class="create-account-link" value="로그인">

    <div>

    </div>
  
  </form>

  <div id="create-account-wrap" class="text-center mt-3">
    <b><a href="<%=request.getContextPath() %>/Join.do" class="create-account1" >회원가입</a></b><br><br>
    <a href="<%=request.getContextPath() %>/FindId.do" class="find-link">아이디 찾기</a> &nbsp;/&nbsp;
    <a href="<%=request.getContextPath() %>/FindPw.do" class="find-link">비밀번호 찾기</a>
  </div>
  
  
</main>


        
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script>

    // URL 파라미터를 읽어오는 함수
    function getParameterByName(name) {
        name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
        var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
            results = regex.exec(location.search);
        return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
    }

    // 'message' 파라미터가 있는지 확인하고, 있으면 alert 창 띄우기
    var message = getParameterByName('message');
    if(message) {
    	swal("로그인 아웃 되었습니다", "좋은 하루 되세요!", "success");
    }
  
 	// 'error' 파라미터가 있는지 확인하고, 있으면 alert 창 띄우기
    var error = getParameterByName('error');
    if(error === '1') {
        swal("로그인 실패", "비밀번호가 일치하지 않습니다.", "error");
    }else if(error === '2'){
    	swal("경고!", "블랙리스트에 등록되었습니다. 당분간 이용이 불가합니다.", "warning");
    }
    
    </script>


</body>
</html>

 
 