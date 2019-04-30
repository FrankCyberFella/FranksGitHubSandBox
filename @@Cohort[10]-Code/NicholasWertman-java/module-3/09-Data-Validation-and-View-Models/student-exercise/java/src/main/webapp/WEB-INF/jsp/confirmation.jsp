<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="confirmation"/>
<%@include file="common/header.jspf" %>

<h2>Confirmation</h2>

<c:out value="You have successfully logged in"/>

<%@include file="common/footer.jspf" %>