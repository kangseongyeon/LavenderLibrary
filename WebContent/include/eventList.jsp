<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class = "list">
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
}
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
.content-wrapper {
	flex: 1 0 auto;
	display: flex;
}

.main-content {
	flex: 1;
}
.book-image {
	width: 100px;
	height: 150px;
	object-fit: cover;
}
.movie-image {
	width: 100px;
	height: 150px;
	object-fit: cover;
}
.actions {
	text-align: right;
}
.book-image {
	width: 100px;
	height: 150px;
	object-fit: cover;
}
.actions a {
	margin-left: 20px;
	padding: 12px 15px;
	text-decoration: none;
	background-color: #9986b3;
	color: white;
	border-radius: 5px;
	font-size: 14px;
}

.actions a:hover {
	background-color: #c4bee2;
}
.searchButton {
	display: flex;
	justify-content: space-between; 
	align-items: center; 
	margin-bottom: 20px; 
	flex-direction: row-reverse; 
	width: 90%;
}
.pagingButton {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-top: 20px;
	margin-bottom: 10px;
	flex-direction: column;
	width: 90%;
}
.writingButton{
	display: flex;
	justify-content: space-between; 
	align-items: center; 
	margin-bottom: 20px; 
	flex-direction: row-reverse; 
	width: 90%;
}
</style>
</div>