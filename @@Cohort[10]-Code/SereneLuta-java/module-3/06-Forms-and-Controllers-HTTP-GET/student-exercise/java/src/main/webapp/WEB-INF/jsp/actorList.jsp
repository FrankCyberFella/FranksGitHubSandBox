<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="All Actors List" />

<%@include file="common/header.jspf"%>
<!-- Form goes here -->
<c:url var="actorSearchAction" value="/actorSearchResult" />
<form:form action="${actorSearchAction}" 
		   method="POST" 
		   modelAttribute="Actor">
	<label for="lastName">Search By Last Name:</label> 
		<form:input  path="lastName"  class="form-control"/>
		<form:errors path="lastName"  cssClass="error"/>
		<!-- <input type="text" name="lastName" id="lastName" /> -->
		
		<input class="actorSearchSubmitButton" type="submit"
				value="Submit" />
</form:form>
	<table class="table">
		<tr>
			<th>Name</th>
		</tr>

	</table>
<c:import url="/WEB-INF/jsp/common/footer.jspf" />