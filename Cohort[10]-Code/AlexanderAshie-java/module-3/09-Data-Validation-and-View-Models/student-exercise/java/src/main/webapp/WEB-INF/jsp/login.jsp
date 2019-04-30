<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Home Page"/>
<%@include file="common/header.jspf" %>

<h2>Login</h2>

<c:url value="/login" var="loginUrl"/>
<form:form action="${loginUrl}" method="POST" modelAttribute="Login">
	
	    <div>
        	<label for="email">Email</label>
        	<form:input  path="email" value="enter email" class="form-control"/>
        	<form:errors path="email" cssClass="error"/>	
        </div>
        
        <br>
        
        <div>
        	<label for="password">Password</label>
        	<form:input  path="password" value="enter password" class="form-control"/>
        	<form:errors path="password" cssClass="error"/>	
        </div>
        
        <br>
        
        <div>
            <input type="submit" class="btn btn-primary" value="Submit"/>
        </div>

</form:form>

<%@include file="common/footer.jspf" %>