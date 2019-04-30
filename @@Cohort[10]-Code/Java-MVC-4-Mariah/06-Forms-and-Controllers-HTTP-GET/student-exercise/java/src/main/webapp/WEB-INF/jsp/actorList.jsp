<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>
<!-- Form goes here -->
<c:url var="targetURL" value="/actorListPath" />   <!-- Which URL path to go to on submit  -->
<form method="GET" action="${targetURL}">           <!-- Issue a GET request with action= URL on submit -->

<input type="submit" name="mySubmitButton" value="Click Here to Submit"> 
</form>
<table class="table">
<tr>
<th>Name</th>
</tr>
<c:forEach items="${actors}" var="actor">
<tr>
    <!-- What do we print here for each actor? -->
</tr>
</c:forEach>
</table>
<%@include file="common/footer.jspf"%>