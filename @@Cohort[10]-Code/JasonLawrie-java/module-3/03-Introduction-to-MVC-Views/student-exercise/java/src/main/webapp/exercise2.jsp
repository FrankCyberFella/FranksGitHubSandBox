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
			<c:set var="num1" value="0"/>
			<c:set var="num2" value="1"/>
			<%-- Apparently we don't print the seed numbers?
			<li>${num1}</li>
			<li>${num2}</li>
			 --%>
			<c:forEach begin="1" end="25" step="1" var="num">
				<c:set var="num3" value="${num1+num2}"/>
				<li>${num3}</li>
				<c:set var="num1" value="${num2}"/>
				<c:set var="num2" value="${num3}"/>
			</c:forEach>
		</ul>
	</body>
</html>