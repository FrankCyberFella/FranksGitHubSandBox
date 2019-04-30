<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp"/>

<section id="tile-main-content">
    
    <h2>Toy Department</h2>
    
    <div id="tiles">
    
    <c:forEach var="toy" items="${productList}">
    
    	<div id="productTiles">
    
	<div id="images"><a href="productDetail?productId=${toy.getProductId()}"><img src="img/${toy.imageName}"></a></div>
    <div id="toyNames3">${toy.name}<c:if test="${toy.topSeller == true}"><span id="bestSeller">  BEST SELLER!</span></c:if></div>
    <div id="manufacturer3">by ${toy.manufacturer}</div>
    <div id="price3">$${toy.price}</div>
    <div id="weightLine3"><span id ="weight3">Weight </span>${Math.round(toy.weightInLbs)} lbs</div>
    <div><img id="stars3" src= "img/${Math.round(toy.averageRating)}-star.png"></div> 
    	</div>  
	</c:forEach>
	</div>
</section>
</body>
</html>