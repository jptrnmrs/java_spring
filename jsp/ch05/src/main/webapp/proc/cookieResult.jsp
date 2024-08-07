<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>cookieResult.jsp</title>
</head>
<body>
	<h3> 쿠키 확인 </h3>
	<%
		Cookie[] cookies = request.getCookies();
	for(Cookie cookie : cookies){ %>
	
	<p>
	쿠키명 : <%= cookie.getName() %> <br>
	쿠키값 : <%= cookie.getValue() %> <br>
	</p>
	<%
	}
	%>
	<a href="../1.cookieTest.jsp">처음으로</a>	
	
</body>
</html>