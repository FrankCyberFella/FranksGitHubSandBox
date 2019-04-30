<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>
<c:url value="/searchActors" var="searchUrl"/>
<form:form action="${searchUrl}" method= "POST" modelAttribute="ActorSearch">
<label for="actor">Enter actor name:</label>	
<form:input path="actor" class= "form-control"/>
<form:errors path="actor"  cssClass="error"/>
<input type="submit" name= "searchActors" id= "searchActors" />

</form:form>
<%-- <c:url var="formAction" value="/searchActors"/>
<form method="GET" action="${formAction}">
<label for="actor">Enter actor name:</label>
<input type ="text" name ="actor" id= "actor"/>
<input type="submit" name= "searchActors" id= "searchActors" />
</form>
<!-- Form goes here -->
<table class="table">
<tr>
<th>Name</th>
</tr>
<c:forEach items="${actors}" var="actor">
<tr>
    <!-- What do we print here for each actor? -->
    <td>${actor.firstName} ${actor.lastName}</td>
</tr>
</c:forEach>
</table> --%>
<%@include file="common/footer.jspf"%>