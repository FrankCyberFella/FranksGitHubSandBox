<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>National Park Weather Service</title>
    <c:url value="/css/site.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>

<body>
    <header>
    		<c:url value="/" var="homePageHref" />
    		<c:url value="/img/logo.png" var="logoSrc" />
    		<div class="logIn">
        <a href="${homePageHref}">
        		<img src="${logoSrc}" alt="Solar System Geek logo" />
        </a>
          
            </div>
        <h1> <em> National Park Weather Service </em></h1>
      
    </header>
    <nav>
        <p>  Click on any park image to view more detailed information about it.  </p>
        <ul>
            <li class="links"><a href="homePage">Home</a></li>
            <li class="links"><a href="login">Login</a></li>
            <li class="links"><a href="survey">Survey</a></li>             
        </ul>
    </nav>