<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 

<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="detailBodyH">
<c:out value="Enter Your Cookout Details:"/>
</div>
<div class="smSpacerBlock"></div>

<c:url var="updateCookoutDetailUrl" value="/updateCookoutDetails" />
<form:form action="${updateCookoutDetailUrl}" method="POST" modelAttribute="cookout">
<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />


		<div>
			<label for="cookoutName">Event Name:</label><br> 
			<form:input type="text" path="cookoutName" id="cookoutName" size="45" placeholder="Event Name" value="${cookout.cookoutName}" required="required" />
			<form:errors path="cookoutName"></form:errors>
			
		</div>
		
		<div><br>
			<label for="cookoutDate">Event Date:</label><br>
		  	<form:input type="date" path="cookoutDate" id="cookoutDate" min="${currentDate}" required="required" />
		  	<form:errors path="cookoutDate"></form:errors>
		</div> 
		<div><br>
		  <label for="startTime">Start Time:</label><br>
			<form:input type="time" id="startTime" path="startTime" min="1:00" max="23:59" required="required" />
			<form:errors path="startTime"></form:errors>
		</div><br>
		  <label for="endTime">End Time:</label><br>
			<form:input type="time" id="endTime" path="endTime" min="1:00" max="23:59" required="required" />	
			<form:errors path="endTime"></form:errors>		
		<div><br>
			<label for="description">Description:</label> <br>
			<form:textarea path="description" id="description" cols="45" rows ="4" placeholder="Description" required="required"></form:textarea>		
			<form:errors path="description"></form:errors>		
		</div>
		<div><br>
			<label for="street">Street Address:</label><br>
			 <form:input type="text" path="street" id="street" size="45" placeholder="Street Address" pattern="\d+[ ](?:[A-Za-z0-9.-]+[ ]?)+(?:Avenue|Lane|Road|Boulevard|Drive|Street|Ave|Dr|Rd|Blvd|Ln|St|avenue|lane|road|boulevard|drive|street|ave|dr|rd|blvd|ln|st)\.?" 
			 			 required="required" title="Enter a valid street address, ie: 123 State St" /> 
			 <form:errors path="street"></form:errors> 
		</div>
		<div><br>
			<label for="city">City:</label> <br>
			<form:input type="text" path="city" id="city" size="45" placeholder="City" pattern="(?:[A-Z][a-z.-]+[ ]?)+" required="required" title="Enter a valid city name" />
			<form:errors path="city"></form:errors> 
		</div><br>
			<label for="state">State:</label> <br>
			<form:select
				path="state" id="state">
				<option value="Alabama">Alabama</option>
				<option value="Alaksa">Alaska</option>
				<option value="Arizona">Arizona</option>
				<option value="Arkansas">Arkansas</option>
				<option value="California">California</option>
				<option value="Colorado">Colorado</option>
				<option value="Connecticut">Connecticut</option>
				<option value="Delaware">Delaware</option>
				<option value="Florida">Florida</option>
				<option value="Georgia">Georgia</option>
				<option value="Hawaii">Hawaii</option>
				<option value="Idaho">Idaho</option>
				<option value="Illinois">Illinois</option>
				<option value="Indiana">Indiana</option>
				<option value="Iowa">Iowa</option>
				<option value="Kansas">Kansas</option>
				<option value="Kentucky">Kentucky</option>
				<option value="Louisiana">Louisiana</option>
				<option value="Maine">Maine</option>
				<option value="Massachutsetts">Massachutsetts</option>
				<option value="Michigan">Michigan</option>
				<option value="Minnesota">Minnesota</option>
				<option value="Mississipi">Mississipi</option>
				<option value="Missouri">Missouri</option>
				<option value="Montana">Montana</option>
				<option value="Nebraska">Nebraska</option>
				<option value="Nevada">Nevada</option>
				<option value="New Hampshire">New Hampshire</option>
				<option value="New Jersey">New Jersey</option>
				<option value="New York">New York</option>
				<option value="North Carolina">North Carolina</option>
				<option value="North Dakota">North Dakota</option>
				<option value="Ohio">Ohio</option>
				<option value="Oklahoma">Oklahoma</option>
				<option value="Oregon">Oregon</option>
				<option value="Pennsylvania">Pennsylvania</option>
				<option value="Rhode Island">Rhode Island</option>
				<option value="South Carolina">South Carolina</option>
				<option value="South Dakota">South Dakota</option>
				<option value="Tennessee">Tennessee</option>
				<option value="Teaxs">Texas</option>
				<option value="Utah">Utah</option>
				<option value="Vermont">Vermont</option>
				<option value="Virginia">Virginia</option>
				<option value="Washington">Washington</option>
				<option value="West Virginia">West Virginia</option>
				<option value="Wisconsin">Wisconsin</option>
				<option value="Wyoming">Wyoming</option>
			</form:select>
			<form:errors path="state"></form:errors> 
		<div><br>
			<label for="zip">Zip:</label> <br>
			<form:input type="text"
				path="zip" id="zip" size="45" placeholder="Zip" pattern="[0-9]{5}" required="required" title="Enter a 5 digit zip code"/>
			<form:errors path="zip"></form:errors> 	
		</div>		
		<div><br>
			<button type="submit" class="btn btn-warning">SUBMIT UPDATE</button>	
		</div>

</form:form>




<c:import url="/WEB-INF/jsp/footer.jsp" />