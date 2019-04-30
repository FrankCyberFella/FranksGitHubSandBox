package com.techelevator.model;

import java.util.List;

import org.postgresql.core.Keyword;

public interface CardDAO {

	public Card getCardById(Long cardId);

	public List<Card> getCardByDeckId(Long deckId);

	public List<Card> getPrivateCardByKeyword(String keyword, String userName);

	public List<Card> getPublicCardByKeyword(String keyword);

	public List<Card> getAllUserCardsByKeyword(String keyword, String userNam);

	public List<Card> getCardInDeckByKeyword(String keyword, Long deckId);
	
	public List<Card> getAllCardsByKeyword(String keyword);

	public List<String> getKeywordsByDeck(Long deckId);

	public List<String> getKeywordsByCard(Long cardId);
	
	public List<String> getAllKeywords();
	
	public List<String> getAllUserKeywords(String userName);
	
	public List<String> getPublicKeywords();

	public Long addCard(String frontText, String backText);

	public void addCardToDeck(Long cardId, Long deckId);

	public void addKeywordToCard(String keyword, Long cardId);

	public void removeKeywordFromCard(Long cardId, String keyword);

	public void deleteCard(Long cardId);

	public void modifyCard(String frontText, String backText, Long cardId);

}
