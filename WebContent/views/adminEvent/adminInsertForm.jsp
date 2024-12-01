<%@page import="kr.or.ddit.vo.EventVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	EventVO ev = (EventVO)request.getAttribute("mv");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관 행사 등록</title>
<%@include file="/include/boardDetail.jsp"%>
</head>
<body>
<%@include file="/include/header.jsp"%>
	<div style="margin-top: 20px;"></div>
	<div class="container">
    <div class="header">
    <h1>행사 등록</h1>
	</div>
	<form action="<%=request.getContextPath() %>/adminEvent/insert.do" method="post" enctype="multipart/form-data">
	<div style="margin-top: 20px;"></div>
		<table>
			<tr>
				<th>행사 이름</th>
				<td><input type="text" name="eventName" value=""></td>
			</tr>
			<tr>
				<th>행사 타입</th>
				<td>
				<!-- <input type="text" name="eventType" value=""> -->
				<form name="ss"  method="post" enctype="multipart/form-data"  style="margin: 0;">
					<select id="sel" name="eventType"  style ="height:25px; margin-right: 13px; padding: 2px;">
			   			 <option value="library" >library</option>
			   			 <option value="movie">movie</option>
			   			 <option value="fieldstudy">fieldstudy</option>
			   			 <option value="hoilday">hoilday</option>
		  			</select>
	    		</form>
				</td>
			</tr>
				
				<tr>
				<th>표지</th>
				<td><input type="text" name="imgId" value="" ></input></td>
				</tr>
			<tr>
				<th>행사 기간 :</th>
				<td><input type="text" name="eventDateStr" value="">~
				<input type="text" name="eventDateEnd" value=""></td>
			</tr>
			<tr>
				<th>정원:</th>
				<td><input type="text" name="eventPeople" value=""></td>
			</tr>
			<tr>
				<th>신청기간:</th>
				<td><input type="text" name="eventRegDateStr" value="">~<input type="text" name="eventRegDateEnd" value=""></td>
			</tr>
			<tr>
				<th>장소:</th>
				<td><input type="text" name="eventPlace" ></input></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="eventContent" ></textarea></td>
			</tr>
			<tr>
				<th>이미지 파일</th>
				<td><input type="file" name="atchFile" multiple="multiple"></td>
			</tr>
		</table>
		<div class="buttons">
		<input type="submit" value="행사 등록">
		</div>
		</form>
		</div>
		<%@include file="/include/footer.jsp"%>
</body>
</html>