<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <c:import url="/WEB-INF/jsp/common/header.jsp" />
   
   <section>
   <h2>Alien Age Calculator</h2>
	<c:url var="formAction" value="/alienAgeResult" />
	<form method="GET" action="${formAction}">
	<div class = "planetChoice">
	<label for ="planet" > Choose A Planet </label>
	<select name = "planet">
				<option value = "Mars"> Mars </option>
				<option value = "Jupiter"> Jupiter </option>
				<option value = "Saturn"> Saturn </option>
				<option value = "Venus"> Venus </option>
				<option value = "Uranus"> Uranus </option>
				<option value = "Neptune"> Neptune </option>
				<option value = "Mercury"> Mercury </option>
	</select>

	</div>
	<div class="formInputGroup">
		<label for="earthAge">Enter Your Earth Age: </label> 
		<input type="text" name="earthAge" id="earthAge" />
	</div>

	<input class="formSubmitButton" type="submit" value="Calculate Age" />
</form>
   
   
   
   
   </section>
   
    



<c:import url="/WEB-INF/jsp/common/footer.jsp" />
   
    

