<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Campground Reservation Home Page" />
</c:import>

<div id="welcomeMsg">Best Campground</div>

<ol>
	<c:forEach items="${parks}" var="eachPark">
		<li class="black-text">${eachPark.parkName}:
			${eachPark.numOfSurvey}</li>
	</c:forEach>
</ol>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
