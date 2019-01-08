<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<span class="detailName"><c:out value="Your Upcoming Cookouts"/></span>
<div class="spacerBlock"></div><br>


<c:forEach var="userCookouts" items="${userCookouts}">

	<c:url var="cookoutDetailUrl"
		value="/details?cookoutId=${userCookouts.cookoutId}" />
	<a href="${cookoutDetailUrl}" class="detailBodyH"> <c:out
			value="${userCookouts.cookoutName}" /></a>
	<br>
	<span class="detailBody"> <c:out
			value="${userCookouts.formattedCookoutDate}" />
	</span>
	<br>
	<br>
</c:forEach>

<c:import url="/WEB-INF/jsp/footer.jsp" />