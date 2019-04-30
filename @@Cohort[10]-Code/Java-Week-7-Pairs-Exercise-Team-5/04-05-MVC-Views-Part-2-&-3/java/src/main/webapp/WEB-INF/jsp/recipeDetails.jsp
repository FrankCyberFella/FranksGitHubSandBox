<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="/WEB-INF/jsp/recipeHeader.jsp">
</c:import>

<section id="main-content">
	<div id="detail">
		<c:set var="id" value="${param.recipeId}" />
		<img id="desc-image" src="img/recipe${id}.jpg" />
		<div class="overview">
			<p id="detail-name">${recipe.name}</p>
			<p id="detail-type">${recipe.recipeType}</p>
			<b>Cook Time: </b><span>${recipe.cookTimeInMinutes} </span> minutes

			${recipe.description}
		</div>
		<div id="detail-ingredients">
			<h2>Ingredients</h2>
			<ul id="detail-ing-list">
				<c:forEach var="ingredient" items="${recipe.ingredients}">
					<li id="detail-ing-list">${ingredient.quantity}
						${ingredient.name}</li>
				</c:forEach>
			</ul>
		</div>
		<hr>
		<div id="detail-prep">
			<h2>Preparation</h2>
			<ol>
				<div>
					<c:forEach var="steps" items="${recipe.preparationSteps}">
						<li>${steps}</li>
					</c:forEach>
				</div>
			</ol>
		</div>
	</div>
</section>

</body>
</html>