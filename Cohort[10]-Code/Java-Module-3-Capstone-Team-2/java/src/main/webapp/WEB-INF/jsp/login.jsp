<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
    <c:import url="/WEB-INF/jsp/common/header.jsp" />
<section id="login-content"  class="centeredPanel">
<c:url value="/login" var="loginUrl" />
<form:form action="${loginUrl}" method="POST" modelAttribute="User">
        <div>
        	<label for="username">Name</label>
        	<form:input  path="username"  class="form-control"/>	<!-- name = identify variable in model backing form -->
        	<form:errors path="username"  cssClass="error"/>		<!-- put any error message here -->
        		
        </div>
        <div>
            <label for="password">Password</label>
			<form:input type="password"  path="password"  />            
        	<form:errors path="password" cssClass="error"/>
        	<form:errors path="passwordMatching" cssClass="error"/>
        </div>

        <div>
            <label for="confirmPassword">Confirm Password</label>
            <form:input type="password" path="confirmPassword" />
            <form:errors path="confirmPassword" cssClass="error"/>
        </div>

        <div>
            <label for="role">Role </label>
            <form:input  path="role" />
            <form:errors path="role" cssClass="error"/>            
        </div>
        
          <div>
            <input type="submit" value="Log Me In!"/>	
        </div>
</form:form>
</section>
    <c:import url="/WEB-INF/jsp/common/footer.jsp" />
