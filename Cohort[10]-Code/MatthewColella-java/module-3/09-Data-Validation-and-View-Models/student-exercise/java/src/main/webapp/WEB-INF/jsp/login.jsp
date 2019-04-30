<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Home Page"/>
<%@include file="common/header.jspf" %>

<h2>Login</h2>

<c:url var="action" value="/login"></c:url>
<form:form method="POST" action="${action}" modelAttribute="Login">
	<div>
	<label for="email">Email:</label> 
		<form:input  path="email" />            
        	<form:errors path="email" cssClass="error"/>
	</div>
	<div>
	<label for="password">Password:</label> 
		<form:input  path="password" />            
        	<form:errors path="password" cssClass="error"/>
	</div>
	<input type="submit" value="Login"/>

</form:form>



<%@include file="common/footer.jspf" %>