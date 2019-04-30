-- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)
SELECT title
  FROM film f
  INNER JOIN film_actor fa
  ON f.film_id = fa.film_id
  INNER JOIN actor a
  ON fa.actor_id=a.actor_id
  WHERE a.first_name='NICK'
  AND a.last_name='STALLONE'
  ;


-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)
SELECT title
  FROM film f
  INNER JOIN film_actor fa
  ON f.film_id = fa.film_id
  INNER JOIN actor a
  ON fa.actor_id=a.actor_id
  WHERE a.first_name='RITA'
  AND a.last_name='REYNOLDS'
  ;

-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)
SELECT title
  FROM film f
  INNER JOIN film_actor fa
  ON f.film_id = fa.film_id
  INNER JOIN actor a
  ON fa.actor_id=a.actor_id
  WHERE (a.first_name='JUDY'
  OR a.first_name='RIVER')
  AND a.last_name='DEAN'
  
  ;
-- 4. All of the the ‘Documentary’ films
-- (68 rows)
SELECT title
  FROM film f
  INNER JOIN film_category fc
  ON f.film_id=fc.film_id
  INNER JOIN category c
  ON fc.category_id=c.category_id
  WHERE c.name ilike 'documentary'
  ;

-- 5. All of the ‘Comedy’ films
-- (58 rows)
SELECT title
  FROM film f
  INNER JOIN film_category fc
  ON f.film_id=fc.film_id
  INNER JOIN category c
  ON fc.category_id=c.category_id
  WHERE c.name ilike 'comedy'
  ;

-- 6. All of the ‘Children’ films that are rated ‘G’
-- (10 rows)
SELECT title
  FROM film f
  INNER JOIN film_category fc
  ON f.film_id=fc.film_id
  INNER JOIN category c
  ON fc.category_id=c.category_id
  WHERE c.name ilike 'children'
  AND f.rating='G'
  ;

-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
-- (3 rows)
SELECT title
  FROM film f
  INNER JOIN film_category fc
  ON f.film_id=fc.film_id
  INNER JOIN category c
  ON fc.category_id=c.category_id
  WHERE c.name ilike 'family'
  AND f.rating='G'
  AND f.length<120
  ;

-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
-- (9 rows)
SELECT title
  FROM film f
  INNER JOIN film_actor fa
  ON f.film_id = fa.film_id
  INNER JOIN actor a
  ON fa.actor_id=a.actor_id
  WHERE a.first_name||' '||a.last_name='MATTHEW LEIGH'
  AND f.rating='G'
  ;
-- 9. All of the ‘Sci-Fi’ films released in 2006
-- (61 rows)
SELECT title
  FROM film f
  INNER JOIN film_category fc
  ON f.film_id=fc.film_id
  INNER JOIN category c
  ON fc.category_id=c.category_id
  WHERE c.name ilike 'sci-fi'
  AND f.release_year=2006
  ;
-- 10. All of the ‘Action’ films starring Nick Stallone
-- (2 rows)
SELECT title
  FROM film f
  JOIN film_actor fa
  ON f.film_id=fa.film_id
  JOIN actor a
  ON fa.actor_id=a.actor_id
  JOIN film_category fc
  ON f.film_id=fc.film_id
  JOIN category c
  ON fc.category_id=c.category_id
  WHERE c.name ilike 'action'
  AND a.first_name || ' ' || a.last_name ilike 'NICK STALLONE'
  ;
-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)
SELECT a.address, c.city, a.district, co.country
  FROM store s
  JOIN address a
  on s.address_id=a.address_id
  JOIN city c
  ON a.city_id=c.city_id
  JOIN country co
  ON co.country_id=c.country_id
  ;  
-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
-- (2 rows)
SELECT s.store_id, a.address, st.first_name||' '||st.last_name as manager_name
  FROM store s
  JOIN address a
  ON s.address_id = a.address_id
  JOIN staff st
  ON st.staff_id=s.manager_staff_id
  ;

-- 13. The first and last name of the top ten customers ranked by number of rentals 
-- (#1 should be “ELEANOR HUNT” with 46 rentals, #10 should have 39 rentals)
SELECT c.first_name||' '||c.last_name as customer_name, count(r.rental_id) as rentals
  FROM customer c
  JOIN rental r
  ON c.customer_id=r.customer_id
  GROUP BY customer_name
  ORDER BY rentals DESC
  LIMIT 10
  ;

-- 14. The first and last name of the top ten customers ranked by dollars spent 
-- (#1 should be “KARL SEAL” with 221.55 spent, #10 should be “ANA BRADLEY” with 174.66 spent)
SELECT c.first_name||' '||c.last_name as customer_name, sum(p.amount) as dollars_spent
  FROM customer c
  JOIN payment p
  ON c.customer_id=p.customer_id
  GROUP BY customer_name
  ORDER BY dollars_spent DESC
  LIMIT 10
  ;

-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store 
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)
SELECT s.store_id, a.address, count(r.rental_id) as total_rentals, sum(p.amount) as total_sales, round(avg(p.amount),2) as average_sale
  FROM store s
  JOIN address a
  ON s.address_id=a.address_id
  JOIN inventory i
  ON i.store_id=s.store_id
  JOIN rental r
  ON r.inventory_id=i.inventory_id
  JOIN payment p
  ON r.rental_id=p.rental_id
  GROUP BY s.store_id, a.address
  ORDER BY s.store_id
  ;

-- 16. The top ten film titles by number of rentals
-- (#1 should be “BUCKET BROTHERHOOD” with 34 rentals and #10 should have 31 rentals)
SELECT title, count(r.rental_id) as rentals
  FROM film f
  JOIN inventory i
  ON f.film_id=i.film_id
  JOIN rental r
  ON r.inventory_id=i.inventory_id
  GROUP BY f.title
  ORDER BY rentals DESC
  LIMIT 10
  ;

-- 17. The top five film categories by number of rentals 
-- (#1 should be “Sports” with 1179 rentals and #5 should be “Family” with 1096 rentals)
SELECT cat.name, count(r.rental_id) as category_rentals
  FROM category cat
  JOIN film_category fc
  ON cat.category_id=fc.category_id
  JOIN film f
  ON f.film_id=fc.film_id
  JOIN inventory i
  ON f.film_id=i.film_id
  JOIN rental r
  ON r.inventory_id=i.inventory_id
  GROUP BY cat.category_id
  ORDER BY category_rentals DESC
  LIMIT 5
  ;
  

-- 18. The top five Action film titles by number of rentals 
-- (#1 should have 30 rentals and #5 should have 28 rentals)
SELECT f.title, count(r.rental_id) as film_rentals
  FROM category cat
  JOIN film_category fc
  ON cat.category_id=fc.category_id
  JOIN film f
  ON f.film_id=fc.film_id
  JOIN inventory i
  ON f.film_id=i.film_id
  JOIN rental r
  ON r.inventory_id=i.inventory_id
  WHERE cat.name ilike 'action'
  GROUP BY f.title
  ORDER BY film_rentals DESC
  LIMIT 5
  ;

-- 19. The top 10 actors ranked by number of rentals of films starring that actor 
-- (#1 should be “GINA DEGENERES” with 753 rentals and #10 should be “SEAN GUINESS” with 599 rentals)
SELECT a.first_name||' '||a.last_name as actor_name, count(r.rental_id) as starred_films
  FROM actor a
  JOIN film_actor fa
  ON a.actor_id=fa.actor_id
  JOIN film f
  ON f.film_id=fa.film_id
  JOIN inventory i
  ON i.film_id=f.film_id
  JOIN rental r
  ON i.inventory_id=r.inventory_id
  GROUP BY a.actor_id
  ORDER BY starred_films DESC
  LIMIT 10
  ;


-- 20. The top 5 “Comedy” actors ranked by number of rentals of films in the “Comedy” category starring that actor 
-- (#1 should have 87 rentals and #5 should have 72 rentals)
SELECT a.first_name||' '||a.last_name as actor_name, count(r.rental_id) as comedy_stars
  FROM actor a
  JOIN film_actor fa
  ON a.actor_id=fa.actor_id
  JOIN film f
  ON f.film_id=fa.film_id
  JOIN inventory i
  ON i.film_id=f.film_id
  JOIN rental r
  ON i.inventory_id=r.inventory_id
  JOIN film_category fc
  ON f.film_id=fc.film_id
  JOIN category c
  ON c.category_id=fc.category_id
  WHERE c.name ilike 'Comedy'
  GROUP BY actor_name
  ORDER BY comedy_stars DESC
  LIMIT 5
  ;
