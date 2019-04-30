<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Films Form"/>

<%@include file="common/header.jspf"%>
<c:url var="filmListAction" value ="/filmResult" />
<form method = "GET" action ="${filmListAction}">
	<div class ="formInputGroup">
	<label for = "Minimum Length"> Minimum Length</label>
	<input type = "text" name = "minLength" id = "Minimum Length"/>
	</div>
	<div class ="formInputGroupTwo">
	<label for = "Maximum Length"> Maximum Length</label>
	<input type = "text" name = "maxLength" id = "Maximum Length"/>
	</div>
	<div class ="formInputGroupThree">
	<label for = "genre"> Genre </label>
	<select name = "genre">
				<option value = "Action"> Action </option>
				<option value = "Animation"> Animation </option>
				<option value = "Children"> Children </option>
				<option value = "Classics"> Classics </option>
				<option value = "Comedy"> Comedy </option>
				<option value = "Documentary"> Documentary </option>
				<option value = "Drama"> Drama </option>
				<option value = "Family"> Family </option>
				<option value = "Foreign"> Foreign </option>
				<option value = "Games"> Games </option>
				<option value = "Horror"> Horror </option>
				<option value = "Music"> Music </option>
				<option value = "New"> New </option>
				<option value = "Sci-Fi"> Sci-Fi </option>
				<option value = "Sports"> Sports </option>
				<option value = "Travel"> Travel </option>
				<option value = "Mathmagical"> Mathmagical</option>
	</select>
	</div>
<input class = "formSubmitButton" type ="submit" value = "Submit"/>

</form>
<%@include file="common/footer.jspf"%>