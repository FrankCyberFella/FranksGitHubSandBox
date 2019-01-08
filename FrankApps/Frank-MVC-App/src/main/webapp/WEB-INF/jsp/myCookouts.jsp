<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<c:out value="Greetings ${currentUser.username}!"/>

<c:forEach var="userCookouts" items="${userCookouts}">
				<li> ${userCookouts.cookoutName}</li>
			</c:forEach>

<c:import url="/WEB-INF/jsp/footer.jsp" />