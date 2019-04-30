<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">

	<h2>New Geek Post</h2>


	<c:url var="formAction" value="/forumPosting" />
	<form method="POST" action="${formAction}">
	

		<div class="formInputGroup">
			<label for="userNameLabel">Enter Your Username</label> <input
				type="text" name="userName" id="userNameLabel" />
		</div>

		<div class="formInputGroup">
			<label for="subjectLabel">Subject</label> <input
				type="text" name="subject" id="subjectLabel" />
		</div>

		<div class="formInputGroup">
			<label for="MessageLabel">Message</label> <input
				type="text" name="message" id="messageLabel" />
		</div>
		<input class="formSubmitButton" type="submit"
			value="Submit" />
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />