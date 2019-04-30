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
			<input type="text" id="theName" name="name" />  <!-- defines a text input box -->
														 <!--  associate the label theName with this text box -->
			<input type="submit" value="Get Greeting" /> <!-- defining a submit button -->
		</form>
	</body>
</html>