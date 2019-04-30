<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp"/>

		<h1 id="heading">Toy Department</h1>
    	<c:forEach var="product" items="${productList}">
    		<div class="toy-list">
    			<a href="productDetail?productId=${product.productId}">
    				<img class="toy-image" src="img/${product.imageName}" alt="${product.name}"/>
    			</a>
				<ul class="toy-info">
					<a href="productDetail?productId=${product.productId}">
						<li class="name">${product.name}
						  <c:if test="${product.topSeller == true }">
						    <i class="topSeller">Best Seller</i>
						  </c:if>
						</li>
					</a>
					<li class="maker">${product.manufacturer}</li>
					<li class="price">$${product.price}</li>
					<li class="weight">Weight ${product.weightInLbs} lbs</li>
					<li><img class="rating" src="img/${Math.round(product.averageRating)}-star.png"/></li>
				</ul>
			</div>
		</c:forEach>

<c:import url="/WEB-INF/jsp/footer.jsp"/>