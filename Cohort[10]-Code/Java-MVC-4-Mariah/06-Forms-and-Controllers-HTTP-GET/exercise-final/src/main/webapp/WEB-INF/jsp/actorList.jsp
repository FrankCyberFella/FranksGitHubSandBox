<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>

<c:url var="actorSearchURL" value="/actorList" />
<form method="GET" action="${actorSearchURL}">
	<label for="name">Last Name: </label>
	<input type="text" id="name" name="name" placeholder="e.g. Cage">
	<input type="submit" value="Search">
</form>

<table class="table">
<tr>
<th>Name</th>
</tr>
<c:forEach items="${actors}" var="actor">
<tr>
	<td>${actor.firstName} ${actor.lastName}</td>
</tr>
</c:forEach>
</table>
<%@include file="common/footer.jspf"%>