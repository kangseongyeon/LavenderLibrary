<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // 현재 페이지 URI를 가져옵니다.
    String currentUri = request.getRequestURI();
%>
<div class="sidebar">
<style>
    .sidebar {
        width: 200px;
        background-color: #f0f0f0;
        padding: 20px;
        position: fixed;
        top: 0;
        bottom: 0;
        left: 20px;
      
        z-index: 5;
    }
    .sidebar h3 {
        color: white;
        background-color: #9370DB;
        padding: 10px;
        margin-top: 0;
    }
    .sidebar ul {
        list-style-type: none;
        padding: 0;
    }
    .sidebar li {
        margin-bottom: 10px;
    }
    .sidebar li a {
        display: block;
        padding: 10px;
        text-decoration: none;
        color: #333;
        transition: background-color 0.3s;
    }
    .sidebar li a.active {
        background-color: #ddd;
    }
    .sidebar li a:hover {
        background-color: #ccc;
    }
</style>
<br><br><br><br><br>
    <h3>도서관소개</h3><br>
    <ul>
        <li><a href="<%= request.getContextPath() %>/library/intro.do">인사말</a></li>
        <li><a href="<%= request.getContextPath() %>/library/info.do">도서관 현황</a></li>
        <li><a href="<%= request.getContextPath() %>/library/find.do">찾아오시는 길</a></li>
        <li><a href="<%= request.getContextPath() %>/library/use.do">이용안내</a></li>
        <hr>
    </ul>
</div>


<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script>

$(function(){
	  
let active = "<%=request.getAttribute("active") %>";


	switch(active){
// 		case 'page1':
		case 'intro':
// 			console.log('in intro');
			$('li:nth-of-type(1) > a').addClass('active');
			break;
// 		case 'page2':
		case 'info':
			$('li:nth-of-type(2) > a').addClass('active');
			break;
// 		case 'page3':
		case 'find':
			$('li:nth-of-type(3) > a').addClass('active');
			break;
// 		case 'page4':
		case 'use':
			$('li:nth-of-type(4) > a').addClass('active');
			break;
	}
	
});



</script>


