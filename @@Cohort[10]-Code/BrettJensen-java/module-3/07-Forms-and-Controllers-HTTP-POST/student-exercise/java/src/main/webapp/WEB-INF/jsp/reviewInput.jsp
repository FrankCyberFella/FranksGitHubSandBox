<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="common/header.jspf"%>

<section id="cigar-section">
	
<div id="bookSection">
		<c:url var="dummiesBook" value="forDummies.png"/>
		<img id="bookImage" src="etc/${dummiesBook}" alt="Squirrel Cigar Party"/>
		<form id="reviewForm" method="POST" action="reviewInput">
			<div id="userName">
				<label for="userName">Username*: </label>
				<input type="text" name="userName" required>
			</div>
			<div id="rating">
				<label for="rating">Star Rating:</label>
				<select name="rating">
 					<option value="1">1</option>
  					<option value="2">2</option>
  					<option value="3">3</option>
  					<option value="4">4</option>
  					<option value="5">5</option>
				</select>
				<p> stars</p>
			</div>
			<div id="title">
				<label for="title">Title:</label>
				<input type="text" name="title" required>
			</div>
			
			<label id="messageLabel" for="message">Review:</label>
			<textarea type="text" name="message" rows="10" cols="30" required></textarea>
			<input id="submitButton" type="submit" value="Post"/>		
		</form>	
	</div>




</section>


<%@include file="common/footer.jspf"%>