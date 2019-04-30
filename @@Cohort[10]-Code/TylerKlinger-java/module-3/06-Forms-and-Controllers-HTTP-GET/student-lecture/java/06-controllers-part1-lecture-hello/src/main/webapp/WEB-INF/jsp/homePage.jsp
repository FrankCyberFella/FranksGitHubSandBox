<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
	<h1>Home Page</h1>
		<c:url value="/greeting" var="formAction" />		<!-- defines an always-correct url to use -->
		<form method="GET" action="${formAction}">			<!-- define a form to issue a GET on submit -->
			<label for="theName">Your Name: </label>		<!-- Label is text to appear on the page -->
			<input type="text" id="theName" name="name" /> <!--  Define a text input box called name -->
															<!--  associate the label theName with textBox -->
			<input type="submit" value="Get Greeting" /> <!--  define a submit button -->
		</form>											<!--  form variables are added to query string -->
	</body>												<!-- 		on submit -->
</html>