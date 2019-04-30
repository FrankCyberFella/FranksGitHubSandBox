<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<c:import url="/WEB-INF/jsp/common/header.jsp">
	    <c:param name="pageTitle" value="Park List" />
	</c:import>
<div id="welcomeMsg">
	Check out this list of parks!
</div>

<c:url value="/campgroundList" var="campgroundURL"/> 

<form:form action="${campgroundURL}"       <%-- action= Use this URL on submit --%> 
           method="POST"                          <%-- method= issue a POST on submit --%>
           modelAttribute="parks">               <%-- method= issue a POST on submit --%>
<ul>
<c:forEach var="parque" items="${parks}">  <!-- iterate thru the ModelMap called parks sent from controller -->

<li class="parkz">${parque.name}</li>
</c:forEach>
</ul>
</form:form>
	<c:import url="/WEB-INF/jsp/common/footer.jsp" />