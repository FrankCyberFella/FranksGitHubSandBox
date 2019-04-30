<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<div id="spaceForumOutput">
<li id="link"><a href="spaceForumInput">Write a Post</a></li>
<c:forEach var="post" items="${posts}">
	<table>
		<tr>
		<td>${post.subject}</td>
		</tr>
		<tr>
		<td>by ${post.username} on ${post.datePosted}</td>
		</tr>
		<p></p>
		<tr>
		<td>${post.message}</td>
		</tr>
	</table>
</c:forEach>

</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>