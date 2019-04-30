BEGIN TRANSACTION;
DROP TABLE IF EXISTS invoice            cascade;

CREATE TABLE invoice (
        id serial NOT NULL,
        visit_id integer NOT NULL,
        invoice_date timestamp without time zone NOT NULL,
        paid_date timestamp without time zone NOT NULL,
        CONSTRAINT pk_invoice_id PRIMARY KEY (id)
        );
        
ALTER TABLE procedure
ADD COLUMN price numeric(10,2) NOT NULL;

ALTER TABLE procedure_visit
ADD COLUMN discount numeric(3,1) DEFAULT 0 ;

ALTER TABLE invoice 
ADD FOREIGN KEY (visit_id)
REFERENCES visit(id);



COMMIT;