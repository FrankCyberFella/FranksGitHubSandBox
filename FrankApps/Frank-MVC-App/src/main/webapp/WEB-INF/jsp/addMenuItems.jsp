<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<c:url var="addMenuItemsUrl" value="/addMenuItems"/>
<form action="${addMenuItemsUrl}" method="POST">
	<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
	
<div class="detailBodyH">
<c:out value="Set Your Menu:"/>
</div>


		<c:forEach var="cookoutItemsCheck" items="${menuOptions}">
			<input type="checkbox" name="item" value="${cookoutItemsCheck.itemId}"> <span class="detailMinor"><c:out value= "${cookoutItemsCheck.itemName}" /></span> <BR>
		</c:forEach>
		
		
		<div><br>
			<input class="btn btn-warning" type="submit" value="SUBMIT MENU SELECTION">		
		</div>	
</form>		


<c:import url="/WEB-INF/jsp/footer.jsp" />
