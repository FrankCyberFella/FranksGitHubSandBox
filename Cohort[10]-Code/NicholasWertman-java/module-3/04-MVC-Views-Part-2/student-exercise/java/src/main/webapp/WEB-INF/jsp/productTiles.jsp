<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/header.jsp">
</c:import>

    <section id="main-content">
 	<h1>Toy Department</h1>
		<div id = "tile-block">
			<c:forEach var="product" items="${productList}">
			<c:url value = "productDetail" var = "productDetail"/>
			<a class="product" href = "${productDetail}?productId=${product.productId}">
				<div id="tile-list">
				<ul id="side-by-side">
				<li>
				<img id ="product-image-tile" src="img/${product.imageName}"/>
				</li>
					<li> <b>
					${product.name}
					</b>
					<c:if  test = "${product.topSeller}" >
					<u id ="best-seller"> Best Seller!
					</u>
					</c:if>
					</li> 
					<li> 
					By ${product.manufacturer}
					</li>
					<li><b>
					 Weight: </b> ${product.weightInLbs} lbs
					 </li>
					 <li id = "price-tile">
					  $ ${product.price}
					
					  </li>
					<div class="product-rating">
						<img src="img/${Math.round(product.averageRating)}-star.png" />
					</div>
					</ul>
	
					
					
				</div>

		</a>
			</c:forEach>
		</div>
    </section>
</body>
</html>