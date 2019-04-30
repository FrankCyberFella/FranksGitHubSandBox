<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<h1><c:out value="${greeting}" /></h1>		<!--  use EL expression to retrieve value from the requestMap with key = greeting -->
	</body>
</html>