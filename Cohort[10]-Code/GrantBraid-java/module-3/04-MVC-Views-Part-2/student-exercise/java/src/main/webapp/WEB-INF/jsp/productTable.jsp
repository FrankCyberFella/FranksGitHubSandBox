<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp">
</c:import>

    	<h1>Toy Department</h1>
    <table>
       	<tr>
    		<th> </th>
    		<td><a href="productDetail?productId=SKU-1234"><img src="img/toy-balls.jpg"></a></td>
    		<td><a href="productDetail?productId=SKU-2345"><img src="img/toy-car.jpg"></a></td>
    		<td><a href="productDetail?productId=SKU-5678"><img src="img/toy-gym.jpg"></a></td>
    		<td><a href="productDetail?productId=SKU-3333"><img src="img/toy-horse.jpg"></a></td>
    		<td><a href="productDetail?productId=SKU-4567"><img src="img/toy-snail.jpg"></a></td>
    		<td><a href="productDetail?productId=SKU-5566"><img src="img/toy-tricycle.jpg"></a></td>
    	</tr>
    	<tr>
    		<th></th>
    		<c:forEach var="name" items="${productList}">
    		<td class="red-text">
    			<c:if test="${name.topSeller == true}">
    				Best Seller! 
    			</c:if>
    		</td>
    		</c:forEach>
    	</tr>
    	<tr>
    		<th>Name</th>
    		<c:forEach var="name" items="${productList}">
    			<td class="bg-grey">${name.name}</td>
    		</c:forEach>
    	</tr>
    	<tr>
    		<th>Rating</th>
    		<c:forEach var="rating" items="${productList}">
    			<td><img src="img/${Math.round(rating.averageRating)}-star.png"}></td>
    		</c:forEach>
    	</tr>
    	<tr>
    		<th>Mfg</th>
    		<c:forEach var="mfg" items="${productList}">
    			<td class="bg-grey">${mfg.manufacturer}</td>
    		</c:forEach>
    	</tr>
    	<tr>
    		<th>Price</th>
    		<c:forEach var="price" items="${productList}">
    			<td class="red-text">$${price.price}</td>
    		</c:forEach>
    	</tr>
    	<tr>
    		<th>wt. (in lbs)</th>
    		<c:forEach var="wt" items="${productList}">
    			<td class="bg-grey">${wt.weightInLbs}</td>
    		</c:forEach>
    	</tr>
    
    </table>


    </section>
</body>
</html>