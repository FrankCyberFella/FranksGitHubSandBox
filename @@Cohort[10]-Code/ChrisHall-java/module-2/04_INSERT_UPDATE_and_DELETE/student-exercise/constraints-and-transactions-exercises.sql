-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.
--                   **********  use BEGIN TRANSACTION, ROLLBACK, with select to check first. then commit  ********************

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
BEGIN TRANSACTION;

Insert Into actor (first_name, last_name)
Values            ('HAMPTON', 'AVENUE')
;
Insert Into actor (first_name, last_name)
Values            ('LISA', 'BYWAY')              
;

Select *
from actor
WHERE last_name = 'BYWAY'
or last_name = 'AVENUE'
;

COMMIT;



-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in 
-- ancient Greece", to the film table. The movie was released in 2008 in English. 
-- Since its an epic, the run length is 3hrs and 18mins. There are no special 
-- features, the film speaks for itself, and doesn't need any gimmicks."	
BEGIN TRANSACTION;

Insert Into film (title, description, release_year, language_id)
Values           ('EUCLIDEAN PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008, 1)
;

Select *
from film
WHERE title = 'EUCLIDEAN PI'
;

commit;


-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly 
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
BEGIN TRANSACTION;

Insert Into film_actor (actor_id, film_id)
Values                 (215, 1003)
;
Insert Into film_actor (actor_id, film_id)
Values                 (216, 1003)
;

Select *
from film_actor
WHERE film_id = 1003
;

commit;



-- 4. Add Mathmagical to the category table.
BEGIN TRANSACTION;

Insert Into category  (name)
Values           ('Mathemagical')
;

Select *
from category  
;

COMMIT;

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",   
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
BEGIN TRANSACTION;

update file_category
Insert Into film_category (film_id, category_id)
Values                    (1003,    18)
;
Update film_category 
set category_id = 18
where film_id IN (SELECT film_id from film where title = ('EGG IGBY') 
or title = ('KARATE MOON') 
or title = ('RANDOM GO') 
or title = ('YOUNG LANGUAGE'))
;


Select *
from film_category 
where film_id IN (SELECT film_id from film where title = ('EGG IGBY'))
;

commit;


-- 6. Mathmagical films always have a "G" rating, adjust all Mathemagical films 
-- accordingly.
-- (5 rows affected)
BEGIN TRANSACTION;

Update film
set rating = 'G' 
where film_id IN (SELECT film_id from film_category where category_id = 18)
;

Select rating, title
from film
where film_id IN (SELECT film_id from film_category where category_id = 18)
;

ROLLBACK;

-- 7. Add a copy of "Euclidean PI" to all the stores.
BEGIN TRANSACTION;

Insert into inventory (film_id, store_id)
values                (1003, 1)
;
Insert into inventory (film_id, store_id)
values                (1003, 2)
;

Select * from inventory
where film_id = 1003
;

ROLLBACK;

-- 8. The Feds have stepped in and have impounded all copies of the pirated film, 
-- "Euclidean PI". The film has been seized from all stores, and needs to be 
-- deleted from the film table. Delete "Euclidean PI" from the film table. 
-- (Did it succeed? Why?)
BEGIN TRANSACTION;

DELETE from film                     -- delete not allowed--foreign key constraint.  The key for film_id = 1003 (Euclidean PI) is still referenced 
                                     -- from the film_actor table.    
WHERE film_id = 1003;

Select title 
from film
where code = 1003;

ROLLBACK;

-- 9. Delete Mathmagical from the category table. 
-- (Did it succeed? Why?)
BEGIN TRANSACTION;

DELETE from category                     -- delete not allowed--foreign key constraint.  The key for category_id = 18 (Euclidean PI) is still referenced 
                                        -- from the film_category table.                                        
WHERE category_id = 18;

Select * 
from category
where category_id = 18;

ROLLBACK;

-- 10. Delete all links to Mathemagical in the film_category tale. 
-- (Did it succeed? Why?)
BEGIN TRANSACTION;

DELETE from film_category                                                                                                  
WHERE category_id = 18;

Select * 
from category
where category_id = 18;

ROLLBACK;

-- 11. Retry deleting Mathemagical from the category table, followed by retrying
-- to delete "Euclidean PI". 
-- (Did either deletes succeed? Why?)



-- 12. Check database metadata to determine all constraints of the film id, and 
-- describe any remaining adjustments needed before the film "Euclidean PI" can 
-- be removed from the film table.
