<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<link href="<c:url value="/css/site.css"/>" rel="stylesheet" type="text/css" />
		<title>Submit A Review</title>
	</head>
	<body>
		<nav>
		<ul id="link">
			<li><img id="forDummies" src="img/forDummies.png"/><a href="homePage">Home Page (Reviews)</a></li>
		</ul>
		</nav>
			<div id="submitPageHeader">Submit a Review for 'Squirrel Cigar Parties for Dummies'!</div>
		
	<c:url value="/homePage" var="formAction"/>
	
	<form method="POST" action="${formAction}">

	<div class="formInputGroup">
		<label for="username">Username</label> 
		<input type="text" name="username" id="username" />
	</div>
	
	<div class="formInputGroup">
		<label for="rating">Rating [1-5 Stars]</label> 
		<input type="text" name="rating" id="rating" />
	</div>
	
	<div class="formInputGroup">
		<label for="reviewTitle">Review Title</label> 
		<input type="text" name="reviewTitle" id="reviewTitle"/>
	</div>
	
	<div class="formInputGroup">
		<label for="reviewText">Review Text</label> 
		<textarea cols="25" rows="5" name="reviewText" id="reviewText">
		</textarea>
	</div>
	
	<input id="submit" class="formSubmitButton" type="submit" value="SUBMIT" />
	
	</form>	
	</body>
</html>