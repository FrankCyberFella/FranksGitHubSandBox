-- Write queries to return the following:
-- The following changes are applied to the "pagila" database.**
insert into countrylanguage 
(countrycode, language, isofficial, percentage)
values ('USA', 'Klingon', true, 100)
;
update country
SET capital = (select id from city where name = 'Houston') -- subquery to find code for Houston
where code = 'USA'
;
delete from country
where code = 'USA'
;







-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
Begin Transaction;
insert into actor (actor_id,first_name,last_name) values(201,'HAMPTON', 'AVENUE');
insert into actor (actor_id,first_name,last_name) VALUES(202,'LISA','BYWAY');
Select *
from actor
;
commit;

BEGIN TRANSACTION;
delete from actor
where actor_id 
;
-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in 
-- ancient Greece", to the film table. The movie was released in 2008 in English. 
-- Since its an epic, the run length is 3hrs and 18mins. There are no special 
-- features, the film speaks for itself, and doesn't need any gimmicks.	
BEGIN TRANSaction;
insert into film (film_id,title, description, release_year,language_id,length)
values (1001,'Euclidean PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008,1, 198)
;
SELECT *
from film
where title = 'Euclidean PI'
;
commit;

BEGIN TRANSACTION;
delete from film
where title = 'Euclidean PI'
;
SELECT *
from film
;
commit;


-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly  ************************* 
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
BEGIN TRANSACTION;
insert into film_actor (actor_id,film_id) values ((SElect actor_id from actor where first_name = 'HAMPTON' AND last_name = 'AVENUE'), (select film_id from film where title = 'Euclidean PI'));
insert into film_actor (actor_id,film_id) values ((SElect actor_id from actor where first_name = 'LISA' AND last_name = 'BYWAY'), (select film_id from film where title = 'Euclidean PI'));

SELECT *
from film_actor
where actor_id = (SElect actor_id from actor where first_name = 'HAMPTON' AND last_name = 'AVENUE') OR actor_id = (SElect actor_id from actor where first_name = 'LISA' AND last_name = 'BYWAY')
;

commit;

-- 4. Add Mathmagical to the category table.
BEGIN TRANSACTION;
insert into category (category_id , name) values(17, 'Mathmagical');

SELECT *
from category
;
commit;

--delete from category
--where name = 'Mathmagical'
--;

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI", 
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
BEGIN TRANSACTION;
insert into film_category (film_id, category_id) values ((SELECT film_id from film where title = 'Euclidean PI'), (SELECT category_id from category where name = 'Mathmagical'));
insert into film_category (film_id, category_id) values ((SELECT film_id from film where title = 'EGG IGBY'), (SELECT category_id from category where name = 'Mathmagical'));
insert into film_category (film_id, category_id) values ((SELECT film_id from film where title = 'KARATE MOON'), (SELECT category_id from category where name = 'Mathmagical'));
insert into film_category (film_id, category_id) values ((SELECT film_id from film where title = 'RANDOM GO'), (SELECT category_id from category where name = 'Mathmagical'));
insert into film_category (film_id, category_id) values ((SELECT film_id from film where title = 'YOUNG LANGUAGE'), (SELECT category_id from category where name = 'Mathmagical'));


SELECT *
from film_category
where category_id = 17;
commit;

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films 
-- accordingly.
-- (5 rows affected)
BEGIN TRANSACTION;
update film
 set rating = 'G'
 where film.film_id in (SELECT film_id from film_category where category_id = 17)
;commit;

SELECT title , rating
from film
where film.film_id in (SELECT film_id from film_category where category_id = 17)
;
ROLLBACK;


-- 7. Add a copy of "Euclidean PI" to all the stores.
BEGIN TRANSACTION;
insert into inventory (film_id, store_id) values((SELECT film_id from film where title = 'Euclidean PI'),1);
insert into inventory (film_id, store_id) values((SELECT film_id from film where title = 'Euclidean PI'),2);
commit;

SELECT *
from inventory
where film_id = 1001
;
ROLLBACK;

-- 8. The Feds have stepped in and have impounded all copies of the pirated film, 
-- "Euclidean PI". The film has been seized from all stores, and needs to be 
-- deleted from the film table. Delete "Euclidean PI" from the film table. 
-- (Did it succeed? Why?)
BEGIN TRANSACTION;
delete from film
where title = 'Euclidean PI'
;
ROLLBACK;
-- Euclidean PI is being referenced from the inventory table

-- 9. Delete Mathmagical from the category table. 
-- (Did it succeed? Why?)
BEGIN TRANSACTION;
delete from category
where name = 'Mathmagical'
;
ROLLBACK;
-- mathmagical is being referenced by other tables

-- 10. Delete all links to Mathmagical in the film_category tale. 
-- (Did it succeed? Why?)
BEGIN TRANSACTION;
delete from film_category
where category_id = 17
;
commit;
-- i believe category_id is not a direct reference and not being utilized by other tables

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI". 
-- (Did either deletes succeed? Why?)

BEGIN TRANSACTION;
delete from category
where name = 'Mathmagical'
;commit; -- now this is not being directly referenced so you can delete it

BEGIN TRANSACTION;
delete from film
where title = 'Euclidean PI'
;
ROLLBACK; -- The actors are sill accessing this information so you cannot delete it

-- 12. Check database metadata to determine all constraints of the film id, and 
-- describe any remaining adjustments needed before the film "Euclidean PI" can 
-- be removed from the film table.
SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS

-- you would need to delete the film_id connection
-- as well as the inventory table link
