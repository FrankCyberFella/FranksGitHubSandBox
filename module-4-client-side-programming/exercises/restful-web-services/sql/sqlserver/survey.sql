BEGIN TRANSACTION;

CREATE TABLE survey (
    survey_id integer identity NOT NULL,
    name varchar(128),
    description text,
    CONSTRAINT pk_survey_survey_id PRIMARY KEY(survey_id)
);

CREATE TABLE options (
    survey_id integer NOT NULL,
    opt_num integer NOT NULL,
    description varchar(128),
    CONSTRAINT pk_options_survey_id_opt_num PRIMARY KEY(survey_id, opt_num),
    CONSTRAINT fk_options_survey_id FOREIGN KEY(survey_id) REFERENCES survey(survey_id)
);

CREATE TABLE vote (
    vote_id integer identity NOT NULL,
    survey_id integer NOT NULL,
    opt_num integer NOT NULL,
    CONSTRAINT fk_vote_survey_id_opt_num FOREIGN KEY(survey_id, opt_num) REFERENCES options(survey_id, opt_num)
);

-- SURVEY

INSERT INTO survey(name, description)
VALUES('Favorite Coding Language','What is your favorite language to write code in?');

INSERT INTO survey(name, description)
VALUES('Best Snacks','Which snack do you reach for first to fuel your marathon coding sessions?');

INSERT INTO survey(name, description)
VALUES('Pair Programming With The Stars','If given the chance, who would you most like to pair program with?');

INSERT INTO survey(name, description)
VALUES('Most Diabolical Coding Exercise','Which of the following coding exercises is the one you most love to hate?');

-- options

INSERT INTO options(survey_id, opt_num, description)
VALUES(1, 1, 'C#');

INSERT INTO options(survey_id, opt_num, description)
VALUES(1, 2, 'CSS');

INSERT INTO options(survey_id, opt_num, description)
VALUES(1, 3, 'HTML');

INSERT INTO options(survey_id, opt_num, description)
VALUES(1, 4, 'Java');

INSERT INTO options(survey_id, opt_num, description)
VALUES(1, 5, 'Javascript');

INSERT INTO options(survey_id, opt_num, description)
VALUES(1, 6, 'Pseudo Code');

INSERT INTO options(survey_id, opt_num, description)
VALUES(1, 7, 'SQL');

INSERT INTO options(survey_id, opt_num, description)
VALUES(2, 1, 'Animal Crackers');

INSERT INTO options(survey_id, opt_num, description)
VALUES(2, 2, 'Candy');

INSERT INTO options(survey_id, opt_num, description)
VALUES(2, 3, 'Cookies');

INSERT INTO options(survey_id, opt_num, description)
VALUES(2, 4, 'Mixed Nuts');

INSERT INTO options(survey_id, opt_num, description)
VALUES(2, 5, 'Pretzels');

INSERT INTO options(survey_id, opt_num, description)
VALUES(3, 1, 'Ada Lovelace');

INSERT INTO options(survey_id, opt_num, description)
VALUES(3, 2, 'Bill Gates');

INSERT INTO options(survey_id, opt_num, description)
VALUES(3, 3, 'David Wintrich');

INSERT INTO options(survey_id, opt_num, description)
VALUES(3, 4, 'Grace Hopper');

INSERT INTO options(survey_id, opt_num, description)
VALUES(3, 5, 'James Gosling');

INSERT INTO options(survey_id, opt_num, description)
VALUES(3, 6, 'Josh Tucholski');

INSERT INTO options(survey_id, opt_num, description)
VALUES(3, 7, 'Steve Wozniak');

INSERT INTO options(survey_id, opt_num, description)
VALUES(4, 1, 'Hello, World');

INSERT INTO options(survey_id, opt_num, description)
VALUES(4, 2, 'Fibonacci');

INSERT INTO options(survey_id, opt_num, description)
VALUES(4, 3, 'FizzBuzz');

INSERT INTO options(survey_id, opt_num, description)
VALUES(4, 4, 'Squirrel Party');

COMMIT;