-- Write queries to return the following:
-- The following changes are applied to the "pagila" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
BEGIN TRANSACTION;
INSERT INTO actor(first_name, last_name)
VALUES ('HAMPTON', 'AVENUE');
INSERT INTO actor(first_name, last_name)
VALUES ('LISA', 'BYWAY'); 
SELECT first_name, last_name FROM actor;
COMMIT;

--COMMITTED--

-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in 
-- ancient Greece", to the film table. The movie was released in 2008 in English. 
-- Since its an epic, the run length is 3hrs and 18mins. There are no special 
-- features, the film speaks for itself, and doesn't need any gimmicks.	

BEGIN TRANSACTION;
INSERT INTO film(title, description, release_year, language_id, length)
VALUES ('Euclidean PI','The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008, 1, 198);
SELECT * FROM film;
COMMIT;
--COMMITTED--


-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly 
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
BEGIN TRANSACTION;
INSERT INTO film_actor(actor_id, film_id)
VALUES (209, 1006);
INSERT INTO film_actor(actor_id, film_id)
VALUES (210, 1006);
SELECT * FROM film_actor;
COMMIT;

--COMMITTED--

-- 4. Add Mathmagical to the category table.
BEGIN TRANSACTION;
INSERT INTO category(category_id, name)
VALUES (9999, 'Mathmagical');
SELECT * FROM category;
COMMIT;

--COMMITTED--

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI", 
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"

BEGIN TRANSACTION;
INSERT INTO film_category(film_id, category_id)
VALUES (1006,9999);

UPDATE film_category
SET category_id = 9999
WHERE film_id in (274, 494, 714, 996);
SELECT * FROM film_category;
COMMIT;

--COMMITTED--

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films 
-- accordingly.
-- (5 rows affected)

BEGIN TRANSACTION;

UPDATE film
SET rating = 'G'
WHERE film_id in (SELECT film_category.film_id FROM film_category WHERE category_id = 9999);
SELECT * FROM film WHERE rating = 'G';
COMMIT;

--COMMITTED--

-- 7. Add a copy of "Euclidean PI" to all the stores.
BEGIN TRANSACTION; 

INSERT INTO inventory(film_id, store_id)
VALUES (1006, 1);
INSERT INTO inventory(film_id, store_id)
VALUES (1006, 2);

SELECT * FROM inventory;

COMMIT;

--COMMITTED--

-- 8. The Feds have stepped in and have impounded all copies of the pirated film, 
-- "Euclidean PI". The film has been seized from all stores, and needs to be 
-- deleted from the film table. Delete "Euclidean PI" from the film table. 
BEGIN TRANSACTION;

DELETE FROM film
WHERE film_id = 1006;

ROLLBACK;
-- (Did it succeed? Why?)

--No because it is a parent to several dependants and deleting the film would leave several orphans

-- 9. Delete Mathmagical from the category table. 


BEGIN TRANSACTION;

DELETE FROM category
WHERE name = 'Mathmagical';
SELECT * FROM category;
ROLLBACK;

-- (Did it succeed? Why?)

-- No because it is a parent to film_category and would leave category_id orphaned

-- 10. Delete all links to Mathmagical in the film_category tale. 


BEGIN TRANSACTION;

DELETE FROM film_category
WHERE category_id = 9999;
SELECT * FROM film;
COMMIT;

--COMMIT

-- (Did it succeed? Why?)

-- Yes because film_category has no dependents


-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI". 
BEGIN TRANSACTION;

DELETE FROM category
WHERE name = 'Mathmagical';
SELECT * FROM film;


DELETE FROM film
WHERE title = 'Euclidean PI';
SELECT * FROM film;
COMMIT;
--COMMITTED

-- (Did either deletes succeed? Why?)

-- deleting the category did because it no longer has a depndant in film_category, but could not delete the film because it has dependants in film_actor

-- 12. Check database metadata to determine all constraints of the film id, and 
-- describe any remaining adjustments needed before the film "Euclidean PI" can 
-- be removed from the film table.

--In order to remove "Euclidean PI" you would have to remove any references to it in film_actor, otherwise there would be orphans in film_actor
--You would also have to remove film_id from inventory or else it would create oprhans in inventory