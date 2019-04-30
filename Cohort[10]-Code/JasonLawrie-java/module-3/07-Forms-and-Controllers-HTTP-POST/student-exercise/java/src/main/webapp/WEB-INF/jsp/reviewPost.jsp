<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Squirrel Cigar Party</title>
		<c:url value="/css/reviewStyles.css" var="cssHref" />
    	<link rel="stylesheet" href="${cssHref}">
	</head>
	<body>

		<div>
			<form method="POST" action="reviewPost">
				<label for="username">Username:</label>
				<input type="text" id="username" name="username">
				<br>
				<div>
					<label for="rating">Star Rating:</label>
					<select name="rating" id="rating">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
				</div>
				
				<br>
				
				<label for="title">Title:</label>
				<input type="text" id="title" name="title">
				<br>
				<label for="review">Review:</label>
				<textarea rows="4" cols="25" id="review" name="text"></textarea>
				<br>
				<input type="submit" value="submit" id="submit">
			</form>
		</div>
		
	</body>
</html>