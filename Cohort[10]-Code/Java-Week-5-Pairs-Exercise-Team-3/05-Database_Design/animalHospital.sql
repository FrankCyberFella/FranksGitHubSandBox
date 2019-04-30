CREATE TABLE pet (
        pet_id serial NOT NULL,
        pet_name varchar(20) NOT NULL,
        pet_type varchar(20) NOT NULL,
        pet_age integer NOT NULL,
        owner_id integer NOT NULL,
        activebool boolean DEFAULT true NOT NULL,
        active integer,
        CONSTRAINT pk_pet_pet_id PRIMARY KEY (pet_id),
        CONSTRAINT fk_pet_owner_id FOREIGN KEY (owner_id) REFERENCES owner (owner_id)
);

CREATE TABLE owner (
        owner_id serial NOT NULL,
        owner_first_name varchar(20) NOT NULL,
        owner_last_name varchar(20) NOT NULL,
        CONSTRAINT pk_owner_owner_id PRIMARY KEY (owner_id)
);

CREATE TABLE procedure (
        procedure_id SERIAL NOT NULL,
        procedure_name varchar(20) NOT NULL,
        visit_date varchar(20) NOT NULL,
        invoice_id integer NOT NULL,
        CONSTRAINT pk_procedure_procedure_id PRIMARY KEY (procedure_id)
);

CREATE TABLE pet_procedure (
        procedure_id integer NOT NULL,
        pet_id integer NOT NULL,
        CONSTRAINT pk_pet_procedure_procedure_id_pet_id PRIMARY KEY (procedure_id, pet_id),
        CONSTRAINT fk_pet_procedure_procedure_id FOREIGN KEY (procedure_id) REFERENCES procedure (procedure_id),
        CONSTRAINT fk_pet_procedure_pet_id FOREIGN KEY (pet_id) REFERENCES pet (pet_id)
);

CREATE TABLE invoice (
        invoice_id serial NOT NULL,
        pet_id integer NOT NULL,
        procedure_id integer NOT NULL,
        expenses numeric NOT NULL,
        CONSTRAINT pk_invoice_invoice_id PRIMARY KEY (invoice_id),
        CONSTRAINT fk_invoice_pet_id FOREIGN KEY (pet_id) REFERENCES pet (pet_id),
        CONSTRAINT fk_invoice_procedure_id FOREIGN KEY (procedure_id) REFERENCES procedure (procedure_id)
);

CREATE TABLE procedure_invoice (
        procedure_id integer NOT NULL,
        invoice_id integer NOT NULL,
        CONSTRAINT pk_procedure_invoice_procedure_id_invoice_id PRIMARY KEY (procedure_id, invoice_id),
        CONSTRAINT fk_procedure_invoice_procedure_id FOREIGN KEY (procedure_id) REFERENCES procedure (procedure_id),
        CONSTRAINT fk_procedure_invoice_invoice_id FOREIGN KEY (invoice_id) REFERENCES invoice (invoice_id)
);