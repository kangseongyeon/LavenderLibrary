<%@ page import="kr.or.ddit.vo.NoticeVO"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    List<NoticeVO> noticeList = (List<NoticeVO>) request.getAttribute("noticeList");

    String msg = session.getAttribute("msg") == null ? "" : (String) session.getAttribute("msg");
    session.removeAttribute("msg");

    String memId = (String) session.getAttribute("memId");

    // 페이징 처리를 위해 추가
    List<NoticeVO> list = (List<NoticeVO>) request.getAttribute("list");
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
    <title>공지목록</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ include file="/include/boardList.jsp" %>
</head>

<body>
    <%@ include file="/include/header.jsp" %>
    <div class="container">
        <%@ include file="/include/boardSidebar.jsp" %>
        <div class="content" style="position:relative; left: 200px;">
        	<br><h1>공지사항</h1>
        	
			    <!-- 검색창 -->
        	<div class = "searchButton">
			    <form action="<%=request.getContextPath()%>/notice/search.do" method="post" style="margin: 0;">
			        <input type="text" name="searchKeyword" placeholder="제목 입력" maxlength="30" style="margin-right: 10px;" required>
			        <button type="submit">검색</button>
			    </form>
		    </div>
		    
            <table border="1">
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>등록일</th>
                </tr>
                <%
                    if (noticeList != null && !noticeList.isEmpty()) {
                        for (NoticeVO nv : noticeList) {
                %>
                <tr>
                    <td>
                    	공지
                    <img src="<%=request.getContextPath()%>/images/공지.png" alt="공지" width="20" height="20">
                    </td>
                    <td><a href="<%=request.getContextPath() %>/notice/detail.do?noticeNo=<%=nv.getNoticeNo() %>"><%=nv.getNoticeTitle() %></a></td>
                    <td><%=nv.getAdmId() %></td>
                    <td><%=nv.getNoticeDate() %></td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="4">공지정보가 없습니다.</td>
                </tr>
                <%
                    }
                %>
                <%
                    if (list != null && !list.isEmpty()) {
                        for (NoticeVO nv : list) {
                %>
                <tr>
                    <td><%=nv.getNoticeNo() %></td>
                    <td><a href="<%=request.getContextPath() %>/notice/detail.do?noticeNo=<%=nv.getNoticeNo() %>"><%=nv.getNoticeTitle() %></a></td>
                    <td><%=nv.getAdmId() %></td>
                    <td><%=nv.getNoticeDate() %></td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="4">공지정보가 없습니다.</td>
                </tr>
                <%
                    }
                %>
            </table>

            
    		<!-- 페이징 처리 -->
		    <div class = "pagingButton">
		        <ul class="pagination" style="margin: 0;">
		            <%
		                for (int i = 1; i <= totalPage; i++) {
		            %>
		            <li <%= (i == currentPage) ? "class='active'" : "" %>><a href="<%=request.getContextPath() %>/notice/list.do?page=<%=i%>"><%=i %></a></li>
		            <%
		                }
		            %>
		        </ul>
		    </div>

		    <!-- 글 등록 버튼 (관리자일 경우에만 표시) -->
		    <div class = "writingButton">
		    <%
		        if ("b1a4".equals(memId)) {
		    %>
		    <div class = "actions">
		        <a href="<%=request.getContextPath() %>/notice/insert.do"><span class="glyphicon glyphicon-pencil"></span>   글 등록</a>
		    </div>
		    <%
		        }
		    %>
			</div>

		<%
		    if ("SUCCESS".equals(msg)) {
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

<%request.setAttribute("active", "noticeList"); %>
<%@ include file="/include/footer.jsp" %>
</body>
</html>