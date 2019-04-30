<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Films List"/>
<%@include file="common/header.jspf"%>

<c:url var="formAction" value="/filmList" />

<div>FILM SEARCH ENGINE</div>
<form method="GET" action="${formAction}">
	<div class="formInputGroup">
		<label for="filmList"></label>
		<input type="text" placeholder="MINIMUM LENGTH" name = "minLength" id="filmList" />
		<input type="text" placeholder="MAXIMUM LENGTH" name = "maxLength" id="filmList" />
		<select name = "genre" id="filmList">
			<option value="Action">Action!</option>
			<option value="Animation">aNiMaTiOn</option>
			<option value="Children">children</option>
			<option value="Classics">CLASSICS</option>
			<option value="Comedy">Comedy :D</option>
			<option value="Documentary">...documentary...</option>
			<option value="Drama">DRAMA!?</option>
			<option value="Family">Family =)</option>
			<option value="Foreign">Foreign.</option>
			<option value="Games">Gamez</option>
			<option value="Horror">!horror!</option>
			<option value="Music">Muuusiiic</option>
			<option value="Sci-Fi">SCi.-fI.</option>
			<option value="Sports">Sports!!!!!</option>
			<option value="Travel">travel...</option>
		</select>
		<input type="submit" value="SEARCH"/>
	</div>
	</form>

<table class="table">
<tr id="captions">
<th>TITLE</th><th>DESCRIPTION</th><th>RELEASE YEAR</th><th>LENGTH</th><th>RATING</th>
</tr>
<c:forEach items="${films}" var="film">
<tr id="output">
    <td>${film.title}</td> <td>${film.description}</td> <td>${film.releaseYear}</td> <td>${film.length}</td> <td>${film.rating}</td>
</tr>
</c:forEach>
</table>

<%@include file="common/footer.jspf"%>