<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$.validator.addMethod('capitals', function(thing) {
							return thing.match(/[A-Z]/);
						});
						$("form#passwordChangeValidation")
								.validate(
										{

											rules : {
												currentPassword : {
													required : true
												},
												newPassword : {
													required : true,
													minlength : 10,
													capitals : true,
												},
												confirmNewPassword : {
													required : true,
													equalTo : "#newPassword"
												}
											},
											messages : {
												password : {
													minlength : "Password too short, make it at least 15 characters",
													capitals : "Field must contain a capital letter",
												},
												confirmPassword : {
													equalTo : "Passwords do not match"
												}
											},
											errorClass : "error"
										});
					});
</script>

<div class="passwordChangeMessage">
Change password for <c:out value="${currentUser.userName}" />
</div>

<c:url var="formAction" value="/changePassword" />
<form method="POST" action="${formAction}" id="passwordChangeValidation">
	<c:out value="${message}" />
	<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<div class="form-group">
				<label for="currentPassword">Current Password: </label> <input type="password"
					id="currentPassword" name="currentPassword" placeHolder="Current Password"
					class="form-control" />
			</div>
			<div class="form-group">
				<label for="newPassword">New Password: </label> <input type="password"
					id="newPassword" name="newPassword" placeHolder="New Password"
					class="form-control" />
			</div>
			<div class="form-group">
				<label for="confirmNewPassword">Confirm New Password: </label> <input
					type="password" id="confirmNewPassword" name="confirmNewPassword"
					placeHolder="Re-Type New Password" class="form-control"/>
			</div>
			<input type="hidden" name="role" value="user" />
			<button type="submit" class="changePassword">Change
				Password</button>
		</div>
		<div class="col-sm-4"></div>
	</div>
</form>

<c:import url="/WEB-INF/jsp/footer.jsp" />