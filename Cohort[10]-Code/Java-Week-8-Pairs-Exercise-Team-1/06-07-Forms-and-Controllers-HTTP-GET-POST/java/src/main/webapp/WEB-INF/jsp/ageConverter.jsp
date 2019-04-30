 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section id="main-content">
	
<h2>Alien Age Calculator</h2>
<c:url var="formAction" value="/AgeConverterResults" />
<form method="GET" action="${formAction}">

	<div>
		<label for="planetSelector">Choose a Planet</label> 
		<select name="planet" id="planetSelector">
			<option value="87.96">Mercury</option>
			<option value="224.68">Venus</option>
			<option value="686.98">Mars</option>
			<option value="11.86">Jupiter</option>
			<option value="29.46">Saturn</option>
			<option value="84.07">Uranus</option>
			<option value="164.81">Neptune</option>
			<option value="247.70">Pluto</option>
		</select>
	</div>
	<div>
		<label for="ageSelector">Enter Your Earth Age:</label> 
		<input type="text" name="age" id="ageSelector" />
	</div>
	<input type="submit" value="Convert Age" />
</form>


</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />