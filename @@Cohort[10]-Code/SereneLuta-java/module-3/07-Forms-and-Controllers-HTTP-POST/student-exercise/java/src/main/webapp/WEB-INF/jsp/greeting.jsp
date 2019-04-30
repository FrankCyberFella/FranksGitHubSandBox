<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
		<link href="<c:url value="/css/style.css" />" rel="stylesheet">
	</head>
	<body>
		<div id="top-section"/>
		<h1>Squirrel Cigar Parties For Dummies</h1>
		<h3>by Craig Castelaz</h3>
		<img src="img/forDummies.png" id="book-image"/>
		</div>
		
		<h4>Book Reviews</h4>
		<c:url var="url" value="postBookReview"/>
		<h5><a href="${url}">submit a review</a></h5>
		<c:forEach var="review" items="${reviewKey}">
		<div id="review-block">
		<b>${review.title}</b> (${review.username})<br>
		${review.dateSubmitted}<br>
			<c:choose>
				<c:when test="${review.rating == 5}">
					<img src="img/star.png"/><img src="img/star.png"/><img src="img/star.png"/>
					<img src="img/star.png"/><img src="img/star.png"/>	
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${review.rating == 4 }">
					<img src="img/star.png"/><img src="img/star.png"/><img src="img/star.png"/>
					<img src="img/star.png"/>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${review.rating == 3 }">
					<img src="img/star.png"/><img src="img/star.png"/><img src="img/star.png"/>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${review.rating == 2 }">
					<img src="img/star.png"/><img src="img/star.png"/>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${review.rating == 1 }">
					<img src="img/star.png"/>
				</c:when>
			</c:choose>
		<br><p>${review.text}</p>
		<hr>
		</c:forEach>
		</div>
	</body>
</html>