<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp"/>

    	<table id="product-table">
		<caption> Toy Department </caption>
 		 <tr>
 		 	<td id="blank">&nbsp;</td>
 		 	<c:forEach var="product" items="${productList}">
   			  <td>
   			  <a href="productDetail?productId=${product.productId}">
   			  	<img class="table-photo" src="img/${product.imageName}" alt="Stock Photo"/>
   			  	</a>
   			  	<c:if test="${product.topSeller == true }">
			    	<i class="topSeller">Best Seller</i>
			    </c:if>
   			  </td>
    	    </c:forEach>
 	     </tr>
 	     <tr>
 		  <th>Name</th>
 		  <c:forEach var="product" items="${productList}">
 		  <a href="productDetail?productId=${product.productId}">
 	  	    <td class="grey">${product.name}</td> 
 	  	  </a>
 	   	  </c:forEach>
 		 </tr>
 		  <tr>
 		  <th>Rating</th>
 		  <c:forEach var="product" items="${productList}">
 	  	    <td><img class="table-rating" src="img/${Math.round(product.averageRating)}-star.png" alt="Star Rating"/></td> 
 	   	  </c:forEach>
 		 </tr>
 		  <tr>
 		  <th>Mfr</th>
 		  <c:forEach var="product" items="${productList}">
 	  	    <td class="grey">${product.manufacturer}</td> 
 	   	  </c:forEach>
 		 </tr>
 		  <tr>
 		  <th>Price</th>
 		  <c:forEach var="product" items="${productList}">
 	  	    <td>$${product.price}</td> 
 	   	  </c:forEach>
 		 </tr>
 		  <tr>
 		  <th>wt. (in lbs)</th>
 		  <c:forEach var="product" items="${productList}">
 	  	    <td class="grey">${product.weightInLbs} lbs</td> 
 	   	  </c:forEach>
 		 </tr>
		</table>
       

<c:import url="/WEB-INF/jsp/footer.jsp"/>