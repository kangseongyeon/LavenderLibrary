<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신규도서 등록</title>
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
            <h1>도서 등록</h1>
        </div>
        <form action="<%=request.getContextPath() %>/book/insert.do" method="post" enctype="multipart/form-data">
        
            <div style="margin-top: 20px;"></div>
            <table>
                <tr>
                    <th>책 제목</th>
                    <td><input type="text" name="bookName" value=""></td>
                </tr>
                <tr>
                    <th>저자</th>
                    <td><input type="text" name="bookWriter" value=""></td>
                </tr>
                <tr>
                    <th>출판사</th>
                    <td><input type="text" name="bookPublisher" value=""></td>
                </tr>
                <tr>
                    <th>카테고리</th>
                    <td><textarea name="bookCategory"></textarea></td>
                </tr>
                <tr>
                    <th>이미지 파일</th>
                    <td><input type="file" name="atchFile" multiple="multiple"></td>
                </tr>
            </table>
            <div class="buttons">
                <button type="submit">도서 등록</button>
                <a href="<%=request.getContextPath()%>/book/list.do" class="button">목록보기</a>
            </div>
        </form>
    </div>
</div>
<%@include file="/include/footer.jsp"%>
</body>
</html>
