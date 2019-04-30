<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<h1>Shopping Cart Exercise</h1>
		
		<h2>Heirloom Tomatoes</h2>
		
		<img src="img/tomatoes.jpg" />

		<p>Price: $2,719 per 5000 seeds</p>
		
				<form action="tomatoes" method="POST">
		<label for="tomatoQuantity">Quantity</label>
		<input type="text" name="tomatoQuantity" placeholder="Enter Quantity" />
		<input type="submit" value="Enter"/>
		</form>

	</body>
</html>