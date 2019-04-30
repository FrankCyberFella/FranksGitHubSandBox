-- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)
Select title from film
inner join film_actor on film.film_id = film_actor.film_id
inner join actor on actor.actor_id = film_actor.actor_id
where first_name = 'NICK' and last_name = 'STALLONE';
-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)
Select title from film
inner join film_actor on film.film_id = film_actor.film_id
inner join actor on actor.actor_id = film_actor.actor_id
where first_name = 'RITA' and last_name = 'REYNOLDS';
-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)
Select title from film
inner join film_actor on film.film_id = film_actor.film_id
inner join actor on actor.actor_id = film_actor.actor_id
where (first_name = 'JUDY' or first_name = 'RIVER') and last_name = 'DEAN';
-- 4. All of the the ‘Documentary’ films
-- (68 rows)
Select title from film
inner join film_category on film_category.film_id = film.film_id
inner join category on category.category_id = film_category.category_id
where name = 'Documentary';
-- 5. All of the ‘Comedy’ films
-- (58 rows)
Select title from film
inner join film_category on film_category.film_id = film.film_id
inner join category on category.category_id = film_category.category_id
where name = 'Comedy';
-- 6. All of the ‘Children’ films that are rated ‘G’
-- (10 rows)
Select title from film
inner join film_category on film_category.film_id = film.film_id
inner join category on category.category_id = film_category.category_id
where name = 'Children' and rating = 'G';
-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
-- (3 rows)
Select title from film
inner join film_category on film_category.film_id = film.film_id
inner join category on category.category_id = film_category.category_id
where name = 'Family' and rating = 'G' and length < 120;
-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
-- (9 rows)
Select title from film
inner join film_actor on film.film_id = film_actor.film_id
inner join actor on actor.actor_id = film_actor.actor_id
where first_name = 'MATTHEW' and last_name = 'LEIGH' and rating = 'G';

-- 9. All of the ‘Sci-Fi’ films released in 2006
-- (61 rows)
Select title from film
inner join film_category on film_category.film_id = film.film_id
inner join category on category.category_id = film_category.category_id
where name = 'Sci-Fi' and release_year = 2006;
-- 10. All of the ‘Action’ films starring Nick Stallone
-- (2 rows)
Select title from film
inner join film_category on film_category.film_id = film.film_id
inner join category on category.category_id = film_category.category_id
inner join film_actor on film.film_id = film_actor.film_id
inner join actor on actor.actor_id = film_actor.actor_id
where name = 'Action' and first_name = 'NICK' and last_name = 'STALLONE';
-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)
select address, city.city, district, country.country  from address
inner join store on address.address_id = store.address_id
inner join city on city.city_id = address.city_id
inner join country on country.country_id = city.country_id;

-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
-- (2 rows)

Select store.store_id, address, first_name || ' ' || last_name as first_last_name
 from store
        inner join address
         on store.address_id = address.address_id
        inner join staff 
         on store.store_id = staff.store_id;

-- 13. The first and last name of the top ten customers ranked by number of rentals 
-- (#1 should be “ELEANOR HUNT” with 46 rentals, #10 should have 39 rentals)
Select first_name, last_name, count(rental_date)
from customer
        inner join rental
         on rental.customer_id = customer.customer_id
GROUP BY first_name, last_name
ORDER BY 3 desc limit 10;


-- 14. The first and last name of the top ten customers ranked by dollars spent 
-- (#1 should be “KARL SEAL” with 221.55 spent, #10 should be “ANA BRADLEY” with 174.66 spent)
Select first_name, last_name, sum(amount)
from customer
        inner join payment
         on customer.customer_id = payment.customer_id
GROUP BY first_name, last_name
ORDER BY 3 desc limit 10;
        
-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store 
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)
SELECT store.store_id, address, count(rental.rental_id) as total_rentals, sum(amount) as total_sales, round(avg(amount)::numeric,2) as avg_sale_per_store
from store 
        inner join
        address
       on address.address_id = store.address_id
       inner join
        inventory
       on store.store_id = inventory.store_id
       inner join
        rental
       on inventory.inventory_id = rental.inventory_id
       inner join
        payment
       on payment.rental_id = rental.rental_id
GROUP BY store.store_id, address;
-- 16. The top ten film titles by number of rentals
-- (#1 should be “BUCKET BROTHERHOOD” with 34 rentals and #10 should have 31 rentals)
SELECT film.title, count(rental_id)
FROM film
        inner join
        inventory
       on inventory.film_id = film.film_id
        inner join
        rental
       on inventory.inventory_id = rental.inventory_id
GROUP BY film.title
ORDER BY 2 desc limit 10;
-- 17. The top five film categories by number of rentals 
-- (#1 should be “Sports” with 1179 rentals and #5 should be “Family” with 1096 rentals)
SELECT category.name, count (rental_id)
FROM category
        inner join
        film_category
       on category.category_id = film_category.category_id
        inner join
        film
       on film_category.film_id = film.film_id
        inner join
        inventory
       on inventory.film_id = film.film_id
        inner join
        rental
       on inventory.inventory_id = rental.inventory_id
GROUP BY category.name
ORDER BY 2 desc limit 5;
-- 18. The top five Action film titles by number of rentals 
-- (#1 should have 30 rentals and #5 should have 28 rentals)
SELECT title, count(rental_id)
FROM film
        inner join
        film_category
       on film.film_id = film_category.film_id
        inner join
        category
       on category.category_id = film_category.category_id
        inner join
        inventory
       on inventory.film_id = film.film_id
        inner join
        rental
       on inventory.inventory_id = rental.inventory_id
WHERE category.name = 'Action'
GROUP BY title
ORDER BY 2 desc limit 5;
-- 19. The top 10 actors ranked by number of rentals of films starring that actor 
-- (#1 should be “GINA DEGENERES” with 753 rentals and #10 should be “SEAN GUINESS” with 599 rentals)
SELECT actor.first_name, actor.last_name, count(rental_id)
FROM actor
        inner join
        film_actor
       on actor.actor_id = film_actor.actor_id
       inner join
       film
       on film_actor.film_id = film.film_id
       inner join
       inventory
       on film.film_id = inventory.film_id
       inner join
       rental
       on inventory.inventory_id = rental.inventory_id
GROUP BY actor.actor_id
ORDER BY 3 DESC limit 10;

-- 20. The top 5 “Comedy” actors ranked by number of rentals of films in the “Comedy” category starring that actor 
-- (#1 should have 87 rentals and #5 should have 72 rentals)
Select first_name, last_name, count(rental_id)
from actor
       inner join
       film_actor
       on actor.actor_id = film_actor.actor_id
       inner join
       film
       on film_actor.film_id = film.film_id
       inner join
       inventory
       on film.film_id = inventory.film_id
       inner join
       rental
       on inventory.inventory_id = rental.inventory_id
       inner join
       film_category
       on film.film_id = film_category.film_id
       inner join
       category
       on film_category.category_id = category.category_id
WHERE category.name = 'Comedy'
GROUP BY first_name, last_name
ORDER BY 3 desc limit 5;