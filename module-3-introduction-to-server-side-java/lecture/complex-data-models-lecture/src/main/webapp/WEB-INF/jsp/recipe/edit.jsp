<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Edit Recipe - ${recipe.name }"/>

<%@include file="../common/header.jspf"%>
<c:url var="actionUrl" value="/recipe/edit"/>
<form:form modelAttribute="recipe" method="POST" action="${actionUrl }">
<form:hidden path="id"/>
<div class="form-group">
<form:label path="name">Name:</form:label>
<form:input path="name" class="form-control"/>
</div>

<div class="form-group">
<form:label path="durationInMinutes">Cook Time:</form:label>
<form:input path="durationInMinutes" class="form-control"/> Minutes
</div>

<div class="form-group">
<form:label path="description">Description:</form:label>
<form:textarea path="description" class="form-control"/>
</div>

<h3>Ingredients:</h3>
<table class="table table-condensed">
<tr>
<th>Quantity</th>
<th>Type</th>
<th>&nbsp;</th>
</tr>
<c:forEach var="ingredient" varStatus="loopStatus" items="${recipe.ingredients }">
<tr>
<td>
	<form:hidden path="ingredients[${loopStatus.index}].id"/>
	<form:input path="ingredients[${loopStatus.index}].quantity" class="form-control"/>
</td>
<td><form:input path="ingredients[${loopStatus.index}].type" class="form-control"/></td>
<c:url var="deleteUrl" value="/recipe/edit/deleteIngredient">
<c:param name="ingredientId" value="${recipe.ingredients[loopStatus.index].id}"/>
<c:param name="recipeId" value="${recipe.id }"/>
</c:url>
<td><a href="${deleteUrl}">DELETE</a></td>
</tr>
</c:forEach>
<c:set var="emptyIngredientCounter" value="${recipe.ingredients.size()}"/>
<tr>
<td><form:input path="ingredients[${emptyIngredientCounter }].quantity"  class="form-control"/></td>
<td><form:input path="ingredients[${emptyIngredientCounter }].type"  class="form-control"/></td>
<td>&nbsp;</td>
</tr>
<tr>
<td><form:input path="ingredients[${emptyIngredientCounter + 1}].quantity" class="form-control"/></td>
<td><form:input path="ingredients[${emptyIngredientCounter + 1}].type" class="form-control"/></td>
<td>&nbsp;</td>
</tr>
<tr>
<td><form:input path="ingredients[${emptyIngredientCounter + 2}].quantity" class="form-control"/></td>
<td><form:input path="ingredients[${emptyIngredientCounter + 2}].type" class="form-control"/></td>
<td>&nbsp;</td>
</tr>
</table>

<input type="submit" name="submit" value="Save Recipe"/>
</form:form>
<a href="<c:url value="/recipe/list"/>">Back to List</a>
<%@include file="../common/footer.jspf"%>