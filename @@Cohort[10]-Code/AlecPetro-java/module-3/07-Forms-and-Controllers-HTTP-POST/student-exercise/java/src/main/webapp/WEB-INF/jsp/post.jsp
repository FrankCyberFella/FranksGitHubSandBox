<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Write Review</title>
	</head>
	<body>
		<h1>Squirrel Parties for Dummies by Craig Castelaz</h1>
		<div class="content-area-result">
<h2>Write a Review</h2>
	<form method = "POST" action = "${formMethod}">
		<div class="forum-post-box">
			<div>
				<label for="username">Username</label> 
				<input type="text"name="username" id="username" /> 
			</div>
			<div>
				<label for="rating">Rating</label>
				<select name="rating" id="rating">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">4</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
			</div>
			<div>	
				<label for="subject">Review Title</label>
				<input type="text" name="title" id="title" /> 	
			</div>
			<div>
				<label for="message">Review Text</label>
				<textarea name="text" rows="5" cols="50"></textarea>
			</div>
			<div class="forum-submit-button">
				<input class="formSubmitButton" type="submit" value="Submit" />
			</div>
		</div>
	</form>

</div>
	</body>
</html>