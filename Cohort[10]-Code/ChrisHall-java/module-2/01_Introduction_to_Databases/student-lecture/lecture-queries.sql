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
--        IN(list-of-values)
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
SELECT *
FROM country
;

-- Show the names for all countries
SELECT name 
FROM country
;

-- Show the name and population of all countries
SELECT name, population 
FROM country
;


-- Show all columns from the city table
SELECT * 
FROM city
;

-- Show the cities in Ohio
SELECT  name
FROM city
WHERE district = 'Ohio'
;


-- Show countries that gained independence in the year 1776
SELECT name
FROM country
WHERE indepyear = 1776
;


-- Show countries not in Asia
SELECT name, continent
FROM country
WHERE continent != 'Asia'
;

-- Show countries that do not have an independence year
SELECT name, indepyear
FROM country
WHERE indepyear is null   -- can't use = null.....use is null or is not null....
;

-- Show countries that do have an indepenShowr
SELECT name, indepyear
FROM country
WHERE indepyear is not null   -- can't use = null.....use is null or is not null....
;

-- Show countries that have a population greater than 5 million
SELECT name, population
FROM country
WHERE population > 5000000   -- can't use = null.....use is null or is not null....
;

-- Show cities in Ohio and Population greater than 400,000
SELECT name, population
FROM city
WHERE population > 400000 
and district = 'Ohio'  -- can't use = null.....use is null or is not null....
order by population
;

-- Show country names on the continent North America or South America
SELECT name, continent
FROM country
WHERE continent = 'North America' 
or continent = 'South America'  
;

SELECT name, continent
FROM country
WHERE continent IN ('North America', 'South America')   -- ALTERNATIVE WAY
;
-- Show the population, life expectancy, and population per area (population / surfacearea)
SELECT population as how_many_live_there, lifeexpectancy, population/surfacearea
AS Pop_per_area
FROM country
;

--show the countries whose population is between 1,000,000 and 2,000,000  -- BETWEEN  can do a range check (inclusive0
SELECT population, name
FROM country
where population between 1000000 and 2000000
order by population desc
;
-- show the states whose names are between 'Ohio' and 'Utah'
SELECT name, district
FROM city
where district between 'Ohio' and  'Utah'
and countrycode = 'USA'
;
-- List the countries that start with 'United'
Select name
from country
where name like 'United%'
;
--list countries that contain the word 'New'
Select name
from country
where name like '%New%'
;
--list countries that end with the word 'stan'
Select name
from country
where name like '%stan'
;
