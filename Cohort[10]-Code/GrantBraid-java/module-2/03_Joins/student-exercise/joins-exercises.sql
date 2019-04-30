-- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)
SELECT  film.title, film.film_id
from actor
        inner join film_actor
     on actor.actor_id = film_actor.actor_id
        inner join film
     on film_actor.film_id = film.film_id
 where actor.first_name = 'NICK'  AND actor.last_name = 'STALLONE'
 ;

-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)
SELECT title, F.film_id
from actor A
        inner join film_actor FA
     on A.actor_id = FA.actor_id
        inner join film F
     on F.film_id = FA.film_id
where A.first_name = 'RITA' AND A.last_name = 'REYNOLDS'
;

-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)
SELECT A.first_name || ', ' || A.last_name as Actor_Name , F.title
from actor A
        inner join film_actor FA
     on A.actor_id = FA.actor_id
        inner join film F
     on FA.film_id = F.film_id
where (A.first_name = 'JUDY' AND A.last_name = 'DEAN') 
     or (A.first_name = 'RIVER' AND A.last_name = 'DEAN')
     ;

-- 4. All of the the ‘Documentary’ films
-- (68 rows)
SELECT title, C.name
from category C
        inner join film_category FC
     on C.category_id = FC.category_id
        inner join film F
     on F.film_id = FC.film_id
where C.name = 'Documentary'
;

-- 5. All of the ‘Comedy’ films
-- (58 rows)
SELECT title, C.name
from category C
        inner join film_category FC
     on C.category_id = FC.category_id
        inner join film F
     on FC.film_id = F.film_id
where C.name = 'Comedy'
;

-- 6. All of the ‘Children’ films that are rated ‘G’
-- (10 rows)
SELECT title, C.name, F.rating
from category C
        inner join film_category FC
     on C.category_id = FC.category_id
        inner join film F
     on FC.film_id = F.film_id
where C.name = 'Children' AND F.rating = 'G'
;

-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
-- (3 rows)
SELECT title , F.rating, F.length
from category C
        inner join film_category FC
     on C.category_id = FC.category_id
        inner join film F
     on FC.film_id = F.film_id
where C.name = 'Family' AND F.rating = 'G' AND F.length < 120
;

-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
-- (9 rows)
SELECT title , F.rating
FROM actor A
        inner join film_actor FA
     on A.actor_id = FA.actor_id
        inner join film F
     on F.film_id = FA.film_id
where (A.first_name = 'MATTHEW' AND A.last_name = 'LEIGH') AND F.rating = 'G'
;

-- 9. All of the ‘Sci-Fi’ films released in 2006
-- (61 rows)
SELECt F.title, C.name
from category C
        inner join film_category FC
     on C.category_id = FC.category_id
        inner join film F
     on F.film_id = FC.film_id
where C.name = 'Sci-Fi' And F.release_year = 2006
;

-- 10. All of the ‘Action’ films starring Nick Stallone
-- (2 rows)
SELEct F.title, C.name, A.first_name || ', ' ||  A.last_name as first_last
from category C
        inner join film_category FC
     on C.category_id = FC.category_id
        inner join film F
     on F.film_id = FC.film_id
        inner join film_actor FA
     on FA.film_id = F.film_id
        inner join actor A
     on A.actor_id = FA.actor_id
where C.name = 'Action' AND A.first_name = 'NICK' ANd A.last_name = 'STALLONE'
;

-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)
SELECT A.address, CT.city, A.district,   C.country
from country C
        inner join city CT
     on CT.country_id = C.country_id
        inner join address A
     on A.city_id = CT.city_id
        inner join store S
     on S.address_id = A.address_id
;


-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
-- (2 rows)
SELECT S.store_id, A.address, ST.first_name || ', ' || ST.last_name as Store_manager
from store S
        inner join address A
     on S.address_id = A.address_id
        inner join staff ST
     on ST.staff_id =S.manager_staff_id
     ;


-- 13. The first and last name of the top ten customers ranked by number of rentals 
-- (#1 should be “ELEANOR HUNT” with 46 rentals, #10 should have 39 rentals)
SELECt C.first_name || ', ' || C.last_name as first_last, count(P.payment_date)
from customer C
        inner join rental R
     on C.customer_id = R.customer_id
        inner join payment P
     on R.rental_id = P.rental_id
group by C.first_name || ', ' || C.last_name
order by 2 desc
limit 10
;
        

-- 14. The first and last name of the top ten customers ranked by dollars spent 
-- (#1 should be “KARL SEAL” with 221.55 spent, #10 should be “ANA BRADLEY” with 174.66 spent)
SELECt C.first_name || ', ' || C.last_name as first_last, sum(P.amount)
from customer C
        inner join rental R
     on C.customer_id = R.customer_id
        inner join payment P
     on R.rental_id = P.rental_id
group by C.first_name || ', ' || C.last_name
order by 2 desc
limit 10
;

-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store 
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)
SELECT ST.store_id , A.address , count(R.rental_date) , sum(P.amount), avg(P.amount)
from store ST
        inner join address A
     on ST.address_id = A.address_id
        inner join inventory I
     on ST.store_id = I.store_id
        inner join rental R
     on R.inventory_id = I.inventory_id
        inner join payment P
     on R.rental_id = P.rental_id
group by ST.store_id, A.address
;



-- 16. The top ten film titles by number of rentals
-- (#1 should be “BUCKET BROTHERHOOD” with 34 rentals and #10 should have 31 rentals)
SELECT F.title , count(R.rental_date)
from film F
        inner join inventory I
     on F.film_id = I.film_id
        inner join rental R
     on R.inventory_id = I.inventory_id
group by F.title
order by 2 desc
limit 10
;

-- 17. The top five film categories by number of rentals 
-- (#1 should be “Sports” with 1179 rentals and #5 should be “Family” with 1096 rentals)
SELECT C.name , count(R.rental_date)
from film F
        inner join inventory I
     on F.film_id = I.film_id
        inner join rental R
     on R.inventory_id = I.inventory_id
        inner join film_category FC
     on FC.film_id = F.film_id
        inner join category C
     on C.category_id = FC.category_id
group by C.name
order by 2 desc
limit 5
;

-- 18. The top five Action film titles by number of rentals 
-- (#1 should have 30 rentals and #5 should have 28 rentals)
select F.title, count(R.rental_date)
from category C
        inner join film_category FC
     on C.category_id = FC.category_id
        inner join film F
     on F.film_id = FC.film_id
        inner join inventory I
     on I.film_id = F.film_id
        inner join rental R
     on I.inventory_id = R.inventory_id
where C.name = 'Action'
group by F.title
order by 2 desc
limit 5
;


-- 19. The top 10 actors ranked by number of rentals of films starring that actor 
-- (#1 should be “GINA DEGENERES” with 753 rentals and #10 should be “SEAN GUINESS” with 599 rentals)
SELECT A.first_name || ', ' || A.last_name as first_last , count(R.rental_date)
from actor A 
        inner join film_actor FA
     on A.actor_id = FA.actor_id
        inner join film F
     on F.film_id = FA.film_id
        inner join inventory I
     on I.film_id = F.film_id
        inner join rental R
     on R.inventory_id = I.inventory_id
group by A.first_name || ', ' || A.last_name, A.actor_id
order by 2 desc
limit 11;



-- 20. The top 5 “Comedy” actors ranked by number of rentals of films in the “Comedy” category starring that actor 
-- (#1 should have 87 rentals and #5 should have 72 rentals)
select A.first_name || ', ' || A.last_name, count(R.rental_date)
from actor A
        inner join film_actor FA
     on A.actor_id = FA.actor_id
        inner join film F
     on F.film_id = FA.film_id
        inner join film_category FC
     on FC.film_id = F.film_id
        inner join category C
     on C.category_id = FC.category_id
        inner join inventory I
     on I.film_id = F.film_id
        inner join rental R
     on R.inventory_id = I.inventory_id
where C.name = 'Comedy'
group by A.first_name || ', ' || A.last_name
order by 2 desc

limit 5
;
