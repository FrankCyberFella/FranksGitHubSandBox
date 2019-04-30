<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cucumbers</title>
</head>
<body>

<h1>Shopping Cart Exercise</h1>
<br>
<h3>Cucumbers</h3>
<img src="img/cucumbers.jpg">
<p>Price: $0.99</p>

<form method="POST" action="home">
	<label for="quantitySelector">Quantity: </label> 
	<input type="text" name="quantity" id="quantitySelector"/>
	<input type="hidden" name="type" value="cucumber"/>
	
	<input type="submit" value="Add to Cart"/>
</form>
<br>
<c:url var="homePage" value="/home"/>
<a href="${homePage}">Return to Catalog</a>
</body>
</html>