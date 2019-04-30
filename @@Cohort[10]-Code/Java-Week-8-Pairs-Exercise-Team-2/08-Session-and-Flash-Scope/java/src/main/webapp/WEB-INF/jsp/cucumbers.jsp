<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cucumbers</title>
</head>
<body>
<h1>Cucumbers</h1>
<div><img id="image" src= "img/cucumbers.jpg"></div>
<div>Price: $2.99</div>
<c:url value="/shoppingCart" var="formAction"/>
<form method="POST" action="${formAction}">

	<div class="formInputGroup">
		<label for="quantity">Quantity</label> 
		<input type="text" name="quantity" id="quantity" />
		<input class="formSubmitButton" type="submit" value="SUBMIT" />
	</div>
		
	<ul>
		<li><a href="mainPage">Home Page</a></li>
	</ul>	
		
</form>
</body>
</html>