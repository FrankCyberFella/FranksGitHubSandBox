<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<%@include file="common/header.jspf" %>
<section id="main-content"  class="centeredPanel">
<c:url value="/login" var="loginUrl" />
<form:form action="${loginUrl}" method="POST" modelAttribute="SignUp">
        <div>
        	<label for="email">Email</label>
        	<form:input  path="email"  class="form-control"/>	
        	<form:errors path="email"  cssClass="error"/>		
        		
        </div>
        <div>
            <label for="password">Password</label>
			<form:input  path="password" class="form-control" />            
        	<form:errors path="password" cssClass="error"/>
        </div>

        <div>
            <input type="submit" value="Submit"/>	<!-- all variables placed in response body -->
        </div>
</form:form>
</section>


<%@include file="common/footer.jspf" %>