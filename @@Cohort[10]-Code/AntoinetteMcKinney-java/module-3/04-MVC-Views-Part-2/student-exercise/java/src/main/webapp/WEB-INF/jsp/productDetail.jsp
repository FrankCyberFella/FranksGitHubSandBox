<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var= "pageTitle" value="Detail View" />    
<%@ include file = "header.jsp" %>
<div class="">
			<img class="" id="" src="img/${product.imageName}" />
				
				<div class="" id="">
				
					<p>
						<span><c:out value="${product.name}" /></span>
					<br/>
						<span><c:out value="by ${product.manufacturer}" /></span>
					<br />
						
						<img class="" id="" src="img/${Math.round(product.averageRating)}-star.png" />
					</p>
				
					<p>
						<span>Price: </span><c:out value="$ ${product.price}" />
					<br/>
						<span><c:out value="Weight: ${product.weightInLbs}" /> lbs.</span> 
					</p>
					
					<p>
						<span class="">Description: </span> <c:out value="${product.description}" />
					</p>
				</div>
							
			</div>

<%@ include file = "footer.jsp" %>