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
			<c:set var="previousValue" value="1" />
			<c:set var="nextValue" value="1"/>
			<c:forEach begin="1" end="25">
				<li> ${nextValue} </li>
			<c:set var = "holdingValue" value = "${previousValue + nextValue}"/>
			<c:set var = "previousValue"  value = "${nextValue}"/>
			<c:set var = "nextValue" 	 value = "${holdingValue}"/>
			 
			<%--
				Add a list item (i.e. <li>) for each of the first 25 numbers in the Fibonacci sequence
				
				See exercise2-fibonacci.png for example output
			 --%>
			</c:forEach>
		</ul>
	</body>
</html>