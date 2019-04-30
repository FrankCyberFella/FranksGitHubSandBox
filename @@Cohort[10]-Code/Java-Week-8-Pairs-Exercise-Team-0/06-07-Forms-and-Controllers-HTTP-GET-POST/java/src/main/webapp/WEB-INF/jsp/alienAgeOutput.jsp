<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">

	<h2>Alien Age Calculator</h2>

	alienAge:
	<c:out value="${ageValue}" />
	years old
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />