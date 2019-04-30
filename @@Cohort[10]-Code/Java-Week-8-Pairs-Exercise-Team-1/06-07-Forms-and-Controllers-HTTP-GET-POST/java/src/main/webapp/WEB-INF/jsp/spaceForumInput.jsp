<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section id="main-content">
	
<h2>New Geek Post</h2>

<form method="POST" action="spaceForumInput">

	<div>
		<label for="usernameSelector">Username:</label> 
		<input type="text" name="username" id="usernameSelector" />
	</div>
	
	<div>
		<label for="SubjectSelector">Subject:</label> 
		<input type="text" name="subject" id="SubjectSelector" />
	</div>
	
	<div>
		<label for="messageSelector">Message:</label> 
		<input type="text" name="message" id="messageSelector" />
	</div>
	
	<input type="submit" value="Submit" />
</form>


</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />