<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <c:url var="cssUrl" value="/css/site.css"/>
    <link rel="stylesheet" href="${cssUrl}"/>
    <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
   <title>Quote Generator</title>
</head>
<body>
    <div id="ron"><img src="https://parade.com/wp-content/uploads/2013/10/tv-show-best-boss-ron-swanson.jpg" alt="Ron Swanson"/></div>
    <div class="quote-list">
        <h1 id="title">Ron Swanson Quote Generator</h1>
       
        <div id="show-quote">
				<c:choose>
					<c:when test="${param.size == 'small' }">
						<p>${small.text}</p>
					</c:when>
					<c:when test="${param.size == 'medium' }">
						<p>${medium.text}</p>
					</c:when>
					<c:when test="${param.size == 'large' }">
						<p>${large.text}</p>
					</c:when>
				</c:choose>
		</div>
    </div>
    
    <div class="quote-list">
      <h1 id="title">Get Swanson Word of Wisdom</h1>
       
	    	<c:url value="/greeting" var="greetingURL"/>
	    		<form action="${greetingURL}" method="GET">
					<div class="choice">
						<input type="submit" name="size" value="small"/>
						<input type="submit" name="size" value="medium"/>
						<input type="submit" name="size" value="large"/>
					</div>
				</form>
	</div>
	
	 <div class="quote-list">
		
		<c:url value="/greeting" var="greeting"/>
			<form:form action="${greeting}" method="POST" modelAttribute="small">
				<h1>Rate This Quote</h1>
				<div id="rating-option">
					<form:select path="sum">
						<form:option value="1">1</form:option>
						<form:option value="2">2</form:option>
						<form:option value="3">3</form:option>
						<form:option value="4">4</form:option>
						<form:option value="5">5</form:option>
					</form:select>
				</div>
			</form:form>				
		
		<div id="submit"><input type="submit" name="mySubmit" value="Submit"/></div>
	</div>
	

 
    
    
	
	

</body>
</html>