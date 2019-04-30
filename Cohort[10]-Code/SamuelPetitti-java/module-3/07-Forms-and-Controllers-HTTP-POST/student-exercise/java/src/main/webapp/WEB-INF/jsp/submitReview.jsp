<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Squirrel Cigar Party Reviews</title>
 <c:url value="/CSS/site.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>
<img src="etc/forDummies.png"/>
<body>
<c:url var="formAction" value= "/submitReview"/>
<form method= "POST" action="${formAction}">
<div>
<label for = "username">Enter Username:</label>
<input type="text" name = "username" id= "username"/>
</div>
<div>
<label for= "rating">Enter Rating:</label>
<select name="rating" id="rating">
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
</select>
</div>
<div>
<label for= "title">Enter Review Title:</label>
<input type="text" name = "title" id= "title"/>
</div>
<div>
<label for= "review">Enter Review:</label>
<textarea id="review" name="review" rows="5" cols="25" >
</textarea>
<input class="formSubmitButton" type="submit" value="Submit" />
</div>
</form>

</body>
</html>