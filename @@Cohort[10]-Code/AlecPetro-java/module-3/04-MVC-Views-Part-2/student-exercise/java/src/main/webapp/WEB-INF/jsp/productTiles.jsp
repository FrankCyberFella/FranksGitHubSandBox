<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp"/>

<h1>Toy Department</h1>
    	<div id="product-tiles">
    	<c:forEach var="product" items="${productList}">
    		<div class="tile-column">
    			
	    		<img id="tile-photo" src="img/${product.imageName}"/>
	    			<i id="tile-name"><a href="productDetail?productId=${product.productId}">${product.name}</a>
						<c:if test="${product.topSeller == true}">
							<a id="best-seller">BEST SELLER!</a>
						</c:if>
				</i>
				<i id="tile-mfr">by ${product.manufacturer}</i>
				<i id="tile-price" class="price">$${product.price}</i>
				<i id="tile-wgt"><strong>Weight </strong>${Math.round(product.weightInLbs)} lbs</i>
				<img id="tile-rating" src="img/${Math.round(product.averageRating)}-star.png" alt="Average Rating"/>
				
			</div>
    	</c:forEach>
    	</div>
       
<c:import url="/WEB-INF/jsp/footer.jsp"/>   