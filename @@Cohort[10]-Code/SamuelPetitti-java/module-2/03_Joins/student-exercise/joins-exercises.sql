-- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)
SELECT title
FROM film
        inner join
        film_actor 
      on film.film_id = film_actor.film_id
        inner join
         actor
      on film_actor.actor_id = actor.actor_id
WHERE first_name = 'NICK' and last_name = 'STALLONE';

-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)
SELECT title
FROM film f
        inner join
        film_actor fa
     on f.film_id = fa.film_id
        inner join
        actor a
     on fa.actor_id = a.actor_id
WHERE first_name = 'RITA' and last_name = 'REYNOLDS';
    
-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)
SELECT title
FROM film f
        inner join
        film_actor fa
      on f.film_id = fa.film_id  
        inner join
        actor a
      on fa.actor_id = a.actor_id
WHERE  first_name = 'JUDY' and last_name = 'DEAN' or
        first_name = 'RIVER' and last_name = 'DEAN';
        
-- 4. All of the the ‘Documentary’ films
-- (68 rows)
SELECT title
FROM film_category fc
        inner join
        film f
       on  f.film_id = fc.film_id
        inner join
        category c
       on c.category_id = fc.category_id
WHERE c.name  = 'Documentary';
       
-- 5. All of the ‘Comedy’ films
-- (58 rows)
SELECT title
FROM film_category fc
        inner join
        film f
       on  f.film_id = fc.film_id
        inner join
        category c
       on c.category_id = fc.category_id
WHERE c.name  = 'Comedy';
       
-- 6. All of the ‘Children’ films that are rated ‘G’
-- (10 rows)
SELECT title
FROM film f
        inner join
        film_category fc
       on  f.film_id = fc.film_id
        inner join
        category c
       on c.category_id = fc.category_id
WHERE c.name  = 'Children' and f.rating = 'G';
       

-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
-- (3 rows)
SELECT title
FROM film f
        inner join
        film_category fc
      on f.film_id = fc.film_id
        inner join
        category c
      on c.category_id = fc.category_id
WHERE c.name = 'Family' and f.rating = 'G' and f.length < 120;


-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
-- (9 rows)
SELECT title
FROM film f
        inner join
        film_actor fa
      on f.film_id = fa.film_id
        inner join
        actor a
      on fa.actor_id = a.actor_id
WHERE f.rating = 'G' and a.first_name = 'MATTHEW' and a.last_name = 'LEIGH';
-- 9. All of the ‘Sci-Fi’ films released in 2006
-- (61 rows)
SELECT title
FROM film f
     inner join
     film_category fc
   on f.film_id = fc.film_id
     inner join
     category c
   on fc.category_id = c.category_id
WHERE c.name = 'Sci-Fi' and f.release_year = '2006';

-- 10. All of the ‘Action’ films starring Nick Stallone
-- (2 rows)
SELECT title
FROM film f
       inner join
       film_actor fa
     on f.film_id = fa.film_id
        inner join
        actor a
      on a.actor_id = fa.actor_id
        inner join
        film_category fc
      on f.film_id = fc.film_id
        inner join
        category c 
      on fc.category_id = c.category_id
 WHERE a.first_name = 'NICK' and a.last_name = 'STALLONE' and c.name = 'Action';
-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)
SELECT  ad.address, ad.district, ci.city, co.country
FROM store st
        inner join
        address ad
      on st.address_id = ad.address_id
        inner join
        city ci
      on ad.city_id = ci.city_id
        inner join
        country co
      on ci.country_id = co.country_id;
      
-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
-- (2 rows)
SELECT sto.store_id, ad.address, sta.first_name || ', ' || sta.last_name as Manager
FROM store sto
        inner join
        staff sta
      on sto.store_id = sta.store_id
        inner join
        address ad
      on sto.address_id = ad.address_id;

-- 13. The first and last name of the top ten customers ranked by number of rentals 
-- (#1 should be “ELEANOR HUNT” with 46 rentals, #10 should have 39 rentals)
SELECT c.first_name, c.last_name, count(rental_date)
FROM customer c
        inner join
        rental r
      on c.customer_id = r.customer_id
GROUP by c.last_name, c.first_name
ORDER by count desc
LIMIT 10;

-- 14. The first and last name of the top ten customers ranked by dollars spent 
-- (#1 should be “KARL SEAL” with 221.55 spent, #10 should be “ANA BRADLEY” with 174.66 spent)
SELECT first_name, last_name, sum(p.amount)
FROM customer c
        inner join
        rental r
      on c.customer_id = r.customer_id
       inner join
        payment p
      on r.rental_id = p.rental_id
 GROUP by c.last_name, c.first_name
 ORDER by sum desc
 LIMIT 10;

-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store 
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)
SELECT sum(pay.amount) as Total_Sales, avg(pay.amount) as AVG_payment, count(rent.rental_id), sto.store_Id, ad.address
FROM address ad
        inner join
        store sto
      on ad.address_id = sto.address_id
        inner join
        inventory inv
      on inv.store_id = sto.store_id
        inner join
        rental rent
      on inv.inventory_id = rent.inventory_id
        inner join
        payment pay
      on rent.rental_id = pay.rental_id
GROUP by sto.store_id, ad.address
ORDER by count(rent.rental_id) desc;





-- 16. The top ten film titles by number of rentals
-- (#1 should be “BUCKET BROTHERHOOD” with 34 rentals and #10 should have 31 rentals)
SELECT f.title, count(r.rental_date)
FROM film f
        inner join
        inventory i
     on f.film_id = i.film_id
        inner join
        rental r
     on i.inventory_id = r.inventory_id
GROUP by f.title
ORDER by count desc
LIMIT 10;

-- 17. The top five film categories by number of rentals 
-- (#1 should be “Sports” with 1179 rentals and #5 should be “Family” with 1096 rentals)
SELECT c.name , count(r.rental_date)
FROM category c
        inner join
        film_category fc
      on c.category_id = fc.category_id
        inner join
        film f
     on fc.film_id = f.film_id
        inner join
        inventory i
     on f.film_id = i.film_id
        inner join
        rental r
     on i.inventory_id = r.inventory_id
GROUP by c.name
ORDER by count desc
LIMIT 5;

-- 18. The top five Action film titles by number of rentals 
-- (#1 should have 30 rentals and #5 should have 28 rentals)
SELECT f.title , count(r.rental_date)
FROM category c
        inner join
        film_category fc
      on c.category_id = fc.category_id
        inner join
        film f
     on fc.film_id = f.film_id
        inner join
        inventory i
     on f.film_id = i.film_id
        inner join
        rental r
     on i.inventory_id = r.inventory_id
WHERE c.name = 'Action'
GROUP by f.title
ORDER by count desc
LIMIT 5;

-- 19. The top 10 actors ranked by number of rentals of films starring that actor 
-- (#1 should be “GINA DEGENERES” with 753 rentals and #10 should be “SEAN GUINESS” with 599 rentals)
SELECT a.first_name || ', ' || a.last_name as Actor, count(r.rental_date) as rentals
FROM actor a
        inner join
       film_actor fa
      on a.actor_id = fa.actor_id
        inner join
        film f
     on fa.film_id = f.film_id
        inner join
        inventory i
     on f.film_id = i.film_id
        inner join
        rental r
     on i.inventory_id = r.inventory_id
GROUP by a.first_name || ', ' || a.last_name, a.actor_id
ORDER by rentals desc
LIMIT 10;

-- 20. The top 5 “Comedy” actors ranked by number of rentals of films in the “Comedy” category starring that actor 
-- (#1 should have 87 rentals and #5 should have 72 rentals)
SELECT a.first_name || ', ' || a.last_name as Actor , count(r.rental_date) as rentals
FROM actor a
       inner join
       film_actor fa
     on a.actor_id = fa.actor_id
        inner join
        film f
     on fa.film_id = f.film_id
        inner join
        inventory i
     on f.film_id = i.film_id
        inner join
        rental r
     on i.inventory_id = r.inventory_id
        inner join
        film_category fc
     on f.film_id = fc.film_id
        inner join
        category c
     on c.category_id = fc.category_id
WHERE c.name = 'Comedy'
GROUP by a.first_name || ', ' || a.last_name 
ORDER by rentals desc
LIMIT 5;

