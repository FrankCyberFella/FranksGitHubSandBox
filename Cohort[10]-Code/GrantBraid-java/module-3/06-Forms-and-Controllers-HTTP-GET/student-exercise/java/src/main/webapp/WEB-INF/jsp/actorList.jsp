<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>

<!-- Form goes here -->



<c:url var="formAction" value="/actorList" />
<form:form action="${formAction}" method="POST" modelAttribute="Actor">
	<div>
		<label for="lastName">Enter Last Name:</label>
		<form:input path="lastName" class="form-control"/>
		<form:errors path="lastName" cssClass="error" />
	</div>
	<input type="submit" value="submit" />
</form:form>





<%@include file="common/footer.jspf"%>