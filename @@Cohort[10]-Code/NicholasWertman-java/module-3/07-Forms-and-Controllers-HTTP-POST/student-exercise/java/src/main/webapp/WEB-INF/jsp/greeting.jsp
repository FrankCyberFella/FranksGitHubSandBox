  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

   <c:import url="/WEB-INF/jsp/common/header.jsp" />
   
    

	<body>
		
		<h1>Home Page</h1>
		<div id="container"> 
		<c:forEach var="review" items="${reviews}">
		<div class="reviewContainer">
			<h2> ${review.title} (${review.username})</h2>
				<c:choose>
					<c:when test="${review.rating == 1}">
				<img class="star-rating" src="img/star.png" />
					</c:when>
					<c:when test = "${review.rating == 2}">
				<img class="star-rating" src="img/star.png"/>
				<img class="star-rating" src="img/star.png"/>
					</c:when>
					<c:when test = "${review.rating == 3}">
				<img class="star-rating" src="img/star.png"/>
				<img class="star-rating" src="img/star.png"/>
				<img class="star-rating" src="img/star.png"/>
					</c:when>
					<c:when test = "${review.rating == 4}">
				<img class="star-rating" src="img/star.png"/>
				<img class="star-rating" src="img/star.png"/>
				<img class="star-rating" src="img/star.png"/>
				<img class="star-rating" src="img/star.png"/>
					</c:when>
					<c:when test = "${review.rating == 5}">
				<img class="star-rating" src="img/star.png"/>
				<img class="star-rating" src="img/star.png"/>
				<img class="star-rating" src="img/star.png"/>
				<img class="star-rating" src="img/star.png"/>
				<img class="star-rating" src="img/star.png"/>
					</c:when>
				</c:choose>
			<p> ${review.text}</p>
			</div>
		</c:forEach>
		
				<c:url var="submitNewReview" value="/submitNewReview"/>
				<a href="submitNewReview">
				<input class="submitButton "type="submit" value="Submit Your Own Review"/>
				</a>
			
		</div>
	</body>
</html>	