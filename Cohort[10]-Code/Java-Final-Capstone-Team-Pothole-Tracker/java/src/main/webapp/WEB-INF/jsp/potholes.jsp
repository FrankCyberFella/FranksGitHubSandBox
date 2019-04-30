<%@ include file = "common/header.jspf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var="repairedpotholes" value="/repairedpotholes" />
<a href="repairedpotholes">Click here to view repaired potholes!</a>

<div id="severity-ranking">
<h4>Severity Ranking:</h4>
<h5>5 - Most Severe: Can cause detrimental damage to vehicle</h5>
<h5>4 - Extremely Severe: Can cause serious damage to vehicle</h5>
<h5>3 - Severe: Can cause moderate damage to vehicle</h5>
<h5>2 - Slightly Severe: Can cause some damage to vehicle</h5>
<h5>1 - Least Severe: Not likely to cause damage to vehicle</h5>


</div>
<div id="pothole_main">
	<c:forEach var="depression" items="${inspectedReported}"> 
	<div id="pothole_div">
	<div id="pothole_text">
	<h5>Location: ${depression.location} </h5>
	<h5>Size: ${depression.size}</h5>
	<h5>Date Reported: ${depression.dateReported} </h5>
	<h5>Repair Status: ${depression.repairStatus}</h5>
	<h5>Severity: ${depression.severity}</h5>
	</div>

	
	</div>
	</c:forEach>
	 
</div>


<%@ include file = "common/footer.jspf" %>