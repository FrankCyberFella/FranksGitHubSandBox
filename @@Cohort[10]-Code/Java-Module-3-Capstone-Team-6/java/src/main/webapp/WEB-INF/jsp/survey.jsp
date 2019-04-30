<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/common/header.jsp"/>
</head>
<body>

<section id="main-content"  class="centeredPanel">
<c:url value="/survey" var="surveyUrl"/>
	<form:form action="${surveyUrl}" method="POST" modelAttribute="Survey" onSubmit="mySubmit.disabled=true return true;">
	<div class="survey">
		<div>
			<label for="parkCode"> Park name</label>
				<form:select path="parkCode" class="form-control">
					<option></option>
					<c:forEach var="parks" items="${parks}">
					<option value="${parks.parkCode}">${parks.parkName}</option>
					</c:forEach>
				</form:select>
				 <form:errors path="parkCode" cssClass="error"/>
					
		 </div>
		 <div>
            <label for="emailAddress">Email </label>
            <form:input  path="emailAddress" class="form-control"/>
            <form:errors path="emailAddress" cssClass="error"/>
        </div>
        <div>
        	<label for="state">State of Residence</label>
        		<form:select path="state" class="form-control">
        			<option></option>
					<option value="AL">Alabama</option>
					<option value="AK">Alaska</option>
					<option value="AZ">Arizona</option>
					<option value="AR">Arkansas</option>
					<option value="CA">California</option>
					<option value="CO">Colorado</option>
					<option value="CT">Connecticut</option>
					<option value="DE">Delaware</option>
					<option value="DC">District Of Columbia</option>
					<option value="FL">Florida</option>
					<option value="GA">Georgia</option>
					<option value="HI">Hawaii</option>
					<option value="ID">Idaho</option>
					<option value="IL">Illinois</option>
					<option value="IN">Indiana</option>
					<option value="IA">Iowa</option>
					<option value="KS">Kansas</option>
					<option value="KY">Kentucky</option>
					<option value="LA">Louisiana</option>
					<option value="ME">Maine</option>
					<option value="MD">Maryland</option>
					<option value="MA">Massachusetts</option>
					<option value="MI">Michigan</option>
					<option value="MN">Minnesota</option>
					<option value="MS">Mississippi</option>
					<option value="MO">Missouri</option>
					<option value="MT">Montana</option>
					<option value="NE">Nebraska</option>
					<option value="NV">Nevada</option>
					<option value="NH">New Hampshire</option>
					<option value="NJ">New Jersey</option>
					<option value="NM">New Mexico</option>
					<option value="NY">New York</option>
					<option value="NC">North Carolina</option>
					<option value="ND">North Dakota</option>
					<option value="OH">Ohio</option>
					<option value="OK">Oklahoma</option>
					<option value="OR">Oregon</option>
					<option value="PA">Pennsylvania</option>
					<option value="RI">Rhode Island</option>
					<option value="SC">South Carolina</option>
					<option value="SD">South Dakota</option>
					<option value="TN">Tennessee</option>
					<option value="TX">Texas</option>
					<option value="UT">Utah</option>
					<option value="VT">Vermont</option>
					<option value="VA">Virginia</option>
					<option value="WA">Washington</option>
					<option value="WV">West Virginia</option>
					<option value="WI">Wisconsin</option>
					<option value="WY">Wyoming</option>
				</form:select>
					 <form:errors path="state" cssClass="error"/>				
        	</div>
			
			<div>
				<label for="activityLevel"> Physical activity level</label>
					<form:select path="activityLevel" class="form-control">
						<option></option>
						<option value="Inactive">Inactive</option>
						<option value="Sedentary">Sedentary</option>
						<option value="Active">Active</option>
						<option value="Extremely-Active">Extremely Active</option>
					</form:select>
						 <form:errors path="activityLevel" cssClass="error"/>
			</div>
			<div>
            	<input type="submit" name="mySubmit" value="Submit"/>
            	
       		 </div>
	</div>		
	</form:form>

</section>
</body>
<c:import url="/WEB-INF/common/footer.jsp"/>
</html>