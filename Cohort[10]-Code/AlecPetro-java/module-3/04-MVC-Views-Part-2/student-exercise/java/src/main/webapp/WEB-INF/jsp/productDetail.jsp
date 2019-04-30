<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp"/>

	<div class="detail">
		<img class="detail-photo" src="img/${product.imageName}" alt="Photo of Toy"/>
			<div class="detail-text">
				<i>${product.name}
						<c:if test="${product.topSeller == true}">
							<a id="best-seller">BEST SELLER!</a>
						</c:if>
					</i>
    			<i>by ${product.manufacturer}</i>
    			<img class="detail-rating" src="img/${Math.round(product.averageRating)}-star.png" alt="Average Rating"/>
    			<i class="price">$${product.price}</i>
    			<i><strong>Weight </strong>${Math.round(product.weightInLbs)} lbs</i>
    			<i id="detail-description"><strong>Description: </strong>${product.description}</i>
    		</div>
    </div>	
       
<c:import url="/WEB-INF/jsp/footer.jsp"/>   