<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<h1>Shopping Cart Exercise</h1>
		
		<h2>Carrots</h2>
		
		<img src="img/carrots.jpg" />

		<p>Price: 24000.99 Rubles per Kg</p>
		
		<form action="carrots" method="POST">
		<label for="carrotQuantity">Quantity</label>
		<input type="text" name="carrotQuantity" placeholder="Enter Quantity" />
		<input type="submit" value="Enter"/>
		</form>
		

	</body>
</html>