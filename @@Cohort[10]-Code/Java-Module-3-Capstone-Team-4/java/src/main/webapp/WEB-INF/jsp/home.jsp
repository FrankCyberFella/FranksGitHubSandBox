<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<c:import url="/WEB-INF/jsp/common/header.jsp">
	    <c:param name="pageTitle" value="Campground Reservation Home Page" />
	</c:import>
<div id="welcomeMsg">
	Welcome to Our Campground Reservation System
</div>

<div id="chooser">
	<c:url var="parkListURL" value="/parkList" />
	<a href="${parkListURL}">List Parks</a>
</div>
<div id="park-info">

	<c:forEach items="${parks}" var="park">
		<div class="flexy">
			<img src="img/parks/${park.parkCode.toLowerCase()}.jpg">
			<div class="inline">
				<h3 class="info-link">
					<a href="parkInfo?parkcode=${park.parkCode}">${park.parkName}</a>
				</h3>
				<p><b>${park.state}</b></p>
				<p>${park.description}</p>
			</div>
		</div>
	</c:forEach>

</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
