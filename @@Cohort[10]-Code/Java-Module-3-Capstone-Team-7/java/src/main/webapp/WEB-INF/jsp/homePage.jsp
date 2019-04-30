<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
		<c:url var="stylesheetHref" value="/css/homePage.css" />
  <link rel="stylesheet" href="${stylesheetHref}">
	</head> 
	<body>
	
			<h1><img id="logo" src="img/logo.png" /></h1>
			
			<a href="surveyPage">Fill out a Survey!</a>
			
			
	<div class="parkDetail"> 
		<c:forEach items="${park}" var="park">
					<c:url var="detailLink" value="detailPage" />
					<a href="${detailLink}?parkCode=${park.parkCode}" >
					<img class="parkImg" src="img/parks/${park.parkCode.toLowerCase()}.jpg" /></a>
					<h2>${park.parkName}</h2>
					<h3>${park.state}</h3>
					<p>${park.parkDescription}</p>
		</c:forEach>
	</div>
	
	</body>
</html>