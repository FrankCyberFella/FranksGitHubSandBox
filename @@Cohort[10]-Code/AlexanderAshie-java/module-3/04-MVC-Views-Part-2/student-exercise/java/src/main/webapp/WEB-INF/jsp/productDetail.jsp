	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<c:import url="/WEB-INF/jsp/viewtemplate.jsp">
	</c:import>
    
    <section id="main-content">
    	
    			<div>
    				<img src="img/${product.imageName}"/>
    				
    				<div style="margin-top: 30px;">
    					<h2>${product.name}</h2>
    					<p>${product.manufacturer}</p>
    					<img style="height: 20px" src="img/${Math.round(product.averageRating)}-star.png"/>
    					<br>
    					<h3 style="color: red">$${product.price}</h3>
    					<p>Weight ${Math.round(product.weightInLbs)} lbs</p>
    					<br>
    					<p>Description: ${product.description}</p>
    					
    				</div>
    				
    			</div>

    </section>
    
</body>
</html>