-- **************************************************************
-- This script destroys the database and associated users
-- **************************************************************

-- ALTER TABLE users ALTER COLUMN salt set NOT NULL;
-- ALTER TABLE users ALTER COLUMN role set NOT NULL;



-- The following line terminates any active connections to the database so that it can be destroyed
SELECT pg_terminate_backend(pid) FROM pg_stat_activity WHERE datname = 'capstone';

DROP DATABASE capstone;

DROP USER capstone_owner;
DROP USER capstone_appuser;


-- Used to Drop individual tables
Drop Table cookout_users;
Drop Table cookout_menu;
Drop Table user_order;
Drop Table order_items;
Drop Table menu_items;
Drop Table cookout;
Drop Table users;
DROP TABLE attendee;
DROP TABLE orders;
DROP TABLE cookout_attendee;
DROP TABLE attendee_order;


DROP table cookout_users;
drop table user_order;
DROP TABLE users;
