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
--               -- without an ORDER BY teh sequence of teh rows in teh result is not predictable
                 -- if teh sequence of teh rows in teh result matter - code an ORDER BY
-- WHERE predicates:
--
--        =  <>  !=  >  >=  <  <= 
--        IN(list-of-values) -- alternative to a series of = OR
--        NOT IN(list-of-values) -- opposite of IN, alternative to a series of != AND
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
SELECT * FROM  country;  --all columns from this table

-- Show the names for all countries
SELECT name FROM country;

-- Show the name and population of all countries
SELECT name, population FROM country; -- multiple columns are separated by commas


-- Show all columns from the city table
SELECT * from city;

-- Show the cities in Ohio
 SELECT name FROM city WHERE district = 'Ohio'; -- in SQL, a string literal is enclosed in apostrophes, not double quotes

-- Show countries that gained independence in the year 1776
Select name 
From country
where indepyear = 1776
;
-- Show countries not in Asia
select name, continent
from country
where continent != 'Asia' -- case matters in string literals
;

-- Show countries that do not have an independence year
select name, indepyear
from country 
where indepyear is null;  -- null is a special value that cannot be targeted by operators, only 'is' or 'is not'

-- Show countries that do have an indepenShowr
select name, indepyear
from country
where indepyear is not null;

-- Show countries that have a population greater than 5 million
select name, population
from country
where population > 5000000;

-- Show cities in Ohio and Population greater than 400,000
select name, population
from city
where population > 400000
and district = 'Ohio';

-- Show country names on the continent North America or South America
select name, continent
from country
where continent = 'North America' -- can also use IN instead of '='and ( ) to contain 'North America' and 'South America' on one line
or continent = 'South America';


-- Show the population, life expectancy, and population per area (population / surfacearea)
select population, lifeexpectancy / surfacearea as Pop_per_area-- calculated/derived column result on the select
                                                --'as' provides a new name for a derived column; derived columns do not have column names
from country;

--
select name, population as how_Many_live_there
, lifeexpectancy as number_of_birthdays
, population / surfacearea as pop_per_area
from country;

-- show the countries whose population is between 1,000,000 and 2,000,000
select name, population
from country
where population between 1000000 and 2000000
;

-- show the states whose names are between 'Ohio' and 'Utah'
select name, district
from city
where district between 'Ohio' and 'Utah'
and countrycode = 'USA'
;

-- list the countries that start with 'United'
select name
from country
where name like 'United%';

-- list the countries that contain the word 'New'
select name 
from country
where name like '%New%';

-- list the countries that contain the word 'New'
select name 
from country
where name ilike '%NEW%';

-- list the countries that end with 'stan'
select name
from country
where name like '%stan';

-- show country names on the continent North America or South America if population > 5000000
select name continent, population
from country
where (continent = 'North America'
or continent = 'South America')
and population > 5000000
-- add an ORDER BY
order by continent, population DESC; -- ASC is default if order is omitted
-- 

