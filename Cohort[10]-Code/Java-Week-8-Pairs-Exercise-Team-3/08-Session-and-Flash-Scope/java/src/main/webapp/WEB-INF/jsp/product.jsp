<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${param.name}</title>
</head>
<body>
	<div>
		<h1>${param.name}</h1>
		<div> 
			<img src="${seedDisplay.getImgLoc()}">
		</div>
		<div>
			${seedDisplay.getPrice()}
		</div>
		<form method="POST" action="product">
			<input type="hidden" name="productName" value="${param.name}">
			<input type="number" name="quantity" value="1">
			<input type="submit">
	
		</form>
		<c:url var="url" value="/"/>
		<div><a href="${url}"><c:out value="<<<Return To Catalog"></c:out></a></div>
	</div>
	
 
</body>
</html>