<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="All Customers List" />

<%@include file="common/header.jspf"%>
<c:url value="/customerListResults" var="formAction" />
<form method="GET" action="${formAction}">
	<label for="name">Name: </label> <input type="text" id="name"
		name="name" /> <label for="sort">Sort By:</label> 
		<select name="sort" id="sort">
		<option value="last_name">Last Name</option>
		<option value="email">Email</option>
		<option value="activebool">Active</option>
	</select> <input type="submit" value="Search" />
</form>
<table>
	<tr>
		<th><c:out value="Name" /></th>
		<th><c:out value="Email" /></th>
		<th><c:out value="Active" /></th>
	</tr>
	<c:forEach var="customer" items="${customers}">
		<tr>
			<td><c:out value="${customer.firstName} ${customer.lastName}" /></td>
			<td><c:out value="${customer.email}" /></td>
			<td><c:out value="${customer.active}" /></td>
		</tr>
	</c:forEach>
</table>
<%@include file="common/footer.jspf"%>