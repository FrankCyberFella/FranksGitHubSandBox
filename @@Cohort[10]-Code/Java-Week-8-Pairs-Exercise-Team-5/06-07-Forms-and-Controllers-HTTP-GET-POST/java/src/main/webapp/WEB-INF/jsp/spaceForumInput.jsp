<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<section id= "main-content">

<h2>Space Forum</h2>

<c:url var="formAction" value="/spaceForumOutput"/>
<form method="POST" action="${formAction}">
	<div class="formInputGroup">
		<label for="username">Enter Username:</label> 
		<input type="text" name="username" id="username" />
	</div>
	<div class="formInputGroup">
		<label for="subject">Enter Subject:</label> 
		<input type="text" name="subject" id="subject" />
	</div>
	<div class="formInputGroup">
		<label for="message">Message:</label> 
		<textarea type="text" id="message" name="message" rows="5" cols="25" >
		</textarea>
	</div>
	<input class="formSubmitButton" type="submit" value="Submit" />
</form>
</section>


<c:import url="/WEB-INF/jsp/common/footer.jsp"/>

