drop table if exists employee                           cascade;
drop table if exists department                         cascade;
drop table if exists project                            cascade;
drop table if exists project_employee                   cascade;
drop table if exists employee_department                cascade;


Create table employee(
employee_id serial NOT NULL,
job_title varchar(50) NOT NULL,
lastname varchar(50) NOT NULL,
firstname varchar(50) NOT NULL,
gender varchar(1) NOT NULL,
birthday varchar(20) NOT NULL,
hiredate varchar(20) NOT NULL,
CONSTRAINT pk_employee_employee_id PRIMARY KEY (employee_id),
CONSTRAINT ck_gender CHECK (gender IN ('F', 'M')),
CONSTRAINT ck_job_title CHECK (job_title IN('Technician', 'Salesman', 'Customer Service', 'Management', 'Advertisement'))
);

Create table department (
department_id serial NOT NULL,
department_name varchar(50) NOT NULL,
CONSTRAINT pk_department_department_id PRIMARY KEY (department_id),
CONSTRAINT ck_department_name CHECK (department_name IN ( 'Store' , 'Office' , 'Management'))
);

Create table project (
project_id serial NOT NULL,
project_name varchar(50) NOT NULL,
project_startdate varchar(20) NOT NULL,
CONSTRAINT pk_project_project_id PRIMARY KEY (project_id)
);

Create table project_employee (
project_id integer NOT NULL,
employee_id integer NOT NULL,
CONSTRAINT pk_project_employee_project_id_employee_id PRIMARY KEY (project_id, employee_id)
);

Create table employee_department (
employee_id integer NOT NULL,
department_id integer NOT NULL,
CONSTRAINT pk_employee_department_employee_id_department_id PRIMARY KEY (employee_id, department_id)
);

INSERT INTO employee(job_title, lastname, firstname, gender, birthday, hiredate) VALUES ('Technician', 'Brown', 'James', 'M', '10/11/1990', '12/15/2010');
INSERT INTO employee(job_title, lastname, firstname, gender, birthday, hiredate) VALUES ('Salesman', 'Wilt', 'Philip', 'M', '08/14/1980', '1/15/2007');
INSERT INTO employee(job_title, lastname, firstname, gender, birthday, hiredate) VALUES ('Customer Service', 'Warner', 'Mack', 'M', '08/1/1994', '11/07/2014');
INSERT INTO employee(job_title, lastname, firstname, gender, birthday, hiredate) VALUES ('Management', 'Hurst', 'Maggie', 'F', '04/1/1979', '07/9/2000');
INSERT INTO employee(job_title, lastname, firstname, gender, birthday, hiredate) VALUES ('Advertisement', 'Dunn', 'Alex', 'F', '03/9/1984', '02/6/2004');
INSERT INTO employee(job_title, lastname, firstname, gender, birthday, hiredate) VALUES ('Salesman', 'Lola', 'Natalie', 'F', '05/3/1986', '07/8/2005');
INSERT INTO employee(job_title, lastname, firstname, gender, birthday, hiredate) VALUES ('Management', 'Bent', 'Jackie', 'F', '08/17/1987', '03/11/2010');
INSERT INTO employee(job_title, lastname, firstname, gender, birthday, hiredate) VALUES ('Technician', 'Gunn', 'Burt', 'M', '04/5/1987', '12/15/2010');

INSERT INTO department(department_name) VALUES ('Store');
INSERT INTO department(department_name) VALUES ('Office');
INSERT INTO department(department_name) VALUES ('Management');

INSERT INTO project(project_name, project_startdate) VALUES ('Alpha', '10/10/1995');
INSERT INTO project(project_name, project_startdate) VALUES ('Beta', '05/19/1998');
INSERT INTO project(project_name, project_startdate) VALUES ('Omega', '03/16/2000');
INSERT INTO project(project_name, project_startdate) VALUES ('Theta', '06/8/2007');


        
        
ALTER TABLE project_employee
ADD FOREIGN KEY(employee_id)
REFERENCES employee(employee_id);

ALTER TABLE project_employee
ADD FOREIGN KEY(project_id)
REFERENCES project(project_id);

ALTER TABLE employee_department
ADD FOREIGN KEY(employee_id)
REFERENCES employee(employee_id);

ALTER TABLE employee_department
ADD FOREIGN KEY(department_id)
REFERENCES department(department_id);


        -- add foreign keys 
        --insert values 
        -- add relator between employee and department 
        -- 
      