<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="common/header.jsp"/>

<c:forEach var="film" items="${films}">
<div class="col-sm-4 col-md-3 film">
	<img class="img-responsive" src="img/dvd_placeholder.png">
	<h4><c:out value="${film.title}"/></h4>
</div>
</c:forEach>

<c:import url="common/footer.jsp"/>