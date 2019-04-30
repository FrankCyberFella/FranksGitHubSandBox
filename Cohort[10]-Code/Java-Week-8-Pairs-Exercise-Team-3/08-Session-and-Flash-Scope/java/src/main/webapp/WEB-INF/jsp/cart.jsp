<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
</head>
<body>
	<table>
		<tr>
			<td>Product</td>
			<td>Price Per Item</td>
			<td>Quantity</td>
			<td>Total Cost</td>
		</tr>
		<c:forEach var="item" items="${cart}">
		<tr>
			
			<c:forEach var="product" items="${productList}">
				<c:if test="${item.key==product.name}">
					<td><c:out value="${product.name}"/></td>
					<td>${product.price}</td>
					<td>${item.value}</td>
					<td>${product.price*item.value}</td>
				</c:if>
			</c:forEach>
		</tr>	
		</c:forEach>
		
	</table>
</body>
</html>