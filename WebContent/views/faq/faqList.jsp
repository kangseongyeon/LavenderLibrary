<%@page import="kr.or.ddit.vo.FaqVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    List<FaqVO> faqList = (List<FaqVO>) request.getAttribute("faqList");

    String msg = session.getAttribute("msg") == null ? ""
            : (String) session.getAttribute("msg");

    session.removeAttribute("msg");
    String memId = (String) session.getAttribute("memId");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@include file="/include/boardFaq.jsp"%>
</head>
<body>
<%@include file="/include/header.jsp"%>
    <div class="container">
    <%@include file="/include/boardSidebar.jsp"%>
    <br><h1  style="position:relative; left : 15px;">FAQ</h1><br>
        <div class="content" style="position:relative; left : 5px;">
	
<div class="container">
<%
    int faqSize = faqList.size();
    if (faqSize > 0) {
        for (int i = 0; i < faqSize; i++) {
            FaqVO faq = faqList.get(i);
%>
    <div class="item">
        <div class="question" id="question-<%=i %>">
            <strong style = "color : white;">Q.</strong> <%= faq.getFaqQuestion() %>
        </div>
        <div class="answer" id="answer-<%=i %>">
            <p><strong  style = "color : #9986b3;">A.</strong> <%= faq.getFaqAnswer() %></p>
            <% if ("b1a4".equals(memId)) { %>
            <div class="buttons">
                <a href="<%=request.getContextPath() %>/faq/update.do?faqNo=<%= faq.getFaqNo() %>">수정</a>
                <a href="<%=request.getContextPath() %>/faq/delete.do?faqNo=<%= faq.getFaqNo() %>">삭제</a>
            </div>
            <% } %>
        </div>
    </div>
<%
        }
%>
</div>

<script>
    $(document).ready(function() {
        $(document).on('click', '.question', function() {
            var answer = $(this).next('.answer'); 
            $('.answer').not(answer).slideUp(); 
            answer.slideToggle();
        });
    });
</script>

<%
    } else {
%>
    <p>FAQ 정보가 없습니다.</p>
<%
    }
%>
<br>
<div class = "writingButton">
<%
   if ("b1a4".equals(memId)) {
%>
   <div class="actions">
      <a href="<%=request.getContextPath() %>/faq/insert.do"><span class="glyphicon glyphicon-pencil"></span>   글 등록</a>
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
<div style="height: 100px;"></div>
</div>

    <script>
    
    
     let active = "<%=request.getAttribute("active") %>"
     
     
    
    </script>
    
    <%request.setAttribute("active", "faqList"); %>
<%@include file="/include/footer.jsp"%>
</body>
</html>
