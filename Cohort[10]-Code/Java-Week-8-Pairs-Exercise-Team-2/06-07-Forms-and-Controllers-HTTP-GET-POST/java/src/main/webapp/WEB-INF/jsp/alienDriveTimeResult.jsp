<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<div id="alienDriveTimeResult">

<img id="driveTimeImage" src="img/${param.selectPlanet}.jpg">
<div> Traveling by <c:out value="${param.selectVehicle}"/> you will reach <c:out value="${param.selectPlanet}"/> in <c:out value="${years}"/> years. You will be <c:out value="${years + param.earthAge}"/> years old.</div>
<div>What's Up.</div>


</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>