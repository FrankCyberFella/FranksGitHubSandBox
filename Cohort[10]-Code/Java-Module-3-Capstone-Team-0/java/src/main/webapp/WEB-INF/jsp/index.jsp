<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Home Page"/>
<%@include file="common/header.jspf" %>

<c:forEach var="park" items="${parks}">
	<div class="card shadow p-3 mb-5 rounded">
		<div class="card-body">
			<span>
				<a href="detail?parkCode=${park.parkCode}"><img id="park-img-index" src="img/parks/${park.parkCode.toLowerCase()}.jpg"/></a>
			</span>
			<span>
				<a href="detail?parkCode=${park.parkCode}"><h3 style="margin-top: 10px">${park.parkName}</h3></a>
				<p>${park.parkDescription}</p>
			</span>
		</div>
	</div>
	
</c:forEach>
<%@include file="common/footer.jspf" %>
