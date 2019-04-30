<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <c:import url="header.jsp">
		<c:param name="productTitle" value ="Product Detail View" /> 
	</c:import>
    <section id="main-content">
    	
    	<div class="detail-card">
			<span class="img-wrapper">
				<img src="img/${product.getImageName()}" id="detail-image">
			</span>
			<span>
				<div>
					<span class="bold">${product.getName()}</span>
					<c:if test="${product.isTopSeller()}">
						<span class="red">BEST SELLER!</span>
					</c:if>
				</div>
				<div>
					<span>by ${product.getManufacturer()}</span>
				</div>
				<img src="img/${Math.round(product.getAverageRating())}-star.png" id="detail-stars">
				<div>
					<span class="tile-money">$${product.getPrice()}</span>
				</div>
				<div>
					<span class="bold">Weight</span>
					<span>${product.getWeightInLbs()} lbs</span>
				</div>
				<div>
					<span><strong>Description: </strong>${product.getDescription()}</span>
				</div>
			</span>
		</div>
    
    </section>
</body>
</html>