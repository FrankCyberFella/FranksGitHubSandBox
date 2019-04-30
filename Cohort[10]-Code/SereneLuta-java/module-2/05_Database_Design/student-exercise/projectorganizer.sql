-- invoice table was created accidentally due to mouse user error

DROP TABLE IF EXISTS department                     cascade;
DROP TABLE IF EXISTS employee                       cascade;
DROP TABLE IF EXISTS poject                         cascade;
DROP TABLE IF EXISTS employee_project               cascade;


CREATE TABLE project (
    project_id serial NOT NULL,
    name varchar(100),
    start_date date NOT NULL,
    CONSTRAINT pk_project_project_id PRIMARY KEY (project_id)
);

CREATE TABLE department (
    dept_id integer NOT NULL,
    name varchar(100) NOT NULL,
    CONSTRAINT pk_department_dept_id PRIMARY KEY (dept_id)
);

CREATE TABLE employee (
    employee_id serial NOT NULL,
    job_title varchar(100) NOT NULL,
    last_name varchar(30) NOT NULL,
    first_name varchar(30) NOT NULL,
    gender varchar(6) NOT NULL,
    birhtday date NOT NULL,
    hiredate date NOT NULL,
    working_dept varchar(30) DEFAULT 'NEW HIRE', -- defaults to 'new hire', employee is in training :)
    dept_id integer, -- will assign dept id after training
    CONSTRAINT chk_employee_gender CHECK (gender IN ('female', 'male')),
    CONSTRAINT pk_employee_employee_id PRIMARY KEY (employee_id)
);

CREATE TABLE employee_project (
    employee_id integer NOT NULL,
    project_id integer NOT NULL,
    CONSTRAINT pk_employeep_project_employee_id PRIMARY KEY (employee_id),
    CONSTRAINT fk_employee_project_to_employee FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
    CONSTRAINT fk_employee_project_to_project FOREIGN KEY (project_id) REFERENCES project(project_id)
);


ALTER TABLE employee
ADD FOREIGN KEY (dept_id) REFERENCES department(dept_id);

--ALTER TABLE employee_project
--ADD FOREIGN KEY (employee_id) REFERENCES employee(employee_id);

--ALTER TABLE employee_project
--ADD FOREIGN KEY (project_id) REFERENCES project(project_id);


COMMIT;

DROP TABLE employee_project;
DROP TABLE project;
DROP TABLE department;
DROP TABLE employee;

BEGIN TRANSACTION;

INSERT INTO department VALUES (1, 'executive');
INSERT INTO department VALUES (2, 'management');
INSERT INTO department VALUES (3, 'sales');
INSERT INTO department VALUES (4, 'technology');

INSERT INTO employee VALUES (DEFAULT, 'President', 'Jones', 'Sarah', 'female', '1985-07-7', '2015-06-18', 'executive', 1);
INSERT INTO employee VALUES (DEFAULT, 'Chief Executive Officer', 'Schmo', 'Joe', 'male', '1975-11-19', '1995-01-01', 'executive', 1);
INSERT INTO employee VALUES (DEFAULT, 'Chief Financial Officer', 'Smith', 'John', 'male', '1965-09-05', '2001-05-27', 'executive', 1);
INSERT INTO employee VALUES (DEFAULT, 'Manager', 'Kelly', 'Mike', 'male', '1995-02-21', '2015-03-15', 'management', 2);
INSERT INTO employee VALUES (DEFAULT, 'Customer Service Representative', 'Watson', 'Noel', 'female', '2000-09-30', '2016-02-15', 'sales', 3);
INSERT INTO employee VALUES (DEFAULT, 'Customer Service Representative', 'Tipton', 'Micah', 'male', '2000-10-31', '2016-04-21', 'sales', 3);
INSERT INTO employee VALUES (DEFAULT, 'Information Technology Specialist', 'Miller', 'Jamica', 'female', '1997-11-30', '2017-04-28', 'technology', 4);
INSERT INTO employee VALUES (DEFAULT, 'Information Technology Specialist', 'Mahmah', 'Joe', 'male', '1982-12-25', '2013-03-01', 'technology', 4);

INSERT INTO project VALUES (DEFAULT, 'How To Work Harder And Not Smarter', '2018-06-18');
INSERT INTO project VALUES (DEFAULT, 'How To Increase Production By Adding More Red Tape', '1995-01-01');
INSERT INTO project VALUES (DEFAULT, 'How To Pass The Blame And Look Good Doing It', '2001-05-27');
INSERT INTO project VALUES (DEFAULT, 'The 100 Year Project That Never Gets Done', '2015-03-15');

--INSERT INTO employee_project VALUES (1, 3);
--INSERT INTO employee_project VALUES (2, 4);
--INSERT INTO employee_project VALUES (3, 1);
--INSERT INTO employee_project VALUES (4, 2);




COMMIT;




