 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<section id="main-content">
	
<h2>Squirrell Cigar Parties For Dummies<h2>

<a href="reviewPost">Post a Review</a>

<div class="reviews">

	<c:forEach var="review" items="${reviews}">

		<div class="review">
------------------------------------------------------------------------------------------------------------------------
			<h3>${review.title} by ${review.username}</h3>
			<br>
			<p>${review.dateSubmitted}</p>
			<br>
			<div>
			<c:forEach var="i" begin="1" end="${review.rating}">
				<img src="star.png"/>
			</c:forEach>
			</div>
			<br>
			<p>${review.text}</p>
		</div>
		
	</c:forEach>
	
</div>

</section>

