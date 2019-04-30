<%@ include file = "common/header.jspf" %>

<div id="pothole_table">
	<div id="pothole_div">
	<div id="pothole_text">
	
	<%-- <img src="${depression.image}"/> --%>
	<table id="potholeRepairedTable">
		<tr>
			<th>Location</th>
			<th>Size</th>
			<th>Date Reported</th>
			<th>Date Inspected</th>
			<th>Date Repaired</th>
			<th>Days To Resolution</th>
		</tr>
		<c:forEach var="depression" items="${repaired}"> 
		<tr>
			<td>${depression.location}</td>
			<td>${depression.size}</td>
			<td>${depression.dateReported}</td>
			<td>${depression.dateInspected}</td>
			<td>${depression.dateFixed}</td>
			<td>${depression.daysBetweenRepair}</td>
		</tr>
		</c:forEach>
	</table>
	</div>
	</div>

	 
</div>








<%@ include file = "common/footer.jspf" %>