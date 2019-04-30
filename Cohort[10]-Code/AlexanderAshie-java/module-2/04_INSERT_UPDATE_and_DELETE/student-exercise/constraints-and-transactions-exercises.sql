-- Write queries to return the following:
-- The following changes are applied to the "pagila" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
BEGIN TRANSACTION;
INSERT INTO actor
(actor_id, first_name, last_name)
VALUES (201, 'HAMPTON', 'AVENUE');

SELECT *
FROM actor
WHERE actor_id = 201 AND first_name = 'HAMPTON' AND last_name = 'AVENUE';
COMMIT;

BEGIN TRANSACTION;
INSERT INTO actor
(actor_id, first_name, last_name)
VALUES (202, 'LISA', 'BYWAY');

SELECT *
FROM actor
WHERE actor_id = 202 AND first_name = 'LISA' AND last_name = 'BYWAY';
COMMIT;

-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in 
-- ancient Greece", to the film table. The movie was released in 2008 in English. 
-- Since its an epic, the run length is 3hrs and 18mins. There are no special 
-- features, the film speaks for itself, and doesn't need any gimmicks.	

BEGIN TRANSACTION;
INSERT INTO film
(film_id, title, description, release_year, language_id, 
        original_language_id, rental_duration, rental_rate, length,
        replacement_cost, rating)
        
VALUES (1001, 'Euclidean PI', 'The epic story of Euclid as a pizza delivery boy in 
-- ancient Greece', 2008, (SELECT language_id FROM language WHERE name = 'English'), 
        null, 6, 4.99, 198, 19.95, 'G');

SELECT *
FROM film
WHERE film_id = 1001;

COMMIT;
        
-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly 
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.

BEGIN TRANSACTION;

INSERT INTO film_actor
(film_id, actor_id)
VALUES ((SELECT film_id FROM film WHERE title = 'Euclidean PI'), (SELECT actor_id FROM actor WHERE first_name = 'HAMPTON' AND last_name = 'AVENUE'))
;

SELECT *
FROM film_actor
WHERE film_id = (SELECT film_id FROM film WHERE title = 'Euclidean PI');

COMMIT;

BEGIN TRANSACTION;

INSERT INTO film_actor
(film_id, actor_id)
VALUES ((SELECT film_id FROM film WHERE title = 'Euclidean PI'), (SELECT actor_id FROM actor WHERE first_name = 'LISA' AND last_name = 'BYWAY'))
;

SELECT *
FROM film_actor
WHERE film_id = (SELECT film_id FROM film WHERE title = 'Euclidean PI');

COMMIT;

-- 4. Add Mathmagical to the category table.

BEGIN TRANSACTION;

INSERT INTO category
(category_id, name)
VALUES ((SELECT MAX(category_id) FROM category) + 1, 'Mathmagical');

SELECT *
FROM category
WHERE name = 'Mathmagical';

COMMIT;

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI", 
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
BEGIN TRANSACTION;

INSERT INTO film_category
(film_id, category_id)
VALUES ((SELECT film_id FROM film WHERE title = 'Euclidean PI'), (SELECT category_id FROM category WHERE name = 'Mathmagical'));

INSERT INTO film_category
(film_id, category_id)
VALUES ((SELECT film_id FROM film WHERE title = 'EGG IGBY'), (SELECT category_id FROM category WHERE name = 'Mathmagical'));

INSERT INTO film_category
(film_id, category_id)
VALUES ((SELECT film_id FROM film WHERE title = 'KARATE MOON'), (SELECT category_id FROM category WHERE name = 'Mathmagical'));

INSERT INTO film_category
(film_id, category_id)
VALUES ((SELECT film_id FROM film WHERE title = 'RANDOM GO'), (SELECT category_id FROM category WHERE name = 'Mathmagical'));

INSERT INTO film_category
(film_id, category_id)
VALUES ((SELECT film_id FROM film WHERE title = 'YOUNG LANGUAGE'), (SELECT category_id FROM category WHERE name = 'Mathmagical'));

SELECT *
FROM film_category
WHERE category_id = 17;

COMMIT;

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films 
-- accordingly.
-- (5 rows affected)

BEGIN TRANSACTION;
UPDATE film
SET rating = 'G'
WHERE film_id IN (SELECT film_id FROM film_category WHERE category_id = (SELECT category_id FROM category WHERE name = 'Mathmagical'));
COMMIT;

-- 7. Add a copy of "Euclidean PI" to all the stores.


BEGIN TRANSACTION;
INSERT INTO inventory
(inventory_id, film_id, store_id)
VALUES (4582, (SELECT film_id FROM film WHERE title = 'Euclidean PI'), 1);

INSERT INTO inventory
(inventory_id, film_id, store_id)
VALUES (4583, (SELECT film_id FROM film WHERE title = 'Euclidean PI'), 2);

SELECT store_id, inventory_id
FROM inventory;
COMMIT;

-- 8. The Feds have stepped in and have impounded all copies of the pirated film, 
-- "Euclidean PI". The film has been seized from all stores, and needs to be 
-- deleted from the film table. Delete "Euclidean PI" from the film table. 
-- (Did it succeed? Why?)
BEGIN TRANSACTION;
DELETE FROM film
WHERE title = 'Euclidean PI';
COMMIT;

--Did not succeed.  Violated foreign key constraint, aka parent child relationship, would leave orphans

-- 9. Delete Mathmagical from the category table. 
-- (Did it succeed? Why?)

BEGIN TRANSACTION;
DELETE FROM category
WHERE name = 'Mathmagical';
COMMIT;

--Did not succeed.  Violated foreign key constraint, aka parent child relationship, would leave orphans

-- 10. Delete all links to Mathmagical in the film_category tale. 
-- (Did it succeed? Why?)

BEGIN TRANSACTION;
DELETE FROM film_category
WHERE category_id = (SELECT category_id FROM category WHERE name = 'Mathmagical');
COMMIT;

--Success, did not violate foreign key constraint, and left primary key behind

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI". 
-- (Did either deletes succeed? Why?)

BEGIN TRANSACTION;
DELETE FROM category
WHERE name = 'Mathmagical';
COMMIT;

--Success, dependents were deleted first

BEGIN TRANSACTION;
DELETE FROM film
WHERE title = 'Euclidean PI';
ROLLBACK;

--No success, need to remove dependents in film actor

-- 12. Check database metadata to determine all constraints of the film id, and 
-- describe any remaining adjustments needed before the film "Euclidean PI" can 
-- be removed from the film table.

SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS

--dependents need to be removed from film_actor and actor
