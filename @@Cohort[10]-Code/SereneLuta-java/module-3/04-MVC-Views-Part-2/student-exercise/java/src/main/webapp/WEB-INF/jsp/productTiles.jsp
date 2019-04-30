<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url= "/WEB-INF/jsp/header.jsp">
</c:import>
	<section id="main-content">
	<h1>Toy Department</h1>
		<div id="main-tiles-div">
			<c:forEach var="product" items="${requestScope.productList}">
				<c:url var="url" value="productDetail?productId=${product.getProductId()}" />
				<div id="tileDiv">
					<div>
						<a href="${url}"><img id="tilePhoto"
							src="img/${product.getImageName()}" /></a>
					</div>
					<div id="tile-name">${product.getName()}</div>
					<div id="tile-mnfr">${product.getManufacturer()}</div>
					<br>
					<div id="tile-price">$${product.getPrice()}</div>
					<div id="tile-weight"><b>Weight </b>${Math.round(product.getWeightInLbs())} lbs</div>
					<div>
						<img id="tileStar"
							src="img/${Math.round(product.averageRating)}-star.png" />
					</div>
				</div>
			</c:forEach>
		</div>



	</section>
</body>
</html>