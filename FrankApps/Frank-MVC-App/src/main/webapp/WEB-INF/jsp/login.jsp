<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<script type="text/javascript">
	$(document).ready(function() {

		$("form").validate({

			rules : {
				userName : {
					required : true,
					email : true,
				},
				password : {
					required : true
				}
			},
			messages : {
				confirmPassword : {
					equalTo : "Passwords do not match"
				}
			},
			errorClass : "error"
		});
	});
</script>

<div class="row">
	<div class="col-sm-4"></div>
	<div class="col-sm-4">
		<c:url var="formAction" value="/login" />
		<form method="POST" action="${formAction}">
			<input type="hidden" name="destination" value="${param.destination}" />
			<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
			<div class="form-group">
				<label for="userName">Email Address: </label> 
				<input type="text" id="userName" name="userName" placeHolder="Email" class="form-control" />
			</div>
			<div class="form-group">
				<label for="password">Password: </label> <input type="password"
					id="password" name="password" placeHolder="Password"
					class="form-control" />
			</div>
			<div class="text-center">
			<button type="submit" class="btn btn-warning">Login</button>
			</div>
		</form>
		
		<br>
		
		<div class="text-center">
			<span class="detailMinor">
				<c:url var="formAction" value="/users/new" />
				<c:out value="Not a registered user?" /><br>
				<a href="${formAction}"> Click here</a>
				<c:out value="to create an account." />
			</span>
		</div>
		
	</div>


<c:import url="/WEB-INF/jsp/footer.jsp" />