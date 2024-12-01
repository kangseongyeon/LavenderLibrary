<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	String uId = request.getParameter("id");

	//DB에서 ID검증하기
	//db설치
	//자바와 DB간의 연결을 위해 ojdbc.jar
	//드라이버 로딩
	Class.forName("oracle.jdbc.driver.OracleDriver");
	// 커넥션 객체 및 쿼리실행객체(statement)도 생성
	String url = "jdbc:oracle:thin:@112.220.114.130:1521:xe";
	Connection conn = DriverManager.getConnection(url, "team1_202404M", "java");
	Statement stmt = conn.createStatement();
	String sql = "select mem_id from member where mem_id = '" + uId + "'";
	ResultSet rs = stmt.executeQuery(sql);
	
	if(rs.next()){
		//id존재하므로 사용불가
%>
		{
			"rst" : "fail",
			"msg" : "사용불가"
		}
<%	
	}else{
		//사용가능
%>
		{
			"rst" : "ok",
			"msg" : "사용가능"
		}
<%
	}
	rs.close();
	stmt.close();
	conn.close();
%>