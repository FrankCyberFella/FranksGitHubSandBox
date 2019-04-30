<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<c:url value="/greeting" var="formAction" />
		<form method="GET" action="${formAction}">
			<label for="theName">Your Name: </label>			<!-- Label is text to appear on the page -->
			<input type="text" id="theName" name="name" />	<!-- text input box -->
															<!-- associate the label theName with this text box -->
															<!-- Store any data in the variable called name -->
			<input type="submit" value="Get Greeting" />	<!-- submit button -->
		</form>
	</body>
</html>