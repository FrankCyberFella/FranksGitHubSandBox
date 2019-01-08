<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="text-center">
	<span class="detailNameCenter"><c:out value="Your Invitations Have Been Sent!"></c:out></span>
</div>  <br>  
    <center>
    		<c:url var="detailsPage" value="/details?cookoutId=${cookoutId}"/>
		<a href = "${detailsPage}"><button type="button" class="btn btn-warning">RETURN TO COOKOUT PAGE</button></a>
    </center>

<c:import url="/WEB-INF/jsp/footer.jsp" />