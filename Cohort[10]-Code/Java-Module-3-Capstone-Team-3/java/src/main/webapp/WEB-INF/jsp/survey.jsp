<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section id="main-content"  class="centeredPanel">
<c:url value="/survey" var="surveyUrl" />
<form:form id="surveyForm" action="${surveyUrl}" method="POST" modelAttribute="Survey">
		<%-- <form:errors path="*" cssClass="error"/>  puts error field at top--%>
		<h1 id="formHeading">Favorite National Park</h1>
        <div class="form-group">
        	<label for="parkCode">Park Name: </label>
        	<form:select  path="parkCode" class="form-control">
        	<form:option value="CVNP">Cuyahoga Valley National Park</form:option>
        	<form:option value="ENP">Everglades National Park</form:option>
        	<form:option value="GCNP">Grand Canyon National Park</form:option>
        	<form:option value="GNP">Glacier National Park</form:option>
        	<form:option value="GSMNP">Great Smoky Mountains National Park</form:option>
        	<form:option value="GTNP">Grand Teton National Park</form:option>
        	<form:option value="MRNP">Mount Rainier National Park</form:option>
        	<form:option value="RMNP">Rocky Mountain National Park</form:option>
        	<form:option value="YNP">Yellowstone National Park</form:option>
        	<form:option value="YNP2">Yosemite Valley National Park</form:option>
        		</form:select>
        </div>
        
        <div class="form-group">
            <label for="emailAddress">Email: </label>
			<form:input class="form-control"  path="emailAddress" />            
        	<form:errors path="emailAddress" cssClass="error"/>
        </div>


        <div class="form-group">
            <label for="state">State of Residence: </label>
            <form:select path="state" class="form-control">
				<form:option value="AL">Alabama</form:option>
				<form:option value="AK">Alaska</form:option>
				<form:option value="AZ">Arizona</form:option>
				<form:option value="AR">Arkansas</form:option>
				<form:option value="CA">California</form:option>
				<form:option value="CO">Colorado</form:option>
				<form:option value="CT">Connecticut</form:option>
				<form:option value="DE">Delaware</form:option>
				<form:option value="DC">District Of Columbia</form:option>
				<form:option value="FL">Florida</form:option>
				<form:option value="GA">Georgia</form:option>
				<form:option value="HI">Hawaii</form:option>
				<form:option value="ID">Idaho</form:option>
				<form:option value="IL">Illinois</form:option>
				<form:option value="IN">Indiana</form:option>
				<form:option value="IA">Iowa</form:option>
				<form:option value="KS">Kansas</form:option>
				<form:option value="KY">Kentucky</form:option>
				<form:option value="LA">Louisiana</form:option>
				<form:option value="ME">Maine</form:option>
				<form:option value="MD">Maryland</form:option>
				<form:option value="MA">Massachusetts</form:option>
				<form:option value="MI">Michigan</form:option>
				<form:option value="MN">Minnesota</form:option>
				<form:option value="MS">Mississippi</form:option>
				<form:option value="MO">Missouri</form:option>
				<form:option value="MT">Montana</form:option>
				<form:option value="NE">Nebraska</form:option>
				<form:option value="NV">Nevada</form:option>
				<form:option value="NH">New Hampshire</form:option>
				<form:option value="NJ">New Jersey</form:option>
				<form:option value="NM">New Mexico</form:option>
				<form:option value="NY">New York</form:option>
				<form:option value="NC">North Carolina</form:option>
				<form:option value="ND">North Dakota</form:option>
				<form:option value="OH">Ohio</form:option>
				<form:option value="OK">Oklahoma</form:option>
				<form:option value="OR">Oregon</form:option>
				<form:option value="PA">Pennsylvania</form:option>
				<form:option value="RI">Rhode Island</form:option>
				<form:option value="SC">South Carolina</form:option>
				<form:option value="SD">South Dakota</form:option>
				<form:option value="TN">Tennessee</form:option>
				<form:option value="TX">Texas</form:option>
				<form:option value="UT">Utah</form:option>
				<form:option value="VT">Vermont</form:option>
				<form:option value="VA">Virginia</form:option>
				<form:option value="WA">Washington</form:option>
				<form:option value="WV">West Virginia</form:option>
				<form:option value="WI">Wisconsin</form:option>
				<form:option value="WY">Wyoming</form:option>
			</form:select>            
        </div>
        
        <div class="form-check form-check-inline radioButtons">
            <label class="radioButton" for="activityLevel">Activity Level: </label>
            <form:radiobutton class="form-check-input radioButton" path="activityLevel"  value="inactive" checked="checked"/> 
            <label class="radioButton">Inactive</label>
            <form:radiobutton class="form-check-input radioButton" path="activityLevel"  value="sedentary" /> 
            <label class="radioButton">Sedentary</label>
            <form:radiobutton class="form-check-input radioButton" path="activityLevel"  value="active" /> 
            <label class="radioButton">Active</label>
            <form:radiobutton class="form-check-input radioButton" path="activityLevel"  value="extremely active" /> 
            <label class="radioButton"> Extremely Active </label>
            <form:errors path="activityLevel" cssClass="error"/>   
        </div>
        
        
        
        <div class="form-group">
            <input class="btn btn-primary" type="submit" value="Submit"/>   
        </div>
</form:form>
</section>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />