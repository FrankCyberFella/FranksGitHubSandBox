<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<c:url value="/greeting" var="formAction" />
		<form method="GET" action="${formAction}">
			<label for="theName">Your Name: </label>         <!-- Label is text to appear on the page -->
			<input type="text" id="theName" name="name" />   <!-- Defines a text input box -->
															 <!-- Store any data in the variable name="name" -->
			<input type="submit" value="Get Greeting" />     <!-- Defines a submit button -->
		</form>
	</body>
</html>