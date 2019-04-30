<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Thank you!</h1>
	<h3>Your Cart Has Been Updated</h3>
	<div>${param.name} ${param.value}</div>
	<c:url var="url" value="/"/>
	<div><a href="${url}"><c:out value="<<<Return To Catalog"></c:out></a></div>
</body>
</html>