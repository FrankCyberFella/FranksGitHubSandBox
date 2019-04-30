BEGIN Transaction;

DROP TABLE IF EXISTS user_restaurant cascade;
DROP TABLE IF EXISTS users cascade;
DROP TABLE IF EXISTS restaurants cascade;

CREATE TABLE users (
  id serial PRIMARY KEY,
  username varchar(255) NOT NULL UNIQUE,     -- Username
  password varchar(32) NOT NULL,      -- Password
  salt varchar(256) NOT NULL,          -- Password Salt
  role varchar(255) NOT NULL default('user'),
  city varchar(255),
  state varchar(255),
  current_preference int
);

CREATE TABLE restaurants (
  id serial PRIMARY KEY,
  name varchar(255) NOT NULL,
  address varchar(255) NOT NULL,
  city varchar(255) NOT NULL,
  cuisine varchar(255) NOT NULL,
  rating float NOT NULL,
  price varchar(5) NOT NULL,
  locality varchar(255) NOT NULL,
  menu varchar(255)
);

CREATE TABLE user_restaurant (
  user_id int NOT NULL,
  restaurant_id int NOT NULL,
  CONSTRAINT pk_users_user_id_restaurants_restaurant_id PRIMARY KEY (user_id, restaurant_id)
);

ALTER TABLE user_restaurant
ADD Foreign Key(user_id)
references users(id);

ALTER TABLE user_restaurant
ADD Foreign Key(restaurant_id)
references restaurants(id);

ALTER TABLE restaurants
DROP COLUMN state;

ALTER TABLE user_restaurant
ADD times_visited int
;

commit Transaction;
