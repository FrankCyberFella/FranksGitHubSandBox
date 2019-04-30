<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<c:import url="header.jsp">
		<c:param name="productTitle" value ="Product Table View" /> 
	</c:import>

    <section id="main-content">
		<table>
			<tr>
				<th></th>
				<c:forEach var="toy" items="${productList}">
					<c:url var="detailAddress" value ="productDetail?productId=${toy.getProductId()}"/> 
					<td><a href="${detailAddress}"><img src="img/${toy.getImageName()}"></a>
					<c:if test="${toy.isTopSeller()}">
							<div class="red">BEST SELLER!</div>
					</c:if>
					</td>
				</c:forEach>
			</tr>
			<tr>
				<th>Name</th>
				<c:forEach var="toy" items="${productList}">
					<td>${toy.getName()}</td>
				</c:forEach>
			</tr>
			<tr>
				<th>Rating</th>
				<c:forEach var="toy" items="${productList}">
					<td><img src="img/${Math.round(toy.getAverageRating())}-star.png"></td>
				</c:forEach>
			</tr>
			<tr>
				<th>Manufacturer</th>
				<c:forEach var="toy" items="${productList}">
					<td>${toy.getManufacturer()}</td>
				</c:forEach>
			</tr>
			<tr>
				<th>Price</th>
				<c:forEach var="toy" items="${productList}">
					<td><span class="tile-money">$${toy.getPrice()}</span></td>
				</c:forEach>
			</tr>
			<tr>
				<th>Weight (in lbs)</th>
				<c:forEach var="toy" items="${productList}">
					<td><span>${toy.getWeightInLbs()}</span></td>
				</c:forEach>
			</tr>
		</table>
    </section>
</body>
</html>