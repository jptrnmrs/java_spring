<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>3.Loop</title>
	<%--
		날짜 : 2024.08.05.
		이름 : 김주경
		내용 : 반복문 실습하기
	 --%>
	</head>
	<body>
	<h3>3. 반복문</h3>
	<h4> for</h4>
	<%
		for(int i= 1 ; i <=3;i++){
			out.println("<p>i : "+ i +"</p>");
		}	
	%>
	<h4>while</h4>
	<%
		int k = 1;
		while(k<=3){
	%>
	<p>k:<%= k %></p>
	<%
		k++;
		}
	%>
	
	
	<h4>구구단</h4>
	
	<table border="1">
	<tr>
	<% for(int i = 2 ; i<10 ; i++){ %>
	<th scope="col"><%= i %>단</th>
	<%} %>
	</tr>
	<% for(int j = 1; j<10;j++){ %>
	<tr>
		<% for(int i = 2 ; i<10;i++){ %>
		<td><%= i %>x <%= j %> = <%= i*j %></td>
		<% } %>
	</tr>	
	<%} %>
	</table>
	
	
</body>
</html>