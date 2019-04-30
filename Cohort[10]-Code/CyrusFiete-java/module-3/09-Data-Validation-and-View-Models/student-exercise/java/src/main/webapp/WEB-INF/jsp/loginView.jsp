<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Login"/>
<%@include file="common/header.jspf" %>

<section id="main-content"  class="centeredPanel">
<c:url value="/loginView" var="loginView" />
<form:form action="${loginView}" method="POST" modelAttribute="Login">
		<!-- form:errors path="*" cssClass="error"/ -->
        <div>
        	<label for="email">Email</label>
        	<form:input  path="email"  class="form-control"/>
        	<form:errors path="email"  cssClass="error"/>	
        </div>
        
        <div>
            <label for="password">Password</label>
			<form:input  path="password" />            
        	<form:errors path="password" cssClass="error"/>
        </div>
        
        <div>
            <input type="submit" value="SUBMIT"/>
        </div>
</form:form>
</section>

<%@include file="common/footer.jspf" %>