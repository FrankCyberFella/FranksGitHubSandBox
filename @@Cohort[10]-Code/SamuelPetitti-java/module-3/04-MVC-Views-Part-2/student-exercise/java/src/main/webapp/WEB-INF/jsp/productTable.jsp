<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url = "/WEB-INF/jsp/header.jsp"/>
    <section id="main-content">
    	<h1>Toy Department</h1>
            <table>
            <tr>
           <th></th>
           	<c:forEach var= "image" items= "${requestScope.productList}" >
           		<c:url var= "url"  value= "productDetail?productId=${image.productId}"></c:url>
           		<td><a href= "${url}"><img src="img/${image.imageName}"/></a>
           </td>
           </c:forEach>
           </tr>
            <tr class = "table-image"> 
            	<th>name:</th>                    <!-- look in controller for what it's mapping to -->
            	<c:forEach var = "name" items = "${requestScope.productList}">
            	<td>${name.name}</td>
   				</c:forEach>
            </tr>
              <tr> <!-- class = "table-image" -->
            	<th>rating:</th>                    <!-- look in controller for what it's mapping to -->
            	<c:forEach var = "rating" items = "${requestScope.productList}">
            	<td>${rating.averageRating}</td>
   				</c:forEach>
              </tr>
                <tr> <!-- class = "table-image" -->
            	<th>mfr:</th>                    <!-- look in controller for what it's mapping to -->
            	<c:forEach var = "mfr" items = "${requestScope.productList}">
            	<td>${mfr.manufacturer}</td>
   				</c:forEach>
              </tr>
                <tr> <!-- class = "table-image" -->
            	<th>price:</th>                    <!-- look in controller for what it's mapping to -->
            	<c:forEach var = "price" items = "${requestScope.productList}">
            	<td>$${price.price}</td>
   				</c:forEach>
              </tr>
                <tr> <!-- class = "table-image" -->
            	<th>weight:</th>                    <!-- look in controller for what it's mapping to -->
            	<c:forEach var = "wt" items = "${requestScope.productList}">
            	<td>${wt.weightInLbs}</td>
   				</c:forEach>
              </tr>
              
            
            
            </table>

       

    </section>
</body>
</html>