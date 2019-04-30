<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Quote Generator</title>
    <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
    <div id="ron"><img src="https://parade.com/wp-content/uploads/2013/10/tv-show-best-boss-ron-swanson.jpg" alt="Ron Swanson"/></div>
    <div class="quote-list">
        <h1 id="title"></h1>
        <div id="show-quote">
            <!-- add quote here -->
        </div>
    </div>

    <a id="toggleQuote" onclick='displayAPI()' class="btn">
        Get Swanson Word of Wisdom
    </a>

    <div id="size-button">
     <select id="size-selection">
        <option value="small">Small</option>
        <option value="medium" selected="selected">Medium</option>
        <option value="large">Large</option>
      </select>
    </div>  

    <script src="js/getRandomQuotes.js"></script>
    <script src="js/quotes.js"></script>
</body>
</html>