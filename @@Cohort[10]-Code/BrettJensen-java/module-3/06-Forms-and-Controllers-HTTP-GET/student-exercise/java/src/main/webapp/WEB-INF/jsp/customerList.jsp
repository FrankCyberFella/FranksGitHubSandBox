<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Customers List"/>

<%@include file="common/header.jspf"%>

<section id="form-container">
	<c:url var="customerSearch" value="/customerSearch"/>
	<form id="customerSearch" method="GET" action="${customerSearch}">
		<div id="nameContainer">
			<label for="name">Name: </label>
			<input id="customerName" type="text" name="name">
		</div>
		<div id="sortContainer">
			<label for="sort">Sort: </label>
			<select name = "sort">
				<option value = "firstName"> First Name </option>
				<option value = "lastName"> Last Name </option>
			</select>
		</div>
		<input id="customerSubmitButton" type="submit" value="Search" />
	</form>
	<table class="table">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Active</th>
		</tr>
		<c:forEach items="${customers}" var="customer">
		<tr>
  	 		 <td>${customer.firstName} ${customer.lastName}</td>
  	 		 <td>${customer.email}</td>
  	 		 <c:choose>
  	 			 <c:when test="${customer.active}">
  	 			 	<td>yes</td>
  	 			 </c:when>
  	 			 <c:otherwise>
  	 			 	<td>no</td>
  	 			 </c:otherwise>
  	 		 </c:choose>
		</tr>
		</c:forEach>
	</table>
</section>

<%@include file="common/footer.jspf"%>