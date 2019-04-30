<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<c:import url="/WEB-INF/jsp/header.jsp">
	    <c:param name="title" value="Recipe Table View" />
	</c:import>

    <section id="main-content">
    	Recipes
    	<table>
    		<tr>
    			<th></th>
    			<c:forEach var="recipeData" items="${recipes}">
    				<c:url var="detailLink" value="recipeDetails?recipeId=${recipeData.getRecipeId()}"/>
    				<td><a href="${detailLink}"><img src="img/recipe${recipeData.getRecipeId()}.jpg"></a></td>
    			</c:forEach>
    		</tr>
    		<tr>
    			<th>Name</th>
    			<c:forEach var="recipeData" items="${recipes}">
    				<td>${recipeData.getName()}</td>
    			</c:forEach>
    		</tr>
    		<tr>
    			<th>Type</th>
    			<c:forEach var="recipeData" items="${recipes}">
    				<td>${recipeData.getRecipeType()}</td>
    			</c:forEach>
    		</tr>
    		<tr>
    			<th>Cook Time</th>
    			<c:forEach var="recipeData" items="${recipes}">
    				<td>${recipeData.getCookTimeInMinutes()} min</td>
    			</c:forEach>
    		</tr>
    		<tr>
    			<th>Ingredients</th>
    			<c:forEach var="recipeData" items="${recipes}">
    				<td>${recipeData.getIngredients().size()} ingredients</td>
    			</c:forEach>
    		</tr>
    		<tr>
    			<th>Rating</th>
    			<c:forEach var="recipeData" items="${recipes}">
    				<td><img src="img/${Math.round(recipeData.getAverageRating())}-star.png"></td>
    			</c:forEach>
    		</tr>
    	</table>

       <!-- Use therequest attribute "recipes" (List<Recipe>) -->

    </section>
</body>
</html>