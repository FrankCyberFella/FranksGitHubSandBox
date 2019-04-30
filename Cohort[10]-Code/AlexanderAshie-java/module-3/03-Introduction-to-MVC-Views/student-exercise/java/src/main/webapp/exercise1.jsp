<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Exercise 1 - FizzBuzz</title>
		<style>
			li {
				list-style-type: none;
			}
			
			.fizz {
				color: blue;
			}
			
			.buzz {
				color: red;
			}
			
			.fizzbuzz {
				color: purple;
				font-size: 150%;
			}
		</style>
	</head>
	<body>
		<h1>Exercise 1 - FizzBuzz</h1>
		<ul>
			<%--
				Add a list item (i.e. <li>) containing each of the numbers from 1 to 100.
				
				if the number is divisible by 3, show "Fizz!" instead and style the item using the "fizz" class
				
				if the number is divisible by 5, show "Buzz!" instead and style the item using the "buzz" class
				
				if the number is divisible by both 3 and 5, show "FizzBuzz!" instead  and style the item using the "fizzbuzz" class
				
				see exercise1-fizzbuzz.png for example output
			 --%>
			 
			 <c:forEach begin="1" end="100" var="fizzBuzz">
			 
			 	<c:set var="outputClass" value="li"/>
			 	
			 	<c:set var="output" value="${fizzBuzz}"/>
			 	
			 	<c:if test="${fizzBuzz % 3 == 0 && fizzBuzz % 5 != 0}">
					<c:set var="output" value="Fizz!"/>
					<c:set var="outputClass" value="fizz"/>
			 	</c:if>
			 		
			 	<c:if test="${fizzBuzz % 5 == 0 && fizzBuzz % 3 != 0}">
			 		<c:set var="output" value="Buzz!"/>
			 		<c:set var="outputClass" value="buzz"/>
			 	</c:if>
			 		
			 	<c:if test="${fizzBuzz % 3 == 0 && fizzBuzz % 5 == 0}">
			 		<c:set var="output" value="FizzBuzz!"/>
			 		<c:set var="outputClass" value="fizzbuzz"/>
			 	</c:if> 	
			 	
			 	<li class="${outputClass}">
			 		${output}	
			 	</li>
			 	
			 </c:forEach>
			 
		</ul>
	</body>
</html>