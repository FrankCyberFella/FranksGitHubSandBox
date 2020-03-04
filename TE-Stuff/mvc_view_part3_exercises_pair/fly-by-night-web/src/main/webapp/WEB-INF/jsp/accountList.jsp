<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
  <title>Fly By Night Bank</title>
  <link rel="stylesheet" href="site.css">
</head>
<body>
  <header>
    <img src="img/flybynightlogo.png" alt="Fly By Night Bank">
    <p class="motto">At Fly By Night, we treat your money as if it's our own.</p>
  </header>
  <nav>
    <ul>
      <c:url var="homeHref" value="/" />
      <li><a href="${homeHref}">Home</a></li>
      <li><a href="#">Log In or Enroll</a></li>
      <li><a href="#">Why Fly By Night</a></li>
      <c:url var="accountList" value="/accountList" />
      <li><a href="${accountList}">Bank Account List</a></li>
    </ul>
  </nav>
	<section id="main-content">
		
		<p>Display a list of all accounts here. Use the request scoped variable <code>accounts</code>.</p>
	</section>
	
	<footer>
        Fly By Night Bank | Varying Locations | josh@flybynightbank.com
    </footer>
	
</body>
</html>