<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <c:import url="/WEB-INF/jsp/header.jsp">
	</c:import>

       <!-- Use the request attribute "recipes" (List<Recipe>) -->
           <h1>Recipes</h1>
	<c:set var="imgCount" value="0" />
	<table>

	<tr>
	<th></th>
	
		<td><a href="recipeDetails?recipeId=0"><img src= "img/recipe0.jpg"></a></td>
		<td><a href="recipeDetails?recipeId=1"><img src= "img/recipe1.jpg"></a></td>
		<td><a href="recipeDetails?recipeId=2"><img src= "img/recipe2.jpg"></a></td>
		
		</tr>
	<tr>
	<th>Name</th>
	<c:forEach var="currentName" items="${recipes}">
		<td class="grey-bg">${currentName.name}</td>
	</c:forEach>
	</tr>
	<tr>
		<th>Type</th>	
	<c:forEach var="currentType" items="${recipes}">
		<td>${currentType.recipeType}</td>
	</c:forEach>
	</tr>
	<tr>
	    <th>Cook Time</th>
	<c:forEach var="currentCook" items="${recipes}">
		<td class="grey-bg">${currentCook.cookTimeInMinutes}</td>
	</c:forEach>
	</tr>
	<tr>
	<th>Ingredients</th>
	<c:forEach var="ingredients" items="${recipes}">
		<td>${ingredients.ingredients.size()} ingredients</td>
	</c:forEach>
	</tr>
	<tr>
	<th>Rating</th>
	<c:forEach var="currentRating" items="${recipes}">
			<td class = "grey-bg">${currentRating.averageRating}</td>
	</c:forEach>
		</tr>


	</table>

    </section>
</body>
</html>