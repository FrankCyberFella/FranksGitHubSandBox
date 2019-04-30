<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<h1>Shopping Cart Exercise</h1>
		
		<h2>Bell Peppers</h2>
		
		<img src="img/peppers.jpg" />

		<p>Price: $5.99</p>
		
		<form action="bellPeppers" method="POST">
		<label for="bellPepperQuantity">Quantity</label>
		<input type="text" name="bellPepperQuantity" placeholder="Enter Quantity" />
		<input type="submit" value="Enter"/>
		
		
		
		</form>

	</body>
</html>