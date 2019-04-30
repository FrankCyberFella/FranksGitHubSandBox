DROP TABLE IF EXISTS   employee                 cascade; 
DROP TABLE IF EXISTS   dept                     cascade; 
DROP TABLE IF EXISTS   project                  cascade; 
DROP TABLE IF EXISTS   project_employee         cascade; 

CREATE TABLE employee (
        employee_id serial NOT NULL,
        first_name varchar (25) NOT NULL,
        last_name varchar (30) NOT NULL,
        job_title varchar (40) NOT NULL,
        gender varchar (10),
        dob date NOT NULL,
        hire_date date NOT NULL,
        dept_id int NOT NULL,
        CONSTRAINT pk_employee_employee_id PRIMARY KEY (employee_id));
        

CREATE TABLE dept (
        dept_id serial NOT NULL,
        dept_name varchar (25) NOT NULL,
     
        CONSTRAINT pk_department_dept_id PRIMARY KEY (dept_id));


CREATE TABLE project (
        project_id serial NOT NULL,
        project_name varchar (45),
        start_date date NOT NULL,
        CONSTRAINT pk_project_project_id PRIMARY KEY (project_id));
        
        
CREATE TABLE project_employee (
        project_id int NOT NULL,
        employee_id int NOT NULL,
        CONSTRAINT pk_project_employee_project_id_employee_id PRIMARY KEY (project_id, employee_id)); 
      
        
ALTER TABLE employee
ADD FOREIGN KEY (dept_id)
REFERENCES dept (dept_id);

ALTER TABLE project_employee
ADD FOREIGN KEY (employee_id)
REFERENCES employee (employee_id);

ALTER TABLE project_employee
ADD FOREIGN KEY (project_id)
REFERENCES project (project_id);

INSERT INTO dept (dept_name) VAlUES ( 'Admin');
INSERT INTO dept (dept_name) VAlUES ( 'IT');
INSERT INTO dept (dept_name) VAlUES ( 'Sales');

INSERT INTO employee ( first_name, last_name, job_title, gender, dob, hire_date, dept_id) VALUES ('Sonny', 'Freeman', 'Admin', 'male', '03/21/1937', '09/08/1967', (SELECT dept_id from dept WHERE dept_name = 'Admin'));
INSERT INTO employee ( first_name, last_name, job_title, gender, dob, hire_date, dept_id) VALUES ( 'Shemp', 'Howard', 'IT', 'male', '08/30/1911', '09/12/1945', (SELECT dept_id from dept WHERE dept_name = 'IT'));
INSERT INTO employee ( first_name, last_name, job_title, gender, dob, hire_date, dept_id) VALUES ( 'Lucy', 'Morningdove', 'Admin', 'female', '06/02/1983', '11/28/2001', (SELECT dept_id from dept WHERE dept_name = 'Admin'));
INSERT INTO employee ( first_name, last_name, job_title, gender, dob, hire_date, dept_id) VALUES ( 'Roger', 'Stoneman', 'Sales', 'male', '05/12/1973', '02/16/1999', (SELECT dept_id from dept WHERE dept_name = 'Sales'));
INSERT INTO employee ( first_name, last_name, job_title, gender, dob, hire_date, dept_id) VALUES ( 'Carlton', 'Esterhazy', 'IT', 'male', '07/20/1960', '01/30/2011', (SELECT dept_id from dept WHERE dept_name = 'IT'));
INSERT INTO employee ( first_name, last_name, job_title, gender, dob, hire_date, dept_id) VALUES ( 'George ', 'Smiley', 'IT', 'male', '12/06/1917', '09/24/1953', (SELECT dept_id from dept WHERE dept_name = 'IT'));
INSERT INTO employee ( first_name, last_name, job_title, gender, dob, hire_date, dept_id) VALUES ( 'Bruno', 'Sammartino','Sales', 'male', '02/04/1949', '04/22/1968', (SELECT dept_id from dept WHERE dept_name = 'Sales'));
INSERT INTO employee ( first_name, last_name, job_title, gender, dob, hire_date, dept_id) VALUES ( 'Earl', 'Hooker', 'Admin', 'male', '03/29/1940', '01/13/1962', (SELECT dept_id from dept WHERE dept_name = 'Admin'));

SELECT setval(pg_get_serial_sequence( 'employee', 'employee_id'), 2);


SELECT setval(pg_get_serial_sequence ('dept', 'dept_id'), 3);

INSERT INTO project ( project_name, start_date) VALUES ( 'Denim Factory', '07/05/2018');
INSERT INTO project ( project_name, start_date) VALUES ( 'Large Rock Busting', '06/16/2000');
INSERT INTO project ( project_name, start_date) VALUES ( 'SubOptimal Web Integration', '08/30/1944');
INSERT INTO project ( project_name, start_date) VALUES ( 'Airport Surveillance Snacks', '12/15/1977');

SELECT setval(pg_get_serial_sequence( 'project', 'project_id'), 2);

