<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h3>Card Page</h3>

Card
<c:out value="${counter + 1}"></c:out>
of:
<c:out value="${size}"></c:out>
total. Number correct:
<c:out value="${correctList.size()}"></c:out>

<div id="sessionGrid">
	<div class="flip-container">
		<div class="flipper">
			<div class="front cardInfo">
				<div id="sessionContent">
					<c:out value="${card.frontText}" />
				</div>
			</div>
			<div class="back cardInfo">
				<div id="sessionContent">
					<c:out value="${card.backText}" />
				</div>
			</div>
		</div>
	</div>
	<div id="answerGrid">
		<div id="answerButton">
			<c:url var="correct" value="/sessionPage">
				<c:param name="counter" value="${counter + 1}" />
				<c:param name="deckId" value="${deckId}" />
				<c:param name="answer" value="correct" />
			</c:url>
			<a href="${correct}" class="correctButton"><button class="sessionButton">Correct</button></a>
		</div>
		<div id="answerButton">
			<c:url var="incorrect" value="/sessionPage">
				<c:param name="counter" value="${counter + 1}" />
				<c:param name="deckId" value="${deckId}" />
				<c:param name="answer" value="incorrect" />
			</c:url>
			<a href="${incorrect}" ><button class="sessionButton">Incorrect</button></a>
		</div>
		<div id="answerButton">
			<c:url var="skip" value="/sessionPage">
				<c:param name="counter" value="${counter + 1}" />
				<c:param name="deckId" value="${deckId}" />
				<c:param name="answer" value="skip" />
			</c:url>
			<a href="${skip}"><button class="sessionButton">Skip</button></a>
		</div>
	</div>
	<div id="finishButton">
		<c:url var="finishHref" value="/resultsPage">
			<c:param name="deckId" value="${deckId}" />
		</c:url>
		<a href="${finishHref}"><button class="sessionButton">Finish</button></a>
	</div>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />