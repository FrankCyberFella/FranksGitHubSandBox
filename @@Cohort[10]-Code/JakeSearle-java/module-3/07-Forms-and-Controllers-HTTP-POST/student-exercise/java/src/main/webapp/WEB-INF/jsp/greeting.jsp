<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Hello Spring MVC</title>
</head>
<section>

	<h1>Hello, Dummy!</h1>
	<h2>
		<img src="WEB-INF/images/forDummies.png" />
	</h2>
	<a href="forum">Click Here to Leave a Review!</a>


	<div id="forum-stuff">
		<c:forEach items="${posts}" var="review">
			<ul>
				<li class="black-text"><b>${review.title}</b></li>
				<li class="black-text">${review.rating}</li>
				<li class="black-text">by ${review.username} on ${review.dateSubmitted}</li>
				<li class="black-text">${review.text}</li>
			</ul>
		</c:forEach>
	</div>

</section>
</html>