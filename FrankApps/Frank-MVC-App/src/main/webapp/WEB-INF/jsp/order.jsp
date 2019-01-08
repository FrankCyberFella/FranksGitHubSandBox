<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> --%>


<c:import url="/WEB-INF/jsp/header.jsp" />

<c:url var="submitGrillOrderUrl" value="/order" />
<form action="${submitGrillOrderUrl}" method="POST">
<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
	
	<div class="spacerBlock"></div>
	
<%-- 	<div class="detailBodyH">
<c:out value="What Do You Want From The Grill?"/>
</div>
<div class="smSpacerBlock"></div> --%>
	
<div>
	<span class="detailBodySubhead"><c:out value="Name for order:"/></span>
	<div class="spacerBlock"></div>
	<input type="text" name="orderName" id="orderName" placeholder="Name" size="45" required="required"/>

</div><br><br>
	
	<span class="detailBodySubhead"><c:out value="Let us know what you want from the grill:"/></span>
		<div class="spacerBlock"></div>
	
	<c:forEach var="grillOptions" items="${grillOptions}">
	
	  		
	  			
<!-- 			<input type="hidden" name="itemId" value="0" />  -->	

 
			<%-- <input type="checkbox" name="itemId" id="itemId" value="${grillOptions.itemId}"> <c:out value= "${grillOptions.itemName}" /> --%>
			
			<input type="hidden" name="itemId" value="${grillOptions.itemId}" />
			<label><c:out value= "${grillOptions.itemName}    " /></label>
			<input type="number" name="quantity" id="quantity" min="0" value="0" size="2" /><c:out value= " QTY" /> <br><br>
			<input type="text" name="comments" id="comments" value=" " placeholder="Additional comments?" size="45" /><br>
			<hr>
			
	</c:forEach>

		<div><br>
			<input class="btn btn-warning" type="submit" value="SUBMIT GRILL ORDER">		
		</div><br>

</form>
	<div>
		<c:url var="detailsPage" value="/details?cookoutId=${cookoutId}" />
		<a href="${detailsPage}"><button type="button"
				class="btn btn-warning">RETURN TO COOKOUT DETAILS</button></a>		
	</div><br>


<c:import url="/WEB-INF/jsp/footer.jsp" />