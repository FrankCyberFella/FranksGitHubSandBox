<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>
<c:url var="formAction" value="/actorList" />
<form:form action="${formAction}" method="POST" modelAttribute="ActorSearch">
<div class="formInputGroup">
	<label for="lastName"> Search</label>
	<form:input path="name" class="form-control"/>
	<form:errors path="name" cssClass="error"/>
</div>
<input class="formSubmitButton" type="submit" value="Submit"/>
<table class="table">
<tr>
<th>Name</th>

</tr>
<c:forEach items="${actors}" var="actor">
<tr>
  <td> ${actor.firstName} ${actor.lastName}</td>
</tr>
</c:forEach>
</table>
</form:form>
<%@include file="common/footer.jspf"%>