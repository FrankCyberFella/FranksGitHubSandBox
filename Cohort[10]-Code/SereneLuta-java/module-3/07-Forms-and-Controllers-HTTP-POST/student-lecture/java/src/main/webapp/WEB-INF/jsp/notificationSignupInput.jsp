<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
		<link rel="stylesheet" href="css/site.css"></link>
	</head>
	<body>
		<div id="main_content">
			<h1>You are this close to Awesome...</h1>
			<form action="notificationSignupInput" method="POST"><!-- POST = variables are not put in the query string -->
																 <!-- form variables are put in the body -->
			
			<!-- action tells the URL method tells what you are doing with the form Getting/Posting -->
				<div class="formGroup">
					<label for="firstName">First Name: </label>
					<input type="text" name="firstName" id="firstName" />
				</div>
				<div class="formGroup">
					<label for="lastName">Last Name: </label>
					<input type="text" name="lastName" id="lastName" />
				</div>	
				<div class="formGroup">		
					<label for="age">Age: </label>
					<input type="text" name="age" id="age" />
				</div>	
				<div class="formGroup">		
					<label for="emailAddress">Email Address: </label>
					<input type="text" name="emailAddress" id="emailAddress" />
				</div>
				<div class="formGroup">
					<input type="submit" value="Sign Up" />
				</div>		
			</form>
		</div>
	</body>
</html>