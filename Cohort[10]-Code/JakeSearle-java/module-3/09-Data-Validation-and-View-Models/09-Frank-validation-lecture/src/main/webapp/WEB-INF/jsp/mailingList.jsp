<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<%@include file="common/header.jspf" %>
<section id="main-content"  class="centeredPanel">
<c:url value="/mailingList" var="mailingListSignUpUrl" /> 
<form:form action="${mailingListSignUpUrl}" 
		   method="POST" 
		   modelAttribute="SignUp"> <!-- action= use this URL on submit -->
		   							<!-- method= issue a POST on submit -->
		   							<!-- modelAttribute= use this model automatically with the form -->
		<!-- form:errors path="*" cssClass="error"/ -->
        <div>
        	<label for="name">Name</label>
        	<form:input  path="name"  class="form-control"/> <!-- name= identifies the variable in the model that backs the form -->
        	<form:errors path="name"  cssClass="error"/> <!-- put any error messages here -->
        												 <!--  class="form-control" just means its a text box (instead of type="text" -->
        												 <!-- cssClass attribute is the name for the error indicator -->
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
            <label for="phone">Phone Number (XXX)XXX-XXXX</label>
            <form:input  path="phone" />
            <form:errors path="phone" cssClass="error"/>            
        </div>
        
        <div>
            <label for="occupation">Occupation</label>
            <form:input  path="occupation" />
            <form:errors path="occupation" cssClass="error"/>   
        </div>
        
        <div>
            <label for="age">Age</label>
            <form:input  path="age" />
            <form:errors path="age" cssClass="error"/>    
        </div>
        
        <div>
            <input type="submit" value="Sign Me Up!"/>
        </div>
</form:form>
</section>
<%@include file="common/footer.jspf" %>