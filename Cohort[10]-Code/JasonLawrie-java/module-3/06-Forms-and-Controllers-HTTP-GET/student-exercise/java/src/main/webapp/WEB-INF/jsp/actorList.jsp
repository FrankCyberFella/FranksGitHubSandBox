<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>
	<c:url var="subTarget" value="/actorList"/>
	<form:form method="POST" action="${subTarget}" modelAttribute="Actor">
		<div>
			<label for="lastName">Search Actor Name:</label>
			<form:input path="lastName" id="lastName" placeholder="ex. CRUISE" class="form-control"/>
			<form:errors path="lastName"  cssClass="error"/>
		</div>
		
		<input type="submit" value="submit">
	</form:form>
	<table class="table">
		<tr>
			<th>Name</th>
		</tr>
		<c:forEach items="${Actors}" var="actor">
			<tr>
			    <td>${actor.firstName} ${actor.lastName}</td>
			</tr>
		</c:forEach>
	</table>
<%@include file="common/footer.jspf"%>
