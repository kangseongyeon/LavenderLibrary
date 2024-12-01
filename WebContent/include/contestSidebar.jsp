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
    <h3>참여광장</h3><br>
    <ul>
        <li><a href="<%= request.getContextPath() %>/report/list.do">글쓰기</a></li>
        <li><a href="<%= request.getContextPath() %>/debate/list.do">토론</a></li>
        <li><a href="<%= request.getContextPath() %>/sentence/list.do">1일1문장 쓰기</a></li>
    </ul>
</div>



<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script>

$(function(){
	  
let active = "<%=request.getAttribute("active") %>";


	switch(active){
		case 'listR':
			$('li:nth-of-type(1) > a').addClass('active');
			break;
		case 'listD':
			$('li:nth-of-type(2) > a').addClass('active');
			break;
		case 'listS':
			$('li:nth-of-type(3) > a').addClass('active');
			break;
	}
	
});



</script>


