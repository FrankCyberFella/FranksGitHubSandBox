<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Squirrel Cigar Party</title>
	</head>
	<body>
		<div>
			<a href = <c:url value="reviewPost"/>>Submit a Review!</a>
		</div>
		<div>
			<c:forEach var = "review" items = "${reviews}">
				<div>
					<strong>${review.title}</strong> (${review.username})
					<br>
					${review.dateSubmitted}"
					<br>
					<div>
						<c:forEach var="i" begin="1" end="${review.rating}">
							<img src="img/star.png">
						</c:forEach>
					</div>
					
					<br>
					${review.text}
					<br>
					<br>
				</div>
			</c:forEach>
		</div>
		
	</body>
</html>