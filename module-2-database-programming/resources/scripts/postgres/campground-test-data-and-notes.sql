-- A little reservation test data
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (47, 'Yogi Bear', '2016-06-16', '2016-06-20');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (47, 'Boo-Boo Bear', '2016-07-15', '2016-07-21');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (48, 'Smokey the Bear', '2016-06-21', '2016-07-01');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (49, 'Max Bear', '2016-06-18', '2016-06-24');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (49, 'Max Bear, Jr.', '2016-07-02', '2016-07-13');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (50, 'Teddy Bear', '2016-06-07', '2016-06-15');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (50, 'Care Bear', '2016-07-28', '2016-08-04');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (51, 'Polar Bear', '2016-06-17', '2016-06-30');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (51, 'Grizzly Bear', '2016-07-08', '2016-07-14');

select * from reservation r where ('2016-06-20'<r.from_date and '2016-06-28'>r.to_date)
or ('2016-06-20'>r.from_date and '2016-06-28'<r.to_date)
or ('2016-06-20'<r.to_date and '2016-06-28'>from_date);

-- reservation_id  site_id   name                from_date   to_date
-- 3               48        "Smokey the Bear"   2016-06-21  2016-07-01      //2016-06-20 - 2016-06-28 starts before, ends before existing
-- 4               49        "Max Bear"          2016-18-24  2016-06-24      //2016-06-20 - 2016-06-28 starts after, ends after existing
-- 8               51        "Polar Bear"        2016-06-17  2016-06-30      //2016-06-20 - 2016-06-28 starts after, ends before existing

select * from reservation r where ('2016-06-06'<r.from_date and '2016-06-16'>r.to_date)
or ('2016-06-06'>r.from_date and '2016-06-16'<r.to_date)
or ('2016-06-06'<r.to_date and '2016-06-16'>from_date);

-- reservation_id  site_id   name                from_date   to_date
-- 6               50        "Teddy Bear"        2016-06-07  2016-06-15      //2016-06-06 - 2016-06-16 starts before, ends after existing

-- New and improved SELECT which returns non-conflicting site_id(s)
--
-- requested reservation from date: 2016-06-20
-- requested reservation to date:   2016-06-28
SELECT DISTINCT site_id FROM reservation
WHERE site_id NOT IN
(SELECT site_id FROM reservation r
WHERE ('2016-06-20'<r.from_date AND '2016-06-28'>r.to_date)
OR ('2016-06-20'>r.from_date AND '2016-06-28'<r.to_date)
OR ('2016-06-20'<r.to_date AND '2016-06-28'>from_date));

-- site_id
-- 47
-- 50

INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (47, 'Danny Pink', '2016-08-04', '2016-08-09');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (47, 'Lori Orange', '2016-08-15', '2016-08-21');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (48, 'Mike Blue', '2016-07-21', '2016-08-03');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (49, 'Clara Brown', '2016-07-19', '2016-07-21');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (49, 'Zeke Apricot', '2016-08-02', '2016-08-10');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (50, 'Helen Purple', '2016-07-07', '2016-07-20');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (50, 'Steve Green', '2016-08-09', '2016-08-12');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (51, 'Meredith Grey', '2016-07-27', '2016-08-10');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (51, 'Jules Amber', '2016-08-03', '2016-08-17');

INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (47, 'Lenny Luke', '2016-09-08', '2016-09-16');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (47, 'Able Baker', '2016-09-15', '2016-09-21');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (48, 'Ben Grimm', '2016-08-23', '2016-09-05');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (49, 'Reed Richards', '2016-09-17', '2016-09-26');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (49, 'Sue Storm', '2016-09-04', '2016-09-10');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (50, 'Mary Waters', '2016-08-11', '2016-08-20');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (50, 'Bill Boderick', '2016-09-15', '2016-09-22');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (51, 'Angus Wilcox', '2016-10-05', '2016-10-13');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (51, 'Jill Jones', '2016-09-24', '2016-10-07');

-- New, New, New and improved improved improved SELECT which returns non-conflicting site_id(s) for a given campground
--
-- requested campground Cuyahoga Valley (7)
-- requested reservation from date: 2016-06-20
-- requested reservation to date:   2016-06-28
SELECT DISTINCT s.site_id FROM site s
inner join reservation r on s.site_id=r.site_id
WHERE s.campground_id=7 and r.site_id NOT IN
(SELECT s.site_id FROM campground c
inner join site s on c.campground_id=s.campground_id
inner join reservation r on s.site_id=r.site_id
WHERE s.campground_id=7
AND (('2016-06-20'<r.from_date AND '2016-06-28'>r.to_date)
OR ('2016-06-20'>r.from_date AND '2016-06-28'<r.to_date)
OR ('2016-06-20'<r.to_date AND '2016-06-28'>from_date)));
