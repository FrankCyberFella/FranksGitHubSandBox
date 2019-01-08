<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Films List"/>

<%@include file="common/header.jspf"%>
<c:url value="/filmListResults" var="formAction" />
<form method="GET" action="${formAction}">
	<label for="minLength"><c:out value="Minimum Length:" /></label> <input type="text" id="minLength"
		name="minLength" />
	<label for="maxLength"><c:out value="Maximum Length:" /></label> <input type="text" id="maxLength"
		name="maxLength" />
	<label for="genre"><c:out value="Genre:" /></label> 
		<select name="genre"	id="genre">
			<option value="Action"><c:out value="Action" /></option>
			<option value="Animation"><c:out value="Animation" /></option>
			<option value="Children"><c:out value="Children" /></option>
			<option value="Classics"><c:out value="Classics" /></option>
			<option value="Comedy"><c:out value="Comedy" /></option>
			<option value="Documentary"><c:out value="Documentary" /></option>
			<option value="Drama"><c:out value="Drama" /></option>
			<option value="Family"><c:out value="Family" /></option>
			<option value="Foreign"><c:out value="Foreign" /></option>
			<option value="Games"><c:out value="Games" /></option>
			<option value="Horror"><c:out value="Horror" /></option>
			<option value="Music"><c:out value="Music" /></option>
			<option value="New"><c:out value="New" /></option>
			<option value="Sci-Fi"><c:out value="Sci-Fi" /></option>
			<option value="Sports"><c:out value="Sports" /></option>
			<option value="Travel">T<c:out value="Travel" /></option>
		</select>
	<input type="submit" value="Search" />
</form>

<table>
  <tr>
    <th><c:out value="Title" /></th>
    <th><c:out value="Description" /></th>
    <th><c:out value="Release Year" /></th>
    <th><c:out value="Length" /></th>
    <th><c:out value="Rating" /></th>
  </tr>
  <c:forEach var="film" items="${films}">
  	<tr>
  		<td><c:out value="${film.title}" /></td>
  		<td><c:out value="${film.description}" /></td>
  		<td><c:out value="${film.releaseYear}" /></td>
  		<td><c:out value="${film.length}" /></td>
  		<td><c:out value="${film.rating}" /></td>
  	</tr>
  </c:forEach>
</table>

<%@include file="common/footer.jspf"%>