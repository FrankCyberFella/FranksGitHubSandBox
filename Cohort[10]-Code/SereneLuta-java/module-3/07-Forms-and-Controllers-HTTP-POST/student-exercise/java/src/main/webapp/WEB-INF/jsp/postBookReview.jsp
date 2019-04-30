<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/css/style.css" rel="stylesheet">
<title>Post Your Review!</title>
</head>
<body id="post-page">
<section id="main-content">
	<h1 style="text-align: center;">New Book Review</h1>
	<c:url var="forumPostAction" value="/postBookReview" />
	<form method="POST" action="${formPostAction}" id="book-form">
		<!-- On submit run the mortgageCalculatorResult.jsp -->
		<div class="reviewFormInputGroup">
			<label for="username">Username:</label> 
				<input type="text" name="userName" id="username"/>
				<br>
			<label for="rating">Rating:</label>
				<input type="radio" name="rating" value="5" checked> 5-Stars
				<input type="radio" name="rating" value="4"> 4-Stars
				<input type="radio" name="rating" value="3"> 3-Stars
				<input type="radio" name="rating" value="2"> 2-Stars
				<input type="radio" name="rating" value="1"> 1-Star<br>
			<label for="title">Title:</label> 
				<input type="text" name="title" id="title"/>
				<br>
			<label for="text">Review:</label> 
				<textarea form="book-form" name="text" id="text">
				</textarea>
<!-- 				<input type="text" name="text" id="text" />
 -->			</div>
			<input class="postFormSubmitButton" type="submit"
				value="Submit Review" />
	</form>


</section>
</body>
</html>