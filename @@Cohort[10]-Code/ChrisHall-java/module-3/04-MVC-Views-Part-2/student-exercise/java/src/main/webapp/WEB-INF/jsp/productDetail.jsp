<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<c:import url="/WEB-INF/jsp/headder.jsp">
	    <c:param name="title" value="Toy Detail View" />
	</c:import>
	
	<section id="main-content">
	 	<div id="detail-wrapper">
		 	<div id="detail-header" class="detail-wrapper">
		 		<span>
		 			<img src="img/${product.getImageName()}">  <!-- if I change this to ${recipe.recipeId} it still works -->
		 		</span>
		 		<span id="header-text">
		 			<strong>${product.getName()}</strong>
		 				${product.getManufacturer()}
		 				<img src="img/${Math.round(product.getAverageRating())}-star.png">
		 				
		 				<br>
		 				${product.getPrice()}
		 				${product.getWeightInLbs()}
		 				<br>
		 				Description: ${product.getDescription()}
		 		</span>
		 		
		 		
		 	</div>
		 		
		</div> 	
		
		</section> 	
		 	