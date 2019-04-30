<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Word Echo</title>
</head>
<body style= "background-image: url(img/wordcloud.png)">
<section style="background-color: white; margin: 25%">
<h1 style= "font-family:arial">Word Echo</h1>
<form action="echoShow" method="GET">

	<div>
		<label for="startingFontSize" style= "font-family:arial">Font Size</label>
		<input type="text" name="startingFontSize" id="initial font size"/>
	</div>
	<div>
		<label for="startingFontSize"  style= "font-family:arial">Starting Word</label>
		<input type="text" name="word" id="word"/>
	</div>
	<div>
		<input type="submit" id="submit"/>
	</div>
</form>
</section>
</body>
</html>