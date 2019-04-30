<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/common/header.jsp"/>


<h1 id="rank">PARK RANKINGS:</h1>
<c:forEach var="park" items="${park}">
<div class="rank-text">
<h2 id="rank-name">${park.parkName}</h2>
<h3>Votes: ${park.parkCount}</h3>
</div>
<img class="park-img" src="img/parks/${park.parkCode.toLowerCase()}.jpg" alt="Park Images">
</c:forEach>




<c:import url="/WEB-INF/common/footer.jsp"/>
</html>