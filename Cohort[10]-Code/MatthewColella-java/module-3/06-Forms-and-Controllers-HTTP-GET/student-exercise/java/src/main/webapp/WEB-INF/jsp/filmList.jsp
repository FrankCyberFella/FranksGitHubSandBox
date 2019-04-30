<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="All Films List"/>

<%@include file="common/header.jspf"%>
<c:url var="formAction" value="/filmList" />
<form:form method="POST" action="${formAction}" modelAttribute="FilmSearch">	
<div>
		<label for="minLength">Minimum Length: </label> 
		<form:input path="minLength" />
			<form:errors path="minLength" cssClass="error"/>
	</div>
	
	<div>
		<label for="maxLength">Maximum Length: </label> 
		<form:input path="maxLength" />
			<form:errors path="maxLength" cssClass="error"/>
	</div>
	  
	<div>
		
		<label for="genre">Genre: </label> 
		<form:select path="genre">
			<form:option value="Action">Action</form:option>
			<form:option value="Animation">Animation</form:option>
			<form:option value="Children">Children</form:option>
			<form:option value="Classics">Classics</form:option>
			<form:option value="Comedy">Comedy</form:option>
			<form:option value="Documentary">Documentary</form:option>
			<form:option value="Drama">Drama</form:option>
			<form:option value="Family">Familiy</form:option>
			<form:option value="Foreign">Foreign</form:option>
			<form:option value="Games">Games</form:option>
			<form:option value="Horror">Horror</form:option>
			<form:option value="Music">Music</form:option>
			<form:option value="New">New</form:option>
			<form:option value="Sci-Fi">Sci-Fi</form:option>
			<form:option value="Sports">Sports</form:option>
			<form:option value="Travel">Travel</form:option>
		</form:select>
		<form:errors path="genre" cssClass="error"/>
	</div>
	
	<input type="submit" value="Search"/>
</form:form>
<table class="table">
<tr>
<th>Name</th>
</tr>
<c:forEach items="${films}" var="film">
<tr>
    <td><b><em>${film.title}</em></b> <b>|</b> ${film.description} <b>|</b> ${film.releaseYear} <b>|</b> ${film.length} minutes <b>|</b> ${film.rating}</td>
</tr>
</c:forEach>
</table>
<%@include file="common/footer.jspf"%>