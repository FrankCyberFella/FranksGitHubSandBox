DROP TABLE IF EXISTS department       cascade;
DROP TABLE IF EXISTS employee         cascade;
DROP TABLE IF EXISTS project          cascade;
DROP TABLE IF EXISTS project_employee cascade;


CREATE TABLE employee (
        employee_id serial NOT NULL,
        job_title varchar(30) NOT NULL,
        first_name varchar(30) NOT NULL,
        last_name varchar(30) NOT NULL,
        gender varchar(1) NOT NULL,
        birthday varchar(10) NOT NULL,
        hire_date varchar(10) NOT NULL,
        department_id serial NOT NULL,
        CONSTRAINT pk_employee_employee_id PRIMARY KEY (employee_id)
        );
        
CREATE TABLE department (
        department_id serial NOT NULL,
        department_name varchar(50) NOT NULL,
        CONSTRAINT pk_department_department_id PRIMARY KEY (department_id)
        );
        
CREATE TABLE project (
        project_name varchar(70) NOT NULL,
        start_date varchar(10) NOT NULL,
        project_id serial NOT NULL,
        CONSTRAINT pk_project_project_id PRIMARY KEY (project_id)
        );
        
CREATE TABLE project_employee (
        employee_id serial NOT NULL,
        project_id serial NOT NULL,
        CONSTRAINT pk_project_employee PRIMARY KEY (employee_id, project_id)
        );
         
ALTER TABLE project_employee
ADD FOREIGN KEY (project_id)
REFERENCES  project(project_id);

ALTER TABLE project_employee
ADD FOREIGN KEY (employee_id)
REFERENCES  employee(employee_id);

ALTER TABLE employee
ADD FOREIGN KEY (department_id)
REFERENCES  department(department_id);

INSERT INTO department
(department_name)
VALUES('Project Management')
;

INSERT INTO department
(department_name)
VALUES('Software Development')
;

INSERT INTO department
(department_name)
VALUES('Sound Technician Office')
;

INSERT INTO department
(department_name)
VALUES('Morale Office')
;



INSERT INTO employee
(job_title, first_name, last_name, gender, birthday, hire_date, department_id)
VALUES('Project Manager', 'Rick', 'James', 'M', '02/01/1948', '01/01/2017', 1)
;

INSERT INTO employee
(job_title, first_name, last_name, gender, birthday, hire_date, department_id)
VALUES('Senior Software Developer', 'Steve', 'Jobs', 'M', '02/24/1955', '01/04/2017', 6)
;

INSERT INTO employee
(job_title, first_name, last_name, gender, birthday, hire_date, department_id)
VALUES('Lead Sound Technician', 'Tim', 'Bergling', 'M', '09/08/1989', '02/11/2017', 7)
;

INSERT INTO employee
(job_title, first_name, last_name, gender, birthday, hire_date, department_id)
VALUES('Assistant Sound Technician', 'Whitney', 'Houston', 'F', '08/09/1963', '07/19/2017', 7)
;

INSERT INTO employee
(job_title, first_name, last_name, gender, birthday, hire_date, department_id)
VALUES('Senior Project Manager', 'Grace', 'Hopper', 'F', '12/09/1906', '04/14/2017', 1)
;

INSERT INTO employee
(job_title, first_name, last_name, gender, birthday, hire_date, department_id)
VALUES('Lead Software Developer', 'Margaret', 'Hamilton', 'F', '08/17/1936', '01/29/2017', 6)
;

INSERT INTO employee
(job_title, first_name, last_name, gender, birthday, hire_date, department_id)
VALUES('Lead Morale Officer', 'Steve', 'Irwin', 'M', '02/22/1962', '01/01/2017', 8)
;
        
INSERT INTO employee
(job_title, first_name, last_name, gender, birthday, hire_date, department_id)
VALUES('Secondary Morale Officer', 'Carrie', 'Fisher', 'F', '10/21/1956', '05/04/2017', 8)
;

INSERT INTO project
(project_name, start_date)
VALUES('Alligator Chomp Game', '03/07/18')
;

INSERT INTO project
(project_name, start_date)
VALUES('Dance Music Creator', '07/04/18')
;

INSERT INTO project
(project_name, start_date)
VALUES('Astronaut Checklist', '03/07/18')
;

INSERT INTO project
(project_name, start_date)
VALUES('StarWars Fan Tracker', '03/07/18')
;

INSERT INTO project_employee
(employee_id, project_id)
VALUES(8, 1)
;

INSERT INTO project_employee
(employee_id, project_id)
VALUES(9, 1)
;
              
INSERT INTO project_employee
(employee_id, project_id)
VALUES(4, 2)
;

INSERT INTO project_employee
(employee_id, project_id)
VALUES(3, 2)
;

INSERT INTO project_employee
(employee_id, project_id)
VALUES(7, 3)
;

INSERT INTO project_employee
(employee_id, project_id)
VALUES(2, 3)
;

INSERT INTO project_employee
(employee_id, project_id)
VALUES(10, 4)
;

INSERT INTO project_employee
(employee_id, project_id)
VALUES(6, 4)
;


        