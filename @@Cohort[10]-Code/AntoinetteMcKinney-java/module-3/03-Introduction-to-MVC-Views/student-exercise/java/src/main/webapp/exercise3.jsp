<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Exercise 3 - Echo</title>
		<style>
			li {
				list-style-type: none;
			}
		</style>
	</head>
<body>
	<h1>Exercise 3 - Echo</h1>

	<ul>
		<%--
			Given two query string parameters, "word" and "count":
			
			Add a number of list items equal to "count".  Each list item should contain the value passed in "word".
			
			The font size of the first list item should be equal to "count".  The font size of each subsequent list
			item should be decreased by 1.
			 
			See exercise3-echo.png for example output
		 --%>
		<c:set var="count" value="25"/>
		<!-- This set initializes the variable word to give the value Hello -->
		<c:set var="word" value="Hello" />
		<!-- print the first list item with value equal to the 'word' variable and font-size equal to the  variable 'count' -->
		<li style="font-size:${count}px">${word}</li>	
		<c:forEach begin="1" end="24" var="iteration">
		<!--  Subtracts the count minus the iteration number value to modify and decrease the font size -->
			<li style="font-size:${count-iteration}px">${word}</li>			

		</c:forEach>
		

	</ul>

</body>
</html>