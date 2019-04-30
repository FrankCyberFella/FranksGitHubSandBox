<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<section id= "main-content">


<h2>Space Message Board</h2>
<p><a href= "/spaceForumInput">Post A Message</a></p>
<div class = "posts">

<c:forEach items= "${forumPost}" var= "post">
<div class = "post">
<h4>${post.subject}</h4>
<div>by ${post.username} at ${post.datePosted}</div>
<p>${post.message}</p>
</div>
</c:forEach>
</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>