<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Hello Spring MVC</title>
<c:url var="stylesheetHref" value="/css/detailPage.css" />
<link rel="stylesheet" href="${stylesheetHref}">
</head>
<body>
	<h1>
			<img id="logo" src="img/logo.png" />
	</h1>
	<a href="homePage">Home</a>
	<a href="surveyPage">Fill out a Survey!</a>
	
	
	<h2>${park.parkName} Details</h2>
	<div class="parkContainer">
		<div class="imgContainer infoBox">
			<img src="img/parks/${park.parkCode.toLowerCase()}.jpg" />
			<p>${park.inspirationalQuote} -${park.inspirationalQuoteSource}</p>
		</div>
		<div class="infoBox">
			<p>${park.parkDescription}</p>
		</div>
		
		<table id="infoTable" class="infoBox" >
			<thead>
				<tr>
					<th>Park Information</th>
				</tr>
			</thead>
				<tr>
					<td>Acreage: </td>
					<td>${park.acreage} acres</td>
				</tr>
				<tr>
					<td>Elevation:</td>
					<td>${park.elevationInFeet} feet</td>
				</tr>
				<tr>
					<td>Miles of trail:</td>
					<td>${park.milesOfTrail} miles</td>
				</tr>
				<tr>
					<td>Number of Campsites:</td>
					<td>${park.numberOfCampsites} campsites</td>
				</tr>
				<tr>
					<td>Climate:</td>
					<td>${park.climate}</td>
				</tr>
				<tr>
					<td>Year Founded:</td>
					<td>${park.yearFounded}</td>
				</tr>
				<tr>
					<td>Annual Visitors:</td>
					<td>${park.visitorCount}</td>
				</tr>
				<tr>
					<td>Entry Fee:</td>
					<td>$${park.entryFee} </td>
				</tr>
				<tr>
					<td>Number of animal species:</td>
					<td>${park.numberOfAnimalSpecies} </td>
				</tr>
				
		
		
		
		</table>
			
	</div>
	
	<div id="weather">
	<h2>Five Day Forecast</h2>
	<c:url var="detailLink" value="/detailPage?parkCode=${park.parkCode}" />
					
		<form id ="tempSelect" action="${detailLink}" method="POST">
		<input type="radio" name="temperature" value="0">Fahrenheit
		<input type="radio" name="temperature" value="1">Celsius
		<input type= "submit" value= "Change Temp">
		</form>
		<c:forEach items="${weather}" var="weather">
			<table class="weatherTable">
				<tr>
					<td><c:choose><c:when test="${weather.fiveDayForecastValue == 1}">Today </c:when></c:choose>Day ${weather.fiveDayForecastValue}</td>
					<td><img class="forecastImg"src="img/weather/${weather.forecast}.png"></td>
					<td><c:choose><c:when test="${weather.lowF < 20}">Warning! Frigid temperatures suck! </c:when></c:choose><c:choose><c:when test="${sessionScope.temp =='1'}">The low is ${weather.lowC}°C</c:when><c:otherwise>The low is ${weather.lowF}°F</otherwise></c:otherwise></c:choose></td>
					<td><c:choose><c:when test="${weather.highF > 75}">Bring an extra gallon of water! </c:when></c:choose><c:choose><c:when test="${sessionScope.temp =='1'}">The high is ${weather.highC}°C</c:when><c:otherwise>The high is ${weather.highF}°F</otherwise></c:otherwise></c:choose></td>
					<td><c:choose><c:when test="${weather.highF - weather.lowF > 20}"> Wear breathable layers! </c:when></c:choose></td>
					<td><c:choose><c:when test="${weather.forecast == 'snow'}">Pack snowshoes! </c:when></c:choose>
						<c:choose><c:when test="${weather.forecast == 'rain'}">Pack rain gear and wear waterproof shoes! </c:when></c:choose>
						<c:choose><c:when test="${weather.forecast == 'thunderstorms'}">Seek shelter and avoid hiking on exposed ridges! </c:when></c:choose>
						<c:choose><c:when test="${weather.forecast == 'sunny'}">Pack sunblock! </c:when></c:choose>
					The forecast calls for ${weather.forecast}</td>
				</tr>
				
			</table>
		</c:forEach>
	</div>
</body>
</html>