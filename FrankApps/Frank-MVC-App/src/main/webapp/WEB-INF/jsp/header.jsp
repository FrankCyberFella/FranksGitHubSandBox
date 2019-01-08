<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.io.BufferedReader"%>
<%@page import ="java.io.IOException" %>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URLConnection"%>
<%@page import=" java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>Capstone</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.js "></script>
<script
	src="https://cdn.jsdelivr.net/jquery.timeago/1.4.1/jquery.timeago.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	
<c:url value="/css/site.css" var="cssUrl" />
<link rel="stylesheet" type="text/css" href="${cssUrl}" />
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
<link href="https://fonts.googleapis.com/css?family=PT+Serif|Open+Sans|Shrikhand|Sanchez"
	rel="stylesheet">
</head>
<body>
	<header class="header-bkgd">
		<c:choose>
			<c:when test="${empty currentUser}">
				<c:url var="homePageHref" value="/" />
				
							</c:when>
			<c:otherwise>
				<c:url var="homePageHref" value="/dashboard" />
			</c:otherwise>
		</c:choose>
	</header>
	<nav class="navbar">	
		
		<div class="container-fluid d-flex">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent1"
				aria-controls="navbarSupportedContent1" aria-expanded="false"
				aria-label="Toggle navigation">
				<img id="burger" height="30" width="30" alt=""
					src="https://image.ibb.co/dhFJkz/hamburgerstill.png">
				<span class="nav-logo linktext">grill & chill</span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent1">
				<ul class="nav navbar-nav mr-auto">
					<li id="logoDesktop" class="nav-logo linktext">grill & chill</li>
					<c:choose>
						<c:when test="${empty currentUser}">
							<c:url var="homePageHref" value="/" />
							<li class="nav-item active"><a class="nav-link linktext"
								href="${homePageHref}"><i class="material-icons">home</i>Home</a></li>
						</c:when>
						<c:otherwise>
							<c:url var="homePageHref" value="/dashboard" />
							<li class="nav-item active"><a class="nav-link linktext"
								href="${homePageHref}"><i class="material-icons">home</i>
									Home</a></li>
							<c:url var="dashboardHref" value="${currentUser}/myCookouts" />
							<c:url var="dashboardHref" value="/createCookoutDetails" />
							<li class="nav-item active"><a class="nav-link linktext"
								href="${dashboardHref}"><i class="material-icons">whatshot</i>
									Create Cookout</a></li><%--  <c:url var="changePasswordHref"
									value="/changePassword" />
							<li class="nav-item active"><a class="nav-link linktext"
								href="${changePasswordHref}"><i class="material-icons">system_update_alt</i>
									Change Password</a></li> --%>
						</c:otherwise>
					</c:choose>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${empty currentUser}">
							<c:url var="newUserHref" value="/users/new" />
							<li class="nav-item active"><a class="nav-link linktext"
								href="${newUserHref}"><i class="material-icons">person_add</i>
									Sign Up</a></li>
							<c:url var="loginHref" value="/login" />
							<li class="nav-item active"><a class="nav-link linktext"
								href="${loginHref}"><i class="material-icons">send</i> Log
									In</a></li>
						</c:when>
						<c:otherwise>
							<c:url var="logoutAction" value="/logout" />
							<form id="logoutForm" action="${logoutAction}" method="POST">
								<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
							</form>
							<li class="nav-item active"><a class="nav-link linktext"
								id="logoutLink" href="#"><i class="material-icons">send</i>
									Log Out</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>
	<c:if test="${not empty currentUser}">
		<p class="text-right" id="currentUser"><strong>Logged in as: ${currentUser.userName}&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</strong></p>
	</c:if>

	<c:if test="${detailMessage != null}">
		<div class="alert alert-success" role="alert">
			<c:out value="${detailMessage}" />
		</div>
		<br>
	</c:if>
	<div class="container">