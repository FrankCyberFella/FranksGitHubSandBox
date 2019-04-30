-- Write queries to return the following:
-- The following queries utilize the "world" database.

-- 1. The city name, country name, and city population of all cities in Europe with population greater than 1 million
-- (36 rows)
 
SELECT c.name, cn.name, c.population
FROM city c JOIN country cn
   ON c.countrycode = cn.code
   AND cn.continent = 'Europe'
   AND c.population > 1000000
;

-- 2. The city name, country name, and city population of all cities in countries where French is an official language and the city population is greater than 1 million
-- (2 rows)

SELECT c.name, cn.name, c.population, cl.language
FROM city c JOIN country cn
   ON c.countrycode = cn.code
      JOIN countrylanguage cl
   ON cn.code = cl.countrycode
   AND cl.language = 'French'
   AND c.population > 1000000
   AND cl.isofficial = 'true'
;


-- 3. The name of the countries and continents where the language Javanese is spoken
-- (1 row)

SELECT c.name, c.continent, lc.language
FROM country c JOIN countrylanguage lc
   ON lc.countrycode = c.code
   AND lc.language = 'Javanese'
;


-- 4. The names of all of the countries in Africa that speak French as an official language
-- (5 row)

SELECT c.name, c.continent, lc.language
FROM country c JOIN countrylanguage lc
   ON lc.countrycode = c.code
   AND lc.language = 'French'
   AND c.continent = 'Africa'
   AND isofficial = 'true'
;



-- 5. The average city population of cities in Europe
-- (average city population in Europe: 287,684)
SELECT avg(c.population), cn.continent
     FROM country cn JOIN city c
     ON cn.code = c.countrycode
     AND cn.continent = 'Europe'
     GROUP BY cn.continent
;

-- 6. The average city population of cities in Asia
-- (average city population in Asia: 395,019)

SELECT avg(c.population), cn.continent
     FROM country cn JOIN city c
     ON cn.code = c.countrycode
     AND cn.continent = 'Asia'
     GROUP BY cn.continent
;

-- 7. The number of cities in countries where English is an official language
-- (number of cities where English is official language: 523)

SELECT count(c)
  FROM city c JOIN country cn
    ON c.countrycode = cn.code
    JOIN countrylanguage cl
    ON cn.code = cl.countrycode
    AND language = 'English'
    AND isofficial = 'true'
    
;

-- 8. The average population of cities in countries where the official language is English
-- (average population of cities where English is official language: 285,809)

SELECT avg(c.population)
  FROM city c JOIN country cn
    ON c.countrycode = cn.code
    JOIN countrylanguage cl
    ON cn.code = cl.countrycode
    AND language = 'English'
    AND isofficial = 'true'
    
;

-- 9. The names of all of the continents and the population of the continent’s largest city
-- (6 rows, largest population for North America: 8,591,309)

SELECT cn.continent, max(c.population)
   FROM city c JOIN country cn
    ON c.countrycode = cn.code
    AND cn.continent = 'North America'
    GROUP BY cn.continent
;

-- 10. The names of all of the cities in South America that have a population of more than 1 million people and the official language of each city’s country
-- (29 rows)

SELECT c.name, cl.language
  FROM city c JOIN country cn
    ON c.countrycode = cn.code
    JOIN countrylanguage cl
    ON cn.code = cl.countrycode
    AND c.population > 1000000
    AND cn.continent = 'South America'
    AND isofficial = 'true'
  
;
