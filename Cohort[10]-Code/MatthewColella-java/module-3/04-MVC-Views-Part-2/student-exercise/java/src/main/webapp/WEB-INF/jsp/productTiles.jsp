<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/header.jsp"/>
    
<h1>Toy Department</h1>
	<div id="tile-row">
	<c:set var="i" value="0"/>
       <c:forEach var="product" items="${productList}">
       		
       		
       			<ul id="tileList">
      
       			<li class="tile"><img src="img/${product.imageName}"></li>
       			<li class="tile"> <a href="productDetail?productId=${product.getProductId()}">${product.name}</a> <c:if test="${product.topSeller == true}"> <span style="color: red"> <strong><em>Top Seller!</em></strong></span></c:if></li>
       			<li class="tile">by ${product.manufacturer}</li>
       			<li class="tile" >$${product.price}</li>
       			<li class="tile">Weight: ${product.weightInLbs} lbs.</li>
       			<li class="tile" ><img id="stars" src= "img/${Math.round(product.averageRating)}-star.png"></li>
       		</ul>
       		<c:set var="i" value="${i +1}"/>
       </c:forEach>
       
	</div>
       

    </section>
</body>
</html>