<%@page import="kr.or.ddit.contest.vo.DebateVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	List<DebateVO> debateList = (List<DebateVO>) request.getAttribute("debateList");
	String memId =  session.getAttribute("memId") == null ? "" : (String) session.getAttribute("memId");

	List <DebateVO> list = (List<DebateVO>) request.getAttribute("list");
	int start = (int) request.getAttribute("start");
	int startPage = (int) request.getAttribute("startPage");
	int endPage = (int) request.getAttribute("endPage");
	int totalPage = (int) request.getAttribute("totalPage");
	int totalCount = (int) request.getAttribute("totalCount");
	int currentPage = (int) request.getAttribute("currentPage");

	
	String msg =session.getAttribute("msg") ==null ? "" :
		(String)session.getAttribute("msg");
	
	session.removeAttribute("msg");  
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>토론 목록</title>
<meta charset="utf-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> -->
<!--   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
	<%@include file="/include/boardList.jsp" %>
</head>
<body>
<%@include file="/include/header.jsp"%>
    <div class="container">
 	<%@include file="/include/contestSidebar.jsp"%>
 		<div class="content" style="position:relative; left: 200px;">
 
    <br><h1>토론</h1>
	<div class = "searchButton">
	
		<form name="ss" action="<%=request.getContextPath() %>/debate/search.do" method="post" enctype="multipart/form-data"  style="margin: 0;">
			<select id="sel" name=selValue  style ="height:25px; margin-right: 13px; padding: 2px;">
			    <option value="bookTitle" >도서명</option>
			    <option value="debateTopic">주제</option>
			    <option value="debateContent">내용</option>
		  	</select>
	    
	    <input type="text" name="searchWord" placeholder="검색어 입력"
				maxlength="30" style="margin-right: 10px;" required>
	    <input type="submit" value="검색">
	    </form>
		<script language="JavaScript">
	
		function check_submit(){
			if(ss.selValue.value ==""){
			alert("카테고리를 선택해주세요.");
			ss.selValue.focus(); 
			return false;
			}
		}
		</script>
    </div>
    
	<table border="1" >
		<tr>
			<th>번호</th>
			<th>토론 주제</th>
			<th>도서명</th>
			<th>작성날짜</th>
		</tr>
		
<%
	 	int debateSize = list.size();
		if(debateSize > 0){
			for(DebateVO dv : list){
%>		
		<tr>
			<td><%=dv.getDebateNo() %></td>
			<td><a href="<%=request.getContextPath()%>/debate/detail.do?debateNo=<%=dv.getDebateNo()%>"><%=dv.getDebateTopic() %></a></td>
			<td><%=dv.getBookTitle() %></td>
			<td><%=dv.getDebateDate() %></td>
		</tr>
<%
			}
		}else{
%>				
	<tr align="center">
		<td colspan="4">토론 정보가 존재하지 않습니다.</td>
	</tr>

<%
		}

%>			
	</table>
	
	<!-- 페이징처리 -->
	<div class = "pagingButton">
	<!-- <div style="width:600px;margin-top:5px; text-align:center; "> -->
		<ul class="pagination" style="margin: 0;">
		<%
		for(int i=1 ; i <= totalPage; i++){
		%>
		<%-- <a href="<%=request.getContextPath() %>/report/list.do?page=<%=i%>">&nbsp;<% if(i==currentPage) out.print("["+i+"]"); else out.print(i); %>&nbsp;</a> --%>
		<%--     <li><a href="<%=request.getContextPath() %>/report/list.do?page=<%=i%>"><%=i %></a></li> --%>
    	<li <% if(i==currentPage) {%> class="active" <% } else {}%>><a href="<%=request.getContextPath() %>/debate/list.do?page=<%=i%>"><%=i %></a></li>
		<%		
			}
		%>
		  </ul>
	</div>
	
    <div class = "writingButton">
	<%
		if(memId.equals("b1a4")){
	%>	
		<div class="actions">
			<a href="<%=request.getContextPath() %>/debate/insert.do"><span class="glyphicon glyphicon-pencil"></span>   글 등록</a>
		</div>
	<%
		}
	%>
  </div>
	  
	<%
		if(msg.equals("SUCCESS")){
	%>
	<script>
		alert("정상적으로 처리되었습니다.");
	</script>
	<%		
		}
	%>  
	</div>
 	</div>
    <script>
    	let active = "<%=request.getAttribute("active") %>"
    </script>
    
<%request.setAttribute("active", "listD"); %>
<%@include file="/include/footer.jsp"%>
</body>
</html>