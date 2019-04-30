<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Squirrel Parties for Dummies by Craig Castelaz</title>
		<link rel="stylesheet" href="css/site.css"></link>
	</head>
	<body>
		<h1>Squirrel Parties for Dummies by Craig Castelaz</h1>
		<h4><a href="greeting"> Home</a></h4>
		<div>
			<c:forEach items="${reviews}" var="review">
				<div class="main">
					<p><strong>${review.title }</strong> (${review.username })</p>
					<p>${review.dateSubmitted }</p>
					<c:forEach begin="1" end="${review.rating }">
					<span><img alt="star image" src="img/star.png"/></span>
					</c:forEach>
					<p>${review.text }</p>
				</div>
			</c:forEach>
		</div>

	</body>
</html>