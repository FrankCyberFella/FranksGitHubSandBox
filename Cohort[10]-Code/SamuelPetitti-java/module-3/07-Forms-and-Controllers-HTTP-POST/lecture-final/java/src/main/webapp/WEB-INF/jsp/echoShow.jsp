<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach begin= "0" end= "${echo.startingFontSize}" var= "num">
	<li style= "font-size:${echo.startingFontSize-num}px; list-style: none" >${echo.word}</li>
</c:forEach>
	<ul style= "list-style: none;">
	<li ><a href="echoHome">Echo Home</a></li>
	</ul>
</body>
</html>