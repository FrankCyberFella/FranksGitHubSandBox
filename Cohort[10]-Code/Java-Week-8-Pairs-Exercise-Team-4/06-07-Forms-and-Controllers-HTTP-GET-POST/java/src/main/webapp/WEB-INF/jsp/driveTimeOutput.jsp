<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />
<title>Drive Time Output</title>
</head>
<section id="ageCalculator">

<div id="important-stuff"><img src="img/${driveTime.planet}.jpg">
<p class="black-text" id="to-tha-left">Traveling by ${driveTime.transport} you will reach ${driveTime.planet} in ${driveTime.travelYears} years. You will be ${driveTime.endingAge} years old.</p>


</div> 


</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />