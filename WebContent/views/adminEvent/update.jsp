<%@page import="kr.or.ddit.vo.EventVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
       EventVO ev = (EventVO)request.getAttribute("ev");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>행사 수정</title>
<%@include file="/include/boardDetail.jsp"%>
</head>
<body>
<%@include file="/include/header.jsp"%>
	<div style="margin-top: 20px;"></div>
<%@include file="/include/eventSidebar.jsp"%>
<!-- <div class="content" style="position:relative; left: 200px;"> -->
<div class="container">
		<div class="header">
			<h1>행사정보 수정</h1>
		</div>
   <form action="<%=request.getContextPath() %>/adminEvent/update.do" method="post" enctype="multipart/form-data">
      <table>
		 <tr>
            <th>행사 이름</th>
      
            <td colspan="4"><input type="text" name="eventName"
               value="<%= ev.getEventName() %>"></td>
            <td style="display:none"><input type="hidden" name="eventNo"
               value="<%= ev.getEventNo() %>"></td>
         </tr>
		<tr>	
            <th>행사시작</th>
            <td><input type="text" name="eventDateStr"
               value="<%= ev.getEventDateStr() %>"></td>
               
          </tr>
			<tr>
	            <th>행사종료</th>
    	        <td><input type="text" name="eventDateEnd"
        		       value="<%= ev.getEventDateEnd() %>"></td>
			</tr>    
          <tr>
            <th>신청 시작</th>
            <td><input type="text" name="eventRegDateStr"
               value="<%= ev.getEventRegDateStr() %>"></td>
         </tr>      
         <tr>
         	<th>신청종료</th>
            	<td><input type="text" name="eventRegDateEnd"
               value="<%= ev.getEventRegDateEnd() %>"></td>
         </tr>
         <tr>
            <th>정원</th>
            <td><input type="text" name="eventPeople"
               value="<%= ev.getEventPeople() %>"></td>
         </tr>
         <tr>
         	<th>타입</th>
         	<td><input type="text" name="eventType"
               value="<%= ev.getEventType() %>">
            </td>   
         </tr>
            <tr>
            <th>장소</th>
            <td><input type="text" name="eventPlace"
               value="<%= ev.getEventPlace() %>"></td>
            </tr>
          <tr>      
            <th>내용</th>
            <td colspan="4" class="content_box">
            <input type="text" name="eventContent"
               value="<%=ev.getEventContent() %>" ></td>
         </tr>
         <tr>
            <th>이미지 파일</th>
            <td><input type="file" name="atchFile" multiple="multiple"></td>
         </tr>
      </table>
      <input type="submit" value="수정 완료">
   </form>
   
</div>
      <!-- <colgroup>
         <col style="width:15%">
         <col style="width:35%">
         <col style="width:15%">
         <col style="width:35%">
      </colgroup> -->
        
         
         
   
         
         
        
         
</body>
</html>