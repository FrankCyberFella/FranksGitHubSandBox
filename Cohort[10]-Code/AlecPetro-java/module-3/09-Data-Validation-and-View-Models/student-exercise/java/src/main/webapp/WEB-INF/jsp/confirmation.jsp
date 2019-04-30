<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Home Page"/>
<%@include file="common/header.jspf" %>
<c:url value="/confirmation" var="confirmation" />

<h2>Confirmation</h2>
<p>You have successfully logged in.</p>

      



<%@include file="common/footer.jspf" %>
