DROP TABLE IF EXISTS employee   CASCADE;
DROP TABLE IF EXISTS employee_title   CASCADE;
DROP TABLE IF EXISTS job_title   CASCADE;
DROP TABLE IF EXISTS department   CASCADE;
DROP TABLE IF EXISTS employee_department   CASCADE;
DROP TABLE IF EXISTS project   CASCADE;
DROP TABLE IF EXISTS employee_project   CASCADE;

CREATE TABLE employee (
        employee_id SERIAL NOT NULL,
        job_title VARCHAR(40) NOT NULL,
        last_name VARCHAR(40) NOT NULL,
        first_name VARCHAR(40) NOT NULL,
        gender VARCHAR(1) DEFAULT 'M' NOT NULL,
        birthday DATE DEFAULT CURRENT_DATE NOT NULL,
        hiredate DATE DEFAULT CURRENT_DATE NOT NULL,
        department INTEGER NOT NULL,
        CONSTRAINT ck_employee_gender CHECK (gender IN ('M', 'F')),
        CONSTRAINT pk_employee_employee_id PRIMARY KEY (employee_id)
);

CREATE TABLE department (
        department_id SERIAL NOT NULL,
        name VARCHAR(40) NOT NULL,
        CONSTRAINT pk_department_department_id PRIMARY KEY (department_id)    
);

CREATE TABLE project (
        project_id SERIAL NOT NULL,
        name VARCHAR(40) NOT NULL,
        start_date DATE DEFAULT CURRENT_DATE NOT NULL,
        CONSTRAINT pk_project_project_id PRIMARY KEY (project_id)
);

CREATE TABLE job_title (
        job_id SERIAL NOT NULL,
        name VARCHAR(40) DEFAULT 'Worker' NOT NULL,
        CONSTRAINT ck_job_title_name UNIQUE (name),
        CONSTRAINT pk_job_title_job_id PRIMARY KEY (job_id)
);
        
CREATE TABLE employee_title (
        job_id INTEGER NOT NULL,
        employee_id INTEGER NOT NULL,
        CONSTRAINT pk_employee_title_job_id_employee_id PRIMARY KEY (job_id, employee_id)
);      

CREATE TABLE employee_project (
        employee_id INTEGER NOT NULL,
        project_id INTEGER NOT NULL,
        CONSTRAINT pk_employee_project_employee_id_project_id PRIMARY KEY (employee_id, project_id)
);

INSERT INTO job_title
(name)
VALUES ('Software Developer I');

INSERT INTO job_title
(name)
VALUES ('Software Developer II');

INSERT INTO job_title
(name)
VALUES ('QA I');

INSERT INTO job_title
(name)
VALUES ('QA II');

INSERT INTO department
(name)
VALUES ('Development');

INSERT INTO department
(name)
VALUES ('Testing');

INSERT INTO department
(name)
VALUES ('Research');

INSERT INTO project
(name)
VALUES ('Government Contract');

INSERT INTO project
(name)
VALUES ('Mass Gathering of Personal Customer Data');

INSERT INTO project
(name)
VALUES ('World Domination');

INSERT INTO project
(name)
VALUES ('Charity Project');

INSERT INTO employee
(job_title, last_name, first_name, gender, department)
VALUES ((SELECT name FROM job_title WHERE job_id = 7), 'Johnson', 'Bob', 'M', (SELECT department_id FROM department WHERE department_id = 4));

INSERT INTO employee
(job_title, last_name, first_name, gender, department)
VALUES ((SELECT name FROM job_title WHERE job_id = 8), 'Johnson', 'Jane', 'F', (SELECT department_id FROM department WHERE department_id = 5));

INSERT INTO employee
(job_title, last_name, first_name, gender, department)
VALUES ((SELECT name FROM job_title WHERE job_id = 9), 'Johnson', 'John', 'M', (SELECT department_id FROM department WHERE department_id = 6));

INSERT INTO employee
(job_title, last_name, first_name, gender, department)
VALUES ((SELECT name FROM job_title WHERE job_id = 7), 'Davidson', 'David', 'M', (SELECT department_id FROM department WHERE department_id = 4));

INSERT INTO employee
(job_title, last_name, first_name, gender, department)
VALUES ((SELECT name FROM job_title WHERE job_id = 8), 'Smithson', 'Smithy', 'M', (SELECT department_id FROM department WHERE department_id = 5));

INSERT INTO employee
(job_title, last_name, first_name, gender, department)
VALUES ((SELECT name FROM job_title WHERE job_id = 10), 'Fella', 'Frank', 'M', (SELECT department_id FROM department WHERE department_id = 6));

INSERT INTO employee
(job_title, last_name, first_name, gender, department)
VALUES ((SELECT name FROM job_title WHERE job_id = 8), 'Mayfield', 'Baker', 'M', (SELECT department_id FROM department WHERE department_id = 5));

INSERT INTO employee
(job_title, last_name, first_name, gender, department)
VALUES ((SELECT name FROM job_title WHERE job_id = 10), 'Kitchens', 'Freddie', 'M', (SELECT department_id FROM department WHERE department_id = 6));

ALTER TABLE employee_title
ADD FOREIGN KEY (job_id)
REFERENCES job_title(job_id);

ALTER TABLE employee_title
ADD FOREIGN KEY (employee_id)
REFERENCES employee(employee_id);

ALTER TABLE employee_project
ADD FOREIGN KEY (project_id)
REFERENCES project(project_id);

ALTER TABLE employee_project
ADD FOREIGN KEY (employee_id)
REFERENCES employee(employee_id);

ALTER TABLE employee
ADD FOREIGN KEY (department)
REFERENCES department(department_id);