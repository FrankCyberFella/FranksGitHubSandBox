<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Name List Example</title>
	</head>
	<body>
		<ol>
		<!-- requestScope.whatever - retrieves an entry in the request map (request attribute), the . notation -->
		<!-- requestScope - identifies the scope in which search is desired -->
		<!--  . - indicates desired value from the request map associated with teh scope -->
		<!-- whatever is the key desired in map -->
			<c:forEach var="name" items="${requestScope.nameList}"><!-- el expression; use "" when beign assigned to attr, any word associated with = -->
				<li>${name}</li>
			</c:forEach>
		</ol>
	</body>
</html>