<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<c:url value="/greeting" var="formAction" />		<!-- Define an always correct URL to use -->
		<form method="GET" action="${formAction}">			<!-- Define a form to issue a GET on submit -->
			<label for="theName">Your Name: </label>		<!-- Label you want to appear on the page -->
			<input type="text" id="theName" name="name" />  <!-- Define a text input box called name -->
															<!-- Store any data in the variable called "name" -->
															<!-- associate the label "theName" with this text box -->
			<input type="submit" value="Get Greeting" /> 	<!-- Define a submit button -->
		</form>												<!-- Any form variables are added to the query string on submit -->
	</body>
</html>