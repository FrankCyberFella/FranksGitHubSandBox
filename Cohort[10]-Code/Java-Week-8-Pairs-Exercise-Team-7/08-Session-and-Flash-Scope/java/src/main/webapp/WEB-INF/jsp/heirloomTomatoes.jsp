<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="styleSheet" href="css/site.css"/>
</head>
<body>

	<h1> Shopping Cart Exercise </h1>

	<c:url var="addItem" value="/addToCart" />
	<form method="POST" action="${addItem}">
		<h2>Heirloom Tomatoes</h2>
		<img src="img/tomatoes.jpg" alt="Heirloom Tomatoes"/>
		<h4>Price: $5.99</h4>
		<input type="hidden" name="type" value="heirloomTomatoes">
		<label for="quantity">Quantity:</label>
		<input type="text" name="quantity"/>
		<input class="addToCartButton" type="submit" value="Add To Cart" />
	</form>

</body>
</html>