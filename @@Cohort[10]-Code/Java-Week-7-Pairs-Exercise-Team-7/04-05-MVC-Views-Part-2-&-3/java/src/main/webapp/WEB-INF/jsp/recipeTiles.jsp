<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/template.jsp"/>

	<section id="tile-main-content">

    <h1>Recipes</h1>
    
    <div id="tiles">
    
   <c:set var="i" value="0"/>		
	<c:forEach var="recipe" items="${recipes}">
	
	<div id="recipes">
   			<a href="recipeDetails?recipeId=${recipe.getRecipeId()}"><img src="img/recipe${recipe.getRecipeId()}.jpg"></a> 
   		<h3>${recipe.name}</h3>

   		<div id="rating2">
   		<img src= "img/${Math.round(recipe.averageRating)}-star.png">
   		<span id="ingredients">${recipe.ingredients.size()} ingredients
   		</span></div>
   	
   	<c:set var="i" value="${i+1}"/>
   	</div>
   	</c:forEach>
   	</div>
   	</section>
    
<c:import url="/WEB-INF/jsp/template2.jsp"/>