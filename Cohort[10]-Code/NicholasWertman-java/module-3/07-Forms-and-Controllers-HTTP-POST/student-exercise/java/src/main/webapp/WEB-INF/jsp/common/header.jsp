<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
	<head>
		<title>See All Reviews</title>
		<c:url value="/css/site.css" var="cssHREF"/>
		<link rel="stylesheet" href="${cssHREF}">
	</head>
<body>
	<header>
		<div id="headingContainer">
			<h1> Squirrel Parties For Dummies</h1>
			<c:url value="/img/forDummies.png" var="forDummies"/>
			<img id="dummiesCover" src="${forDummies}" alt="For Dummies Book Cover"/>
		</div>
	</header>
