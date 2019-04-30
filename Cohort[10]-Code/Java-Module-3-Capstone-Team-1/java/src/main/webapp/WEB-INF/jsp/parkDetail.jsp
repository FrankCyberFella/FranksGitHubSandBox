<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="common/header.jsp"%>
<div id="parkDetail">
	<c:url var="url" value="img/parks/${park.parkCode.toLowerCase()}.jpg"/>
	<div id="detail_top_section">
	<img src="${url}" id="park_detail_img"/>
	<br>
	<div id="name_quote">
	<h2>${park.parkName} (${park.parkCode})</h2>
	${park.inspirationalQuote} - ${park.inspirationalQuoteSource} <br>
	<table>
	<th>Park Facts</th>
		<tr>
			<td>Year Founded</td>
			<td>${park.yearFounded}</td>
		</tr>
		<tr>
			<td>Location</td>
			<td>${park.state}</td>
		</tr>
		<tr>
			<td>Acreage</td>
			<td>${park.acreage}</td>
		</tr>
		<tr>
			<td>Elevation</td>
			<td>${park.elevationInFeet}</td>
		</tr>
		<tr>
			<td>Number of Campsites</td>
			<td>${park.numberOfCampsites}</td>
		</tr>
		<tr>
			<td>Miles of Trail</td>
			<td>${park.milesOfTrail}</td>
		</tr>
		<tr>
			<td>Climate</td>
			<td>${park.climate}</td>
		</tr>
		<tr>
			<td>Number of Animal Species</td>
			<td>${park.numberOfAnimalSpecies}</td>
		</tr>
		<tr>
			<td>Annual Visitors</td>
			<td>${park.annualVisitorCount}</td>
		</tr>
		<tr>
			<td>Entry Fee</td>
			<td>$${park.entryFee}</td>
		</tr>
	</table>
	</div>
	</div>
	<br>
	<p>${park.parkDescription}</p>
	<br>
	
	<c:url var="tempURL" value="/parkDetail"/>
		<form action="${tempURL}"> <!-- method="POST"-->
			<input type="hidden" name="parkCode" value="${park.parkCode}"/>
			<input type="submit" name="degrees" value="F"/>
			<input type="submit" name="degrees" value="C"/>
			
		</form>
	<div id="weather">
		<c:forEach var="daily" items="${weather}">
		<div id="forecast-tiles">
		<c:url var="wUrl" value="img/weather/${daily.forecast.replace(' c', 'C')}.png"/>		
		<img src="${wUrl}" id="weather_img"/>
		<br>
		${daily.weatherDate} 
		<br>
		${daily.forecast}
		<br>
		<c:choose>
			<c:when test="${param.degrees == 'F'}">
				High: ${daily.high}&deg;F / Low: ${daily.low}&deg;F
			</c:when>
			<c:when test="${param.degrees == 'C'}">
				High: ${daily.highC}&deg;C / Low: ${daily.lowC}&deg;C
			</c:when>
		</c:choose>
		
		
		<br>
		Tips for the day: <c:choose>
			<c:when test="${daily.forecast == 'snow'}">
				Pack snowshoes!
			</c:when>
			
			<c:when test="${daily.forecast == 'rain'}">
				Pack rain gear, wear waterproof shoes!
			</c:when>
			
			<c:when test="${daily.forecast == 'thunderstorms'}">
				Seek shelter, avoid hiking on exposed ridges!
			</c:when>
			
			<c:when test="${daily.forecast == 'sunny'}">
				Pack sunblock!
			</c:when>
		</c:choose>
			
		
			<c:if test="${daily.high > 75}">
				Bring an extra gallon of water!
			</c:if>
			
			<c:if test="${(daily.high - daily.low) > 20}">
				Wear breathable layers!
			</c:if>
			
			<c:if test="${daily.high < 20 || daily.low < 20}">
				WARNING! ZERO SKIN EXPOSURE!
			</c:if>
		
		</div>
		</c:forEach>
		
	
	</div>
		

</div>
<%@include file="common/footer.jsp"%>