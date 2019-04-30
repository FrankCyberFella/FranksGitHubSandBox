<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp"/>

    <section id="main-content">
    <h2>Toy Department</h2>
    
    <table>
       
        <tr>
       	<th></th>
       	<c:forEach var="toy" items="${productList}">
       	
       	<td><a href="productDetail?productId=${toy.getProductId()}"><img src="img/${toy.imageName}"></a>
       	<div><c:if test="${toy.topSeller == true}"><span id="bestSeller">  BEST SELLER!</span></c:if></div>
       	</td>
       	</c:forEach>
		</tr>
       
       <tr style="background: #DDf">
       	<th>Name</th>
       	<c:forEach var="toy" items="${productList}">
					<td id="toyNames2">${toy.name}</td>
		</c:forEach>
		</tr>
		
		<tr>
       <th>Rating</th>
       <c:forEach var="toy" items="${productList}">
					<td id="rating"><img id="stars2" src= "img/${Math.round(toy.averageRating)}-star.png"></td>
		</c:forEach>
		</tr>
		
		<tr style="background: #DDf">
       <th>Mfr</th>
       <c:forEach var="toy" items="${productList}">
       				<td id="maker">${toy.manufacturer}</td>			
		</c:forEach>
		<th>
		</tr>
		
		
		<tr>
       <th>Price</th>
       <c:forEach var="toy" items="${productList}">
					<td id="price2">$${toy.price}</td>
		</c:forEach>
		</tr>
		
		<tr style="background: #DDf">
		<th>wt. (in lbs)</th>
		
		<c:forEach var="toy" items="${productList}">
					<td>${Math.round(toy.weightInLbs)}</td>
		</c:forEach>
		</tr>			
			
	</table>
    </section>

</body>
</html>