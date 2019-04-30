<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<div id="alienAgeResult">

<img id="ageImage" src="img/${param.selectPlanet}.jpg">
<div> If you are <c:out value="${param.earthAge}"/> years old on planet Earth, then you are <c:out value="${age}"/> <c:out value="${param.selectPlanet}"/> years old.</div>
<div>What's Up.</div>
</div>
        
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>