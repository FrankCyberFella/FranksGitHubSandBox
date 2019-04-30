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
		<c:forEach begin = "1" end= "100" var = "num">
		<c:set var = "val" value = ""/>
		<c:set var = "stylings" value = ""/>
		<c:choose>
		
		<c:when test="${num % 5 == 0 && num % 3 == 0}">
		<c:set var ="val" value ="FizzBuzz"/>
		<c:set var ="stylings" value ="fizzbuzz"/>
		</c:when>
		
		<c:when test= "${num % 3 == 0}">
    	<c:set var ="val" value ="Fizz"/>
		<c:set var ="stylings" value ="fizz"/>
		</c:when>
		
		<c:when test= "${num % 5 == 0}">
		<c:set var = "val" value = "Buzz"/>
		<c:set var = "stylings" value = "buzz"/>
		</c:when>
		
		<c:otherwise>
		<c:set var ="val" value = "${num}"/>
		<c:set var="stylings"  value ="li"/>
		</c:otherwise>
		</c:choose> 
		
		<li class="${stylings}">${val}</li>
		</c:forEach>
		
			<%--
		
				Add a list item (i.e. <li>) containing each of the numbers from 1 to 100.
				
				if the number is divisible by 3, show "Fizz!" instead and style the item using the "fizz" class
				
				if the number is divisible by 5, show "Buzz!" instead and style the item using the "buzz" class
				
				if the number is divisible by both 3 and 5, show "FizzBuzz!" instead  and style the item using the "fizzbuzz" class
				
				see exercise1-fizzbuzz.png for example output
			 --%>
		</ul>
	</body>
</html>

<%-- 

		<c:forEach begin="1" end="100" var="nums">
		<c:set var= "value" value = ""/>
		<c:set var= "rowClassAttribute" value = ""/>
		<c:choose>
		<c:when test="${nums % 3 == 0 && nums % 5 == 0}">
		<c:set var ="value" value="FizzBuzz"/>
		<c:set var ="rowClassAttribute" value ="fizzbuzz"/>
		</c:when>
		<c:when test="${nums % 3 == 0}">
		<c:set var="value" value="Fizz"/>
		<c:set var="rowClassAttribute" value ="buzz"/>
		</c:when>
		<c:when test="${nums % 5 == 0}">
		<c:set var="value" value="Buzz"/>
		<c:set var="rowClassAttribute" value ="fizzbuzz"/>
		</c:when>
		<c:when test="${nums % 3 == 0 && nums % 5 == 0}">
		<c:set var="value" value="FizzBuzz"/>
		<c:set var="rowClassAttribute" value ="fizzbuzz"/>
		</c:when>
		<c:otherwise> 
			<c:set var= "value" value = "${nums}"/>
			<c:set var= "rowClassAttribute" value = "li"/>
		
		</c:otherwise>
		</c:choose>
			<li class="${rowClassAttribute}">${value}</li>
		</c:forEach>  --%>