--------------------------------------------------------------------------------------------------------
-- Ordering, Grouping Basic Functions Lecture Code
--------------------------------------------------------------------------------------------------------
--
-- ORDER BY -  Sequence of Rows in Result
--
--    ORDER BY          -- Ascending Sequence (low-high)
--    ORDER BY ASC      -- Ascending Sequence (low-high)
--    ORDER BY DESC     -- Descending Sequence (high-low)
--    ORDER BY col-#    -- Ascending Sequence (low-high)
--
-- The order of the rows in the result is not guaranteed without an ORDER BY
--  if the order of the rows is important use an ORDER BY

-- Show Populations of all countries in acscending order
--
SELECT name, population
  FROM country
  order by population
  ;
SELECT name, population
  FROM country
  order by population asc
  ;
  
SELECT name, population
  FROM country
  order by 2   -- the column number in the SELECT may be used in an ORDER BY
  ;
  
SELECT name, population
  FROM country
  order by 2, name  DESC -- the column number in the SELECT may be used in an ORDER BY
  ;
  
-- Show Populations of all countries in descending order

SELECT name, population
  FROM country
  order by population desc
  ;

SELECT name, population
  FROM country
  order by name, population desc
  ;

-- Show  the names of countries and continents in ascending order

SELECT name, continent
  FROM country
  order by continent, country
  ;

-- Show Population density in ascending orderof all countries 

SELECT name, population / surfacearea as population_Density
  FROM country
  order by population_Density
  ;

--------------------------------------------------------------------------------------------------------
-- Limiting the number of rows in the result
--
-- LIMIT n   - Limit the number of rows in the result - always goes at the end of the SELECT
--
--
-- Show the name and average life expectancy of the countries with the 10 highest life expectancies.

SELECT lifeexpectancy
  FROM country
WHERE lifeexpectancy IS NOT null
order by lifeexpectancy desc
limit 10   -- limit the number of rows in the result
;
--------------------------------------------------------------------------------------------------------
-- Concatenating values 
--
-- the concat operator (||) may be used to concatenate character (string) values in a result
--

-- Show the name & state in the format: "city-name, state"
-- of all cities in California, Oregon, or Washington.
-- sorted by state then city

SELECT name || ', ' || district as City_Name
  FROM city
WHERE district in('California', 'Oregon', 'Washington')
order by district, name  
;

SELECT name || ', ' || district as City_Name
  FROM city
WHERE district = 'California'
   or district = 'Oregon'
   or district = 'Washington'
order by district, name  
;


--------------------------------------------------------------------------------------------------------
-- Aggregate functions - produce one row in result for each group specified
--
-- The group used by the aggregate functions is determined by the GROUP BY clause
-- if no GROUP BY clause is specified, the group is the set of rows in the result
--
--     AVG(column-expression)   - arithmentic average for group of non-NULL values in expression 
--     SUM(column-expression)   - arithmentic sum for group of a non-NULL values in expression 
--     MIN(column-expression)   - lowest value for group of non-NULL values in expression 
--     MAX(column-expression)   - highest value for group of non-NULL values in expression 
--     COUNT(*)                 - number of rows in the group
--     COUNT(column-expression) - number of rows for the group of non-NULL values in expression 
--
--
-- AVG(), SUM() may only be used with numeric data types
-- MIN(), MAX() may be used with numeric, character, date, time datatypes
--
-- COUNT() is applied to rows (not columns)
--
--
-- Show average life expectancy in the world
select avg(lifeexpectancy)
     , min(lifeexpectancy)
     , max(lifeexpectancy)
from  country
;
-- Show the total population in Ohio
select sum(population)
  from city
  where district = 'Ohio'
  ;

-- Show the surface area of the smallest country in the world
select name, min(surfacearea)
from country
group by name
order by 2
limit 1
;

-- Show The 10 largest countries (by surface area) in the world
select name, surfacearea
from country
order by surfacearea desc
limit 10
;

-- Show the number of countries who declared independence in 1991
select count(*)
from country
where indepyear = 1991
;
--------------------------------------------------------------------------------------------------------
-- GROUP BY  - Specify the group to which the aggregate functions apply
--
--      GROUP BY column-expression
--
-- When using a GROUP BY the SELECT is limited ot aggreggate functions or columns in the GROUP BY
--
--

-- Show the number of countries where each language is spoken, order show them from most countries to least
select language, count(*)
from countrylanguage
group by language
order by count(*) desc
;

-- Show the average life expectancy of each continent ordered from highest to lowest
select continent, avg(lifeexpectancy)
from country 
group by continent
;


-- Exclude Antarctica from consideration for average life expectancy
select continent, avg(lifeexpectancy)
from country
where lifeexpectancy is not null
group by continent
;

-- What is the sum of the population of cities in each state in the USA ordered by state name
select district, sum(population)
from  city
where countrycode = 'USA'
group by district
order by district
;


-- What is the average population of cities in each state in the USA ordered by state name
select district, round(avg(population),0)
from  city
where countrycode = 'USA'
group by district
order by district
;

-- Which cities are in the same state 
--select name, district



-- Example of having to cast in order to round
--select round(population/surfacearea,3)
select round(CAST(population / surfacearea as numeric),2)
from country
where population <> 0
;
--------------------------------------------------------------------------------------------------------
-- SUBQUERIES - Using the result from one query (inner query) in another query (outer query)
--
-- Frequently used in a WHERE clause with an IN predicate:
--
--       WHERE column-name IN (SELECT column-name FROM some-table WHERE some-predicate)
--
-- Any WHERE predicate may be used to connect the subquery in a WHERE clause, but you must
-- be sure a single value is returned from the subquery. 
--
-- Subqueries may also be used in a SELECT as a column-specification or a FROM as a table
-- (These are advanced concepts we will discuss later, if there is time)
--
-- Show the cities under the same given government leader

select name
  from city
 where countrycode in (select code        -- a list of country codes the person is head of state
                         from country
                        where headofstate = 'Jacques Chirac')
 ;


-- Show countries with the same independece year


-- Show the cities whose country has not yet declared independence yet

select name, countrycode
  from city
where countrycode in (select code from country where indepyear is null)
;

-- Show the surface area of the smallest country in the world
select name, surfacearea
from country
where surfacearea = (select min(surfacearea) from country)
;


--------------------------------------------------------------------------------------------------------
--
-- Additional samples
--
-- You may alias column and table names to provide more descriptive names
--
SELECT name AS CityName 
  FROM city AS cities

-- Ordering allows columns to be displayed in ascending order, or descending order (Look at Arlington)
SELECT name
     , population 
  FROM city 
 WHERE countryCode='USA' 
 ORDER BY name ASC, population DESC
;
-- Limiting results allows rows to be returned in 'limited' clusters where LIMIT says how many, 
-- and an optional OFFSET specifies number of rows to skip
SELECT name
     , population 
  FROM city 
  LIMIT 10 OFFSET 10
;