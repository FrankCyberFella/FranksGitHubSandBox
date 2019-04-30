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
			<c:when test="${empty param.word}">
				<c:set var="word" value="Hello" />
			</c:when>
			<c:otherwise>
				<c:set var="word" value="${param.word}" />
			</c:otherwise>
		</c:choose>
		
		 <c:choose>
			<c:when test="${empty param.count}">
				<c:set var="count" value="25" />
			</c:when>
			<c:otherwise>
				<c:set var="count" value="${param.count}" />
			</c:otherwise>
		</c:choose>
		
		 
		 <c:forEach begin="0" end="${count}" var="num">
		  
		 	<li style = "font-size:${count - num}px">${word}</li>
		 
		</c:forEach>
		</ul>
		
	</body>
</html>