<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp"/>

	<div class="detail-upper">
		<img class="detail-photo" src="img/recipe${recipe.recipeId}.jpg"/>
			<div class="upper-text">
				<h3>${recipe.name}</h3>
    			<h3>${recipe.recipeType}</h3>
    			<h3><strong>Cook Time</strong> ${recipe.cookTimeInMinutes} minutes</h3>
    			<h3 id="detail-description">${recipe.description}</h3>
    		</div>
    </div>	
    
    <div class="detail-middle">
    	<h3>Ingredients</h3>
    	
    			<ul class ="ing-list">
    				<c:forEach var="ingredient" items="${recipe.ingredients}">
    					<li>${ingredient.quantity} ${ingredient.name}</li>
    				</c:forEach>
    			</ul>
    	
    
    
    </div>	
    
    <div class="detail-lower">
    	<h3>Preparation</h3>
    		<ol class ="prep-list">
    				<c:forEach var="preparation" items="${recipe.preparationSteps}">
    					<li>${preparation}</li>
    				</c:forEach>
    			</ol>
    </div>
    	
<c:import url="/WEB-INF/jsp/footer.jsp"/>  