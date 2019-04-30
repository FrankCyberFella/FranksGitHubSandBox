<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cucumbers</title>
</head>
<body>
<img src="img/cucumbers.jpg"/>
<c:url value="/shoppingCart" var="formAction"/>
<form method= "POST" action= "${formAction}">
<div class= "formInputGroup">
	<label for= "quantity">Quantity</label>
	<input type= "text" name= "quantity" id= "quantity"/>
	<input type= "hidden" name= "type" value ="cucumbers" />
	<input type= "hidden" name= "price" value="1.99"/>
	<input class="formSubmitButton" type ="submit" value= "submit"/>
</form>	
</div>

</body>
</html>