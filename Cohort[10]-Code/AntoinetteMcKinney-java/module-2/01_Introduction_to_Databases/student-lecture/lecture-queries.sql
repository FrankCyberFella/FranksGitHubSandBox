--------------------------------------------------------------------------------------------------------
-- Basic SELECT Lecture Code
--------------------------------------------------------------------------------------------------------
-- -- indicates a comment - anything following on the line is ignored
--
-- SQL SELECT statement - retrieve values form the database (Read)
--
-- A SELECT statement is often referred to as a query
--
-- Basic syntax:
--
--      SELECT   - columns to include in the result (seperate mutiple column reqeusts with commas)
--      FROM     - table containing rows used in the query 
--      WHERE    - rows to include in the result
--      ORDER BY - sequence of rows in teh result
--
-- WHERE predicates:
--
--        =  <>  !=  >  >=  <  <= 
--        IN(list-of-values) -- alterative to a series of = OR
--        NOT IN(list-of-values)
--        BETWEEN value AND value
--        IS NULL
--        IS NOT NULL
--        LIKE    (use wildcards: % means 0 to any number of any characters
--                                _ means exactly any one character
--        ILIKE   (case insensivtive LIKE - Postgres extension)
--
-- predicates may be combined using AND and OR
--
-- use parentheses to make your multi-predicate condition clear

-- The DISTINCT clause on a SELECT removes duplicate values from the result
-- based on the all columns that follow
--
-- The DISTINCT ON(columns/expression) clause on a SELECT removes duplicate values from the result
-- based on the all columns/expression inside the parentheses that follow (Postgres extension)
------------------------------------------------------------------------------------------------------
--
-- Show all the rows and all the columns for all countries
SELECT *                        -- all the colums
From country                    -- from this table
;
-- Show the names for all countries
SELECT name
FROM country
;
-- Show the name and population of all countries
SELECT name
        , population --multiple columns are separted by commas
FROM country 
;

-- Show all columns from the city table
SELECT *
From city
;
-- Show the cities in Ohio
 SELECT name
 FROM city
WHERE district = 'Ohio' -- in SQL string literal is enclosed in apostrophies (Not double quotes)
;
-- Show countries that gained independence in the year 1776
SELECT indepyear
 FROM country
 WHERE indepyear = 1776
;
-- Show countries not in Asia
SELECT name
 FROM country
 WHERE continent <> 'Asia' -- literals are case sensitive
 ;

-- Show countries that do not have an independence year
Select name, indepyear
from country
where indepyear is null
;

-- Show countries that do have an indepenShowr
Select name, indepyear
from country
where indepyear is not null -- only is Null or IS Not Null
;
-- Show countries that have a population greater than 5 million
select name , population
from country
where population > 5000000
;
-- Show cities in Ohio and Population greater than 400,000
select name, population
from city
where population > 400000
and district = 'Ohio'
;
-- Show country names on the continent North America or South America
select name, continent
from contury
where continent = 'North America'
     or continent = 'South America'
;

select name, continent
from country
where continent IN ('North America
-- Show the population, life expectancy, and population per area (population / surfacearea)





