<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp">
</c:import>

	<c:set var="count" value="0"/>
	<ul class="row-1">
	<c:forEach var="toy" items="${productList}">
	<c:choose>
		<c:when test="${count == 0}">
			<li ><a href="productDetail?productId=SKU-1234"><img src="img/toy-balls.jpg"></a></li>
		</c:when>
		<c:when test="${count == 1}">
			<li ><a href="productDetail?productId=SKU-2345"><img src="img/toy-car.jpg"></a></li>
		</c:when>
		<c:when test="${count == 2}">
			<li ><a href="productDetail?productId=SKU-5678"><img src="img/toy-gym.jpg"></a></li>
		</c:when>
		<c:when test="${count == 3}">
			<li ><a href="productDetail?productId=SKU-3333"><img src="img/toy-horse.jpg"></a></li>
		</c:when>
		<c:when test="${count == 4}">
			<li ><a href="productDetail?productId=SKU-4567"><img src="img/toy-snail.jpg"></a></li>
		</c:when>
		<c:otherwise>
			<li ><a href="productDetail?productId=SKU-5566"><img src="img/toy-tricycle.jpg"></a></li>
		</c:otherwise>
	</c:choose>
	
			<li class="col">${toy.name}</li>
			<li class="col">Helllo</li>
	
	
	
	<c:set var="count" value="${count+1}"/>
	</c:forEach>
    </ul>   

    </section>
</body>
</html>