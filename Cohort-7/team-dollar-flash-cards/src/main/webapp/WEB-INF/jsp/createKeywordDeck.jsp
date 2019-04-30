<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />
<script type="text/javascript">
	$(document).ready(function() {
		$.validator.addMethod('capitals', function(thing) {
			return thing.match(/[A-Z]/);
		});
		$("form#createDeckValidation").validate({
			rules : {
				deckName : {
					maxlength : 32,
				},
				deckDescription : {
					maxlength : 255,
				}
			},
			messages : {
				deckName : {
					maxlength : "You've entered too long of a name, please enter only 32 characters",
				},
				deckDescription : {
					maxlength : "You've entered too long of a description, please enter only 255 characters",
				}
			},
			errorClass : "error"
		});
	});
</script>

<h3 class="formTitle">List of All Cards in Deck</h3>

<div class="deckInfoKeyword">
	<div class="deckName">Create a New Deck</div>
	<div class="createNewDeck">
		<c:url var="formAction" value="/saveKeywordDeck" />
		<form method="POST" action="${formAction}" id="createDeckValidation">
			<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
			<div class="form-group deckDescription">
				<label for="deckName">Deck Name: </label> <input type="text"
					id="deckName" name="deckName" placeHolder="Deck Name"
					class="form-control" />
			</div>
			<div class="form-group deckDescription">
				<label for="deckDescription">Description: </label>
				<textarea id="deckDescription" name="deckDescription"
					placeHolder="Description" class="form-control" maxlength="255"></textarea>
			</div>
			<button type="submit" class="btn btn-default">Create Deck</button>
		</form>
	</div>
</div>




<div class="cardGrid">

	<c:forEach var="card" items="${listOfCardsByKeyword}">

		<div class="cardInfo">
			<div class="cardFront">
				<strong> <c:out value="${card.frontText}" /></strong>
			</div>
			<c:out value="(${card.backText})" />
		</div>
	</c:forEach>

</div>



<c:import url="/WEB-INF/jsp/footer.jsp" />