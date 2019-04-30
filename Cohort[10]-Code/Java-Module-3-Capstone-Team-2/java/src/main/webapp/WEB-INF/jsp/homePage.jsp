<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   

    <c:import url="/WEB-INF/jsp/common/header.jsp" />
    
    
    <c:forEach var="park" items="${parkList}">
    	<c:url var = "url" value = "parkInfo?parkCode=${park.parkCode}"></c:url>
   		<div class="parkList">
		<h1><a href="${url}"><em> ${park.parkName} </em></a></h1>
		<div class="parkListElements">
		<h4>${park.state}</h4>
		<p>${park.parkDescription}</p>
		</div>
		<a href="${url}"><img class="parkImages" src="img/parks/${park.parkCode.toLowerCase()}.jpg" alt="Park Image"/></a>
	 </div>
    
	</c:forEach>    
	
	
	
	
	
    <c:import url="/WEB-INF/jsp/common/footer.jsp" />
    