<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

	<title>
		National Parks Geek 
	  	<c:if test="${param.subTitle != null}"> - <c:out value="${param.subTitle}"/></c:if>
	</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/css?family=Acme" rel="stylesheet">
	<c:url var="stylesheetHref" value="/css/main.css" />
	<link rel="stylesheet" href="${stylesheetHref}">
	
</head>
<body>
	<c:url var="logo" value="img/logo.png"/>
	<div id="logo">
		<img id="logoImage" src="${logo}" alt="National Park Logo"/>
	</div>
	<div id="nav">
		<c:url var="homeRef" value="/home" />
		<a href="${homeRef}">Home</a>
		<c:url var="surveyRef" value="/survey" />
		<a href="${surveyRef}">Survey</a>
	</div>
	<div id="container" class="wrapper">