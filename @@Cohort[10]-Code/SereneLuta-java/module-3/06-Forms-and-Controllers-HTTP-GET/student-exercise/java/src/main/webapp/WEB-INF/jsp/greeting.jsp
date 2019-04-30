<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="common/header.jspf"%>

		<h1>Hello, <c:out value="${param.name}" />!</h1>
		
<c:import url="/WEB-INF/jsp/common/footer.jspf" />