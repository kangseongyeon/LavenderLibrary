<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="list">
<style>
table {
	border: 3px solid #c4bee2;
	width: 90%;
	table-layout: fixed;
	/* margin: auto; */
}
th {
	background-color: #e0dbef;
	word-wrap: break-word;
	text-align: center !important;
}
th:first-child {
	width: 7%;
}
th:nth-child(2){
	width: 45%
}

td {
	text-align: center;
	word-wrap: break-word;
}
select {        
  appearance: none;
  width: 70px; /* 원하는 너비설정 */
  padding: .8em .5em; /* 여백으로 높이 설정 */
  font-family: inherit;  /* 폰트 상속 */
  background: url('/LavenderLibrary/images/selectImg.png') no-repeat right/10%; /* 네이티브 화살표를 커스텀 화살표로 대체 */
  border: 1px solid #999;
  border-radius: 0px; /* iOS 둥근모서리 제거 */
  -webkit-appearance: none; /* 네이티브 외형 감추기 */
  -moz-appearance: none;
  border: 1px solid #999;
  border-radius: 1px;
}
.actions {
	text-align: right;
}

.actions a {
    margin-left: 20px;
    padding: 10px 18px;
    text-decoration: none;
    background-color: #9986b3;
    color: white;
    border-radius: 5px;
    font-size: 14px;
    display: flex;
    justify-content: center;
    /* align-items: center; */
    margin-top: 5px;
    margin-bottom: 10px;
    flex-direction: row;
    flex-wrap: nowrap;
    align-content: flex-start;
}
.actions a:hover {
	background-color: #c4bee2;
}

.status-complete {
	color : grqy;
}
.status-pending {
	color : red;
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

.searchButton2 {
	display: flex;
	justify-content: space-between; 
	align-items: center; 
	margin-bottom: 20px; 
	flex-direction: row-reverse; 
}
.pagingButton2 {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-top: 20px;
	margin-bottom: 10px;
	flex-direction: column;
}
.writingButton2{
	display: flex;
	justify-content: space-between; 
	align-items: center; 
	margin-bottom: 20px; 
	flex-direction: row-reverse; 
}
.searchButton{
	display: flex;
	justify-content: space-between; 
	align-items: center; 
	margin-top: 20px; 
	flex-direction: row-reverse; 
}
</style>
</div>