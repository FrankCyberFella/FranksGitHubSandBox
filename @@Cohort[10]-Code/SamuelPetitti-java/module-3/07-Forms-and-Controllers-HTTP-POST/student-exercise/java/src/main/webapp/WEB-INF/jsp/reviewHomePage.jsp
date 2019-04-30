<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Squirrel Cigar Party Reviews</title>
 <c:url value="/CSS/site.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>
<body>
<img src="etc/forDummies.png"/>
<h1>Squirrel Cigar Party Reviews</h1>
<ul>
<li><a href="submitReview">Submit a new Post</a></li>
</ul>
<div class = "posts">
<c:forEach var="review" items= "${reviews}">
<div class = "post">
<div>${review.dateSubmitted}</div>
<c:forEach begin= "1" end = "${review.rating}" var= "num">
<img src="etc/star.png"/>
</c:forEach>
<h4>${review.title} (${review.username})</h4>
<p class = "message">${review.text}</p>
</div>
</c:forEach>
</div>
</body>
</html>