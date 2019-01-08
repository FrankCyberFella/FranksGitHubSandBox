<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Home Page from Java Cohort[9] powered by Spring MVC</title>
	</head>
<!-- --------------------------------------------------------------------------- -->
<!-- c:url   tag formats a URL into a string and stores it into a variable.      -->
<!--         automatically performs URL encoding when necessary.                 -->
<!--         var attribute specifies the variable to contain the formatted URL.  --> 
<!--                                                                             --> 
<!--                                                                             -->
<!-- <form> tag creates a form for user input.                                   --> 
<!--        A form can contain textfields, checkboxes, radio-buttons and more.   -->
<!--        Forms are used to pass user-data to a specified URL.                 -->
<!--                                                                             -->
<!--        action= the URL to process the form when submitted                   -->
<!--        method= Specifies the HTTP method to use when the form is submitted. -->
<!--                GET  (the form data is appended to the URL when submitted)   -->
<!--                POST (the form data is not appended to the URL)              -->
<!--                                                                             -->
<!-- <label> add a label to a form control                                       -->
<!--         for= the id of the control to associate with the label              -->
<!--                                                                             -->
<!-- <input> add an input/interactive control to the form                        -->
<!--         type= the type of control "button", "text", "submit", "radio"       -->
<!--                                   "select", "checkbox", "password" et al    -->
<!--         id=   the id to be assigned the control                             -->
<!--         name= name to be assigned the value of the control sent to server   -->
<!--         value= initial value to be assigned to the control                  -->
<!--                                                                             -->
<!--         other control specific attributes may also be specified             -->
<!--                                                                             -->
<!-- --------------------------------------------------------------------------- -->

	<body>
		<c:url value="/greeting" var="formAction" />
		<form method="GET" action="${formAction}">
			<label for="name">Your Name: </label>
			<input type="text" id="name" name="name" />
			<input type="submit" value="Get Greeting" />
		</form>
	</body>
</html>