<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Home Page"/>
<%@include file="common/header.jspf" %>

<h2>New User Registration</h2>

<c:url value="/newUser" var="newUserUrl"/>
<form:form action="${newUserUrl}" method="POST" modelAttribute="Registration">
	
	    <div>
        	<label for="firstName">First Name</label>
        	<form:input  path="firstName" class="form-control"/>
        	<form:errors path="firstName" cssClass="error"/>	
        </div>
        
        <br>
        
	    <div>
        	<label for="lastName">Last Name</label>
        	<form:input  path="lastName" class="form-control"/>
        	<form:errors path="lastName" cssClass="error"/>	
        </div>
        
        <br>
        
        <div>
        	<label for="email">Email</label>
        	<form:input  path="email" class="form-control"/>
        	<form:errors path="email" cssClass="error"/>	
        	<form:errors path="emailMatching" cssClass="error"/>
        </div>
        
        <br>
        
        <div>
        	<label for="confirmEmail">Confirm Email</label>
        	<form:input  path="confirmEmail" class="form-control"/>
        	<form:errors path="confirmEmail" cssClass="error"/>	
        </div>
        
        <br>
        
        <div>
        	<label for="password">Password</label>
        	<form:input  path="password" class="form-control"/>
        	<form:errors path="password" cssClass="error"/>	
        </div>
        
        <br>
        
        <div>
        	<label for="confirmPassword">Confirm</label>
        	<form:input  path="confirmPassword" class="form-control"/>
        	<form:errors path="confirmPassword" cssClass="error"/>
        	<form:errors path="passwordMatching" cssClass="error"/>
        </div>
        
        <br>
        
        <div>
        	<label for="birthday">Birthday</label>
        	<form:input  path="birthDate" class="form-control"/>
        	<form:errors path="birthDate" cssClass="error"/>	
        </div>
        
        <br>
        
        <div>
        	<label for="numberOfTickets"># of Tickets</label>
        	<form:input  path="numberOfTickets" class="form-control"/>
        	<form:errors path="numberOfTickets" cssClass="error"/>	
        </div>
        
        <br>

        <div>
            <input type="submit" class="btn btn-primary" value="Submit"/>
        </div>

</form:form>

<%@include file="common/footer.jspf" %>