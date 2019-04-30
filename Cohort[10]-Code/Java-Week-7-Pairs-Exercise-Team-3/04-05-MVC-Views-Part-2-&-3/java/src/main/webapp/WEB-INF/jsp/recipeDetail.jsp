<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<section id="main-content-detail">

	<c:forEach var="recipe" items="${recipes}">
		<c:set var="count" value="0" />
		<c:forEach var="ingredients" items="${recipe.ingredients}">
			<c:set var="count" value="${count + 1}" />
		</c:forEach>

			<ul>
				<li id="image"><img src="img/recipe${recipe.recipeId}.jpg">
				</li>
				<li id="name">${recipe.name}</li>
				<li id="type">${recipe.recipeType}</li>
				<li id="time">${recipe.cookTimeInMinutes}</li>
				<li id="count">${count}ingredients</li>
				<li id="stars"><img
					src="img/${Math.round(recipe.averageRating)}-star.png"></li>
			</ul>

	</c:forEach>
	</section>

</body>
</html>