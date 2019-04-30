-- Write queries to return the following:
-- The following changes are applied to the "pagila" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.

BEGIN TRANSACTION;
INSERT INTO actor (first_name, last_name)
VALUES ('HAMPTON', 'AVENUE')
;
INSERT INTO actor (first_name, last_name)
VALUES ('LISA', 'BYWAY')
;
COMMIT;
-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in 
-- ancient Greece", to the film table. The movie was released in 2008 in English. 
-- Since its an epic, the run length is 3hrs and 18mins. There are no special 
-- features, the film speaks for itself, and doesn't need any gimmicks.
BEGIN TRANSACTION;
INSERT INTO film (title, description, release_year, language_id, length)
VALUES ('EUCLIDEAN PI', 'The epic story of Euclid as a pizza delivery boy in 
ancient Greece', 2008, 1, 198)
;
COMMIT;

	

-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly 
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
BEGIN TRANSACTION;
INSERT INTO film_actor (actor_id, film_id)
values( 201, 1003)
;
INSERT INTO film_actor (actor_id, film_id)
values( 202, 1003)
;
COMMIT;
-- 4. Add Mathmagical to the category table.
BEGIN TRANSACTION;
INSERT INTO category (name)
values('Mathmagical')
;
commit
;

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI", 
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
BEGIN TRANSACTION;
UPDATE film_category
SET category_id = 18
WHERE film_id IN (SELECT film_id FROM film WHERE title IN ('EUCLIDEAN PI', 'EGG IGBY', 'KARATE MOON', 'RANDOM GO', 'YOUNG LANGUAGE'))
;
COMMIT;
BEGIN TRANSACTION;
INSERT INTO film_category(film_id, category_id)
VALUES(1003, 18)
;
COMMIT;
-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films 
-- accordingly.
-- (5 rows affected)
BEGIN TRANSACTION;
UPDATE film
SET rating = 'G'
WHERE film_id IN (SELECT film_id FROM film WHERE title IN ('EUCLIDEAN PI', 'EGG IGBY', 'KARATE MOON', 'RANDOM GO', 'YOUNG LANGUAGE'))
;
Commit;
-- 7. Add a copy of "Euclidean PI" to all the stores.
BEGIN TRANSACTION;
INSERT INTO inventory (film_id, store_id)
values(1003, 1)
;
commit;
BEGIN TRANSACTION;
INSERT INTO inventory (film_id, store_id)
values(1003, 2)
;
commit;

-- 8. The Feds have stepped in and have impounded all copies of the pirated film, 
-- "Euclidean PI". The film has been seized from all stores, and needs to be 
-- deleted from the film table. Delete "Euclidean PI" from the film table. 
-- (Did it succeed? Why?) No, this violates foreign key constraints
BEGIN TRANSACTION;
DELETE FROM  film
WHERE film_id = 1003
;
Rollback;

-- 9. Delete Mathmagical from the category table. 
-- (Did it succeed? Why?) No because this violates foreign key constraints 
BEGIN TRANSACTION;
DELETE FROM  category
WHERE category_id = 18
;
Rollback;
-- 10. Delete all links to Mathmagical in the film_category tale. 
-- (Did it succeed? Why?)
BEGIN TRANSACTION;
DELETE FROM  film_category
WHERE category_id = 18
;
Commit;

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI". 
-- (Did either deletes succeed? Why?)Yes, Mathmagical worked because we deleted it from the film_category which eliminated the relational constraints.
-- no, deleting Euclidean PI did not work because we did not change the foriegn key relational constraints for the film.
BEGIN TRANSACTION;
DELETE FROM  category
WHERE category_id = 18
;
Rollback;
BEGIN TRANSACTION;
DELETE FROM  film
WHERE film_id = 1003
;
Rollback;
-- 12. Check database metadata to determine all constraints of the film id, and 
-- describe any remaining adjustments needed before the film "Euclidean PI" can 
-- be removed from the film table.

--film_actor, inventory, and film_category tables all have a foreign key relational constraints to the film table through the film_id key. These would have to be deleted before deleting the film_id from the film table:
