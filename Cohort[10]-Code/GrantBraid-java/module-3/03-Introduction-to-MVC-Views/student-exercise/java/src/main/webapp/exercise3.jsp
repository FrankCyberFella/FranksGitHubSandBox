<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Exercise 3 - Echo</title>
		<style>
			li {
				list-style-type: none;
			}
		</style>
	</head>
	<body>
		<h1>Exercise 3 - Echo</h1>
		
		<ul>
		<%--
			Given two query string parameters, "word" and "count":
			
			Add a number of list items equal to "count".  Each list item should contain the value passed in "word".
			
			The font size of the first list item should be equal to "count".  The font size of each subsequent list
			item should be decreased by 1.
			 
			See exercise3-echo.png for example output
		 --%>
		 <c:choose>
		 	<c:when test="${empty param.count}">
		 		<c:set var="count" value="2"/>
		 	</c:when>
		 	<c:when test="${empty param.word}">
		 		<c:set var="word" value="echo"/>
		 	</c:when>
		 	
		 	<c:otherwise>
		 		<c:set var="word" value="#{param.word}" />
		 		<c:set var="count" value="#{param.count}" />
		 	</c:otherwise>
		 	
		 	
		 </c:choose>
		 
		 <c:set var="countHolder" value="${count}" />
		 
		 <c:forEach begin = "1" end = "${count}" >
		 	
		 	
		 <li style="font-size:${countHolder}px;">${word}</li>
		 <c:set var="countHolder" value="${countHolder -1}" />
		 </c:forEach>
		 
		</ul>
		
	</body>
</html>