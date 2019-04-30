<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp">
</c:import>

	<section class="flexy-description">
	<div id="img-holder"><img src="img/${product.imageName}"></div>
	<ul class="flexy-column">
		<li>${product.name} <c:if test="${product.topSeller == true}"><strong class="red-text">Best Seller!</strong></c:if></li>
		<li>${product.manufacturer}</li>
		<li><img id="star-img" src="img/${Math.round(product.averageRating)}-star.png"></li>
		<li class="red-text more-padding"><b>Price: $${product.price}</b></li>
		<li><b>Weight </b>${product.weightInLbs} lbs</li>
		<li class="more-padding"><b>Description: </b>${product.description}</li>
	

	

	</ul>
	</section>


    </section>
</body>
</html>