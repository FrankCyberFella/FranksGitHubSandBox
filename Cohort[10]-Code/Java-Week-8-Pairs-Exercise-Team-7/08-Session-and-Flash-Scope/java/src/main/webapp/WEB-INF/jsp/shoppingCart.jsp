<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
<link rel = "stylesheet" href ="css/site.css">
</head>
<body>

	<h1>Shopping Cart</h1>
	<table>
		<tr>
			<th>Product</th>
			<th>Price Per Item</th>
			<th>Quantity</th>
			<th>Total Cost</th>
		</tr>
		<c:forEach var="vegetable" items="${cartList}">
		<tr>
			<td>${vegetable.name}</td>
			<td>$${vegetable.price}</td>
			<td>${vegetable.quantity}</td>
			<td>$${vegetable.quantity * vegetable.price}</td>
		</tr>
		</c:forEach>
		<tr>
			<th colspan="3"> Total </th>
			<th> $${cartList.stream().map(vegetable -> vegetable.price * vegetable.quantity).sum()} </th>
		</tr>
			
		</table>
	

</body>
</html>