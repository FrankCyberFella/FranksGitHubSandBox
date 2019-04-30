<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Exercise 2 - Fibonacci 25</title>
		<style>
			body{
			background-image:linear-gradient(to top, #555, #CCC);
				display: grid;
				grid-template-columns:
				"10% 80% 10%";
				grid-template-areas:
				". h1 ."
				". ul ."
				". a .";
				font-family:Monospace;
				
			}
		
		
			h1{
			height: 10%;
			grid-area:h1;
			justify-self: center;
				
			}
			
			a{	height: 10%;
				grid-area:a;
				text-align: center;
			}
			
			ul{
				height: 80%;
				grid-area:ul;
				display: flex;
				padding-left: 0;
				justify-self: center;
				justify-contents: evenly-spaced;
				flex-wrap: wrap;
				text-align: center;
			}
			
			li {
				margin-left: 0;
				margin-right: 0;
				list-style-type: none;
				width: 40px;
				padding: 5px;
				border-style: solid;
				background-image:linear-gradient(#CCC, #555);
				border-width: 1px;
				margin-bottom: 2px;
				text-align: center;
			}
		</style>
	</head>
	<body>
	<c:set var="f1" value="0"/>
	<c:set var="f2" value="1"/>
	<c:set var="fib" value="0"/>
		<h1>Exercise 2 - Fibonacci 25</h1>
		<ul>
			<li> ${f1}</li>
			<c:forEach begin="1" end="25">
				<li> ${f2}</li>
				<c:set var="fib"  value="${f1 + f2}"/>
				<c:set var="f1" value="${f2}"/>
				<c:set var="f2" value="${fib}"/>
			</c:forEach>
			<%--
				Add a list item (i.e. <li>) for each of the first 25 numbers in the Fibonacci sequence
				
				See exercise2-fibonacci.png for example output
			 --%>
		</ul>
		<a href="index.jsp">Go Back</a>
	</body>
</html>