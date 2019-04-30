<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Campground Reservation Home Page" />
</c:import>
<div id="welcomeMsg">Welcome to Our Campground Survey System</div>
<c:url value="parkSurvey" var="surveyInput" />
<form:form action="${surveyInput}" method="POST" modelAttribute="Survey">
	<label for="parkCode">Park Name:</label> 
	<form:select path="parkCode">
		<c:forEach items="${parks}" var="park">
			<option value="${park.parkCode}">${park.parkName}</option>
		</c:forEach>
	</form:select>
	<form:errors path="parkCode" cssClass="error" /> <br> 
	
	<label for="email">Email:</label> 
	<form:input class="form-control" path="email" />
	<form:errors path="email" cssClass="error" /> <br>
	
	<label for="state">State of Residence:</label> 
	<form:select path="state">
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
	<form:errors path="state" cssClass="error" /><br>
	
	<label for="activity">Activity Level:</label>
	<form:radiobutton path="activity" value="Inactive" /> <b>Inactive</b>   
	<form:radiobutton path="activity" value="Sedentary"/> <b>Sedentary</b>   
	<form:radiobutton path="activity" value="Active"/> <b>Active</b>   
	<form:radiobutton path="activity" value="Extremely Active"/> <b>Super Active</b>   
	<form:errors path="activity" cssClass="error" /><br>
	
	<input type="submit" value="submit" />
</form:form>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />
