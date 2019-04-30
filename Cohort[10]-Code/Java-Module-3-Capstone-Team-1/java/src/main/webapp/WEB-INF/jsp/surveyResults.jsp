<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="common/header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<h2>Thank you!</h2>
	<p>Your results have been submitted. Check out the results below to see where
	   your favorite park ranks!</p>
	   
	 <h3>National Park Survey Results</h3>
	 <c:forEach var= "mappyJr" items = "${mappyResults}">
	 <div id="vote"><h4>${mappyJr.key}</h4>
	 <div><h5>${mappyJr.value} votes</h5><progress value="${mappyJr.value}" max="${county}">
</progress>
	</div>
	</div>
	</c:forEach>






	
<%@include file="common/footer.jsp"%>