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
SELECT * -- all the columns
FROM   country -- from this table
;

-- Show the names for all countries
SELECT name
FROM country
;

-- Show the name and population of all countries

SELECT name, 
       population
FROM country
;


-- Show all columns from the city table
SELECT *
FROM city
;

-- Show the cities in Ohio
SELECT name 
FROM city
WHERE district = 'Ohio' -- an SQL string literal is enclosed in apostrophes (NOT double quotes)
;

-- Show countries that gained independence in the year 1776
SELECT name,
       indepyear
FROM country
WHERE indepyear = 1776 -- NUMERIC VALUES ARE NOT IN APOSTROPHES
;

-- Show countries not in Asia
SELECT name,
       continent
FROM country
WHERE continent != 'Asia'
;

-- Show countries that do not have an independence year
SELECT name,
        indepyear
FROM country
WHERE indepyear is null --only IS NULL or IS NOT NULL can be used to check for null values
;

-- Show countries that do have an indepenShowr
SELECT name,
        indepyear
FROM country
WHERE indepyear is not null --only IS NULL or IS NOT NULL can be used to check for null values
;

-- Show countries that have a population greater than 5 million
SELECT name,
        population
FROM country
where population > 5000000
;

-- Show cities in Ohio and Population greater than 400,000
SELECT  name, population
from city
where population > 400000
and district = 'Ohio'
;

-- Show country names on the continent North America or South America
select name, continent
from country
where continent IN ('North America', 'South America')
;

-- Show country names NOT on the continent North America or South America
select name, continent
from country
where continent NOT IN ('North America', 'South America')
;

-- Show the population, life expectancy, and population per area (population / surfacearea)
select population, 
        lifeexpectancy, 
        population / surfacearea AS Pop_per_area-- derived column does not have column names
from country
;

--Show the countries whose population is between 1,000,000 and 2,000,000
select name, population
From country
where population between 1000000 and 2000000
;

-- Show the states whose names are between 'Ohio' and 'Utah'
select name, district
from city
where district between 'Ohio' and 'Utah'
;

-- Show the states whose names are between 'Ohio' and 'Utah'
select name, district, countrycode
from city
where district between 'Ohio' and 'Utah'
and countrycode = 'USA'
;

-- List countries that start with 'United'
SELECT name
FROM country
WHERE name LIKE 'United%'
;

-- List countries that contanin the word 'New'
SELECT name
FROM country
WHERE name LIKE '%New%'
;

-- List countries that contanin the word 'New'
SELECT name
FROM country
WHERE name ILIKE '%NEW%'
;

-- List countries that end with 'Arabia'
SELECT name
FROM country
WHERE name LIKE '%stan'
;

-- List countries that end with 'Arabia'
SELECT name, continent, population
FROM country
WHERE (continent = 'North America'
or continent = 'South America')
and population > 5000000
;

-- List countries that end with 'Arabia'
SELECT name, continent, population
FROM country
WHERE (continent = 'North America'
or continent = 'South America')
and population > 5000000
order by population DESC
;

-- List countries that end with 'Arabia'
SELECT name, continent, population
FROM country
WHERE (continent = 'North America'
or continent = 'South America')
and population > 5000000
order by population 
;

-- List countries that end with 'Arabia'
SELECT name, continent, population
FROM country
WHERE (continent = 'North America'
or continent = 'South America')
and population > 5000000
order by continent,  -- ASC by default
population DESC -- DESC when specified
;
