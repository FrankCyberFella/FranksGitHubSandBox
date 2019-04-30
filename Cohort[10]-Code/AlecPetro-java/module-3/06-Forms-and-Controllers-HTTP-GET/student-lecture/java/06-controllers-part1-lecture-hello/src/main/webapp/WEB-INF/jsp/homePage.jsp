<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<c:url value="/greeting" var="formAction" />		 <!-- Define an always correct URL to use -->
		<form method="GET" action="${formAction}"> 		     <!-- When this form is submitted generate a GET request with /greeting path -->
			<label for="theName">Your Name: </label>		 <!-- Label is text to appear on the page -->
			<input type="text" id="theName" name="name" />	 <!-- Define a text input box called theName -->
															 <!-- Associate the label theName with this textBox -->
															 <!-- Store any data in the variable called name -->
			<input type="submit" value="Get Greeting" />	 <!-- Define a submit button -->
		</form>												 <!-- any form variables are added to query string on submit -->
	</body>
</html>