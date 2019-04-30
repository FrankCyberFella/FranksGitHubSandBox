-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.

BEGIN TRANSACTION;

INSERT INTO actor(actor_id, first_name, last_name)
VALUES (201, 'HAMPTON', 'AVENUE');

INSERT INTO actor(actor_id, first_name, last_name)
VALUES (202, 'LISA', 'BYWAY');


SELECT first_name || ' ' || last_name as customer
FROM actor
;

 

COMMIT;

-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in 
-- ancient Greece", to the film table. The movie was released in 2008 in English. 
-- Since its an epic, the run length is 3hrs and 18mins. There are no special 
-- features, the film speaks for itself, and doesn't need any gimmicks.	

BEGIN TRANSACTION;

INSERT INTO film (film_id, title, description                                                     , release_year, language_id     , original_language_id, rental_duration, rental_rate, length, replacement_cost, rating)
VALUES (1001, 'EUCLIDEAN PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008         , 1              , DEFAULT            , DEFAULT        ,DEFAULT     , 198   , DEFAULT        , DEFAULT)
;

SELECT title
FROM film
WHERE film_id = 1001
;


COMMIT;
-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly 
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.

BEGIN TRANSACTION;

INSERT INTO film_actor
VALUES (201, 1001)
;
INSERT INTO film_actor
VALUES (202, 1001)
;

SELECT actor_id, film_id
FROM film_actor
;

COMMIT;

-- 4. Add Mathmagical to the category table.

BEGIN TRANSACTION;

INSERT INTO category 
(name)
VALUES ('Mathmagical')
;

SELECT name, category_id
FROM category
;

COMMIT;

--insert into category
--(category_id, name)
--VALUES (select max(category_id) + 1 from category, 'Favorites');



-- 5. Assign the Mathmagical category to the following films, "Euclidean PI", 
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"

BEGIN TRANSACTION;

INSERT INTO film_category
VALUES(1001, 17)
;

UPDATE film_category
SET category_id = (select category_id from category where name = 'Mathmagical')
WHERE film_id IN (SELECT film_id FROM film WHERE title IN ('EGG IGBY', 'KARATE MOON', 'RANDOM GO', 'YOUNG LANGUAGE', 'EUCLIDEAN PI'))
;


SELECT film_id, category_id
FROM film_category
;


COMMIT;

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films 
-- accordingly.
-- (5 rows affected)

BEGIN TRANSACTION;

UPDATE film
SET rating = 'G'
WHERE film_id IN (SELECT film_id from film_category WHERE category_id = 17)
;

SELECT *
FROM film
;

COMMIT;

-- 7. Add a copy of "Euclidean PI" to all the stores.

BEGIN TRANSACTION;

INSERT INTO inventory (store_id, film_id)
SELECT store_id, (SELECT film_id FROM film WHERE title = 'EUCLIDEAN PI') -- store_id, will insert film_id into both stores
  FROM store
  ;

SELECT inventory_id, store_id
 FROM  inventory i
 JOIN  film f
   ON f.film_id = i.film_id
  WHERE f.title = 'EUCLIDEAN PI'
  ; 


COMMIT;

-- 8. The Feds have stepped in and have impounded all copies of the pirated film, 
-- "Euclidean PI". The film has been seized from all stores, and needs to be 
-- deleted from the film table. Delete "Euclidean PI" from the film table. 
-- (Did it succeed? Why?)

BEGIN TRANSACTION;


ROLLBACK;

-- 9. Delete Mathmagical from the category table. 
-- (Did it succeed? Why?)

BEGIN TRANSACTION;


ROLLBACK;

-- 10. Delete all links to Mathmagical in the film_category tale. 
-- (Did it succeed? Why?)

BEGIN TRANSACTION;


ROLLBACK;

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI". 
-- (Did either deletes succeed? Why?)

BEGIN TRANSACTION;


ROLLBACK;

-- 12. Check database metadata to determine all constraints of the film id, and 
-- describe any remaining adjustments needed before the film "Euclidean PI" can 
-- be removed from the film table.

BEGIN TRANSACTION;


ROLLBACK;
