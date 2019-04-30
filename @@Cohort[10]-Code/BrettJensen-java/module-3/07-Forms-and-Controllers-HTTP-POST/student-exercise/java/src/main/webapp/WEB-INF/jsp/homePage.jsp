<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="common/header.jspf"%>

<section id="cigar-section">
	<div id="bookSection">
		<c:url var="dummiesBook" value="forDummies.png"/>
		<img id="bookImage" src="etc/${dummiesBook}" alt="Squirrel Cigar Party"/>
		<div id="description">
			<h3>DESCRIPTION:</h3>
			<p>This book takes a detailed look at Squirrel Cigar Parties, broken down for ease of understanding</p>
			<c:url var="reviewInputHref" value="/reviewInput"/>
			<a id="reviewAnchor" href="${reviewInputHref}">Add A Review</a>
		</div>	
	</div>
	
	<hr />
	
	<div id="reviews">
		<c:forEach var="review" items="${reviews}">
			<div class="review">
				<h4 class="row">${review.title}</h4>
				<p class="row">by ${review.username} on ${review.dateSubmitted}</p>
				<p class="row">${review.text}</p>
				<ul class="starRating row">
					<c:forEach begin="1" end="${review.rating}">
					<c:url var="star" value="star.png"/>
					<li><img src="etc/${star}" alt="Star Rating"/></li>
					</c:forEach>
				</ul>
			</div>
		</c:forEach>
	</div>
</section>
<%@include file="common/footer.jspf"%>