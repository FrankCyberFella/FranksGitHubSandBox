<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url = "/WEB-INF/jsp/header.jsp"/>

    <section id="main-content">
    		<h1>Toy Department</h1>
            <ul id = "listFlex">
 		<c:forEach var = "name" items = "${requestScope.productList}">
 				<c:url var = "url" value = "productDetail?productId=${name.getProductId()}"></c:url>
           		<li id ="listImage"><a href = "${url}"><img href src="img/${name.getImageName()}"></a></li>
           		<div id ="listItems">
           		<h4 id= listName>${name.name}</h4>
           		<li>${name.averageRating}</li>
           		<li>${name.manufacturer}</li>
           		<li>$${name.price}</li>
           		<div><img id = "tileStar" src = "img/${Math.round(name.averageRating)}-star.png"/></div>
           		</div>
            </c:forEach>
           </ul>
        
    </section>
</body>
</html>