DROP TABLE IF EXISTS pet                cascade;
DROP TABLE IF EXISTS owner              cascade;
DROP TABLE IF EXISTS visit              cascade;
DROP TABLE IF EXISTS procedure_visit    cascade;
DROP TABLE IF EXISTS procedure          cascade;
DROP TABLE IF EXISTS procedure_invoice  cascade;
DROP TABLE IF EXISTS invoice            cascade; 


CREATE TABLE pet (
        pet_name varchar(30) NOT NULL,
        pet_id serial NOT NULL,
        pet_type varchar(50) NOT NULL,
        pet_age integer NOT NULL,
        owner_id serial NOT NULL,
        CONSTRAINT pk_pet_pet_id PRIMARY KEY (pet_id)
        );
        
CREATE TABLE owner (
        owner_name varchar (50) NOT NULL,
        address varchar (100) NOT NULL,
        owner_id serial NOT NULL,
        CONSTRAINT pk_owner_owner_id PRIMARY KEY (owner_id)
        );
        
CREATE TABLE visit (
        visit_id serial NOT NULL,
        visit_date varchar(10) NOT NULL,
        pet_id serial NOT NULL,
        CONSTRAINT pk_visit_visit_id PRIMARY KEY (visit_id)
        );
        
CREATE TABLE procedure_visit (
        visit_id serial NOT NULL,
        procedure_id serial NOT NULL,
        CONSTRAINT pk_procedure_visit PRIMARY KEY (visit_id, procedure_id)
        );
        
CREATE TABLE procedure (
        procedure_id serial NOT NULL,
        procedure_name varchar(40) NOT NULL,
        amount numeric(4, 2) NOT NULL,
        CONSTRAINT pk_procedure_procedure_id PRIMARY KEY (procedure_id)
        );
        
CREATE TABLE procedure_invoice (
        invoice_id serial NOT NULL,
        procedure_id serial NOT NULL,
        CONSTRAINT pk_procedure_invoice PRIMARY KEY (invoice_id, procedure_id)
        );
        
CREATE TABLE invoice (
        invoice_id serial NOT NULL,
        owner_id serial NOT NULL,
        CONSTRAINT pk_invoice_invoice_id PRIMARY KEY (invoice_id)
        );
        

ALTER TABLE pet
ADD FOREIGN KEY (owner_id)
REFERENCES owner (owner_id);       

ALTER TABLE visit
ADD FOREIGN KEY (pet_id)
REFERENCES pet (pet_id);

ALTER TABLE procedure_visit
ADD FOREIGN KEY (visit_id)
REFERENCES visit (visit_id);

ALTER TABLE procedure_visit
ADD FOREIGN KEY (procedure_id)
REFERENCES   procedure (procedure_id);

ALTER TABLE procedure_invoice
ADD FOREIGN KEY (invoice_id) 
REFERENCES invoice (invoice_id);

ALTER TABLE procedure_invoice
ADD FOREIGN KEY (procedure_id)
REFERENCES procedure (procedure_id);

ALTER TABLE invoice
ADD FOREIGN KEY (owner_id)
REFERENCES owner (owner_id);
         

        