<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<h1>Shopping Cart Exercise</h1>
		
		<h2>Cucumber</h2>
		
		<img src="img/cucumbers.jpg" />

		<p>Price: $700 per ton</p>
		
			<form action="cucumbers" method="POST">
		<label for="cucumberQuantity">Quantity</label>
		<input type="text" name="cucumberQuantity" placeholder="Enter Quantity" />
		<input type="submit" value="Enter"/>
		</form>

	</body>
</html>