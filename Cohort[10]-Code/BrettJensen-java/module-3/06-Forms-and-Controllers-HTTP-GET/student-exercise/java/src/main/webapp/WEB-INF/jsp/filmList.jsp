<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>

<section id="form-container">
	<c:url var="filmList" value="/filmList"/>
	<form:form id="filmSearch" method="POST" action="${filmList}" modelAttribute="FilmSearch">
		<div id="minLContainer">
			<label for="minLength">Minimum length: </label>
			<form:input id="filmMinLength" path="minLength" class="form-control"/>
			 <form:errors path="minLength"  cssClass="error"/>
		</div>
		<div id="maxLContainer">
			<label for="maxLength">Max length: </label>
			<form:input id="filmMaxLength" path="maxLength" class="form-control"/>
			<form:errors path="maxLength"  cssClass="error"/>
			<form:errors path="maxGreaterThanMin" cssClass="error"/>
		</div>
		<div id="genreLContainer">
			<label for="genre">Genre: </label>
			<select name = "genre">
				<option value = "Action"> Action </option>
				<option value = "Animation"> Animation </option>
				<option value = "Children"> Children </option>
				<option value = "Classics"> Classics </option>
				<option value = "Comedy"> Comedy </option>
				<option value = "Documentary"> Documentary </option>
				<option value = "Drama"> Drama </option>
				<option value = "Family"> Family </option>
				<option value = "Foreign"> Foreign </option>
				<option value = "Games"> Games </option>
				<option value = "Horror"> Horror </option>
				<option value = "Music"> Music </option>
				<option value = "New"> New </option>
				<option value = "Sci-Fi"> Sci-Fi </option>
				<option value = "Sports"> Sports </option>
				<option value = "Travel"> Travel </option>
			</select>
		</div>
		<input id="filmSubmitButton" type="submit" value="Search" />
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
</section>

<%@include file="common/footer.jspf"%>