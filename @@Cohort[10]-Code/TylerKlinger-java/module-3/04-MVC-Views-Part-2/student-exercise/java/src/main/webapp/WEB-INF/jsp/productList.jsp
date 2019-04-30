<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- creates "c" as the initializer for the JSTL statement -->

<!-- <!DOCTYPE html>

<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>Product List View</title>
    <link rel="stylesheet" href="css/site.css" />
</head>
<body>
    <header>
        <h1>MVC Exercises - Views Part 2: Models</h1>        
    </header>
    <nav>
        <ul>
            <li><a href="student-exercise/java/src/main/webapp/WEB-INF/jsp/productTiles.jsp">Tile View</a></li>
            <li><a href="#">Table View</a></li>
        </ul>
        
    </nav>  -->
    
    <c:import url="/WEB-INF/jsp/header.jsp"/>
    
    <section id="main-content"> 
   <!-- header finish --> 
   
		<h1>Toy Department</h1>
		
		<c:forEach var="name" items="${productList}"><!-- calling productList from ProductController; target each item in product list -->
			<div class="list-item">
			<img id="toy" src="img/${name.imageName}"><!-- pulls all the toy images -->
				<div class = "list-details">
			<p>${name.name} <c:if test="${name.topSeller == true}">--Best Seller</c:if></p>
			<p>by ${name.manufacturer}</p><!-- prints the name variable from the manufacturer object -->
			<p>$${name.price}</p><!-- prints the value of the price with $; everything after the first $ is printed -->
			<p>Weight ${Math.round(name.weightInLbs)} lbs</p><!-- rounds the product weight up to the nearest whole number -->
			<img id="star" src="img/${Math.round(name.averageRating)}-star.png"><!-- pulls images of the stars for rating and rounds up to the nearest whole number -->
				</div>
			</div>
		</c:forEach>
  
    </section>
</body>
</html>