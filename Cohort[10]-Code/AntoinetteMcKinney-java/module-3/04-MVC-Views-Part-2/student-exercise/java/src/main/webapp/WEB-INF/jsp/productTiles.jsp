<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var= "pageTitle" value="Tile View" />    
<%@ include file = "header.jsp" %>
	<div class="">
	<span class = ""><c:out value="Toy Department"/></span>
	</div>
	<c:forEach items="${productList}" var="product">
			<div class="">
				<a href="productDetail?productId=${product.productId}" ><img class="" src="img/${product.imageName}" /></a>
				<br/>
				<div class="">
					<span><a href="productDetail?productId=${product.productId}" ><c:out value="${product.name}" /></a></span>
					<br/>
					<span><c:out value="by ${product.manufacturer}" /></span>
					<br/>
					<span><c:out value="$ ${product.price}" /></span>
					<br/>
					<span><c:out value="Weight: ${product.weightInLbs} lbs." /></span>
				</div>
				<div class="">
					<img class="" src="img/${Math.round(product.averageRating)}-star.png" />
				</div>			
			</div>
		</c:forEach>
<%@ include file = "footer.jsp" %>