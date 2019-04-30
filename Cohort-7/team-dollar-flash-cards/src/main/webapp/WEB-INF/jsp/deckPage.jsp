<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$.validator.addMethod('capitals', function(thing) {
							return thing.match(/[A-Z]/);
						});
						$("form#createDeckValidation")
								.validate(
										{
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

<div class="deckHeader">
	<c:out value="${deck.deckName}" />
</div>
<div class="deckPageInfoGrid">
	<div class="deckPageInfo">
		<c:choose>
			<c:when test="${currentUser.userName.equals('admin')}">
				<div class="createNewDeck">
					<c:url var="formAction" value="/modifyDeck" />
					<form method="POST" action="${formAction}"
						id="createDeckValidation">
						<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" /> <input
							type="hidden" name="deckId" value="${deck.deckId}" />
						<div class="form-group deckDescription">
							<label for="deckName">Deck Name: </label> <input type="text"
								id="deckName" name="deckName" value="${deck.deckName}"
								class="form-control" />
						</div>
						<div class="form-group deckDescription">
							<label for="deckDescription">Description: </label>
							<textarea id="modifyDescription" name="deckDescription"
								maxlength="255" />
							<c:out value="${deck.deckDescription}" />
							</textarea>
							<div class="modifyDeckButton">
								<button type="submit" class="btn btn-default">Modify
									Deck</button>
							</div>
						</div>
					</form>
				</div>
			</c:when>
			<c:when test="${currentUser.userName.equals(deck.userName)}">
				<div class="createNewDeck">
					<c:url var="formAction" value="/modifyDeck" />
					<form method="POST" action="${formAction}"
						id="createDeckValidation">
						<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" /> <input
							type="hidden" name="deckId" value="${deck.deckId}" />
						<div class="form-group deckDescription">
							<label for="deckName">Deck Name: </label> <input type="text"
								id="deckName" name="deckName" value="${deck.deckName}"
								class="form-control" />
						</div>
						<div class="form-group deckDescription">
							<label for="deckDescription">Description: </label>
							<textarea id="modifyDescription" name="deckDescription"
								maxlength="255" />
							<c:out value="${deck.deckDescription}" />
							</textarea>
							<div class="modifyDeckButton">
								<button type="submit" class="btn btn-default">Modify
									Deck</button>
							</div>
						</div>
					</form>
				</div>
			</c:when>

			<c:otherwise>
				<div>
					<div class="deckName">
						<c:out value="${deck.deckName}" />
					</div>
					<div class="deckDescription">
						<c:out value="${deck.deckDescription}" />
					</div>
				</div>
			</c:otherwise>
		</c:choose>

	</div>
	<c:url var="formAction" value="/keywordSession" />
	<form method="GET" action="${formAction}">
		<div class="sessionOptions">
			<h3 class="sessionOptionTitle">Select Your Session Options</h3>
			<div class="sessionOptionGrid">
				<div class="sessionOrderOption">
					<label for="order" class="selectionLabel">Order</label> <select name="order" id="value">
						<option value="ordered">Ordered</option>
						<option value="random">Random</option>
					</select>
				</div>
				<div class="sessionCountOption">
					<label for="count" class="selectionLabel">How many cards?</label> <select name="count"
						id="value">
						<option value=-1>All</option>
						<option value=5>5</option>
						<option value=10>10</option>
						<option value=15>15</option>
					</select>
				</div>
				<div class="sessionKeywordOption">
					<label for="keyword" class="selectionLabel">Keyword</label> <select name="keyword"
						id="value">
						<option value="allKeywords">All Keywords</option>
						<c:forEach var="keyword" items="${listOfKeywordsByDeck}">
							<option value="${keyword}"><c:out value="${keyword}" /></option>
						</c:forEach>
					</select>
				</div>
				<input type="hidden" name="deckId" value="${deckId}" /> <input
					type="hidden" name="counter" value=0 /> <input type="hidden"
					name="answer" value='start' />
				<button class="sessionStartButton">Start Session!</button>
			</div>
		</div>
	</form>
</div>

<h3 class="formTitle">List of Cards in Deck</h3>

<div class="cardGrid">

	<c:choose>
		<c:when test="${currentUser.userName.equals('admin')}">
			<c:url var="createCardPageHref" value="/createCard">
				<c:param name="deckId" value="${deckId}" />
			</c:url>
			<a href="${createCardPageHref}">
				<div class="cardInfoDeckPage">
					<div class="cardFrontDeckPage">Create New Card</div>
				</div>
			</a>
		</c:when>

		<c:when test="${currentUser.userName.equals(deck.userName)}">
			<c:url var="createCardPageHref" value="/createCard">
				<c:param name="deckId" value="${deckId}" />
			</c:url>
			<a href="${createCardPageHref}">
				<div class="cardInfoDeckPage">Create New Card</div>
			</a>
		</c:when>
	</c:choose>

	<c:forEach var="card" items="${listOfCardsPerDeck}">
		<c:url var="modifyCardPageHref" value="/modifyCard">
			<c:param name="deckId" value="${deck.deckId}" />
			<c:param name="cardId" value="${card.cardId}" />
		</c:url>
		<c:if
			test="${currentUser.userName.equals('admin') || currentUser.userName.equals(deck.userName)}">
			<a class="linkOverflow" href="${modifyCardPageHref}">
		</c:if>
		<div class="cardInfoDeckPage">
			<div class="cardFrontDeckPage">
				<c:out value="${card.frontText}" />
			</div>
			<div class="cardBackDeckPage">
				<c:out value="(${card.backText})" />
				<c:forEach var="cardKeyword" items="${card.keyword}">
					<c:out value='${cardKeyword}'>
					</c:out>
				</c:forEach>
				<c:if
					test="${ currentUser.userName.equals('admin') || currentUser.userName.equals(deck.userName)}">
					<c:url var="formAction" value="/deleteCard">
						<c:param name="cardId" value="${card.cardId}" />
						<c:param name="deckId" value="${deck.deckId}" />
					</c:url>
					<form method="POST" action="${formAction}">
						<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
						<div class="deleteCardButton">
							<button type="submit">Delete Card</button>
						</div>
					</form>
				</c:if>
			</div>
		</div>
		<c:if test="${currentUser.userName.equals('admin')}">
			</a>
		</c:if>
	</c:forEach>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />