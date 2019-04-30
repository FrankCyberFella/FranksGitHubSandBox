<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


    <c:import url="/WEB-INF/jsp/headder.jsp">
	    <c:param name="title" value="Table Layout" />
	</c:import>
    
    <section id="main-content">

    	Toy Department
    	<table>
    		<tr>
    			<th></th>
    			<c:forEach var="prodList" items="${productList}">
    				<c:url var="detailLink" value="productDetail?productId=${prodList.getProductId()}"/>
    				<td><a href="${detailLink}"><img src="img/${prodList.getImageName()}"></a></td>  
    			</c:forEach>
    		</tr>
    		<tr>
    			<th>Name</th>
    			<c:forEach var="prodList" items="${productList}">
    				<td>${prodList.getName()}</td>
    			</c:forEach>
    		</tr>
    		<tr>
    			<th>Rating</th>
    			<c:forEach var="prodList" items="${productList}">
    				<td><img src="img/${Math.round(prodList.getAverageRating())}-star.png"></td>
    			</c:forEach>
    		</tr>
    		<tr>
    			<th>Mfr</th>
    			<c:forEach var="prodList" items="${productList}">
    				<td>${prodList.getManufacturer()} </td>
    			</c:forEach>
    		</tr>
    		<tr>
    			<th>Price</th>
    			<c:forEach var="prodList" items="${productList}">
    				<td>$${prodList.getPrice()}</td>
    			</c:forEach>
    		</tr>
    		<tr>
    			<th>wt. (in lbs)</th>
    			<c:forEach var="prodList" items="${productList}">
    				<td>${Math.round(prodList.getWeightInLbs())}</td>
    			</c:forEach>
    		</tr>
    	</table>
       

    </section>
</body>
</html>