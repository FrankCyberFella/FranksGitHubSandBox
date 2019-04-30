<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Exercise 2 - Fibonacci 25</title>
		<style>
			li {
				list-style-type: none;
			}
		</style>
	</head>
	<body>
		<h1>Exercise 2 - Fibonacci 25</h1>
		<ul>
			<%--
				Add a list item (i.e. <li>) for each of the first 25 numbers in the Fibonacci sequence
				
				See exercise2-fibonacci.png for example output
			 --%>
			 <c:set var="returnVal" value="" />
			 <c:set var="initialVal" value="" />
			 <c:set var="holder" value="0" />
			 
			 <c:forEach begin="1" end="25">
			 
			 	<c:choose>
			 		<c:when test="${empty returnVal}">
			 			<c:set var="returnVal" value="1" />
			 			<c:set var="initialVal" value="1" />
			 		</c:when>
			 		
			 		<c:otherwise>
			 			<c:set var="holder" value="${initialVal}" />
			 			<c:set var="initialVal" value="${returnVal}" />
			 			<c:set var="returnVal" value="${returnVal + holder}" />
			 		</c:otherwise>
			 	
			 	</c:choose>
			 <li>${returnVal}</li>
			 </c:forEach>
		</ul>
	</body>
</html>