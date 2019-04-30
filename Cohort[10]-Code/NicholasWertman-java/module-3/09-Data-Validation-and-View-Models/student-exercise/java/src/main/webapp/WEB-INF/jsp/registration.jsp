<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
    <%@include file="common/header.jspf" %>
    
<section id="main-content"  class="centeredPanel">
<c:url value="/registration" var="registrationUrl" />
<form:form action="${registrationUrl}" method="POST" modelAttribute="RegisterUp">
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
            <label for="emailAddress">Email</label>
			<form:input  path="emailAddress" />            
        	<form:errors path="email" cssClass="error"/>
        	<form:errors path="emailMatching" cssClass="error"/>
        </div>

        <div>
            <label for="confirmEmail">Confirm Email</label>
            <form:input  path="confirmEmail" />
            <form:errors path="confirmEmail" cssClass="error"/>
        </div>

 	<div>
            <label for="password">Password</label>
			<form:input  path="password" />            
        	<form:errors path="password" cssClass="error"/>
        	<form:errors path="passwordMatching" cssClass="error"/>
        </div>

        <div>
            <label for="confirmPassword">Confirm Password</label>
            <form:input  path="confirmPassword" />
            <form:errors path="confirmPassword" cssClass="error"/>
        </div>

        <div>
            <label for="birthday">Birthday MM-DD-YYYY </label>
            <form:input  path="birthday" />
            <form:errors path="birthday" cssClass="error"/>            
        </div>
        
        <div>
            <label for="tickets">Tickets, (1-10)</label>
            <form:input  path="tickets" />
            <form:errors path="tickets" cssClass="error"/>   
        </div>
        
     
        <div>
            <input type="submit" value="Sign Me Up!"/>	
        </div>
</form:form>
</section>


<%@include file="common/footer.jspf" %>