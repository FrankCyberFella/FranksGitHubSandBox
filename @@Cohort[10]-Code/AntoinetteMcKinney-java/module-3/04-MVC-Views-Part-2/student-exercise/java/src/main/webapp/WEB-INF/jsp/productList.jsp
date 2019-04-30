<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var= "pageTitle" value="List View" />    
<%@ include file = "header.jsp" %>
<c:forEach items="${productList}" var="product">
	<div class="product">
	<a href="productDetail?productId=${product.productId}" >
		<img class="" src="img/${product.imageName}"/>
		</a>
		<div class="">
		 <a href="productDetail?productId=${product.productId}" >
			<c:out value="${product.name}"/>
			</a>
			<br>
			<c:out value="by ${product.manufacturer}"/>
			<br>
			<c:out value="$${product.price}"/>
		</div>
	</div>
</c:forEach>
<%@ include file = "footer.jsp" %>