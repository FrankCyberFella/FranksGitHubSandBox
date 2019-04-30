<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Favorite Things Exercise</title>
	</head>
	<body>
		<h1>Favorite Things Exercise </h1>
		
		<h2>What is your favorite food?</h2>

	<c:url var="formAction" value="/page3" />
	<form method="POST" action="${formAction}">


		<div class="formInputGroup">
			<label for="userNameLabel"></label> <input
				type="text" name="userName" id="userNameLabel" />
		</div>
		<br>
		<input class="formSubmitButton" type="submit" value="Next>>>" />
</body>
</html>

