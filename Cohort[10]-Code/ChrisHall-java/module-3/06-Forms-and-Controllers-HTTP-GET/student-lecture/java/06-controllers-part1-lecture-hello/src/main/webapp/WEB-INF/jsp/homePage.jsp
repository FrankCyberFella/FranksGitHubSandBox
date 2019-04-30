<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<c:url value="/greeting" var="formAction" /> <!-- define an always correct URL to use -->
		<form method="GET" action="${formAction}">		<!-- define a form to issue a GET on submit -->
			<label for="theName">Your Name: </label>  <!-- label is text to appear on page-->
			<input type="text" id="theName" name="name" /> <!-- define a text input box called theName-->
			<input type="submit" value="Get Greeting" />  <!-- associate the label theName with thistextBox-->
		</form>		<!-- define a submit button -->		<!-- store any data in the variable called name-->
	</body>						<!-- any form variables are added to query string on submit-->
</html>