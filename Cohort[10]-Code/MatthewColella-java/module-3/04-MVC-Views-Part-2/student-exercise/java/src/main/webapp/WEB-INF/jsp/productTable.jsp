<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/header.jsp"/>
    
<h1>Toy Department</h1>
	<div id="info">
		<ul class="tableList">
			<li></li>
			<li style="background: #AAA">Name</li>
			<li>Manufacturer</li>
			<li id="priceTag">Price</li>
			<li>Weight</li>
			<li id="ratingName">Rating</li>
		</ul>
       <c:forEach var="product" items="${productList}">
       		
       		
       			<ul class="tableList">
      
       			<li id="tableImage"><img src="img/${product.imageName}"></li>
       			<li id="name"> <a href="productDetail?productId=${product.getProductId()}">${product.name}</a> <c:if test="${product.topSeller == true}"> <span style="color: red"> <strong><em>Top Seller!</em></strong></span></c:if></li>
       			<li id="manufacturer">by ${product.manufacturer}</li>
       			<li id="price" style="background: #AAA">$${product.price}</li>
       			<li id="weight">Weight: ${product.weightInLbs} lbs.</li>
       			<li class="rating" style="background: #AAA"><img id="stars" src= "img/${Math.round(product.averageRating)}-star.png"></li>
       		</ul>
       		
       		<c:set var="i" value="${i +1}"/>
       </c:forEach>
       
	</div>
       

    </section>
</body>
</html>