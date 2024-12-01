<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	z-index:10;
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
<footer>
    <p>주소: 대전 중구 계룡로 846 1층 | 전화: 042-000-0000</p>
    <p>&copy; 2024 대전광역시 라벤더도서관. All rights reserved.</p>
</footer>