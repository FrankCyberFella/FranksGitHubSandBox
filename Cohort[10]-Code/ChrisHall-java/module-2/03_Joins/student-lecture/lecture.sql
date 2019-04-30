-- Keys, Joins and Unions
--
-- Primary Key - a column or set of columns that uniquely identify a row in a table (Parent table)
-- Foreign Key - a column or set of columns that match the primary key of another table (Dependent table)
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
--- If you omit join conditions, the result is Cartesian Product
--    -- get each row from one table with each row in the other -- It is NOT a JOiN
--  Rule of thumb : the minimum number of conditions on WHERE clause is # TABLES - 1

-- newer syntax to help avoid Cartesian

--  SELECT columns
--    FROM table1
--         INNER JOIN
--         table2
--      on table1.column = table2.column
--
-- Additional WHERE predicates may be added to either syntax to filter rows
------------------------------------------------------------------------------------------------

--Show me last_name of all the actors in the movie FINDING ANACONDA
-- actor table...to get to film table to get film...need to go through film_actor table and the film table.  The film_table is a RELATOR.
-- need multiple tables, need JOIN
-- from needs actor, film_actor
-- What rows for film_actor? >> we want the rows where actor_id matches film_actor >> WHERE clause >> WHERE actor's actor_id = film_actor's actor_id 
--  >> ambiguous >> which actor_id ?? >> use dots and specify each table name >> actor.actor_id   and film_actor.actor_id
-- now connect film_actor to film with film_id >> add film to from and add "and film.film_id = film_actor.film_id" to the Where
-- now we need to limit films to the one we want (from film) add "and title = 'FINDING ANACONDA'"
--

Select last_name
from actor, film_actor, film
Where actor.actor_id = film_actor.actor_id  --join condition - matching condition
and film.film_id = film_actor.film_id    -- join condition
and title = 'FINDING ANACONDA'   -- Filtering condtion (for results) 
;
--new syntax version of above:

Select last_name
from actor
        inner join
        film_actor
    on  actor.actor_id = film_actor.actor_id  -- join condition
        inner join
        film
    on  film.film_id = film_actor.film_id  --join condition
Where title = 'FINDING ANACONDA'  -- filtering condition
;

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
-- UNION - *** Merging ***  rows between two tables
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
-- 
--

--
-- ********* INNER JOIN ***********

-- Let's find out who made payment 16666:
-- what table for customer_id for payment_id = 16666?
select customer_id
from payment
where payment_id = 16666
;
-- gives 204  
-- Ok, that gives us a customer_id, but not the name. NEED data from two tables.  JOIN We can use the customer_id to get the name FROM the customer table
select customer.customer_id, first_name || ' ' || last_name  --  <<  note: need to specify the ambiguous possibities even on Select
from payment
        inner join
        customer
    on  payment.customer_id = customer.customer_id
where payment_id = 16666
;
--  a Frank technique:  a correlation name (nickname or alias) can be assigned to a table to make coding easier:
-- also good to use the correlation name even when not necessary, to help point out which table a column is from: c.first_name

--  note p.* gets all colums
select p.*, c.customer_id, c.first_name || ' ' || c.last_name  --  <<  note: need to specify the ambiguous possibities even on Select
from payment p  -- assigned correlation name p to the payment table
        inner join
        customer c  -- assign correlation name c to customer table
    on  p.customer_id = c.customer_id
where p.payment_id = 16666
;

-- We can see --above--that the * pulls back everything from both tables. We just want everything from payment and then the first and last name of the customer:

-- But when did they return the rental? Where would that data come from? From the rental table, so let’s join that.

-- What did they rent? Film id can be gotten through inventory.

-- What if we wanted to know who acted in that film?    

-- What if we wanted a list of all the films and their categories ordered by film title

-- Show all the 'Comedy' films ordered by film title

-- Finally, let's count the number of films under each category






-- *********** UNION *************

-- Back to the "dvdstore" database...

-- Gathers a list--eliminate duplicates of all first names used by actors and customers
-- By default removes duplicates
Select first_name 
from actor
union  -- eliminates duplicates
Select first_name
from customer
;


-- Gather the list-- keep duplicates, but this time note the source table with 'A' for actor and 'C' for customer

Select first_name, 'A'  -- adds an A to specify which table it came from
from actor
union all    -- keeps duplicates
Select first_name, 'C'   -- adds C
from customer
order by first_name -- can also order by
;  
