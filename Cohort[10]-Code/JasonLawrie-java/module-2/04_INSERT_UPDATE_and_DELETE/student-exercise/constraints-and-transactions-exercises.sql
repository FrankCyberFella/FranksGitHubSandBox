-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
BEGIN TRANSACTION;

INSERT INTO actor (first_name, last_name)
        VALUES ('HAMPTON', 'AVENUE')
        ;
INSERT INTO actor (first_name, last_name)
        VALUES ('LISA', 'BYWAY')
        ;
SELECT first_name||' '||last_name
  FROM actor
  ;
COMMIT;

-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in 
-- ancient Greece", to the film table. The movie was released in 2008 in English. 
-- Since its an epic, the run length is 3hrs and 18mins. There are no special 
-- features, the film speaks for itself, and doesn't need any gimmicks.	
BEGIN TRANSACTION;
INSERT INTO film (title
        , description
        , release_year
        ,language_id
        ,length)
        VALUES('Euclidean PI'
        , 'The epic story of Euclid as a pizza delivery boy in ancient Greece'
        ,2008
        ,(SELECT language_id
        FROM language
        WHERE name like '%English%')
        ,3*60+18)
        ;

SELECT *
  FROM film
  WHERE title ilike 'Euclidean PI'
  ;
commit;

-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly 
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
BEGIN TRANSACTION;
INSERT INTO film_actor (film_id
                        ,actor_id)
       VALUES((SELECT film_id FROM film WHERE title ilike '%Euclidean PI%'),
                (SELECT actor_id FROM actor WHERE first_name||last_name='HAMPTONAVENUE'))
       ;
INSERT INTO film_actor (film_id
                        ,actor_id)
       VALUES((SELECT film_id FROM film WHERE title ilike '%Euclidean PI%'),
                (SELECT actor_id FROM actor WHERE first_name||last_name ilike 'LISABYWAY'))
       ;       
SELECT f.title, a.first_name||' '||a.last_name
  FROM film f
  JOIN film_actor fa
    ON f.film_id=fa.film_id
  JOIN actor a
    ON a.actor_id=fa.actor_id
 WHERE f.title='Euclidean PI'
 ;
commit;

-- 4. Add Mathmagical to the category table.
BEGIN TRANSACTION;
INSERT INTO category (name) VALUES ('Mathmagical');
SELECT name FROM category;
COMMIT;

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI", 
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
BEGIN TRANSACTION;

INSERT INTO film_category(film_id, category_id)
        SELECT film_id,(SELECT category_id FROM category WHERE name = 'Mathmagical') 
          FROM film WHERE title IN ('Euclidean PI', 'EGG IGBY', 'KARATE MOON', 'RANDOM GO', 'YOUNG LANGUAGE')
          ;

SELECT f.title, c.name
  FROM film f
  JOIN film_category fc
  ON f.film_id=fc.film_id
  JOIN category c
  ON c.category_id=fc.category_id
  WHERE c.name='Mathmagical'
  ;
       
COMMIT;
-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films 
-- accordingly.
-- (5 rows affected)
BEGIN TRANSACTION;
SELECT f.title, f.rating
  FROM film f
  JOIN film_category fc
  ON f.film_id=fc.film_id
  JOIN category c
  ON c.category_id=fc.category_id
  WHERE c.name='Mathmagical'
  ;
UPDATE film
   SET rating='G'
 WHERE film_id IN (SELECT film_id FROM film_category WHERE category_id = (SELECT category_id FROM category WHERE name = 'Mathmagical'))
 ;
SELECT f.title, f.rating
  FROM film f
  JOIN film_category fc
  ON f.film_id=fc.film_id
  JOIN category c
  ON c.category_id=fc.category_id
  WHERE c.name='Mathmagical'
  ;
COMMIT;
-- 7. Add a copy of "Euclidean PI" to all the stores.
BEGIN TRANSACTION;
INSERT INTO inventory (store_id,film_id)
SELECT store_id, (SELECT film_id FROM film WHERE title = 'Euclidean PI')
  FROM store
  ;
SELECT inventory_id
  FROM inventory i
  JOIN film f
  ON f.film_id=i.film_id
  where f.title='Euclidean PI'
  ;
COMMIT;

-- 8. The Feds have stepped in and have impounded all copies of the pirated film, 
-- "Euclidean PI". The film has been seized from all stores, and needs to be 
-- deleted from the film table. Delete "Euclidean PI" from the film table. 
-- (Did it succeed? Why?)
--BEGIN TRANSACTION;
--DELETE FROM film
-- WHERE title = 'Euclidean PI'
-- ;
--SELECT title
--  FROM film
-- WHERE title='Euclidean PI'
-- ;
--ROLLBACK; --NOT POSSIBLE, FOREIGN KEY CONSTRAINT
-- 9. Delete Mathmagical from the category table. 
-- (Did it succeed? Why?)
--BEGIN TRANSACTION;
--DELETE FROM category
-- WHERE name = 'Mathmagical'
-- ;
--SELECT name
--  FROM category
-- WHERE name= 'Mathmagical'
-- ;
--ROLLBACK; --NOT POSSIBLE, FOREIGN KEY CONSTRAINT
-- 10. Delete all links to Mathmagical in the film_category table. 
-- (Did it succeed? Why?)
BEGIN TRANSACTION;
SELECT category_id
  FROM film_category
  WHERE category_id=(SELECT category_id FROM category WHERE name = 'Mathmagical')
  ;
DELETE FROM film_category
 WHERE category_id=(SELECT category_id FROM category WHERE name = 'Mathmagical')
 ;
SELECT category_id
  FROM film_category
  WHERE category_id=(SELECT category_id FROM category WHERE name = 'Mathmagical')
  ;
COMMIT; --it succeeded. it was the child key, not the parent key
-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI". 
-- (Did either deletes succeed? Why?)
BEGIN TRANSACTION;
DELETE FROM category
 WHERE name = 'Mathmagical'
 ;
SELECT name
  FROM category
 WHERE name= 'Mathmagical'
 ;
COMMIT; --it succeeded. it is no longer connected to the child key in film_category
--BEGIN TRANSACTION;
--DELETE FROM film
-- WHERE title = 'Euclidean PI'
-- ;
--SELECT title
--  FROM film
-- WHERE title='Euclidean PI'
-- ;
--ROLLBACK; --NOT POSSIBLE, FOREIGN KEY CONSTRAINT
-- 12. Check database metadata to determine all constraints of the film id, and 
-- describe any remaining adjustments needed before the film "Euclidean PI" can 
-- be removed from the film table.

SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS WHERE constraint_name like '%film_id%';
--this select returns a table that shows three referential constraints on the film_id key. we took care of one but two remain
--we have to get rid of all the rows in tables that reference the film_id as a foreign key. in this case it still exists in the film_actor table and the inventory table
