<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Films List"/>

<%@include file="common/header.jspf"%>

<section id="filmSearch">
<a href="actorList"><p1>Search an Actor</p1></a>
	
	<c:url var="formAction" value="/filmSearchOutput" />
	<form method="GET" action="${formAction}"> 
	<input type="text" name="minLength" id="textBox" placeholder="Enter Minimum Length" />
	<input type="text" name="maxLength" id="textBox" placeholder="Enter Maximum Length" />
		<div id="list">
			<p id=chooseGenre>
				Choose a Genre: <select name="genre" id="genre">
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
			</p>
			<input type="submit" value="Search" />
			
			</div>
	
	</form>


</section>

<%@include file="common/footer.jspf"%>