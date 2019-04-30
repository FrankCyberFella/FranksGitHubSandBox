<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp"/>

    <section id="main-content">
    <h2>Toy Department</h2>
	<table>
	<c:forEach var="toy" items="${productList}">
	<div id="row">
	<div id="images"><a href="productDetail?productId=${toy.getProductId()}"><img src="img/${toy.imageName}"></a></div>
				<ul>
					<li id="toyNames">${toy.name}<c:if test="${toy.topSeller == true}"><span id="bestSeller">  BEST SELLER!</span></c:if></li>
					<li id="maker">by ${toy.manufacturer}</li>
					<li id="stock"><c:if test="${toy.remainingStock <= 3}">Only ${toy.remainingStock} left!!!?!!??!</c:if></li>
					<li id="price">$${toy.price}</li>
					<li id="weightLine"><span id ="weight">Weight </span>${Math.round(toy.weightInLbs)} lbs</li>
					<li><img id="stars" src= "img/${Math.round(toy.averageRating)}-star.png"></li>
				</ul>
				</div>
			</c:forEach>
     </table>
    </section>
</body>
</html>