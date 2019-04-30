<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<section id="main-content" class="centeredPanel">
	<c:url value="/register" var="registerURL" />
	<form:form action="${registerURL}" method="POST"
		modelAttribute="register">
	</form:form>
	<div>
		<label for="email">Email: </label>
		<form:input path="email" class="form-control" />
		<form:errors path="email" cssClass="error" />

	</div>
	</section>