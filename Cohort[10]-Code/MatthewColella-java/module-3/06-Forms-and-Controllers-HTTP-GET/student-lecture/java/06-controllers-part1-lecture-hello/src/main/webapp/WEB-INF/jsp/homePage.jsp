<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<c:url value="/greeting" var="formAction" />   <!-- this is gonna be used when form is submitted -->
		<form method="GET" action="${formAction}">
			<label for="theName">Your Name: </label>
			<input type="text" id="theName" name="name" />	 <!-- associates label theName iwth this box -->
															<!--  Defines a text input box -->
															<!-- Store any data in the variable called name -->
			<input type="submit" value="Get Greeting" /> <!-- Define a submit button -->
		</form>
	</body>
</html>