<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
<c:import url="/WEB-INF/jsp/template.jsp"/>


 <c:set var="id" value="${param.recipeId}"/>
 
 <section id="detail-main-content">

    <div id="description">
    <span id="recipeImg"><img src="img/recipe${id}.jpg"/></span>
   	 <div>
	<div id="recipeName">${recipe.name}</div>
	<div id="recipeType">${recipe.recipeType}</div>
		<p></p>
		<div id="cookTime">
	<span style="font-weight:bold"> Cook Time </span> <span> ${recipe.cookTimeInMinutes} minutes </span>
		</div>
		<p></p>
	<div id="recipeDesc">${recipe.description} </div>
	
		</div>
    
    </div>
    
    <h2 style="text-align:left">Ingredients</h2>
    <ul class="instructionList">
   <c:forEach var="ingredient" items="${recipe.ingredients}">
   		<li> ${ingredient.getName()} ${ingredient.getQuantity()}</li>
   </c:forEach>
   </ul>
   
    <h2 style="text-align:left">Preparation</h2>
    <ol class="instructionList">
   <c:forEach var="preparationSteps" items="${recipe.preparationSteps}">
   		<li> ${preparationSteps}</li>
   </c:forEach>
   </ol>
	
    </section>


<c:import url="/WEB-INF/jsp/template2.jsp"/>
	    