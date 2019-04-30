<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Film List Search"/>

<%@include file="common/header.jspf"%>

<c:url var="formAction" value="/filmListResults" />
<form method="GET" action="${formAction}">

	<div>
		<label for="minLengthInput">Minimum Length: </label> 
		<input type="text" name="minLength" id="minLengthInput" />
	</div>
	
		<div>
		<label for="maxLengthInput">Maximum Length: </label> 
		<input type="text" name="maxLength" id="maxLengthInput" />
	</div>
	
	<div>
		<label for="genreSelector">Genre: </label> 
		<select name="genre" id="genreSelector">
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
	
	<input type="submit" value="Search" />
	
</form>


<%@include file="common/footer.jspf"%>