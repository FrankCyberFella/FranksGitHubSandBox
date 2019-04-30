BEGIN TRANSACTION;

DROP TABLE IF EXISTS employee                     CASCADE;
DROP TABLE IF EXISTS departments                   CASCADE;
DROP TABLE IF EXISTS project                     CASCADE;
DROP TABLE IF EXISTS department_projects          CASCADE;

CREATE TABLE departments (
    department_id SERIAL NOT NULL,
    name varchar(64) NOT NULL,
    total_employees integer DEFAULT 0 NOT NULL,
    CONSTRAINT pk_department_id PRIMARY KEY (department_id)
);

CREATE TABLE employee (
    employee_id SERIAL NOT NULL,
    job_title varchar(64) NOT NULL,
    first_name varchar(64) NOT NULL,
    last_name varchar(64) NOT NULL,
    gender varchar(6) NOT NULL,
    birthday date NOT NULL,
    hire_date date NOT NULL,
    department_id integer, 
    CONSTRAINT pk_employee_id PRIMARY KEY (employee_id),
    CONSTRAINT employee_gender_check CHECK ((gender = 'Male') OR (gender = 'Female'))
);

CREATE TABLE project (
    project_id SERIAL NOT NULL,
    name varchar(64) NOT NULL,
    start_date date NOT NULL,
    employees_assigned integer DEFAULT 0 NOT NULL,
    CONSTRAINT pk_project_id PRIMARY KEY (project_id)
);

CREATE TABLE employee_projects (
    id SERIAL NOT NULL,
    employee_id integer NOT NULL,
    project_id integer NOT NULL,
    CONSTRAINT pk_employee_project_id PRIMARY KEY (employee_id, project_id)
);

INSERT INTO departments (name) VALUES ('Sales');
INSERT INTO departments (name) VALUES ('Accounting');
INSERT INTO departments (name) VALUES ('Shipping');

INSERT INTO employee (job_title, first_name, last_name, gender, birthday, hire_date, department_id) VALUES('Sales Manager','Brett', 'Jensen', 'Male', to_date('19910124','YYYYMMDD'), to_date('20150105','YYYYMMDD'), (SELECT department_id FROM departments WHERE name = 'Sales'));
INSERT INTO employee (job_title, first_name, last_name, gender, birthday, hire_date, department_id) VALUES('Sales Associate','Marquis', 'Harrell', 'Male', to_date('19900905','YYYYMMDD'), to_date('20140413','YYYYMMDD'), (SELECT department_id FROM departments WHERE name = 'Sales'));
INSERT INTO employee (job_title, first_name, last_name, gender, birthday, hire_date, department_id) VALUES('Sales Associate','Rachael', 'Tovtin', 'Female', to_date('19920421','YYYYMMDD'), to_date('20160825','YYYYMMDD'), (SELECT department_id FROM departments WHERE name = 'Sales'));
INSERT INTO employee (job_title, first_name, last_name, gender, birthday, hire_date, department_id) VALUES('Account Manager','Kyle', 'Schafer', 'Male', to_date('19880505','YYYYMMDD'), to_date('20150105','YYYYMMDD'), (SELECT department_id FROM departments WHERE name = 'Accounting'));
INSERT INTO employee (job_title, first_name, last_name, gender, birthday, hire_date, department_id) VALUES('Account Manager','Taryn', 'Lehmann', 'Female', to_date('19900831','YYYYMMDD'), to_date('20110105','YYYYMMDD'), (SELECT department_id FROM departments WHERE name = 'Accounting'));
INSERT INTO employee (job_title, first_name, last_name, gender, birthday, hire_date, department_id) VALUES('Shipping Supervisor','Garrett', 'Gronowski', 'Male', to_date('19900902','YYYYMMDD'), to_date('20100618','YYYYMMDD'), (SELECT department_id FROM departments WHERE name = 'Shipping'));
INSERT INTO employee (job_title, first_name, last_name, gender, birthday, hire_date, department_id) VALUES('Shipping Associate','Chris', 'Jensen', 'Male', to_date('19881230','YYYYMMDD'), to_date('20090211','YYYYMMDD'), (SELECT department_id FROM departments WHERE name = 'Shipping'));
INSERT INTO employee (job_title, first_name, last_name, gender, birthday, hire_date, department_id) VALUES('Shipping Associate','Jasmine', 'Frye', 'Female', to_date('19920617','YYYYMMDD'), to_date('20150211','YYYYMMDD'), (SELECT department_id FROM departments WHERE name = 'Shipping'));

INSERT INTO project (name, start_date) VALUES('Everlast', '20181102');
INSERT INTO project (name, start_date) VALUES('Aerotek', '20180522');
INSERT INTO project (name, start_date) VALUES('PolyOne', '20190105');
INSERT INTO project (name, start_date) VALUES('Chemtron', '20181010');

INSERT INTO employee_projects(employee_id, project_id) VALUES(1,2);
INSERT INTO employee_projects(employee_id, project_id) VALUES(3,2);
INSERT INTO employee_projects(employee_id, project_id) VALUES(6,1);
INSERT INTO employee_projects(employee_id, project_id) VALUES(7,3);
INSERT INTO employee_projects(employee_id, project_id) VALUES(8,3);
INSERT INTO employee_projects(employee_id, project_id) VALUES(2,1);
INSERT INTO employee_projects(employee_id, project_id) VALUES(5,1);
INSERT INTO employee_projects(employee_id, project_id) VALUES(4,4);

commit;
