<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/site.css" />

</head>
<body>

<section id="main-content-detail">
     
      	<div id="productDetail">

    		
				
				<div id="imageDetail">
					<img src="img/${product.imageName}">
				</div>
					<ul id="listDetail">
						<li id="nameDetail">${product.name}</li>
						<li id="manufacturerDetail">by ${product.manufacturer}</li>
						<li id="starsDetail"><img src="img/${Math.round(product.averageRating)}-star.png"></li>
						<li id="priceDetail">$${product.price}</li>
						<li id="weightDetail">Weight ${product.weightInLbs} lbs</li>
						<li id="description">Description: ${product.description}</li>
					</ul>
		
			
		</div>

    </section>



</body>
</html>