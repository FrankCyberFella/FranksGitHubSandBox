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
            <li><a href="productTable">Table</a></li>
            <li><a href="productTile">Tile</a></li>
        </ul>
        
    </nav>
    <section id="main-content">
    <h1 id="header">Toy Department</h1>
    
      	<div id="productList">
    
    		<c:forEach var="product" items="${productList}">
    		
    			<c:url var="productImageUrl" value="/img/${product.imageName}" />
				<c:url var="productDetailUrl" value="/productDetail">
					<c:param name="productId" value="${product.productId}" />
				</c:url>
    		
				
				<div id="image">
					<a href="${productDetailUrl}"><img src="${productImageUrl}"></a>
				</div>
					<ul id="list">
						<li id="listName">${product.name}</li>
						<li id="listManufacturer">${product.manufacturer}</li>
						<li id="listPrice">$${product.price}</li>
						<li id="listWeight">Weight ${product.weightInLbs} lbs</li>
						<li id="listStars"><img src="img/${Math.round(product.averageRating)}-star.png"></li>
					</ul>
		
			</c:forEach>
			
		</div>

       

    </section>
</body>
</html>