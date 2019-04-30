package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCDeckDAO implements DeckDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCDeckDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public long saveDeck(String deckName, String deckDescription, String userName, Boolean isPublic) {
		// TODO do we need to save public decks, or will they all be private?
		String saveDeck = "INSERT INTO deck(deck_name, deck_description, user_name, public_deck) VALUES (?, ?, ?, ?) "
				+ "RETURNING deck_id ";
		long deckId = jdbcTemplate.queryForObject(saveDeck, Long.class, deckName, deckDescription, userName,
				isPublic);
		return deckId;
	}

	@Override
	public Deck getDeckByDeckID(Long deckId) {
		String sqlSelectDeckByID = "SELECT * FROM deck WHERE deck_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectDeckByID, deckId);
		Deck chosenDeck = new Deck();
		if (results.next()) {
			chosenDeck = mapRowToDeck(results);
		}
		return chosenDeck;
	}

	@Override
	public List<Deck> getAllPublicDecks() {
		List<Deck> publicDecks = new ArrayList<>();
		String sqlSelectAllPublicDecks = "SELECT * FROM deck WHERE public_deck = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllPublicDecks, true);
		while (results.next()) {
			Deck chosenDeck = mapRowToDeck(results);
			publicDecks.add(chosenDeck);
		}
		return publicDecks;
	}

	@Override
	// TODO need to add in user name to the deck "save"
	public List<Deck> getAllUserDecks(String userName) {
		List<Deck> userDecks = new ArrayList<>();
		String sqlSelectAllUserDecks = "SELECT * FROM deck WHERE user_name = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllUserDecks, userName);
		while (results.next()) {
			Deck chosenDeck = mapRowToDeck(results);
			userDecks.add(chosenDeck);
		}
		return userDecks;
	}

	@Override
	public List<Deck> getAllPrivateDecks() {
		List<Deck> allDecks = new ArrayList<>();
		String sqlSelectAllUserDecks = "SELECT * FROM deck WHERE public_deck = false";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllUserDecks);
		while (results.next()) {
			Deck chosenDeck = mapRowToDeck(results);
			allDecks.add(chosenDeck);
		}
		return allDecks;
	}
	
	@Override
	public void modifyDeck(Long deckId, String deckName, String deckDescription) {
		String sqlModifyDeck = "UPDATE deck SET deck_name = ?, deck_description = ? WHERE deck_id = ?";
		jdbcTemplate.update(sqlModifyDeck, deckName, deckDescription, deckId);

	}

	private Deck mapRowToDeck(SqlRowSet results) {
		Deck theDeck = new Deck();
		theDeck.setDeckId(results.getLong("deck_id"));
		theDeck.setDeckName(results.getString("deck_name"));
		theDeck.setDeckDescription(results.getString("deck_description"));
		theDeck.setIsPublic(results.getBoolean("public_deck"));
		theDeck.setUserName(results.getString("user_name"));
		return theDeck;

	}

}
