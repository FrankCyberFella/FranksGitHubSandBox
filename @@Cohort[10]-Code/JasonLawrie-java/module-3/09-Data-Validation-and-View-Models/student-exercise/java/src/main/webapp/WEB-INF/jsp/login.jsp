<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="pageTitle" value="Home Page"/>
<%@include file="common/header.jspf" %>

<h2>Login</h2>
<c:url var="submitPath" value="/login"/>
<form:form action="${submitPath}" method="POST" modelAttribute="Login" >
	<label for="email">Email address:</label>
	<form:input path="email" class="form-control"/>
	<form:errors path="email"  cssClass="error"/>
	<label for="password">Password:</label>
	<form:password path="password" class="form=control"/>
	<form:errors path="password" cssClass="error"/>
	<input type="submit" value="submit">
</form:form>
<%@include file="common/footer.jspf" %>