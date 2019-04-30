<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<c:import url="/WEB-INF/jsp/common/header.jsp">
	    <c:param name="pageTitle" value="Park List" />
	</c:import>
<div id="welcomeMsg">
	Welcome to Our Campground Reservation System
</div>
<body>

<div id="chooser">
<c:url var= "parkListURL" value="/parkList"/> 
   	<a href="${parkListURL}">List Parks</a>
</div>
<ul>
<c:forEach var="park" items= "${parks}">
<div class= "parkDiv">
<h2>${park.name}</h2>
<h5>${park.location}</h5>
<p>${park.description}</p>
<a></a>
<li><a href="#">Show Park Campgrounds</a></li>
</div>
</c:forEach>
</ul>
</body>
</html>
	
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
