-- Write queries to return the following:
-- The following changes are applied to the "pagila" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.

BEGIN TRANSACTION;
INSERT INTO actor (actor_id, first_name, last_name)
VALUES (201, 'HAMPTON', 'AVENUE')
;
INSERT INTO actor (actor_id, first_name, last_name)
VALUES (202, 'LISA', 'BYWAY')
;
COMMIT;

-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in 
-- ancient Greece", to the film table. The movie was released in 2008 in English. 
-- Since its an epic, the run length is 3hrs and 18mins. There are no special 
-- features, the film speaks for itself, and doesn't need any gimmicks.

BEGIN TRANSACTION;
INSERT INTO film (title, description, release_year, language_id)
VALUES ('Euclidean PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008, 1)
;
COMMIT;

BEGIN TRANSACTION;
UPDATE film
SET length = 198
WHERE film_id = 1002
;
COMMIT;

-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly 
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.

BEGIN TRANSACTION;
INSERT INTO film_actor (actor_id, film_id)
VALUES (201, 1002)
;
INSERT INTO film_actor (actor_id, film_id)
VALUES (202, 1002)
;
COMMIT;

-- 4. Add Mathmagical to the category table.

BEGIN TRANSACTION;
INSERT INTO category (name)
VALUES ('Mathmagical')
;
COMMIT;

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI", 
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"

BEGIN TRANSACTION;
UPDATE film_category
SET category_id = (SELECT category_id FROM category WHERE name = 'Mathmagical')
WHERE film_id IN (SELECT film_id FROM film WHERE title IN ('EUCLIDEAN PI', 'EGG IGBY', 'KARATE MOON', 'RANDOM GO', 'YOUNG LANGUAGE'))
;
COMMIT;

BEGIN TRANSACTION;
INSERT INTO film_category (film_id, category_id)
VALUES (1002, 17)
;
COMMIT;

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films 
-- accordingly.
-- (5 rows affected)

BEGIN TRANSACTION;
UPDATE film
SET rating = 'G'
WHERE film_id IN (SELECT film_id FROM film_category WHERE category_id = 17)
;
COMMIT;

-- 7. Add a copy of "Euclidean PI" to all the stores.

BEGIN TRANSACTION;
INSERT INTO inventory (store_id, film_id)
SELECT store_id = (SELECT film_id FROM film WHERE title = 'Euclidean PI')
FROM store
;
SELECT inventory_id
FROM inventory
INNER JOIN film f ON film.film_id = inventory.film_id
WHERE film.title = 'Euclidean PI'
;
COMMIT;

-- 8. The Feds have stepped in and have impounded all copies of the pirated film, 
-- "Euclidean PI". The film has been seized from all stores, and needs to be 
-- deleted from the film table. Delete "Euclidean PI" from the film table. 
-- (Did it succeed? Why?)

--did not succeed because film_id 1002 is still referenced in another table
BEGIN TRANSACTION;
DELETE FROM film
WHERE film_id = 1002
;
ROLLBACK;

-- 9. Delete Mathmagical from the category table. 
-- (Did it succeed? Why?)

--also failed because category_id is referenced elsewhere
BEGIN TRANSACTION;
DELETE FROM category
WHERE name = 'Mathmagical'
;
ROLLBACK;

-- 10. Delete all links to Mathmagical in the film_category tale. 
-- (Did it succeed? Why?)

--successful (because it was the origin of the reference?)
BEGIN TRANSACTION;
DELETE FROM film_category
WHERE category_id = 17
;
COMMIT;

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI". 
-- (Did either deletes succeed? Why?)

--successful because the category's category_id is now gone from film_category
BEGIN TRANSACTION;
DELETE FROM category
WHERE name = 'Mathmagical'
;
COMMIT;

--unsuccessful because film_actor table is still using the film_id
BEGIN TRANSACTION;
DELETE FROM film
WHERE film_id = 1002
;
ROLLBACK;

-- 12. Check database metadata to determine all constraints of the film id, and 
-- describe any remaining adjustments needed before the film "Euclidean PI" can 
-- be removed from the film table.

--trying to delete the film from the 'film' table violates a foreign key constraint on the table 'film_actor',
--so deleting film_id = 1002 from the film_actor table would be required.
--we also added film_id = 1002 to the inventory table, so it would likely need to be removed from there as well
--(unless removing it from the film_actor table extended to its removal from inventory)
