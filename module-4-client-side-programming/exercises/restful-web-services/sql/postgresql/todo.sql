BEGIN TRANSACTION;

CREATE SEQUENCE seq_item_id;

CREATE TABLE todo_items (
    item_id integer NOT NULL DEFAULT nextval('seq_item_id'),
    description text NOT NULL,
    CONSTRAINT pk_item_id PRIMARY KEY(item_id)
);

INSERT INTO todo_items(description)
VALUES('Attend Tech Elevator');

INSERT INTO todo_items(description)
VALUES('Work Hard for 14 Weeks');

INSERT INTO todo_items(description)
VALUES('Get a Job');

COMMIT;