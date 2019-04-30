<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">

	<h2>Alien Weight Calculator</h2>

	    Alien Weight:
	<c:out value="${weightValue}"  />
	lbs.

</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />