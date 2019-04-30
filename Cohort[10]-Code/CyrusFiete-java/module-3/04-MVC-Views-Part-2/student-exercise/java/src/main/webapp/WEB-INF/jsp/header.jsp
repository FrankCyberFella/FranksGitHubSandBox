<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <c:url value="css/site.css" var="cssURL" />
    <link rel="stylesheet" href="${cssURL}"/>
    <title>Product View</title>
</head>
<body>
    <header>
        <h1>MVC Exercises - Views Part 2: Models</h1>        
    </header>
    <nav>
        <ul>
            <li><a href="productTable">Table View</a></li>
            <li><a href="productTiles">Tile View</a></li>
            <li><a href="productList">List View</a></li>
        </ul>   
    </nav>