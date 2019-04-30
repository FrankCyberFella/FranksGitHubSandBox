<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<h1>Greeting</h1>
		<h1><c:out value="${introduction}" /></h1><!-- use EL expression to retrieve value from requestMap with key=greeting -->
	</body>
</html>