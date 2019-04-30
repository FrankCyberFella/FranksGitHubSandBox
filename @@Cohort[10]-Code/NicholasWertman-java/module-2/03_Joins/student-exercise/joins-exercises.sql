-- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)

Select film.title
From film 
INNER JOIN film_actor 
on film_actor.film_id = film.film_id
INNER JOIN actor
on actor.actor_id = film_actor.actor_id
Where first_name = 'NICK' and last_name = 'STALLONE'
;



-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)

Select film.title
From film 
INNER JOIN film_actor 
on film_actor.film_id = film.film_id
INNER JOIN actor
on actor.actor_id = film_actor.actor_id
Where first_name = 'RITA' and last_name = 'REYNOLDS'
;



-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)

Select film.title
From film 
INNER JOIN film_actor 
on film_actor.film_id = film.film_id
INNER JOIN actor
on actor.actor_id = film_actor.actor_id
Where first_name = 'JUDY' or first_name = 'RIVER' and last_name = 'DEAN'
;


-- 4. All of the the ‘Documentary’ films
-- (68 rows)

Select film.title
From film
INNER JOIN film_category
on film.film_id = film_category.film_id
INNER JOIN category 
on film_category.category_id = category.category_id
Where name = 'Documentary'
;


-- 5. All of the ‘Comedy’ films
-- (58 rows)

Select film.title
From film
INNER JOIN film_category
on film.film_id = film_category.film_id
INNER JOIN category
on film_category.category_id = category.category_id
Where name = 'Comedy'
;

-- 6. All of the ‘Children’ films that are rated ‘G’
-- (10 rows)

SELECT film.title, film.rating
FROM film
INNER JOIN film_category 
ON film.film_id = film_category.film_id 
INNER JOIN category
ON film_category.category_id = category.category_id
WHERE name = 'Children' and rating = 'G'
;

-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
-- (3 rows)

SELECT film.title, film.rating
FROM film 
INNER JOIN film_category
ON film.film_id = film_category.film_id
INNER JOIN category
ON film_category.category_id = category.category_id
WHERE name = 'Family' and rating = 'G' and length < 120
;

-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
-- (9 rows)

SELECT film.title
FROM film
INNER JOIN film_actor
ON film.film_id = film_actor.film_id
INNER JOIN actor
ON film_actor.actor_id = actor.actor_id
WHERE first_name = 'MATTHEW' and last_name = 'LEIGH' and rating = 'G'
;


-- 9. All of the ‘Sci-Fi’ films released in 2006
-- (61 rows)

SELECT film.title
FROM film
INNER JOIN film_category
ON film.film_id = film_category.film_id
INNER JOIN category
ON film_category.category_id = category.category_id
WHERE name = 'Sci-Fi' and film.release_year = 2006
;

-- 10. All of the ‘Action’ films starring Nick Stallone
-- (2 rows)

SELECT film.title
FROM film
INNER JOIN film_category
ON film.film_id = film_category.film_id
INNER JOIN category
ON film_category.category_id = category.category_id
INNER JOIN film_actor
ON film_actor.film_id = film.film_id
INNER JOIN actor 
ON film_actor.actor_id = actor.actor_id
WHERE category.name = 'Action' and first_name = 'NICK' and last_name = 'STALLONE'
;

-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)

SELECT a.address, a.district, c.city, ct.country
FROM store s
INNER JOIN address a
ON s.address_id = a.address_id
INNER JOIN city c
ON a.city_id = c.city_id
INNER JOIN country ct
ON c.country_id = ct.country_id
;

-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
-- (2 rows)

SELECT s.store_id, a.address, first_name, last_name
FROM store s
INNER JOIN address a 
ON s.address_id = a.address_id
INNER JOIN staff st
ON s.manager_staff_id = st.staff_id
;

-- 13. The first and last name of the top ten customers ranked by number of rentals 
-- (#1 should be “ELEANOR HUNT” with 46 rentals, #10 should have 39 rentals)


SELECT c.first_name, c.last_name, count(*)
FROM customer c
INNER JOIN rental r
ON c.customer_id = r.customer_id
GROUP BY c.first_name , c.last_name 
ORDER BY count(*) desc LIMIT 10
;

-- 14. The first and last name of the top ten customers ranked by dollars spent 
-- (#1 should be “KARL SEAL” with 221.55 spent, #10 should be “ANA BRADLEY” with 174.66 spent)


SELECT c.first_name, c.last_name, sum(amount)
FROM customer c
INNER JOIN payment p 
ON p.customer_id = c.customer_id
GROUP BY c.first_name, c.last_name
ORDER BY sum(amount) desc LIMIT 10
;




-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store 
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)

SELECT s.store_id, a.address, count(*), SUM(amount), AVG(amount)
FROM store s
INNER JOIN address a
ON s.address_id = a.address_id
INNER JOIN inventory i
ON s.store_id = i.store_id
INNER JOIN rental r
ON i.inventory_id = r.inventory_id
INNER JOIN payment p
ON r.rental_id = p.rental_id
GROUP BY s.store_id, a.address
order by s.store_id asc 
;


-- 16. The top ten film titles by number of rentals
-- (#1 should be “BUCKET BROTHERHOOD” with 34 rentals and #10 should have 31 rentals)

Select f.title, count(*)
FROM film f
INNER JOIN inventory i
ON f.film_id = i.film_id
INNER JOIN rental r
ON i.inventory_id = r.inventory_id
GROUP BY f.title
ORDER BY count(*) desc LIMIT 10
;


-- 17. The top five film categories by number of rentals 
-- (#1 should be “Sports” with 1179 rentals and #5 should be “Family” with 1096 rentals)

SELECT c.name, count(*)
FROM film f 
INNER JOIN film_category fc
ON f.film_id = fc.film_id
INNER JOIN category c
ON fc.category_id = c.category_id
INNER JOIN inventory i
ON f.film_id = i.film_id
INNER JOIN rental r
ON i.inventory_id = r.inventory_id
GROUP BY c.name
ORDER BY count(*) desc LIMIT 5
;

-- 18. The top five Action film titles by number of rentals 
-- (#1 should have 30 rentals and #5 should have 28 rentals)

SELECT f.title, count(*)
FROM film f
INNER JOIN film_category fc
ON f.film_id = fc.film_id
INNER JOIN category c
ON fc.category_id = c.category_id
INNER JOIN inventory i
ON f.film_id = i.film_id 
INNER JOIN rental r
ON i.inventory_id = r.inventory_id
WHERE c.name = 'Action'
GROUP BY f.title
ORDER BY count(*) desc limit 5
;



-- 19. The top 10 actors ranked by number of rentals of films starring that actor 
-- (#1 should be “GINA DEGENERES” with 753 rentals and #10 should be “SEAN GUINESS” with 599 rentals)

SELECT first_name, last_name, count(*)
FROM film f
INNER JOIN film_actor fa
ON f.film_id = fa.film_id
INNER JOIN actor a 
ON fa.actor_id = a.actor_id
INNER JOIN  inventory i
ON f.film_id = i.film_id
INNER JOIN rental r 
ON i.inventory_id = r.inventory_id
GROUP BY first_name, last_name, a.actor_id
ORDER BY count(*) desc LIMIT 10
;

-- 20. The top 5 “Comedy” actors ranked by number of rentals of films in the “Comedy” category starring that actor 
-- (#1 should have 87 rentals and #5 should have 72 rentals)

SELECT first_name, last_name, count(*)
FROM film f 
INNER JOIN film_actor fa
ON f.film_id = fa.film_id 
INNER JOIN actor a 
ON fa.actor_id = a.actor_id
INNER JOIN inventory i
ON f.film_id = i.film_id
INNER JOIN rental r
ON i.inventory_id = r.inventory_id
INNER JOIN film_category fc
ON f.film_id = fc.film_id
INNER JOIN category c 
ON fc.category_id = c.category_id
WHERE c.name = 'Comedy'
GROUP BY first_name, last_name, a.actor_id
ORDER BY count(*) desc LIMIT 5
;




