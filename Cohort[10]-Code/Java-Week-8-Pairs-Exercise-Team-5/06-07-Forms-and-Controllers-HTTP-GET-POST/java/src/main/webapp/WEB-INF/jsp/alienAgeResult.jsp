<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section id = "main-content">
<h1>Alien Age Result</h1>

<c:url var= "planetImage" value= "/img/${param.planet.toLowerCase()}.jpg" />

<img src= "${planetImage}"/>

<div id="resultText">
<c:out value= "If you are ${param.age} years old on Earth, you are
${newPlanetAge} years old on planet ${param.planet}"/>
</div>



</section>
</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>