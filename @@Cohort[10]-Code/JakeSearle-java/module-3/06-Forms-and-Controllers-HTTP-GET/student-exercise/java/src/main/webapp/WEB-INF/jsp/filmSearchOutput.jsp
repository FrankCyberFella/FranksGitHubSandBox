<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="All Films List" />
<link href="/css/site.css" rel="stylesheet">

<%@include file="common/header.jspf"%>

<section id="filmSearch">



	<c:url var="formAction" value="/filmSearchOutput" />
	<form method="GET" action="${formAction}">
		<input type="text" name="minLength" id="textBox" placeholder="Enter Minimum Length" /> 
		<input type="text" name="maxLength" id="textBox" placeholder="Enter Maximum Length" />
		
		<table>
			<tr>
				<td id="title">Title</td>
				<td id="length">Length</td>
				<td id="release">Release Year</td>
		
			<tr>
		</table>
		
		
		
		<table id="filmOutput">
			<c:forEach var="film" items="${listOfFilms}">


				<tr>
					<td class="title">${film.title}</td>
					<td class="film">${film.length}</td>
					<td class="release">${film.releaseYear}</td>
					<td class="description">${film.description}</td>
				</tr>

			</c:forEach>

		</table>




	</form>

</section>









<%@include file="common/footer.jspf"%>