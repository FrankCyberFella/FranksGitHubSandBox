<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="common/header.jsp"%>
<div id="home"> 
	
	<c:forEach var="park" items="${parks}">
	<div id="home_sections">
		<c:url var="code" value="/parkDetail?parkCode=${park.parkCode}&degrees=${degrees}"/>
	
	
		
		<a href="${code}"><img src="img/parks/${park.parkCode.toLowerCase()}.jpg" id="home_park_img"/></a>
		<div id="home_park_info">
		<h2>${park.parkName} <div id="state">${park.state}</div></h2><br>
		
		<p>${park.parkDescription}</p>
		<br>
		<div id="home_button"><a href="${code}">LEARN MORE</a></div>
		</div>
		</div>
		<hr>
	</c:forEach>
</div>





<%@include file="common/footer.jsp"%>