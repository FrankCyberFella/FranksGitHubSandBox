<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<ul>
	<li></li>
</ul>
<h1>Share how amazing this book is</h1>
<form action="forumPostInput" method="POST">
	<div class="Username">
		<label for="Username">Username: </label> <input type="text"
			name="username" id="username" placeholder="  Enter a real Username" />
	</div>
	<div class="rating">
		<label for="rating">Rating: </label> <select name="rating">
			<option value="1">1 Star</option>
			<option value="2">2 Stars</option>
			<option value="3">3 Stars</option>
			<option value="4">4 Stars</option>
			<option value="5">5 Starts</option>
		</select>
	</div>
	<div class="reviewTitle">
		<label for="reviewTitle">Review Title: </label> <input type="text"
			name="reviewTitle" id="reviewTitle"
			placeholder="Enter a review title" />
	</div>
	<div class="reviewText">
		<label for="reviewText">Review Text: </label> <input type="text"
			name="reviewText" id="reviewText" placeholder="  e.g. My confidence in Squirrel cigar parties..." />
	</div>
	<label for="submitButton"> </label> <input type="submit" value="Submit" />
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />