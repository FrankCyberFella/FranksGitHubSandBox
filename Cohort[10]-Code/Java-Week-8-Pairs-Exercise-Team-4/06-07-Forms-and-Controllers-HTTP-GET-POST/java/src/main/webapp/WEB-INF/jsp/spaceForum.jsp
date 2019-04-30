<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section id="ageCalculator">


	<h1 id="title">SUPER COOL CUTTING Edge NEW HOT info POST</h1>
	
<form action="spaceForum" method="POST">
<div id="forumInput">
	<div id="spaceForumUser">
		<label for="UserName">Username:</label>
		<input type="text" name="username" id="username" placeholder="  enter a totally secure username ;)"/>
	</div>
	<div id="spaceForumSub">
		<label for="Subject">Subject:</label>
		<input type="text" name="subject" id="subject" placeholder="  Enter you subject matter (heh pun intended)" />
	</div>
	<div id="spaceForumMessage">
		<label for="Subject">Message:</label>
		<input type="text" name="message" id="message" placeholder="  Enter your important message" />
	</div>
	<div id="button-one">
		<label for="button"></label>
		<input class="formSubmitButton" type="submit" value="Submit" />
	</div>
</div>
</form>
<div id="forum-stuff">
	<c:forEach items="${posts}" var="post">
	<div id="forum-things">
		<p class="black-text"><b>${post.subject}</b></p>
		<p class="black-text">by ${post.username} on ${post.datePosted}</p>
		<p class="black-text">${post.subject}</p>
	</div>
	</c:forEach>
</div>

</section>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />