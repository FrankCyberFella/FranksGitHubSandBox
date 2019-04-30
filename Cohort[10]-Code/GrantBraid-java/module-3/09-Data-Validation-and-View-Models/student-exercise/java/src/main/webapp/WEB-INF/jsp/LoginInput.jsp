<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<c:set var="pageTitle" value="Home Page"/>
<%@include file="common/header.jspf" %>

<h2>Login</h2>

<c:url value="/login" var="loginInput" />
<form:form action="${loginInput}" method="POST" modelAttribute="Login">
	<div>
		<label for="email">Email:</label>
		<form:input path="email"  class="form-control"/>
		<form:errors path="email"  cssClass="error" />
	</div>
	<div>
		<label for="username">Username:</label>
		<form:input path="username" class="form-control"/>
		<form:errors path="username" cssClass="error" />
	</div>

	<input type="submit" value="submit" />
</form:form>



<%@include file="common/footer.jspf" %>
