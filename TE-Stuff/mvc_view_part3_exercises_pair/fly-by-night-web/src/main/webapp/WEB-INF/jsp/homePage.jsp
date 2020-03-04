<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>Fly By Night Bank - Home</title>
    <link rel="stylesheet" href="site.css" />
</head>
<body>
    <header>
        <img src="img/flybynightlogo.png" alt="Fly By Night Bank" />
        <p>At Fly By Night, we treat your money as if it's our own.</p>
    </header>
    <nav>
        <ul>
        		<c:url var="homeHref" value="/" />
            <li><a href="${homeHref}">Home</a></li>
            <li><a href="#">Log In or Enroll</a></li>
            <li><a href="#">Why Fly By Night</a></li>
            <c:url var="accountListHref" value="/accountList" />
            <li><a href="${accountListHref}">Bank Account List</a></li>
        </ul>
    </nav>
    <div class="container">
        <section class="account">
            <!-- image file for piggy bank -->
            <img src="img/piggybank.png" alt="Start Saving" />
            <h2>Start Saving</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis imperdiet lorem in urna accumsan, sed consequat arcu tincidunt. Duis pretium lectus ac elit pretium, ut interdum felis aliquet. Ut varius, nisi eget venenatis hendrerit, lorem neque mattis nisl, vel feugiat libero sapien sit amet purus. Duis lobortis, nisi in dignissim congue, lacus ipsum posuere diam, eget lacinia ex elit in leo. Aenean non dui sagittis, aliquam turpis a, lacinia lacus. Mauris at hendrerit odio. Fusce tristique hendrerit aliquam.</p>
            <ul>
                <li>One</li>
                <li>Two</li>
                <li>Three</li>
            </ul>
        </section>

        <section class="account">
            <img src="img/checkandpen.png" alt="Open Checking" />
            <h2 id="checking">Open Checking</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis imperdiet lorem in urna accumsan, sed consequat arcu tincidunt. Duis pretium lectus ac elit pretium, ut interdum felis aliquet. Ut varius, nisi eget venenatis hendrerit, lorem neque mattis nisl, vel feugiat libero sapien sit amet purus. Duis lobortis, nisi in dignissim congue, lacus ipsum posuere diam, eget lacinia ex elit in leo. Aenean non dui sagittis, aliquam turpis a, lacinia lacus. Mauris at hendrerit odio. Fusce tristique hendrerit aliquam.</p>
        </section>

        <section class="account">
            <img src="img/dollarsign.png" alt="Loans">
            <h2>Loans</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis imperdiet lorem in urna accumsan, sed consequat arcu tincidunt. Duis pretium lectus ac elit pretium, ut interdum felis aliquet. Ut varius, nisi eget venenatis hendrerit, lorem neque mattis nisl, vel feugiat libero sapien sit amet purus. Duis lobortis, nisi in dignissim congue, lacus ipsum posuere diam, eget lacinia ex elit in leo. Aenean non dui sagittis, aliquam turpis a, lacinia lacus. Mauris at hendrerit odio. Fusce tristique hendrerit aliquam.</p>
        </section>

    </div>
    <footer>
        Fly By Night Bank | Varying Locations | josh@flybynightbank.com
    </footer>


</body>
</html>