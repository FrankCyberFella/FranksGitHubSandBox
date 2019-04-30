drop table if exists pets                       cascade;
drop table if exists owner                       cascade;
drop table if exists visit_date                       cascade;
drop table if exists procedure                       cascade;
drop table if exists visit_procedure                      cascade;
drop table if exists invoice                     cascade;


CREATE TABLE pets (
pet_id serial NOT NULL,
pet_name varchar(50) NOT NULL,
pet_type varchar(50) NOT NULL,
pet_age smallint NOT NULL,
CONSTRAINT pk_pets_pet_id PRIMARY KEY (pet_id)
);

CREATE TABLE owner (
owner_id serial NOT NULL,
owner_name varchar(50) NOT NULL,
pet_id integer NOT NULL,
CONSTRAINT pk_owner_owner_id PRIMARY KEY (owner_id)
);

CREATE TABLE visit_date (
visit_id serial NOT NULL,
visit_day varchar(50) NOT NULL,
CONSTRAINT pk_visit_date_visit_id PRIMARY KEY (visit_id)
);

CREATE TABLE procedure(
procedure_id serial NOT NULL,
procedure_type varchar(50) NOT NULL,
procedure_amount NUMERIC(6, 2),
CONSTRAINT pk_procedure_procedure_id PRIMARY KEY (procedure_id)
);

CREATE TABLE visit_procedure(
visit_id integer NOT NULL,
procedure_id integer NOT NULL,
pet_id integer NOT NULL,
CONSTRAINT pk_visit_procedure_visit_id_procedure_id_pet_id PRIMARY KEY (visit_id, procedure_id, pet_id)
);

CREATE TABLE invoice(
invoice_id serial NOT NULL,
total_amount NUMERIC(6,2),
procedure_id integer NOT NULL,
CONSTRAINT pk_invoice_invoice_id PRIMARY KEY (invoice_id)
);

ALTER TABLE visit_procedure
ADD FOREIGN KEY (visit_id)
REFERENCES visit_date(visit_id);

ALTER TABLE visit_procedure
ADD FOREIGN KEY (procedure_id)
REFERENCES procedure(procedure_id);

ALTER TABLE visit_procedure
ADD FOREIGN KEY (pet_id)
REFERENCES pets(pet_id);

ALTER TABLE owner
ADD FOREIGN KEY (pet_id)
REFERENCES pets(pet_id);

ALTER TABLE invoice
ADD FOREIGN KEY (procedure_id)
REFERENCES procedure(procedure_id);
------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------


INSERT INTO pets(pet_name, pet_type, pet_age)
VALUES('ROVER', 'DOG', 12);
INSERT INTO pets(pet_name, pet_type, pet_age)
VALUES('SPOT', 'DOG', 2);
INSERT INTO pets(pet_name, pet_type, pet_age)
VALUES('MORRIS', 'CAT', 4);
INSERT INTO pets(pet_name, pet_type, pet_age)
VALUES('SPOT', 'DOG', 2);

SELECT * FROM pets;

INSERT INTO owner (owner_name)
VALUES('SAM COOK');
INSERT INTO owner (owner_name)
VALUES('TERRY KIM');

SELECT * FROM owner;

INSERT INTO visit_date (visit_day)
VALUES('JAN 23/2001');
INSERT INTO visit_date (visit_day)
VALUES('JAN 13/2002');
INSERT INTO visit_date (visit_day)
VALUES('JAN 21/2002');
INSERT INTO visit_date (visit_day)
VALUES('MAR 10/2002');
INSERT INTO visit_date (visit_day)
VALUES('MAR 27/2002');
INSERT INTO visit_date (visit_day)
VALUES('APR 02/2002');
INSERT INTO visit_date (visit_day)
VALUES('APR 30/2002');

SELECT * FROM visit_date;

INSERT INTO procedure (procedure_type)
VALUES ('RABIES VACCINE');
INSERT INTO procedure (procedure_type)
VALUES ('HEART WORM TEST');
INSERT INTO procedure (procedure_type)
VALUES ('EXAMINE and TREAT WOUND');
INSERT INTO procedure (procedure_type)
VALUES ('TETANUS VACCINE');
INSERT INTO procedure (procedure_type)
VALUES ('ANNUAL CHECK UP');
INSERT INTO procedure (procedure_type)
VALUES ('EYE WASH');

SELECT * FROM procedure;

INSERT INTO visit_procedure (visit_id, procedure_id, pet_id)
VALUES (2, 1, 1);
INSERT INTO visit_procedure (visit_id, procedure_id, pet_id)
VALUES (5, 3, 1);
INSERT INTO visit_procedure (visit_id, procedure_id, pet_id)
VALUES (6, 2, 1);
INSERT INTO visit_procedure (visit_id, procedure_id, pet_id)
VALUES (3, 4, 2);
INSERT INTO visit_procedure (visit_id, procedure_id, pet_id)
VALUES (4, 2, 2);
INSERT INTO visit_procedure (visit_id, procedure_id, pet_id)
VALUES (1, 1, 3);
INSERT INTO visit_procedure (visit_id, procedure_id, pet_id)
VALUES (2, 1, 3);
INSERT INTO visit_procedure (visit_id, procedure_id, pet_id)
VALUES (7, 5, 4);
INSERT INTO visit_procedure (visit_id, procedure_id, pet_id)
VALUES (7, 6, 4);

