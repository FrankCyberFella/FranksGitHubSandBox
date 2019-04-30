package com.techelevator.model;

import java.util.List;

public interface DeckDAO {
	
	public long saveDeck(String deckName, String deckDescription, String userName, Boolean isPublic);
	
	public Deck getDeckByDeckID(Long deckId);
	
	public List<Deck> getAllPublicDecks();
	
	public List<Deck> getAllUserDecks(String userName);

	public List<Deck> getAllPrivateDecks();
	
	public void modifyDeck(Long deckId, String deckName, String deckDescription);
}
