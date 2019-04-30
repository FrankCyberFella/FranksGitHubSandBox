<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Film List Results"/>

<%@include file="common/header.jspf"%>

<table class="table">
<tr>
<th>Name</th>
</tr>
<c:forEach items="${films}" var="film">
<tr>
    <td>${film.title}     ${film.description}     ${film.releaseYear}     ${film.length}     ${film.rating}</td>
</tr>
</c:forEach>
</table>

<%@include file="common/footer.jspf"%>