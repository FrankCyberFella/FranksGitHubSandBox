<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<c:url value="/greeting" var="formAction" />
		<form method="GET" action="${formAction}">		   <!-- define a form to issue a GET on submit -->
			<label for="theName">Your Name: </label>	   <!-- label is text to appear on the page -->
			<input type="text" id="theName" name="name" /> <!-- define a text input box called name -->
														   <!-- associate the label theName with this textBox -->
														   <!-- store any data in the variable called name -->
			<input type="submit" value="Get Greeting" />   <!-- define a submit button -->
		</form>											   <!-- any form variables are added to the query string on submit -->
	</body>
</html>