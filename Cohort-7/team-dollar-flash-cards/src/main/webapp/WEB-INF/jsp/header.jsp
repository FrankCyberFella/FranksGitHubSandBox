<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Flash Attack</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
<script
	src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.js "></script>
<script
	src="https://cdn.jsdelivr.net/jquery.timeago/1.4.1/jquery.timeago.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet">
<c:url var="cssHref" value="/css/capstone.css" />
<link rel="stylesheet" type="text/css" href="${cssHref}">

<script type="text/javascript">
	$(document).ready(function() {
		$("time.timeago").timeago();

		$("#logoutLink").click(function(event) {
			$("#logoutForm").submit();
		});

		var pathname = window.location.pathname;
		$("nav a[href='" + pathname + "']").parent().addClass("active");

	});
</script>

</head>
<body>
	<header>
		<div class="header">
			<c:url var="homePageHref" value="/" />
			<c:url var="imgSrc" value="/img/logo.png" />
			<a href="${homePageHref}" class="headerHomeLink"> <img class="headerImage"
				src="${imgSrc}" />
			</a>
			<div class="buttons">
				<c:url var="homePageHref" value="/" />
				<form class="headerLink" action="${homePageHref}" method="GET">
					<button class="headerButton">Home</button>
				</form>
				<c:if test="${not empty currentUser}">
					<c:url var="changePasswordHref" value="/users/changePassword" />
					<form class="headerLink" action="${changePasswordHref}"
						method="GET">
						<button class="headerButton">Change Password</button>
					</form>
				</c:if>
				<c:choose>
					<c:when test="${empty currentUser}">
						<c:url var="newUserHref" value="/users/new" />
						<form class="headerLink" action="${newUserHref}" method="GET">
							<button class="headerButton">Sign Up</button>
						</form>
						<c:url var="loginHref" value="/login" />
						<form class="headerLink" action="${loginHref}" method="GET">
							<button class="headerButton">Log In</button>
						</form>
					</c:when>
					<c:otherwise>
						<c:url var="logoutAction" value="/logout" />
						<form class="headerLink" action="${logoutAction}" method="POST">
							<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
							<button class="headerButton">Log Out</button>
						</form>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</header>