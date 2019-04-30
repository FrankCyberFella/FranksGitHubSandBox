<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section id="main-content">

<div class="posts">

	<c:forEach var="review" items="${reviews}">

		<div class="post">
			<h3>${review.title}</h3>
			<p style="display: inline">${review.username}</p>
			<br>
			<p>${review.dateSubmitted}</p>
			<br>
			<c:forEach begin="1" end="${review.rating}">
				<img style="display: inline-block; height: 20px; width: 20px" src="img/star.png"/>
			</c:forEach>
			<br>
			<p>${review.text}</p>
		</div>
		
	</c:forEach>
	
</div>
    
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />