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
SELECT * FROM   country; -- all the coloumns from this table

SELECT name, population from country;



-- Show the names for all countries
SELECT name from country;

-- Show the name and population of all countries

SELECT name, population from country;
-- Show all columns from the city table

SELECT * FROM city

-- Show the cities in Ohio
 SELECT name FROM city WHERE district = 'Ohio';

-- Show countries that gained independence in the year 1776
SELECT name 
FROM country
WHERE indepyear = 1776; -- numeric values are not put in apostrophies

-- Show countries not in Asia
Select name, continent
FROM country
Where continent != 'Asia'; -- literals are case sensitive

-- Show countries that do not have an independence year
Select name, indepyear, continent
FROM country
WHERE indepyear IS NULL;

-- Show countries that do have an indepenShowr
SELECT name , indepyear, continent
FROM country
WHERE indepyear IS NOT NULL;
-- Show countries that have a population greater than 5 million
SELECT name, population
FROM country
WHERE population > 5000000;
-- Show cities in Ohio and Population greater than 400,000
SELECT name, population
FROM city
WHERE district = 'Ohio' and population > 400000;
-- Show country names on the continent North America or South America
SELECT name, continent
FROM country
WHERE continent IN('North America','South America');


-- Show the population, life expectancy, and population per area (population / surfacearea)
SELECT name , population, lifeexpectancy, (population/surfacearea) AS Pop_per_area -- ?column? = derived column
FROM country

--between can do a range check
select name, population
from country
where population between 1000000 and 2000000;

select name, district
from city
where district between 'Ohio' and 'Utah'
    and countrycode = 'USA';
    
 Select name
 from country
 where name like '%New%';
    
select name, continent, population
from country
where (continent = 'North America'
      or continent = 'South America')
      and population > 5000000
      order by continent,
      population desc;
