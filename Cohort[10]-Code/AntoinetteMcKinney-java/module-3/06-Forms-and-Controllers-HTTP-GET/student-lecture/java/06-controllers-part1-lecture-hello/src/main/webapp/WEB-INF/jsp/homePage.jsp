<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<c:url value="/greeting" var="formAction" />
		<form method="GET" action="${formAction}">
			<label for="name">Your Name: </label> <!-- label is text to appear on the page  -->
			<input type="text" id="thename" name="alex" /> <!-- define a text imput box called theName -->
			<input type="submit" value="Get Greeting" /> <!-- associate the label theName with this textBox -->
															<!-- Store any data in the variable called name
															define a submit button -->
		</form>
	</body>
</html>