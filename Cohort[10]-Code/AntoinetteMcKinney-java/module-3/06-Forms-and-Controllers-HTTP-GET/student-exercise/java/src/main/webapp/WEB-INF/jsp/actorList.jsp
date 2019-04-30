<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>
<!-- Form goes here -->
<c:url value="/greeting" var="formAction" />
		<form method="GET" action="${formAction}">
			<label for="name">Your Name: </label> <!-- label is text to appear on the page  -->
			<input type="text" id="thename" name="alex" /> <!-- define a text imput box called theName -->
			<input type="submit" value="Get Greeting" /> <!-- associate the label theName with this textBox -->
															<!-- Store any data in the variable called name
															define a submit button -->
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