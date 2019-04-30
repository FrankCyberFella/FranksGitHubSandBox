<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<link href="<c:url value="/css/site.css"/>" rel="stylesheet" type="text/css" />
		<title>Home Page - REVIEWS</title>
	</head>
		<body>
		<nav>
		<ul id="link">
			<li><img id="forDummies" src="img/forDummies.png"/><a href="submitAReview">Submit a Review</a></li>
			
		</ul>
		</nav>
			<div id="homePageHeader">Squirrel Cigar Parties for Dummies - REVIEWS</div>
			
			<c:forEach var="review" items="${reviews}">
				<table>
					<tr>
					<td id="title">${review.title}</td>
					</tr>
					<tr>
					<td>by ${review.username} on ${review.dateSubmitted}</td>
					</tr>
					<tr>
					<td><img id="stars" src= "img/${review.rating}-star.png"></td>
					</tr>
					<p></p>
					<tr>
					<td>${review.text}</td>
					</tr>
					</table>
					<hr>
			</c:forEach>
			
		</body>
</html>