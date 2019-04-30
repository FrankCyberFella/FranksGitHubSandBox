<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<div id="alienWeightInput">
<h2>Alien Weight Calculator</h2>

<c:url value="/alienWeightResult" var="formAction"/>
<form method="GET" action="${formAction}">
	<div class="formInputGroup">
		<label for="selectPlanet">Choose a Planet</label> 
		<select name="selectPlanet"	id="selectPlanet">
			<option value="sun">Sun</option>
			<option value="mercury">Mercury</option>
			<option value="venus">Venus</option>
			<option value="earth">Earth</option>
			<option value="moon">Moon</option>
			<option value="mars">Mars</option>
			<option value="jupiter">Jupiter</option>
			<option value="saturn">Saturn</option>
			<option value="uranus">Uranus</option>
			<option value="neptune">Neptune</option>
			<option value="pluto">Pluto</option>
		</select>
	</div>
	<div class="formInputGroup">
		<label for="earthWeight">Enter Your Earth Weight: </label> 
		<input type="text" name="earthWeight" id="earthWeight" />
	</div>
	<input class="formSubmitButton" type="submit" value="Calculate Weight" />
</form>
</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>