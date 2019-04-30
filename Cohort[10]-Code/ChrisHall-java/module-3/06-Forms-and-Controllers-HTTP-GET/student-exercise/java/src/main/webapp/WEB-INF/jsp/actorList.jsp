<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="All Actors List" />

<%@include file="common/header.jspf"%>
<!-- Form goes here -->


<c:url var="formAction" value="/actorList" />
<form method="GET" action="${formAction}">
	<input type="text" id="theName" name="name" /> <input type="submit"
		value="Submit" />
</form>

<table class="table">
	<tr>
		<th>Name</th>
	</tr>
	<tr>
		<c:forEach items="${actors}" var="actor">
			<c:out value="${actor.firstName} ${actor.lastName}" />
			<br>
		</c:forEach>
	</tr>
</table>
<%@include file="common/footer.jspf"%>