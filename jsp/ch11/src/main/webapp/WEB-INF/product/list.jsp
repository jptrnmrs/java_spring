<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Product :: list</title>
</head>
<body>
	<h3>상품목록</h3>
	<a href="/ch11/">처음으로</a>
	<a href="/ch11/product/register.do">등록</a>
	<table border="1">
		<tr>
			<th>상품번호</th>
			<th>상품명</th>
			<th>재고</th>
			<th>가격</th>
			<th>제조사</th>
			<th>관리</th>
		</tr>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.prodNo}</td>
				<td>${product.prodName}</td>
				<td>${product.stock}</td>
				<td>${product.price}</td>
				<td>${product.company}</td>
				<td>
					<a href="/ch11/product/modify.do?prodNo=${product.prodNo}">수정</a>
					<a href="/ch11/product/delete.do?prodNo=${product.prodNo}">삭제</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>