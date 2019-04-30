<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:url var="cssUrl" value="/css/site.css"/>
<link rel="stylesheet" href="${cssUrl}"/>
<title>National Parks</title>
</head>
<body>
	<header>
	</header>
		<nav class="header">
		<img id="title-img" src="img/logo.png" alt ="national park logo"> 
			<ul class="list-header">
				
				<li><a href="home">Home</a></li>
				<li><a href="survey">Survey</a></li>
				<li><a href="results">Results</a></li>
			</ul>
		</nav>
</body>
</html>