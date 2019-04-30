<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">
	<h2>Alien Travel Calculator</h2>


	<c:url var="formAction" value="/driveTimeOutput" />
	<form method="GET" action="${formAction}">
		
		<div class="formInputGroup">
			<label for="planetChoiceId">Choose a Planet</label> 
			<select name="planetChoiceValue" id="planetChoiceId">
				<option value="Mercury">Mercury</option>
				<option value="Mars">Mars</option>
				<option value="Venus">Venus</option>
				<option value="Earth">Earth</option>
				<option value="Saturn">Saturn</option>
				<option value="Jupiter">Jupiter</option>
				<option value="Uranus">Uranus</option>
			</select>
		</div>
		<div>
			<label for="chooseTransDrop">Choose Transportation </label> 
			<select	type="text" name="transValue" id="chooseTransDrop" />
				<option value="Walking">Walking</option>
				<option value="Car">Car</option>
				<option value="BulletTrain">Bullet Train</option>
				<option value="Boeing747">Boeing 747</option>
				<option value="Concorde">Concorde</option>
			</select>
		</div>
		<div class="formInputGroup">
			<label for="earthAgeId">Enter Your Earth Age</label> 
			<input type="text" name="earthAgeValue" id="earthAgeId" />
		</div>	
		<input class="formSubmitButton" type="submit" value="Calculate Travel Time" />
	</form>
</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
