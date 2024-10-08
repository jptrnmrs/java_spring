<%@page import="user1.User1VO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
		// 데이터 수신
		String uid = request.getParameter("uid");

		// 데이터베이스 처리
		String host="jdbc:mysql://127.0.0.1:3306/studydb";
		String user="root";
		String pass="1234";

		User1VO vo = new User1VO();
	try{

		// 1단계 - JDBC 드라이버 로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2단계 - 데이터베이스 접속
		Connection conn = DriverManager.getConnection(host,user,pass);

		// 3단계 - SQL 실행객체 생성
		String sql = "Select * from `user1` where `uid`=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, uid);
		
		// 4단계 - SQL 실행
		ResultSet rs = psmt.executeQuery();
		
		// 5단계 - 결과처리(Select문의 경우)
		if(rs.next()){
			User1VO sv = new User1VO();
			sv.setUid(rs.getString(1));
			sv.setName(rs.getString(2));
			sv.setBirth(rs.getString(3));
			sv.setHp(rs.getString(4));
			sv.setAge(rs.getInt(5));
			vo=sv;
		}
		
		// 6단계 - 데이터베이스 종료
		rs.close();
		psmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}



%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User1 :: modify</title>
</head>
<body>
	<h3>User1 수정</h3>
	<a href="/ch06/1.JDBCTest.jsp">처음으로</a> 
	<a href="/ch06/user1/list.jsp">목록</a>

	<form action="/ch06/user1/modifyProc.jsp" method="post">
	<table border="1">
	<tr>
		<td>아이디</td>
		<td><input type="text" name="uid" value="<%= vo.getUid() %>" readonly></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="name" value="<%= vo.getName() %>"></td>
	</tr>
	<tr>
		<td>생년월일</td>
		<td><input type="date" name="birth" value="<%= vo.getBirth() %>"></td>
	</tr>
	<tr>
		<td>휴대폰</td>
		<td><input type="tel" name="hp" value="<%= vo.getHp() %>"></td>
	</tr>
	<tr>
		<td>나이</td>
		<td><input type="number" name="age" value="<%= vo.getAge() %>"></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><input type="submit" value="수정하기"> </td>
	</tr>
	</table>
	</form>
</body>
</html>