<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var= "pageTitle" value="Table View" />    
<%@ include file = "header.jsp" %>

<table>
	<%-- Using the <caption> tag for the Title Name --%>
	<caption class="">Toy Department</caption>
	<tr id="" class="">
		<th></th>
		<c:forEach items="${productList}" var="product">
			<td><a href="productDetail?productId=${product.productId}" ><img class="" src="img/${product.imageName}" /></a></td>
		</c:forEach>
	</tr>
	<tr id="" class="">
		<th class="">Name</th>
		<c:forEach items="${productList}" var="product">
			<td><a href="productDetail?productId=${product.productId}" ><c:out value="${product.name}" /></a></td>
		</c:forEach>

	</tr>
	<tr>
		<th class="">Rating</th>
		<c:forEach items="${productList}" var="product">
			<td><img class=""
				src="img/${Math.round(product.averageRating)}-star.png" /></td>
		</c:forEach>
	</tr>
	<tr id="" class="">
		<th class="">Mfr.</th>
		<c:forEach items="${productList}" var="product">
			<td><c:out value="${product.manufacturer}" /></td>
		</c:forEach>
	</tr>
	<tr id="" class="">
		<th class="">Price</th>
		<c:forEach items="${productList}" var="product">
			<td><c:out value="$ ${product.price}" /></td>
		</c:forEach>
	</tr>
	<tr id="" class="">
		<th class="">Weight</th>
		<c:forEach items="${productList}" var="product">
			<td><c:out value="${product.weightInLbs} lbs." /></td>
		</c:forEach>
	</tr>

</table>

<%@ include file = "footer.jsp" %>
