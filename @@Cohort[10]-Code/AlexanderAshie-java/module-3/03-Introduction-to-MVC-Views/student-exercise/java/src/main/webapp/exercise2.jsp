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
			 
			 <c:set var="firstNumber" value="0"/>
			 <c:set var="secondNumber" value="1"/>
			 
			 
			 <c:forEach begin="1" end="25">
			 	
			 	<c:set var="sumOfPrevious" value="${firstNumber + secondNumber}"/>
			 
			 	<li>
			 		${sumOfPrevious}
			 	</li>
			 	
			 	<c:set var="firstNumber" value="${secondNumber}"/>
			 	<c:set var="secondNumber" value="${sumOfPrevious}"/>
			 
			 </c:forEach>
			 
		</ul>
	</body>
</html>