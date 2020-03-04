<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>Page Title</title>
    <link rel="stylesheet" href="site.css" />
</head>
<body>
    <header>
        <h1>Movie Listing</h1>
    </header>
    <nav>
        <ul>
        		<c:url var="movieListHref" value="/movieList" />
            <li><a href="${movieListHref}">Movie List</a></li>
            <li><a href="${movieListHref}">Nav Link 2</a></li>
            <li><a href="${movieListHref}">Nav Link 3</a></li>
            <li><a href="${movieListHref}">Nav Link 4</a></li>
        </ul>

    </nav>
    <section id="main-content">
        <p>List of movies goes here. Use the request scoped variable <code>movies</code></p>
    </section>
</body>
</html>
