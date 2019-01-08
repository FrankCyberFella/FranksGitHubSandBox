<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />


<c:url var="submitGuestUrl" value="/addAttendees" />
<form action="${submitGuestUrl}" method="POST">
	<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
	<span class="detailName"><c:out value="Enter Guest Information to Add Attendee"></c:out></span>
	<div class="row">
	<div class="col-sm-6 offset-sm-3"><br>
	<c:forEach var="attendeeDetails" items="addAttendees">
	<div class="form-group">
		<label for="email">Email Address: </label>
		<input type="text" id="email" name="email" placeHolder="Email" class="form-control" required="required"/>
	</div>
	<div class="form-group">
		<label for="firstName">First Name: </label>
		<input type="text" id="firstName" name="firstName" placeHolder="First Name" class="form-control" required="required"/>
	</div>
	<div class="form-group">
		<label for="lastName">Last Name: </label>
		<input type="text" id="lastName" name="lastName" placeHolder="Last Name" class="form-control" required="required"/>
	</div>
	</c:forEach>

		<div>

			<input class="btn btn-danger" type="submit" value="ADD GUEST TO LIST">		

		</div>	
	<br>
	<div>
		<c:url var="detailsPage" value="/details?cookoutId=${cookoutId}" />
		<a href="${detailsPage}"><button type="button"
				class="btn btn-warning">GO TO COOKOUT DETAILS</button></a>		
	</div>
	
	</div>
	
</form>

<div class="col-sm-6 offset-sm-1">
<h3 class="detailBodySubhead">Invited Guests</h3>
<ul class="guests">
	<c:forEach var="cookoutAttendee" items="${attendees}">
		<li>${cookoutAttendee.firstName} ${cookoutAttendee.lastName}</li>
	</c:forEach>
</ul>

	<div>
		<c:url var="emailForm" value="/EmailForm" />
		<a href="${emailForm}"><button type="button" class="btn btn-warning">EMAIL INVITES</button></a>
	</div>
</div>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />