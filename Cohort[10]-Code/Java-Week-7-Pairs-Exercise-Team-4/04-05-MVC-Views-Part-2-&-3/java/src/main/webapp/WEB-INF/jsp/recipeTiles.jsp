<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <c:import url="/WEB-INF/jsp/header.jsp">
	</c:import>

       <!-- Use the request attribute "recipes" (List<Recipe>) -->
           <h1>Recipes</h1>
       <c:set var="imgCount" value="0" />
<c:forEach var="currentRep" items="${recipes}">
	
	<c:set var="count" value="0" />	
	<c:forEach var="ingredient" items="${currentRep.ingredients}">
		<c:set var="count" value= "${count + 1}" />
	</c:forEach>
	
		<ul class ="noPoints">
			<li><a href="recipeDetails?recipeId=${imgCount}"><img src="img/recipe${imgCount}.jpg"></a> </li>
			<li>${currentRep.name}</li>
			<li>${count} ingredients</li>
			<li>${currentRep.averageRating}</li>
	
		</ul>
		<!--<li><img src="img/${Math.round(currentRep.averageRating)}-star.png"}></li> -->
	<c:set var="imgCount" value="${imgCount + 1}" />

	
</c:forEach>

    </section>
</body>
</html>