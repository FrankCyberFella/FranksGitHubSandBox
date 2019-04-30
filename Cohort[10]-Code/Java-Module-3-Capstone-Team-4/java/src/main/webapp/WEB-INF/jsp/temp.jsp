<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<c:import url="/WEB-INF/jsp/common/header.jsp">
	    <c:param name="pageTitle" value="Campground Reservation Home Page" />
	</c:import>
<div id="welcomeMsg">
	Welcome to Our Campground Reservation System
</div>



<c:choose>
	<c:when test="${temp == 0}">
		<h1>You're now in Fahrenheit</h1>
	</c:when>
	<c:otherwise>
		<h1>You're now in Celsius</h1>
	</c:otherwise>
</c:choose>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />
