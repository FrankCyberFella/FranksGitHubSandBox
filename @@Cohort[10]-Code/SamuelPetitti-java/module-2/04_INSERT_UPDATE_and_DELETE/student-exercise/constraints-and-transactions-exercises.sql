-- Write queries to return the following:
-- The following changes are applied to the "pagila" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.



BEGIN TRANSACTION;

INSERT into actor(actor_id, first_name, last_name)
            values(201, 'HAMPTON', 'AVENUE'),
                  (202, 'LISA', 'BYWAY');
SELECT *
FROM actor
ORDER by 1 desc;

COMMIT;


-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in 
-- ancient Greece", to the film table. The movie was released in 2008 in English. 
-- Since its an epic, the run length is 3hrs and 18mins. There are no special 
-- features, the film speaks for itself, and doesn't need any gimmicks.	
BEGIN TRANSACTION;

INSERT into film(film_id, title, description, release_year, language_id, length)
          values(1001, 'EUCLIDEAN PI','The epic story of Euclid as a pizza delivery boy in 
ancient Greece', 2008, 1, 198);

SELECT *
FROM film;

COMMIT;



-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly 
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
BEGIN TRANSACTION;



INSERT into film_actor(film_id, actor_id)
                values(1001, 201),
                      (1001, 202);

SELECT title, fa.film_id, fa.actor_id
FROM film
        inner join
        film_actor fa
      on film.film_id = fa.film_id
WHERE fa.film_id = 1001;


COMMIT;
         


-- 4. Add Mathmagical to the category table.

BEGIN TRANSACTION;

INSERT into category(category_id, name)
               values(17, 'Mathmagical');

SELECT *
FROM category;

COMMIT;

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI", 
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"

BEGIN TRANSACTION;
UPDATE film_category
SET category_id = 17 -- should be (select category_id from category where name = 'Mathmagical');
WHERE film_id IN (SELECT film_id FROM film 
                        WHERE title = ('EUCLIDEAN PI')
                          or  title = ('EGG IGBY')
                          or  title = ('KARATE MOON')
                          or  title =  ('RANDOM GO')
                          or  title = ('YOUNG LANGUAGE'));
                          
INSERT into film_category(film_id, category_id)
                     values(1001, 17);

SELECT fc.film_id, fc.category_id
FROM film_category fc
              inner join
              film
            on film.film_id = fc.film_id
WHERE film.title in ('EUCLIDEAN PI', 'EGG IGBY', 'KARATE MOON', 'RANDOM GO', 'YOUNG LANGUAGE');
 
COMMIT;

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films 
-- accordingly.
-- (5 rows affected)
BEGIN TRANSACTION;

UPDATE film SET rating  = 'G'
WHERE film.film_id in (SELECT film_id FROM film_category WHERE category_id = (
                       SELECT category_id FROM category WHERE name = 'Mathmagical'));

SELECT title, rating
FROM film
WHERE title = 'EGG IGBY';

COMMIT;



-- 7. Add a copy of "Euclidean PI" to all the stores.

--Jason's Solution - review this weekend!!!
--BEGIN TRANSACTION
--INSERT INTO inventory
--SELECT store_id, (SELECT film_id FROM film WHERE title = 'Euclidean PI')
--FROM store;
BEGIN TRANSACTION;

INSERT into inventory(film_id, store_id)
        values((SELECT film_id FROM film WHERE title = 'EUCLIDEAN PI'), 1),
                ((SELECT film_id FROM film WHERE title = 'EUCLIDEAN PI'), 2);

SELECT *, TITLE
FROM inventory
        inner join film
      on film.film_id =inventory.film_id
WHERE title = 'EUCLIDEAN PI';

COMMIT;

-- 8. The Feds have stepped in and have impounded all copies of the pirated film, 
-- "Euclidean PI". The film has been seized from all stores, and needs to be 
-- deleted from the film table. Delete "Euclidean PI" from the film table. 
-- (Did it succeed? Why?)
BEGIN TRANSACTION;

DELETE
FROM film
WHERE title = 'EUCLIDEAN PI';

SELECT *
FROM film
WHERE title = 'EUCLIDEAN PI';

COMMIT;

--It does not work becuase it violates foreign key constraint

-- 9. Delete Mathmagical from the category table. 
-- (Did it succeed? Why?)
BEGIN TRANSACTION;

DELETE 
FROM category
WHERE name = 'Mathmagical';

SELECT *
FROM category;

COMMIT;

--It does not work because it vioalates a foreign key constraint

-- 10. Delete all links to Mathmagical in the film_category tale. 
-- (Did it succeed? Why?)
BEGIN TRANSACTION;
DELETE 
FROM film_category fc
WHERE fc.category_id = (
        SELECT cat.category_id FROM category cat WHERE cat.name = 'Mathmagical');
        
SELECT fc.category_id,fc.film_id
FROM film_category fc
        inner join
        category cat
      on fc.category_id = cat.category_id
ORDER BY 1 desc;


COMMIT;

--It did succeed because Mathmagical in the film_category table is not a parent element, so other tables are not depending on it.

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI". 
-- (Did either deletes succeed? Why?)
BEGIN TRANSACTION;;

DELETE 
FROM category 
WHERE name = 'Mathmagical';

SELECT *
FROM CATEGORY;

COMMIT;

BEGIN TRANSACTION;


DELETE
FROM film_category fc
WHERE fc.film_id = (SELECT film.film_id FROM film WHERE title = 'EUCLIDEAN PI');

SELECT fc.film_id
FROM film_category fc
WHERE fc.film_id = (SELECT film_id FROM film WHERE title = 'EUCLIDEAN PI');

COMMIT;

--Deleting Mathmagical worked because it is not a parent element to another table anymore
-- Deleting 'EUCLIDEAN PI' from film category should or did work (but something was weird with how I did it) for the same reaasons as above.


-- 12. Check database metadata to determine all constraints of the film id, and 
-- describe any remaining adjustments needed before the film "Euclidean PI" can 
-- be removed from the film table.

--You would still need to delete the 'EUCLIDEAN PI' film_id  and inventory from the film_actor table where it is a primary key.

BEGIN TRANSACTION;

DELETE 
FROM film_actor
WHERE film_id = (SELECT film_id FROM film WHERE title = 'EUCLIDEAN PI');

DELETE
FROM inventory
WHERE film_id = (SELECT film_id FROM film WHERE title = 'EUCLIDEAN PI');


DELETE 
FROM film
WHERE title = 'EUCLIDEAN PI';

ROLLBACK;


