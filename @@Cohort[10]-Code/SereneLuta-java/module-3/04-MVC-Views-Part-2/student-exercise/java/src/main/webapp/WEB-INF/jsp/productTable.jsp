<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url= "/WEB-INF/jsp/header.jsp">
</c:import>
	<section id="table-content">
	<h1>Toy Department</h1>
		<table id="table-titles">
			<tr>
				<td></td>
			</tr>
			<tr>
				<td>Name</td>
			</tr>
			<tr>
				<td>Rating</td>
			</tr>
			<tr>
				<td>Mfr</td>
			</tr>
			<tr>
				<td>Price</td>
			</tr>
			<tr>
				<td>wt. (in lbs)</td>
			</tr>
		
		</table>
		<table id="table-products">
				<c:forEach var="image" items="${requestScope.productList}">
				<c:url var="url" value="productDetail?productId=${image.getProductId()}" />
					<td><a href="${url}"><img id="list-img" src="img/${image.getImageName()}"></a></td>
				</c:forEach>
			<tr>
				<c:forEach var="name" items="${requestScope.productList}">
					<td>${name.getName()}</td>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach var="star" items="${requestScope.productList}">
					<td><img id="table-star" src="img/${Math.round(star.averageRating)}-star.png" /></td>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach var="made" items="${requestScope.productList}">
					<td>${made.getManufacturer()}</td>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach var="price" items="${requestScope.productList}">
					<td id="table-price">$${price.getPrice()}</td>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach var="weight" items="${requestScope.productList}">
					<td>${Math.round(weight.getWeightInLbs())}</td>
				</c:forEach>
		</table>
	</section>
</body>
</html>