<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<c:import url="/WEB-INF/jsp/common/header.jsp">
	    <c:param name="pageTitle" value="Park List" />
	</c:import>
<div id="welcomeMsg">
	Check out this list of Parks
</div>
	<ul>
		<c:forEach var="park" items="${parks}"> <!-- iterate through the ModelMap called parks sent from controller -->
			<li class="parkz">${park.name}</li>
		</c:forEach>
	</ul>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />