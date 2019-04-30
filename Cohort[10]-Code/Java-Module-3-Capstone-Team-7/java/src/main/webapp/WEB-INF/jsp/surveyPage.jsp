<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Hello Spring MVC</title>
	<c:url var="stylesheetHref" value="/css/surveyPage.css" />
  <link rel="stylesheet" href="${stylesheetHref}">
</head>
<body>
	<h1>National Park Geek</h1>
	<a href="homePage"><p>Home</p></a>
	<h2>Complete a Survey for Your Favorite Park!</h2>

	<section id="main-content">
		<c:url value="/favParks" var="surveyPage" />
		<form:form action="${surveyPage}" method="POST" modelAttribute="Survey">
			<div>
				<label for="parkCode">Choose a Park</label> 
				<form:select path="parkCode" class="form-control">
					<c:forEach var="parks" items="${park}">
						<option value="${parks.parkCode}">${parks.parkName}</option>
					</c:forEach>
				</form:select>
			</div>
			<div>
				<label for="emailAddress">Enter your email address</label> 
				<form:input path="emailAddress" class="form-control" placeholder="Email Address" /> 
			</div>
			<div>
			<label for="state">Please select your state of residence</label>
				<form:select path="state"> 
				<option value="">Select State</option>
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
				</div>
				<div>
				<label for="activityLevel">Please select your activity level</label>
				<form:select path="activityLevel"> 
				<option value="">Select Activity Level</option>
				<option value="Inactive">Inactive</option>
				<option value="Sedentary">Sedentary</option>
				<option value="Active">Active</option>
				<option value="Extremely Active">Extremely Active</option>
				</form:select>
				</div>
				
			<div>
				<form:input path="" type="submit" value="Submit your survey" />
			</div>
		</form:form>
	</section>









	</form>