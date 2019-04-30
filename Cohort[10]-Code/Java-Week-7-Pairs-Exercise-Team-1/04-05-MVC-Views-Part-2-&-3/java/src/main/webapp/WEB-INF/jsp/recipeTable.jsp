<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp"/>


		<table id="recipe-table">
		<caption> Recipes </caption>
 		 <tr>
 		 	<td id="blank">&nbsp;</td>
 		 	<c:forEach var="recipe" items="${recipes}">
   			  <th>
   			  	<a class="detail-img-link"  href="recipeDetails?recipeId=${recipe.recipeId}">
   			  		<img class="table-photo" src="img/recipe${recipe.recipeId}.jpg" alt="Photo of Meal"/>
    	   		</a>
    	   	  </th>	
    	    </c:forEach>
 	     </tr>
 	     <tr>
 		  <th>Name</th>
 		  <c:forEach var="recipe" items="${recipes}">
 	  	    <td class="grey"><a class="detail-link" href="recipeDetails?recipeId=${recipe.recipeId}">${recipe.name}</a></td> 
 	   	  </c:forEach>
 		 </tr>
 		  <tr>
 		  <th>Type</th>
 		  <c:forEach var="recipe" items="${recipes}">
 	  	    <td>${recipe.recipeType}</td> 
 	   	  </c:forEach>
 		 </tr>
 		  <tr>
 		  <th>Cook Time</th>
 		  <c:forEach var="recipe" items="${recipes}">
 	  	    <td class="grey">${recipe.cookTimeInMinutes} min</td> 
 	   	  </c:forEach>
 		 </tr>
 		  <tr>
 		  <th>Ingredients</th>
 		  <c:forEach var="recipe" items="${recipes}">
 	  	    <td>${recipe.ingredients.size()} ingredients</td> 
 	   	  </c:forEach>
 		 </tr>
 		  <tr>
 		  <th>Rating</th>
 		  <c:forEach var="recipe" items="${recipes}">
 	  	    <td class="grey"><img class="table-rating" src="img/${Math.round(recipe.averageRating)}-star.png" alt="Average Rating"/></td> 
 	   	  </c:forEach>
 		 </tr>
		</table>
       <!-- Use the request attribute "recipes" (List<Recipe>) -->
<c:import url="/WEB-INF/jsp/footer.jsp"/>       