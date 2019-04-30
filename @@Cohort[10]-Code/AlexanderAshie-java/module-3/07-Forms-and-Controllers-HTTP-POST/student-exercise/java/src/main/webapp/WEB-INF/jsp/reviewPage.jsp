<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section id="main-content">
	
<h2>New Review</h2>

<form method="POST" action="reviewPage">

	<div>
		<label for="usernameSelector">Username:</label> 
		<input type="text" name="username" id="usernameSelector" />
	</div>
	
	<div>
		<label for="titleSelector">Title:</label> 
		<input type="text" name="title" id="titleSelector" />
	</div>
	
	<div>
		<label for="textSelector">Message:</label> 
		<input type="text" name="text" id="textSelector" />
	</div>
	
	<div>
		<label for="ratingSelector">Rating (out of 5):</label> 
		<input type="text" name="rating" id="ratingSelector" />
	</div>
	
	<input type="submit" value="Submit" />
</form>


</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />