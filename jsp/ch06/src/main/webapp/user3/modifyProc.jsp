<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="jakarta.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String uid = request.getParameter("uid");
	String name = request.getParameter("name");
	String birth = request.getParameter("birth");
	String hp = request.getParameter("hp");
	String addr = request.getParameter("addr");
	
	// 데이터베이스 처리
	String host="jdbc:mysql://127.0.0.1:3306/studydb";
	String user="root";
	String pass="1234";
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		//1단계 - 데이터베이스 접속
		Connection conn = DriverManager.getConnection(host,user,pass);
		
		//2단계 - SQL 실행객체 생성
		String sql = "update `user3` set"
				   + "`name`=?,`birth`=?,`hp`=?,`addr`=?"
				   + "where `uid`=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, name);
		psmt.setString(2, birth);
		psmt.setString(3, hp);
		psmt.setString(4, addr);
		psmt.setString(5, uid);
		
		//3단계 - SQL 실행
		psmt.executeUpdate();
		
		
		//4단계 - 결과처리(Select문의 경우)
		
		//5단계 - 데이터베이스 종료
		psmt.close();
		conn.close();
	
	}catch(Exception e){
	}
		response.sendRedirect("/ch06/user3/list.jsp");
	
%>