DROP TABLE IF EXISTS pet        CASCADE;
DROP TABLE IF EXISTS owner        CASCADE;
DROP TABLE IF EXISTS pet_owner        CASCADE;
DROP TABLE IF EXISTS procedures        CASCADE;
DROP TABLE IF EXISTS owner_procedures        CASCADE;
DROP TABLE IF EXISTS invoice        CASCADE;
DROP TABLE IF EXISTS owner_invoice        CASCADE;

CREATE TABLE pet (
        pet_id SERIAL NOT NULL,
        pet_name VARCHAR(40) NOT NULL,
        pet_type VARCHAR(40) NOT NULL,
        pet_age integer DEFAULT 1 NOT NULL,
        CONSTRAINT pk_pet_pet_id PRIMARY KEY (pet_id)
);

CREATE TABLE owner (
        owner_id SERIAL NOT NULL,
        first_name VARCHAR(40) NOT NULL,
        last_name VARCHAR(40) NOT NULL,
        gender VARCHAR(1) DEFAULT 'M',
        address VARCHAR(40) NOT NULL,
        CONSTRAINT pk_owner_owner_id PRIMARY KEY (owner_id),
        CONSTRAINT ck_owner_gender CHECK (gender IN ('M', 'F'))
);

CREATE TABLE pet_owner (
        pet_id INTEGER NOT NULL,
        owner_id INTEGER NOT NULL,
        CONSTRAINT pk_pet_owner_pet_id_owner_id PRIMARY KEY (pet_id, owner_id)
);

CREATE TABLE procedures (
        procedure_id SERIAL NOT NULL,
        name VARCHAR(60) NOT NULL,
        amount NUMERIC(8,2) DEFAULT 50.00 NOT NULL,
        CONSTRAINT pk_procedures_procedure_id PRIMARY KEY (procedure_id)
);
        
CREATE TABLE owner_procedures (
        owner_id INTEGER NOT NULL,
        procedure_id INTEGER NOT NULL,
        procedure_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
        CONSTRAINT pk_owner_procedures_owner_id_procedure_id PRIMARY KEY (owner_id, procedure_id)
);

CREATE TABLE invoice (
        invoice_id SERIAL NOT NULL,
        hospital_name VARCHAR(40) NOT NULL,
        tax_rate INTEGER DEFAULT 8 NOT NULL,
        CONSTRAINT pk_invoice_invoice_id PRIMARY KEY (invoice_id)
);

CREATE TABLE owner_invoice (
        invoice_id INTEGER NOT NULL,
        owner_id INTEGER NOT NULL,
        CONSTRAINT pk_owner_invoice_invoice_id_owner_id PRIMARY KEY (invoice_id, owner_id)
);
       
ALTER TABLE pet_owner
ADD FOREIGN KEY (pet_id)
REFERENCES pet(pet_id);
 
ALTER TABLE pet_owner
ADD FOREIGN KEY (owner_id)
REFERENCES owner(owner_id);
        
ALTER TABLE owner_procedures
ADD FOREIGN KEY (procedure_id)
REFERENCES procedures(procedure_id);
 
ALTER TABLE owner_procedures
ADD FOREIGN KEY (owner_id)
REFERENCES owner(owner_id);
        
ALTER TABLE owner_invoice
ADD FOREIGN KEY (invoice_id)
REFERENCES invoice(invoice_id);
 
ALTER TABLE owner_invoice
ADD FOREIGN KEY (owner_id)
REFERENCES owner(owner_id);