<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/viewTemplate.jsp"/>

<section id="main-content">

	<img style="width: 25%" src="img/recipe${recipe.recipeId}.jpg"/>
	
	<div style="display: inline-block">
		<h3>${recipe.name}</h3>
		<p>${recipe.recipeType}</p>
		<br>
		<h5>Cook Time: ${recipe.cookTimeInMinutes} minutes</h5>
		<br>
		<p>${recipe.description}</p>
	</div>
	
	<h3>Ingredients</h3>
	
	<div style="text-align: left; border-bottom: 2px solid black">
		<ul>
			<c:forEach var="item" items="${recipe.ingredients}">
				<li>${item.quantity} ${item.name}</li>
			</c:forEach>
		</ul>
	</div>
	
	<h3>Ingredients</h3>
		<div style="text-align: left; border-bottom: 2px solid black">
		<ol>
			<c:forEach var="item" items="${recipe.preparationSteps}">
				<li>${item}</li>
			</c:forEach>
		</ol>
	</div>

</section>

<c:import url="/WEB-INF/jsp/footer.jsp"/>