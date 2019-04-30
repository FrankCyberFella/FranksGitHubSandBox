-- Write queries to return the following:
-- The following changes are applied to the "pagila" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
BEGIN TRANSACTION;
INSERT into actor (actor_id, first_name, last_name)
values (201, 'Hampton', 'Avenue'), (202, 'Lisa', 'Byway');

Select *
from actor;

commit;


-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in 
-- ancient Greece", to the film table. The movie was released in 2008 in English. 
-- Since its an epic, the run length is 3hrs and 18mins. There are no special 
-- features, the film speaks for itself, and doesn't need any gimmicks.	
BEGIN TRANSACTION;

Insert into film (film_id, title, description, release_year, language_id, length)
VALUES (1001, 'Euclidean PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008, 1, 198);

select *
from film
where film_id = 1001;

commit;

-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly 
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
BEGIN TRANSACTION;

Insert into film_actor (film_id, actor_id)
values (1001, 201), (1001, 202);


Select title, actor.first_name || ' ' || actor.last_name as first_last_name
from film
inner join film_actor 
on film.film_id = film_actor.film_id
inner join actor
on film_actor.actor_id = actor.actor_id
where film.film_id = 1001;

commit;

-- 4. Add Mathmagical to the category table.
BEGIN TRANSACTION;
Insert into category (name)
values ('Mathmagical');

select *
from category;

commit;



-- 5. Assign the Mathmagical category to the following films, "Euclidean PI", 
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
BEGIN TRANSACTION;
Insert into film_category (film_id, category_id)
values ((Select film_id from film where title = 'Euclidean PI'), (Select category_id from category where name = 'Mathmagical')),
        ((Select film_id from film where title = 'EGG IGBY'), (Select category_id from category where name= 'Mathmagical')),
        ((Select film_id from film where title = 'KARATE MOON'), (Select category_id from category where name = 'Mathmagical')),
        ((Select film_id from film where title = 'RANDOM GO'), (Select category_id from category where name = 'Mathmagical')),
        ((Select film_id from film where title = 'YOUNG LANGUAGE'), (Select category_id from category where name = 'Mathmagical'));

SELECT title, category.name, rating
from film
inner join film_category
on film.film_id = film_category.film_id
inner join category
on film_category.category_id = category.category_id
WHERE category.name = 'Mathmagical';

commit;

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films 
-- accordingly.
-- (5 rows affected)
BEGIN TRANSACTION;
UPDATE film
set rating = 'G'
WHERE film.film_id in (Select film_id from film_category where category_id = (Select category_id from category where name = 'Mathmagical'));

SELECT title, category.name, rating
from film
inner join film_category
on film.film_id = film_category.film_id
inner join category
on film_category.category_id = category.category_id
WHERE category.name = 'Mathmagical';

commit;

-- 7. Add a copy of "Euclidean PI" to all the stores.
BEGIN TRANSACTION;
INSERT into inventory (film_id, store_id)
values ((select film_id from film where title = 'Euclidean PI'), 1),
        ((select film_id from film where title = 'Euclidean PI'), 2);
        
select *, title
from inventory
inner join film
on film.film_id = inventory.film_id
where title = 'Euclidean PI';

commit;


-- 8. The Feds have stepped in and have impounded all copies of the pirated film, 
-- "Euclidean PI". The film has been seized from all stores, and needs to be 
-- deleted from the film table. Delete "Euclidean PI" from the film table. 
-- (Did it succeed? Why?)
BEGIN TRANSACTION;
DELETE from film
where title = 'Euclidean PI';

SELECT film_id, title
from film
where title = 'Euclidean PI';

rollback;
-- it did not succeed.  euclidean pi contains a primary key that film_category is dependent on


-- 9. Delete Mathmagical from the category table. 
-- (Did it succeed? Why?)
BEGIN TRANSACTION;
Delete from category
where name = 'Mathmagical';

select *
from category;

rollback;
--it did not work.  mathmagical is still a foreign key on the fim_category table

-- 10. Delete all links to Mathmagical in the film_category tale. 
-- (Did it succeed? Why?)

BEGIN TRANSACTION;
Delete from film_category
where category_id = 21;

select *
from film_category;

commit;
-- it worked because the associated category_id was not a FK in a related table

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI". 
-- (Did either deletes succeed? Why?)
BEGIN TRANSACTION;
Delete from category
where name = 'Mathmagical';

select *
from category;

rollback;
--Yes it worked because mathmagical no longer existed in the foreign key


-- 12. Check database metadata to determine all constraints of the film id, and 
-- describe any remaining adjustments needed before the film "Euclidean PI" can 
-- be removed from the film table.

--For Eudclidean PI to be deleted it would need to first be deleted in the film_actor, film_category, and inventory tables.  
-- then it could be deleted from film
