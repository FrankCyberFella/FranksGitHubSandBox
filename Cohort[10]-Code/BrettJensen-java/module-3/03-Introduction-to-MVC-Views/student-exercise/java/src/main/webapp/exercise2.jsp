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
			<c:set var="nextValue" value="1"/>
			<c:set var="lastValue" value="1"/>
			<c:forEach begin="1" end="25">
				<li>${nextValue}</li>
				<c:set var="holdValue" value="${nextValue + lastValue}"/>
				<c:set var="lastValue" value="${nextValue}"/>
				<c:set var="nextValue" value="${holdValue}"/>
			</c:forEach>
		</ul>
	</body>
</html>