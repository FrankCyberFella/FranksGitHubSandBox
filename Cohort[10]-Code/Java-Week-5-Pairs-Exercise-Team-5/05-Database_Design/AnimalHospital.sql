drop table if exists pet                cascade;
drop table if exists owner              cascade;
drop table if exists visit              cascade;
drop table if exists procedure          cascade;
drop table if exists address            cascade;
drop table if exists hospital           cascade;
drop table if exists invoice            cascade;
drop table if exists city               cascade;


CREATE TABLE pet (
pet_id serial NOT NULL,
pet_name varchar(20) NOT NULL,
pet_type varchar(20) NOT NULL,
pet_age integer NOT NULL,
owner_id integer NOT NULL,
CONSTRAINT pk_pet_pet_id PRIMARY KEY (pet_id)
);

CREATE TABLE owner (
owner_id serial NOT NULL,
first_name varchar(30) NOT NULL,
last_name varchar(30) NOT NULL,
address_id integer NOT NULL,
CONSTRAINT pk_owner_owner_id PRIMARY KEY (owner_id)
);

CREATE TABLE visit (
visit_id serial NOT NULL,
visit_date timestamp without time zone NOT NULL,
pet_id integer NOT NULL,
procedure_id integer NOT NULL,
invoice_id integer NOT NULL,
CONSTRAINT pk_visit_visit_id_pet_id_procedure_id PRIMARY KEY (visit_id)
);

CREATE TABLE procedure (
procedure_id serial NOT NULL,
procedure_name varchar(30) NOT NULL,
amount numeric(6,2) NOT NULL,
CONSTRAINT pk_procedure_procedure_id PRIMARY KEY (procedure_id)
);

CREATE TABLE address (
address_id serial NOT NULL,
address varchar(50) NOT NULL,
state varchar(20) NOT NULL,
city_id integer NOT NULL,
postal_code integer NOT NULL,
CONSTRAINT pk_address_address_id PRIMARY KEY (address_id)
);

CREATE TABLE city (
city_id serial NOT NULL,
city varchar(30) NOT NULL,
CONSTRAINT pk_city_city_id PRIMARY KEY (city_id)
);

CREATE TABLE hospital (
hospital_id serial NOT NULL,
hospital_name varchar(50) DEFAULT 'HILLTOP ANIMAL HOSPITAL' NOT NULL,
address_id integer NOT NULL,
CONSTRAINT pk_hospital_hospital_id PRIMARY KEY (hospital_id)
);

CREATE TABLE invoice (
invoice_id serial NOT NULL,
owner_id integer NOT NULL,
visit_id integer NOT NULL,
total numeric(6,2) DEFAULT 0.00 NOT NULL,
CONSTRAINT pk_invoice_invoice_id PRIMARY KEY (invoice_id)
);


ALTER TABLE pet
ADD FOREIGN KEY (owner_id)
REFERENCES owner(owner_id);

ALTER TABLE owner
ADD FOREIGN KEY (address_id)
REFERENCES address(address_id);

ALTER TABLE invoice
ADD FOREIGN KEY (owner_id)
REFERENCES owner(owner_id);

ALTER TABLE invoice
ADD FOREIGN KEY (visit_id)
REFERENCES visit(visit_id);

ALTER TABLE visit
ADD FOREIGN KEY (invoice_id)
REFERENCES invoice(invoice_id);

ALTER TABLE address
ADD FOREIGN KEY (city_id)
REFERENCES city(city_id);

ALTER TABLE hospital
ADD FOREIGN KEY (address_id)
REFERENCES address(address_id);

ALTER TABLE visit
ADD FOREIGN KEY (pet_id)
REFERENCES pet(pet_id);

ALTER TABLE visit
ADD FOREIGN KEY (procedure_id)
REFERENCES procedure(procedure_id);


