<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>

<style>
	table, th, td {
		border: 1px solid black;
	}

</style>

</head>
<body>

<c:set var="totalCost" value="0"/>

<table>

<tr>
	<th style="strong">Product</th>
	<th style="strong">Price Per Item</th>
	<th style="strong">Quantity</th>
	<th style="strong">Total Cost</th>
</tr>

<c:set var="tomatoCount" value="0"/>
<c:set var="tomatoObject" value="0"/>
<c:forEach var="item" items="${shoppingCart.getList()}">
	<c:if test="${item.type.equals('tomato')}">
		<c:set var="tomatoCount" value="${tomatoCount +1}"/>
		<c:set var="tomatoObject" value="${item}"/>
	</c:if>
</c:forEach>

	<c:if test="${tomatoCount > 0}">
	<tr>
		<td>${tomatoObject.getName()}</td>
		<td>$${tomatoObject.getPrice()}</td>
		<td>${tomatoCount}</td>
		<td>$${tomatoObject.getPrice()*tomatoCount}</td>
		<c:set var="totalCost" value="${totalCost + tomatoObject.getPrice() * tomatoCount}"/>
	</tr>
	</c:if>

<c:set var="bellpepperCount" value="0"/>
<c:set var="bellpepperObject" value="0"/>
<c:forEach var="item" items="${shoppingCart.getList()}">
	<c:if test="${item.type.equals('bellpepper')}">
		<c:set var="bellpepperCount" value="${bellpepperCount +1}"/>
		<c:set var="bellpepperObject" value="${item}"/>
	</c:if>
</c:forEach>

	<c:if test="${bellpepperCount > 0}">
	<tr>
		<td>${bellpepperObject.getName()}</td>
		<td>$${bellpepperObject.getPrice()}</td>
		<td>${bellpepperCount}</td>
		<td>$${bellpepperObject.getPrice()*bellpepperCount}</td>
		<c:set var="totalCost" value="${totalCost + bellpepperObject.getPrice() * bellpepperCount} "/>
		
	</tr>
	</c:if>
	
<c:set var="carrotCount" value="0"/>
<c:set var="carrotObject" value="0"/>
<c:forEach var="item" items="${shoppingCart.getList()}">
	<c:if test="${item.type.equals('carrot')}">
		<c:set var="carrotCount" value="${carrotCount +1}"/>
		<c:set var="carrotObject" value="${item}"/>
	</c:if>
</c:forEach>

	<c:if test="${carrotCount > 0}">
	<tr>
		<td>${carrotObject.getName()}</td>
		<td>$${carrotObject.getPrice()}</td>
		<td>${carrotCount}</td>
		<td>$${carrotObject.getPrice()*carrotCount}</td>
		<c:set var="totalCost" value="${totalCost + carrotObject.getPrice() * carrotCount} "/>
	</tr>
	</c:if>

<c:set var="radishCount" value="0"/>
<c:set var="radishObject" value="0"/>
<c:forEach var="item" items="${shoppingCart.getList()}">
	<c:if test="${item.type.equals('radish')}">
		<c:set var="radishCount" value="${radishCount +1}"/>
		<c:set var="radishObject" value="${item}"/>
	</c:if>
</c:forEach>

	<c:if test="${radishCount > 0}">
	<tr>
		<td>${radishObject.getName()}</td>
		<td>$${radishObject.getPrice()}</td>
		<td>${radishCount}</td>
		<td>$${radishObject.getPrice()*radishCount}</td>
		<c:set var="totalCost" value="${totalCost + radishObject.getPrice() * radishCount} "/>
	</tr>
	</c:if>

<c:set var="cucumberCount" value="0"/>
<c:set var="cucumberObject" value="0"/>
<c:forEach var="item" items="${shoppingCart.getList()}">
	<c:if test="${item.type.equals('cucumber')}">
		<c:set var="cucumberCount" value="${cucumberCount +1}"/>
		<c:set var="cucumberObject" value="${item}"/>
	</c:if>
</c:forEach>

	<c:if test="${cucumberCount > 0}">
	<tr>
		<td>${cucumberObject.getName()}</td>
		<td>$${cucumberObject.getPrice()}</td>
		<td>${cucumberCount}</td>
		<td>$${cucumberObject.getPrice()*cucumberCount}</td>
		<c:set var="totalCost" value="${totalCost + cucumberObject.getPrice() * cucumberCount} "/>
	</tr>
	</c:if>

<tr>
	<td></td>
	<td></td>
	<td style="text-align: right">Total</td>
	<td>$${totalCost}</td>
</tr>

</table>

<c:url var="homePage" value="/home"/>
<a href="${homePage}">Return to Catalog</a>
</body>
</html>