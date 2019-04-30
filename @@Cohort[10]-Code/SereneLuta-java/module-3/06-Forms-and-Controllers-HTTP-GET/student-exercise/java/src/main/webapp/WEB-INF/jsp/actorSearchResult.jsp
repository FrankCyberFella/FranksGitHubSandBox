<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@include file="common/header.jspf"%>
<%-- <c:url var="actorSearchAction" value="/actorSearchResult" />
<form:form action="${actorSearchAction}" 
		   method="POST" 
		   modelAttribute="Actor">
	<label for="lastName">Search By Last Name:</label> 
		<form:input  path="lastName"  class="form-control"/>
		<form:errors path="lastName"  cssClass="error"/>
		<!-- <input type="text" name="lastName" id="lastName" /> -->
		
		<input class="actorSearchSubmitButton" type="submit"
				value="Submit" />
</form:form> --%> 
<b>Name</b>
	<table class="table">
		<tr>
			<th></th>
		</tr>
		<c:forEach var="actor" items="${actorKey}">
			<tr>
				<div>${actor.firstName} ${actor.lastName}</div>
				<div><hr></div>
				
			</tr>
		</c:forEach>
	</table>
<c:import url="/WEB-INF/jsp/common/footer.jspf" />