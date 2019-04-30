<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/template.jsp"/>
	    

    <section id="main-content">
    <h2>Recipes</h2>
    
	<table>
       <!-- Use the request attribute "recipes" (List<Recipe>) -->
       
        <tr>
       	<th></th>
       	<c:forEach var="recipe" items="${recipes}">
       	
       	<td><a href="recipeDetails?recipeId=${recipe.getRecipeId()}"><img src="img/recipe${recipe.getRecipeId()}.jpg"></a> </td>
       	</c:forEach>
		</tr>
       
       <tr style="background: #DDf">
       	<th>Name</th>
       	<c:forEach var="recipe" items="${recipes}">
					<td id="name">${recipe.name}</td>
		</c:forEach>
		</tr>
		
		
		<tr>
       <th>Type</th>
       <c:forEach var="recipe" items="${recipes}">
       				<td id="type">${recipe.recipeType}</td>			
		</c:forEach>
		<th>
		</tr>
		
		
		<tr style="background: #DDf">
       <th>Cook Time</th>
       <c:forEach var="recipe" items="${recipes}">
					<td id="time">${recipe.cookTimeInMinutes}</td>
		</c:forEach>
		</tr>
		
		<tr>
		<th>Ingredients</th>
		
		<c:forEach var="recipe" items="${recipes}">
			<c:set var="count" value="0"/>
			<c:forEach var="ingred" items="${ingredients}">
				<c:set var="count" value="${count + 1}"/>
			</c:forEach>
					<td id="ingredients">${recipe.ingredients.size()}</td>
			
		</c:forEach>
		</tr>
		
		<tr style="background: #DDf">
       <th>Rating</th>
       <c:forEach var="recipe" items="${recipes}">
					<td id="rating"><img id="stars" src= "img/${Math.round(recipe.averageRating)}-star.png"></td>
		</c:forEach>
		</tr>
					
			
	</table>
    </section>

<c:import url="/WEB-INF/jsp/template2.jsp"/>