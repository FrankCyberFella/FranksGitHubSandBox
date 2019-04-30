<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Exercise 1 - FizzBuzz</title>
		<style>
			li {
				list-style-type: none;
			}
			
			.fizz { /* class */
				color: blue;
			}
			
			.buzz { /* class */
				color: red;
			}
			
			.fizzbuzz { /* class */
				color: purple;
				font-size: 150%;
			}
		</style>
	</head>
	<body>
		<h1>Exercise 1 - FizzBuzz</h1>
		<ul>
		
		
		<table>
			<tr>
				<th>number</th> <!-- header -->
			</tr>
			 
			<%-- The forEach tag can be used to iterate over a range of numbers
		     or over a collection (like the "for each" loop from Java).  The 
		     loop below iterates over the numbers from 1-100 inclusive and 
		     assigns the next number to the scoped variable named "inches" 
		     with each iteration.The "choose" tag below allows us to do "if/else"
				logic. Each of the "when" tags is evaluated in order, 
				if the "test" attribute is true, then the body of the 
				"when" tag is evaluated and then the "choose" tag is 
				exited.  If no "when" tag is executed, then the
				"otherwise" tag is evaluated. --%>
			<c:forEach begin="1" end="100" var="number"><!-- Change "inches" to "number" -->
				<tr><!--  row -->
				<c:choose>						
				<c:when test="${number % 3 == 0 && number % 5 == 0 }"> <!-- if divid by 3 and remainder is 0 and divide by 5 and remaind is 0 retrn fizzbuzz -->
					<c:set var = "setClass" value="fizzbuzz" />	<!-- set initializes the variable setClass to give value fizzbuzz -->
					<td class="${setClass}">FizzBuzz!</td> <!-- tag to give class a name. varable setClass is put in mustashe --> 
				</c:when>
				<c:when test="${number % 5 == 0}">
					<c:set var = "setClass" value="buzz" />	
					<td class="${setClass}">Buzz!</td>
				</c:when>
				<c:when test="${number % 3 == 0}">
					<c:set var = "setClass" value="fizz" />	
					<td class="${setClass}">Fizz!</td>
				</c:when>
				<c:otherwise>
				<td>${number}</td> <%-- Changed table data ${inches} to ${number} , this is default if conditions dont meet --%>
				</c:otherwise>
					<%-- These are JSP EL expressions.  Anything between the
				    curly braces will be evaluated as an EL expression
				    and the result will be included in the HTML generated
				    by this JSP --%>
					</c:choose>
				</tr>	
			</c:forEach>
		</table>
		
		
		
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