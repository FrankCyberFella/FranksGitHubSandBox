<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />


<div class="resultsInfo">

	<c:if test="${correctList.size() > 0}">
		<div class="resultsButton">
			<div class="info">
				You got
				<c:out value="${correctList.size()}" />
				out of
				<c:out
					value="${correctList.size() + incorrectList.size() + skippedList.size()}" />
				cards
			</div>
			<div id="reStudyButton">
				<c:url var="reStudyCorrectHref" value="/reStudy">
					<c:param name="deckId" value="${deckId}" />
					<c:param name="counter" value="0" />
					<c:param name="answer" value="reStudyCorrect" />
				</c:url>
				<a href="${reStudyCorrectHref}"><button class="reStudyButton">ReStudy
						Correct</button></a>
			</div>
		</div>
	</c:if>
	<c:if test="${incorrectList.size() > 0}">
		<div class="resultsButton">
			<div class="info">
				You got
				<c:out value="${incorrectList.size()}" />
				out of
				<c:out
					value="${correctList.size() + incorrectList.size() + skippedList.size()}" />
				cards
			</div>
			<div id="reStudyButton">
				<c:url var="reStudyIncorrectHref" value="/reStudy">
					<c:param name="counter" value="0" />
					<c:param name="deckId" value="${deckId}" />
					<c:param name="answer" value="reStudyIncorrect" />
				</c:url>
				<a href="${reStudyIncorrectHref}"><button class="reStudyButton">ReStudy
						Incorrect</button></a>
			</div>
		</div>
	</c:if>
	<c:if test="${skippedList.size() > 0}">
		<div class="resultsButton">
			<div class="info">
				You skipped
				<c:out value="${skippedList.size()}" />
				out of
				<c:out
					value="${correctList.size() + incorrectList.size() + skippedList.size()}" />
				cards
			</div>
			<div id="reStudyButton">
				<c:url var="reStudySkippedHref" value="/reStudy">
					<c:param name="counter" value="0" />
					<c:param name="deckId" value="${deckId}" />
					<c:param name="answer" value="reStudySkipped" />
				</c:url>
				<a href="${reStudySkippedHref}"><button class="reStudyButton">ReStudy
						Skipped</button></a>
			</div>
		</div>
	</c:if>
	<c:url var="deckPageHref" value="/deckPage">
		<c:param name="deckId" value="${deckId}" />
	</c:url>
	<div class="resultsButton">
	<div class="invisibleText">This text should never appear</div>
		<a href="${deckPageHref}"><button class="reStudyButton">Return
				to Deck Page</button></a>
	</div>
</div>


<c:import url="/WEB-INF/jsp/footer.jsp" />