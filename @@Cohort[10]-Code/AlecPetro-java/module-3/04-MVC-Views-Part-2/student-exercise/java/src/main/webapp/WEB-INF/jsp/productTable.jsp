<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp"/>


		<table class="product-table">
		<caption id="table-head">Toy Department</caption>
		
		<tr>
		<td> </td>
		<c:forEach var="product" items="${productList}">
			<th><img class="table-photo" src="img/${product.imageName}" alt="Photo of Toy"/>
				<c:if test="${product.topSeller == true}">
					<i id="best-seller">BEST SELLER!</i>
					</c:if>
			</th>
		</c:forEach>
		</tr>
		
		<tr>
		<th>Name</th>
		<c:forEach var="product" items="${productList}">
		<td class="grey"><a href="productDetail?productId=${product.productId}">${product.name}</a></td>
		</c:forEach>
		</tr>
		
		<tr>
		<th>Rating</th>
		<c:forEach var="product" items="${productList}">
		<td><img class="table-rating" src="img/${Math.round(product.averageRating)}-star.png" alt="Average Rating"/></td>
		</c:forEach>
		</tr>
		
		<tr>
		<th>Mfr</th>
		<c:forEach var="product" items="${productList}">
		<td class="grey">${product.manufacturer}</td>
		</c:forEach>
		</tr>
		
		<tr>
		<th>Price</th>
		<c:forEach var="product" items="${productList}">
		<td class="price">$${product.price}</td>
		</c:forEach>
		</tr>
		
		<tr>
		<th id="">wt. (in lbs)</th>
		<c:forEach var="product" items="${productList}">
		<td class="grey">${Math.round(product.weightInLbs)}</td>
		</c:forEach>
		</tr>
		
		</table>
       

<c:import url="/WEB-INF/jsp/footer.jsp"/>   