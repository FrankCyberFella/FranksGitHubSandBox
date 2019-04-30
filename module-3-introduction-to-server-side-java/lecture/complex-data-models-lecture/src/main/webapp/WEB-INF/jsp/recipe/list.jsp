<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Recipes"/>

<%@include file="../common/header.jspf"%>
<table class="table">
<tr>
<th>Name</th>
<th>Cooking Time</th>
</tr>
<c:forEach items="${recipes}" var="recipe">
<tr>
<c:url var="recipeDetail" value="/recipe/detail">
<c:param name="recipeId" value="${recipe.id}"/>
</c:url>
<td><a href="${recipeDetail}"><c:out value="${recipe.name}"/></a></td>
<td><c:out value="${recipe.durationInMinutes }"/> Minutes</td>
</tr>
</c:forEach>
</table>
<c:url var="newRecipeUrl" value="/recipe/new"/>
<a href="${newRecipeUrl }">Add a Recipe</a>
<%@include file="../common/footer.jspf"%>