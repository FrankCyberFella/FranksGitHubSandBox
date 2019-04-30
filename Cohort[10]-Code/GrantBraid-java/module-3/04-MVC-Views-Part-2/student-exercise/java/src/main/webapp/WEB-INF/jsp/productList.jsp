<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp">
</c:import>

    <h1>Toy Department</h1>
    <c:set var="count" value="0" />
    <c:forEach var="product" items="${productList}">
    <div class="flexy">
   
   		<c:choose> 
   			<c:when test="${count == 0}">
   				<a href="productDetail?productId=SKU-1234"><img id="img-list" src="img/toy-balls.jpg" alt="Student Image"></a>
   			</c:when>
   			
   			<c:when test="${count == 1}">
   				<a href="productDetail?productId=SKU-2345"><img id="img-list" src="img/toy-car.jpg" alt="Student Image"></a>
   			</c:when>
   			
   			<c:when test="${count == 2}">
   				<a href="productDetail?productId=SKU-5678"><img id="img-list" src="img/toy-gym.jpg" alt="Student Image"></a>
   			</c:when>
   			
   			<c:when test="${count == 3}">
   				<a href="productDetail?productId=SKU-3333"><img id="img-list" src="img/toy-horse.jpg" alt="Student Image"></a>
			</c:when>
   				
   			<c:when test="${count == 4}">
   				<a href="productDetail?productId=SKU-4567"><img id="img-list" src="img/toy-snail.jpg" alt="Student Image"></a>
   			</c:when>
   			
   			<c:otherwise>
   				<a href="productDetail?productId=SKU-5566"><img id="img-list" src="img/toy-tricycle.jpg" alt="Student Image"></a>
   			</c:otherwise>
   				
   		</c:choose>
    	
    <ul class="flexy-column">
    	<li>${product.name} <c:if test="${product.topSeller == true}"><strong class="red-text">Best Seller!</strong></c:if></li>
    	<li>${product.manufacturer}</li>
    	<li class="red-text">$${product.price}</li>
    	<li><b>Weight</b>: ${product.weightInLbs}</li>
    	<li><img src="img/${Math.round(product.averageRating)}-star.png"></li>
    	
    </ul>
    <c:set var="count" value="${count + 1}"/>
   	</div>
   	</c:forEach>
   	
	
   

       

    </section>
</body>
</html>