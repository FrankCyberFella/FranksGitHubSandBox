<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>

<section id="form-container">
	<c:url var="actorList" value="/actorList"/>
	<form:form method="POST" action="${actorList}" modelAttribute="ActorSearch">
		<label for="name">Enter actor's last name: </label>
		<form:input  path="name"  class="form-control"/>
        <form:errors path="name"  cssClass="error"/>
		<input class="formSubmitButton" type="submit" value="Search" />
	</form:form>
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