<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width"/>
	<title>Video City - We Still Exist!</title>
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<!-- Site CSS -->
	<link rel="stylesheet" href="css/site.css">
	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
	<!-- Bootstrap JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<c:url var="homeUrl" value="/"/>
			<a href="${homeUrl}"><img class="img-responsive" src="img/logo.jpg"></a>
	    	<div class="header">
	    		<h1>Video City</h1>
	    		<strong>We still exist!</strong>
	    	</div>
		</div>
	</div>
	<nav class="navbar navbar-default">
		<div class="container">
			<c:url var="searchUrl" value="/films"/>
			<form action="${searchUrl}" method="GET" class="navbar-form navbar-right">
				<div class="form-group">
					<input type="text" name="search" class="form-control" placeholder="Search">
				</div>
				<button id="searchButton" type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
	</nav>
	<div class="container">