<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">

	<h2>
		Traveling by
 		<c:out value="${trans}" />
		you will reach
		<c:out value="${planet}" />
		in 
		<c:out value="${travelYears}" />
		years. You will be
		<c:out value="${finalAgeValue}" />
		years old.
	</h2>

</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />