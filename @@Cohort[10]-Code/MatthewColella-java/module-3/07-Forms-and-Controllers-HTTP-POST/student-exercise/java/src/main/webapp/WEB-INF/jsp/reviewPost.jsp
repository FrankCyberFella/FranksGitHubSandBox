<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<section id="main-content">
	
<h2>New Review</h2>

<form method="POST" action="reviewPost">

	<div>
		<label for="usernameSelector">Username:</label> 
		<input type="text" name="username" id="usernameSelector" />
	</div>
	
	<div>
		<label for="ratingSelector">Rating (1-5):</label> 
		<input type="text" name="rating" id="RatingSelector" />
	</div>
	
	<div>
		<label for="titleSelector">Title:</label> 
		<input type="text" name="title" id="titleSelector" />
	</div>
	
	<div>
		<label for="textSelector">Comments:</label> 
		<input type="text" name="text" id="textSelector" />
	</div>
	
	<input type="submit" value="Submit" />
</form>


</section>

