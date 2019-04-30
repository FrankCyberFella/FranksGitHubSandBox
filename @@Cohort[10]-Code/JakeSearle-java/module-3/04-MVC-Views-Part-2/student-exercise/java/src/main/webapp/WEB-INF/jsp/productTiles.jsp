<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
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
    <section id="main-content">
    
    
		<h1 id="tileHeader">Toy Department</h1>

		<div class="content">

			<c:forEach var="productTile" items="${product}">

				<div class="productCard">
					<img id="tileImg" src="img/${product.imageName}.jpg">
				${product.name}
				
				
				
				
				
				
				</div>
					
					
			
			
					</div>

			</c:forEach>

		</div>

       

    </section>
</body>
</html>