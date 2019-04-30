-- Write queries to return the following:
-- The following queries utilize the "world" database.

-- 1. The city name, country name, and city population of all cities in Europe with population greater than 1 million
-- (36 rows)
select country.name, city.name, city.population
from city
inner join country
on country.continent = 'Europe'
where city.countrycode = country.code
and city.population > 1000000
;

-- 2. The city name, country name, and city population of all cities in countries where French is an official language and the city population is greater than 1 million
-- (2 rows)
select city.name, country.name, city.population
from city
inner join countrylanguage cl
on  cl.language = 'French'
inner join country
on country.code = cl.countrycode
where city.countrycode = cl.countrycode
and city.population > 1000000
and cl.isofficial = true
;


-- 3. The name of the countries and continents where the language Javanese is spoken
-- (1 row)
select name, continent
from country
inner join countrylanguage cl
on cl.language = 'Javanese'
where country.code = cl.countrycode
;

-- 4. The names of all of the countries in Africa that speak French as an official language
-- (5 row)
select name
from country
inner join countrylanguage cl
on cl.language = 'French'
where country.continent = 'Africa'
and country.code = cl.countrycode 
and cl.isofficial = true
;

-- 5. The average city population of cities in Europe
-- (average city population in Europe: 287,684)
select avg(c.population)
from city c
inner join country co
on co.continent = 'Europe'
where c.countrycode = co.code
;

-- 6. The average city population of cities in Asia
-- (average city population in Asia: 395,019)
select avg(c.population)
from city c
inner join country co
on co.continent = 'Asia'
where c.countrycode = co.code
;

-- 7. The number of cities in countries where English is an official language
-- (number of cities where English is official language: 523)
select count(*)
from city c
inner join countrylanguage cl
on cl.language = 'English'
inner join country co 
on co.code = cl.countrycode
where c.countrycode = co.code 
and cl.isofficial = true
;

-- 8. The average population of cities in countries where the official language is English
-- (average population of cities where English is official language: 285,809)
select avg(c.population)
from city c
inner join countrylanguage cl
on cl.language = 'English'
inner join country co 
on co.code = cl.countrycode
where c.countrycode = co.code 
and cl.isofficial = true
;

-- 9. The names of all of the continents and the population of the continent’s largest city
-- (6 rows, largest population for North America: 8,591,309)
select co.continent, max(c.population)
from country co
inner join city c
on c.countrycode = co.code
group by continent
;



-- 10. The names of all of the cities in South America that have a population of more than 1 million people and the official language of each city’s country
-- (29 rows)
select c.name, cl.language
from city c
inner join country co
on co.continent = 'South America'
inner join countrylanguage cl
on cl.countrycode = co.code
where c.population > 1000000
and cl.isofficial = true 
and c.countrycode = cl.countrycode
;
