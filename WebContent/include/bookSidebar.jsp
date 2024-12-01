<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<div class="sidebar">
    <br><br><br><br><br>
<div className="sidebar-skeleton">
    <h3>도서 정보</h3><br>
    <ul>
        <li><a href="<%= request.getContextPath() %>/book/list.do">전체도서</a></li>
        <li><a href="<%=request.getContextPath()%>/book/newList.do">신작도서</a></li>
        <li><a href="<%=request.getContextPath()%>/book/popularList.do">베스트</a></li>
    </ul>
</div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script>

$(function(){
	  
let active = "<%=request.getAttribute("active") %>";


	switch(active){
// 		case 'page1':
		case 'list':
			$('li:nth-of-type(1) > a').addClass('active');
			break;
// 		case 'page2':
		case 'newList':
			$('li:nth-of-type(2) > a').addClass('active');
			break;
// 		case 'page3':
		case 'popularList':
			$('li:nth-of-type(3) > a').addClass('active');
			break;

	}
	
});



</script>