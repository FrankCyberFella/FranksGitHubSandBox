<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Films List"/>

<%@include file="common/header.jspf"%>
<c:url var="formAction" value="/filmList"/>
	<form method="POST" action="${formAction}">
		<label for="minLength">Enter film minimum length:</label>
		<input type="text" id="minLength" name="minLength"/>
		<label for="maxLength">Enter film maximum length:</label>
		<input type="text" id="maxLength" name="maxLength"/>
		<label for="genre">Genre:</label>
	<select name = "genre">
		<option value = "Action">Action </option>
		<option value = "Animation">Animation </option>
		<option value = "Children">Children </option>
		<option value = "Classic">Classic </option>
		<option value = "Comedy">Comedy </option>
		<option value = "Documentary">Documentary </option>
		<option value = "Drama">Drama </option>
		<option value = "Family">Family </option>
		<option value = "Foreign">Foreign </option>
		<option value = "Games">Games </option>
		<option value = "Horror">Horror </option>
		<option value = "Music">Music </option>
		<option value = "New">New</option>
		<option value = "Sci-Fi">Sci-Fi </option>
		<option value = "Sports">Sports </option>
		<option value = "Travel">Travel </option>
	</select>
	<input type="submit" value="submit"/>
	</form>
	<table class="table">
		<tr>
			<th>Title</th>
			<th>Description</th>
			<th>Release</th>
			<th>Length</th>
			<th>Rating</th>	
		</tr>
		<c:forEach items="${films}" var="film">
		<tr>
			<td>${film.title}</td>
			<td>${film.description}</td>
			<td>${film.releaseYear}</td>
			<td>${film.length}</td>
			<td>${film.rating}</td>
		</tr>
		
		</c:forEach>
	
	</table>

<%@include file="common/footer.jspf"%>