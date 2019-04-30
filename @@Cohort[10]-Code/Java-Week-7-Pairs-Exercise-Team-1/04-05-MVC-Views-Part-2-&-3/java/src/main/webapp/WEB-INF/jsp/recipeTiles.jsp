<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp"/>

    	<h1>Recipes</h1>
    	<div id="recipes">
    	<c:forEach var="recipe" items="${recipes}">
    		<div class="list">
    			<a class="detail-img-link" href="recipeDetails?recipeId=${recipe.recipeId}">
    				<img class="photo" src="img/recipe${recipe.recipeId}.jpg"/>
    			</a>
    			<h4><a class="detail-link" href="recipeDetails?recipeId=${recipe.recipeId}">${recipe.name}</a></h4>
    			 <img class="star" src="img/${Math.round(recipe.averageRating)}-star.png"/>
    			<p>${recipe.ingredients.size()} ingredients </p>
    		</div>
    	
    	</c:forEach>
    	</div>

       <!-- Use the request attribute "recipes" (List<Recipe>) -->

<c:import url="/WEB-INF/jsp/footer.jsp"/>