<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />
<c:url var="updateOrdersUrl"  value="/chefSummary"/>
<form action="${updateOrdersUrl}" method="POST">
<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />

<h1 class="detailName">Order Summary </h1>
		
		<table class="table">
			<tr>
				<th>Order Name</th>
				<th>Item</th>
				<th class="text-center" >Ready</th>
				<th class="text-center" >Qty</th>
				<th class="text-center" >Done</th>
				<th>Comments</th>
			</tr>
	 <c:set var="orderAttribute"></c:set>
			<c:forEach var="orderSummaryList" items="${orderList}">
			 
			 <c:if test="${orderSummaryList.finished == 'Yes'}">
					 <c:set var="orderAttribute" value="finished"></c:set>
					</c:if>	
				<tr id ="${orderAttribute}">
					<td><c:out value = "${orderSummaryList.orderName}"/></td>
					<td><c:out value = "${orderSummaryList.itemName}"/></td>
					<td class="text-center" ><c:out value = "${orderSummaryList.finished}"/></td>
					<td class="text-center" ><c:out value = "${orderSummaryList.quantity}"/></td>
					<td><input type="checkbox" name="orderId" value="${orderSummaryList.orderId}">
					<td><c:out value = "${orderSummaryList.comments}"/></td>
				
				</tr>
			</c:forEach>
		</table>
		<input class="btn btn-warning" type="submit" value="SUBMIT ORDER UPDATES">	
		
		</form>
		
		<h1 class="detailName">Item Totals </h1>
		<table class="table">
			<tr>
				<th>Food Item</th>
				<th class="text-center" >Quantity</th>
			</tr>
			<c:forEach var="totalSummaryList" items="${orderSummary}">
				<tr>
					<td><c:out value = "${totalSummaryList.itemName}"/></td>
					<td class="text-center" ><c:out value = "${totalSummaryList.totalQuantity}"/></td>
				</tr>
			</c:forEach>
		</table>
		
			<div>
		<c:url var="detailsPage" value="/details?cookoutId=${cookoutId}" />
		<a href="${detailsPage}"><button type="button"
				class="btn btn-warning">RETURN TO COOKOUT DETAILS</button></a>		
	</div>
		
		



<c:import url="/WEB-INF/jsp/footer.jsp" />