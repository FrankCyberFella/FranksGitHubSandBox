--------------------------------------------------------------------------------------------------------
-- Ordering, Grouping Basic Functions Lecture Code
--------------------------------------------------------------------------------------------------------
--
-- ORDER BY -  Sequence of Rows in Result
--
--    ORDER BY          -- Ascending Sequence (low-high)
--    ORDER BY ASC      -- Ascending Sequence (low-high)
--    ORDER BY DESC     -- Descending Sequence (high-low)
--
-- The order of the rows in the result is not guaranteed without an ORDER BY
-- If the order of the rows is important, use an ORDER BY

-- Show Populations of all countries in acscending order
SELECT name, population FROM country ORDER BY population ASC;

SELECT name, population FROM country ORDER BY 2; -- you can use a column number to orderby

-- Show Populations of all countries in descending order
SELECT name, population FROM country ORDER BY population DESC;

-- Show  the n ames of countries and continents in ascending order
SELECT name, continent FROM country ORDER BY continent, country;

--------------------------------------------------------------------------------------------------------
-- Limiting the number of rows in the result
--
-- LIMIT n   - Limit the number of rows in the result - always goes at thE end of the SELECT
--
--
-- Show the name and average life expectancy of the countries with the 10 highest life expectancies.
SELECT name, lifeexpectancy FROM country WHERE lifeexpectancy IS NOT NULL ORDER BY lifeexpectancy DESC LIMIT 10;

--------------------------------------------------------------------------------------------------------
-- Concatenating values 
--
-- the concat operator (||) may be used to concatenate character (string) values in a result
--

-- Show the name & state in the format: "city-name, state"
-- of all cities in California, Oregon, or Washington.
-- sorted by state then city

SELECT name || ', ' || district AS cityname FROM city WHERE district IN ('California', 'Oregon', 'Washington') ORDER BY district, name;

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
-- AVG(), SUM() may only bes used with numeric data types
-- MIN(), MAX() may be used with numeric, character, date, time datatypes
--
-- COUNT() is applied to rows (not columns)
--
--
-- Show average life expectancy in the world
SELECT AVG(lifeexpectancy), MIN(lifeexpectancy), MAX(lifeexpectancy) FROM country;

-- Show the total population in Ohio
SELECT SUM(population) FROM city WHERE district = 'Ohio';

-- Show the surface area of the smallest country in the world
SELECT name, MIN(surfacearea) FROM country GROUP BY name ORDER BY 2 LIMIT 1;


-- Show The 10 largest countries (by surface area) in the world
SELECT name, surfacearea FROM country ORDER BY surfacearea DESC LIMIT 10;

-- Show the number of countries who declared independence in 1991
SELECT count(*), indepyear FROM country WHERE indepyear = 1991;
--------------------------------------------------------------------------------------------------------
-- GROUP BY  - Specify the group to which the aggregate functions apply
--
--      GROUP BY column-expression
--
-- When using a GROUP BY the SELECT is limited ot aggreggate functions or columns in the GROUP BY
--
--

-- Show the number of countries where each language is spoken, order show them from most countries to least
SELECT language, count(*) FROM countrylanguage GROUP BY language ORDER BY 2 DESC;


-- Show the average life expectancy of each continent ordered from highest to lowest
SELECT continent, AVG(lifeexpectancy) FROM country WHERE lifeexpectancy IS NOT NULL GROUP BY continent ORDER BY 2 DESC;


-- Exclude Antarctica from consideration for average life expectancy



-- What is the sum of the population of cities in each state in the USA ordered by state name



-- What is the average population of cities in each state in the USA ordered by state name


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

SELECT name FROM city WHERE countrycode IN (SELECT code FROM country WHERE headofstate = 'Jacques Chirac');

-- Show countries with the same independece year

-- Show the cities whose country has not yet declared independence yet
SELECT name FROM city WHERE countrycode IN (SELECT code FROM country WHERE indepyear IS NULL);


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