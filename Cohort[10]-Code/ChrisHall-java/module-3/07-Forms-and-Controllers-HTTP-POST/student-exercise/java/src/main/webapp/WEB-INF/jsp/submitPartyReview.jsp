<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Speak your Piece</title>
</head>
<body>

<div id="main-content">

	<h2>Tell us what you think!</h2>


	<c:url var="formAction" value="/welcomeToTheParty" />
	<form method="POST" action="${formAction}">
	

		<div class="formInputGroup">
			<label for="userNameLabel">Enter Your Username</label> <input
				type="text" name="userName" id="userNameLabel" />
		</div>

		<div class="formInputGroup">
			<label for="subjectLabel">Your Rating</label> <input
				type="text" name="rating" id="subjectLabel" />
		</div>

		<div class="formInputGroup">
			<label for="MessageLabel">Review Title</label> <input
				type="text" name="reviewTitle" id="messageLabel" />
		</div>
		<div class="formInputGroup">
			<label for="MessageLabel">Your Review</label> <input
				type="text" name="reviewMessage" id="messageLabel" />
		</div>
		<input class="formSubmitButton" type="submit"
			value="Submit" />
</div>
</body>
</html>