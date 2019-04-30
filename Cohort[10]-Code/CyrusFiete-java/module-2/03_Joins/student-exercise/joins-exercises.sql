-- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)

SELECT title
FROM film
INNER JOIN  film_actor ON film_actor.film_id = film.film_id
INNER JOIN actor ON actor.actor_id = film_actor.actor_id
WHERE first_name = 'NICK'
AND last_name = 'STALLONE'
;

-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)

SELECT title
FROM film
INNER JOIN  film_actor ON film_actor.film_id = film.film_id
INNER JOIN actor ON actor.actor_id = film_actor.actor_id
WHERE first_name = 'RITA'
AND last_name = 'REYNOLDS'
;

-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)

SELECT title
FROM film
INNER JOIN  film_actor ON film_actor.film_id = film.film_id
INNER JOIN actor ON actor.actor_id = film_actor.actor_id
WHERE first_name IN ('JUDY', 'RIVER')
AND last_name = 'DEAN'
;

-- 4. All of the the ‘Documentary’ films
-- (68 rows)

SELECT title
FROM film
INNER JOIN film_category ON film_category.film_id = film.film_id
INNER JOIN category ON category.category_id = film_category.category_id
WHERE name = 'Documentary'
;

-- 5. All of the ‘Comedy’ films
-- (58 rows)

SELECT title
FROM film
INNER JOIN film_category ON film_category.film_id = film.film_id
INNER JOIN category ON category.category_id = film_category.category_id
WHERE name = 'Comedy'
;

-- 6. All of the ‘Children’ films that are rated ‘G’
-- (10 rows)

SELECT title
FROM film
INNER JOIN film_category ON film_category.film_id = film.film_id
INNER JOIN category ON category.category_id = film_category.category_id
WHERE name = 'Children'
AND rating = 'G'
;

-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
-- (3 rows)

SELECT title
FROM film
INNER JOIN film_category ON film_category.film_id = film.film_id
INNER JOIN category ON category.category_id = film_category.category_id
WHERE name = 'Family'
AND rating = 'G'
AND length < 120
;

-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
-- (9 rows)

SELECT title
FROM film
INNER JOIN  film_actor ON film_actor.film_id = film.film_id
INNER JOIN actor ON actor.actor_id = film_actor.actor_id
WHERE first_name = 'MATTHEW'
AND last_name = 'LEIGH'
AND rating = 'G'
;

-- 9. All of the ‘Sci-Fi’ films released in 2006
-- (61 rows)

SELECT title
FROM film
INNER JOIN film_category ON film_category.film_id = film.film_id
INNER JOIN category ON category.category_id = film_category.category_id
WHERE name = 'Sci-Fi'
AND release_year = 2006
;

-- 10. All of the ‘Action’ films starring Nick Stallone
-- (2 rows)

SELECT title
FROM film
INNER JOIN film_category ON film_category.film_id = film.film_id
INNER JOIN category ON category.category_id = film_category.category_id
INNER JOIN  film_actor ON film_actor.film_id = film.film_id
INNER JOIN actor ON actor.actor_id = film_actor.actor_id
WHERE name = 'Action'
AND first_name = 'NICK'
AND last_name = 'STALLONE'
;

-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)

SELECT address AS street_address, city, district, country
FROM store
INNER JOIN address ON address.address_id = store.address_id
INNER JOIN city ON city.city_id = address.city_id
INNER JOIN country ON country.country_id = city.country_id
;

-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
-- (2 rows)

SELECT store.store_id, address AS street_address, staff.first_name || ' ' || staff.last_name AS manager
FROM store
INNER JOIN address ON address.address_id = store.address_id
INNER JOIN staff ON staff.staff_id = store.manager_staff_id
;

-- 13. The first and last name of the top ten customers ranked by number of rentals 
-- (#1 should be “ELEANOR HUNT” with 46 rentals, #10 should have 39 rentals)

SELECT first_name || ' ' || last_name AS name, count(*) AS rentals
FROM customer
INNER JOIN rental ON rental.customer_id = customer.customer_id
GROUP BY customer.customer_id
ORDER BY 2 DESC
LIMIT 10
;

-- 14. The first and last name of the top ten customers ranked by dollars spent 
-- (#1 should be “KARL SEAL” with 221.55 spent, #10 should be “ANA BRADLEY” with 174.66 spent)

SELECT first_name || ' ' || last_name AS name, sum(amount) AS spendings
FROM customer
INNER JOIN payment ON payment.customer_id = customer.customer_id
GROUP BY customer.customer_id
ORDER BY 2 DESC
LIMIT 10
;

-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store 
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)

SELECT store.store_id, address AS street_address, count(*), sum(amount) AS payments, avg(amount)
FROM store
INNER JOIN address ON address.address_id = store.address_id
INNER JOIN inventory ON inventory.store_id = store.store_id
INNER JOIN rental ON rental.inventory_id = inventory.inventory_id
INNER JOIN payment ON rental.rental_id = payment.rental_id
GROUP BY store.store_id, address.address
ORDER BY 1
;

-- 16. The top ten film titles by number of rentals
-- (#1 should be “BUCKET BROTHERHOOD” with 34 rentals and #10 should have 31 rentals)

SELECT title, count(*)
FROM film
INNER JOIN inventory ON inventory.film_id = film.film_id
INNER JOIN rental ON rental.inventory_id = inventory.inventory_id
GROUP BY title
ORDER BY 2 DESC
LIMIT 10
; 

-- 17. The top five film categories by number of rentals 
-- (#1 should be “Sports” with 1179 rentals and #5 should be “Family” with 1096 rentals)

SELECT category.name, count(*)
FROM category
INNER JOIN film_category ON film_category.category_id = category.category_id
INNER JOIN inventory ON inventory.film_id = film_category.film_id
INNER JOIN rental ON rental.inventory_id = inventory.inventory_id
GROUP BY 1
ORDER BY 2 DESC
LIMIT 5
; 

-- 18. The top five Action film titles by number of rentals 
-- (#1 should have 30 rentals and #5 should have 28 rentals)

SELECT title, count(*)
FROM film
INNER JOIN film_category ON film_category.film_id = film.film_id
INNER JOIN category ON category.category_id = film_category.category_id
INNER JOIN inventory ON inventory.film_id = film_category.film_id
INNER JOIN rental ON rental.inventory_id = inventory.inventory_id
WHERE category.name = 'Action'
GROUP BY 1
ORDER BY 2 DESC
LIMIT 5
;

-- 19. The top 10 actors ranked by number of rentals of films starring that actor 
-- (#1 should be “GINA DEGENERES” with 753 rentals and #10 should be “SEAN GUINESS” with 599 rentals)

SELECT first_name || ' ' || last_name AS actor_name, count(*)
FROM actor
INNER JOIN film_actor ON film_actor.actor_id = actor.actor_id
INNER JOIN film ON film.film_id = film_actor.film_id
INNER JOIN inventory ON inventory.film_id = film.film_id
INNER JOIN rental ON rental.inventory_id = inventory.inventory_id
GROUP BY actor.actor_id
ORDER BY 2 DESC
;

-- 20. The top 5 “Comedy” actors ranked by number of rentals of films in the “Comedy” category starring that actor 
-- (#1 should have 87 rentals and #5 should have 72 rentals)

SELECT first_name || ' ' || last_name AS actor_name, count(*)
FROM actor
INNER JOIN film_actor ON film_actor.actor_id = actor.actor_id
INNER JOIN film ON film.film_id = film_actor.film_id
INNER JOIN inventory ON inventory.film_id = film.film_id
INNER JOIN rental ON rental.inventory_id = inventory.inventory_id
INNER JOIN film_category ON film_category.film_id = film.film_id
INNER JOIN category ON film_category.category_id = category.category_id
WHERE category.name = 'Comedy'
GROUP BY actor.actor_id
ORDER BY 2 DESC
LIMIT 5
;
