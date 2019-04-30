<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section id="main-content">
	<h3 style="text-align: center;">Solar System Geek Forum</h3>
	<c:url var="url" value="/postSpaceForum" />
	<h3 style="text-align: center">
		<a href="${url}">Post A Message</a>
	</h3>
		<div id="forum-table">
			<c:forEach var="spacePosts" items="${postsKey}">
				<p>${spacePosts.subject}<br>by ${spacePosts.username} on
					${spacePosts.datePosted} <br>${spacePosts.message}</p>
			</c:forEach>
		</div>
</section>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />