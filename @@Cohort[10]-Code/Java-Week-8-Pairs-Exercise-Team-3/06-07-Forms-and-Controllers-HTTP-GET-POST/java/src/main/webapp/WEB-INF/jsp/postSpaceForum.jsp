<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section id="main-content">
	<h3 style="text-align: center;">New Geek Post</h3>
	<c:url var="forumPostAction" value="/postSpaceForum" />
	<form method="POST" action="${formPostAction}">
		<!-- On submit run the mortgageCalculatorResult.jsp -->
		<div class="ageFormInputGroup">
			<label for="username">Username:</label> 
				<input type="text" name="userName" id="username"/>
				<br>
			<label for="subject">Subject:</label> 
				<input type="text" name="subject" id="subject"/>
				<br>
			<label for="message">Message:</label> 
				<input type="text" name="message" id="message" />
			</div>
			<input class="postFormSubmitButton" type="submit"
				value="Submit" />
	</form>


</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />