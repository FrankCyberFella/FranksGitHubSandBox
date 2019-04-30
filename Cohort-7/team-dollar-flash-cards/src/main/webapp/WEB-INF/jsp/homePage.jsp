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

<c:out value="${message}" />

<c:if test="${currentUser != null}">
	<div class="deckHeaderGrid">
		<div class="deckHeader">
			<c:out value="${currentUser.userName}" />'s Flash Card Decks
		</div>
		<div class="getDeckByKeyword">
			<c:if test="${currentUser != null}">
				<c:url var="formAction" value="/createKeywordDeck" />
				<form method="GET" action="${formAction}" id="thisIDisForJoe">
					<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" /> <input
						type="hidden" name="deckId" value="${deck.deckId}" />
					<div class="searchForKeyword">
						<div class="formTitle">Get Cards By</div>
						<div class="formEntry">
							<c:choose>
								<c:when test="${currentUser.userName.equals('admin')}">
									<div class="keywords">
										<select name="keyword" id="value" class="keywordDropDown">
											<c:forEach var="keyword" items="${listOfAllKeywords}">
												<option value="${keyword}"><c:out
														value="${keyword}" /></option>
											</c:forEach>
										</select>
									</div>
								</c:when>
								<c:otherwise>
									<div class="formEntry">
										<select name="keyword" id="value">
											<option value="allKeywords">All Keywords</option>
											<c:forEach var="keyword" items="${listOfAllUserKeyword}">
										<<option value="${keyword}"><c:out value="${keyword}" /></option>
											</c:forEach>
										</select>
									</div>
								</c:otherwise>
							</c:choose>
						</div>
						<button type="submit" class="btn btn-default searchButton">Search</button>
					</div>
				</form>
			</c:if>
		</div>
	</div>
	<div class="deckGrid">
		<div class="deckInfo">
			<div class="deckName">Create a New Deck</div>
			<div class="createNewDeck">
				<c:url var="formAction" value="/createNewUserDeck" />
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
		<c:forEach var="privateDeck" items="${listOfPrivateDecks}">
			<c:url var="deckPageHref" value="/deckPage">
				<c:param name="deckId" value="${privateDeck.deckId}" />
			</c:url>
			<a href="${deckPageHref}">
				<div class="deckInfo">
					<div class="deckName">
						<c:out value="${privateDeck.deckName}" />
					</div>
					<div class="deckDescription">
						<c:out value="${privateDeck.deckDescription}" />
					</div>
				</div>
			</a>
		</c:forEach>
	</div>
</c:if>

<c:if test="${currentUser == null}">

</c:if>


<div class="deckHeader">Public Flash Card Decks</div>

<!-- if user is not logged in, public decks will display without the scrolling option -->
<c:if test="${currentUser == null}">
	<div class="deckGridForGuest">
		<c:forEach var="publicDeck" items="${listOfPublicDecks}">
			<c:url var="deckPageHref" value="/deckPage">
				<c:param name="deckId" value="${publicDeck.deckId}" />
			</c:url>
			<a href="${deckPageHref}">
				<div class="deckInfo">
					<div class="deckName">
						<c:out value="${publicDeck.deckName}" />
					</div>
					<div class="deckDescription">
						<c:out value="${publicDeck.deckDescription}" />
					</div>
				</div>
			</a>
		</c:forEach>
	</div>
</c:if>

<!-- if user is signed in, will display decks in scrolling format -->
<c:if test="${currentUser != null}">
	<div class="deckGrid">
		<c:forEach var="publicDeck" items="${listOfPublicDecks}">
			<c:url var="deckPageHref" value="/deckPage">
				<c:param name="deckId" value="${publicDeck.deckId}" />
			</c:url>
			<a href="${deckPageHref}">
				<div class="deckInfo">
					<div class="deckName">
						<c:out value="${publicDeck.deckName}" />
					</div>
					<div class="deckDescription">
						<c:out value="${publicDeck.deckDescription}" />
					</div>
				</div>
			</a>
		</c:forEach>
	</div>
</c:if>

<c:import url="/WEB-INF/jsp/footer.jsp" />