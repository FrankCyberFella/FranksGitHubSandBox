 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section id="main-content">
	
<h2>Solar System Geek Forum</h2>

<a href="spaceForumInput">Post a Message</a>

<div class="posts">

	<c:forEach var="post" items="${posts}">

		<div class="post">
			<h3>${post.subject}</h3>
			<p>by ${post.username} on ${post.datePosted}</p>
			<br>
			<p>${post.message}</p>
		</div>
		
	</c:forEach>
	
</div>

</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />