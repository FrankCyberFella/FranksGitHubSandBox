<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>
<!-- Form goes here -->


<section id="actorSearch">
	<a href="filmList"><p1>Search Film</p1></a>
	<c:url var="formAction" value="/actorList" />
	<form method="GET" action="${formAction}"> 
	<input type="text" name="lastName" id="textBox" placeholder="Enter Last Name Here" />
	<input type="submit" value="Search" />

	
	 </form>
	
	
</section>

<table class="table">
<tr>
<th>Name</th>
</tr>
<c:forEach items="${actors}" var="actor">
<tr>

<td>${actor.firstName} ${actor.lastName}</td>
    <!-- What do we print here for each actor? -->
</tr>
</c:forEach>
</table>
<%@include file="common/footer.jspf"%>