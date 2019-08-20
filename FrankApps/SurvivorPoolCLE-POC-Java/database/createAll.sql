BEGIN TRANSACTION;
--ALL
DROP TABLE IF EXISTS castmembers cascade;
DROP TABLE IF EXISTS gameoptions cascade;
DROP TABLE IF EXISTS games       cascade;
DROP TABLE IF EXISTS gamesinplay cascade;
DROP TABLE IF EXISTS players     cascade;
DROP TABLE IF EXISTS seasons     cascade;
DROP TABLE IF EXISTS survivors   cascade;
DROP TABLE IF EXISTS tribes      cascade;

CREATE TABLE castmembers 
( seasonid      SMALLINT NOT NULL
, survivorid    SMALLINT NOT NULL
, dayvotedout   SMALLINT
, originaltribe SMALLINT
, currenttribe  SMALLINT
, secondtribe   SMALLINT
, thirdtribe    SMALLINT
, fourthtribe   SMALLINT
, PRIMARY KEY (seasonid, survivorid)
);
--
CREATE TABLE gameoptions 
( gameoptionid  SERIAL   NOT NULL
, name          TEXT     NOT NULL
, amount        SMALLINT NOT NULL
, type          TEXT     NOT NULL
, PRIMARY KEY (gameoptionid)
);
--
CREATE TABLE gamesinplay 
( gameid        SMALLINT NOT NULL
, seasonid      SMALLINT NOT NULL
, gameoptionid  SMALLINT NOT NULL
, playerid      SMALLINT NOT NULL
, survivor      SMALLINT
, PRIMARY KEY (gameid, seasonid, playerid)
);
-- 
CREATE TABLE games 
( gameid        SERIAL   NOT NULL
, seasonid      SMALLINT NOT NULL
, gameoptionid  SMALLINT NOT NULL
, maxplayers    SMALLINT NOT NULL
, PRIMARY KEY (gameid, seasonid, gameoptionid)
);
-- 
CREATE TABLE players 
( playerid       SERIAL NOT NULL
, firstname      TEXT   NOT NULL
, lastname       TEXT   
, email          TEXT
, mailingaddress TEXT
, cellphone      TEXT
, workphone      TEXT
, homephone      TEXT
, PRIMARY KEY (playerid)
);
--
CREATE TABLE seasons 
( seasonid         SMALLINT NOT NULL
, seasonname       TEXT
, location         TEXT
, seasonstartdate  DATE
, seasonenddate    DATE
, winnersurvivorid SMALLINT
, PRIMARY KEY (seasonid)
);
-- 
CREATE TABLE survivors 
( survivorid    SERIAL NOT NULL
, firstname     TEXT   NOT NULL
, lastname      TEXT   NOT NULL
, occupation    TEXT
, homecity      TEXT
, age           SMALLINT
, nickname      TEXT
, comments      TEXT
, PRIMARY KEY(survivorid)
);
-- 
CREATE TABLE tribes 
( tribeid SERIAL NOT NULL
, seasonid SMALLINT
, tribename TEXT
, daycreated SMALLINT
, PRIMARY KEY (tribeid)
);
--
INSERT INTO castmembers (seasonid, survivorid, dayvotedout, originaltribe, currenttribe, secondtribe, thirdtribe, fourthtribe) VALUES (37, 1, 3, '1', '6', null, null, null);
INSERT INTO castmembers (seasonid, survivorid, dayvotedout, originaltribe, currenttribe, secondtribe, thirdtribe, fourthtribe) VALUES (37, 3, 9, '2', '6', null, null, null);
INSERT INTO castmembers (seasonid, survivorid, dayvotedout, originaltribe, currenttribe, secondtribe, thirdtribe, fourthtribe) VALUES (37, 4, 10, '1', '6', null, null, null);
INSERT INTO castmembers (seasonid, survivorid, dayvotedout, originaltribe, currenttribe, secondtribe, thirdtribe, fourthtribe) VALUES (37, 5, 11, '2', '6', '4', null, null);
INSERT INTO castmembers (seasonid, survivorid, dayvotedout, originaltribe, currenttribe, secondtribe, thirdtribe, fourthtribe) VALUES (37, 6, 15, '2', '6', '3', null, null);
INSERT INTO castmembers (seasonid, survivorid, dayvotedout, originaltribe, currenttribe, secondtribe, thirdtribe, fourthtribe) VALUES (37, 7, 17, '1', '6', '3', null, null);
INSERT INTO castmembers (seasonid, survivorid, dayvotedout, originaltribe, currenttribe, secondtribe, thirdtribe, fourthtribe) VALUES (37, 8, 20, '1', '6', '4', null, null);
INSERT INTO castmembers (seasonid, survivorid, dayvotedout, originaltribe, currenttribe, secondtribe, thirdtribe, fourthtribe) VALUES (37, 9, 22, '2', '6', '5', null, null);
INSERT INTO castmembers (seasonid, survivorid, dayvotedout, originaltribe, currenttribe, secondtribe, thirdtribe, fourthtribe) VALUES (37, 10, 25, '2', '6', '5', null, null);
INSERT INTO castmembers (seasonid, survivorid, dayvotedout, originaltribe, currenttribe, secondtribe, thirdtribe, fourthtribe) VALUES (37, 11, null, '1', '6', '4', null, null);
INSERT INTO castmembers (seasonid, survivorid, dayvotedout, originaltribe, currenttribe, secondtribe, thirdtribe, fourthtribe) VALUES (37, 12, null, '1', '6', '5', null, null);
INSERT INTO castmembers (seasonid, survivorid, dayvotedout, originaltribe, currenttribe, secondtribe, thirdtribe, fourthtribe) VALUES (37, 13, null, '2', '6', '4', null, null);
INSERT INTO castmembers (seasonid, survivorid, dayvotedout, originaltribe, currenttribe, secondtribe, thirdtribe, fourthtribe) VALUES (37, 14, null, '2', '6', '3', null, null);
INSERT INTO castmembers (seasonid, survivorid, dayvotedout, originaltribe, currenttribe, secondtribe, thirdtribe, fourthtribe) VALUES (37, 15, null, '1', '6', '4', null, null);
INSERT INTO castmembers (seasonid, survivorid, dayvotedout, originaltribe, currenttribe, secondtribe, thirdtribe, fourthtribe) VALUES (37, 16, null, '1', '6', '5', null, null);
INSERT INTO castmembers (seasonid, survivorid, dayvotedout, originaltribe, currenttribe, secondtribe, thirdtribe, fourthtribe) VALUES (37, 17, null, '2', '6', '5', null, null);
INSERT INTO castmembers (seasonid, survivorid, dayvotedout, originaltribe, currenttribe, secondtribe, thirdtribe, fourthtribe) VALUES (37, 18, null, '1', '6', '4', null, null);
INSERT INTO castmembers (seasonid, survivorid, dayvotedout, originaltribe, currenttribe, secondtribe, thirdtribe, fourthtribe) VALUES (37, 19, null, '2', '6', '3', null, null);
INSERT INTO castmembers (seasonid, survivorid, dayvotedout, originaltribe, currenttribe, secondtribe, thirdtribe, fourthtribe) VALUES (37, 20, null, '1', '6', '3', null, null);
INSERT INTO castmembers (seasonid, survivorid, dayvotedout, originaltribe, currenttribe, secondtribe, thirdtribe, fourthtribe) VALUES (37, 2, 6, '1', '6', null, null, null);
--
INSERT INTO gameoptions (gameoptionid, name, amount, type) VALUES (1, 'Pickem', 20, 'Pickem');
INSERT INTO gameoptions (gameoptionid, name, amount, type) VALUES (2, 'Pickem', 10, 'Pickem');
INSERT INTO gameoptions (gameoptionid, name, amount, type) VALUES (3, 'JV', 20, 'Random');
INSERT INTO gameoptions (gameoptionid, name, amount, type) VALUES (4, 'JV', 20, 'Draft');
INSERT INTO gameoptions (gameoptionid, name, amount, type) VALUES (5, 'PickEm', 5, 'PickEm');
INSERT INTO gameoptions (gameoptionid, name, amount, type) VALUES (6, 'JV', 10, 'Draft');
INSERT INTO gameoptions (gameoptionid, name, amount, type) VALUES (7, 'JV', 5, 'Random');
INSERT INTO gameoptions (gameoptionid, name, amount, type) VALUES (8, 'JV', 5, 'Draft');
INSERT INTO gameoptions (gameoptionid, name, amount, type) VALUES (9, 'Varsity', 20, 'Draft');
INSERT INTO gameoptions (gameoptionid, name, amount, type) VALUES (10, 'JV', 10, 'Random');
INSERT INTO gameoptions (gameoptionid, name, amount, type) VALUES (11, 'Varsity', 10, 'Draft');
INSERT INTO gameoptions (gameoptionid, name, amount, type) VALUES (12, 'Varsity', 5, 'Draft');
INSERT INTO gameoptions (gameoptionid, name, amount, type) VALUES (13, 'Varsity', 20, 'Random');
INSERT INTO gameoptions (gameoptionid, name, amount, type) VALUES (14, 'Varisty', 10, 'Random');
INSERT INTO gameoptions (gameoptionid, name, amount, type) VALUES (15, 'Varsity', 5, 'Random');
--
INSERT INTO games (gameid, seasonid, gameoptionid, maxplayers) VALUES ( 2, 37, 6, 18);
INSERT INTO games (gameid, seasonid, gameoptionid, maxplayers) VALUES ( 3, 37, 8, 18);
INSERT INTO games (gameid, seasonid, gameoptionid, maxplayers) VALUES ( 4, 37, 11, 18);
INSERT INTO games (gameid, seasonid, gameoptionid, maxplayers) VALUES ( 5, 37, 12, 18);
INSERT INTO games (gameid, seasonid, gameoptionid, maxplayers) VALUES ( 6, 37, 15, 20);
INSERT INTO games (gameid, seasonid, gameoptionid, maxplayers) VALUES ( 7, 37, 2, 99);
INSERT INTO games (gameid, seasonid, gameoptionid, maxplayers) VALUES ( 8, 37, 14, 20);
INSERT INTO games (gameid, seasonid, gameoptionid, maxplayers) VALUES ( 9, 37, 10, 20);
INSERT INTO games (gameid, seasonid, gameoptionid, maxplayers) VALUES (10, 37, 7, 20);
-- 
INSERT INTO gamesinplay (gameid, seasonid, gameoptionid, playerid, survivor) VALUES ( 2, 37, 6,   3, 3);
INSERT INTO gamesinplay (gameid, seasonid, gameoptionid, playerid, survivor) VALUES ( 3, 37, 8,   6, 4);
INSERT INTO gamesinplay (gameid, seasonid, gameoptionid, playerid, survivor) VALUES ( 4, 37, 11, 23, 8);
INSERT INTO gamesinplay (gameid, seasonid, gameoptionid, playerid, survivor) VALUES ( 5, 37, 12, 10, 5);
INSERT INTO gamesinplay (gameid, seasonid, gameoptionid, playerid, survivor) VALUES ( 6, 37, 15, 51, 19);
INSERT INTO gamesinplay (gameid, seasonid, gameoptionid, playerid, survivor) VALUES ( 7, 37, 2,  34, 6);
INSERT INTO gamesinplay (gameid, seasonid, gameoptionid, playerid, survivor) VALUES ( 8, 37, 14, 35, 1);
INSERT INTO gamesinplay (gameid, seasonid, gameoptionid, playerid, survivor) VALUES ( 9, 37, 10, 14, 12);
INSERT INTO gamesinplay (gameid, seasonid, gameoptionid, playerid, survivor) VALUES (10, 37,  7, 33, 14);
--
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (2, 'Cathryn', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (3, 'Alex', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (4, 'Bethany', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (5, 'Carl', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (6, 'Gary', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (7, 'Vito', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (8, 'Sonny', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (9, 'Fortunato', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (10, 'Serafino', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (11, 'Rosario', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (12, 'Maria', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (13, 'Sheldon', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (14, 'Howard', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (15, 'Penny', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (16, 'Bernadette', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (17, 'Stuart', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (18, 'Angelina', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (19, 'Gene', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (20, 'Leonard', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (21, 'Tom', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (22, 'Zack', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (23, 'Anthony', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (24, 'Danielle', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (25, 'Alyssa', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (26, 'Abby', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (27, 'Rochelle', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (28, 'Heather', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (29, 'Nick', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (30, 'Brian', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (31, 'Matt', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (32, 'Evan', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (33, 'Glen', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (34, 'Joon', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (35, 'Jordan', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (36, 'Joe', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (37, 'Bryan', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (38, 'Dan', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (39, 'Josh', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (40, 'Craig', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (41, 'David', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (42, 'James', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (43, 'Frank', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (44, 'Lydia', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (45, 'Lisa', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (46, 'Kelly', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (47, 'Marty', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (48, 'Carol', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (49, 'Brett', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (50, 'Bridget', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (51, 'Bill', null, null, null, null, null, null);
INSERT INTO players (playerid, firstname, lastname, email, mailingaddress, cellphone, workphone, homephone) VALUES (1, 'Pete', null, null, null, null, null, null);
--
INSERT INTO seasons (seasonid, seasonname, location, seasonstartdate, seasonenddate, winnersurvivorid) VALUES (35, 'Heroes vs. Healers vs. Hustlers', 'Fiji', '2017-09-27', '2017-12-20', null);
INSERT INTO seasons (seasonid, seasonname, location, seasonstartdate, seasonenddate, winnersurvivorid) VALUES (36, 'Ghost Island', 'Fiji', '2018-02-28', '2018-05-22', null);
INSERT INTO seasons (seasonid, seasonname, location, seasonstartdate, seasonenddate, winnersurvivorid) VALUES (38, 'Edge of Extinction', 'Fiji', null, null, null);
INSERT INTO seasons (seasonid, seasonname, location, seasonstartdate, seasonenddate, winnersurvivorid) VALUES (37, 'David vs Goliath', 'Fiji', '2018-09-26', '2018-12-19', null);
--
INSERT INTO survivors (survivorid, firstname, lastname, occupation, homecity, age, nickname, comments) VALUES (1, 'Pat', 'Cusack', null, 'Watervliet, NY', 40, null, null);
INSERT INTO survivors (survivorid, firstname, lastname, occupation, homecity, age, nickname, comments) VALUES (2, 'Jessica', 'Peet', null, 'Lakeland, FL', 19, null, null);
INSERT INTO survivors (survivorid, firstname, lastname, occupation, homecity, age, nickname, comments) VALUES (3, 'Jeremy', 'Crawford', null, 'New York City, NY', 40, null, null);
INSERT INTO survivors (survivorid, firstname, lastname, occupation, homecity, age, nickname, comments) VALUES (4, 'Bi', 'Nguyen', null, 'Houston, TX', 28, null, null);
INSERT INTO survivors (survivorid, firstname, lastname, occupation, homecity, age, nickname, comments) VALUES (5, 'Natalia', 'Azoqa', null, 'Irvine, CA', 25, null, null);
INSERT INTO survivors (survivorid, firstname, lastname, occupation, homecity, age, nickname, comments) VALUES (6, 'Natalie', 'Cole', null, 'Los Angeles, CA', 57, null, null);
INSERT INTO survivors (survivorid, firstname, lastname, occupation, homecity, age, nickname, comments) VALUES (7, 'Lyrsa', 'Torres', null, 'Boston, MA', 36, null, null);
INSERT INTO survivors (survivorid, firstname, lastname, occupation, homecity, age, nickname, comments) VALUES (8, 'Elizabeth', 'Olson', null, 'Longview, TX', 31, null, null);
INSERT INTO survivors (survivorid, firstname, lastname, occupation, homecity, age, nickname, comments) VALUES (9, 'John', 'Hennigan', null, 'Los Angeles, CA', 38, null, null);
INSERT INTO survivors (survivorid, firstname, lastname, occupation, homecity, age, nickname, comments) VALUES (10, 'Dan', 'Rengering', null, 'Gainesville, FL', 27, null, null);
INSERT INTO survivors (survivorid, firstname, lastname, occupation, homecity, age, nickname, comments) VALUES (11, 'Carl', 'Boudreaux', null, 'Houston, TX', 41, null, null);
INSERT INTO survivors (survivorid, firstname, lastname, occupation, homecity, age, nickname, comments) VALUES (12, 'Christian', 'Hubicki', null, 'Tallahassee, FL', 32, null, null);
INSERT INTO survivors (survivorid, firstname, lastname, occupation, homecity, age, nickname, comments) VALUES (13, 'Kara', 'Kay', null, 'San Diego, CA', 30, null, null);
INSERT INTO survivors (survivorid, firstname, lastname, occupation, homecity, age, nickname, comments) VALUES (14, 'Angelina', 'Keeley', null, 'San Clemente, CA', 28, null, null);
INSERT INTO survivors (survivorid, firstname, lastname, occupation, homecity, age, nickname, comments) VALUES (15, 'Alec', 'Merlino', null, 'San Clemente, CA', 24, null, null);
INSERT INTO survivors (survivorid, firstname, lastname, occupation, homecity, age, nickname, comments) VALUES (16, 'Gabby', 'Pascuzzi', null, 'Denver, CO', 25, null, null);
INSERT INTO survivors (survivorid, firstname, lastname, occupation, homecity, age, nickname, comments) VALUES (17, 'Alison', 'Raybould', null, 'Chapel Hill, NC', 28, null, null);
INSERT INTO survivors (survivorid, firstname, lastname, occupation, homecity, age, nickname, comments) VALUES (18, 'Davie', 'Rickenbacker', null, 'Atlanta, GA', 30, null, null);
INSERT INTO survivors (survivorid, firstname, lastname, occupation, homecity, age, nickname, comments) VALUES (19, 'Mike', 'White', null, 'Los Angeles, CA', 47, null, null);
INSERT INTO survivors (survivorid, firstname, lastname, occupation, homecity, age, nickname, comments) VALUES (20, 'Nick', 'Wilson', null, 'Williamsburg, KY', 27, null, null);
--
INSERT INTO tribes (tribeid, seasonid, tribename, daycreated) VALUES (1, 37, 'David', 1);
INSERT INTO tribes (tribeid, seasonid, tribename, daycreated) VALUES (2, 37, 'Goliath', 1);
INSERT INTO tribes (tribeid, seasonid, tribename, daycreated) VALUES (3, 37, 'Jabeni', 10);
INSERT INTO tribes (tribeid, seasonid, tribename, daycreated) VALUES (4, 37, 'Vuku', 10);
INSERT INTO tribes (tribeid, seasonid, tribename, daycreated) VALUES (5, 37, 'Tiva', 10);
INSERT INTO tribes (tribeid, seasonid, tribename, daycreated) VALUES (6, 37, 'Kolakola', 18);

ALTER TABLE gamesinplay   ADD FOREIGN KEY(playerid)      REFERENCES players(playerid);
ALTER TABLE gamesinplay   ADD FOREIGN KEY(gameid, seasonid, gameoptionid) 
                                                         REFERENCES games(gameid, seasonid, gameoptionid);
ALTER TABLE gamesinplay   ADD FOREIGN KEY(seasonid)      REFERENCES seasons(seasonid);

ALTER TABLE games         ADD FOREIGN KEY(seasonid)      REFERENCES seasons(seasonid);
ALTER TABLE games         ADD FOREIGN KEY(gameoptionid)  REFERENCES gameoptions(gameoptionid);

ALTER TABLE castmembers   ADD FOREIGN KEY(seasonid)      REFERENCES seasons(seasonid);
ALTER TABLE castmembers   ADD FOREIGN KEY(survivorid)    REFERENCES survivors(survivorid);
ALTER TABLE castmembers   ADD FOREIGN KEY(originaltribe) REFERENCES tribes(tribeid);
ALTER TABLE castmembers   ADD FOREIGN KEY(currenttribe)  REFERENCES tribes(tribeid);
ALTER TABLE castmembers   ADD FOREIGN KEY(secondtribe)   REFERENCES tribes(tribeid);
ALTER TABLE castmembers   ADD FOREIGN KEY(thirdtribe)    REFERENCES tribes(tribeid);
ALTER TABLE castmembers   ADD FOREIGN KEY(fourthtribe)   REFERENCES tribes(tribeid);

ALTER TABLE tribes        ADD FOREIGN KEY(seasonid)      REFERENCES seasons(seasonid);

--ROLLBACK;
COMMIT;