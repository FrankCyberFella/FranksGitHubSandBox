<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section id="main-content">
	
<h2>Alien Weight Calculator</h2>
<c:url var="formAction" value="/weightConverterResults" />
<form method="GET" action="${formAction}">

	<div>
		<label for="planetSelector">Choose a Planet</label> 
		<select name="planet" id="planetSelector">
			<option value="27.95">Sun</option>
			<option value="0.37">Mercury</option>
			<option value=".90">Venus</option>
			<option value="1.00">Earth</option>
			<option value="0.17">Moon</option>
			<option value="0.38">Mars</option>
			<option value="2.65">Jupiter</option>
			<option value="1.13">Saturn</option>
			<option value="1.09">Uranus</option>
			<option value="1.43">Neptune</option>
			<option value="0.04">Pluto</option>
		</select>
	</div>
	<div>
		<label for="weightSelector">Enter Your Earth Weight:</label> 
		<input type="text" name="weight" id="weightSelector" />
	</div>
	<input type="submit" value="Convert Weight" />
</form>


</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />