<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Films List"/>

<%@include file="common/header.jspf"%>

<c:url var="searchFilmURL" value="/filmList" />
<form method="GET" action="${searchFilmURL}">
	<label for="minLength">Min Length </label>
	<input type="text" id="minLength" name="minLength" placeholder="e.g. 90">
	<label for="maxLength">Max Length: </label>
	<input type="text" id="maxLength" name="maxLength" placeholder="e.g. 180">
	<label for="genre">Genre: </label>
	<select id="genre" name="genre">
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
	<input type="submit" value="Search">
</form>

<div>
	<h3>Results:</h3>
	
	<table>
		<tr>
			<td>Name</td>
			<td>Description</td>
			<td>Release Year</td>
			<td>Length</td>
			<td>Rating</td>
		</tr>
		<c:forEach var="film" items="${films}">
			<tr>
				<td>${film.title}</td>
				<td>${film.description}</td>
				<td>${film.releaseYear}</td>
				<td>${film.length}</td>
				<td>${film.rating}</td>
			</tr>
		</c:forEach>
	</table>
</div>


<%@include file="common/footer.jspf"%>