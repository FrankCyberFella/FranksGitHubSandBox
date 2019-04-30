<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section id="main-content">
	<h1>Alien Age Calculator</h1>
	<c:url var="formAgeAction" value="/alienAgeResult" />
	<form method="GET" action="${formAgeAction}">
		<!-- On submit run the mortgageCalculatorResult.jsp -->
		<div class="ageFormInputGroup">
			<label for="planet">Choose A Planet:</label> <select
				name="planet" id="planet">
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
			<div class="ageFormInputGroup">
				<label for="earthAge">Enter Your Earth Age:</label> <input
					type="text" name="earthAge" id="earthAge" />
				<!-- name="" will appear in URL -->
			</div>
			<input class="ageFormSubmitButton" type="submit"
				value="Calculate Age" />
	</form>

</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />