<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<script type="text/javascript">
	$(document).ready(function() {
		$.validator.addMethod('capitals', function(thing) {
			return thing.match(/[A-Z]/);
		});
		$("form#cardValidation").validate({
			rules : {
				front : {
					required : true,
					maxlength : 512,
				},
				back : {
					required : true,
					maxlength : 512,
				},
				keyword : {
					maxlength : 255,
				}
			},
			messages : {
				front : {
					maxlength : "You've entered too much text, please enter only 512 characters",
				},
				back : {
					maxlength : "You've entered too much text, please enter only 512 characters",
				},
				back : {
					maxlength : "You've entered too much text, please enter only 255 characters",
				}
			},
			errorClass : "error"
		});
	});
</script>


<h3 class="pageHeading">Create Card</h3>

<c:url var="formAction" value="/addCard" />
<form method="POST" action="${formAction}" id="cardValidation">
	<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" /> <input
		type="hidden" name="deckId" value="${deckId}" />
	<div class="sideBySideCards">
		<div>
			<div class="frontLabel">
				<label for="front">Front </label>
			</div>
			<div class="backLabel">
				<label for="back">Back </label>
			</div>
		</div>
		<div class="cardFaces">
			<div class="frontText">
				<textarea class="cardText" name="front" rows="20"
					cols="30" /></textarea>
			</div>
			<div class="backText">
				<textarea class="cardText" name="back" rows="20"
					cols="30" /></textarea>
			</div>
		</div>
	</div>
	<div class=keywordSection>
		<label for="keywords">Keywords:</label> <input list="keywords"
			name="keyword">
		<datalist id="keywords">
			<c:forEach var="keyword" items="${listOfKeywords}">
				<option value="${keyword}"></option>
			</c:forEach>
		</datalist>
		<input type="submit">
	</div>
	<div class="createCardButton">
		<button type="submit">Create Card</button>
	</div>

</form>

<c:import url="/WEB-INF/jsp/footer.jsp" />