<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section id="main-content">
	<h1>Alien Travel Calculator</h1>
	<c:url var="formTravelAction" value="/transitTimeResult" />
	<form method="GET" action="${formTravelAction}">
		<!-- On submit run the mortgageCalculatorResult.jsp -->
		<div class="travelFormInputGroup">
			<label for="planet">Choose A Planet:</label> 
			<select name="planet" id="planet">
				<!-- name="" will appear in URL -->
				<option value="Mercury">Mercury</option>
				<option value="Venus">Venus</option>
				<option value="Earth">Earth</option>
				<option value="Mars">Mars</option>
				<option value="Jupiter">Jupiter</option>
				<option value="Saturn">Saturn</option>
				<option value="Uranus">Uranus</option>
				<option value="Neptune">Neptune</option>
			</select>
		</div>
		<div>
			<label for="mode">Choose a Mode of Transportation!</label>
			<select name="mode" id="mode">
				<!-- name="" will appear in URL -->
				<option value="Walking">Walking</option>
				<option value="Car">Car</option>
				<option value="Bullet Train">Bullet Train</option>
				<option value="Boeing 747">Boeing 747</option>
				<option value="Concorde">Concorde</option>

			</select>
		</div>
		<div class="ageFormInputGroup">
			<label for="earthAge">Enter Your Earth Age:</label> 
			<input type="text" name="earthAge" id="earthAge" />
		</div>
		<input class="travelFormSubmitButton" type="submit" value="Calculate Transit Time!" />
	</form>

</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />