<!--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Customers List"/>

<%@include file="common/header.jspf"%>

<c:url var="formAction" value="/customerList" />
<form method="GET" action="${formAction}">

	<div>
		<input type="text" name="name" id="nameSearcher" />
	</div>
	<input type="submit" value="Submit" />
	
	<div>
		<label for="planetSelector">Genre: </label> 
		<select name="planet" id="planetSelector">
			<option value="Action">Action</option>
			<option value="Animation">Animation</option>
			<option value="Children">Children</option>
			<option value="Classics">Classics</option>
			<option value="Comedy">Comedy</option>
			<option value="Documentary">Documentary</option>
			<option value="Drama">Drama</option>
			<option value="Family">Family</option>
			<option value="Foreign">Foreign</option>
			<option value="Games">Games</option>
			<option value="Horror">Horror</option>
			<option value="Music">Music</option>
			<option value="New">New</option>
			<option value="Sci-Fi">Sci-Fi</option>
			<option value="Sports">Sports</option>
			<option value="Travel">Travel</option>
		</select>
	</div>
	
</form>

<table class="table">
<tr>
<th>Name</th>
</tr>
<c:forEach items="${actors}" var="actor">
<tr>
    <td>${actor.firstName} ${actor.lastName}</td>
</tr>
</c:forEach>
</table>


<%@include file="common/footer.jspf"%>-->