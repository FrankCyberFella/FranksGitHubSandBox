--display Orders:
SELECT orders.order_id, orders.order_name, menu_items.item_name, order_items.quantity, order_items.comments, orders.finished FROM menu_items
JOIN order_items
ON (menu_items.item_id = order_items.item_id)
JOIN orders
ON (order_items.order_id = orders.order_id)
JOIN cookout
ON (cookout.cookout_id = orders.cookout_id)
WHERE cookout.cookout_id = 101 ORDER BY orders.order_id;


SELECT nextval('orders_order_id_seq');

--Display all menu items:
SELECT * FROM menu_items;

--Can't remember
SELECT cookout_name, description, cookout_date  FROM users JOIN cookout ON cookout.cookout_host = users.user_id WHERE users.username = 'mcgrath.jamesb@gmail.com';

--Show Order Summary:
SELECT item_name AS Food_Items, SUM(order_items.quantity) AS Total_Quantity
FROM order_items
JOIN menu_items
ON order_items.item_id = menu_items.item_id
JOIN orders
ON order_items.order_id = orders.order_id
JOIN cookout
ON cookout.cookout_id = orders.cookout_id
WHERE cookout.cookout_id = 101 GROUP BY menu_items.item_name;

--Display my Cookouts
SELECT * FROM cookout
JOIN users
ON (cookout.cookout_host = users.user_id)
WHERE username = 'mcgrath.jamesb@gmail.com'; -- change username based on test data in table users on your computer

--Show Cookout Menu:
SELECT cookout_menu.item_id, cookout_menu.cookout_id, menu_items.item_name, menu_items.grillable FROM cookout_menu
JOIN cookout
ON (cookout.cookout_id = cookout_menu.cookout_id)
JOIN menu_items
ON (menu_items.item_id = cookout_menu.item_id)
WHERE cookout_menu.cookout_id = 101;

INSERT INTO order_items(order_id, item_id, comments, quantity)
VALUES (101, 7, 'give me more', 3);

UPDATE orders
SET finished = 'No';

INSERT INTO cookout_attendee (cookout_id, attendee_id)
VALUES (101, 11);

INSERT INTO cookout_attendee (cookout_id, attendee_id)
VALUES (101, 12);

INSERT INTO cookout_attendee (cookout_id, attendee_id)
VALUES (101, 13);

INSERT INTO cookout_attendee (cookout_id, attendee_id)
VALUES (101, 14);

INSERT INTO cookout_attendee (cookout_id, attendee_id)
VALUES (101, 15);


SELECT a_first_name, a_last_name FROM attendee
JOIN cookout_attendee
ON cookout_attendee.attendee_id = attendee.attendee_id			
WHERE cookout_attendee.cookout_id = 101;	

UPDATE attendee
SET email_address = 'jmcgrath201@yahoo.com'
WHERE attendee_id = 33;						
									