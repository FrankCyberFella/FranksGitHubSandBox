<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Customers List"/>

<%@include file="common/header.jspf"%>

<c:url var="customerSearchURL" value="/customerList" />
<form action="${customerSearchURL}" method="GET">
	<label for="search">Search: </label>
	<input type="text" id="search" name="search">
	<label for="sort">Sort by: </label>
	<select id="sort" name="sort">
		<option value="last_name">Last Name</option>
		<option value="first_name">First Name</option>
		<option value="email">Email Address</option>
		<option value="activebool">Active</option>
	</select>
	<input type="submit" value="Search">
</form>

<div>
	<h3>Results</h3>
	<table>
		<tr>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Email Address</td>
			<td>Active</td>
		</tr>
		<c:forEach var="customer" items="${customers}">
			<tr>
				<td>${customer.firstName}</td>
				<td>${customer.lastName}</td>
				<td>${customer.email}</td>
				<td>
					<c:if test="${customer.active == true}">Yes</c:if>
					<c:if test="${customer.active == false}">No</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

<%@include file="common/footer.jspf"%>