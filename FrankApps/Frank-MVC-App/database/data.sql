-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;

--Create Cookout:
INSERT INTO cookout
VALUES ('101', 'Neighborhood Cookout', 'Come celebrate the best cookout of all time', '1', '08/25/2018', '00:14:00', '20:00:00', '1274 Ethel Ave', 'Lakewood', 'OH', '44107');

INSERT INTO cookout
VALUES ('102', 'End of Summer Cookout', 'End summer the right way with a big old Labor Day Bash', '1', '09/04/18', '17:00:00', '22:00:00', 'High St', 'Columbus', 'OH', '43201');

--Add menu item:
INSERT INTO menu_items
VALUES ('1', 'Hamburgers', 'Yes');

INSERT INTO menu_items
VALUES ('2', 'Hot Dogs', 'Yes');

INSERT INTO menu_items
VALUES ('3', 'BBQ Chicken', 'Yes');

INSERT INTO menu_items
VALUES ('4', 'Brawurst', 'Yes');

INSERT INTO menu_items
VALUES ('5', 'Dog Slaw', 'Yes');

INSERT INTO menu_items
VALUES ('6', 'Portabello Mushrooms', 'Yes');

INSERT INTO menu_items
VALUES ('7', 'Flank Steak', 'Yes');

INSERT INTO menu_items
VALUES ('8', 'Corn on the Cob', 'Yes');

INSERT INTO menu_items
VALUES ('9', 'Venison', 'Yes');

INSERT INTO menu_items
VALUES ('10', 'Potato Salad', 'No');

INSERT INTO menu_items
VALUES ('11', 'Cole Slaw', 'No');

INSERT INTO menu_items
VALUES ('12', 'Cake', 'No');

INSERT INTO menu_items
VALUES ('13', 'Baked Beans', 'No');

INSERT INTO menu_items
VALUES ('14', 'Ribs', 'Yes');

INSERT INTO menu_items
VALUES ('15', 'Steak-Ka-Bobs', 'Yes');

INSERT INTO menu_items
VALUES ('16', 'Grilled Squash', 'Yes');

INSERT INTO menu_items
VALUES ('17', 'Cookies', 'No');

INSERT INTO menu_items
VALUES ('18', 'Deviled Eggs', 'No');

INSERT INTO menu_items
VALUES ('19', 'Chicken Wings', 'No');

INSERT INTO menu_items
VALUES ('20', 'Pasta Salad', 'No');

INSERT INTO menu_items
VALUES ('21', 'Chips and Salsa', 'No');

INSERT INTO menu_items
VALUES ('22', 'Macaroni Salad', 'No');

INSERT INTO menu_items
VALUES ('23', 'Italian Sausage', 'Yes');


--Create Cookout Menu:
INSERT INTO cookout_menu (cookout_id, item_id)
VALUES (101,1);

INSERT INTO cookout_menu (cookout_id, item_id)
VALUES (101,2);

INSERT INTO cookout_menu (cookout_id, item_id)
VALUES (101,3);

INSERT INTO cookout_menu (cookout_id, item_id)
VALUES (101,5);

INSERT INTO cookout_menu (cookout_id, item_id)
VALUES (101,6);

INSERT INTO cookout_menu (cookout_id, item_id)
VALUES (101,8);

INSERT INTO cookout_menu (cookout_id, item_id)
VALUES (101,11);


INSERT INTO attendee (email_address, a_first_name, a_last_name)
VALUES ('jmcgrath201@yahoo.com', 'JB', 'Edwards');

--INSERT INTO cookout_attendee (attendee_id, cookout_id)
--VALUES (1,101);

INSERT INTO attendee (email_address, a_first_name, a_last_name)
VALUES ('brian_avsec@yahoo.com', 'Brian', 'Avsec');

--INSERT INTO cookout_attendee (attendee_id, cookout_id)
--VALUES (2,101);

INSERT INTO attendee (email_address, a_first_name, a_last_name)
VALUES ('cath.e.green@gmail.com', 'Cathryn', 'Greene');

--INSERT INTO cookout_attendee (attendee_id, cookout_id)
--VALUES (3,101);

INSERT INTO attendee (email_address, a_first_name, a_last_name)
VALUES ('mcgrath.jamesb@gmail.com', 'Jimmy', 'Bobcat');

--INSERT INTO cookout_attendee (attendee_id, cookout_id)
--VALUES (4,101);

INSERT INTO attendee (email_address, a_first_name, a_last_name)
VALUES ('mkekic23@gmail.com', 'Mike', 'Kekic');

--INSERT INTO cookout_attendee (attendee_id, cookout_id)
--VALUES (5,101);

INSERT INTO orders (order_id, cookout_id, order_name)
VALUES(101, 101,'Mike');

INSERT INTO orders (order_id, cookout_id, order_name)
VALUES(102,101,'Cathryn');

INSERT INTO orders (order_id, cookout_id, order_name)
VALUES(103,101,'Big Russ');

INSERT INTO orders (order_id, cookout_id, order_name)
VALUES(104,101,'Eddy');

INSERT INTO order_items(order_id, item_id, comments, quantity)
VALUES(101, 2, 'classic tube-steaks', 2);

INSERT INTO order_items(order_id, item_id, comments, quantity)
VALUES(102, 1, 'Burgers so rare they almost breathe', 3);

INSERT INTO order_items(order_id, item_id, comments, quantity)
VALUES(103, 3, 'I prefer my chicken medium-rare', 1);

INSERT INTO order_items(order_id, item_id, comments, quantity)
VALUES(104, 4, 'As fast as you can cook it!', 1);


COMMIT;
