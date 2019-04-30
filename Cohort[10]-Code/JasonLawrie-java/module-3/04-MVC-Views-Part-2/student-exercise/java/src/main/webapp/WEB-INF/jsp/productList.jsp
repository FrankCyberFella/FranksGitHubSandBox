<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <c:import url="header.jsp">
		<c:param name="productTitle" value ="Product List View" /> 
	</c:import>
    <section id="main-content">
		<h1>Toy Department</h1>
		<span id="list-wrapper">
			<c:forEach var="toy" items="${productList}">
				<div class="list-card">
					<span class="img-wrapper">
						<c:url var="detailAddress" value ="productDetail?productId=${toy.getProductId()}"/> 
						<a href="${detailAddress}"><img src="img/${toy.getImageName()}"></a>
					</span>
					<span>
						<div>
							<span class="bold">${toy.getName()}</span>
							<c:if test="${toy.isTopSeller()}">
								<span class="red">BEST SELLER!</span>
							</c:if>
						</div>
						<div>
							<span>by ${toy.getManufacturer()}</span>
						</div>
						<div>
							<span class="list-money">$${toy.getPrice()}</span>
						</div>
						<div>
							<span class="bold">Weight</span>
							<span>${toy.getWeightInLbs()} lbs</span>
						</div>
						<img src="img/${Math.round(toy.getAverageRating())}-star.png">
					</span>
				</div>
			</c:forEach>
		</span>
       

    </section>
</body>
</html>