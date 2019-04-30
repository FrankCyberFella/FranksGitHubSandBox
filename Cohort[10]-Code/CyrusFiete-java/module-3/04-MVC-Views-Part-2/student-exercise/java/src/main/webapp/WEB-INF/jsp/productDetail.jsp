<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp"/>

<%-- <c:set var="id" value="${param.productId}"/> --%>
 
 <section id="detail-main-content">

    <div id="description">
    <span id="productImgDetails"><img src="img/${product.imageName}"/></span>
   	 <div>
	<div id="toyNameDetails">${product.name}<c:if test="${product.topSeller == true}"><span id="bestSellerDetails">  BEST SELLER!</span></c:if></div>
	<div id="manufacturerDetails">by ${product.manufacturer}</div>
	<div><img id="starsDetails" src= "img/${Math.round(product.averageRating)}-star.png"></div>
	<p></p>
	<div id="priceDetails">Price: $${product.price} </div>
	<div id="weightLineDetails"><span id ="weightDetails">Weight </span>${Math.round(product.weightInLbs)} lbs</div>
	
	<p></p>
	
	<div id="descLineDetails"><span id="descDetails">Description: </span>${product.description} </div>
	</div>
    </div>
   
</section>
</body>
</html>