<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/header.jsp"/>
 
    
    



 <c:set var="id" value="${param.productId}"/>
 
 <section id="detail-main-content">

    <h2>${product.name}</h2>
    <div id="description">
    <img src="img/${product.imageName}"/>
   	<div>
    <div id="name"> ${product.name} <c:if test="${product.topSeller == true}"> <span style="color: red"> <strong><em>Top Seller!</em></strong></span></c:if></div>
	<div id="manufacturer">by ${product.manufacturer}</div>
		<p></p>
	<div id="price">$${product.price}</div>

		<p></p>
    <div id="weight">Weight: ${product.weightInLbs} lbs.</div>
    <p></p>
	<div id="descriptionMark">
	<div><b>Description: </b></div><div>${product.description}</div>
	</div>
	
		</div>
    
    </div>
   </section>
   </body>
</html>