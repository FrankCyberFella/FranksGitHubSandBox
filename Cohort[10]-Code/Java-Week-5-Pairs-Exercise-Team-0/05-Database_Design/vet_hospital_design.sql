BEGIN TRANSACTION;

DROP TABLE IF EXISTS pet                     CASCADE;
DROP TABLE IF EXISTS owner                   CASCADE;
DROP TABLE IF EXISTS procedure               CASCADE;
DROP TABLE IF EXISTS pet_procedure           CASCADE;

CREATE TABLE pet (
    pet_id SERIAL NOT NULL,
    name varchar(64) NOT NULL,
    birthday date NOT NULL,
    gender varchar(6) NOT NULL,
    owner integer NOT NULL,
    CONSTRAINT pk_pet_id PRIMARY KEY (pet_id),
    CONSTRAINT pet_gender_check CHECK ((gender = 'Male') OR (gender = 'Female'))
);

CREATE TABLE owner (
    owner_id SERIAL NOT NULL,
    address varchar(64) NOT NULL,
    first_name varchar(64) NOT NULL,
    last_name varchar(64) NOT NULL,
    gender varchar(6) NOT NULL,
    pet integer NOT NULL, 
    CONSTRAINT pk_owner_id PRIMARY KEY (owner_id)
    
);

CREATE TABLE procedure (
    procedure_id SERIAL NOT NULL,
    name varchar(64) NOT NULL,
    cost integer NOT NULL,
    length integer DEFAULT 60 NOT NULL,
    CONSTRAINT pk_procedure_id PRIMARY KEY (procedure_id)
);

CREATE TABLE pet_procedure (
    id SERIAL NOT NULL,
    pet_id integer NOT NULL,
    procedure_id integer NOT NULL,
    CONSTRAINT pk_pet_procedure_id PRIMARY KEY (id)
);


ALTER TABLE pet
ADD FOREIGN KEY (owner)
REFERENCES owner(owner_id);

ALTER TABLE owner
ADD FOREIGN KEY (pet)
REFERENCES pet(pet_id);

ALTER TABLE pet_procedure
ADD FOREIGN KEY (pet_id)
REFERENCES pet(pet_id);

ALTER TABLE pet_procedure
ADD FOREIGN KEY (procedure_id)
REFERENCES procedure(procedure_id);

commit;
