<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Home Page"/>
<%@include file="common/header.jspf" %>

<h2>Login</h2>
<c:url var="signIn" value="/login"/>
<form:form action="${signIn}" method="POST" modelAttribute="Login">
	<label for="email">Email: </label>
	<form:input  path="email"  class="form-control"/>
    <form:errors path="email"  cssClass="error"/>
    <label for="password">Password: </label>
	<form:input  path="password"  class="form-control"/>
    <form:errors path="password"  cssClass="error"/>
    <input class="formSubmitButton" type="submit" value="Search" />
</form:form>
<%@include file="common/footer.jspf" %>