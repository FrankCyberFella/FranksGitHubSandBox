<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<script type="text/javascript">
	$(document).ready(function () {
		$.validator.addMethod('capitals', function(thing){
			return thing.match(/[A-Z]/);
		});
		$("form").validate({
			
			rules : {
				password : {
					required : true,
					minlength: 5,
					capitals: true,
				},
				confirmPassword : {
					required : true,		
					equalTo : "#password"  
				}
			},
			messages : {			
				password: {
					minlength: "Password too short, make it at least 5 characters",
					capitals: "Field must contain a capital letter",
				},
				confirmPassword : {
					equalTo : "Passwords do not match"
				}
			},
			errorClass : "error"
		});
	});
</script>

<c:url var="formAction" value="/users/changePassword" />
<form method="POST" action="${formAction}" >
<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<div class="form-group">
				<label for="password">Current Password: </label>
				<input type="password" id="password" name="password" placeHolder="Current Password" class="form-control" />
			</div>
			<div class="form-group">
				<label for="password">New Password: </label>
				<input type="password" id="password" name="password" placeHolder="New Password" class="form-control" />
			</div>
			<div class="form-group">
				<label for="confirmPassword">Confirm Password: </label>
				<input type="password" id="confirmPassword" name="confirmPassword" placeHolder="Re-Type Password" class="form-control" />	
			</div>
<!-- 		<div class="form-group">
				<input type="hidden" name="role" id="role" value="user"/>
			</div> 
			Don't know if we want this yet, the hidden value should already be set -->
			<button type="submit" class="btn btn-warning">Change Password</button>
		</div>
		<div class="col-sm-4"></div>
	</div>
</form>

<c:import url="/WEB-INF/jsp/footer.jsp" />