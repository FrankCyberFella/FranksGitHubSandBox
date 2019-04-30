<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to SCP!!</title>
</head>
<body>

	<p><strong>Yes, your are in the right place for Squirrel Cigar Parties!</strong></p>
	<br>
	<p><i>My CSS, it may be lacking,</p>

	<p>But cigars, my friends, these Squirrels are packing!!</i></p>
	<br>
	<p>Now that you have purchased your copy of Squirrel Cigar Parties
		and upgraded your life...
	<p>
		please feel free to tell us what you think: 
	<br>
	<br> 
		<a href="submitPartyReview"><img alt="Squirrels&Cigars!!"
			src="img/submitbutton.png"></a>
	<div>
		<br><strong> Reader Reviews:</strong>

		<div>
			<c:forEach items="${reviews}" var="review">

				<div>
					<c:out value="${review.title}" />
				</div>
				<br>
				<div>
					<c:out value="${review.username}" />
				</div>
				<br>
				<div>
					<c:out value="${review.dateSubmitted}" />
				</div>
				<br>
				<div>
					<c:out value="${review.rating}" />
				</div>
				<br>
				<div>
					<c:out value="${review.text}" />
				</div>
				<br>

				<br>
			</c:forEach>
		</div>
	</div>

</body>
</html>