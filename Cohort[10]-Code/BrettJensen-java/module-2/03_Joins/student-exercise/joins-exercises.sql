-- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)
SELECT title 
FROM film
  INNER JOIN film_actor ON film.film_id = film_actor.film_id
  INNER JOIN actor ON actor.actor_id = film_actor.actor_id
WHERE actor.first_name = 'NICK' AND actor.last_name = 'STALLONE'
;

-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)
SELECT title 
FROM film
  INNER JOIN film_actor ON film.film_id = film_actor.film_id
  INNER JOIN actor ON actor.actor_id = film_actor.actor_id
WHERE actor.first_name = 'RITA' AND actor.last_name = 'REYNOLDS'
;
-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)
SELECT title 
FROM film
  INNER JOIN film_actor ON film.film_id = film_actor.film_id
  INNER JOIN actor ON actor.actor_id = film_actor.actor_id
WHERE actor.first_name = 'JUDY' OR actor.first_name = 'RIVER' AND actor.last_name = 'DEAN'
;
-- 4. All of the the ‘Documentary’ films
-- (68 rows)
SELECT title
FROM film f
  INNER JOIN film_category fc ON fc.film_id = f.film_id
  INNER JOIN category c ON c.category_id = fc.category_id
WHERE c.name = 'Documentary'
;
-- 5. All of the ‘Comedy’ films
-- (58 rows)
SELECT title
FROM film f
  INNER JOIN film_category fc ON fc.film_id = f.film_id
  INNER JOIN category c ON c.category_id = fc.category_id
WHERE c.name = 'Comedy'
;
-- 6. All of the ‘Children’ films that are rated ‘G’
-- (10 rows)
SELECT title
FROM film f
  INNER JOIN film_category fc ON fc.film_id = f.film_id
  INNER JOIN category c ON c.category_id = fc.category_id
WHERE c.name = 'Children' AND f.rating = 'G'
;
-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
-- (3 rows)
SELECT title
FROM film f
  INNER JOIN film_category fc ON fc.film_id = f.film_id
  INNER JOIN category c ON c.category_id = fc.category_id
WHERE c.name = 'Family' AND f.rating = 'G' AND f.length < 120
;
-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
-- (9 rows)
SELECT title 
FROM film
  INNER JOIN film_actor ON film.film_id = film_actor.film_id
  INNER JOIN actor ON actor.actor_id = film_actor.actor_id
WHERE actor.first_name = 'MATTHEW' AND actor.last_name = 'LEIGH' AND film.rating = 'G'
;
-- 9. All of the ‘Sci-Fi’ films released in 2006
-- (61 rows)
SELECT title
FROM film f
  INNER JOIN film_category fc ON fc.film_id = f.film_id
  INNER JOIN category c ON c.category_id = fc.category_id
WHERE c.name = 'Sci-Fi' AND f.release_year = 2006
;
-- 10. All of the ‘Action’ films starring Nick Stallone
-- (2 rows)
SELECT title 
FROM film f
  INNER JOIN film_actor fa ON f.film_id = fa.film_id
  INNER JOIN actor a ON a.actor_id = fa.actor_id
  INNER JOIN film_category fc ON fc.film_id = f.film_id
  INNER JOIN category c ON c.category_id = fc.category_id
WHERE a.first_name = 'NICK' AND a.last_name = 'STALLONE' AND c.name = 'Action'
;
-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)
SELECT a.address, c.city, a.district, co.country
FROM address a
  INNER JOIN store s ON s.address_id = a.address_id
  INNER JOIN city c ON c.city_id = a.city_id
  INNER JOIN country co ON co.country_id = c.country_id
;

-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
-- (2 rows)
SELECT store.store_id, address.address, staff.first_name || ' ' || staff.last_name
FROM store
  INNER JOIN address ON address.address_id = store.address_id
  INNER JOIN staff ON staff.staff_id = store.manager_staff_id
;  
-- 13. The first and last name of the top ten customers ranked by number of rentals 
-- (#1 should be “ELEANOR HUNT” with 46 rentals, #10 should have 39 rentals)
SELECT customer.first_name || ' ' || customer.last_name, count(*) AS rentals
FROM customer
  INNER JOIN rental ON rental.customer_id = customer.customer_id
GROUP BY customer.customer_id
ORDER BY rentals desc
limit 10
;
-- 14. The first and last name of the top ten customers ranked by dollars spent 
-- (#1 should be “KARL SEAL” with 221.55 spent, #10 should be “ANA BRADLEY” with 174.66 spent)
SELECT c.first_name || ' ' || c.last_name, sum(p.amount), sum(p.rental_id)
FROM customer c
  INNER JOIN payment p ON p.customer_id = c.customer_id
GROUP BY c.customer_id
ORDER BY 2 desc
limit 10
;
-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store 
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)
SELECT s.store_id, a.address, count(*) AS rentals, sum(p.amount) AS total_sales, avg(p.amount) AS avg_sale
FROM store s
  INNER JOIN address a ON a.address_id = s.address_id
  INNER JOIN inventory i ON i.store_id = s.store_id
  INNER JOIN rental r ON r.inventory_id = i.inventory_id
  INNER JOIN payment p ON p.rental_id = r.rental_id
GROUP BY s.store_id, a.address
;
-- 16. The top ten film titles by number of rentals
-- (#1 should be “BUCKET BROTHERHOOD” with 34 rentals and #10 should have 31 rentals)
SELECT film.title, count(*)
FROM film
  INNER JOIN inventory i ON i.film_id = film.film_id
  INNER JOIN rental r ON r.inventory_id = i.inventory_id
GROUP BY film.title
ORDER BY 2 desc
LIMIT 10
;

-- 17. The top five film categories by number of rentals 
-- (#1 should be “Sports” with 1179 rentals and #5 should be “Family” with 1096 rentals)
SELECT c.name, count(*)
FROM category c
  INNER JOIN film_category fc ON fc.category_id = c.category_id
  INNER JOIN film f ON f.film_id = fc.film_id
  INNER JOIN inventory i ON i.film_id = f.film_id
  INNER JOIN rental r ON r.inventory_id = i.inventory_id
GROUP BY c.name
ORDER BY 2 desc
LIMIT 5
;
-- 18. The top five Action film titles by number of rentals 
-- (#1 should have 30 rentals and #5 should have 28 rentals)
SELECT film.title, count(*)
FROM film
  INNER JOIN inventory i ON i.film_id = film.film_id
  INNER JOIN rental r ON r.inventory_id = i.inventory_id
  INNER JOIN film_category fc ON fc.film_id = film.film_id
  INNER JOIN category ON category.category_id = fc.category_id
WHERE category.name = 'Action'
GROUP BY film.title
ORDER BY 2 desc
LIMIT 5
;
-- 19. The top 10 actors ranked by number of rentals of films starring that actor 
-- (#1 should be “GINA DEGENERES” with 753 rentals and #10 should be “SEAN GUINESS” with 599 rentals)
SELECT a.first_name || ' ' || a.last_name, count(*) || ' rentals'
FROM actor a
  INNER JOIN film_actor fa ON fa.actor_id = a.actor_id
  INNER JOIN film f ON f.film_id = fa.film_id
  INNER JOIN inventory i ON i.film_id = f.film_id
  INNER JOIN rental r ON r.inventory_id = i.inventory_id
GROUP BY a.actor_id
ORDER BY 2 desc
LIMIT 10
;
-- 20. The top 5 “Comedy” actors ranked by number of rentals of films in the “Comedy” category starring that actor 
-- (#1 should have 87 rentals and #5 should have 72 rentals)
SELECT a.first_name || ' ' || a.last_name, count(*) || ' rentals'
FROM actor a
  INNER JOIN film_actor fa ON fa.actor_id = a.actor_id
  INNER JOIN film f ON f.film_id = fa.film_id
  INNER JOIN inventory i ON i.film_id = f.film_id
  INNER JOIN rental r ON r.inventory_id = i.inventory_id
  INNER JOIN film_category fc ON fc.film_id = f.film_id
  INNER JOIN category ON category.category_id = fc.category_id
WHERE category.name = 'Comedy'
GROUP BY a.actor_id
ORDER BY count(*) desc
LIMIT 5
;