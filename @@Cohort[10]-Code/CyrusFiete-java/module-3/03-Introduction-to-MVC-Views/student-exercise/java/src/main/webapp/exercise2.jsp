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
			<c:set var="toPrint" value="0"/>
			 <c:set var="newNum" value="1"/>
			 <c:set var="hold" value="0"/>
		<ul>
			<%--
				Add a list item (i.e. <li>) for each of the first 25 numbers in the Fibonacci sequence
				
				See exercise2-fibonacci.png for example output
			 --%>
			 <c:forEach begin="1" end="25" var="numbers">
			 <li>
			 	${toPrint}
			 </li>
			 	<c:set var="toPrint" value="${newNum}"/>
			 	<c:set var="newNum" value="${hold + newNum}"/>
			 	<c:set var="hold" value="${toPrint}"/>
			 </c:forEach>
		</ul>
	</body>
</html>