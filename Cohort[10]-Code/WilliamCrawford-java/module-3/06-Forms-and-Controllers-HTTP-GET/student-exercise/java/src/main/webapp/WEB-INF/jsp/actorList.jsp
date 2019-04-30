<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- <c:set name="pageTitle" value="All Actors List"/>--%>

<%@include file="common/header.jspf"%>



<c:url var="formAction" value="/actorList"/>
	<form method="POST" action="${formAction}">
		<label for="name">Enter actor's last name:</label>
		<input type="text" id="theName" name="name"/>
		<input type="submit" value="submit"/>
	</form>
<!-- <table class="table">
<tr>
<th>Name</th>
</tr> -->
<ul>
<c:forEach items="${actors}" var="actor">
<li>
    ${actor.getFirstName()} ${actor.getLastName()}
</li>
</c:forEach>
</ul>
<!-- </table>  -->
<%@include file="common/footer.jspf"%>