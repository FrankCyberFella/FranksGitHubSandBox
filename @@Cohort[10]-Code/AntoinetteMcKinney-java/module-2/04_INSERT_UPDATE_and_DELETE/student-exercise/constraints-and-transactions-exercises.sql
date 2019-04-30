

-- Write queries to return the following:
-- The following changes are applied to the "pagila" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
BEGIN TRANSACTION; 
INSERT INTO actor (first_name, last_name) VALUES ('Hampton', 'Avenue'); --insert for all data
INSERT INTO actor (first_name, last_name) VALUES ('Lisa', 'Byway'); --insert for all data

SELECT first_name, last_name
FROM actor
WHERE first_name = 'Lisa' OR first_name = 'Hampton';

COMMIT
;


-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in ancient Greece",to the film table. 
--The movie was released in 2008 in English. 
-- Since its an epic, the run length is 3hrs and 18mins. There are no special 
-- features, the film speaks for itself, and doesn't need any gimmicks.	
BEGIN TRANSACTION; 
---Nedded to delete extra actor added note to self REMEMBER TO USE ROLLBACK 
DELETE
FROM actor
WHERE actor_id = 212;
COMMIT
;

DELETE
FROM actor
WHERE actor_id = 213;
COMMIT
;

DELETE
FROM film
WHERE film_id = 1003;
COMMIT
;

INSERT INTO film (title,description,release_year,language_id,length) VALUES ('Euclidean PI','The epic story of Euclid as a pizza delivery boy in ancient Greece',2008,1,198); 

SELECT title,description,release_year,language_id,length
FROM film
WHERE title = 'Euclidean PI';
COMMIT
;

-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly 
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
BEGIN TRANSACTION;
INSERT INTO film_actor (film_id ,actor_id ) VALUES (1001, 202); 

--to verify data 
SELECT film_id ,actor_id
FROM film_actor
WHERE film_id = 1001 AND actor_id = 202;
COMMIT;
END TRANSACTION;
--Rollback
;

-- 4. Add Mathmagical to the category table.
BEGIN TRANSACTION; 
INSERT INTO category (name) VALUES ('Mathmagical'); 
COMMIT 

DELETE
FROM category
WHERE category_id = 18;
COMMIT

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI", 
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
--Line 77 is stating we are updating the film_category table
update film_category
-- Line 79 should set the category_id to 17 for Mathmagical
set category_id =(select category.category_id from category where name = 'Mathmagical')-- in class 
--Line 81 is identifying the rows that need updating based on the film_id's of the identified films
where film_id in 
--Line 83 is getting the film_id's of the required films that need to have the category_id updated.
(select film_id from film where film.title in ('Euclidean PI', 'EGG IGBY', 'KARATE MOON', 'RANDOM GO', 'YOUNG LANGUAGE'))
;

END TRANSACTION;

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films 
-- accordingly.
-- (5 rows affected)
--Selecting category id number 17 
 update film
 set rating = 'G'
 Where film_id in (select film_id from film_category where category_id = 17)
 ;
 END TRANSACTION;
 
--insert into film * %Mathmagical ratings to be 'G'

-- 7. Add a copy of "Euclidean PI" to all the stores.
 BEGIN TRANSACTION; -- inclass 
 INSERT INTO inventory (store_id, film_id)
 SELECT store_id, (SELECT film_id From film WHERE title = 'Euclidean PI')
 Values(1,17)
 Values(2,17)
 FROM  store
 ;
 SELECT INVENTORY_id
 from inventory i
 JOIN FILM F
 ON F.FIL

-- 8. The Feds have stepped in and have impounded all copies of the pirated film, 
-- "Euclidean PI". The film has been seized from all stores, and needs to be 
-- deleted from the film table. Delete "Euclidean PI" from the film table. 
-- (Did it succeed? Why?)
DELETE
FROM film
WHERE title = 'Euclidean PI'
;

-- 9. Delete Mathmagical from the category table. 
-- (Did it succeed? Why?)
DELETE
FROM category
WHERE name = 'Mathmagical'; 
--This violates foreign key constraints. It did not suscceed in deleting mathmagical from the category table because there will be orphans due to the key is used in other tables.

-- 10. Delete all links to Mathmagical in the film_category tale. 
-- (Did it succeed? Why?)
DELETE
FROM category
WHERE category_id = 17; 
This violates foreign key constraints. It did not suscceed in deleting mathmagical from the category table because there will be orphans due to the key is used in other tables.
-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI". 
-- (Did either deletes succeed? Why?)
 DELETE
FROM category
WHERE name = 'Mathmagical';

DELETE
FROM category
WHERE category_id = 17; 
--no success due to constraintss

-- 12. Check database metadata to determine all constraints of the film id, and 
-- describe any remaining adjustments needed before the film "Euclidean PI" can 
-- be removed from the film table.
--based on the data filtered the primary and foreign keys would need to be deleted.constraints include pk_film_category_film_id_category_id, pk_film_actor_actor_id_film_id,pk_film_film_id,film_actor_film_id_fkey,film_category_film_id_fkey,inventory_film_id_fkey