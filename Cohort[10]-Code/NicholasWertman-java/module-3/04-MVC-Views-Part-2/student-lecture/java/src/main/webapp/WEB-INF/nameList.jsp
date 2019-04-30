<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Name List Example</title>
	</head>
	<body>
		<ol>
			<!-- requestScope.whatever - retrieve an entry in the request map (requestAttribute) -->
			<!--  requestScope - identifies the scope in which you want to search				 -->
			<!--  .  -  indicates you want a value from the request map associated with the scope-->
			<!--  whatever - the key for the entry that you want in the map 					 -->
			<c:forEach var="name" items="${requestScope.nameList}">
				<li>${name}</li>
			</c:forEach>
		</ol>
	</body>
</html>