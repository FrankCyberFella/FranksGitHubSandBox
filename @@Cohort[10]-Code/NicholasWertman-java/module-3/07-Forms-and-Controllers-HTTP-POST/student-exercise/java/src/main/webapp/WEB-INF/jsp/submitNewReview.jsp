<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>

<h1>Submit Your Own Review</h1>

	<c:url var="submit" value="/submitNewReview" />
	<form method="POST" action="${submit}">
		<div id="submitForm">
			<label for="username"> Username: </label>
			<input type="text" name="username" id="username"/>
		</div>
		<div id="submitForm">
			<label for ="rating">Rating</label>
			<select name="rating">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select>
		</div>
		<div id="submitForm">
			<label for="title">Title: </label>
			<input type="text" name="title" id="title"/>
		</div>
		<div id="submitForm">
			<label for="text">Text: </label>
			<textarea cols=25 rows=10 id="text" name="text">
			</textarea>
		</div>
		<div id="submitForm">
			<input type="submit" value="Post"/>
		</div>
	</form>

</body>
</html>