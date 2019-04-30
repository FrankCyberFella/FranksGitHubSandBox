<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


    <c:import url="/WEB-INF/jsp/common/header.jsp" />
   <section id="survey-container"> 
    <c:url value="/survey" var="surveyUrl"/>
    <form:form action="${surveyUrl}" method="POST" modelAttribute="Survey">  	
    	<div class= "parkChoice">
    		<label for="parkCode">Choose a Park</label>
    		  <form:select path= "parkCode" class= "form-control">
    			<c:forEach var= "park" items= "${parkList}">
    				<option value="${park.parkCode}">${park.parkName}</option>
    			</c:forEach>
    		</form:select>
       </div>

       <div class= "email">
       		<label for="email">Email</label>
			<form:input  path="emailAddress" />            
        	<form:errors path="emailAddress" cssClass="error"/>
       </div>
    
       <div class= "stateChoice">
       		<label for="state">Choose a State</label>
    		  <form:select path="state" class= "form-control">
    			<option value= "Alabama">Alabama</option>
				<option value= "Alaska">Alaska</option>
				<option value= "Arizona">Arizona</option>
				<option value= "Arkansas">Arkansas</option>
				<option value= "California">California</option>
				<option value= "Colorado">Colorado</option>
				<option value= "Connecticut">Connecticut</option>
				<option value= "Delaware">Delaware</option>
				<option value= "Florida">Florida</option>
				<option value= "Georgia">Georgia</option>
				<option value= "Hawaii">Hawaii</option>
				<option value= "Idaho">Idaho</option>
				<option value= "Illinois">Illinois</option>
				<option value= "Indiana">Indiana</option>
				<option value= "Iowa">Iowa </option>
				<option value= "Kansas">Kansas</option>
				<option value= "Kansas">Kansas</option>
				<option value= "Louisiana">Louisiana</option>
				<option value= "Maine">Maine</option>
				<option value= "Maryland">Maryland</option>
				<option value= "Massachusetts">Massachusetts</option>
				<option value= "Michigan">Michigan</option>
				<option value= "Minnesota">Minnesota</option>
				<option value= "Mississippi ">Mississippi </option>
				<option value= "Missouri">Missouri</option>
				<option value= "Nebraska">Nebraska</option>
				<option value= "Nevada">Nevada</option>
				<option value= "New Hampshire">New Hampshire</option>
				<option value= "New Jersey">New Jersey</option>
				<option value= "New Mexico">New Mexico</option>
				<option value= "New York">New York</option>
				<option value= "North Carolina">North Carolina</option>
				<option value= "North Dakota">North Dakota</option>
				<option value= "Ohio">Ohio</option>
				<option value= "Oklahoma">Oklahoma</option>
				<option value= "Oregon">Oregon</option>
				<option value= "Pennsylvania">Pennsylvania</option>
				<option value= "Rhode Island">Rhode Island</option>
				<option value= "South Carolina">South Carolina</option>
				<option value= "South Dakota">South Dakota</option>
				<option value= "Tennessee">Tennessee</option>
				<option value= "Texas">Texas</option>
				<option value= "Utah">Utah</option>
				<option value= "Vermont">Vermont</option>
				<option value= "Virginia">Virginia</option>
				<option value= "Washington">Washington</option>
				<option value= "West Virginia">West Virginia</option>
				<option value= "Wisconsin">Wisconsin</option>
				<option value= "Wyoming">Wyoming</option>
				</form:select>
       </div>
         
      <div class= "activityLevel">
      	<label for= "activityLevel">Activity Level</label>
      		 <form:select path="activityLevel" class= "form-control">
    			<option value= "inactive">Inactive</option>
				<option value= "sedentary">Sedentary</option>
				<option value= "active">Active</option>
				<option value= "extremelyActive">Extremely Active</option>
			</form:select>
      </div>
      
      <div class= "surveySubmit">
      	<input type="submit" value="submit"/>
      </div>
 
    </form:form>

</section>

    
       <c:import url="/WEB-INF/jsp/common/footer.jsp" />
    