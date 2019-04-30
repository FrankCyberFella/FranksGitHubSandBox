
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<c:import url="/WEB-INF/jsp/header.jsp">
	    <c:param name="title" value="Recipe Table View" />
	</c:import>

	 <section id="main-content">
	 	<div id="detail-wrapper">
		 	<div id="detail-header" class="detail-wrapper">
		 		<span>
		 			<img src="img/recipe${param.recipeId}.jpg">
		 		</span>
		 		<span id="header-text">
		 			<strong>${recipe.getName()}</strong>
		 				<br>
		 				${recipe.getRecipeType()}
		 				<br>
		 				<br>
		 				<strong>Cook Time</strong>
		 				${recipe.getCookTimeInMinutes()} minutes
		 				<br>
		 				<br>
		 				${recipe.getDescription()}
		 		</span>
		 		
		 	</div>
		 		
		 	<div class="detail-wrapper">
		 		Ingredients
		 		<ul>
		 			<c:forEach var="ingredient" items="${recipe.getIngredients()}">
		 				<li>${ingredient.getQuantity()} ${ingredient.getName()}</li>
		 			</c:forEach>
		 		
		 		
		 		</ul>
		 		<hr>
		 	</div>
		 	
		 	<div class="detail-wrapper">
		 		Preparation
		 		<ol>
		 			<c:forEach var="steps" items="${recipe.getPreparationSteps()}">
		 				<li>${steps}</li>
		 			</c:forEach>
		 		
		 		</ol>
		 	</div>
	 	</div>
	 
	 