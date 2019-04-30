-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;

INSERT INTO app_user(email_address, user_name, password, salt, role) VALUES ('admin@admin.com', 'admin', 'fA2hZClONO6yK7XYnpIqng==', '6FE9kAEmRRLuJLt5kj125WAjU2dk9SsboJHFV/brkoO62PigmdLAfO6BmiOSAJqLqdhSBQAbwsQAKSXH352d2OmOnDk/gOGkD/JfAPPcZ1as8i9T86SHgvLN1ZgTTkeRMh1NDPaxwSKb9DQYZr83tMXLXAHJRKhINMT+luSeYtc=', 'admin');
INSERT INTO app_user(email_address, user_name, password, salt, role) VALUES ('user@user.com', 'Demo', 'dW8RRlZm4IjKx+XNBOZqzg==', '9nNvzuzp0YWlzl6v8LhG7jjcVA1KYUJ3mHtwtphraIvv2uhSHvUGEGVUTbitzBwt8wYnIt2AEbrW4AKodpweTivowkr5HtEKT7yt9DzXmu5Z/jA5MlPD+JRy0a0TERstqYZbcfV3SgfcINoOlp34tgee5xMLx1Fnl5zhKrbBjHw=', 'user');
INSERT INTO app_user(email_address, user_name, password, salt, role) VALUES ('user@user.com', 'Test', '83eZE9AdPzxmO5ojhz/PjA==', '3Y5YS8eG80KfaPmg0IDsJp0a626SenFCCrzaSxJ6enFwFe5yM3L35SBcP6U01+SUiZEVYmzCk5po6xNKYaBrw0ZfyV6E+NmLMeOndyXSBURd5v+SPbOQ7wFLNH3V1zuzTAGE8paW7F7sZujEk5LFt+YmrnlJjtHQd1sbRAu+puk=', 'user');

INSERT INTO deck(deck_id, deck_name, deck_description, user_name, public_deck) VALUES (1, 'Quote Wall', 'An ode to the memories of the Java Cohort', 'admin', true);
INSERT INTO deck(deck_id, deck_name, deck_description, user_name, public_deck) VALUES (2, 'Demo Deck', 'This a demo deck intended to test a feature', 'Demo', false);
INSERT INTO deck(deck_id, deck_name, deck_description, user_name, public_deck) VALUES (3, 'Java', 'This deck has vocabulary and concepts about the Java language', 'admin', true);
INSERT INTO deck(deck_id, deck_name, deck_description, user_name, public_deck) VALUES (4, 'State Capitals', 'A deck of states and their capitals', 'Test', false);
INSERT INTO deck(deck_id, deck_name, deck_description, user_name, public_deck) VALUES (5, 'Country Capitals', 'A deck of countries and their capitals', 'Test', false);
INSERT INTO deck(deck_id, deck_name, deck_description, user_name, public_deck) VALUES (6, 'The Wu-Tang Clan', 'Can you name these members from the legendary Wu-Tang Clan?', 'admin', true);


INSERT INTO card(card_id, front, back) VALUES (1, 'You need to get more fruit', 'Joe'); 
INSERT INTO card(card_id, front, back) VALUES (2, 'You''ve been Scooby Doo''ed bro', 'Joe');
INSERT INTO card(card_id, front, back) VALUES (3, 'Iiiiinteresting', 'E to the Ran');
INSERT INTO card(card_id, front, back) VALUES (4, 'Write the code you wish you had', 'Joe');
INSERT INTO card(card_id, front, back) VALUES (5, 'Something to rememeber: you have to flush everytime you''re done', 'Joe');
INSERT INTO card(card_id, front, back) VALUES (6, 'I''m not saying that how I would be, but that''s exactly how I would be', 'Joe');
INSERT INTO card(card_id, front, back) VALUES (7, 'American Jean Pants', 'Nameless Equity Trust HR Guy');
INSERT INTO card(card_id, front, back) VALUES (8, 'Riddle me this', 'E to the Ran');
INSERT INTO card(card_id, front, back) VALUES (9, 'Unfortunately that''s how science works', 'Nick');
INSERT INTO card(card_id, front, back) VALUES (10, 'It''s way better having no toe nails', 'Mike');
INSERT INTO card(card_id, front, back) VALUES (11, 'What are we here for, if not to get a little Catholic', 'Bethany');
INSERT INTO card(card_id, front, back) VALUES (12, 'If you hear this, that''s the sound of your children dying', 'Austin');

INSERT INTO card(card_id, front, back) VALUES (13, 'Demo Front 1', 'Demo Back 1');
INSERT INTO card(card_id, front, back) VALUES (14, 'Demo Front 2', 'Demo Back 2');
INSERT INTO card(card_id, front, back) VALUES (15, 'Demo Front 3', 'Demo Back 3');
INSERT INTO card(card_id, front, back) VALUES (16, 'Demo Front 4', 'Demo Back 4');
INSERT INTO card(card_id, front, back) VALUES (17, 'Demo Front 5', 'Demo Back 5');

INSERT INTO card(card_id, front, back) VALUES (18, 'Assignment Statement', 'An assignment sets the value in a storage location denoted by a variable name');
INSERT INTO card(card_id, front, back) VALUES (19, 'Boolean Expression', 'An expression using comparison or logical operators and the evaluated value is a boolean result');
INSERT INTO card(card_id, front, back) VALUES (20, 'Pascal Case', 'A naming convention where the first letter starts with an upper-case letter and each subsequent word starts with a capital letter');
INSERT INTO card(card_id, front, back) VALUES (21, 'Camel Case', 'A naming convention where the first letter starts with a lower-case letter and each subsequent word starts with a capital letter');
INSERT INTO card(card_id, front, back) VALUES (22, 'Code Smell', 'A code smell is any symptom in the code of a program that possibly indicates there is a deeper problem, violation of fundamental design principles, or an impact to design quality. Duplicate code is often an indication of a code smell');
INSERT INTO card(card_id, front, back) VALUES (23, 'Constant', 'A constant is a value that cannot be altered during execution of the program');
INSERT INTO card(card_id, front, back) VALUES (24, 'Constructor', 'A constructor is a special method of a class that initializes an object of that type. Constructors have the same name as the class and can be used to set the values to default values or user-defined values');
INSERT INTO card(card_id, front, back) VALUES (25, 'Declaration Statement', 'A declaration statement introduces a new variable by providing a data type and a name that it can be referenced by');
INSERT INTO card(card_id, front, back) VALUES (26, 'Exception', 'An anomaly or exceptional condition that requires special processing');
INSERT INTO card(card_id, front, back) VALUES (27, 'Instantiate', 'Instantiation is the creation of an instance of an object from a template such as a class');
INSERT INTO card(card_id, front, back) VALUES (28, 'Integrated Development Environment (IDE)', 'A software application that unifies several programming tools commonly used by programmers to develop software. An IDE normally consists of a source code editor with intelligent code completion, build and run automation, and a debugger');
INSERT INTO card(card_id, front, back) VALUES (29, 'Interfaces', 'An interface is a contract. It specifies how a software component could be used by indicating what behavior it needs to implement but not how');
INSERT INTO card(card_id, front, back) VALUES (30, 'Layer of Abstraction', 'A concept that sits on top of a more basic concept that makes is easier to solve problems. For example, a programming language like Java or C# is a layer of abstraction on top of the C programming language. C, in turn, is a layer of abstraction on top of the underlying CPU and hardware the program is running on');
INSERT INTO card(card_id, front, back) VALUES (31, 'Scope', 'Scope refers to the visibility of variables. If code can access a variable, it is in scope. If code cannot access a variable, it is out of scope');
INSERT INTO card(card_id, front, back) VALUES (32, 'Loosely Coupled', 'Loose coupling reduces the dependencies that one class has on another so that it depends on it to the least extent possible');
INSERT INTO card(card_id, front, back) VALUES (33, 'Method Signature', 'Part of the method declaration that indicates the return type, name of the method, and input parameters');
INSERT INTO card(card_id, front, back) VALUES (34, 'Overloaded Method', 'Method overloading allows a class to have several methods with the same name for flexibility. In order for it to be valid though, the parameter signatures must be different between each overloaded method');
INSERT INTO card(card_id, front, back) VALUES (35, 'Tightly Coupled', 'Tightly coupled code tends to make changes in one module have a ripple effect throughout the other modules due to inter-module dependency. Tightly coupled code is not flexible');

INSERT INTO card(card_id, front, back) VALUES (36, 'Alabama', 'Montgomery');
INSERT INTO card(card_id, front, back) VALUES (37, 'Arkansas', 'Little Rock');
INSERT INTO card(card_id, front, back) VALUES (38, 'Delaware', 'Dover');
INSERT INTO card(card_id, front, back) VALUES (39, 'Kansas', 'Topeka');
INSERT INTO card(card_id, front, back) VALUES (40, 'Maine', 'Augusta');
INSERT INTO card(card_id, front, back) VALUES (41, 'Minnesota', 'St. Paul');
INSERT INTO card(card_id, front, back) VALUES (42, 'Montana', 'Helena');
INSERT INTO card(card_id, front, back) VALUES (43, 'New Hampshire', 'Concord');
INSERT INTO card(card_id, front, back) VALUES (44, 'North Dakota', 'Bismark');
INSERT INTO card(card_id, front, back) VALUES (45, 'South Dakota', 'Pierre');

INSERT INTO card(card_id, front, back) VALUES (46, 'Albania', 'Tirana');
INSERT INTO card(card_id, front, back) VALUES (47, 'Australia', 'Canberra');
INSERT INTO card(card_id, front, back) VALUES (48, 'Greece', 'Athens');
INSERT INTO card(card_id, front, back) VALUES (49, 'Chile', 'Santiago');
INSERT INTO card(card_id, front, back) VALUES (50, 'Finland', 'Helsinki');
INSERT INTO card(card_id, front, back) VALUES (51, 'Haiti', 'Port Au Prince');
INSERT INTO card(card_id, front, back) VALUES (52, 'Jamaica', 'Kingston');
INSERT INTO card(card_id, front, back) VALUES (53, 'Malaysia', 'Kuala Lumpur');
INSERT INTO card(card_id, front, back) VALUES (54, 'New Zealand', 'Wellington');
INSERT INTO card(card_id, front, back) VALUES (55, 'Norway', 'Oslo');

INSERT INTO card(card_id, front, back) VALUES(56, 'He is the primary producer for the Wu-Tang Clan and is one of its founding members', 'The RZA');
INSERT INTO card(card_id, front, back) VALUES(57, 'Also known as Genius, this Wu-Tang member is a chess grand master', 'The GZA');
INSERT INTO card(card_id, front, back) VALUES(58, 'An avid comic book fan, this Wu-Tang member often goes by the nickname Tony Starks', 'GhostFace Killah');
INSERT INTO card(card_id, front, back) VALUES(59, 'He collaborated with artists 7L & Esoteric to form the supergroup CZARFACE'  , 'Inspectah Deck');
INSERT INTO card(card_id, front, back) VALUES(60, 'This Wu-Tang member was an actor in both The Wire and The Deuce', 'Method Man');
INSERT INTO card(card_id, front, back) VALUES(61, 'Also known as The Chef, this Wu-Tang member was iconically in the Wu-Tang Torture skit along side Method Man', 'Raekwon');
INSERT INTO card(card_id, front, back) VALUES(62, 'Fellow members referred to his technique as ''No Father to his Style''. He tragically passed away in 2004', 'ODB');
INSERT INTO card(card_id, front, back) VALUES(63, 'This lesser known Wu-Tang member got his name from the film "36 Chambers of Shaolin"', 'Masta Killa');
INSERT INTO card(card_id, front, back) VALUES(64, 'This Wu-Tang member, who often avoids the spotlight, originally went under the pseudonym ''Golden Arms''', 'U-God');
INSERT INTO card(card_id, front, back) VALUES(65, 'This artist is technically not a member of the Wu-Tang Clan but he has still being featured on ever major Wu release', 'Cappadonna');


INSERT INTO card_deck(card_id, deck_id) VALUES (1,1);
INSERT INTO card_deck(card_id, deck_id) VALUES (2,1);
INSERT INTO card_deck(card_id, deck_id) VALUES (3,1);
INSERT INTO card_deck(card_id, deck_id) VALUES (4,1);
INSERT INTO card_deck(card_id, deck_id) VALUES (5,1);
INSERT INTO card_deck(card_id, deck_id) VALUES (6,1);
INSERT INTO card_deck(card_id, deck_id) VALUES (7,1);
INSERT INTO card_deck(card_id, deck_id) VALUES (8,1);
INSERT INTO card_deck(card_id, deck_id) VALUES (9,1);
INSERT INTO card_deck(card_id, deck_id) VALUES (10,1);
INSERT INTO card_deck(card_id, deck_id) VALUES (11,1);
INSERT INTO card_deck(card_id, deck_id) VALUES (12,1);

INSERT INTO card_deck(card_id, deck_id) VALUES (13,2);
INSERT INTO card_deck(card_id, deck_id) VALUES (14,2);
INSERT INTO card_deck(card_id, deck_id) VALUES (15,2);
INSERT INTO card_deck(card_id, deck_id) VALUES (16,2);
INSERT INTO card_deck(card_id, deck_id) VALUES (17,2);

INSERT INTO card_deck(card_id, deck_id) VALUES (18,3);
INSERT INTO card_deck(card_id, deck_id) VALUES (19,3);
INSERT INTO card_deck(card_id, deck_id) VALUES (20,3);
INSERT INTO card_deck(card_id, deck_id) VALUES (21,3);
INSERT INTO card_deck(card_id, deck_id) VALUES (22,3);
INSERT INTO card_deck(card_id, deck_id) VALUES (23,3);
INSERT INTO card_deck(card_id, deck_id) VALUES (24,3);
INSERT INTO card_deck(card_id, deck_id) VALUES (25,3);
INSERT INTO card_deck(card_id, deck_id) VALUES (26,3);
INSERT INTO card_deck(card_id, deck_id) VALUES (27,3);
INSERT INTO card_deck(card_id, deck_id) VALUES (28,3);
INSERT INTO card_deck(card_id, deck_id) VALUES (29,3);
INSERT INTO card_deck(card_id, deck_id) VALUES (30,3);
INSERT INTO card_deck(card_id, deck_id) VALUES (31,3);
INSERT INTO card_deck(card_id, deck_id) VALUES (32,3);
INSERT INTO card_deck(card_id, deck_id) VALUES (33,3);
INSERT INTO card_deck(card_id, deck_id) VALUES (34,3);
INSERT INTO card_deck(card_id, deck_id) VALUES (35,3);

INSERT INTO card_deck(card_id, deck_id) VALUES (36,4);
INSERT INTO card_deck(card_id, deck_id) VALUES (37,4);
INSERT INTO card_deck(card_id, deck_id) VALUES (38,4);
INSERT INTO card_deck(card_id, deck_id) VALUES (39,4);
INSERT INTO card_deck(card_id, deck_id) VALUES (40,4);
INSERT INTO card_deck(card_id, deck_id) VALUES (41,4);
INSERT INTO card_deck(card_id, deck_id) VALUES (42,4);
INSERT INTO card_deck(card_id, deck_id) VALUES (43,4);
INSERT INTO card_deck(card_id, deck_id) VALUES (44,4);
INSERT INTO card_deck(card_id, deck_id) VALUES (45,4);

INSERT INTO card_deck(card_id, deck_id) VALUES (46,5);
INSERT INTO card_deck(card_id, deck_id) VALUES (47,5);
INSERT INTO card_deck(card_id, deck_id) VALUES (48,5);
INSERT INTO card_deck(card_id, deck_id) VALUES (49,5);
INSERT INTO card_deck(card_id, deck_id) VALUES (50,5);
INSERT INTO card_deck(card_id, deck_id) VALUES (51,5);
INSERT INTO card_deck(card_id, deck_id) VALUES (52,5);
INSERT INTO card_deck(card_id, deck_id) VALUES (53,5);
INSERT INTO card_deck(card_id, deck_id) VALUES (54,5);
INSERT INTO card_deck(card_id, deck_id) VALUES (55,5);

INSERT INTO card_deck(card_id, deck_id) VALUES (56,6);
INSERT INTO card_deck(card_id, deck_id) VALUES (57,6);
INSERT INTO card_deck(card_id, deck_id) VALUES (58,6);
INSERT INTO card_deck(card_id, deck_id) VALUES (59,6);
INSERT INTO card_deck(card_id, deck_id) VALUES (60,6);
INSERT INTO card_deck(card_id, deck_id) VALUES (61,6);
INSERT INTO card_deck(card_id, deck_id) VALUES (62,6);
INSERT INTO card_deck(card_id, deck_id) VALUES (63,6);
INSERT INTO card_deck(card_id, deck_id) VALUES (64,6);


INSERT INTO keyword(keyword_id, keyword) VALUES (1, 'Quote Wall');
INSERT INTO keyword(keyword_id, keyword) VALUES (4, 'Public Keyword');
INSERT INTO keyword(keyword_id, keyword) VALUES (2, 'Demo Keyword1');
INSERT INTO keyword(keyword_id, keyword) VALUES (3, 'Demo Keyword 2');
INSERT INTO keyword(keyword_id, keyword) VALUES (5, 'Methods');
INSERT INTO keyword(keyword_id, keyword) VALUES (6, 'Capitals');
INSERT INTO keyword(keyword_id, keyword) VALUES (7, 'Music');

INSERT INTO card_keyword(card_id, keyword_id) VALUES (1, 1);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (2, 1);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (3, 1);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (4, 1);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (5, 1);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (4, 4);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (5, 5);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (6, 1);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (7, 1);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (8, 1);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (9, 1);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (10, 4);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (11, 4);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (12, 4);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (13, 2);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (14, 3);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (15, 2);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (16, 3);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (17, 2);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (24, 5);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (33, 5);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (34, 5);

INSERT INTO card_keyword(card_id, keyword_id) VALUES (36, 6);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (37, 6);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (38, 6);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (39, 6);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (40, 6);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (41, 6);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (42, 6);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (43, 6);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (44, 6);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (45, 6);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (46, 6);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (47, 6);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (48, 6);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (49, 6);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (50, 6);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (51, 6);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (52, 6);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (53, 6);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (54, 6);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (55, 6);

INSERT INTO card_keyword(card_id, keyword_id) VALUES (56, 7);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (57, 7);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (58, 7);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (59, 7);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (60, 7);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (61, 7);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (62, 7);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (63, 7);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (64, 7);
INSERT INTO card_keyword(card_id, keyword_id) VALUES (65, 7);

ALTER SEQUENCE deck_deck_id_seq RESTART WITH 7;

ALTER SEQUENCE card_card_id_seq RESTART WITH 66;


ALTER SEQUENCE keyword_keyword_id_seq RESTART WITH 8;

COMMIT;