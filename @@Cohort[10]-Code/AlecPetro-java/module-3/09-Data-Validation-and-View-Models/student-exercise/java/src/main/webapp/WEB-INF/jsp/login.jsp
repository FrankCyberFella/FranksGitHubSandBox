<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Home Page"/>
<%@include file="common/header.jspf" %>
<c:url value="/login" var="login" />

<h2>Login</h2>
	<form:form action="${login}" method="POST" modelAttribute="Login">
 		<div>
            <label for="email">Email</label>
			<form:input  path="email" class="form-control" placeholder="enter email"/>            
        	<form:errors path="email" cssClass="error"/>
        </div>
        
        <div>
        	<label for="password">Password</label>
        	<form:input  path="password"  class="form-control" placeholder="enter password" type="password"/> <!-- name= identify the variable in the model backing form -->
        													 <!-- class="form-control" - it's a text box (instead of type=text) -->
        	<form:errors path="password"  cssClass="error"/>	<!-- Put any error message here -->
        													<!-- cssClass attribute IS the name for the error indicator -->
        </div> 
        
        <div>
            <input type="submit" value="Login"/> <!-- all the variables are placed in the response body  -->
        </div>
      </form:form>
      
      



<%@include file="common/footer.jspf" %>
