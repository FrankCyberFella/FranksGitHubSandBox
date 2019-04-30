<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


    <c:import url="/WEB-INF/jsp/common/header.jsp" />
   
  <%--     <c:set var= "favoriteParks" value= "${param.favoriteParks}">
    </c:set> --%>
    <h1 class="surveyResultHeader">Favorite Park Survey Results</h1>
    <div id="surveyResultsGraph">
   		<c:forEach var="park" items="${favoriteParks}">
   		<div class="progressContainer">
   			<img  class="surveyParkImages" src="img/parks/${park.parkCode.toLowerCase()}.jpg" alt="Park Image"/>    
   		    <div class="progressName">
   			${park.parkName}:
   			${park.parkVotes} votes
   			</div>
   			 <div class="progressBar">
   		     <progress value="${park.parkVotes}"
   		     max="${favoriteParks.stream().map(park -> park.parkVotes).sum()}">
   		    	</progress>
   		    	
   		    	</div>
   		    	</div>
  	</c:forEach>
  	</div>


    
       <c:import url="/WEB-INF/jsp/common/footer.jsp" />
    
</html>