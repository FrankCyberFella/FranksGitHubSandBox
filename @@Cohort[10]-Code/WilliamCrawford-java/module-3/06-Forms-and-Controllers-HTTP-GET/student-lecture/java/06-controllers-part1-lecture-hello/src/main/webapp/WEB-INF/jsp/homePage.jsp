<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<c:url value="/greeting" var="formAction" />
		<form method="GET" action="${formAction}">
			<label for="theName">Your Name: </label>
			<input type="text" id="theName" name="alex" />  <!-- define a text input box called name -->
															<!-- associate the label name with this textBox-->
			<input type="submit" value="Get Greeting" />    <!-- Define a submit button -->
		</form>
	</body>
</html>