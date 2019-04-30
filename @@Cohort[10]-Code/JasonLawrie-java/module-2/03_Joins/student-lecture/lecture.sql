-- Keys, Joins and Unions
--
-- Primary Key - a column or set of columns that uniquely identify a row in a table (Parent table)
-- Foreigh Key - a column or set of columns that match the primary key of another table (Dependent table)
--
-- Natural Key - Value(s) that exist for a table that can be used as primary keys
-- Surrogate Key - Artificially generated keys to use as a primary key
--
--  Joins are used when columns from multiple tables are required in a query
--
-- INNER JOIN - Matching rows between tables 
-- 
-- OUTER JOIN - All rows from both tables - the full set      
------------------------------------------------------------------------------------------------
-- Inner Join syntax - 2 forms
-- 
--  SELECT columns
--    FROM table1, table2  
--  WHERE table1.column = table2.column  
--
--
--  SELECT columns
--    FROM table1
--         INNER JOIN
--         table2
--      on table1.column = table2.column
--
-- Additional WHERE predicates may be added to either syntax to filter rows
------------------------------------------------------------------------------------------------
-- -- OUTER JOIN syntax 
--
--  SELECT columns
--    FROM table1
--         FULL OUTER JOIN
--         table2
--      on table1.column = table2.column
--
-- Additional WHERE predicates may be added to either syntax to filter rows
------------------------------------------------------------------------------------------------
-- UNION - Merging rows between two tables
--
-- Each SELECT must have the same number of columns in the same order and be compatible datatypes 
--      use literals if necessary to make the UNION work
--
-- SELECT columns
--   FROM table1
-- WHERE predicate
--
-- UNION
--
-- SELECT columns
--   FROM table2
-- WHERE predicate
------------------------------------------------------------------------------------------------
--
-- UNION All - Concatenating rows between two tables
--
-- Each SELECT must have the same number of columns in the same order and be compatible datatypes 
--      use literals if necessary to make the UNION work
--
-- SELECT columns
--   FROM table1
-- WHERE predicate
--
-- UNION ALL
--
-- SELECT columns
--   FROM table2
-- WHERE predicate
------------------------------------------------------------------------------------------------
--
--SHOW THE LAST NAME OF ALL THE ACTORS IN THE MOVIE FINDING ANACONDA
SELECT last_name
  FROM actor, film_actor, film
 WHERE actor.actor_id = film_actor.actor_id -- join condition - "matching condition"
   AND film_actor.film_id=film.film_id      -- join condition - "matching condition"
   AND film.title ilike 'Finding Anaconda'  -- filtering condition
 ;
-- 
--
SELECT actor.first_name,actor.last_name, film.title
  FROM actor
  INNER JOIN film_actor
  ON actor.actor_id = film_actor.actor_id
  INNER JOIN film
  ON film_actor.film_id = film.film_id
  WHERE film.title ilike 'FINDiNg ANACONDA'
  ;
--
-- ********* INNER JOIN ***********

-- Let's find out who made payment 16666:
SELECT customer_id
  from payment
 WHERE payment_id=16666
 ;
-- Ok, that gives us a customer_id, but not the name. We can use the customer_id to get the name FROM the customer table
SELECT customer.first_name||' '||customer.last_name as full_name, customer.customer_id, payment_id
  from payment
  INNER JOIN customer
  on payment.customer_id=customer.customer_id
 WHERE payment_id=16666
 ;
-- A correlation name can be assigned to a table to make coding easier
SELECT c.first_name||' '||c.last_name as full_name, c.customer_id, p.payment_id
  from payment p
  INNER JOIN customer c
  on p.customer_id=c.customer_id
 WHERE p.payment_id=16666
 ;
 
-- We can see that the * pulls back everything from both tables. We just want everything from payment and then the first and last name of the customer:
SELECT p.*, c.first_name||' '||c.last_name as full_name
  from payment p
  INNER JOIN customer c
  on p.customer_id=c.customer_id
 WHERE p.payment_id=16666
 ;

-- But when did they return the rental? Where would that data come from? From the rental table, so let’s join that.

-- What did they rent? Film id can be gotten through inventory.

-- What if we wanted to know who acted in that film?    

-- What if we wanted a list of all the films and their categories ordered by film title

-- Show all the 'Comedy' films ordered by film title

-- Finally, let's count the number of films under each category






-- *********** UNION *************

-- Back to the "dvdstore" database...

-- Gathers a list of all first names used by actors and customers
-- By default removes duplicates
SELECT first_name
  FROM actor
 UNION
SELECT first_name
  FROM customer
ORDER BY first_name
  ;

-- Gather the list, but this time note the source table with 'A' for actor and 'C' for customer
SELECT first_name, 'is an actor'
  FROM actor
 UNION
SELECT first_name, 'is a customer'
  FROM customer
ORDER BY first_name
  ;

