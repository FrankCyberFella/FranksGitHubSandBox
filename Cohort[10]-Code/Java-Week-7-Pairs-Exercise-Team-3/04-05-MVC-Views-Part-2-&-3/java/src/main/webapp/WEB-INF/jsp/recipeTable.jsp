<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>Recipe Table View</title>
    <link rel="stylesheet" href="css/site.css" />
</head>
<body>
    <header>
        <h1>MVC Exercises - Views Part 2: Models</h1>        
    </header>
    <nav>
        <ul>
            <li><a href="recipeTiles">Tile Layout</a></li>
            <li><a href="recipeTable">Table Layout</a></li>
        </ul>
        
    </nav>
    <section id="main-content">
    
    <h1 id="header">Recipes</h1>
    
    <div id="recipesDiv">
    
    <table id="titleTable">
    
    	<tr id="titles">
  
    		<td id="tableName">Name</td>
    		<td id="tableType">Type</td>
    		<td id="tableTime">Cook Time</td>
    		<td id="tableIng">Ingredients</td>
    		<td id="tableRating">Rating</td>
   		 </tr>
    </table>
    	
		<c:forEach var="recipe" items="${recipes}">
			<c:set var="count" value="0" />
			<c:forEach var="ingredients" items="${recipe.ingredients}">
			<c:set var="count" value="${count + 1}" />
			</c:forEach>
				
					<table>
					<tr>
						<td id="image"><img src="img/recipe${recipe.recipeId}.jpg"> </td>
						<td id="name">${recipe.name}</td>
						<td id="type">${recipe.recipeType}</td>
						<td id="time">${recipe.cookTimeInMinutes}</td>
						<td id="count">${count} ingredients</td>
						<td id="stars"><img src="img/${Math.round(recipe.averageRating)}-star.png"></td>
					</tr>
					</table>
			
			
			
			
		</c:forEach>
		
		</div>
       <!-- Use the request attribute "recipes" (List<Recipe>) -->

    </section>
</body>
</html>