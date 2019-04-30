<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h3 id="favoriteMessage">Thank you for your vote!</h3>

<div id="favoriteParks">
	<h1>Favorite Parks Page</h1>
	<table id="favoritesTable" class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Surveys</th>
			</tr>
		</thead>
		<c:forEach var="survey" items="${surveys}">
			<tr>
				<td>${survey.key} </td>
				<td>${survey.value}</td>
			</tr>
		</c:forEach>
	</table>
</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />