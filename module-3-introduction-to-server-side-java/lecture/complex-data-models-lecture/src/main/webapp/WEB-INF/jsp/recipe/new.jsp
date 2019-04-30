<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="New Recipe"/>

<%@include file="../common/header.jspf"%>
<c:url var="actionUrl" value="/recipe/new"/>
<form:form modelAttribute="recipe" method="POST" action="${actionUrl }">

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
</tr>

<tr>
<td><form:input path="ingredients[0].quantity"  class="form-control"/></td>
<td><form:input path="ingredients[0].type"  class="form-control"/></td>
<td>&nbsp;</td>
</tr>
<tr>
<td><form:input path="ingredients[1].quantity" class="form-control"/></td>
<td><form:input path="ingredients[1].type" class="form-control"/></td>
<td>&nbsp;</td>
</tr>
<tr>
<td><form:input path="ingredients[2].quantity" class="form-control"/></td>
<td><form:input path="ingredients[2].type" class="form-control"/></td>
<td>&nbsp;</td>
</tr>
<tr>
<td><form:input path="ingredients[3].quantity" class="form-control"/></td>
<td><form:input path="ingredients[3].type" class="form-control"/></td>
<td>&nbsp;</td>
</tr>
<tr>
<td><form:input path="ingredients[4].quantity" class="form-control"/></td>
<td><form:input path="ingredients[4].type" class="form-control"/></td>
<td>&nbsp;</td>
</tr>
</table>
<input type="submit" name="submit" value="Save New Recipe"/>
</form:form>
<a href="<c:url value="/recipe/list"/>">Back to List</a>
<%@include file="../common/footer.jspf"%>