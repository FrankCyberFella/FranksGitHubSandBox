<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />
<title>Alien Weight Output</title>
</head>
<section id="ageCalculator">

<div id="important-stuff"><img src="img/${planet.planet}.jpg">
<p class="black-text" id="to-tha-left">If you are ${planet.earthWeight} pounds on Earth, then you are ${planet.alienWeight} ${planet.planet} pounds.</p>


</div> 


</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />