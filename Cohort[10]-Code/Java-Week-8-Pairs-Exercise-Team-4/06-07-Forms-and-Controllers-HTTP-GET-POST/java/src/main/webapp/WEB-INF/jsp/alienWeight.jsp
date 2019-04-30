<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section id="ageCalculator">


	<h1 id="title">Alien Weight Calculator</h1>
	
	<c:url var="formAction" value="alienWeightOutput" />
	<form method="GET" action="${formAction}">
		<div id="list">
			<p id=choosePlanet>
				Choose a Planet: <select name="planet" id="weight">
					<option value="mercury">Mercury</option>
					<option value="venus">Venus</option>
					<option value="earth">Earth</option>
					<option value="mars">Mars</option>
					<option value="jupiter">Jupiter</option>
					<option value="saturn">Saturn</option>
					<option value="uranus">Uranus</option>
					<option value="neptune">Neptune</option>
					<option value="pluto">Pluto</option>
					
				</select>
			</p>
			<p id=earthAge>
				Enter your Earth weight: <input type="text" name="earthWeight"
					id="earthWeight">
			</p>

			<input class="formSubmitButton" type="submit" value="Calculate Weight" />

		</div>


	</form>
</section>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />