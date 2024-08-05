<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	<%--
		날짜 : 2024.08.05.
		이름 : 김주경
		내용 : JSP 개요 및 개발 환경 구축하기
	 --%>
	</head>
<body>
	<h3>1. 스크립트 요소</h3>
	<h4>스크립트릿(Scriptlet)</h4>
	
	<%
		int		var1 = 1;
		boolean var2 = true;
		double	var3 = 3.14;
		String 	var4 = "Hello";
		
		out.println("<p>var1 : " + var1 + "</p>");
		out.println("<p>var2 : " + var2 + "</p>");
	%>
	
	<h4>표현식(Expression)</h4>
	<p><%= var3 %></p>
	<p><%= var4 %></p>
</body>
</html>