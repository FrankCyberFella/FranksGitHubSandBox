-- Write queries to return the following:
-- The following changes are applied to the "pagila" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.

BEGIN TRANSACTION ;
INSERT INTO actor(first_name , last_name)
Values ('HAMPTON' , 'AVENUE');
INSERT INTO actor(first_name , last_name)
Values ('LISA' , 'BYWAY');
Select * from actor where first_name = 'LISA' or first_name = 'HAMPTON';
ROLLBACK;


-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in 
-- ancient Greece", to the film table. The movie was released in 2008 in English. 
-- Since its an epic, the run length is 3hrs and 18mins. There are no special 
-- features, the film speaks for itself, and doesn't need any gimmicks.	


BEGIN TRANSACTION;
INSERT INTO film (title, description, release_year, language_id, length)
Values('Euclidean PI' , 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008, 1, 198);
Select * from film where title = 'Euclidean PI';
commit;


-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly 
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.

BEGIN TRANSACTION;
 INSERT INTO film_actor(actor_id, film_id)
 VALUES (203 , 1002);
  INSERT INTO film_actor(actor_id, film_id)
 VALUES (204 , 1002);
 SELECT * FROM film_actor where film_id = 1002;
 commit;

-- 4. Add Mathmagical to the category table.

BEGIN TRANSACTION;
INSERT INTO category(name)
VALUES('Mathmagical');
SELECT * FROM category;
COMMIT;

--BEGIN TRANSACTION;
--insert into category 
--(category_id, name)
--VALUES (select max(category_id)+1 from name, 'Bills Favorites');
--select category_id from category;
--rollback
--;


-- 5. Assign the Mathmagical category to the following films, "Euclidean PI", 
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
BEGIN TRANSACTION;
 INSERT INTO film_category(film_id, category_id)
 VALUES(1002,18);
 SELECT * FROM film_category where film_id = 1002;
 commit;

BEGIN TRANSACTION;
UPDATE film_category
SET category_id = 18
WHERE film_id = 1002 or film_id = 274 or film_id = 494 or film_id = 714 or film_id = 996;
SELECT * from film_category where category_id = 18;
commit;

--update film_category
--set category_id = (select category_id from category where name = 'Mathmagical')
--Where film_id in ( select film_id from film where title in ('Euclidean PI', 
-- 'EGG IGBY', 'KARATE MOON', 'RANDOM GO', and 'YOUNG LANGUAGE')
        --)
        --;

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films 
-- accordingly.
-- (5 rows affected)

BEGIN TRANSACTION;
UPDATE film
SET rating = 'G'
WHERE film_id in (select film_id from film_category where category_id = 18);
SELECT * FROM film where film_id = 1002 or film_id = 274 or film_id = 494 or film_id = 714 or film_id = 996;
commit;

-- 7. Add a copy of "Euclidean PI" to all the stores.
BEGIN TRANSACTION;
INSERT INTO inventory(inventory_id, film_id, store_id)
VALUES (4582 , 1002, 1);
INSERT INTO inventory(inventory_id, film_id, store_id)
VALUES (4583, 1002, 2);
SELECT * FROM inventory where film_id = 1002;
COMMIT
;


-- 8. The Feds have stepped in and have impounded all copies of the pirated film, 
-- "Euclidean PI". The film has been seized from all stores, and needs to be 
-- deleted from the film table. Delete "Euclidean PI" from the film table. 
-- (Did it succeed? Why?)
BEGIN TRANSACTION;
DELETE FROM film
Where title = 'Euclidean PI';
SELECT * FROM film WHERE title = 'Euclidean PI';
ROLLBACK;
--NO it did not succeed, this is due to the fact that you can't delete a parent key that has dependents because it will create orphans and throw errors.

-- 9. Delete Mathmagical from the category table. 
-- (Did it succeed? Why?)

BEGIN TRANSACTION;
DELETE FROM category
WHERE name = 'Mathmagical';
SELECT * FROM category WHERE category = 'Mathmagical';
ROLLBACK
;
--NO it did not succeed, this is due to the fact that you can't delete a parent key that has dependents because it will create orphans and throw erros.

-- 10. Delete all links to Mathmagical in the film_category tale. 
-- (Did it succeed? Why?)

BEGIN TRANSACTION;
DELETE FROM film_category
WHERE category_id = 18;
SELECT * FROM film_category WHERE category_id = 18;
commit
;

--Yes this succeeded. This is due to the fact that this deletion does not affect any dependents, so by deleting this category we are not creating any orphans in other tables.


-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI". 
-- (Did either deletes succeed? Why?)
BEGIN TRANSACTION;
DELETE FROM category
WHERE name = 'Mathmagical';
commit
;

BEGIN TRANSACTION;
DELETE FROM film
Where title = 'Euclidean PI';
ROLLBACK;

--our first deletion of mathmagical succeed while our second deletion of the film failed 
        -- this is because mathmagical was now deleted from film_category so there were no constraints remaining on it allowing it to be deleted
                -- however, there are constraints remaining on Euclidean PI that must be addressed before it can be removed 


-- 12. Check database metadata to determine all constraints of the film id, and 
-- describe any remaining adjustments needed before the film "Euclidean PI" can 
-- be removed from the film table.

--To delete this film, we must still address its presence in the inventory of both stores, while also addressing its connection to both actors.
        --First we must delete it from the inventory table of the stores, and then we must delete it from the film_actor category before removing it from the film table
