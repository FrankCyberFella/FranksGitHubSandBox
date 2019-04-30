<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<c:import url="/WEB-INF/jsp/header.jsp">
	    <c:param name="title" value="Recipe Tile View" />
	</c:import>
        
    </nav>
    <section id="main-content">
    	Recipes
    	<span id="tile-page-wrapper">
			<c:forEach var="recipeData" items="${recipes}">
				<span class="tile-wrapper">
					<a href="recipeDetails?recipeId=${recipeData.getRecipeId()}">
						<img class="foodpic" src="img/recipe${recipeData.getRecipeId()}.jpg">
					</a>
					<div class="recipeName">
						${recipeData.getName()}
					</div>
					<img class="tileImg" src="img/${Math.round(recipeData.getAverageRating())}-star.png">
					<div class="tileIngredients" >
						${recipeData.getIngredients().size()} ingredients
					</div>
				</span>
				
			</c:forEach>
		</span>
     

    </section>
</body>
</html>