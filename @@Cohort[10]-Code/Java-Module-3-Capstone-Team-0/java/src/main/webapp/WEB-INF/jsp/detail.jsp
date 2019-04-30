<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="pageTitle" value="Park Details"/>
<%@include file="common/header.jspf" %>

	<div class="card shadow p-3 mb-5 rounded detail-card">
		<div class="card-body2">
			<img id="park-img" src="img/parks/${param.parkCode.toLowerCase()}.jpg"/>
			<div class="card shadow-sm p-3 mb-5 rounded park-description">
				<h3>${park.parkName}</h3>
				<p>${park.parkDescription}</p>
			</div>
			<div class="card shadow-sm p-3 mb-5 rounded park-details">
				<div id="state">State: ${park.state}</div>
				<div id="acreage">Acreage: ${park.acreage} acres</div>
				<div id="elevationInFeet">Elevation: ${park.elevationInFeet}</div>
				<div id="milesOfTrail">${park.milesOfTrail} miles of trail</div>
				<div id="numberOfCampsites">${park.numberOfCampsites} campsites</div>
				<div id="climate">Climate: ${park.climate}</div>
				<div id="numberOfAnimalSpecies">Number of Animal Species: ${park.numberOfAnimalSpecies}</div>
			</div>
			<div class="card shadow-sm p-3 mb-5 rounded park-quote">
				<div id="yearFounded">Founded in ${park.yearFounded}</div>
				<div id="annualVisitorCount"><fmt:formatNumber type="number">${park.annualVisitorCount}</fmt:formatNumber> visitors per year</div>
				<hr>
				<div id="inspirationQuote"><i>${park.inspirationQuote}</i> -${park.inspirationQuoteSource}</div>
			</div>
			<div class="card shadow-sm p-3 mb-5 rounded park-fee">
				<div>
					<div id="entryFee">-Daily Fee-</div>
					
					<h1 style="color: green; text-align: center; font-size: 52px;">
						<fmt:formatNumber type="currency">${park.entryFee}</fmt:formatNumber>
					</h1>
				</div>
			</div>
			
			
		</div>
	</div>
	<c:url var="postPath" value="detail?parkCode=${param.parkCode}"/>
	
	
	
	
	
	
	
	
	
	<div class="card shadow-sm p-3 mb-5 rounded">
		<div id="toggle-wrapper">
			<form action="${postPath}" method="POST" id="slider">
				<div >
					<input type="range" min="0" max="1" value = "${celsius}" name="celsius" id="celsius">
				</div>
				<input type="submit" class="btn btn-outline-primary" value="F   /   C"/>
			</form>
			<div id="forecast-title">
				<h2>5 Day Forecast</h2>
			</div>
		</div>
		
		<div class="detail-weather">
			<c:forEach var="weather" items="${weathers}">
				<div class="card shadow p-3 mb-5 rounded weather-group">
					
						<img id="forecast-img" src="img/weather/${weather.forecast}.png"/>
						<span style="color: #ff7d3d"class="highword"><h6>High</h6></span>
						<span class="high">
							${Math.round((weather.high-celsius*(32))*(1-4/9*celsius))}&#176 
							<c:choose>
								<c:when test="${celsius==0}">
									F
								</c:when>
								<c:when test="${celsius==1}">
									C
								</c:when>		
							</c:choose>
						</span>
						<span style="color: #3dc8ff" class="lowword"><h6>Low</h6></span>
						<span class="low">
							${Math.round((weather.low-celsius*(32))*(1-4/9*celsius))}&#176 
							<c:choose>
								<c:when test="${celsius==0}">
									F
								</c:when>
								<c:when test="${celsius==1}">
									C
								</c:when>		
							</c:choose>
						</span>
					
					<div class="weather-dress">
						
						<c:if test="${weather.forecast=='snow'}">
							<div class="alert alert-info" role="alert">It's great weather for snowshoes!</div>
						</c:if>
						<c:if test="${weather.forecast=='rain'}">
							<div class="alert alert-primary" role="alert">Remember your rain gear and waterproof shoes!</div>
						</c:if>
						<c:if test="${weather.forecast=='thunderstorms'}">
							<div class="alert alert-danger" role="alert">Seek shelter!
							Do not hike on exposed ridges!</div>
						</c:if>
						<c:if test="${weather.forecast=='sunny'}">
							<div class="alert alert-warning" role="alert">Remember your sunblock!</div>
						</c:if>
						<c:if test="${weather.high>75}">
							<div class="alert alert-info" role="alert">Bring an extra gallon of water!</div>
						</c:if>
						<c:if test="${weather.high-weather.low>20}">
							<div class="alert alert-secondary" role="alert">Wear breathable layers!</div>
						</c:if>
						<c:if test="${weather.low<20}">
							<div class="alert alert-primary" role="alert">Be careful! Exposure to frigid temperatures can be lethal!</div>
						</c:if>
							
						
					</div>
				
				
				</div>	
			</c:forEach>
		</div>
	</div>
	
<%@include file="common/footer.jspf" %>
