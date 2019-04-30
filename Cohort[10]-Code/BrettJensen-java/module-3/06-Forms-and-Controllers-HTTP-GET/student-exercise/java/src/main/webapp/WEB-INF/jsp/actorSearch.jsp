<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>

<section id="main-content">
	<c:url var="actorList" value="/actorSearch"/>
	<form method="GET" action="${actorList}">
		<input id="actorSearch" type="text" name="actorName">
		<input class="formSubmitButton" type="submit" value="Search" />
	</form>
	<table class="table">
		<tr>
		<th>Name</th>
		</tr>
		<c:forEach items="${actors}" var="actor">
		<tr>
  	 	 <td>${actor}</td>
		</tr>
		</c:forEach>
	</table>
</section>

<%@include file="common/footer.jspf"%>