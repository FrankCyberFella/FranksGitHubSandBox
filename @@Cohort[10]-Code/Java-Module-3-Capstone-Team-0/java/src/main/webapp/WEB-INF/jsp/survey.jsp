<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Survey"/>
<%@include file="common/header.jspf" %>

<h3>Submit your Park Survey</h3>

<p>Please participate in our park survey to view a ranking of favorite parks!</p>

<c:url value="survey" var="surveyUrl"/>
<form:form action="${surveyUrl}" method="POST" modelAttribute="Survey">

	<div class="card shadow p-3 mb-5 rounded">
		<div class="survey-card">
			<span>
	        	<label for="parkCode">Favorite National Park</label>
	        
	        	<form:select path="parkCode">
	        		<form:option value="" label="---Select---"/>
	        		
	        		<c:forEach var="park" items="${parks}">
	        			<form:option value="${park.parkCode}" label="${park.parkName}"/>
	        		</c:forEach>
	        	
	        	</form:select>
	        	<form:errors path="parkCode" cssClass="error"/>	
	        </span>
	        <br>
	        <span>
	        	<label for="emailAddress">Email</label>
	        	<form:input  path="emailAddress" class="form-control"/>
	        	<form:errors path="emailAddress" cssClass="error"/>	
	        </span>
	        <br>
	        <span>
	        	<label for="state">State of Residence</label>
	        
	        	<form:select path="state">
	        		<form:option value="" label="---Select---"/>
	        		<form:options items="${states}"/>
	        	</form:select>
	        	
	        	<form:errors path="state" cssClass="error"/>	
	        </span>
	        <br>
	        <span>
	        	<label for="activityLevel">State of Residence</label>
	        	
	        	<c:forEach var="level" items="${activityLevels}">
	        		<form:radiobutton path="activityLevel" value="${level.toLowerCase()}"/>   ${level}
	        	</c:forEach>
	        	
	        	<form:errors path="activityLevel" cssClass="error"/>	
	        </span>
	        <br>
	        <div>
	            <input type="submit" class="btn btn-primary" value="Submit"/>
	        </div>
        </div>
      </div>

</form:form>

<%@include file="common/footer.jspf" %>
