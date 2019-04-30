<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Hello Spring MVC</title>
<c:url var="stylesheetHref" value="/css/flybynight.css" />
</head>
<body style="background-color: orange">
	<h1>Shopping Cart Exercise</h1>

	<ul id="ViewCart">
		<li><a href="#">View Cart</a></li>
	</ul>

	<h2>Shopping Cart Contents</h2>
	<div class="product tableeee"
		style="font-size: 200%;">
		<table>
			<tr class="border">
				<td style="border: 1px solid black"><strong>Product</strong></td>
				<td style="border: 1px solid black"><strong>Price Per Item</strong></td>
				<td style="border: 1px solid black"><strong>Quantity</strong></td>
				<td style="border: 1px solid black"><strong>Total Cost</strong></td>
			</tr>

			<c:if test="${s.bellPepperQuantity > 0}">
				<tr style="border: 1px solid black">
					<td style="border: 1px solid black">Bell Pepper</td>
					<td style="border: 1px solid black">$${s.bellPepperPrice}</td>
					<td style="border: 1px solid black">${s.bellPepperQuantity}</td>
					<td style="border: 1px solid black">$${s.bellPepperTotal}</td>
				</tr>
			</c:if>
			<c:if test="${s.carrotQuantity > 0}">
				<tr style="border: 1px solid black">
					<td style="border: 1px solid black">Carrot</td>
					<td style="border: 1px solid black">$${s.carrotPrice}</td>
					<td style="border: 1px solid black">${s.carrotQuantity}</td>
					<td style="border: 1px solid black">$${s.carrotTotal}</td>
				</tr>
			</c:if>
			<c:if test="${s.cucumberQuantity > 0}">
				<tr>
					<td style="border: 1px solid black">Cucumber</td>
					<td style="border: 1px solid black">$${s.cucumberPrice}</td>
					<td style="border: 1px solid black">${s.cucumberQuantity}</td>
					<td style="border: 1px solid black">$${s.cucumberTotal}</td>
				</tr>
			</c:if>
			<c:if test="${s.tomatoQuantity > 0}">
				<tr style="border: 1px solid black">
					<td style="border: 1px solid black">Tomatoe</td>
					<td style="border: 1px solid black">$${s.tomatoPrice}</td>
					<td style="border: 1px solid black">${s.tomatoQuantity}</td>
					<td style="border: 1px solid black">$${s.tomatoTotal}</td>
				</tr>
			</c:if>
			<c:if test="${s.radishQuantity > 0}">
				<tr style="border: 1px solid black">
					<td style="border: 1px solid black">Radii</td>
					<td style="border: 1px solid black">$${s.radishPrice}</td>
					<td style="border: 1px solid black">${s.radishQuantity}</td>
					<td style="border: 1px solid black">$${s.radishTotal}</td>
				</tr>
			</c:if>
			<tr style="border: 1px solid black">
				<td style="border: 1px solid black"></td>
				<td style="border: 1px solid black"></td>
				<td style="border: 1px solid black"><strong>Total:</strong></td>
				<td style="border: 1px solid black">$${s.totalTotal}</td>
		</table>

	</div>
	<h1>We promise we tried to style it Craig</h1>

</body>
</html>