-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

-- CREATE statements go here
DROP TABLE IF EXISTS app_user;
DROP TABLE IF EXISTS deck;
DROP TABLE IF EXISTS card;
DROP TABLE IF EXISTS keyword;
DROP TABLE IF EXISTS card_deck;
DROP TABLE IF EXISTS card_keyword;

CREATE TABLE app_user (
  email_address varchar(32) NOT NULL,
  user_name varchar(32) NOT NULL,
  password varchar(32) NOT NULL,
  salt varchar(255) NOT NULL,
  role varchar(32) NOT NULL,
  CONSTRAINT pk_app_user_username PRIMARY KEY (user_name)
);

CREATE TABLE deck (
  deck_id SERIAL NOT NULL,
  deck_name varchar(32) NOT NULL,
  deck_description varchar(255),
  user_name varchar(32),
  public_deck boolean NOT NULL,
  CONSTRAINT pk_deck_deck_id PRIMARY KEY (deck_id)
);

CREATE TABLE card (
  card_id SERIAL NOT NULL,
  front varchar(512) NOT NULL,
  back varchar(512) NOT NULL,
  CONSTRAINT pk_card_card_id PRIMARY KEY (card_id)
);

CREATE TABLE keyword (
  keyword_id SERIAL NOT NULL,
  keyword varchar(255) NOT NULL,
  CONSTRAINT pk_keyword_keyword_id PRIMARY KEY (keyword_id)
);

CREATE TABLE card_deck (
  deck_id integer NOT NULL,
  card_id integer NOT NULL,
  CONSTRAINT pk_card_deck_deck_id_card_id PRIMARY KEY (deck_id, card_id)
);

CREATE TABLE card_keyword (
  card_id integer NOT NULL,
  keyword_id integer NOT NULL,
  CONSTRAINT PK_card_keyword_card_id_keyword_id PRIMARY KEY (card_id, keyword_id)
);

ALTER TABLE deck 
ADD FOREIGN KEY (user_name) 
REFERENCES app_user(user_name);


ALTER TABLE card_deck
ADD FOREIGN KEY (card_id)
REFERENCES card(card_id);

ALTER TABLE card_deck
ADD FOREIGN KEY (deck_id)
REFERENCES deck(deck_id);

ALTER TABLE card_keyword 
ADD FOREIGN KEY (card_id)
REFERENCES card(card_id);

ALTER TABLE card_keyword 
ADD FOREIGN KEY (keyword_id)
REFERENCES keyword(keyword_id);

COMMIT;