<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대여 등록</title>
<%@include file="/include/boardDetail.jsp"%>
<style>
@font-face {
    font-family: 'GangwonEdu_OTFBoldA';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/GangwonEdu_OTFBoldA.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
html, body {
    height: 100%;
    margin: 0;
    padding: 0;
}
body {
    font-family: 'GangwonEdu_OTFBoldA';
    display: flex;
    flex-direction: column;
    min-height: 100vh;
}
.content {
    flex: 1 0 auto;
}
footer {
    background-color: #9370DB;
    color: white;
    padding: 15px;
    text-align: center;
    width: 100%;
    flex-shrink: 0;
    z-index: 20;
}
select {        
  appearance: none;
  width: 300px; /* 원하는 너비설정 */
  padding: .5em .8em; /* 여백으로 높이 설정 */
  font-family: inherit;  /* 폰트 상속 */
  background: url('/LavenderLibrary/images/selectImg.png') no-repeat right/10%; /* 네이티브 화살표를 커스텀 화살표로 대체 */
  background-size: 13px;
  padding-right: 0.8em;
  border: 1px solid #999;
  border-radius: 0px; /* iOS 둥근모서리 제거 */
  -webkit-appearance: none; /* 네이티브 외형 감추기 */
  -moz-appearance: none;
  border: 1px solid #999;
  border-radius: 1px;
}
</style>
<script>
function adjustFooter() {
    var content = document.querySelector('.content');
    var footer = document.querySelector('footer');
    var windowHeight = window.innerHeight;
    var contentHeight = content.offsetHeight;
    var footerHeight = footer.offsetHeight;

    // 파일명 확인
    var currentPath = window.location.pathname;
    var isFind = currentPath.includes('find.do');

    if (!isFind && contentHeight + footerHeight < windowHeight) {
        footer.style.position = 'fixed';
        footer.style.bottom = '0';
    } else {
        footer.style.position = 'static';
    }
}

window.addEventListener('load', adjustFooter);
window.addEventListener('resize', adjustFooter);
</script>
</head>
<body>
<%@include file="/include/header.jsp"%>
<div class="content">
    <div style="margin-top: 20px;"></div>
    <div class="container">
        <div class="header">
            <h1>대여 등록</h1>
        </div>
        <form action="<%=request.getContextPath() %>/rental/insert.do" method="post" enctype="multipart/form-data">
            <div style="margin-top: 20px;"></div>
            <table>
                <tr>
                    <th>회원ID</th>
                    <td>
                        <select name="memId">
                            <c:forEach items="${memList}" var="member">
                                <c:if test="${member.banYn == 'N' && member.delYn == 'N'}">
                                    <option value="${member.memId}">${member.memName}(${member.memId})</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>도서ID</th>
                    <td>
                        <select name="bookId">
                            <c:forEach items="${bookList}" var="book">
                                <c:if test="${book.bookRentalYN == 'Y'}">
                                    <option value="${book.bookId}">${book.bookName}(${book.bookId})</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <div class="buttons">
                <button type="submit">대여 등록</button>
                <a href="<%=request.getContextPath()%>/rental/list.do" class="button">목록보기</a>
            </div>
        </form>
    </div>
</div>
<%@include file="/include/footer.jsp"%>
</body>
</html>
