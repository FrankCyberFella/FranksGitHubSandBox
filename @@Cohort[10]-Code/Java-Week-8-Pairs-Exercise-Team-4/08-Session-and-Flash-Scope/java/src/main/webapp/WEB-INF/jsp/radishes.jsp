<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<h1>Shopping Cart Exercise</h1>
		
		<h2>Radishes</h2>
		
		<img src="img/radishes.jpg" />

		<p>Price: $20 per Grave</p>
		
					<form action="radishes" method="POST">
		<label for="radishQuantity">Quantity</label>
		<input type="text" name="radishQuantity" placeholder="Enter Quantity" />
		<input type="submit" value="Enter"/>
		</form>

	</body>
</html>