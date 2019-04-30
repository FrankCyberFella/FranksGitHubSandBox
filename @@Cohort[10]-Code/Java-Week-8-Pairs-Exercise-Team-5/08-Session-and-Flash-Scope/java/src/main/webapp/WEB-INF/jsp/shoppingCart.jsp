<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShoppingCart</title>
</head>
<body>
<h2>Shopping Cart Contents</h2>
<table>
<tr>
<th>Product</th>
<th>Price Per Item</th>
<th>Quantity</th>
<th>Total Cost</th>
</tr>

<c:set var="totalPrice" value="0"></c:set>
<c:forEach var= "vegetable" items= "${vegetables}">
<tr>
<td>${vegetable.type}</td>
<td>$${vegetable.itemPrice}</td>
<td>${vegetable.quantity}</td>
<td>$${vegetable.quantity * vegetable.itemPrice}</td>
<c:set var = "totalPrice" value=  "${totalPrice + (vegetable.quantity * vegetable.itemPrice)}"/> 
<tr>
</c:forEach>
<tr>
<td>Total Price = $ <fmt:formatNumber value = "${totalPrice}" type = "currency"/></td>
</tr>
</table>

</body>
</html>