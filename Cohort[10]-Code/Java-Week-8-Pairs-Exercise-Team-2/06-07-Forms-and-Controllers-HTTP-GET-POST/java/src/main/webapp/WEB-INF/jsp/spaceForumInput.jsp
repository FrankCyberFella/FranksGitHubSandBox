<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<div id="spaceForumInput">
<h2>New Geek Post</h2>

<li id="link"><a href="spaceForumOutput">View All Posts</a></li>

<c:url value="/spaceForumOutput" var="formAction"/>
<form method="POST" action="${formAction}">

	<div class="formInputGroup">
		<label for="userName">Username</label> 
		<input type="text" name="userName" id="userName" />
	</div>
	
	<div class="formInputGroup">
		<label for="subject">Subject</label> 
		<input type="text" name="subject" id="subject" />
	</div>
	
	<div class="formInputGroup">
		<label for="message">Message</label> 
		<textarea cols="25" rows="5" name="message" id="message">
		</textarea>
	</div>
	
	<input class="formSubmitButton" type="submit" value="Submit" />
	
</form>
</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp"/>