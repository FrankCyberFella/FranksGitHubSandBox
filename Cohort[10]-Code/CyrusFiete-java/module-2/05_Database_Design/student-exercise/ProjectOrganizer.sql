CREATE TABLE employee (
        employee_id serial NOT NULL,
        job_title varchar(20) NOT NULL,
        last_name varchar(20) NOT NULL,
        first_name varchar(20) NOT NULL,
        gender varchar(20) NOT NULL,
        birthday varchar(20) NOT NULL,
        hire_date varchar(20) NOT NULL,
        department_id integer NOT NULL,
        CONSTRAINT pk_employee_employee_id PRIMARY KEY (employee_id),
        CONSTRAINT fk_employee_department_id FOREIGN KEY (department_id) REFERENCES department (department_id)
);

CREATE TABLE department (
        department_id serial NOT NULL,
        name varchar(20) NOT NULL,
        CONSTRAINT pk_department_department_id PRIMARY KEY (department_id)
);

CREATE TABLE employee_project (
        employee_id integer NOT NULL,
        project_id integer NOT NULL,
        CONSTRAINT pk_employee_project_employee_id_project_id PRIMARY KEY (employee_id, project_id),
        CONSTRAINT fk_employee_project_employee_id FOREIGN KEY (employee_id) REFERENCES employee (employee_id),
        CONSTRAINT fk_employee_project_project_id FOREIGN KEY (project_id) REFERENCES project (project_id)
);

CREATE TABLE project (
        project_id serial NOT NULL,
        name varchar(20) NOT NULL,
        start_date varchar(20) NOT NULL,
        CONSTRAINT pk_project_project_id PRIMARY KEY (project_id)
);

BEGIN TRANSACTION;
INSERT INTO department (name)
VALUES ('JAZZ')
;
COMMIT;

BEGIN TRANSACTION;
INSERT INTO department (name)
VALUES ('ROCKANDROLL')
;
COMMIT;

BEGIN TRANSACTION;
INSERT INTO department (name)
VALUES ('CLASSICAL')
;
COMMIT;

BEGIN TRANSACTION;
INSERT INTO project (name, start_date)
VALUES ('STRINGS', 1961)
;
COMMIT;

BEGIN TRANSACTION;
INSERT INTO project (name, start_date)
VALUES ('PIANO', 1844)
;
COMMIT;

BEGIN TRANSACTION;
INSERT INTO project (name, start_date)
VALUES ('WINDS', 1901)
;
COMMIT;

BEGIN TRANSACTION;
INSERT INTO project (name, start_date)
VALUES ('DRUMS', 1251)
;
COMMIT;

BEGIN TRANSACTION;
INSERT INTO employee (job_title, last_name, first_name, gender, birthday, hire_date, department_id)
VALUES ('MUSICIAN', 'WHO', 'FELIX', 'MALE', '1745', '1777', 2)
;
COMMIT;

BEGIN TRANSACTION;
INSERT INTO employee (job_title, last_name, first_name, gender, birthday, hire_date, department_id)
VALUES ('MUSICIAN', 'WHERE', 'ROSE', 'FEMALE', '1899', '1901', 1)
;
COMMIT;

BEGIN TRANSACTION;
INSERT INTO employee (job_title, last_name, first_name, gender, birthday, hire_date, department_id)
VALUES ('MUSICIAN', 'WHAT', 'VIOLET', 'FEMALE', '1823', '1840', 3)
;
COMMIT;

BEGIN TRANSACTION;
INSERT INTO employee (job_title, last_name, first_name, gender, birthday, hire_date, department_id)
VALUES ('MUSICIAN', 'WHEN', 'IVY', 'FEMALE', '1717', '1737', 3)
;
COMMIT;

BEGIN TRANSACTION;
INSERT INTO employee (job_title, last_name, first_name, gender, birthday, hire_date, department_id)
VALUES ('MUSICIAN', 'WHY', 'ISAAC', 'MALE', '1900', '1918', 1)
;
COMMIT;

BEGIN TRANSACTION;
INSERT INTO employee (job_title, last_name, first_name, gender, birthday, hire_date, department_id)
VALUES ('MUSICIAN', 'HOW', 'IVAN', 'MALE', '1679', '1699', 3)
;
COMMIT;

BEGIN TRANSACTION;
INSERT INTO employee (job_title, last_name, first_name, gender, birthday, hire_date, department_id)
VALUES ('MUSICIAN', 'HMM', 'LILY', 'FEMALE', '1899', '1922', 2)
;
COMMIT;

BEGIN TRANSACTION;
INSERT INTO employee (job_title, last_name, first_name, gender, birthday, hire_date, department_id)
VALUES ('MUSICIAN', 'WELL', 'VERONICA', 'FEMALE', '1444', '1610', 1)
;
COMMIT;

BEGIN TRANSACTION;
INSERT INTO employee_project (employee_id, project_id)
VALUES (5, 1)
;
COMMIT;

BEGIN TRANSACTION;
INSERT INTO employee_project (employee_id, project_id)
VALUES (8, 4)
;
COMMIT;

BEGIN TRANSACTION;
INSERT INTO employee_project (employee_id, project_id)
VALUES (1, 2)
;
COMMIT;

BEGIN TRANSACTION;
INSERT INTO employee_project (employee_id, project_id)
VALUES (3, 3)
;
COMMIT;

--DROP TABLE IF EXISTS department;
