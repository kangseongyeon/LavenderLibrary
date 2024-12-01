<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class = "faq">
<style>
	.container {
        max-width: 800px;
        margin: 0 auto;
    }
    .question {
        background-color: #9986b3;
        border: 1px solid #ddd;
        padding: 15px;
        cursor: pointer;
        position: relative;
        margin-top: 10px;
        font-weight : bold;
		width: 1020px;        
    }
    .question:hover {
        background-color: #c4bee2;
    }
    .answer {
        display: none;
        border: 1px solid #ddd;
        border-top: none;
        padding: 15px;
        background-color: #fff;
        width: 1020px;        
    }
    .answer p {
        margin: 0;
    }
    .actions {
    text-align: right;
    }
    .actions a {
        margin-left: 10px;
        padding: 10px 20px;
        text-decoration: none;
        background-color: #9986b3;
        color: white;
        border-radius: 5px;
        font-size: 14px;
    }
    .actions a:hover {
        background-color: #c4bee2;
    }
    .item {
        position: relative;
    }
    .buttons {
        margin-top: 10px;
    }
    .buttons a {
        margin-left: 10px;
        padding: 5px 10px;
        text-decoration: none;
        background-color: #9986b3;
        color: white;
        border-radius: 5px;
        font-size: 12px;
    }
    .buttons a:hover {
        background-color: #c4bee2;
    }
</style>
</div>