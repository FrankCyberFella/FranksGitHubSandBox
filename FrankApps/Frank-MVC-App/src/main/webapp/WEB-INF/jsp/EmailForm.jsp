<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<c:url var="EmailSendingServlet" value="/EmailSendingServlet" />
<form action="${EmailSendingServlet}" method="POST">
	<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
	
	<div class="text-center">
	<span class="detailNameCenter"><c:out value="Email Invitations To Your Guests:"></c:out></span>
</div>  <br>  

	
	<c:forEach var="invitedAttendees" items="${emails}">
		<ul>
			<li>${invitedAttendees.firstName} ${invitedAttendees.lastName}</li>
		</ul>
	</c:forEach>
	
	<c:forEach var="attendeeDetails" items="${emails}">
		<table width="35%" align="center">

			<tr>
				<td><input type="hidden" name="recipient" size="50" value="${attendeeDetails.email}" /></td>
			</tr>
	</c:forEach>

			<tr>
				<td><input type="hidden" name="subject" size="50" value="You've Been Invited!"></td>
			</tr>
			
			<tr>
				<td><input type="hidden" rows="6" cols="47" name="content" value="Hi, you've been invited to a cookout! Click the link below to view more details and create a grill order."></td>
			</tr>
					
			<tr>
				<td><input type="hidden" name="link" value="https://afternoon-mountain-76928.herokuapp.com/details?cookoutId=${cookoutId}" size="50"></td>
			</tr>




		</table>

			<tr>
				<td colspan="2" align="center"><input class="btn btn-warning"
					type="submit" value="SEND INVITE" /></td> 
			</tr>
		</form>
  <br> 

<c:import url="/WEB-INF/jsp/footer.jsp" />