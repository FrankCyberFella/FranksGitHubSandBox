<%@ include file = "common/header.jspf" %>
<div id="home_main">

<h1 id="home_header">Welcome to Pothole Tracker!</h1>
<div id="button_div">
<c:url var="craterURL" value="/potholes"/>
<a id="home_button" href="${craterURL}">VIEW POTHOLES</a>
</div>

</div>

<%@ include file = "common/footer.jspf" %>