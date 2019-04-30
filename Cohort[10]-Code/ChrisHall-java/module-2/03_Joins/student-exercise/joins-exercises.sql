-- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)
Select title
from film
        inner join
        film_actor
on film.film_id = film_actor.film_id
        inner join
        actor
    on  film_actor.actor_id = actor.actor_id
Where last_name = 'STALLONE'
;

-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)


Select title
from film
        inner join
        film_actor
on film.film_id = film_actor.film_id
        inner join
        actor
    on  film_actor.actor_id = actor.actor_id
Where last_name = 'REYNOLDS' and first_name = 'RITA'
;

-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)
Select title
from film
        inner join
        film_actor
on film.film_id = film_actor.film_id
        inner join
        actor
    on  film_actor.actor_id = actor.actor_id
Where last_name = 'DEAN' and first_name = 'JUDY' or last_name = 'JUDY' and first_name = 'DEAN'
;

-- 4. All of the the ‘Documentary’ films
-- (68 rows)
Select title
from film
        inner join
        film_category
     on film.film_id = film_category.film_id
        inner join
        category
     on film_category.category_id = category.category_id
WHERE name = 'Documentary'
     ;
-- 5. All of the ‘Comedy’ films
-- (58 rows)
Select title
from film
        inner join
        film_category
     on film.film_id = film_category.film_id
        inner join
        category
     on film_category.category_id = category.category_id
WHERE name = 'Comedy'
;
-- 6. All of the ‘Children’ films that are rated ‘G’
-- (10 rows)

Select title 
from film
        inner join
        film_category
     on film.film_id = film_category.film_id
        inner join
        category
     on film_category.category_id = category.category_id
WHERE name = 'Children' 
and rating = 'G'
;
-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
-- (3 rows)

Select title 
from film
        inner join
        film_category
     on film.film_id = film_category.film_id
        inner join
        category
     on film_category.category_id = category.category_id
WHERE name = 'Family' 
and rating = 'G' 
and length < 120
;
-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
-- (9 rows)
Select title
from film
        inner join
        film_actor
on film.film_id = film_actor.film_id
        inner join
        actor
    on  film_actor.actor_id = actor.actor_id
Where last_name = 'LEIGH'
and first_name = 'MATTHEW'
and rating = 'G'
;

-- 9. All of the ‘Sci-Fi’ films released in 2006
-- (61 rows)
Select title 
from film
        inner join
        film_category
     on film.film_id = film_category.film_id
        inner join
        category
     on film_category.category_id = category.category_id
WHERE name = 'Sci-Fi' 
and release_year = 2006
;

-- 10. All of the ‘Action’ films starring Nick Stallone
-- (2 rows)
Select title
from film
        inner join
        film_actor
on film.film_id = film_actor.film_id
        inner join
        actor
    on  film_actor.actor_id = actor.actor_id
        inner join
        film_category
        on film.film_id = film_category.film_id
        inner join
        category
        on film_category.category_id = category.category_id
Where last_name = 'STALLONE'
and first_name = 'NICK'
and name = 'Action'
;
-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)


Select address, city, district, country 
from country
        inner join
        city
on      city.country_id = country.country_id
        inner join
        address
on      address.city_id = city.city_id
        inner join
        store
on      address.address_id = store.address_id        
;

-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
-- (2 rows)

Select  store.store_id, address.address, staff.first_name || ' ' || staff.last_name 
from store
        inner join
        staff
on      staff.store_id = store.store_id
        inner join
        address
on    address.address_id = store.address_id   
-- on address.address_id = staff.address_id
;

-- 13. The first and last name of the top ten customers ranked by number of rentals 
-- (#1 should be “ELEANOR HUNT” with 46 rentals, #10 should have 39 rentals)
--SELECT  count (*), customer.first_name, customer.last_name


Select  count(*), customer.first_name, customer.last_name
from customer
        inner join
        rental
on      customer.customer_id = rental.customer_id
GROUP BY customer.customer_id
ORDER BY count desc
LIMIT 10       
;

-- 14. The first and last name of the top ten customers ranked by dollars spent 
-- (#1 should be “KARL SEAL” with 221.55 spent, #10 should be “ANA BRADLEY” with 174.66 spent)


Select  sum(amount), customer.first_name, customer.last_name 
from    customer
        inner join
        payment
on      customer.customer_id = payment.customer_id
GROUP BY customer.last_name, customer.first_name
ORDER BY sum(amount) desc
LIMIT 10       
;

-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), 
-- and average sale of each store 
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)

Select store.store_id, address, 
count(rental.rental_id), 
sum(amount), 
avg(amount)
from address
        inner join
        store
on      address.address_id = store.address_id
        inner join
        inventory
on      store.store_id = inventory.store_id
        inner join
        rental
on      inventory.inventory_id = rental.inventory_id
        inner join
        payment
on      rental.rental_id = payment.rental_id
GROUP BY store.store_id, address 
ORDER BY store_id      
;



-- 16. The top ten film titles by number of rentals
-- (#1 should be “BUCKET BROTHERHOOD” with 34 rentals and #10 should have 31 rentals)
Select film.title, count(rental_id)
from film
        inner join 
        inventory
on      film.film_id = inventory.film_id
        inner join
        rental
on      inventory.inventory_id = rental.inventory_id
GROUP BY film.title
ORDER BY count(rental_id) desc
LIMIT 10
;

-- 17. The top five film categories by number of rentals 
-- (#1 should be “Sports” with 1179 rentals and #5 should be “Family” with 1096 rentals)
Select category.name, count(rental_id)
from category
        inner join 
        film_category
on      film_category.category_id = category.category_id
        inner join
        film
on      film_category.film_id = film.film_id
        inner join
        inventory
on      film.film_id = inventory.film_id
        inner join 
        rental
on      inventory.inventory_id = rental.inventory_id
GROUP BY category.name
ORDER BY count(rental_id) desc
LIMIT 5
;


-- 18. The top five Action film titles by number of rentals 
-- (#1 should have 30 rentals and #5 should have 28 rentals)

Select film.title, count(rental_id)
from category
        inner join
        film_category
on      category.category_id = film_category.category_id
        inner join 
        film
on      film.film_id = film_category.film_id
        inner join
        inventory
on      inventory.film_id = film.film_id
        inner join 
        rental
on      inventory.inventory_id = rental.inventory_id
WHERE category.name = 'Action'
GROUP BY film.title
ORDER BY count(rental_id) desc
LIMIT 5
;


-- 19. The top 10 actors ranked by number of rentals of films starring that actor 
-- (#1 should be “GINA DEGENERES” with 753 rentals and #10 should be “SEAN GUINESS” with 599 rentals)




Select actor.first_name, actor.last_name, count(rental_id)
from actor
        inner join
        film_actor
on      actor.actor_id = film_actor.actor_id
        inner join
        film
on      film.film_id = film_actor.film_id
        inner join
        inventory
on      inventory.film_id = film.film_id
        inner join 
        rental
on      inventory.inventory_id = rental.inventory_id
GROUP BY actor.actor_id
ORDER BY count(rental_id) desc
LIMIT 10 
;


-- 20. The top 5 “Comedy” actors ranked by number of rentals of films in the “Comedy” category starring that actor 
-- (#1 should have 87 rentals and #5 should have 72 rentals)
Select actor.first_name, actor.last_name, count(rental_id)
from actor
        inner join
        film_actor
on      actor.actor_id = film_actor.actor_id
        inner join
        film
on      film.film_id = film_actor.film_id
        inner join
        inventory
on      inventory.film_id = film.film_id
        inner join 
        rental
on      inventory.inventory_id = rental.inventory_id
        inner join
        film_category
on      film.film_id = film_category.film_id
        inner join
        category
on      category.category_id = film_category.category_id
where   name = 'Comedy'
GROUP BY actor.actor_id
ORDER BY count(rental_id) desc
LIMIT 5 
;
