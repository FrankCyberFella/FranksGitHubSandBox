<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Squirrel Cigar Parties 101</title>
    <c:url value="/css/dummybook.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>

<body>
    <header>
    		<c:url value="/" var="homePageHref" />
    		<c:url value="/img/ssg_logo.png" var="logoSrc" />

        <h1>The Greatest book Ever</h1>
        
    </header>
    <nav>
  
        <ul>
            <li><a href="forumPostInput">Post a Review</a></li>
            <li><a href="homepage">Home</a></li>
             
        </ul>
    </nav>