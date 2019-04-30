<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="pageTitle" value="Home Page"/>
<%@include file="common/header.jspf" %>

<h2>New User Registration</h2>
<c:url var="submitPath" value="/register"/>
<form:form action="${submitPath}" method="POST" modelAttribute="Registration" >
	<label for="firstName">First Name:</label>
	<form:input path="firstName" class="form-control"/>
	<form:errors path="firstName"  cssClass="error"/>
	<label for="lastName">Last Name:</label>
	<form:input path="lastName" class="form=control"/>
	<form:errors path="lastName" cssClass="error"/>
	<label for="email">Email:</label>
	<form:input path="email" class="form=control"/>
	<form:errors path="email" cssClass="error"/>
	<label for="verifyEmail">Confirm Email:</label>
	<form:input path="verifyEmail" class="form=control"/>
	<form:errors path="verifyEmail" cssClass="error"/>
	<form:errors path="emailMatching" cssClass="error"/>
	<label for="password">Password:</label>
	<form:password path="password" class="form=control"/>
	<form:errors path="password" cssClass="error"/>
	<label for="verifyPassword">Confirm Password:</label>
	<form:password path="verifyPassword" class="form=control"/>
	<form:errors path="verifyPassword" cssClass="error"/>
	<form:errors path="passwordMatching" cssClass="error"/>
	<label for="birthDate">Birthday:</label>
	<form:input type="date" path="birthDate" class="form=control"/>
	<form:errors path="birthDate" cssClass="error"/>
	<label for="tickets"># of Tickets:</label>
	<form:input path="tickets" type="number" class="form=control"/>
	<form:errors path="tickets" cssClass="error"/>
	<input type="submit" value="submit">
	
</form:form>


<%@include file="common/footer.jspf" %>
