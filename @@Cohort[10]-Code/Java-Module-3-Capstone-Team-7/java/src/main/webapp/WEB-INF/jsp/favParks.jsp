<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Hello Spring MVC</title>
	<c:url var="stylesheetHref" value="/css/favParks.css" />
  <link rel="stylesheet" href="${stylesheetHref}">
</head>
<body>
	<h1>National Park Geek</h1>
	<a href="homePage"><p>Home</p></a>
	<h2>Here are everyone's favorite parks!</h2>

<div id="forum-stuff">
	<c:forEach items="${surveys}" var="survey">
	<div id="forum-things">
		<p>${survey.key} has ${survey.value} survey(s) completed!</p>
	</div>
	</c:forEach>
</div>