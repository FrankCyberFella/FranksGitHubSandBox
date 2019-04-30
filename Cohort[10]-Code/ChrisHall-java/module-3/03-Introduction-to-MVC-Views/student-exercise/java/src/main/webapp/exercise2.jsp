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
			<li>0</li>
			<li>1</li>
			<c:set var="num1" value="0"/>
			<c:set var="num2" value="1"/>
			
			<c:forEach begin="2" end="25" var="number">
				<c:set var="temp" value="${num2}"/>
				<c:set var="num2" value="${num1 + num2}"/>
				<c:set var="num1" value="${temp}"/>
			 	<li>${num2}</li>
			</c:forEach>	
		</ul>
	</body>
</html>