<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<c:import url="/WEB-INF/jsp/common/header.jsp">
	    <c:param name="pageTitle" value="Park List" />
	</c:import>
<div id="welcomeMsg">
	Check out this list of parks!
</div>

<ul>
<c:forEach var="parque" items="${parks}">  <!-- iterate thru the ModelMap called parks sent from controller -->

<li class="parkz">${parque.name}</li>
</c:forEach>
</ul>
	
	<c:import url="/WEB-INF/jsp/common/footer.jsp" />