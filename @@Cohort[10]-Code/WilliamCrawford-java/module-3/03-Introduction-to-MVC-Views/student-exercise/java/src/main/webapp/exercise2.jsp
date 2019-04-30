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
		<c:set var="fibNum"/>
		<c:set var="current" value="1" />
		<c:set var="previous" value="0"/>
		<c:forEach begin="1" end="25">
			<c:set var="fibNum" value="${previous+current}"></c:set>
			<li>${fibNum}</li>
			<c:set var="previous" value="${current}"/>
			<c:set var="current" value="${fibNum}"/>
		</c:forEach>
		
			
					
			
			<%--
				Add a list item (i.e. <li>) for each of the first 25 numbers in the Fibonacci sequence
				
				See exercise2-fibonacci.png for example output
			 --%>
		</ul>
	</body>
</html>