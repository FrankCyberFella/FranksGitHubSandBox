drop table if exists employee           cascade;
drop table if exists department           cascade;
drop table if exists project              cascade;
drop table if exists employee_project     cascade;
drop table if exists employee_department     cascade;

CREATE TABLE employee(
employee_id serial NOT NULL,
job_title varchar(50) NOT NULL,
last_name varchar(50) NOT NULL,
first_name varchar(50) NOT NULL,
gender varchar(50) NOT NULL,
birthday varchar(50) NOT NULL,
hire_date varchar(50) NOT NULL,
department_id integer NOT NULL,
CONSTRAINT pk_employee_employee_id PRIMARY KEY (employee_id)
);

CREATE TABLE department(
department_id serial NOT NULL,
department_name varchar(50)NOT NULL,
department_employees integer NOT NULL,
CONSTRAINT pk_department_department_id PRIMARY KEY (department_id)
);

CREATE TABLE project(
project_id serial NOT NULL,
project_name varchar(50)NOT NULL,
start_date varchar(50) NOT NULL,
CONSTRAINT pk_project_project_id PRIMARY KEY (project_id)
);

CREATE TABLE employee_project(
project_id integer NOT NULL,
employee_id integer NOT NULL,
CONSTRAINT pk_employee_project_project_id_employee_id PRIMARY KEY (project_id, employee_id)
);


ALTER TABLE employee_project
ADD FOREIGN KEY (employee_id)
REFERENCES employee(employee_id);

ALTER TABLE employee_project
ADD FOREIGN KEY (project_id)
REFERENCES project(project_id);


ALTER TABLE employee
ADD FOREIGN KEY (department_id)
REFERENCES department(department_id);


INSERT INTO department(department_id, department_name, department_employees)
values(1, 'Accounting', 14);
INSERT INTO department(department_id, department_name, department_employees)
values(2, 'IT', 56);
INSERT INTO department(department_id, department_name, department_employees)
values(3, 'R&D', 20);
SELECT * FROM department;

INSERT INTO project(project_id, project_name, start_date)
VALUES (1, 'Toaster Oven', 'SEP 24/2019');
INSERT INTO project(project_id, project_name, start_date)
VALUES (2, 'Vending Machine', 'JUN 9/2019');
INSERT INTO project(project_id, project_name, start_date)
VALUES (3, 'FOUNTAIN', 'AUG 30/2019');
INSERT INTO project(project_id, project_name, start_date)
VALUES (4, 'Pager', 'MAY 03/2019');
SELECT * FROM project;

INSERT INTO employee(employee_id, job_title, last_name, first_name, gender, birthday, hire_date, department_id)
VALUES              (1          ,'Auditor' , 'James'  , 'Jim'     , 'M'   , 'JAN 1/1992', 'JAN 2/2011', 1);
INSERT INTO employee(employee_id, job_title, last_name, first_name, gender, birthday, hire_date, department_id)
VALUES              (2          ,'Counter' , 'Cavatelli'  , 'Linda' ,'F'   ,'APR 3/1990', 'FEB 9/2017', 1);
INSERT INTO employee(employee_id, job_title, last_name, first_name, gender, birthday, hire_date, department_id)
VALUES              (3          ,'Analyst' , 'Davidson'  , 'Bill'     , 'M'   , 'MAR 8/1980', 'JAN 2/2017', 3);
INSERT INTO employee(employee_id, job_title, last_name, first_name, gender, birthday, hire_date, department_id)
VALUES              (4          ,'Project Manager' , 'Jones'  , 'Grace'     , 'N'   , 'DEC 9/1994', 'DEC 2/2009', 2);
INSERT INTO employee(employee_id, job_title, last_name, first_name, gender, birthday, hire_date, department_id)
VALUES              (5          ,'Manager' , 'Yasukochi'  , 'Kara'     , 'F'   , 'APR 9/1990', 'NOV 9/2015', 1);
INSERT INTO employee(employee_id, job_title, last_name, first_name, gender, birthday, hire_date, department_id)
VALUES              (6          ,'Counter' , 'Dosik'  , 'Beverly'     , 'F'   , 'OCT 22/1974', 'JAN 19/2010', 1);
INSERT INTO employee(employee_id, job_title, last_name, first_name, gender, birthday, hire_date, department_id)
VALUES              (7          ,'Developer' , 'Lewandowski'  , 'Jeff'     , 'M'   , 'SEP 9/1977', 'JAN 5/2018', 2);
INSERT INTO employee(employee_id, job_title, last_name, first_name, gender, birthday, hire_date, department_id)
VALUES              (8          ,'Thinker' , 'Nielsen'  , 'Ruben'     , 'M'   , 'JAN 1/1987', 'MAR 14/2011', 3);
INSERT INTO employee(employee_id, job_title, last_name, first_name, gender, birthday, hire_date, department_id)
VALUES              (9          ,'Developer' , 'Davis'  , 'Mary'     , 'F'   , 'MAY 29/1994', 'FEB 22/2018', 2);

SELECT * FROM employee;


INSERT INTO employee_project(project_id, employee_id)
VALUES(1, 3);
INSERT INTO employee_project(project_id, employee_id)
VALUES(1, 6);
INSERT INTO employee_project(project_id, employee_id)
VALUES(2, 3);
INSERT INTO employee_project(project_id, employee_id)
VALUES(3, 4);
INSERT INTO employee_project(project_id, employee_id)
VALUES(4, 5);

SELECT * FROM employee_project;

SELECT project.project_id, count(*) AS total
FROM employee_project
JOIN project
ON project.project_id = employee_project.project_id
JOIN employee
ON employee.employee_id = employee_project.employee_id
GROUP BY project.project_id
ORDER BY total;