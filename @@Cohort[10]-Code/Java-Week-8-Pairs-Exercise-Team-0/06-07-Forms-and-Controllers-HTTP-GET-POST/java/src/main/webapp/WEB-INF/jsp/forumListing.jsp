<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">

	<h2>Solar System Geek Forum</h2>

		<div>
		<c:forEach items="${posts}" var= "post"> 
			<div>
				<c:out value="${post.username}" />
			</div>
			<div>
				<c:out value="${post.subject}" />
			</div>
			<div>
				<c:out value="${post.datePosted}" />
			</div>
			<div>
				<c:out value="${post.message}" />
			</div>
					
		</c:forEach>
		</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />