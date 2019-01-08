DROP TABLE IF EXISTS ingredients;
DROP TABLE IF EXISTS recipes;

CREATE TABLE recipes (
	id serial PRIMARY KEY,
	name varchar(255) NOT NULL,
	duration_in_minutes int NOT NULL,
	description text
);

CREATE TABLE ingredients (
	id serial PRIMARY KEY,
	recipe_id int NOT NULL REFERENCES recipes(id),
	type varchar(255) NOT NULL,
	quantity varchar(255) NOT NULL
);