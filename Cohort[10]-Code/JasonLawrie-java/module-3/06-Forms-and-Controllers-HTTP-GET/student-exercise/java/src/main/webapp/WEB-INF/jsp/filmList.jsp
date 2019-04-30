<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="pageTitle" value="All Films List"/>

<%@include file="common/header.jspf"%>
	<c:url var="subTarget" value="/filmList"/>
	<form:form method="POST" action="${subTarget}" modelAttribute="FilmSearch">
		<label for="minLength">Minimum Length:</label>
		<form:input path="minLength" type="number" class="form-control"/>
		
		<form:errors path="minLength"  cssClass="error"/>
		<label for="maxLength">Maximum Length:</label>
		<form:input type="number" path="maxLength" />
		<form:errors path="maxLength"  cssClass="error"/>
		<label for="genre">Genre:</label>
		<form:input type="text" path="genre" placeholder="ex. comedy"/>
		<form:errors path="genre"  cssClass="error"/>
		<input type="submit" value="submit">
	</form:form>
	<table class="table">
		<tr>
			<th>Title</th>
			<th>Description</th>
			<th>Release Year</th>
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