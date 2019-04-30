<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Customers List"/>

<%@include file="common/header.jspf"%>
<c:url var="formAction" value="/customerList" />
<form method="GET" action="${formAction}">
	<div>
		<label for="nameSelector">Search for a customer by name:</label> 
		<input type="text" name="name" id="nameSelector" />
	</div>
	<div>
		<label for="sortSelector">Sort By: </label> 
		<select name="sort" id="sortSelector">
			<option value="last_name">Last Name</option>
			<option value="email">Email</option>
			<option value="activebool">Active</option>
		</select>
	</div>
	<input type="submit" value="Search"/>
</form>
<table class="table">
<tr>
    <th class="customer"><span>First Name</span> <span>Last Name</span><span>Email</span><span>Active</span></th>
</tr>
<c:forEach items="${customers}" var="customer">
<tr>
    <td  class="customer"><span class="custRow">${customer.firstName}</span><span class="custRow">${customer.lastName}</span><span class="custRow">${customer.email}</span><span class="custRow">${customer.active}</span></td>
</tr>
</c:forEach>
</table>
<%@include file="common/footer.jspf"%>