<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:url value="/css/site.css" var="cssURL" />
<link rel="stylesheet" type="text/css" href="${cssURL}">
<title>Campground Reservations</title>
</head>
<body>
	<c:url var="home" value="/home"/>
	<c:url var="survey" value="/parkSurvey"/>
	<c:url value="/img/logo.png" var="logoURL" />
	<c:url value="/surveyResult" var="surveyResult"/>
	<c:url value="/changeTemp" var="changeTemp"/>
	<div class="navbar-collapse collapse">
	<nav>
	<img src="${logoURL}" >
		<ul class="nav navbar-nav">
			<li><a href="${home}">Home</a></li>
			<li><a href="${survey}">Survey</a></li>
			<li><a href="${surveyResult}">Survey Results</a></li>
			<li><a href="${changeTemp}">Change to
			<c:choose>
		<c:when test="${temp==1}">
		 Fahrenheit
		 </c:when>
		 <c:otherwise>
		  Celsius
		 </c:otherwise>
	</c:choose>
			</a></li>
		</ul>
	</nav>
	</div>
</body>
    
    <h1 class="pageTitle"><c:out value="${param.pageTitle}" /></h1>