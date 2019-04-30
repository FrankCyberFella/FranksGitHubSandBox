<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    

    <c:import url="/WEB-INF/jsp/common/header.jsp" />
    
    <c:set var= "parkCode" value= "${param.parkCode}">
    </c:set>
<img id="parkDetailImage" class="parkImages" src="img/parks/${park.parkCode.toLowerCase()}.jpg" alt="Park Image"/>    
<p id="parkDetailQuote"><i>"${park.inspirationalQuote}"</i></p>
<h1 id="parkNameDetail">${park.parkName}</h1>
<ul id="parkDetailList">
<li>Park Code: ${park.parkCode}</li>
<li>The park is located in ${park.state}</li>
<li>${park.acreage} acres</li>
<li>Elevation in feet: ${park.elevationInFeet} ft</li>
<li>Trail miles: ${park.milesOfTrail} miles</li>
<li>Number of campsites: ${park.numberOfCampsites}</li>
<li>The park has a ${park.climate} climate</li>
<li>The park was founded in ${park.yearFounded}</li>
<li>Annual visitors: ${park.annualVisitorCount}</li>
<li>Entry fee: $${park.entryFee}</li>
<li>Number of animal species: ${park.numberOfAnimalSpecies}</li>
</ul>


<p id="parkDetailDescription">${park.parkDescription}</p>



<h1>5 Day forecast for ${park.parkName}</h1>
 <!-- CELCIUS/FAHRENHEIT -->
 <form action= "${parkInfo}" method= "POST">
		<div id= "tempSelect">
			<div>Select Fahrenheit or Celcius</div>
			<input name = "tempChoice" type="submit" value= "F" id= "Fahrenheit" />
			<input name = "tempChoice" type="submit" value = "C" id= "Celcius"/>
	   </div>
</form>

<div class = "weatherRow">
<c:forEach var = "dayWeather" items ="${weather}" >
<div class="weatherPanel">
<img class= "weatherImage" src="img/weather/${dayWeather.forecast}.png" alt= "Weather Image"/>

<div class= "weatherText">
<h5>Day: ${dayWeather.fiveDayForecastValue}</h5>
<div><c:choose>
	<c:when test="${tempChoice == 'C'}">
		low: ${dayWeather.lowCelcius}&deg;C
		</c:when>
		<c:when test="${tempChoice == 'F'}">
		low: ${dayWeather.low}&deg;F
		</c:when>
</c:choose>	
</div>

<div>
<c:choose>
	<c:when test="${tempChoice == 'C'}">
		high: ${dayWeather.highCelcius}&deg;C
	</c:when>
		<c:when test="${tempChoice == 'F'}">
		high: ${dayWeather.high}&deg;F
		</c:when>
</c:choose>		
</div>
<!-- WEATHER MESSAGE-->
<div class = "weatherMessage"><i>
<c:choose>
	<c:when test="${dayWeather.forecast == 'snow'}">
		Pack snowshoes 
	</c:when>
	<c:when test="${dayWeather.forecast == 'rain'}">
		Pack rain gear and wear waterproof shoes
	</c:when>
	<c:when test="${dayWeather.forecast == 'thunderstorms'}">
		Seek shelter and avoid hiking on exposed ridges
	</c:when>
	<c:when test="${dayWeather.forecast == 'sunny'}">
		Pack sun block 
	</c:when>
</c:choose>
<c:choose>
	<c:when test="${dayWeather.high > 75}">
		Bring an extra gallon of water
	</c:when>
	<c:when test="${dayWeather.high - dayWeather.low > 20}">
	    Wear breathable layers.
	</c:when>
	<c:when test="${dayWeather.low < 20}">
	    Be careful of exposing skin to cold temperatures
	</c:when>
</c:choose>
</i></div>
</div>
</div> <!-- weatherPanel -->
</c:forEach>

</div> <!-- weatherRow -->
 









<%-- <div id="weatherContainer">
<c:forEach var = "dayWeather" items ="${weather}" >
<div class="weatherImageContainer">
<img id="weatherImage" class= "weatherImage" src="img/weather/${dayWeather.forecast}.png" alt= "Weather Image"/>
</div>
<div class="weatherTextContainer">
<ul>
<li>Day: ${dayWeather.fiveDayForecastValue}</li>
<li><c:choose>
	<c:when test="${tempChoice == 'C'}">
		low: ${dayWeather.lowCelcius}&deg;C
		</c:when>
		<c:when test="${tempChoice == 'F'}">
		low: ${dayWeather.low}&deg;F
		</c:when>
</c:choose>	
</li>

<li>
<c:choose>
	<c:when test="${tempChoice == 'C'}">
		high: ${dayWeather.highCelcius}&deg;C
	</c:when>
		<c:when test="${tempChoice == 'F'}">
		high: ${dayWeather.high}&deg;F
		</c:when>
</c:choose>		
</li>
<!-- WEATHER MESSAGE-->
<li class = "weatherMessage"><i>
<c:choose>
	<c:when test="${dayWeather.forecast == 'snow'}">
		Pack snowshoes 
	</c:when>
	<c:when test="${dayWeather.forecast == 'rain'}">
		Pack rain gear and wear waterproof shoes
	</c:when>
	<c:when test="${dayWeather.forecast == 'thunderstorms'}">
		Seek shelter and avoid hiking on exposed ridges
	</c:when>
	<c:when test="${dayWeather.forecast == 'sunny'}">
		Pack sun block 
	</c:when>
</c:choose>
<c:choose>
	<c:when test="${dayWeather.high > 75}">
		Bring an extra gallon of water
	</c:when>
	<c:when test="${dayWeather.high - dayWeather.low > 20}">
	    Wear breathable layers.
	</c:when>
	<c:when test="${dayWeather.low < 20}">
	    Be careful of exposing skin to cold temperatures
	</c:when>
</c:choose>
</i></li>
</ul>
</div>
</c:forEach>
</div>
 --%>





	
	
	
	
 <c:import url="/WEB-INF/jsp/common/footer.jsp" />
    