<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<c:import url="/WEB-INF/jsp/common/header.jsp">
	    <c:param name="pageTitle" value="Campground Reservation Home Page" />
	</c:import>
<title>List of Parks</title>

<div id="welcomeMsg"> Check out this list of parks!</div>

<ul>
	<c:forEach items="${parks}" var="park">
		<li class="black-text">${park.parkName}</li>
	</c:forEach>
</ul>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />