<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Customers List"/>

<%@include file="common/header.jspf"%>
	<c:url var="subTarget" value="/customerList"/>
	<form method="GET" action="${subTarget}" style="display:flex">
		<label for="custName">Name:</label>
		<input type="text" id="custName" name="custName" placeholder="ex. John">
		<label for="sortyBy">Sort By:</label>
		<select id="sortBy" name="sortBy" >
			<option value = last_name>Last Name</option>
			<option value = email>e-mail</option>
			<option value = active>Active</option>
		</select>
		<input type="submit" value="submit">
	</form>
	<table class="table">
		<tr>
			<th>Name</th>
			<th>e-mail</th>
			<th>Active</th>
			
		</tr>
		<c:forEach items="${customers}" var="customer">
			<tr>
			    <td>${customer.firstName} ${customer.lastName}</td> 
			    <td>${customer.email}</td>
			    <td>${customer.active}</td>

			</tr>
		</c:forEach>
	</table>
<%@include file="common/footer.jspf"%>