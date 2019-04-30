<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Name List Example</title>
	</head>
	<body>
		<ol>
							<!-- EL (Expression Language) expression, used when you want data from a variable -->
							<!-- requestScope.whatever - retrieve an entry in the request map
							requestScope Identifies the scope in which you want to search 
							the . indicates you want a value from the request map associated with the scope
							whatever is the key for the entry you want in the map-->
			<c:forEach var="name" items="${requestScope.nameList}">
									<!-- use quotes around an EL when it's being assigned to something.-->
				<li>${name}</li>
			</c:forEach>
		</ol>
	</body>
</html>