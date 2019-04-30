<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Squirrel Cigar Parties</title>
    <c:url value="/css/stylesheet.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>

<body>
    <header>
    		<c:url value="/" var="homePageHref" />
    		<c:url value="/img/forDummies.png" var="logoSrc" />
        <a href="${homePageHref}">
        		<img src="${logoSrc}" alt="Squirrel Cigar Parties" />
        </a>
        <h1>Squirrel Cigar Parties for Dummies</h1>
        <p>Explore the ins and outs of Cigar Parties with Squirrels with Craig Castelaz's award winning installment in the "for Dummies" franchise!</p>
    </header>
    <nav>
        <p> Navigate to view or leave a review. </p>
        <ul>
        	<li><a href="homePage">Home</a></li>  
            <li><a href="reviewPage">Leave a Review</a></li>          
        </ul>
    </nav>