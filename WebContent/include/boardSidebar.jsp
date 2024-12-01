<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <h3>커뮤니티</h3><br>
    <ul>
        <li><a href="<%= request.getContextPath() %>/notice/list.do">공지사항</a></li>
        <li><a href="<%= request.getContextPath() %>/inquiry/list.do">도서관에 바란다</a></li>
        <li><a href="<%= request.getContextPath() %>/faq/list.do">FAQ</a></li>
        <li><a href="<%= request.getContextPath() %>/bookVideo/list.do">도서 소개영상</a></li>
        <li><a href="<%= request.getContextPath() %>/news/list.do">도서 소식지</a></li>
    </ul>
</div>



<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script>

$(function(){
	  
let active = "<%=request.getAttribute("active") %>";


	switch(active){
		case 'noticeList':
			$('li:nth-of-type(1) > a').addClass('active');
			break;
		case 'inquiryList':
			$('li:nth-of-type(2) > a').addClass('active');
			break;
		case 'faqList':
			$('li:nth-of-type(3) > a').addClass('active');
			break;
		case 'bookVideoList':
			$('li:nth-of-type(4) > a').addClass('active');
			break;
		case 'newsList':
			$('li:nth-of-type(5) > a').addClass('active');
			break;
	}
	
});



</script>
