<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp"/>

    	<h1>Toy Department</h1>
    	<div id="list">
		<c:forEach var="product" items="${productList}">
			<div class="list-info">
				<img id="list-photo" src="img/${product.imageName}" alt="Photo of Toy"/>
					<div class="list-content">
					<i><a href="productDetail?productId=${product.productId}">${product.name}</a>
						<c:if test="${product.topSeller == true}">
							<i id="best-seller">BEST SELLER!</i>
						</c:if>
					</i>
					<i>by ${product.manufacturer}</i>
					<i class="price">$${product.price}</i>
					<i><strong>Weight </strong>${Math.round(product.weightInLbs)} lbs</i>
					<img class="list-rating" src="img/${Math.round(product.averageRating)}-star.png" alt="Average Rating"/>
				</div>
			</div>
			
				
		</c:forEach>
       </div>

<c:import url="/WEB-INF/jsp/footer.jsp"/>   