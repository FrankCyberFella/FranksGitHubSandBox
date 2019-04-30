<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <c:import url="/WEB-INF/jsp/common/header.jsp" />
   
          <section id="resultSection">
   			<c:url var ="planetImage" value = "/img/${param.planet.toLowerCase()}.jpg"/>
  			<img id="resultImg" src = "${planetImage}" alt="${param.planet}"/>
   
  			<p id="resultP"> If you are ${param.earthWeight} lbs on Earth, then you would weigh ${alienWeight} on ${param.planet} .</p>
   
   
   
   
   
  	 	  </section>
   



<c:import url="/WEB-INF/jsp/common/footer.jsp" />