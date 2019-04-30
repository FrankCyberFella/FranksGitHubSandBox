<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>

	<h1>Shopping Cart Exercise</h1>
	<p>
		<c:url var="cartPath" value="/cart" />
		<a href="${cartPath}">View Cart</a>
	</p>
	<p>
		<h2>Garden Vegetable Seeds</h2>
		<ul>
			
			<c:forEach var="seed" items="${productList}">
				<li>
					<c:url var="productPage" value="/product?name=${seed.name}" />
					<a href="${productPage}">${seed.name}</a>
		
				</li>
			</c:forEach>
		</ul>
	</p>

</body>
</html>