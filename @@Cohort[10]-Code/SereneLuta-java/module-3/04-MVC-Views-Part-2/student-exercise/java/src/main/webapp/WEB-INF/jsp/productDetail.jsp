<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp">
</c:import>
<section id="main-content">
		<img id="detail-img" src="img/${product.getImageName()}"/>
		<div id="detail-name">${product.getName()}</div>
		<div id="detail-mnfr">${product.getManufacturer()}</div>
		<div><img id="detail-star" src="img/${Math.round(product.averageRating)}-star.png"/></div>
		<br>
		<br>
		<div id="detail-price">Price: $${product.getPrice()} </div>
		<div id="detail-weight">Weight ${Math.round(product.getWeightInLbs())} lbs</div>
		<br>
		<div id="detail-desc">Description: ${product.getDescription()}</div>
					
     </section>
</body>
</html>