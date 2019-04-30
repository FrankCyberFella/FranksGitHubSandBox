<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<c:set var="pageTitle" value="Home Page"/>
<%@include file="common/header.jspf" %>

<h2>Login</h2>
<section id= "main-content" class= "centeredPanel">
<c:url value="/login" var="loginUrl"/>
<form:form action="${loginUrl}" method="POST" modelAttribute= "Login">
	<div>
		<label for= "email">Email</label>
		<form:input path="email"/>
		<form:errors path="email" cssClass="error"/>
	</div>
	<div>
		<label for="password">Password</label>
		<form:input type="password" path="password"/>
		<form:errors path="password" cssClass="error"/>
	</div>
	<div>
		<input type="submit" value="Submit"/>
	</div>


</form:form>





</section>
</body>
<%@include file="common/footer.jspf" %>



</html>