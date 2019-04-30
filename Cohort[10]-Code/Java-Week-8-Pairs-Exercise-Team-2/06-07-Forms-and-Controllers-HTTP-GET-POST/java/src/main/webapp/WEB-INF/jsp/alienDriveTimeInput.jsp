<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<div id="alienDriveTimeInput">
<h2>Alien Drive Time Calculator</h2>

<c:url value="/alienDriveTimeResult" var="formAction"/>
<form method="GET" action="${formAction}">
	<div class="formInputGroup">
		<label for="selectPlanet">Choose a Planet</label> 
		<select name="selectPlanet"	id="selectPlanet">
			<option value="mercury">Mercury</option>
			<option value="venus">Venus</option>
			<option value="mars">Mars</option>
			<option value="jupiter">Jupiter</option>
			<option value="saturn">Saturn</option>
			<option value="uranus">Uranus</option>
			<option value="neptune">Neptune</option>
		</select>
	</div>
	<div class="formInputGroup">
		<label for="selectVehicle">Choose a Vehicle</label> 
		<select name="selectVehicle" id="selectVehicle">
			<option value="walking">Your Own Two Feet</option>
			<option value="car">Generic Car</option>
			<option value="bulletTrain">Bullet Train!</option>
			<option value="boeing747">Boeing (747)</option>
			<option value="concorde">Concorde?</option>
		</select>
	</div>
	<div class="formInputGroup">
		<label for="earthAge">Enter Your Earth Age: </label> 
		<input type="text" name="earthAge" id="earthAge" />
	</div>
	<input class="formSubmitButton" type="submit" value="Calculate" />
</form>
</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>