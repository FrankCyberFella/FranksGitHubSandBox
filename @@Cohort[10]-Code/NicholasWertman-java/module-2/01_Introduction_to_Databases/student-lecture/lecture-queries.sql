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
Select * 
        From  country 
                      ;

-- Show the names for all countries
Select name
        From country
                    ;
        
-- Show the name and population of all countries
Select name
        , population
                From country
                            ;

-- Show all columns from the city table

Select *
        From city
                  ;

-- Show the cities in Ohio
 
Select name
           From city
                    Where district = 'Ohio'
                                           ;

-- Show countries that gained independence in the year 1776
Select name
, indepyear
           From country
                Where indepyear = 1776
                        ;
                                   

-- Show countries not in Asia
Select name
        ,continent
                From country
                        Where continent != 'Asia'
                          ;

-- Show countries that do not have an independence year
Select name
        From country
                Where indepyear ISNULL
                        ;

-- Show countries that do have an indepenShowr

Select name, continent
        From country
                Where indepyear IS NOT NULL
                        ;


-- Show countries that have a population greater than 5 million

Select name, population
        From country
                Where population > 5000000
                        ;
        

-- Show cities in Ohio and Population greater than 400,000
Select name, population
        From city 
                Where district = 'Ohio' AND  population > 400000
                        ;

-- Show country names on the continent North America or South America

Select name , continent
                From country
                        Where continent = 'North America' OR continent = 'South America'
                        -- COULD USE IN --> Where continent IN ('North America','South America')
                                ;
                       


-- Show the population, life expectancy, and population per area (population / surfacearea)

Select population, lifeexpectancy, (population/surfacearea) AS Pop_per_area
        From country
                ;
               
               
               
Select name, population
        From country
                Where population BETWEEN 1000000 AND 2000000
                ;



Select name, district
        From city
                Where district BETWEEN 'Ohio' AND 'Utah' AND countrycode = 'USA'
                ;
               
               
               
SELECT name
        FROM country 
                WHERE name like 'United%'
                ;
                
                
SELECT name 
        FROM country
                WHERE name ilike '%new%'
                ;
                
                
SELECT name , population
        FROM country
                WHERE (continent = 'North America' or continent = 'South America') and population > 5000000
                        ORDER BY name ASC               -- could be DESC too
                        ;

