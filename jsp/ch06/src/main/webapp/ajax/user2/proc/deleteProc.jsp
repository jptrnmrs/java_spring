<%@page import="com.google.gson.JsonObject"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String uid = request.getParameter("uid");

	int rowCount = 0;
	try {
		// 1단계 - JNDI 서비스 객체 생성
		Context ctx = (Context) new InitialContext().lookup("java:comp/env");
				
		// 2단계 - 커넥션 가져오기
		DataSource ds = (DataSource) ctx.lookup("jdbc/studydb");
		Connection conn = ds.getConnection();
				
		// 2단계 - SQL실행 객체 생성
		String sql = "delete from `user2` where uid=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, uid);
		
		// 3단계 - SQL실행
		rowCount = psmt.executeUpdate();		
		
		// 4단계 - 결과처리(SELECT일 경우)
		// 5단계 - 데이터베이스 종료
		psmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}

	JsonObject json = new JsonObject();
	json.addProperty("result", rowCount);
	
	out.print(json.toString());
%>