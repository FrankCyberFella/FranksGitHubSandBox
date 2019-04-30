<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Shopping Cart</title>
</head>
<body>
<h1>Shopping Cart Contents</h1>
<table>
<tr><th>Product</th><th>Price Per Item</th><th>Quantity</th><th>Total Cost</th></tr>
		<c:forEach var="purchase" items="${vegetables}">
			<table>
				<tr>
					<td>${purchase.name}</td>
					<td>${purchase.itemPrice}</td>
					<td>${purchase.quantity}</td>
					<td>${purchase.totalPrice}</td>
				</tr>
			</table>
		</c:forEach>
<tr><td>Total</td><td>$</td></tr>
</table>

	<ul>
		<li><a href="mainPage">Home Page</a></li>
	</ul>

</body>
</html>