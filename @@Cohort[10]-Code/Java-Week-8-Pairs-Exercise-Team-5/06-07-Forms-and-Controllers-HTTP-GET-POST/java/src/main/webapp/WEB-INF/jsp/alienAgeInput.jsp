<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<title>Alien Age Calculator</title>
</head>
<body>


<section id = "main-content">

<h2>Alien Age Calculator</h2>


<c:url var="formAction" value="/alienAgeResult"/>
<form method="GET" action="${formAction}">
	<div> <!-- class="formInputGroup" -->
		<label for="Age">Enter Age:</label> 
		<input type="text" name="age" id="age" />
	</div>
	<div class="formInputGroup">
		<label for="Planets">Choose a planet</label> 
		<select name="planet"	id="planet">
			<option value="Mercury">Mercury</option>
			<option value="Earth">Earth</option>
			<option value="Venus">Venus</option>
			<option value="Mars">Mars</option>
			<option value="Jupiter">Jupiter</option>
			<option value="Saturn">Saturn</option>
			<option value="Uranus">Uranus</option>
			<option value="Neptune">Neptune</option>
		</select>
	</div>
	
	<div class="formInputGroup">
	</div>
	<input class="formSubmitButton" type="submit" value="Calculate Age" />

</form> 
</section>
</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>