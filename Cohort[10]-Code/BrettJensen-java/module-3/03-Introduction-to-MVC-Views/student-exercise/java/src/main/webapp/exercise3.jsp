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
		<c:set var="fontSize" value="${count}"/>
		<c:forEach begin="1" end="${count}">
			<li style="font-size: ${fontSize}px">
				${word}
			</li>
			<c:set var="fontSize" value="${fontSize-1}"/>
		</c:forEach>
		</ul>
		
	</body>
</html>