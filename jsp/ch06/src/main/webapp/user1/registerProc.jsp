<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="jakarta.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String uid = request.getParameter("uid");
	String name = request.getParameter("name");
	String birth = request.getParameter("birth");
	String hp = request.getParameter("hp");
	String age = request.getParameter("age");
	
	// 데이터베이스 처리
	String host="jbc:mysql://127.0.0.1:3306/studydb";
	String user="root";
	String pass="1234";
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		//1단계 - 데이터베이스 접속
		Connection conn = DriverManager.getConnection(host,user,pass);
		
		//2단계 - SQL 실행객체 생성
		String sql = "insert into `user1` values (?,?,?,?,?);";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, uid);
		psmt.setString(2, name);
		psmt.setString(3, birth);
		psmt.setString(4, hp);
		psmt.setString(5, age);
		
		//3단계 - SQL 실행
		psmt.executeUpdate();
		
		
		//4단계 - 결과처리(Select문의 경우)
		
		//5단계 - 데이터베이스 종료
		psmt.close();
		conn.close();
	
	}catch(Exception e){
	}
		response.sendRedirect("/ch06/user1/list.jsp");
	
%>