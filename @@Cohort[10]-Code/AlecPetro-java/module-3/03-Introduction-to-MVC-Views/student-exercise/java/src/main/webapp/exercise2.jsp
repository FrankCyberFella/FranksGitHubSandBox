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
			 <c:set var="f1" value="0" />
			 <c:set var="f2" value="1" />
			 <c:set var="holding" value=""/>
			 <c:set var="print" value=""/>
			
			 <c:forEach begin="1" end="25" var="num">
			 <c:set var="print" value="${f1 + f2}"/>
			 <c:set var="holding" value="${f1 + f2}"/>
			 <c:set var="f1" value="${f2}"/>
			 <c:set var="f2" value="${holding}"/>
			 
			 <li>${print}</li>
			 </c:forEach>
			 
			 
			 
		</ul>
	</body>
</html>