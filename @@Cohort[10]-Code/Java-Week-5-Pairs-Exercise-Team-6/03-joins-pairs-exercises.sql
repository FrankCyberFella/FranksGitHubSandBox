-- Write queries to return the following:
-- The following queries utilize the "world" database.

-- 1. The city name, country name, and city population of all cities in Europe with population greater than 1 million
-- (36 rows)
SELECT C.name || ', ' || CO.name as city_country
from city C
        inner join country CO
     on C.countrycode = CO.code
where CO.continent = 'Europe' AND C.population > 1000000
;
        
        

-- 2. The city name, country name, and city population of all cities in countries where French is an official language and the city population is greater than 1 million
-- (2 rows)
SELECT C.name , CO.name, CL.language
from countrylanguage CL
        inner join country CO
     on CL.countrycode = CO.code
        inner join city C
     on CO.code = C.countrycode
where CL.language = 'French' AND C.population > 1000000 AND  CL.isofficial = 'true'
;

-- 3. The name of the countries and continents where the language Javanese is spoken
-- (1 row)
SELECT CO.name, CO.continent
from country CO
        inner join countrylanguage CL
     on CL.countrycode = CO.code
 where CL.language = 'Javanese'
 ;

-- 4. The names of all of the countries in Africa that speak French as an official language
-- (5 row)
SELECT CO.name, CO.continent
from country CO
        inner join countrylanguage CL
     on CL.countrycode = CO.code
 where CL.language = 'French' AND CL.isofficial = 'true' AND CO.continent = 'Africa'
 ;

-- 5. The average city population of cities in Europe
-- (average city population in Europe: 287,684)
SELECT avg(C.population)
from city C
        inner join country CO
     on C.countrycode = CO.code
where CO.continent = 'Europe'
;

-- 6. The average city population of cities in Asia
-- (average city population in Asia: 395,019)
SELECT avg(C.population)
from city C
        inner join country CO
     on C.countrycode = CO.code
where Co.continent = 'Asia'
;

-- 7. The number of cities in countries where English is an official language
-- (number of cities where English is official language: 523)
SELECT count(*)
from countrylanguage CL
        inner join country CO
     on CL.countrycode = CO.code
        inner join city C
     on C.countrycode = CO.code
where CL.language = 'English' AND CL.isofficial = 'true'
;
-- 8. The average population of cities in countries where the official language is English
-- (average population of cities where English is official language: 285,809)
SELECT avg(C.population)
from countrylanguage CL
        inner join country CO
     on CL.countrycode = CO.code
        inner join city C
     on C.countrycode = CO.code
where CL.language = 'English' AND CL.isofficial = 'true'
;

-- 9. The names of all of the continents and the population of the continent’s largest city
-- (6 rows, largest population for North America: 8,591,309)
SELECT CO.continent, max(C.population)
from country CO
        inner join city C
     on C.countrycode = CO.code
group by CO.continent
;

-- 10. The names of all of the cities in South America that have a population of more than 1 million people and the official language of each city’s country
-- (29 rows)
SELECT C.name, CL.language
from city C
        inner join country CO
     on C.countrycode = CO.code
        inner join countrylanguage CL
     on CO.code = CL.countrycode
where CO.continent = 'South America' AND C.population > 1000000 AND CL.isofficial = 'true'
;
