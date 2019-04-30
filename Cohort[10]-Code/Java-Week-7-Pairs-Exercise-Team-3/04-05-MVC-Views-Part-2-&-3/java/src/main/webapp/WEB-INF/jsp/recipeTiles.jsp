<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<meta name="viewport" content="width=device-width" />
<title>Recipe List View</title>
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

		<h1 id="tileHeader">Recipes</h1>

		<div class="content">

			<c:forEach var="recipe" items="${recipes}">

				<div class="recipeCard">
					<img id="recipeImg" src="img/recipe${recipe.recipeId}.jpg">
					<div class="recipeName">${recipe.name}</div>
					
					<div class="numStars">
					<c:set var="count" value="0" />
					<c:forEach var="ingredients" items="${recipe.ingredients}">
						<c:set var="count" value="${count + 1}" />
					</c:forEach>

					<img id="starImg"
						src="img/${Math.round(recipe.averageRating)}-star.png">
					${count} ingredients
					</div>
				</div>

			</c:forEach>

		</div>

		<!-- Use the request attribute "recipes" (List<Recipe>) -->
	</section>
</body>
</html>