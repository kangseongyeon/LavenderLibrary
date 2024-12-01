<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%
   List<MemberVO> memberList = (List<MemberVO>) request.getAttribute("memberList");
   String msg = session.getAttribute("msg") == null ? "" : (String) session.getAttribute("msg");
   session.removeAttribute("msg"); // 한번 사용한 데이터 삭제


   //페이징
   List<MemberVO> list = (List<MemberVO>) request.getAttribute("list");
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
<title>블랙리스트 목록</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> -->
<!--   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
<style>
html, body {
   height: 100%;
   margin: 0;
   padding: 0;
}

body {
   display: flex;
   flex-direction: column;
}

.content-wrapper {
   flex: 1 0 auto;
   display: flex;
}

.main-content {
   flex: 1;
   padding: 20px;
}

.book-image {
   width: 100px;
   height: 150px;
   object-fit: cover;
}
.pagingButton {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-top: 20px;
	margin-bottom: 10px;
	flex-direction: column;
	width: 100%;
}
.li
</style>
</head>
<body>
   <%@include file="/include/header.jsp"%>

   <div class="content-wrapper">
      <!-- Main Content -->
      <main class="main-content">
         <table class="table table-hover">
            <thead>
               <tr>
                  <th>회원ID</th>
                  <th>이름</th>
                  <th>전화번호</th>
                  <th>E-mail</th>
                  <th>생일</th>
                  <th>주소</th>
                  <th>상세 주소</th>
                  <th>우편번호</th>
                  <th>경고 횟수</th>
                  <th></th>
               </tr>
            </thead>
            <tbody>
               <%
         //          int memSize = memberList.size();
                  int memSize = list.size();
               if (memSize > 0) {
         //          for (MemberVO mv : memberList) {
                  for (MemberVO mv : list) {
               %>
               <tr>
                  <td><a href="<%=request.getContextPath()%>/member/detail.do?memId=<%=mv.getMemId()%>"><%=mv.getMemId()%></a></td>
                  <td><%=mv.getMemName()%></td>
                  <td><%=mv.getMemTel()%></td>
                  <td><%=mv.getMemEmail()%></td>
                  <td><%=mv.getMemBir()%></td>
                  <td><%=mv.getMemAddr1()%></td>
                  <td><%=mv.getMemAddr2()%></td>
                  <td><%=mv.getMemPostno()%></td>
                  <td><%=mv.getWarnCnt()%></td>
                  <td><a href="<%=request.getContextPath()%>/admin/delBlack.do?memId=<%=mv.getMemId()%>">철회</a></td>
               </tr>
               <%
                  }
               } else {
               %>
               <tr align="center">
                  <td colspan="7">블랙리스트 회원이 존재하지 않습니다.</td>
               </tr>
         
               <%
                  }
               %>
            </tbody>
         </table>
   
         <!-- 페이징처리 -->
         <div class = "pagingButton">
		        <ul class="pagination" style="margin: 0;">
            <%
            for(int i=1 ; i <= totalPage; i++){
            %>
                 <li <% if(i==currentPage) {%> class="active" <% } else {}%>><a href="<%=request.getContextPath() %>/main/listBlack.do?page=<%=i%>"><%=i %></a></li>
            <%      
            }
            %>
               </ul>
         </div>
         
         <%
            if (msg.equals("SUCCESS")) {
         %>
         <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
         <script>
            swal("성공!", "정상적으로 처리 되었습니다.", "success");
         </script>
         <%
            }
         %>
         
      </main>
   </div>

         

   <%@include file="/include/footer.jsp"%>
   
   <script>
      function adjustFooter() {
         var docHeight = document.documentElement.offsetHeight;
         var windowHeight = window.innerHeight;
         var footer = document.querySelector('footer');

         if (docHeight <= windowHeight) {
            footer.style.position = 'fixed';
            footer.style.bottom = '0';
            footer.style.width = '100%';
         } else {
            footer.style.position = 'static';
         }
      }

      window.addEventListener('load', adjustFooter);
      window.addEventListener('resize', adjustFooter);
   </script>



</body>
</html>