<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<ul class="go-away">
	<li></li>
</ul>

<img src="etc/forDummies.png">

<c:forEach items="${reviews}" var="review">
	<div id="forum-display">


			<p><b>${review.title}</b>   (${review.username})</p>

	</div>
			<p>${review.dateSubmitted}</p>
			
	<div class="date">
		<c:choose>
			<c:when test="${review.rating == 1}">
				<tr><img src="etc/star.png"></tr>
			</c:when>
			<c:when test="${review.rating == 2}">
				<tr><img src="etc/star.png"><img src="etc/star.png"></tr>
			</c:when>
			<c:when test="${review.rating == 3}">
				<tr><img src="etc/star.png"><img src="etc/star.png"><img src="etc/star.png"></tr>
			</c:when>
			<c:when test="${review.rating == 4}">
				<tr><img src="etc/star.png"><img src="etc/star.png"><img src="etc/star.png"><img src="etc/star.png"></tr>
			</c:when>
			<c:when test="${review.rating == 5}">
				<tr><img src="etc/star.png"><img src="etc/star.png"><img src="etc/star.png"><img src="etc/star.png"><img src="etc/star.png"></tr>
			</c:when>
		</c:choose>
		
		<p>${review.text}</p>
		
	</div>
		

</c:forEach>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />