<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Campground Reservation Home Page" />
</c:import>
<div id="welcomeMsg">${park.parkName}</div>
<div id="park-image">
	<img src="img/parks/${park.parkCode.toLowerCase()}.jpg">
</div>
<b class="quote-source">${park.quoteSource}:</b>
<br>
<p class="quote">"${park.quote}"</p>
<p class="description">${park.description}</p>
<table>
	<tr>
		<th>Description</th>
		<th>Value</th>
	</tr>
	<tr>
		<td>State</td>
		<td>${park.state}</td>
	</tr>
	<tr>
		<td>acreage</td>
		<td>${park.acreage}</td>
	</tr>
	<tr>
		<td>Elevation (ft.)</td>
		<td>${park.elevationFeet}</td>
	</tr>
	<tr>
		<td>Miles of Trail</td>
		<td>${park.milesOfTrail}</td>
	</tr>
	<tr>
		<td>Number of Campsites</td>
		<td>${park.numberOfCampsites}</td>
	</tr>
	<tr>
		<td>Climate</td>
		<td>${park.climate}</td>
	</tr>
	<tr>
		<td>Year Founded</td>
		<td>${park.yearFounded}</td>
	</tr>
	<tr>
		<td>Annual Visitor Count</td>
		<td>${park.visitors}</td>
	</tr>
	<tr>
		<td>Entry Fee</td>
		<td>$${park.entryFee}</td>
	</tr>
	<tr>
		<td>Number of Species</td>
		<td>${park.numberOfSpecies}</td>
	</tr>
</table>
<div id="count">
	<c:set var="count" value="1" />
</div>
	<div class="box">	
<c:forEach items="${forecasts}" var="forecast">
	<div id="content">
		
			<c:if test="${count == 1}">
		<div id="first">
				<h3>Today</h3>

				
				<img src="img/weather/${forecast.forecast}.png">
				<p>
					<b>High:</b> ${forecast.high}
					<c:choose>
						<c:when test="${temp==0}">
							 Fahrenheit
		 				</c:when>
					<c:otherwise>
		  				Celsius
		 			</c:otherwise>
					</c:choose>
				</p>
				<p>
					<b>Low:</b> ${forecast.low}
					<c:choose>
						<c:when test="${temp==0}">
		 					Fahrenheit
		 				</c:when>
						<c:otherwise>
		  					Celsius
		 				</c:otherwise>
					</c:choose>
				</p><br>
	
		<!-- closing div for box -->
	
	<!-- closing div for content -->
	<c:choose>
		<c:when test="${forecast.high >= 75 && temp == 0}">
			<b>Bring an extra gallucci's water</b>
			<br>
		</c:when>
		<c:when test="${forecast.high >= 24 && temp == 1}">
			<b>Bring an extra gallucci's water</b>
			<br>
		</c:when>
		<c:when test="${forecast.low < 20 && temp == 0}">
			<b>Wear a heated blanket you loon!</b>
			<br>
		</c:when>
		<c:when test="${forecast.low < -6 && temp == 1}">
			<b>Bring an extra gallucci's water</b>
			<br>
		</c:when>
		<c:when test="${forecast.high - forecast.low >= 20 && temp == 0}">
			<b>Wear clothes that have lungs</b>
			<br>
		</c:when>
		<c:when test="${forecast.high - forecast.low >= 11 && temp == 1}">
			<b>Wear clothes that have lungs</b>
			<br>
		</c:when>

		<c:otherwise>
			<b>Have a nice day brudda</b>
			<br>
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="${forecast.forecast == 'snow'}">
			<b>Pack snow shoes</b>
			<br>
		</c:when>
		<c:when test="${forecast.forecast == 'rain'}">
			<b>Pack rain gear, and wear waterproof shoes, and pack a snorkel</b>
			<br>
		</c:when>
		<c:when test="${forecast.forecast == 'thunderstorms'}">
			<b>Seek shelter and avoid hiking on exposed ridges</b>
			<br>
		</c:when>
		<c:when test="${forecast.forecast == 'sunny'}">
			<b>Pack sunscreen, preferably SPF 50</b>
			<br>
		</c:when>
	</c:choose>
		</div>
	</c:if>
	
	
	<c:if test="${count > 1 }">
		<div id="twoToFive">
		<img src="img/weather/${forecast.forecast}.png">
		<p>
			<b>High:</b> ${forecast.high}
		</p>
		<p>
			<b>Low:</b> ${forecast.low}
		</p>
		</div>
	</c:if>



	</div>
	<c:set var="count" value="${count + 1}" />
</c:forEach>
</div>
	
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
