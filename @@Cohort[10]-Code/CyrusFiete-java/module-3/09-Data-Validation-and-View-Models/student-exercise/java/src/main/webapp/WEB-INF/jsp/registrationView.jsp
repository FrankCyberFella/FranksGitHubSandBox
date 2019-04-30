<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Registration"/>
<%@include file="common/header.jspf" %>

<section id="main-content"  class="centeredPanel">
<c:url value="/registrationView" var="registration" />
<form:form action="${registration}" method="POST" modelAttribute="Registration">
		<!-- form:errors path="*" cssClass="error"/ -->
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
        	<form:errors path="emailMatching" cssClass="error"/>
        </div>

        <div>
            <label for="verifyEmail">Verify Email</label>
            <form:input  path="verifyEmail" />
            <form:errors path="verifyEmail" cssClass="error"/>
        </div>

        <div>
            <label for="password">Password</label>
			<form:input  path="password" />            
        	<form:errors path="password" cssClass="error"/>
        	<form:errors path="passwordMatching" cssClass="error"/>
        </div>

        <div>
            <label for="verifyPassword">Verify Password</label>
            <form:input  path="verifyPassword" />
            <form:errors path="verifyPassword" cssClass="error"/>
        </div>
        
        <div>
            <label for="birthDate">Birth Date (mm/dd/yyyy)</label>
			<form:input  path="birthDate" />            
        	<form:errors path="birthDate" cssClass="error"/>
        </div>

        <div>
            <label for="tickets">Tickets (Quantity: 1-10)</label>
            <form:input  path="tickets" />
            <form:errors path="tickets" cssClass="error"/>
        </div>
        
        <div>
            <input type="submit" value="SUBMIT"/>
        </div>
</form:form>
</section>

<%@include file="common/footer.jspf" %>