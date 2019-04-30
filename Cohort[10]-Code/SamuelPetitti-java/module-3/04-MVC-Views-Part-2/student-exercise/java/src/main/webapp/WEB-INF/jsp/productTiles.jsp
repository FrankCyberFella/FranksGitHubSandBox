<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url = "/WEB-INF/jsp/header.jsp"/>

    <section id="main-content">
    <h1>Toy Department</h1>
    <div id ="mainDiv">
    <c:forEach var = "name" items = "${requestScope.productList}">
   				<c:url var = "url" value = "productDetail?productId=${name.productId}"></c:url>
   				<div id ="tileDiv">
           		<div id = "tilePhoto"><a href = "${url}"><img src="img/${name.imageName}"></a></div>
           		<h4>${name.name}</h4>
           		<div>${name.averageRating}</div>
           		<div>${name.manufacturer}</div>
           		<div>$${name.price}</div>
           		<div><img id = "tileStar" src = "img/${Math.round(name.averageRating)}-star.png"/></div>
    	 </div>
           		
           </c:forEach>
</div>
       

    </section>
</body>
</html>

