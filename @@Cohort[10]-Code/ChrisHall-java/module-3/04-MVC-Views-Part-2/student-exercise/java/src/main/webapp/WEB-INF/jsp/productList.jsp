<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


    
    <c:import url="/WEB-INF/jsp/headder.jsp">
	    <c:param name="title" value="List Layout" />
	</c:import>
	
    <section id="main-content">
    	
    	Toy Department
		
			
    			
    			<c:forEach var="prodList" items="${productList}">
    				<c:url var="detailLink" value="productDetail?productId=${prodList.getProductId()}"/>
    				<li><a href="${detailLink}"><img src="img/${prodList.getImageName()}"></a></li>
    				
    				
    				<li>${prodList.getName()}</li>
    				<li>${prodList.isTopSeller()}</li>
    				<li>${prodList.getManufacturer()}</li>
    				<li>${prodList.getPrice()}</li>
    				<li>${prodList.getWeightInLbs()}</li>
    				<li>${prodList.getAverageRating()}</li>
    			</c:forEach>
    		
       

    </section>
</body>
</html>