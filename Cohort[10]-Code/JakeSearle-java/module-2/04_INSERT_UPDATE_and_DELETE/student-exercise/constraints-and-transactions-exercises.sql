-- Write queries to return the following:
-- The following changes are applied to the "pagila" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
BEGIN TRANSACTION;

INSERT INTO actor
(first_name, last_name)
VALUES('Hampton', 'Avenue');

INSERT INTO actor
(first_name, last_name)
VALUES('Lisa', 'Byway')
;

COMMIT;

SELECT *
FROM actor
WHERE last_name = 'Avenue'
  OR last_name = 'Byway'
  ;
  
-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in 
-- ancient Greece", to the film table. The movie was released in 2008 in English. 
-- Since its an epic, the run length is 3hrs and 18mins. There are no special 
-- features, the film speaks for itself, and doesn't need any gimmicks.	
BEGIN TRANSACTION;

INSERT INTO film
(title, description, release_year, language_id, length)
VALUES ('Euclidean PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008, 1, 198)
;

COMMIT;

SELECT *
FROM film
WHERE title = 'Euclidean PI'
;


-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly 
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
BEGIN TRANSACTION;

INSERT INTO film_actor
(actor_id, film_id)
VALUES (210, 1003)
;

INSERT INTO film_actor
(actor_id, film_id)
VALUES (211, 1003)
;

COMMIT;

SELECT *
FROM film_actor
WHERE film_id = 1003
;

-- 4. Add Mathmagical to the category table.
INSERT INTO category
(name)
VALUES ('Mathmagical')
;

COMMIT;

SELECT *
FROM category
;

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI", 
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
BEGIN TRANSACTION;

UPDATE film_category
SET category_id = 17
WHERE film_id IN (SELECT film_id FROM film WHERE title = ('EGG IGBY') OR title = ('KARATE MOON') OR title = ('RANDOM GO') OR title = ('YOUNG LANGUAGE'))
;

INSERT INTO film_category
(film_id, category_id)
VALUES (1003, 17)
;

COMMIT;
  
  SELECT *
  FROM film_category
  WHERE category_id = 17
  ;
  
-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films 
-- accordingly.
-- (5 rows affected)
BEGIN TRANSACTION;

UPDATE film
SET rating = 'G'
WHERE film_id IN (SELECT film_id FROM film_category WHERE film_id = 274 OR film_id = 494 OR film_id = 714 OR film_id = 996 OR film_id = 1003)
;

COMMIT;

SELECT film_id, title, rating
FROM film
WHERE rating = 'G'
;

-- 7. Add a copy of "Euclidean PI" to all the stores.
INSERT INTO inventory
(film_id, store_id)
VALUES(1003, 1)
;
INSERT INTO inventory
(film_id, store_id)
VALUES(1003, 2)
;

COMMIT;

SELECT inventory_id, film_id, store_id
FROM inventory
WHERE film_id = 1003
;

-- 8. The Feds have stepped in and have impounded all copies of the pirated film, 
-- "Euclidean PI". The film has been seized from all stores, and needs to be 
-- deleted from the film table. Delete "Euclidean PI" from the film table. 
-- (Did it succeed? Why?)
BEGIN TRANSACTION;

DELETE FROM film
WHERE film_id = 1003     -- Did NOT succeed, due to the film_id still being referenced elsewhere. (Foreign Key Restraint)
;

ROLLBACK;

-- 9. Delete Mathmagical from the category table. 
-- (Did it succeed? Why?)
BEGIN TRANSACTION;

DELETE FROM category
WHERE category_id = 17   -- Did NOT succeed due to the category_id still being referenced elsewhere. (Foreign Key Restraint)
;

ROLLBACK;

-- 10. Delete all links to Mathmagical in the film_category tale. 
-- (Did it succeed? Why?)
BEGIN TRANSACTION;

DELETE FROM film_category
WHERE category_id = 17   -- Yes, it did succeed because it was a primary key, not a foreign key. 
;

COMMIT;

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI". 
-- (Did either deletes succeed? Why?)
BEGIN TRANSACTION;

DELETE FROM category
WHERE category_id = 17   -- Deleting Mathmagical from the category table worked because it was no longer a foreign key.
;

COMMIT;

DELETE FROM film
WHERE title = 'Euclidean PI'     -- Deleting Euclidean PI did not work, because it is still referenced as a foreign key in film_actor
;

SELECT film_id
FROM film
WHERE title = 'Euclidean PI'
;

ROLLBACK;

-- 12. Check database metadata to determine all constraints of the film id, and 
-- describe any remaining adjustments needed before the film "Euclidean PI" can 
-- be removed from the film table.
-- ANSWER:
-- Euclidean PI cannot be removed from the film table due to a foreign key restraint. To be able to delete it from the film table,
-- we must first delete it from any table where it is a foreign key.