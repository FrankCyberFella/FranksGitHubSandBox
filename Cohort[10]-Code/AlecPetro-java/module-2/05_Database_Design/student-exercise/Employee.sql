drop table if exists employee                   cascade;
drop table if exists department                 cascade;
drop table if exists project                    cascade;
drop table if exists employee_department        cascade;
drop table if exists department_project         cascade;
drop table if exists job                        cascade;
drop table if exists employee_job               cascade;
drop table if exists employee_project           cascade;

CREATE TABLE employee (
employee_id serial NOT NULL,
job_title varchar(20) NOT NULL DEFAULT 'Worker',
last_name varchar(20) NOT NULL,
first_name varchar(20) NOT NULL,
gender varchar(6) NOT NULL DEFAULT 'M' ,
birthday varchar(10) NOT NULL DEFAULT '11/26/1992',
hiredate varchar(10) NOT NULL DEFAULT '1/1/2019',
department_id integer NOT NULL,
CONSTRAINT pk_employee_employee_id PRIMARY KEY (employee_id)
);

CREATE TABLE department (
department_id serial NOT NULL,
department_name varchar(20) NOT NULL,
num_of_employees integer NOT NULL,
CONSTRAINT pk_department_department_id PRIMARY KEY (department_id)
);

CREATE TABLE project (
project_id serial NOT NULL,
project_name varchar(30) NOT NULL,
start_date varchar(10) DEFAULT '3/1/2018' NOT NULL,
num_of_employees integer NOT NULL,
CONSTRAINT pk_project_project_id PRIMARY KEY (project_id)
);

CREATE TABLE department_project (
project_id integer NOT NULL,
department_id integer NOT NULL,
CONSTRAINT pk_project_id_department_id PRIMARY KEY (project_id, department_id)
);

--CREATE TABLE employee_project (
--employee_id integer NOT NULL,
--project_id integer NOT NULL,
--CONSTRAINT pk_employee_id_project_id PRIMARY KEY (employee_id, project_id)
--);



INSERT INTO project (project_id, project_name, num_of_employees, start_date) VALUES (1, 'MANHATTAN', 6, '11/12/16');
INSERT INTO project (project_id, project_name, num_of_employees, start_date) VALUES (2, 'BROOKLYN', 5, '5/5/17');
INSERT INTO project (project_id, project_name, num_of_employees, start_date) VALUES (3, 'QUEENS', 4, '3/3/13');
INSERT INTO project (project_id, project_name, num_of_employees) VALUES (4, 'HARLEM', 3);
INSERT INTO department (department_id, department_name, num_of_employees) VALUES (1, 'FINANCE', 3);
INSERT INTO department (department_id, department_name, num_of_employees) VALUES (2, 'MARKETING', 5);
INSERT INTO department (department_id, department_name, num_of_employees) VALUES (3, 'IT', 2);
INSERT INTO employee (employee_id, last_name, first_name, department_id, job_title)
        VALUES (1, 'Mayfield', 'Baker', 1, 'Intern');
INSERT INTO employee (employee_id, last_name, first_name, department_id, job_title)
        VALUES (2, 'Peppers', 'Jabrill', 1, 'Junior');
INSERT INTO employee (employee_id, last_name, first_name, department_id, job_title)
        VALUES (3, 'Thmoas', 'Joe', 2, 'Senior');
INSERT INTO employee (employee_id, last_name, first_name, department_id, job_title)
        VALUES (4, 'Chubb', 'Nick', 2, 'Intern');
INSERT INTO employee (employee_id, last_name, first_name, department_id, job_title)
        VALUES (5, 'Hunt', 'Kareem', 1, 'Junior');
INSERT INTO employee (employee_id, last_name, first_name, department_id, job_title)
        VALUES (6, 'Garrett', 'Myles', 3, 'Junior');
INSERT INTO employee (employee_id, last_name, first_name, department_id, job_title)
        VALUES (7, 'Kirksey', 'Christian', 1, 'Senior');
INSERT INTO employee (employee_id, last_name, first_name, department_id, job_title)
        VALUES (8, 'Ward', 'Denzel', 3, 'Intern');
INSERT INTO department_project (department_id, project_id)
        VALUES (1,1);
INSERT INTO department_project (department_id, project_id)
        VALUES (1,2);
INSERT INTO department_project (department_id, project_id)
        VALUES (1,3);
INSERT INTO department_project (department_id, project_id)
        VALUES (2,3);
INSERT INTO department_project (department_id, project_id)
        VALUES (3,2);

--ALTER TABLE employee_department
--ADD FOREIGN KEY (employee_id)
--REFERENCES employee(employee_id);

--ALTER TABLE employee_department
--ADD FOREIGN KEY (department_id)
--REFERENCES department(department_id);

ALTER TABLE employee
ADD FOREIGN KEY (department_id)
REFERENCES department(department_id);

ALTER TABLE department_project
ADD FOREIGN KEY (project_id)
REFERENCES project(project_id);

ALTER TABLE department_project
ADD FOREIGN KEY (department_id)
REFERENCES department(department_id);

ALTER TABLE employee
ADD CONSTRAINT check_job_title
  CHECK (job_title IN ('Intern', 'Junior', 'Senior'));
