package com.techelevator.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCCardDAO implements CardDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCCardDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Card getCardById(Long cardId) {
		String sqlSelectCardById = "SELECT * FROM card WHERE card_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectCardById, cardId);
		Card chosenCard = new Card();
		if (results.next()) {
			chosenCard = mapRowToCard(results);
		}
		return chosenCard;
	}

	@Override
	public List<Card> getCardByDeckId(Long deckId) {
		List<Card> listOfCardsById = new ArrayList<>();
		String sqlSelectCardByDeckId = "SELECT * FROM card JOIN card_deck ON card.card_id = card_deck.card_id WHERE deck_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectCardByDeckId, deckId);
		while (results.next()) {
			Card chosenCard = mapRowToCard(results);
			listOfCardsById.add(chosenCard);
		}
		return listOfCardsById;
	}

	@Override
	public List<Card> getPrivateCardByKeyword(String keyword, String userName) {
		List<Card> listOfPrivateCardsByKeyword = new ArrayList<>();
		String sqlSelectPrivateCardByKeyword = "SELECT * FROM card "
				+ "JOIN card_keyword ON card.card_id = card_keyword.card_id "
				+ "JOIN keyword ON card_keyword.keyword_id = keyword.keyword_id "
				+ "JOIN card_deck on card.card_id = card_deck.card_id "
				+ "JOIN deck on card_deck.deck_id = deck.deck_id "
				+ "WHERE keyword = ? AND public_deck = false AND user_name = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectPrivateCardByKeyword, keyword, userName);
		while (results.next()) {
			Card chosenCard = mapRowToCard(results);
			listOfPrivateCardsByKeyword.add(chosenCard);
		}
		return listOfPrivateCardsByKeyword;
	}

	@Override
	public List<Card> getPublicCardByKeyword(String keyword) {
		List<Card> listOfPublicCardsByKeyword = new ArrayList<>();
		String sqlSelectPublicCardByKeyword = "SELECT * FROM card "
				+ "JOIN card_keyword ON card.card_id = card_keyword.card_id "
				+ "JOIN keyword ON card_keyword.keyword_id = keyword.keyword_id "
				+ "JOIN card_deck on card.card_id = card_deck.card_id "
				+ "JOIN deck on card_deck.deck_id = deck.deck_id " + "WHERE keyword = ? AND public_deck = true";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectPublicCardByKeyword, keyword);
		while (results.next()) {
			Card chosenCard = mapRowToCard(results);
			listOfPublicCardsByKeyword.add(chosenCard);
		}
		return listOfPublicCardsByKeyword;

	}

	@Override
	public List<Card> getAllUserCardsByKeyword(String keyword, String userName) {
		List<Card> listOfAllCardsByKeyword = new ArrayList<>();

		String sqlSelectPublicCardByKeyword = "SELECT * FROM card "
				+ "JOIN card_keyword ON card.card_id = card_keyword.card_id "
				+ "JOIN keyword ON card_keyword.keyword_id = keyword.keyword_id "
				+ "JOIN card_deck on card.card_id = card_deck.card_id "
				+ "JOIN deck on card_deck.deck_id = deck.deck_id " + "WHERE keyword = ? AND public_deck = true";
		SqlRowSet publicResults = jdbcTemplate.queryForRowSet(sqlSelectPublicCardByKeyword, keyword);
		while (publicResults.next()) {
			Card publicChosenCard = mapRowToCard(publicResults);
			listOfAllCardsByKeyword.add(publicChosenCard);

		}

		String sqlSelectPrivateCardByKeyword = "SELECT * FROM card "
				+ "JOIN card_keyword ON card.card_id = card_keyword.card_id "
				+ "JOIN keyword ON card_keyword.keyword_id = keyword.keyword_id "
				+ "JOIN card_deck on card.card_id = card_deck.card_id "
				+ "JOIN deck on card_deck.deck_id = deck.deck_id "
				+ "WHERE keyword = ? AND public_deck = false AND user_name = ?";
		SqlRowSet privateResults = jdbcTemplate.queryForRowSet(sqlSelectPrivateCardByKeyword, keyword, userName);
		while (privateResults.next()) {
			Card privateChosenCard = mapRowToCard(privateResults);
			listOfAllCardsByKeyword.add(privateChosenCard);

		}
		return listOfAllCardsByKeyword;

	}

	@Override
	public List<Card> getAllCardsByKeyword(String keyword) {
		List<Card> allCardsByKeyword = new ArrayList<>();
		String sqlSelectAllCardsbyKeyword = "SELECT * " + "FROM card "
				+ "JOIN card_keyword ON card.card_id = card_keyword.card_id "
				+ "JOIN keyword ON card_keyword.keyword_id = keyword.keyword_id " + "WHERE keyword = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllCardsbyKeyword, keyword);
		while (results.next()) {
			Card chosenCard = mapRowToCard(results);
			allCardsByKeyword.add(chosenCard);
		}
		return allCardsByKeyword;
	}

	@Override
	public List<Card> getCardInDeckByKeyword(String keyword, Long deckId) {
		List<Card> listOfCardsByDeckByKeyword = new ArrayList<>();
		String sqlSelectCardbyDeckByKeyword = "SELECT * FROM card JOIN card_keyword ON card.card_id = card_keyword.card_id "
				+ "JOIN keyword on card_keyword.keyword_id = keyword.keyword_id "
				+ "JOIN card_deck on card.card_id = card_deck.card_id " + "WHERE keyword = ? AND deck_id = ?";
		SqlRowSet resutls = jdbcTemplate.queryForRowSet(sqlSelectCardbyDeckByKeyword, keyword, deckId);
		while (resutls.next()) {
			Card chosenCard = mapRowToCard(resutls);
			listOfCardsByDeckByKeyword.add(chosenCard);
		}
		return listOfCardsByDeckByKeyword;
	}

	@Override
	public List<String> getKeywordsByDeck(Long deckId) {
		List<String> listOfKeywordsByDeck = new ArrayList<>();
		String sqlSelectKeywordsByDeck = "SELECT DISTINCT keyword " + "FROM keyword "
				+ "JOIN card_keyword ON keyword.keyword_id = card_keyword.keyword_id "
				+ "JOIN card_deck ON card_keyword.card_id = card_deck.card_id " + "WHERE deck_id = ? ";
		listOfKeywordsByDeck = jdbcTemplate.queryForList(sqlSelectKeywordsByDeck, String.class, deckId);

		return listOfKeywordsByDeck;
	}

	@Override
	public List<String> getAllUserKeywords(String userName) {
		List<String> listOfPublicUserKeywords = new ArrayList<>();
		List<String> listofPrivateKeywords = new ArrayList<>();
		String sqlSelectPublicKeywords = "Select keyword " + "From keyword "
				+ "Join card_keyword on keyword.keyword_id = card_keyword.keyword_id "
				+ "Join card_deck on card_keyword.card_id = card_deck.card_id "
				+ "JOIN deck ON card_deck.deck_id = deck.deck_id " + "WHERE public_deck = true " + "Group By keyword;";
		listOfPublicUserKeywords = jdbcTemplate.queryForList(sqlSelectPublicKeywords, String.class);
		String sqlSelectPrivateKeywords = "Select keyword " + "From keyword "
				+ "Join card_keyword on keyword.keyword_id = card_keyword.keyword_id "
				+ "Join card_deck on card_keyword.card_id = card_deck.card_id "
				+ "JOIN deck ON card_deck.deck_id = deck.deck_id " + "WHERE public_deck = false AND user_name = ? "
				+ "Group By keyword;";
		listofPrivateKeywords = jdbcTemplate.queryForList(sqlSelectPrivateKeywords, String.class, userName);
		Set<String> setofAllUserKeywords = new HashSet<>(listOfPublicUserKeywords);

		for (String element : listofPrivateKeywords) {
			setofAllUserKeywords.add(element);
		}
		List<String> listOfAllUserKeyword = new ArrayList<>(setofAllUserKeywords);
		return listOfAllUserKeyword;

	}

	@Override
	public List<String> getAllKeywords() {
		List<String> listOfAllKeywords = new ArrayList<>();
		String sqlSelectKeywords = "SELECT DISTINCT keyword " + "FROM keyword;";
		listOfAllKeywords = jdbcTemplate.queryForList(sqlSelectKeywords, String.class);

		return listOfAllKeywords;

	}

	@Override
	public List<String> getPublicKeywords() {
		List<String> listOfAllPublicKeywords = new ArrayList<>();
		String sqlSelectPublicKeywords = "SELECT DISTINCT keyword " + "From Keyword "
				+ "JOIN card_keyword on keyword.keyword_id = card_keyword.keyword_id "
				+ "JOIN card_deck on card_keyword.card_id = card_deck.card_id "
				+ "JOIN deck ON card_deck.deck_id = deck.deck_id " + "WHERE public_deck = true;";
		listOfAllPublicKeywords = jdbcTemplate.queryForList(sqlSelectPublicKeywords, String.class);
		return listOfAllPublicKeywords;
	}

	@Override
	public List<String> getKeywordsByCard(Long cardId) {
		List<String> listOfKeywordsByCard = new ArrayList<>();
		String sqlSelectKeywordsByCard = "SELECT keyword  " + "FROM keyword "
				+ "JOIN card_keyword ON keyword.keyword_id = card_keyword.keyword_id " + "WHERE card_id = ? "
				+ "GROUP BY keyword";
		listOfKeywordsByCard = jdbcTemplate.queryForList(sqlSelectKeywordsByCard, String.class, cardId);
		return listOfKeywordsByCard;
	}

	@Override
	public Long addCard(String frontText, String backText) {
		String saveDeck = "INSERT INTO card(front, back) VALUES (?, ?) RETURNING card_id ";
		Long cardId = jdbcTemplate.queryForObject(saveDeck, Long.class, frontText, backText);
		return cardId;
	}

	@Override
	public void addCardToDeck(Long cardId, Long deckId) {
		String saveDeck = "INSERT INTO card_deck(deck_id, card_id) VALUES (?, ?) ";
		jdbcTemplate.update(saveDeck, deckId, cardId);
	}

	@Override
	public void deleteCard(Long cardId) {
		String sqlDeleteCardFromCardDeck = "DELETE FROM card_deck WHERE card_id = ?";
		String sqlDeleteCardFromCardKeyword = "DELETE FROM card_keyword WHERE card_id = ?";
		String sqlDeleteCard = "DELETE FROM card WHERE card_id = ? ";

		jdbcTemplate.update(sqlDeleteCardFromCardDeck, cardId);
		jdbcTemplate.update(sqlDeleteCardFromCardKeyword, cardId);
		jdbcTemplate.update(sqlDeleteCard, cardId);
	}

	@Override
	public void addKeywordToCard(String keyword, Long cardId) {
		String sqlGetKeywordId = "SELECT keyword_id FROM keyword where keyword = ?";
		Long chosenKeywordId;
		try {
			chosenKeywordId = jdbcTemplate.queryForObject(sqlGetKeywordId, Long.class, keyword);
		} catch (EmptyResultDataAccessException ex) {
			String sqlAddKeywordToTable = "INSERT into keyword (keyword) VALUES (?) RETURNING keyword_id ";
			chosenKeywordId = jdbcTemplate.queryForObject(sqlAddKeywordToTable, Long.class, keyword);
		}
		String sqlAddKeywordtoCard = "INSERT into card_keyword (card_id, keyword_id) VALUES (?, ?)";
		jdbcTemplate.update(sqlAddKeywordtoCard, cardId, chosenKeywordId);

	}

	@Override
	public void removeKeywordFromCard(Long cardId, String keyword) {
		String sqlGetKeywordId = "SELECT keyword_id FROM keyword where keyword = ?";
		Long chosenKeywordId = jdbcTemplate.queryForObject(sqlGetKeywordId, Long.class, keyword);
		String sqlDeleteCardFromCardDeck = "DELETE FROM card_keyword WHERE keyword_id = ? AND card_id = ?";
		jdbcTemplate.update(sqlDeleteCardFromCardDeck, chosenKeywordId, cardId);
	}

	@Override
	public void modifyCard(String frontText, String backText, Long cardId) {
		String sqlModifyCard = "UPDATE card SET front =?, back = ? WHERE card_id =?";
		jdbcTemplate.update(sqlModifyCard, frontText, backText, cardId);

	}

	private Card mapRowToCard(SqlRowSet results) {
		Card theCard = new Card();
		theCard.setCardId(results.getLong("card_id"));
		theCard.setFrontText(results.getString("front"));
		theCard.setBackText(results.getString("back"));
		return theCard;
	}

}
