<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Recipe Detail - ${recipe.name }"/>

<%@include file="../common/header.jspf"%>
<h3>Name:</h3>
<c:out value="${recipe.name }"/>
<h3>Cook Time:</h3>
<c:out value="${recipe.durationInMinutes }"/> Minutes
<h3>Description:</h3>
<p><c:out value="${recipe.description }"/></p>
<h3>Ingredients:</h3>
<table class="table">
<tr>
<th>Quantity</th>
<th>Type</th>
</tr>
<c:forEach var="ingredient" items="${recipe.ingredients }">
<tr>
<td><c:out value="${ingredient.quantity }"/></td>
<td><c:out value="${ingredient.type }"/></td>
</tr>
</c:forEach>
</table>
<a href="<c:url value="/recipe/edit?recipeId=${recipe.id}"/>">Edit Recipe</a>
<a href="<c:url value="/recipe/list"/>">Back to List</a>
<%@include file="../common/footer.jspf"%>