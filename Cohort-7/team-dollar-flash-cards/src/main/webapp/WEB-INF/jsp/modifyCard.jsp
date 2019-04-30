<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$.validator.addMethod('capitals', function(thing) {
							return thing.match(/[A-Z]/);
						});
						$("form#cardValidation")
								.validate(
										{
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

<h3 class="pageHeading">Modify Card</h3>



<div class="sideBySideCards">
	<div>
		<div class="frontLabel">
			<label for="front">Front </label>
		</div>
		<div class="backLabel">
			<label for="back">Back </label>
		</div>
	</div>
	<c:url var="formAction" value="/modifyCardWithKeyword" />
	<form method="POST" action="${formAction}" id="cardValidation">
		<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" /> <input
			type="hidden" name="deckId" value="${deckId}" /> <input
			type="hidden" name="cardId" value="${card.cardId}" />
		<div class="cardFaces">
			<div class="frontText">
				<textarea class="cardText" id="modifyFront" name="front" rows="20"
					cols="30" />
				<c:out value="${card.frontText}" />
				</textarea>
			</div>
			<div class="backText">
				<textarea class="cardText" id="modifyBack" name="back" rows="20"
					cols="30" />
				<c:out value="${card.backText}" />
				</textarea>
			</div>
		</div>
		<div class=keywordSection>
			<label for="keywords">Keywords:</label> <input list="keywords"
				name="keyword">
			<datalist id="keywords">
				<c:forEach var="keyword" items="${keywordsPerCard}">
					<option value="${keyword}"></option>
				</c:forEach>
			</datalist>
			<input type="submit">
		</div>
	</form>
	<c:if test="${keywordsPerCard.size() != 0}">
		<c:url var="formAction" value="/modifyCardDeleteKeyword" />
		<form method="POST" action="${formAction}">
			<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" /> <input
				type="hidden" name="deckId" value="${deckId}" /> <input
				type="hidden" name="cardId" value="${card.cardId}" />
			<div class="keywords">
				<select name="keyword" id="value" class="keywordDropDown">
					<option value="allKeywords">All Keywords</option>
					<c:forEach var="keyword" items="${keywordsPerCard}">
						<option value="${keyword}"><c:out value="${keyword}" /></option>
					</c:forEach>
				</select>
			</div>
			<div class="submitButton">
				<input id="formSubmitButton" type="submit" value="Delete Keyword" />
			</div>
		</form>
	</c:if>
	<c:import url="/WEB-INF/jsp/footer.jsp" />