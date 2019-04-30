<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

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
            <li><a href="productList">List Layout</a></li>
            <li><a href="productTile">Tile Layout</a></li>
            <li><a href="productTable">Table Layout</a></li>
        </ul>
        
    </nav>
    <section id="main-content">
    <h3>Toy Department</h3>
    <div id="content">
    	<c:forEach var="product" items="${productList}">
    		<div class = product>
    		<!-- Image -->
    		<img href src="img/"${productList}">
    		<h4>${product.name}</h4>
    		<p class="manufacturer">by ${product.manufacturer}</p>
    		<p class="price">$ ${product.price}</p>
    		<p class="weight">Weight ${product.weightInLbs} lbs</p>
    		<div class="rating">
    		<img src="img/${Math.round(product.averageRating)}-star.png"/>
    		</div>
    	</c:forEach>
    </div>
        
    </nav>
    <section id="main-content">

       

    </section>
</body>
</html>