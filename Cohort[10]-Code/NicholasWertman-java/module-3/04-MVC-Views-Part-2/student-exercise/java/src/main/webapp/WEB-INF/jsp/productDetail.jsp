<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp">
</c:import>

<c:set var="productId" value="${param.productId}">
</c:set>

<section id="main-content">
	<div id ="detail">
	<ul>
					<li> <b>
					${product.name}
					</b>
					<c:if  test = "${product.topSeller}" >
					<u id ="best-seller"> Best Seller!
					</u>
					</c:if>
					</li> 
					<li> 
					by ${product.manufacturer}
					</li>
					<div class="product-rating">
						<img src="img/${Math.round(product.averageRating)}-star.png" />
					</div>
					<li><b>
					 Weight: </b> ${product.weightInLbs} lbs
					 </li>
					 <li id = "price">
					  $ ${product.price}
					
					  </li>
					<li>
					<b> Description:  </b> ${product.description}
					</li>
					</ul>
						<img id ="product-image-detail" src="img/${product.imageName}"/>
				</div>
</section>
</body>
</html>