<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <c:import url="/WEB-INF/jsp/headder.jsp">
	    <c:param name="title" value="Tile Layout" />
	</c:import>
    <section id="main-content">
		Toy Department
    	<span id="tile-page-wrapper">
			<c:forEach var="prodList" items="${productList}">
				<span class="tile-wrapper">
				<c:url var="detailLink" value="productDetail?productId=${prodList.getProductId()}"/>
				 	<a href="${detailLink}"><img src="img/${prodList.getImageName()}">
						<!-- <img class="toypic"  -->
					</a>
					<%-- <div class="recipeName">
						${recipeData.getName()}
					</div>
					<img class="tileImg" src="img/${Math.round(recipeData.getAverageRating())}-star.png">
					<div class="tileIngredients" >
						${recipeData.getIngredients().size()} ingredients
					</div> --%>
				</span>
				
			</c:forEach>
		</span>
       

    </section>
</body>
</html>