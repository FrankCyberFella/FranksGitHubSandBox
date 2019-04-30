<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

   <c:import url="/WEB-INF/jsp/common/header.jsp" />
   
   <section id="main-content">
   <h2>Solar System Geek Forum</h2>
			<form action="spaceForumInput" method="POST">
				<div class="formGroup">
					<label for="username">Username: </label>
					<input type="text" name="username" id="username" />
				</div>
				<div class="formGroup">
					<label for="subject">Subject: </label>
					<input type="text" name="subject" id="subject" />
				</div>	
				<div class="formGroup">		
					<label for="message">Message: </label>
					<textarea name="message" id="message" rows="10" cols="30"></textarea>
				</div>	
				<div class="formGroup">
					<input type="submit" value="Post" />
				</div>		
			</form>
   
   
   
   </section>
   

<c:import url="/WEB-INF/jsp/common/footer.jsp" />