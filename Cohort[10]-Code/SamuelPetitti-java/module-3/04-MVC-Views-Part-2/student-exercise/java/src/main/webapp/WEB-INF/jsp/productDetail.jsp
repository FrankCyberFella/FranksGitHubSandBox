<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<c:import url = "/WEB-INF/jsp/header.jsp"/>


<c:set var = "id" value ="${param.productId}"/>

<section id="main-content">
<h1>Product Detail</h1>
<div id = "detail-grid">

<div id = "detail-img-grid">
<img id = "detail-img" src= "img/${product.imageName}"></img>
</div>

<div id = "detail-info">

<h3 id = "detail-name"> ${product.name}</h3>
<div id = "detail-mfr">by ${product.manufacturer}</div>
<img id = "detail-rating" src="img/${Math.round(product.averageRating)}-star.png"/>
<div id = "detail-price">$${product.price}</div>
<div id = "detail-weight"><b>Weight: </b> ${product.weightInLbs}</div>
<div id = "detail-description"><b>Description: </b>${product.description}</div>

</div>

</div>

</section>



</body>
</html>