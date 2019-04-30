<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<c:set var="pageTitle" value="Home Page"/>
<%@include file="common/header.jspf" %>

<h2>New User</h2>

<c:url value="/newUser" var="userInput" />
<form:form action="${userInput}" method="POST" modelAttribute="registration">

	<div>
		<label for="firstName">First Name:</label>
		<form:input path="firstName" class="form-control"
			value="${SignUp.firstName}" />
		<form:errors path="firstName" cssClass="error" />
	</div>
	<div>
		<label for="lastName">Last Name:</label>
		<form:input path="lastName" class="form-control"
			value="${SignUp.lastName}" />
		<form:errors path="lastName" cssClass="error" />
	</div>
	<div>
		<label for="email">Email:</label>
		<form:input path="email" class="form-control" value="${SignUp.email}" />
		<form:errors path="email" cssClass="error" />
	</div>
	<div>
		<label for="confirmEmail">Confirm Email:</label>
		<form:input path="confirmEmail" class="form-control" />
		<form:errors path="confirmEmail" cssClass="error" />
		<form:errors path="emailMatching" cssClass="error" />
	</div>
	<div>
		<label for="password">Password:</label>
		<form:input path="password" class="form-control" value="${SignUp.password}" />
		<form:errors path="password" cssClass="error" />
	</div>
	<div>
		<label for="passwordConfirm">Confirm Password:</label>
		<form:input path="passwordConfirm" class="form-control" />
		<form:errors path="passwordConfirm" cssClass="error" />
		<form:errors path="passwordMatching" cssClass="error" />
	</div>
	<div>
		<label for="date">Birthday (mm/dd/yyyy):</label>
		<form:input path="date" class="form-control" value="${SignUp.date}"/>
		<form:errors path="date" cssClass="error" />
	</div>
	<div>
		<label for="ticket"># of Tickets</label>
		<form:input path="ticket" class="form-control" />
		<form:errors path="ticket" cssClass="error" />
	</div>

	<input type="submit" value="submit" />
</form:form>



<%@include file="common/footer.jspf" %>
