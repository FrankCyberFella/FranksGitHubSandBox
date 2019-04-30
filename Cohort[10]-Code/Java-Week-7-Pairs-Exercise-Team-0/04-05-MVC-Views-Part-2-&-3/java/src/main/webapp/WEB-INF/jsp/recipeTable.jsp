<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/viewTemplate.jsp"/>


	<section id="main-content">

			
		<c:import url="/WEB-INF/jsp/Tite.jsp">
	    <c:param name="pageTitle" value="Recipes" />  
		</c:import>
	
		<table style="display: inline-block; width: 75px">
			<tr>
				<td>Name<td>
			</tr>
			<tr>
				<td>Type<td>
			</tr>
			<tr>
				<td>Cook Time<td>
			</tr>
			<tr>
				<td>Ingredients<td>
			</tr>
			<tr>
				<td>Rating<td>
			</tr>
		</table>
			
		<c:forEach var="recipe" items="${requestScope.recipes}">
		
			<table style="display: inline-block">
				<tr>
					<th><a href="recipeDetails?recipeId=${recipe.recipeId}"><img style="display: inline-block" src="img/recipe${recipe.recipeId}.jpg"></a></th>
				</tr>
			
				<tr style="background-color: #D1D1D1">
					<td>${recipe.name}</td>
				</tr>
				
				<tr>
					<td>${recipe.recipeType}</td>
				</tr>
				
				<tr style="background-color: #D1D1D1">
					<td>${recipe.cookTimeInMinutes}</td>
				</tr>
				
				<tr>
					<td>${recipe.ingredients.size()}</td>
				</tr>
				
				<tr style="background-color: #D1D1D1">
					<td><img src="img/${Math.round(recipe.averageRating)}-star.png"/></td>
				</tr>
				
			</table>
				
		</c:forEach>
		
		<!-- Use the reque
       cst attribute "recipes" (List<Recipe>) -->

	</section>
	
	<c:import url="/WEB-INF/jsp/footer.jsp"/>
