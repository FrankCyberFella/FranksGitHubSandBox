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
            <li><a href="#">List</a></li>
            <li><a href="#">Table</a></li>
             <li><a href="#">Tiles</a></li>
        </ul>
        
    </nav>
    <section id="main-content">
	 <table>
            	 <tr>
            	<c:forEach var = "name" items = "${requestScope.productList}">
           
            	<td>${name.getName()}</td>
            	</c:forEach>
            </tr>
   				

    </section>
</body>
</html>