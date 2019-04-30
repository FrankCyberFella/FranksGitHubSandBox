<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Films List"/>

<%@include file="common/header.jspf"%>
<table class ="table">
<tr>
<th>Film Name</th><th>Description</th><th>Year</th><th>Length</th><th>Rating</th>
</tr>
<c:forEach items="${films}" var="film">
<tr>
  <td> ${film.title} </td> <td> ${film.description} </td> <td> ${film.releaseYear} <td> ${film.length}</td><td>${film.rating}</td>
</tr>
</c:forEach>
</table>

<%@include file="common/footer.jspf"%>