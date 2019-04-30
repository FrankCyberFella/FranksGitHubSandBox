<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url= "/WEB-INF/jsp/header.jsp">
</c:import>
	<section id="main-content">
	<h1>Toy Department</h1>
		<table>
				<c:forEach var="product" items="${requestScope.productList}">
				<tr id = "list">
				<c:url var="url"
					value="productDetail?productId=${product.getProductId()}" />
					<td><a href="${url}"><img id="list-img" src="img/${product.getImageName()}"></a></td>
					<td>
						<div id="list-info">
							<h2 id="list-name">${product.getName()}</h2> <br>By ${product.getManufacturer()}
							<br><span id="list-price">$${product.getPrice()}</span><br>Weight </h4>${product.getWeightInLbs()}
							<br><img id="list-star" src="img/${Math.round(product.averageRating)}-star.png"/></td>
						</div>
						<%--  <c:choose>
							<c:when test="${product.getTopSeller() == true}">
								<c:set var="value" value="Best Seller" />	
						
							</c:when>
							<c:otherwise>
						    	<c:set var="value" value="" />	
							</c:otherwise>
						</c:choose> --%>
					
				</c:forEach>
			</tr>
		</table>
     </section>
</body>
</html>