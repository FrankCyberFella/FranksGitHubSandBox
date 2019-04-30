<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<!--  
<head>
    <meta name="viewport" content="width=device-width" />
    <title>Product Tiles View</title>
    <link rel="stylesheet" href="css/site.css" />
</head>
<body>
    <header>
        <h1>MVC Exercises - Views Part 2: Models</h1>        
    </header>
    <nav>
        <ul>
            <li><a href="#">Link 1</a></li>
            <li><a href="#">Link 2</a></li>
        </ul>
        
    </nav>
    -->
    
     <c:import url="/WEB-INF/jsp/header.jsp"/>
    
    <section id="main-content">
    
    <h1>Toy Department</h1>
		<div class="tile-view">
		<c:forEach var="name" items="${productList}"><!-- calling productList from ProductController -->
			<div class="tile-item">
			<img id="toy" src="img/${name.imageName}"><!-- pulls all the toy images -->
				<div class = "product-details">
			<p>${name.name} <c:if test="${name.topSeller == true}">--Best Seller</c:if></p>
			<p>by ${name.manufacturer}</p><!-- prints the name variable from the manufacturer object -->
			<p>$${name.price}</p><!-- prints the value of the price with $; everything after the first $ is printed -->
			<p>Weight ${Math.round(name.weightInLbs)} lbs</p><!-- rounds the product weight up to the nearest whole number -->
			<img id="star" src="img/${Math.round(name.averageRating)}-star.png"><!-- pulls images of the stars for rating and rounds up to the nearest whole number -->
				</div>
			</div>
		</c:forEach>
		</div>
       

    </section>
</body>
</html>