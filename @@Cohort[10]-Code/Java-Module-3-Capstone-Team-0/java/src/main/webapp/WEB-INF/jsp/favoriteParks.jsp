<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Home Page"/>
<%@include file="common/header.jspf" %>

<c:forEach var="park" items="${surveys}">
	<div class="card shadow-sm p-3 mb-5 rounded">
		<div class="favorite-park">
			<span>
				<img id="park-img" src="img/parks/${park.parkCode.toLowerCase()}.jpg"/>
			</span>
		
			
			<h3>${park.parkName}  <span class="badge badge-primary">Surveys: ${park.count}</span></h3>
			
		
			
		</div>
	</div>
	
</c:forEach>
<%@include file="common/footer.jspf" %>
