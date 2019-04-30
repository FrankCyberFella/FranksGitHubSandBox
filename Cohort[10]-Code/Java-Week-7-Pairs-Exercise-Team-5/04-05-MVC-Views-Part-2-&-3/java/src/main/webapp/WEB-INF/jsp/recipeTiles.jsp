<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:import url= "/WEB-INF/jsp/recipeHeader.jsp">
</c:import>

    <section id="main-content">
    		<div id = "mainDiv">
    		<c:forEach var = "item" items = "${requestScope.recipes}">
    		<c:url var = "url" value = "recipeDetails?recipeId=${item.getRecipeId()}"/>
    		<div id = "tileDiv">
    		<div><a href = "${url}"><img id = "tilePhoto" src = "img/recipe${recipes.indexOf(item)}.jpg"/></a></div>
			<h4>${item.getName()}</h4> 
			<div><img id = "tileStar" src = "img/${Math.round(item.averageRating)}-star.png"/></div>
			<p>${item.ingredients.size()}     ingredients</p>
			</div>
			</c:forEach>
			</div>
	
<%-- 		<div class = "recipeDisplay"> 
	    	<div id = "image">
	    		<c:forEach var = "image" items = "${requestScope.recipes}">
	   				<img class = "photo" src = "img/recipe${recipes.indexOf(image)}.jpg"/>
	   			</c:forEach>
	   		</div>
	   		<div id = "name">
	   			<c:forEach var = "name" items = "${requestScope.recipes}">
	           
	            	<p>${name.getName()}</p>
	            </c:forEach>
	   		
	   		</div>
	   		<div id = "rating">
	   			<c:forEach var = "ratings" items = "${requestScope.recipes}">
	   					<img class = "tiles-image" src = "img/${Math.round(ratings.averageRating)}-star.png"/>
	            </c:forEach>
	   		
	   		</div>
	   		
	   		<div id = "ingredientAmt">
	   			<c:forEach var = "ingredient" items = "${requestScope.recipes}">
	            	<p>${ingredient.ingredients.size()}     ingredients </p>    	
	            </c:forEach>
	   		
	   		</div>
	   	</div> --%>

       <!-- Use the request attribute "recipes" (List<Recipe>) -->

    </section>
</body>
</html>