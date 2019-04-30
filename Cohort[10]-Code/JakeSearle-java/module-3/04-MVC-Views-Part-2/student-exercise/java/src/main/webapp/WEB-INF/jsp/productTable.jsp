<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<meta name="viewport" content="width=device-width" />
<title>Product Table View</title>
<link rel="stylesheet" href="css/site.css" />
</head>
<body>
	<header>
		<h1>MVC Exercises - Views Part 2: Models</h1>
	</header>
	<nav> 
		<ul>
			<li><a href="productList">List</a></li>
			<li><a href="productTile">Tile</a></li>
		</ul>

	</nav>
	<section id="main-content">
		<h1 id="header">Toy Department</h1>

		<div id="products">

			<ul id="titles">
				<li>Name</li>
				<li>Rating</li>
				<li>Mfr</li>
				<li>Price</li>
				<li>Weight</li>
			</ul>

			<c:forEach var="product" items="${productList}">

				<c:url var="productImageUrl" value="/img/${product.imageName}" />
				<c:url var="productDetailUrl" value="/productDetail">
					<c:param name="productId" value="${product.productId}" />
				</c:url>

				<ul>
					<li id="image"><a href="${productDetailUrl}"><img
							src="${productImageUrl}"></a></li>
					<li id="name">${product.name}</li>
					<li id="stars"><img
						src="img/${Math.round(product.averageRating)}-star.png"></li>
					<li id="manufacturer">${product.manufacturer}</li>
					<li id="price">$${product.price}</li>
					<li id="weight">${product.weightInLbs}</li>

				</ul>


			</c:forEach>

		</div>



	</section>
</body>
</html>