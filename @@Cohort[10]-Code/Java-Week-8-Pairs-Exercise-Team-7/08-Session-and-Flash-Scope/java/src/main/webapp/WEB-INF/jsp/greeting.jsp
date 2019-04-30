<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Shopping Cart Exercise</title>
	</head>
	<link rel="styleSheet" href="css/site.css"/>
	<body>
	<h1> Shopping Cart Exercise </h1>
	<div>
	<c:url var = "viewCart" value = "/shoppingCart"/>  
	<a href = "${viewCart}" > View Cart </a>
	</div>
		<h1>Garden Vegetable Seeds</h1>
		<ul>
			<li>	
			<c:url var = "bellPeppers" value = "/bellPeppers"/>  
		<a href = "${bellPeppers}" > Bell Peppers </a>
			</li>
			<li>	
			<c:url var = "carrots" value = "/carrots"/>  
		<a href = "${carrots}" > Carrots </a>
			</li>
			<li>	
			<c:url var = "cucumbers" value = "/cucumbers"/>  
		<a href = "${cucumbers}" > Cucumbers </a>
			</li>
			<li>	
			<c:url var = "heirloomTomatoes" value = "/heirloomTomatoes"/>  
		<a href = "${heirloomTomatoes}" > Heirloom Tomatoes </a>
			</li>
			<li>	
			<c:url var = "radishes" value = "/radishes"/>  
		<a href = "${radishes}" > Radishes </a>
			</li>	
		</ul>
	</body>
</html>