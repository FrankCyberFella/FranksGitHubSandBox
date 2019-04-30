<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<c:set var="pageTitle" value="Home Page"/>
<%@include file="common/header.jspf" %>

<c:url value="/register" var="registrationUrl" />
<form:form action="${registrationUrl}" 
		   method="POST" 
		   modelAttribute="Registration">
        <div>
        	<label for="firstName">First Name</label>
        	<form:input  path="firstName"  class="form-control"/>  
        	<form:errors path="firstName"  cssClass="error"/>
        </div>
        <div>
        	<label for="lastName">Last Name</label>
        	<form:input  path="lastName"  class="form-control"/> 
        	<form:errors path="lastName"  cssClass="error"/> 
        </div>
        <div>
            <label for="email">Email</label>
			<form:input  path="email" />            
        	<form:errors path="email" cssClass="error"/>
        </div>

        <div>
            <label for="verifyEmail">Verify Email</label>
            <form:input  path="verifyEmail" />
            <form:errors path="verifyEmail" cssClass="error"/>
            <form:errors path="emailMatching" cssClass="error"/>
        </div>

        <div>
            <label for="password">Password</label>
            <form:input  path="password" />
            <form:errors path="password" cssClass="error"/>            
        </div>
        <div>
            <label for="verifyPassword">Confirm Password</label>
            <form:input  path="verifyPassword" />
            <form:errors path="verifyPassword" cssClass="error"/>            
        </div>
        <div>
            <label for="birthday">Birthday (MM-DD-YYY)</label>
            <form:input  path="birthday" />
            <form:errors path="birthday" cssClass="error"/>   
        </div>
        
        <div>
            <label for="tickets"># of Tickets</label>
            <form:input  path="tickets" />
            <form:errors path="tickets" cssClass="error"/>    
        </div>
        
        <div>
            <input type="submit" value="Register Now!"/>
        </div>
</form:form>

<%@include file="common/footer.jspf" %>