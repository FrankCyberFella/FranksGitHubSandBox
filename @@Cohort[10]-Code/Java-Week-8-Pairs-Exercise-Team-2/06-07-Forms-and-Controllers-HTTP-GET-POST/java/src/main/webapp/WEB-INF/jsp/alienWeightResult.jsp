<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<div id="alienWeightResult">

<img id="weightImage" src="img/${param.selectPlanet}.jpg">
<div> If you are <c:out value="${param.earthWeight}"/> lbs on planet Earth, you would weigh <c:out value="${weight}"/> lbs on <c:out value="${param.selectPlanet}"/>.</div>
<div>What's Up.</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp"/>