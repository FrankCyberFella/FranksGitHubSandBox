-- The following queries utilize the "world" database.
-- Write queries for the following problems. 
-- Notes:
--   GNP is expressed in units of one million US Dollars
--   The value immediately after the problem statement is the expected number 
--   of rows that should be returned by the query.

-- 1. The name and state plus population of all cities in states that border Ohio 
-- (i.e. cities located in Pennsylvania, West Virginia, Kentucky, Indiana, and 
-- Michigan).  
-- The name and state should be returned as a single column called 
-- name_and_state and should contain values such as ‘Detroit, Michigan’.  
-- The results should be ordered alphabetically by state name and then by city 
-- name. 
-- (19 rows)

SELECT name || ', ' || district AS name_and_state, population
FROM city
WHERE district IN  ('Pennsylvania', 'West Virginia', 'Kentucky', 'Indiana', 'Michigan')
ORDER BY district, name
;

-- 2. The name, country code, and region of all countries in Africa.  The name and
-- country code should be returned as a single column named country_and_code 
-- and should contain values such as ‘Angola (AGO)’ 
-- (58 rows)
SELECT name || ' (' || code || ')' AS country_and_code, region
FROM country
WHERE continent = 'Africa'
;
-- 3. The per capita GNP (i.e. GNP multipled by 1000000 then divided by population) of all countries in the 
-- world sorted from highest to lowest. Recall: GNP is express in units of one million US Dollars 
-- (highest per capita GNP in world: 37459.26)

SELECT ((gnp * 1000000) / population)
FROM country
WHERE gnp != 0 AND population != 0
ORDER BY 1 desc
;
-- 4. The average life expectancy of countries in South America.
-- (average life expectancy in South America: 70.9461)
SELECT avg(lifeexpectancy)
FROM country
WHERE continent = 'South America'
;
-- 5. The sum of the population of all cities in California.
-- (total population of all cities in California: 16716706)
SELECT sum(population)
FROM city
WHERE district = 'California'
;
-- 6. The sum of the population of all cities in China.
-- (total population of all cities in China: 175953614)
SELECT sum(population)
FROM city
WHERE countrycode = (SELECT code
                        FROM country
                        WHERE name = 'China')
;
-- 7. The maximum population of all countries in the world.
-- (largest country population in world: 1277558000)
SELECT max(population)
FROM country
;
-- 8. The maximum population of all cities in the world.
-- (largest city population in world: 10500000)
SELECT max(population)
FROM city
;
-- 9. The maximum population of all cities in Australia.
-- (largest city population in Australia: 3276207)
SELECT max(population)
FROM city
WHERE countrycode = (SELECT code
                        FROM country
                        WHERE name = 'Australia')
;
-- 10. The minimum population of all countries in the world.
-- (smallest_country_population in world: 50)
SELECT min(population) AS smallest_country_population
FROM country
WHERE population != 0
;
-- 11. The average population of cities in the United States.
-- (avgerage city population in USA: 286955.3795)
SELECT avg(population) AS average_city_population_in_usa
FROM city
WHERE countrycode = 'USA'
;
-- 12. The average population of cities in China.
-- (average city population in China: 484720.6997 approx.)
SELECT avg(population) AS average_city_population_in_china
FROM city
WHERE countrycode = (SELECT code
                        FROM country
                        WHERE name = 'China')
;
-- 13. The surface area of each continent ordered from highest to lowest.
-- (largest continental surface area: 31881000, "Asia")
SELECT sum(surfacearea), continent
FROM country
GROUP BY continent
ORDER BY 1 desc
;
-- 14. The highest population density (population divided by surface area) of all 
-- countries in the world. 
-- (highest population density in world: 26277.7777)
SELECT max(population/ surfacearea)
FROM country
WHERE population != 0
;
-- 15. The population density and life expectancy of the top ten countries with the 
-- highest life expectancies in descending order. 
-- (highest life expectancies in world: 83.5, 166.6666, "Andorra")
SELECT (population/surfacearea), lifeexpectancy, name
FROM country
WHERE population != 0 AND lifeexpectancy IS NOT NULL
ORDER BY 2 desc
LIMIT 10
;
-- 16. The difference between the previous and current GNP of all the countries in 
-- the world ordered by the absolute value of the difference. Display both 
-- difference and absolute difference.
-- (smallest difference: 1.00, 1.00, "Ecuador")
SELECT (gnp - gnpold), @(gnp - gnpold), name
FROM country
ORDER BY 2
;
-- 17. The average population of cities in each country (hint: use city.countrycode)
-- ordered from highest to lowest.
-- (highest avg population: 4017733.0000, "SGP")
SELECT avg(population), countrycode
FROM city
GROUP BY city.countrycode
ORDER BY 1 desc
;	
-- 18. The count of cities in each state in the USA, ordered by state name.
-- (45 rows)
SELECT count(*), district
FROM city
WHERE countrycode = 'USA'
GROUP BY district
ORDER BY district
;	
-- 19. The count of countries on each continent, ordered from highest to lowest.
-- (highest count: 58, "Africa")
SELECT count(*), continent
FROM country
GROUP BY continent
ORDER BY 1 desc
;	
-- 20. The count of cities in each country ordered from highest to lowest.
-- (largest number of  cities ib a country: 363, "CHN")
SELECT count(*), countrycode
FROM city
GROUP BY countrycode
ORDER BY 1 desc
;	
-- 21. The population of the largest city in each country ordered from highest to 
-- lowest.
-- (largest city population in world: 10500000, "IND")
SELECT max(population), countrycode
FROM city
GROUP BY countrycode
ORDER BY 1 desc
;
-- 22. The average, minimum, and maximum non-null life expectancy of each continent 
-- ordered from lowest to highest average life expectancy. 
-- (lowest average life expectancy: 52.5719, 37.2, 76.8, "Africa")
SELECT avg(lifeexpectancy), min(lifeexpectancy), max(lifeexpectancy), continent
FROM country
WHERE lifeexpectancy IS NOT NULL
GROUP BY continent
ORDER BY 1 
;