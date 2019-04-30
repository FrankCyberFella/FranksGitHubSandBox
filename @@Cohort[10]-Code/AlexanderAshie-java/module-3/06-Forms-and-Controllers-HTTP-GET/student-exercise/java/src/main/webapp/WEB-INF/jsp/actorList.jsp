<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>

<c:url var="formAction" value="/actorList" />
<form:form action="${formAction}" method="POST" modelAttribute="Actor">

    <form:input  path="lastName" />
	<input type="submit" value="Submit" />
	<form:errors path="lastName" cssClass="error"/> 
	
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