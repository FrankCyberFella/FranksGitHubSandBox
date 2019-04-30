	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<c:import url="/WEB-INF/jsp/viewtemplate.jsp">
	</c:import>


    <section id="main-content">

       <h1>Toy Department</h1>
    
    	<div id="tileview-grid">
    	
    	<c:set var="counter" value="1"/>
    	
    	<c:forEach var="product" items="${productList}">
    	
    		<div id="tileview-item${counter}">
    		
    			<div style="display: flex">
    				<a href="productDetail?productId=${product.productId}"><img src="img/${product.imageName}"/></a>
    				
    				<div style="margin-top: 30px;">
    					<h2>${product.name}</h2>
    					<p>${product.manufacturer}</p>
    					<h3 style="color: red">$${product.price}</h3>
    					<p>Weight ${Math.round(product.weightInLbs)} lbs</p>
    					<img style="height: 20px" src="img/${Math.round(product.averageRating)}-star.png"/>
    				</div>
    				
    			</div>
    		</div>
    		
    		<c:set var="counter" value="${counter + 1}"/>
    		
    	</c:forEach>
    	
    	</div>

    </section>
</body>
</html>