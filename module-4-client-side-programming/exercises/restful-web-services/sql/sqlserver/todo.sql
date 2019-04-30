BEGIN TRANSACTION;

CREATE TABLE todo_items (
    item_id integer identity NOT NULL,
    description text NOT NULL,
	list_name varchar(250) NULL,
	is_complete bit not null default 0,
    CONSTRAINT pk_item_id PRIMARY KEY(item_id)
);

INSERT INTO todo_items(description, list_name)
VALUES('Attend Tech Elevator', 'Bootcamp');

INSERT INTO todo_items(description, list_name)
VALUES('Work Hard for 14 Weeks', 'Bootcamp');

INSERT INTO todo_items(description, list_name)
VALUES('Get a Job', 'Bootcamp');

COMMIT;