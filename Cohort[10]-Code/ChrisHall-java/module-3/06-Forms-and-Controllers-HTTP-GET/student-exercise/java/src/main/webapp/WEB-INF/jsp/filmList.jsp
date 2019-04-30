<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Films List"/>

<%@include file="common/header.jspf"%>

<c:url var="formAction" value="/filmList" />
<form method="GET" action="${formAction}">
	<input type="text" id="min" name="minLength" />Minimum Length 
	<input type="text" id="max" name="maxLength" />Maximum Length 
	<div class="formInputGroup">
			<label for="genreChoiceId">Genre:</label> 
			<select name="genreChoice" id="genreChoiceId">
				<option value="Action">Action</option>
				<option value="Animation">Animation</option>
				<option value="Children">Children</option>
				<option value="Classics">Classics</option>
				<option value="Comedy">Comedy</option>
				<option value="Documentary">Documentary</option>
				<option value="Drama">Drama</option>
				<option value="Family">Family</option>
		</select>
		<input type="submit" value="Submit" />
		</div>
</form>
<table class="table">
	<tr>
		<th>Title</th>
	</tr>
	<tr>
		<c:forEach items="${films}" var="film">
			<c:out value="${film.title}" />
			<br>
		</c:forEach>
		
	</tr>
</table>







<%@include file="common/footer.jspf"%>