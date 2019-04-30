<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


   <c:import url="/WEB-INF/jsp/common/header.jsp" />
   
   <section id="forum-content">
   <h3 id="forum-head">Solar System Geek Forum</h3>
	<a id="forumButtonLink" href="spaceForumInput">Post a Message</a>
	<c:forEach var="post" items="${forumPosts}">
		<div class="forumPost">
			<h3>${post.subject}</h3>
			<p>${post.username} on ${post.datePosted}</p>
			<p>${post.message}</p>
		</div>
   </c:forEach>
   
   
   
   </section>
   

<c:import url="/WEB-INF/jsp/common/footer.jsp" />