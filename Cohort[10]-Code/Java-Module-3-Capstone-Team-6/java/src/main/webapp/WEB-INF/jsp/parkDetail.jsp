<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:import url="/WEB-INF/common/header.jsp"/>
<c:set var ="parkcode" value ="${param.parkCode}"/>
<body>
<section class="main">
	<div class="detail-title">
	<p id="park-name">${detail.parkName} </p>
	<p id="state">${detail.state}</p>
	</div>
	<div class="pic-table">
		<div id="quote-contain">
			<p><img class="detail-img" src="img/parks/${detail.parkCode.toLowerCase()}.jpg" alt="Park Images"></p>
				<div class="quote-words">
					<p id="quote">${detail.inspirationalQuote}</p>
						<p id="quote">-${detail.inspirationalQuoteSource}</p>
				</div>
		</div>
	<table id="detail-table">
	<tr>
    <th>Founded:</th>
    <td>${detail.yearFounded}</td>
  </tr>
  <tr>
    <th>Acreage:</th>
    <td>${detail.acreage}</td>
  </tr>
  <tr>
    <th>Elevation:</th>
    <td>${detail.elevationInFeet} feet</td>
  </tr>
  <tr>
    <th>Trail Length:</th>
    <td>${detail.milesOfTrail} miles</td>
  </tr>
  <tr>
    <th>Climate:</th>
    <td>${detail.climate}</td>
  </tr>
  <tr>
    <th>Annual Visitors:</th>
    <td>${detail.annualVisitorCount}</td>
  </tr>
  <tr>
    <th>Campsites:</th>
    <td>${detail.numberOfCampsites}</td>
  </tr>
  <tr>
    <th>Animal Species:</th>
    <td>${detail.numberOfAnimalSpecies}</td>
  </tr>
   <tr>
    <th>Entry Fee:</th>
    <td>$${detail.entryFee}</td>
  </tr>
	</table>
	</div>
	<div class="quote-text">
	
	<p id="detail-desc">${detail.parkDescription}</p>
	</div>


	<p id="weather-heading">5 Day Weather Forecast</p>
	
	<ul class="weather-list">
		<c:forEach items="${today}" var="weather">
		<div class="main-weather">
			<div id="today">Today</div>
			<img id="today-weather" src="img/weather/${weather.forecast}.png" alt="Park Images">
			<c:choose>
					<c:when test="${param.mySubmit == 'Fahrenheit' }">
			<li>High ${weather.high} &#8457; || Low ${weather.low} &#8457;</li>
			</c:when>
			<c:when test="${param.mySubmit == 'Celcius' }">
			<li>High ${weather.highCel} &#8451; || Low ${weather.lowCel} &#8451;</li>
			</c:when>
			</c:choose>
			<div class="message">
				<c:choose>
					<c:when test="${weather.high > 75 }">
						<c:out value="Bring an extra gallon of water!"/>
					</c:when>
					<c:when test="${weather.low < 20}">
						<c:out value="Danger!!! Frigid Temperatures!!"/>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${weather.high - weather.low > 20 }">
						<c:out value="Wear breathable layers."/>
					</c:when>
				</c:choose>
			
				<c:choose>
					<c:when test="${weather.forecast == 'rain' }">
						<c:out value="Pack rain gear and wear waterproof shoes."/>
					</c:when>
					<c:when test ="${weather.forecast == 'snow'}">
						<c:out value="Where are my snow shoes?"/>
					</c:when>
					<c:when test="${weather.forecast == 'thunderstorms'}">
						<c:out value="Seek shelter and avoid hiking on exposed ridges."/>
					</c:when>
					<c:when test="${weather.forecast == 'sunny' }">
						<c:out value="Pack that sunblock."/>
					</c:when>		
				</c:choose>
				</div>
			</div>
	
		</c:forEach>
		<c:forEach items="${four}" var="four">
			<div class="four-div">
				<img id="four-img" src="img/weather/${four.forecast}.png" alt="Park Images">
				<c:choose>
					<c:when test="${param.mySubmit == 'Fahrenheit' }">
				<li>High ${four.high} &#8457;</li>
				<li>Low ${four.low} &#8457;</li>
					</c:when>
					<c:when test="${param.mySubmit == 'Celcius' }">
				<li>High ${four.highCel} &#8451;</li>
				<li>Low ${four.lowCel} &#8451;</li>
					</c:when>
				</c:choose>
			</div>
		</c:forEach>
	</ul>
	
	<c:url value="/parkDetail" var="surveyUrl"/>
	
	<form action="${surveyUrl}" method="GET">
	<div class="choice">
	<input type="hidden" name="parkcode" value="${detail.parkCode}"/>
	<input type="submit" name="mySubmit" value="Fahrenheit"/>
	
	
	<input type="submit" name="mySubmit" value="Celcius"/>
	</div>
	</form>
	
	</section>
</body>
<c:import url="/WEB-INF/common/footer.jsp"/>
</html>