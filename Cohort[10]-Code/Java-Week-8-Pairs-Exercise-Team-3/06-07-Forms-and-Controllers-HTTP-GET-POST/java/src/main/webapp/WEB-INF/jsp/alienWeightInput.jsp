<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section id="main-content">
	<h1>Alien Weight Calculator</h1>
	<c:url var="formWeightAction" value="/alienWeightResult" />
	<form method="GET" action="${formWeightAction}">
		<!-- On submit run the mortgageCalculatorResult.jsp -->
		<div class="weightFormInputGroup">
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
		<div class="ageFormInputGroup">
			<label for="earthWeight">Enter Your Earth Weight:</label> 
			<input type="text" name="earthWeight" id="earthWeight" />
		</div>
		<input class="weightFormSubmitButton" type="submit" value="Calculate Weight" />
	</form>

</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />