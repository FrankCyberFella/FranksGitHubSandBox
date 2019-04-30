<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp">
</c:import>

   <!-- Use the request attribute "recipes" (List<Recipe>) -->
<c:set var="imgCount" value="0" />



<div class="flexy1">
	<img  src= "img/recipe${recipe.recipeId}.jpg">
	<ul class="block , noPoints">
		
		<li><b>${recipe.name}</b></li>
		<li>${recipe.recipeType}</li>
		<li class="alilSomthinSomthin"><b>Cook Time:</b> ${recipe.cookTimeInMinutes}</li>
		<li class="alilSomthinSomthin">${recipe.description}</li>
	</ul>

</div>

<div class="listBuddies">
<h3 class="align-left">Ingredients</h3>
	<ul class="listUnordered">
		<c:forEach var="inventory" items="${recipe.ingredients}">
			<li>${inventory.quantity} ${inventory.name}</li>
		</c:forEach>

	</ul>
	

</div>
<div class="preparationList">
<p class="align-left">Preparations</p>
	<ol class="listOrdered">
		<c:forEach var="prep" items="${recipe.preparationSteps}">
		<li>${prep}</li>
		</c:forEach>
	</ol>
</div>


</section>
</body>
</html>
