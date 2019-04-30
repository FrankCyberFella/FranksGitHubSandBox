<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:import url="/WEB-INF/common/header.jsp"/>

</head>
<body>
	<div class="detail-list">
		
			<c:forEach items="${parks}" var="parks">
			<div class="detail-info">
				<c:url var="url" value="parkDetail?parkcode=${parks.parkCode}&mySubmit=${temp}"/>
					<p><a href="${url}"><img class="park-img" src="img/parks/${parks.parkCode.toLowerCase()}.jpg" alt="Park Images"></a></p>
					<div class="home-text">
						<div class="title-back">
						<span id="home-name"><a href="${url}">${parks.parkName}</a></span>
				
						<span id="state-detail"> ${parks.state}</span>
						</div>
						<span id="description">${parks.parkDescription}</span>
					</div>
			</div>
				
	
			</c:forEach>
		
	</div>
</body>
<c:import url="/WEB-INF/common/footer.jsp"/>
</html>