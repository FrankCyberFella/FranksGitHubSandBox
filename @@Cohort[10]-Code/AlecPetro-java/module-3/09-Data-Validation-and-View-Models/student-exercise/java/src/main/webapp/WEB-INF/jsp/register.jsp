<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Home Page"/>
<%@include file="common/header.jspf" %>
<c:url value="/register" var="register" />

<h2>Register</h2>

<form:form action="${register}" method="POST" modelAttribute="Register">
		<!-- form:errors path="*" cssClass="error"/ -->
        <div>
        	<label for="firstName">First Name</label>
        	<form:input  path="firstName"  class="form-control"/> <!-- name= identify the variable in the model backing form -->
        													 <!-- class="form-control" - it's a text box (instead of type=text) -->
        	<form:errors path="firstName"  cssClass="error"/>	<!-- Put any error message here -->
        													<!-- cssClass attribute IS the name for the error indicator -->
        </div>
        
       <div>
        	<label for="lastName">Last Name</label>
        	<form:input  path="lastName"  class="form-control"/> <!-- name= identify the variable in the model backing form -->
        													 <!-- class="form-control" - it's a text box (instead of type=text) -->
        	<form:errors path="lastName"  cssClass="error"/>	<!-- Put any error message here -->
        													<!-- cssClass attribute IS the name for the error indicator -->
        </div>
        <div>
            <label for="email">Email</label>
			<form:input  path="email" class="form-control"/>            
        	<form:errors path="email" cssClass="error"/>
        	<form:errors path="emailMatching" cssClass="error"/>
        </div>

        <div>
            <label for="verifyEmail">Verify Email</label>
            <form:input  path="verifyEmail" class="form-control"/>
            <form:errors path="verifyEmail" cssClass="error"/>
        </div>
        
        <div>
            <label for="password">Password</label>
			<form:input  path="password" type="password" class="form-control"/>            
        	<form:errors path="password" cssClass="error"/>
        	<form:errors path="passwordMatching" cssClass="error"/>
        </div>

        <div>
            <label for="verifyPassword">Verify Password</label>
            <form:input  path="verifyPassword" type="password" class="form-control"/>
            <form:errors path="verifyPassword" cssClass="error"/>
        </div>
        
        
        <div>
            <label for="numOfTickets">Number of Tickets</label>
            <form:input  path="numOfTickets" class="form-control"/>
            <form:errors path="numOfTickets" cssClass="error"/>
        </div>
        
        

       
        
        <div>
            <input type="submit" value="Sign Me Up!"/> <!-- all the variables are placed in the response body  -->
        </div>
</form:form>
      



<%@include file="common/footer.jspf" %>
