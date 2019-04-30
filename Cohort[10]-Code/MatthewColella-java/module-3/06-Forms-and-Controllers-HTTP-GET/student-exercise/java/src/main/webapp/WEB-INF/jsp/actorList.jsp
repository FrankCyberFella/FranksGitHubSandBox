<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>
<c:url var="formAction" value="/actorList" />
<form:form method="POST" action="${formAction}" modelAttribute="ActorSearch">
	<div>
	<label for="name">Search for an actor by name:</label> 
		<form:input  path="name" />            
        	<form:errors path="name" cssClass="error"/>
	</div>
	<input type="submit" value="Search"/>
</form:form>
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