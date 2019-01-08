<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="row">
	<div class="col-sm-6 offset-sm-3">	
		
		<span class="detailName">
			<c:out value="${cookout.cookoutName}"/><br />
		</span>
		<span class="detailBodyH">
		<c:out value="${cookout.formattedCookoutDate}"/><br />
			<c:out value="${cookout.formattedStartTime} - "/>
			<c:out value="${cookout.formattedEndTime}"/><br />
		</span>
		<span class="detailBody">
			<c:out value="${cookout.street}"/><br />
			<c:out value="${cookout.city}, ${cookout.state} ${cookout.zip}"/><br />
			<span class=""><c:out value="View directions in "/><a  target="_blank" href="https://www.google.com/maps/dir/?api=1&destination=${cookout.street}+${cookout.city}%2C${cookout.state}+${cookout.zip}
			">Google Maps <span class=""><i class="material-icons">explore</i></span></a></span><br/>
		</span>
			<div class="spacerBlock"></div>	
		<span class="detailBodySubhead">
			<c:out value="DESCRIPTION:"/><br />
		</span>
		<span class="detailBody">
			<c:out value="${cookout.description}"/><br />
		</span>
		<div class="spacerBlock"></div>
		<c:choose>
			<c:when test="${not empty currentUser}">
		<c:url var="addAttendees" value="/addAttendees"/>
		<a href="${addAttendees}"><button type="button" class="btn btn-danger">ADD ATTENDEE</button></a>
		<div class="spacerBlock"></div>	
		
				<c:url var="updateEventDetails" value="/updateCookoutDetails"/>
				<a href="${updateEventDetails}"><button type="button" class="btn btn-danger">UPDATE COOKOUT DETAILS</button></a>
			</c:when>
			<c:otherwise>
				<c:out value=""/>
			</c:otherwise>
		</c:choose>	
		
	</div>
	
	<div class="col-sm-6">
		<div class="lgSpacerBlock"></div>
		<span class="detailBodySubhead">
			<c:out value="MENU:"/><br />
		</span>	
		<ul>
			<c:forEach var="cookoutMenu" items="${menu}">
				<li> ${cookoutMenu.itemName}</li>
			</c:forEach>
		</ul>
		<div class="spacerBlock"></div>
		<c:url var="grillOrderUrl" value="/order"/>
		<a href="${grillOrderUrl}"><button type="button" class="btn btn-warning">SUBMIT GRILL ORDER</button></a>
			
				

		<div class="spacerBlock"></div>
			<c:url var="chefViewUrl" value="/chefSummary"/>
			<a href="${chefViewUrl}"><button type="button" class="btn btn-warning">VIEW ORDERS</button></a>			
		<div class="spacerBlock"></div>
		<div class="spacerBlock"></div>
		
		

	</div>
</div>

<div class="col-sm-12">
<div class="detailMinor">
<c:choose>
<c:when test="${not empty currentUser}">
	<c:out value=""/>
</c:when>
	<c:otherwise>
	<c:out value="Do you want to organize your own cookout? Click "/>
	<a href=#>here</a><c:out value=" to register for a free account!"/>
</c:otherwise>
		</c:choose>
	</div>	
</div>


<c:import url="/WEB-INF/jsp/footer.jsp" />