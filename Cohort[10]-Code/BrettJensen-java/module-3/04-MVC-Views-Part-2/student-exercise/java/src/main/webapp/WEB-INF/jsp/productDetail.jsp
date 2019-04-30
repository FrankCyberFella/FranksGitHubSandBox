<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp"/>

    	<h1 id="heading">Toy Department</h1>
    		<div class="toy-list detail-div">
    			<img class="toy-image" src="img/${product.imageName}" alt="${product.name}"/>
				<ul class="toy-info">
					<li class="name">${product.name}
					  <c:if test="${product.topSeller == true }">
					    <i class="topSeller">Best Seller</i>
					  </c:if>
					</li>
					<li class="mfr">by ${product.manufacturer}</li>
					<li><img class="rating" src="img/${Math.round(product.averageRating)}-star.png"/></li>
					<li class="price">$${product.price}</li>
					<li class="weight">Weight ${product.weightInLbs} lbs</li>
					<li class="description">Description: ${product.description}</li>
				</ul>
			</div>
			
<c:import url="/WEB-INF/jsp/footer.jsp"/>