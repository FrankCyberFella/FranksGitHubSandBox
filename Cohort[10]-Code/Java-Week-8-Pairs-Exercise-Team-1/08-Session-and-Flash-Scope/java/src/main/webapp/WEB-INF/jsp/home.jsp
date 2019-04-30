<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<h1>Buy Some Produce</h1>
		<br>
		
		<c:url var="shoppingCart" value="/shoppingCart"/>
		<a href="${shoppingCart}">View Cart</a>
		
		<h2>Garden Vegetable Seeds</h2>
		<br>
		
		<ul>
		
		
		
			<c:url var="tomatoPage" value="/tomatoProductPage"/>
			<li><a href="${tomatoPage}">Heirloom Tomatoes</a></li>
			<c:url var="bellPepperPage" value="/bellPeppersProductPage"/>
			<li><a href="${bellPepperPage}">Bell Peppers</a></li>
			<c:url var="carrotPage" value="/carrotsProductPage"/>
			<li><a href="${carrotPage}">Carrots</a></li>
			<c:url var="cucumberPage" value="/cucumbersProductPage"/>
			<li><a href="${cucumberPage}">Cucumbers</a></li>
			<c:url var="radishPage" value="/radishesProductPage"/>
			<li><a href="${radishPage}">Radishes</a></li>
		
		</ul>
		
	</body>
</html>