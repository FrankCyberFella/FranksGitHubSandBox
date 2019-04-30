<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section id="main-content">
		<div style="display:flex">
			<span>
				<c:url var="imageLoc" value="/img/${param.planet.toLowerCase()}.jpg" />
				<img src="${imageLoc}">
			</span>
			<span>
				Traveling by ${param.mode} you will reach ${param.planet} in 
				<fmt:formatNumber type="number" maxFractionDigits="2" value="${years}"/> years.
				You will be <fmt:formatNumber type="number" maxFractionDigits="2" value="${years+param.earthAge}"/>
				years old!
			</span>
		</div>
		
	</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />