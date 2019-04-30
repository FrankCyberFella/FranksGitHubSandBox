-- invoice table was created accidentally due to mouse user error

DROP TABLE IF EXISTS owner                      cascade;
DROP TABLE IF EXISTS pet                        cascade;
DROP TABLE IF EXISTS procedure                  cascade;
DROP TABLE IF EXISTS pet_procedure              cascade;
DROP TABLE IF EXISTS pet_owner                  cascade;

CREATE TABLE owner (
    owner_id serial NOT NULL,
    owner_name varchar(80) NOT NULL,
    address varchar(100) NOT NULL,
    CONSTRAINT pk_owner_owner_id PRIMARY KEY (owner_id)
);

CREATE TABLE pet (
    pet_id serial NOT NULL,
    pet_name varchar(80) NOT NULL,
    type varchar(50) NOT NULL,
    CONSTRAINT pk_pet_pet_id PRIMARY KEY (pet_id)
);

CREATE TABLE pet_owner (
    owner_id integer NOT NULL,
    pet_id integer NOT NULL,
    CONSTRAINT pk_pet_owner_owner_id PRIMARY KEY (owner_id)
);

CREATE TABLE pet_procedure (
    pet_procedure_id serial NOT NULL,
    date timestamp without time zone NOT NULL,
    pet_id integer NOT NULL,
    procedure_id integer NOT NULL,
    description varchar(200) NOT NULL,
    price numeric(6,2) NOT NULL,
    CONSTRAINT pk_pet_procedure_pet_procedure_id PRIMARY KEY (pet_procedure_id)
    
  
);

CREATE TABLE procedure (
    description varchar(500) NOT NULL,
    procedure_id integer NOT NULL,
    price numeric(6,2) NOT NULL,
    CONSTRAINT pk_procedure_description PRIMARY KEY (description)
);

CREATE TABLE invoice (
    invoice_id serial NOT NULL,
    pet_procedure_id integer NOT NULL,
    owner_name varchar(80) NOT NULL,
    procedure_id integer NOT NULL,
    price numeric(6,2) NOT NULL,
    description varchar (500) NOT NULL,
    pet_name varchar (50) NOT NULL,
    address varchar (100) NOT NULL,
    CONSTRAINT pk_invoice_invoice_id PRIMARY KEY (invoice_id),
    CONSTRAINT fk_invoice_pet_procedure_id FOREIGN KEY (pet_procedure_id) references pet_procedure (pet_procedure_id)
);


ALTER TABLE pet_owner
ADD FOREIGN KEY (pet_id)
REFERENCES pet (pet_id);

ALTER TABLE pet_procedure
ADD FOREIGN KEY (description)
REFERENCES procedure (description);

ALTER TABLE pet_owner
ADD FOREIGN KEY (owner_id)
REFERENCES owner (owner_id);



COMMIT;






