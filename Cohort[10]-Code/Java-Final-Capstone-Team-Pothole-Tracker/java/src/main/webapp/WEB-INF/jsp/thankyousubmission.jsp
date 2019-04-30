<%@ include file = "common/header.jspf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="current" value="${current}"/>
<div id="thanks-submission">
<h1>THANK YOU!</h1>
<p>Thank you for reporting a pothole. With help from citizens like you, we can fix our streets and protect our cars!</p>
<br>
<p>Here's what you submitted: </p>

	<h5><b>Location:</b> ${current.location} </h5>
	<br>
	<h5><b>Size:</b> ${current.size}</h5>
	<br>
	<h5><b>Date Reported:</b> ${current.dateReported} </h5>
	<br>
	<h5><b>Repair Status:</b> ${current.repairStatus}</h5>
	
	<c:url var="index" value="/index" />
<a href="index">Click here to return to the home page!</a>
</div>
<%@ include file = "common/footer.jspf" %>