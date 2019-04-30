--------------------------------------------------------------------------------------------------------
-- Basic SELECT Lecture Code
--------------------------------------------------------------------------------------------------------
-- -- indicates a comment - anything following on the line is ignored
--
-- SQL SELECT statement - retrieve values from the database (Read)
--
-- A SELECT statement is often referred to as a query
--
-- Basic syntax:
--
--      SELECT   - columns to include in the result (seperate mutiple column reqeusts with commas)
--      FROM     - table containing rows used in the query 
--      WHERE    - rows to include in the result
--      ORDER BY - sequence of rows in teh result
--               - without an ORDER BY the sequence of the rows in the result is not predictable
--               - if the sequence of the rows in the result matter - code an ORDER BY
--
-- WHERE predicates:
--
--        =  <>  !=  >  >=  <  <= 
--        IN(list-of-values)            -- alternative to a series of = OR
--        NOT IN(list-of-values)        -- alternative to a series of != AND
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
---------------------------------------------------
-- Show all the rows and all the columns for all countries
SELECT *                                --  * -> all of the columns
FROM country                            -- from the country table
;                                       -- end all of your statements with a semicolon

-- Show the names for all countries
SELECT name                             -- selected name as the column to display
FROM country
;


-- Show the name and population of all countries
SELECT name, population                  -- separate by commma for multiple columns
FROM country

;


-- Show all columns from the city table
SELECT *
FROM city
;

-- Show the cities in Ohio
-- ** the district is the same as states
SELECT name
FROM city
WHERE district = 'Ohio'                 -- an SQL string literal is enclosed in a apostrophe (NOT double quotes)
;
 

-- Show countries that gained independence in the year 1776
SELECT name
FROM country
WHERE indepyear = 1776                  -- numeric values are not out in aposts
;

-- Show countries not in Asia
SELECT name, continent
FROM country
WHERE continent != 'Asia'               -- literals are case sensitive
;

-- Show countries that do not have an independence year
SELECT name, indepyear
FROM country
WHERE indepyear IS NULL
;


-- Show countries that do have an indepenShowr
Select name, indepyear
FROM country
WHERE indepyear IS NOT NULL
;

-- Show countries that have a population greater than 5 million
SELECT name, population
FROM country
WHERE population > 5000000
;

-- Show cities in Ohio and Population greater than 400,000
SELECT name, population
FROM city
WHERE population > 400000 AND district = 'Ohio'
ORDER BY population                             -- orders by the selected varaible
;

-- Show country names on the continent North America or South America
SELECT name, continent
FROM country
WHERE continent = 'North America' OR continent = 'South America'
;

SELECT name, continent
FROM country
WHERE continent iN ('North America', 'South America')
;

SELECT name, continent, population
FROM country
WHERE continent NOT IN ('North America', 'South America') -- all countries not in North America and South America
order by population DESC
;
-- Show the population, life expectancy, and population per area (population / surfacearea)
SELECT name, population, lifeexpectancy, population/surfacearea as Pop_per_area -- calculated/derived column result on the select
                                                                                -- derived columns do not have column names
                                                                                -- AS provides a new name for a column
FROM country
;

-- AS phrase may be used to assign new names to columns or provide names for derived columns

-- sho the countries whose population is between 1000000 and 2000000
SELECT name, population
From country
Where population between 1000000 AND 2000000 -- between can do a range check (inclusive)
;

-- show the states whose names are between 'Ohio' and 'Utah'
SELECT name, district
from city
where countrycode = 'USA' AND district between 'Ohio' and 'Utah'
;

-- List the countries that start with 'United'
SELECT name
from country
WHERE name like 'United%'                       -- starts with 'United'
;

-- list the countries that contain the word 'new"
Select name , continent, population
from country
where name ilike '%m_n%'
order by continent, population
;

-- list the countries that contain a 'm' then any character then 'n'
Select name
from country
where name ilike '%m_n%'
;
