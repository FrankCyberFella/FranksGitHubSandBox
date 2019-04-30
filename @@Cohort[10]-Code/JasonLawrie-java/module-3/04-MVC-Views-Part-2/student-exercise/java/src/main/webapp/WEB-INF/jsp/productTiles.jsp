<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <c:import url="header.jsp">
		<c:param name="productTitle" value ="Product Tiles View" /> 
	</c:import>
    <section id="main-content">
    	<h1>Toy Department</h1>
		<span id="tile-wrapper">
			<c:forEach var="toy" items="${productList}">
				<div class="tile-card">
					<c:url var="detailAddress" value ="productDetail?productId=${toy.getProductId()}"/> 
					<a href="${detailAddress}"><img src="img/${toy.getImageName()}"></a>
					<div>
						<span class="bold">${toy.getName()}</span>
						<c:if test="${toy.isTopSeller()}">
							<span class="red">BEST SELLER!</span>
						</c:if>
					</div>
					<div>
						<span>${toy.getManufacturer()}</span>
					</div>
					<div>
						<span class="tile-money">$${toy.getPrice()}</span>
					</div>
					<div>
						<span class="bold">Weight</span>
						<span>${toy.getWeightInLbs()} lbs</span>
					</div>
					<img src="img/${Math.round(toy.getAverageRating())}-star.png">
				</div>
			</c:forEach>
		</span>

    </section>
</body>
</html>