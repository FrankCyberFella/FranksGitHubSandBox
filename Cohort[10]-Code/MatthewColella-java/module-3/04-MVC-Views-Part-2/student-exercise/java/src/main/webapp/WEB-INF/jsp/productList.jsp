<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/header.jsp"/>
    
<h1>Toy Department</h1>
	 <c:forEach var="product" items="${productList}">
       		
       		<div id="listRow">
       		<div id="image">
       		<img src="img/${product.imageName}">
       		</div>
       		<div>
       		<ul>
       			<li id="name" style="background: none"> <a href="productDetail?productId=${product.getProductId()}">${product.name}</a> <c:if test="${product.topSeller == true}"> <span style="color: red"> <strong><em>Top Seller!</em></strong></span></c:if></li>
       			<li id="manufacturer">by ${product.manufacturer}</li>
       			<li id="price">$${product.price}</li>
       			<li id="weight">Weight: ${product.weightInLbs} lbs.</li>
       			<li class="rating"><img id="stars" src= "img/${Math.round(product.averageRating)}-star.png"></li>
       		</ul>
       		</div>
       		</div>
   
       </c:forEach>

    </section>
</body>
</html>
 
 
 
