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
visit_date timestamp without time zone NOT NULL,
pet_id integer NOT NULL,
procedure_id integer NOT NULL,
invoice integer NOT NULL,
CONSTRAINT pk_visit_visit_date_pet_id_procedure_id PRIMARY KEY (visit_date, pet_id, procedure_id)
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
visit_date timestamp without time zone NOT NULL,
total numeric(6,2) DEFAULT 0.00 NOT NULL,
CONSTRAINT pk_invoice_invoice_id PRIMARY KEY (invoice_id)
);


