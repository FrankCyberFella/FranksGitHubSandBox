-- Write queries to return the following:
-- The following changes are applied to the "pagila" database.**
insert into countrylanguage
(countrycode, language, isofficial, percentage)
values ('USA', 'Klingon', true, 100)
;
update country
set capital = (select id from city where name = 'Houston')
where code = 'USA'
;
delete from country
where code = 'USA'
;

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
begin transaction;

insert into actor
(first_name, last_name)
values ('Hampton', 'Avenue')
;
insert into actor 
(first_name, last_name)
values ('Lisa', 'Byway')
;


commit;


-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in 
-- ancient Greece", to the film table. The movie was released in 2008 in English. 
-- Since its an epic, the run length is 3hrs and 18mins. There are no special 
-- features, the film speaks for itself, and doesn't need any gimmicks.	
begin transaction;

insert into film
 (film_id, title, description, release_year, language_id, length)
values (1001, 'Euclidian PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008, 1, 198)
;


select * 
from film
where title = 'Euclidian PI'
;
commit;


-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly 
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
begin transaction;

insert into film_actor
(film_id, actor_id)
values (1001, 201)
;
insert into film_actor
(film_id, actor_id)
values (1001, 202)
;
select *
from film_actor
where film_id = 1001
;
commit;

-- 4. Add Mathmagical to the category table.
begin transaction;

insert into film
(name)
values ('Mathmagical')
;
commit;


-- 5. Assign the Mathmagical category to the following films, "Euclidean PI", 
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
begin transaction;

insert into film_category
(category_id, film_id)
values (17, 1001)
;

insert into film_category
(category_id, film_id)
values (17, 274)
;
insert into film_category
(category_id, film_id)
values (17, 494)
;
insert into film_category
(category_id, film_id)
values (17, 714)
;
insert into film_category
(category_id, film_id)
values(17, 996)
;

commit;

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films 
-- accordingly.
-- (5 rows affected)
begin transaction;

update film
set rating = 'G'
where film_id in (select film_id from film_category where category_id = 17)
;
select title, rating, film_id
from film 
where rating = 'G'
;

commit;


-- 7. Add a copy of "Euclidean PI" to all the stores.
begin transaction;
insert into inventory (store_id, film_id)
select store_id, (select film_id from film where title = 'Euclidean PI')
from store
;
select inventory_id
from inventory i
join film f
on f.film_id=i.film_id
where f.title = 'Euclidean PI'
;
commit;


-- 8. The Feds have stepped in and have impounded all copies of the pirated film, 
-- "Euclidean PI". The film has been seized from all stores, and needs to be 
-- deleted from the film table. Delete "Euclidean PI" from the film table. 
-- (Did it succeed? Why?)

-- 9. Delete Mathmagical from the category table. 
-- (Did it succeed? Why?)

-- 10. Delete all links to Mathmagical in the film_category table. 
-- (Did it succeed? Why?)

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI". 
-- (Did either deletes succeed? Why?)

-- 12. Check database metadata to determine all constraints of the film id, and 
-- describe any remaining adjustments needed before the film "Euclidean PI" can 
-- be removed from the film table.
