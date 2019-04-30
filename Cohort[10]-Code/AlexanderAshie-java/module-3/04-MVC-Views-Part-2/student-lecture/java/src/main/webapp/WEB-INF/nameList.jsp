<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Name List Example</title>
	</head>
	<body>
		<ol>
			<!--  requestScope.whatever - retrieve an entry in the request map -->
			<!--  identifies the scope in which you want to search -->
			<!--  . indicates retrieve a value from the request map or request attr -->
			<!-- whatever indicates the key for the entry -->
			<c:forEach var="name" items="${requestScope.nameList}">
				<li>${name}</li>
			</c:forEach>
		</ol>
	</body>
</html>