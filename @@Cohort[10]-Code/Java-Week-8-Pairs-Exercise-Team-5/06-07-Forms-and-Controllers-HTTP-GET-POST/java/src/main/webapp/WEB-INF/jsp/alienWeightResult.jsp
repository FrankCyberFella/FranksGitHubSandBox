<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section id = "main-content">

<c:url var= "planetImage" value= "/img/${param.planet.toLowerCase()}.jpg" />

<img src= "${planetImage}"/>

<div id="resultText">
<c:out value = "If you are ${param.weight} lbs. on planet Earth, 
your weight on planet ${param.planet} would be ${newWeight.calculateWeight()} lbs."/> 
</div>

 </section>

</body>
</html>