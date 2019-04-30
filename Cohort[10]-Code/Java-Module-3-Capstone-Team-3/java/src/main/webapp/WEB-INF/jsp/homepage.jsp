<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<c:forEach var="park" items="${parks}">
	<div class="park">
	<c:url var="parkImage" value="/img/parks/${park.parkCode}.jpg"/>
	<c:url var="parkDetails" value="/parkDetails?theCode=${park.parkCode}"/>
	
	<a href="${parkDetails}"><img src="${parkImage}" alt="park Image"/></a>
	<div class="parkInfo">
		<a class="nameAnchor" href="${parkDetails}"><h4>${park.parkName}</h4></a>
		<h6 class="state">${park.state}</h6>
		<p class="description">${park.parkDescription}</p>
	</div>
	</div>
</c:forEach>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />