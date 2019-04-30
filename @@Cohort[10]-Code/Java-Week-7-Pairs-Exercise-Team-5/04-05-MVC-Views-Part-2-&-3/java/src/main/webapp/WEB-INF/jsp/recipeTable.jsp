<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:import url= "/WEB-INF/jsp/recipeHeader.jsp">
</c:import>

    <section id="main-content">
    <h2 id="recipes-title">Recipes</h2>
           <table>
            <tr class = "table-image">
            	<th></th>
            	<c:forEach var = "image" items = "${requestScope.recipes}">
            	<c:url var = "url" value = "recipeDetails?recipeId=${image.getRecipeId()}"/>
					<td><a href = "${url}"><img src = "img/recipe${recipes.indexOf(image)}.jpg"/></a>
   				    </td>
   				</c:forEach>
            </tr>
            <tr>
            	<th class = "row-names">Name</th>
            	<c:forEach var = "name" items = "${requestScope.recipes}">
           
            	<td>${name.getName()}</td>
            	</c:forEach>
            </tr>
            <tr>
            	<th class = "row-names">Type</th>
            	<c:forEach var = "recipeType" items = "${requestScope.recipes}">
            	<td>${recipeType.getRecipeType()}</td>
            	</c:forEach>
            </tr>
            <tr>
            	<th class = "row-names">Ingredients</th>
            	<c:forEach var = "ingredient" items = "${requestScope.recipes}">
             	<td>${ingredient.ingredients.size()}     ingredients </td>
            	
            	</c:forEach>
                </tr>
                <tr>
            	<th class = "row-names">Rating</th>
            	<c:forEach var = "ratings" items = "${requestScope.recipes}">

   				<td><img class = "photo" src = "img/${Math.round(ratings.averageRating)}-star.png"/>
   				</td>
            	
            	</c:forEach>
            </tr>
          </table>
       <!-- Use the request attribute "recipes" (List<Recipe>) -->

    </section>
</body>
</html>