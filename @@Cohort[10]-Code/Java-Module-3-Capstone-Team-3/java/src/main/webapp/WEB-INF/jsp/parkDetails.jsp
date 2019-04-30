<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<div class="parkDetails">		
		<div id="parkHeading">
			<h4>${park.parkName}</h4>
			<h6>${park.state}</h6>
		</div>
		<div id="parkPhoto">
			<c:url var="parkImage" value="/img/parks/${park.parkCode}.jpg"/>
			<img src="${parkImage}" alt="park Image"/>	
			<p>"${park.inspirationalQuote}"</p>
			<p>-${park.inspirationalSource}-</p>
		</div>
		<div id="parkInfo">
			<table id="infoTable" class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Park Information</th>
					</tr>
				</thead>
				<tr>
					<td>Acreage: </td>
					<td>${park.acreage}</td>
				</tr>
				<tr>
					<td >Elevation: </td>
					<td>${park.elevationInFeet} ft</td>
				</tr>
				<tr>
					<td >Miles Of Trail: </td>
					<td>${park.milesOfTrail}</td>
				</tr>
				<tr>
					<td >Number Of Campsites: </td>
					<td>${park.numberOfCampsites}</td>
				</tr>
				<tr>
					<td>Climate: </td>
					<td>${park.climate}</td>
				</tr>
				<tr>
					<td>Year Founded: </td>
					<td>${park.yearFounded}</td>
				</tr>
				<tr>
					<td>Annual Visitors: </td>
					<td>${park.annualVisitorCount}</td>
				</tr>
				<tr>
					<td>Entry Fee: </td>
					<td>$${park.entryFee}</td>
				</tr>
				<tr>
					<td>Animal Species: </td>
					<td>${park.numberOfAnimalSpecies}</td>
				</tr>
			</table>
			<p id="parkDescription">${park.parkDescription}</p>
		</div>
	</div>
	<div id="fiveDayForecast">
	<c:url var="details" value="/parkDetails?theCode=${park.parkCode}"/>
	<form:form id="tempForm" action="${details}" method="POST">
		<select name="temperature">
			<option value="0">Fahrenheit</option>
			<option value="1">Celcius</option>
		</select>
		<input class="btn btn-primary btn-sm" type="submit" name="submitButton" value="change">
	</form:form>
	<div id="forecastContainer">
		<c:forEach var="weatherDay" items="${weather}">
			<c:set var="dayOfWeek" value="${weatherDay.fiveDayForecastValue}"/>
			<div class="forecast">
			<c:choose>
			<c:when test="${weatherDay.fiveDayForecastValue == 1}">
				<h3>Today</h3>
			</c:when>
			<c:otherwise>
				<h5>${days[dayOfWeek-1]}</h5>
			</c:otherwise>
			</c:choose>
			<c:url var="weatherPhoto" value="/img/weather/${weatherDay.forecast}.png"/>
			<img src="${weatherPhoto}" alt="Weather Forecast Photo"/>
			<div id="highLow">
			<c:choose>
				<c:when test="${sessionScope.temp == '1'}">
					<table>
						<tr>
							<td>Low ${weatherDay.lowC} °C</td>
						</tr>
						<tr>
							<td>High ${weatherDay.highC} °C</td>
						</tr>
					</table>
				</c:when>
				<c:otherwise>
					<table>
						<tr>
							<td>Low ${weatherDay.lowF} °F</td>
						</tr>
						<tr>
							<td>High ${weatherDay.highF} °F</td>
						</tr>
					</table>
				</c:otherwise>
			</c:choose>
			</div>
				<c:if test="${weatherDay.fiveDayForecastValue == 1}">
				<ul id="weatherTips">
					<li>Tips: </li>
					<c:choose>
						<c:when test="${weatherDay.forecast=='rain'}">
							<li>Pack rain gear and wear waterproof shoes</li>
						</c:when>
						<c:when test="${weatherDay.forecast=='sun'}">
							<li>Pack sun screen</li>
						</c:when>
						<c:when test="${weatherDay.forecast=='thunderstorm'}">
							<li>Seek shelter and avoid hiking on exposed ridges</li>
						</c:when>
						<c:when test="${weatherDay.forecast=='snow'}">
							<li>Pack snowshoes</li>
						</c:when>
						<c:otherwise>
							<li>${weatherDay.forecast}</li>
						</c:otherwise>			
					</c:choose>
					<c:if test="${weatherDay.isLessThanTwenty()}">
						<li>Make sure to cover all exposed skin</li>
					</c:if>
					<c:if test="${weatherDay.isGreaterThanSeventyFive()}">
						<li>Bring an extra gallon of water</li>
					</c:if>
					<c:if test="${weatherDay.isDifferenceGreaterThanTwenty()}">
						<li>Wear breathable layers</li>
					</c:if>
				</ul>
				</c:if>
			</div>
			</c:forEach>
		</div>	
	</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />