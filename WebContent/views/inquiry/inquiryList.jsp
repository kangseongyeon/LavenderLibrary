 <%@page import="kr.or.ddit.vo.InquiryVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    List<InquiryVO> inquiryList = (List<InquiryVO>) request.getAttribute("inquiryList");
    String msg = session.getAttribute("msg") == null ? ""
            : (String) session.getAttribute("msg");
    
    session.removeAttribute("msg");
    
    String memId = (String) session.getAttribute("memId");
    
	//페이징처리위해 추가
	List<InquiryVO> list = (List<InquiryVO>) request.getAttribute("list");
	int start = (int) request.getAttribute("start");
	int startPage = (int) request.getAttribute("startPage");
	int endPage = (int) request.getAttribute("endPage");
	int totalPage = (int) request.getAttribute("totalPage");
	int totalCount = (int) request.getAttribute("totalCount");
	int currentPage = (int) request.getAttribute("currentPage");

	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관에 바라다</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@include file="/include/boardList.jsp" %>
<style>
select {        
  appearance: none;
  width: 70px; /* 원하는 너비설정 */
  padding: .8em .5em; /* 여백으로 높이 설정 */
  font-family: inherit;  /* 폰트 상속 */
  background: url('/LavenderLibrary/images/selectImg.png') no-repeat center/10%; /* 네이티브 화살표를 커스텀 화살표로 대체 */
  border: 1px solid #999;
  border-radius: 0px; /* iOS 둥근모서리 제거 */
  -webkit-appearance: none; /* 네이티브 외형 감추기 */
  -moz-appearance: none;
  border: 1px solid #999;
  border-radius: 1px;
}
</style>
</head>
<body>
<%@include file="/include/header.jsp"%>
    <div class="container">
    <%@include file="/include/boardSidebar.jsp"%>
    	<div class="content" style="position:relative; left: 200px;">
    	<br><h1>도서관에 바란다</h1>
    	
	   <!-- 검색창 -->
		<div class = "searchButton">
	   <form action="<%=request.getContextPath()%>/inquiry/search.do" method="post" style="margin: 0;">
			<select name="searchOption" style ="height:25px; margin-right: 13px; padding: 2px;">
				<option value="inqCategoryCode">분류코드</option>
				<option value="memId">작성자</option>
				<option value="inqTitle">제목</option>
			</select>
			<input type="text" name="searchKeyword" placeholder="검색어 입력"
				maxlength="30" style="margin-right: 10px;" required>
			<button type="submit">검색</button>
		</form>
	   </div>
	   
   <table border="1">
      <tr>
         <th>번호</th>
         <th>제목</th>
         <th>분류코드</th>
         <th>작성자</th>
         <th>등록일</th>
         <th>상태</th>
      </tr>
<%
//     int inquirySize = inquiryList.size();
    int inquirySize = list.size();
    if (inquirySize > 0) {
//         for (InquiryVO iv : inquiryList) {
        for (InquiryVO iv : list) {
        	String inqStatus = iv.getInqStatus().equals("진행완료") ? "status-complete" : "status-pending";
%>
      <tr>
         <td><%=iv.getInqNo() %></td>
         <td><a href="<%=request.getContextPath() %>/inquiry/detail.do?inqNo=<%=iv.getInqNo() %>"><%=iv.getInqTitle() %></a></td>
         <td><%=iv.getInqCategoryCode() %></td>
         <td><%=iv.getMemId() %></td>
         <td><%=iv.getInqDate() %></td>
         <%-- <td><%=iv.getInqStatus() %></td> --%>
          <td class="<%= inqStatus %>"><%=iv.getInqStatus() %></td>
      </tr>
<%
        }
    } else {
%>
    <tr>
        <td colspan="6">정보가 없습니다.</td>
    </tr>
<%
    }
%>
   </table>
   
   
   	<!-- 페이징처리 -->
	<div class = "pagingButton">
      <ul class="pagination" style="margin: 0;">
		<%
		for(int i=1 ; i <= totalPage; i++){
		%>
			
	    <li <% if(i==currentPage) {%> class="active" <% } else {}%>><a href="<%=request.getContextPath() %>/inquiry/list.do?page=<%=i%>"><%=i %></a></li>
		<%		
			}
		%>
		
	  </ul>
	</div>
	
	<div class = "writingButton">
	<%
	   if (!"b1a4".equals(memId)) {
	%>
	   <div class="actions">
	      <a href="<%=request.getContextPath() %>/inquiry/insert.do" ><span class="glyphicon glyphicon-pencil"></span>   글 등록</a>
	   </div>
	<%
	   }
	%>
	</div>
<% 
    if (msg.equals("SUCCESS")) { 
%>
    <script>
        alert('정상적으로 처리되었습니다.');
    </script>
<%
    }
%>
</div>
</div>

    <script>
    
     let active = "<%=request.getAttribute("active") %>"
    
    </script>
    
    <%request.setAttribute("active", "inquiryList"); %>
<%@include file="/include/footer.jsp"%>
</body>
</html>
 