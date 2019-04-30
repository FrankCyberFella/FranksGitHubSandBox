drop table if exists employee               cascade;
drop table if exists employee_department    cascade;
drop table if exists department             cascade;
drop table if exists  employee_project      cascade;
drop table if exists project                cascade;
drop table if exists job_title              cascade;

CREATE TABLE employee (
employee_id serial NOT NULL,
job_title_id integer NOT NULL,
last_name  varchar(20) NOT NULL,
first_name varchar(20) NOT NULL,
gender varchar(1)  NOT NULL,
birthday varchar(20) default '12/25/2019',
hire_date varchar(20) default current_date,
department_id integer NOT NULL,
CONSTRAINT pk_employee_employee_id PRIMARY KEY (employee_id),
CONSTRAINT ck_gender CHECK(gender IN('M', 'F'))
);

 --   CONSTRAINT pk_film_film_id PRIMARY KEY (film_id),
 --   CONSTRAINT ck_film_rating CHECK (rating IN ('G', 'PG', 'PG-13', 'R', 'NC-17'))

CREATE TABLE employee_department (
employee_id integer NOT NULL,
department_id integer NOT NULL,
CONSTRAINT pk_employee_department_employee_id_department_id PRIMARY KEY(employee_id, department_id)
);

CREATE TABLE employee_project(
employee_id integer NOT NULL,
project_id integer NOT NULL,
CONSTRAINT pk_employee_department_project_id_department_id PRIMARY KEY(employee_id, project_id)
);

-- CONSTRAINT ck_department_size, CHECK(department_size > 0),

CREATE TABLE department (
department_id serial NOT NULL,
name varchar(20) NOT NULL,
department_size integer NOT NULL,
CHECK(department_size >= 0),
CONSTRAINT pk_department_department_id PRIMARY KEY (department_id)
);

CREATE TABLE project (
project_id serial NOT NULL,
project_name varchar(20) NOT NULL,
project_start_date varchar(20) NOT NULL,
project_employees integer NOT NULL,
CHECK(project_employees >=0),
CONSTRAINT pk_project_project_id PRIMARY KEY(project_id)
);

CREATE TABLE job_title (
job_title_id serial NOT NULL,
job_title varchar(20) NOT NULL,
CONSTRAINT pk_job_title_job_title_id PRIMARY KEY (job_title_id)
);




--Populate department
INSERT INTO department (name, department_size) 
VALUES ('logistics', 50);
INSERT INTO department (name, department_size) 
VALUES ('payroll', 20);
INSERT INTO department (name, department_size) 
VALUES ('information_tech', 80);

--Populate projects

INSERT INTO project(project_name,project_start_date, project_employees) 
VALUES ('heartcore', '12/25/2018', 4);
INSERT INTO project(project_name,project_start_date, project_employees) 
VALUES ('the_next_step', '12/1/2010', 10);
INSERT INTO project(project_name,project_start_date, project_employees) 
VALUES ('the_remedy', '12/25/2016', 5);
INSERT INTO project(project_name,project_start_date, project_employees) 
VALUES ('enemies_of_energy', '12/1/1996', 8);

--populate job_title

INSERT INTO job_title(job_title) 
VALUES ('guitarist');
INSERT INTO job_title(job_title) 
VALUES ('percussion');
INSERT INTO job_title(job_title) 
VALUES ('synthesis');
INSERT INTO job_title(job_title) 
VALUES ('bass');
INSERT INTO job_title(job_title) 
VALUES ('manager');
INSERT INTO job_title(job_title) 
VALUES ('composer');

--populate employee
INSERT INTO employee(job_title_id, last_name, first_name, gender, birthday, hire_date, department_id) 
VALUES (1, 'Rosenwinkel', 'Kurt', 'M', '12/4/1971', '12/1/1990', 1);
INSERT INTO employee(job_title_id, last_name, first_name, gender, birthday, hire_date, department_id) 
VALUES (3, 'Rosnes', 'Renee', 'F', '12/4/1968', '12/1/1992', 2);
INSERT INTO employee(job_title_id, last_name, first_name, gender, birthday, hire_date, department_id) 
VALUES (2, 'Ballard', 'Jeff', 'M', '12/4/1966', '12/1/1988', 3);
INSERT INTO employee(job_title_id, last_name, first_name, gender, birthday, hire_date, department_id) 
VALUES (5, 'Turner', 'Mark', 'M', '12/4/1981', '12/1/1995', 1);
INSERT INTO employee(job_title_id, last_name, first_name, gender, birthday, hire_date, department_id) 
VALUES (1, 'Metheny', 'Pat', 'M', '12/4/1955', '12/3/1975', 2);
INSERT INTO employee(job_title_id, last_name, first_name, gender, birthday, hire_date, department_id) 
VALUES (4, 'Oh', 'Linda', 'F', '12/4/1983', '12/1/2001', 3);
INSERT INTO employee(job_title_id, last_name, first_name, gender, birthday, hire_date, department_id) 
VALUES (1, 'Scofield', 'John', 'M', '12/4/1958', '12/1/1977', 2);
INSERT INTO employee(job_title_id, last_name, first_name, gender, birthday, hire_date, department_id) 
VALUES (6, 'SHorter', 'Wayne', 'M', '12/4/1940', '12/1/1966', 1);
INSERT INTO employee(job_title_id, last_name, first_name, gender, birthday, hire_date, department_id) 
VALUES (6, 'Schnieder', 'Maria', 'F', '12/4/1968', '11/1/1993', 2);

--Populate employee department
INSERT INTO employee_department(employee_id, department_id)
VALUES (1, (SELECT department_id FROM employee WHERE employee_id = 1));
INSERT INTO employee_department(employee_id, department_id)
VALUES (2, (SELECT department_id FROM employee WHERE employee_id = 2));
INSERT INTO employee_department(employee_id, department_id)
VALUES (3, (SELECT department_id FROM employee WHERE employee_id = 3));
INSERT INTO employee_department(employee_id, department_id)
VALUES (4, (SELECT department_id FROM employee WHERE employee_id = 4));
INSERT INTO employee_department(employee_id, department_id)
VALUES (5, (SELECT department_id FROM employee WHERE employee_id = 5));
INSERT INTO employee_department(employee_id, department_id)
VALUES (6, (SELECT department_id FROM employee WHERE employee_id = 6));
INSERT INTO employee_department(employee_id, department_id)
VALUES (7, (SELECT department_id FROM employee WHERE employee_id = 7));
INSERT INTO employee_department(employee_id, department_id)
VALUES (8, (SELECT department_id FROM employee WHERE employee_id = 8));
INSERT INTO employee_department(employee_id, department_id)
VALUES (9, (SELECT department_id FROM employee WHERE employee_id = 9));

--Populate employee/project

BEGIN TRANSACTION;
INSERT INTO employee_PROJECT(employee_id, project_id)
VALUES (1, 4);
INSERT INTO employee_PROJECT(employee_id, project_id)
VALUES (2, 3);
INSERT INTO employee_PROJECT(employee_id, project_id)
VALUES (3, 2);
INSERT INTO employee_PROJECT(employee_id, project_id)
VALUES (4, 1);
INSERT INTO employee_PROJECT(employee_id, project_id)
VALUES (5, 4);
INSERT INTO employee_PROJECT(employee_id, project_id)
VALUES (6, 3);
INSERT INTO employee_PROJECT(employee_id, project_id)
VALUES (7, 2);
INSERT INTO employee_PROJECT(employee_id, project_id)
VALUES (8, 1);
INSERT INTO employee_PROJECT(employee_id, project_id)
VALUES (9, 2);
COMMIT;


ALTER TABLE employee
ADD FOREIGN KEY (job_title_id)
REFERENCES job_title(job_title_id);

ALTER TABLE employee_department 
ADD FOREIGN KEY (employee_id)
REFERENCES employee(employee_id);

ALTER TABLE employee_department 
ADD FOREIGN KEY (department_id)
REFERENCES  department(department_id);

ALTER TABLE employee_project
ADD FOREIGN KEY (project_id)
REFERENCES project(project_id);

ALTER TABLE employee_project
ADD FOREIGN KEY (employee_id)
REFERENCES employee(employee_id);
