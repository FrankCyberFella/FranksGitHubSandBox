<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="common/header.jspf"%>

<c:set var="pageTitle" value="All Films List"/>
<c:url var="filmSearchAction" value="/filmSearchResult" />
<form:form action="${filmSearchAction}" 
		   method="POST" 
		   modelAttribute="Film">
	<label for="minLength">Minimum Length:</label> 
	<form:input  path="minLength"  class="form-control"/>
	<form:errors path="minLength"  cssClass="error"/>
	
	<label for="maxLength">Maximum Length:</label>
	<form:input  path="maxLength"  class="form-control"/>
	<form:errors path="maxLength"  cssClass="error"/>
	
	<label for="name">Genre:</label>
	<select name="name" id="name">
				<option value="Action">Action</option>
				<option value="Animation">Animation</option>
				<option value="Children">Children</option>
				<option value="Classics">Classics</option>
				<option value="Comedy">Comedy</option>
				<option value="Documentary">Documentary</option>
				<option value="Drama">Drama</option>
				<option value="Family">Family</option>
				<option value="Foreign">Foreign</option>
				<option value="Classics">Classics</option>
				<option value="Games">Games</option>
				<option value="Horror">Horror</option>
				<option value="Music">Music</option>
				<option value="New">New</option>
				<option value="Sci-Fi">Sci-Fi</option>
				<option value="Sports">Sports</option>
				<option value="Travel">Travel</option>
				<option value="Mathmagical">Mathmagical</option>
		<input class="filmSearchSubmitButton" type="submit" value="Submit" />
</form:form>

<c:import url="/WEB-INF/jsp/common/footer.jspf" />