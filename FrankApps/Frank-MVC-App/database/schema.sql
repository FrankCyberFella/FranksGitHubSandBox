-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

-- CREATE statements go here
DROP TABLE IF EXISTS users;

CREATE TABLE users (
user_id serial NOT NULL,
first_name varchar(45) NOT NULL,
last_name varchar(45) NOT NULL,
username varchar(45) NOT NULL,
password varchar(45) NOT NULL,
salt varchar(255),
CONSTRAINT pk_user_user_id PRIMARY KEY (user_id)
);

CREATE TABLE cookout (
cookout_id serial NOT NULL,
cookout_name varchar(45) NOT NULL,
description varchar(300) NOT NULL,
cookout_host int NOT NULL,
cookout_date date NOT NULL,
start_time time NOT NULL,
end_time time,
street varchar(45), --renamed from address
city varchar(45),
cookout_state varchar(45),
zip int,
CONSTRAINT pk_cookout_cookout_id PRIMARY KEY (cookout_id)
);

CREATE TABLE attendee (
attendee_id serial NOT NULL,
a_first_name varchar(45) NOT NULL,
a_last_name varchar(45) NOT NULL,
email_address varchar(45) NOT NULL,
CONSTRAINT pk_attendee_attendee_id PRIMARY KEY (attendee_id)
);

CREATE TABLE menu_items (
item_id serial NOT NULL,
item_name varchar(45) NOT NULL,
grillable varchar(3) NOT NULL,
CONSTRAINT pk_menu_items_item_id PRIMARY KEY (item_id)
);

CREATE TABLE order_items (
order_id int NOT NULL,
item_id int NOT NULL,
comments varchar(100),
quantity int NOT NULL,
CONSTRAINT order_items_item_id_order_id PRIMARY KEY (order_id, item_id)
);

CREATE TABLE orders (
order_id serial NOT NULL,
cookout_id int NOT NULL,
order_name varchar(30) NOT NULL,
finished varchar(3) DEFAULT 'No',
CONSTRAINT pk_orders_order_id PRIMARY KEY (order_id)
);

CREATE TABLE cookout_attendee (
cookout_id int NOT NULL,
attendee_id int NOT NULL,
CONSTRAINT pk_cookout_users_cookout_id_attendee_id PRIMARY KEY (cookout_id, attendee_id)
);

CREATE TABLE cookout_menu (
cookout_id int NOT NULL,
item_id int NOT NULL,
CONSTRAINT cookout_menu_cookout_id_item_id PRIMARY KEY (cookout_id, item_id)
);

ALTER TABLE cookout
ADD FOREIGN KEY (cookout_host)
REFERENCES users (user_id);

ALTER TABLE cookout_attendee
ADD FOREIGN KEY (cookout_id)
REFERENCES cookout (cookout_id);

ALTER TABLE cookout_attendee
ADD FOREIGN KEY (attendee_id)
REFERENCES attendee (attendee_id);

ALTER TABLE cookout_menu
ADD FOREIGN KEY (cookout_id)
REFERENCES cookout (cookout_id);

ALTER TABLE cookout_menu
ADD FOREIGN KEY (item_id)
REFERENCES menu_items (item_id);

ALTER TABLE orders
ADD FOREIGN KEY (cookout_id)
REFERENCES cookout (cookout_id);

ALTER TABLE order_items
ADD FOREIGN KEY (order_id)
REFERENCES orders (order_id);

ALTER TABLE order_items
ADD FOREIGN KEY (item_id)
REFERENCES menu_items(item_id);


COMMIT;

