DROP TABLE IF EXISTS employee           cascade;
DROP TABLE IF EXISTS department         cascade;
DROP TABLE IF EXISTS project            cascade;
DROP TABLE IF EXISTS department_employee        cascade;
DROP TABLE IF EXISTS employee_project   cascade;

CREATE TABLE employee (
        number integer NOT NULL,
        first_name varchar(64) NOT NULL,
        last_name varchar(64) NOT NULL,
        gender varchar(16)  NOT NULL,
        birthday DATE,
        hire_date DATE,
        CONSTRAINT pk_employee_number PRIMARY KEY (number),
        CONSTRAINT pk_employee_gender CHECK (gender IN ('Male','Female','Other'))
        );
        
CREATE TABLE department (
        number integer NOT NULL,
        name varchar(64) NOT NULL,
        CONSTRAINT pk_department_number PRIMARY KEY (number)
        );
        
CREATE TABLE project ( 
        number integer NOT NULL,
        name varchar(64) NOT NULL,
        start_date DATE NOT NULL,
        CONSTRAINT pk_project_number PRIMARY KEY (number)
        );
      
--Deciding this is a many-to-many relationship as one employee can transfer between departments, and a history is worth keeping      
CREATE TABLE department_employee (
        department_number integer NOT NULL,
        employee_number integer NOT NULL,
        start_date DATE NOT NULL,
        end_date DATE,
        CONSTRAINT pk_department_employee_department_number_employee_number PRIMARY KEY (department_number,employee_number)
        );
--Deciding this is a many-to-many relationship as one employee will have many projects over time, and a history is worth keeping        
CREATE TABLE employee_project (
        employee_number integer NOT NULL,
        project_number integer NOT NULL,
        start_date DATE NOT NULL,
        end_date DATE,
        CONSTRAINT pk_employee_project_employee_number_project_number PRIMARY KEY (employee_number,project_number)
        );
        
ALTER TABLE department_employee 
ADD FOREIGN KEY (department_number)
REFERENCES department(number);

ALTER TABLE department_employee
ADD FOREIGN KEY (employee_number)
REFERENCES employee(number);

ALTER TABLE department_employee
ADD CONSTRAINT pk_end_date_after_start_date CHECK (end_date>start_date);

ALTER TABLE employee_project
ADD FOREIGN KEY (employee_number)
REFERENCES employee(number);

ALTER TABLE employee_project
ADD FOREIGN KEY (project_number)
REFERENCES project(number);

INSERT INTO employee (number,first_name,last_name,gender,birthday,hire_date) VALUES (1,'Adam','Zillow','Male','01/01/1990'::date,'01/01/2016'::date);
INSERT INTO employee (number,first_name,last_name,gender,birthday,hire_date) VALUES (2,'Beverly','Yarde','Female','1989/02/02'::date,'2014/01/15'::date);
INSERT INTO employee (number,first_name,last_name,gender,birthday,hire_date) VALUES (3,'Charles','Xavier','Other','03/20/1965'::date,'01/01/2015'::date);
INSERT INTO employee (number,first_name,last_name,gender,birthday,hire_date) VALUES (4,'Danae','Willburn','Female','04/30/1972'::date,'01/01/2015'::date);
INSERT INTO employee (number,first_name,last_name,gender,birthday,hire_date) VALUES (5,'Evan','Venice','Male','01/01/1990'::date,'01/01/2015'::date);
INSERT INTO employee (number,first_name,last_name,gender,birthday,hire_date) VALUES (6,'Francine','Umbridge','Other','01/01/1990'::date,'01/01/2013'::date);
INSERT INTO employee (number,first_name,last_name,gender,birthday,hire_date) VALUES (7,'Georg','Tallow','Male','01/01/1990'::date,'01/01/2014'::date);
INSERT INTO employee (number,first_name,last_name,gender,birthday,hire_date) VALUES (8,'Hannah','Stewart','Female','01/01/1990'::date,'01/01/2015'::date);

INSERT INTO department (number,name) VALUES (1,'Sales');
INSERT INTO department (number,name) VALUES (2,'Accounting');
INSERT INTO department (number,name) VALUES (3,'Operations');

INSERT INTO project (number,name,start_date) VALUES (1,'Time Study','2019/01/12');
INSERT INTO project (number,name,start_date) VALUES (2,'Motion Study','2019/01/12');
INSERT INTO project (number,name,start_date) VALUES (3,'Safety Initiative','2015/06/15');
INSERT INTO project (number,name,start_date) VALUES (4,'Employee Morale','2019/01/12');

INSERT INTO department_employee (department_number,employee_number,start_date,end_date) VALUES (3,1,'2016/01/01',null);
INSERT INTO department_employee (department_number,employee_number,start_date,end_date) VALUES (3,2,'2014/01/15',null);
INSERT INTO department_employee (department_number,employee_number,start_date,end_date) VALUES (3,3,'2015/01/01',null);
INSERT INTO department_employee (department_number,employee_number,start_date,end_date) VALUES (3,4,'2015/01/01',null);
INSERT INTO department_employee (department_number,employee_number,start_date,end_date) VALUES (3,5,'2015/01/01',null);
INSERT INTO department_employee (department_number,employee_number,start_date,end_date) VALUES (3,6,'2013/01/01',null);
INSERT INTO department_employee (department_number,employee_number,start_date,end_date) VALUES (1,7,'2014/01/01',null);
INSERT INTO department_employee (department_number,employee_number,start_date,end_date) VALUES (2,8,'2015/01/01',null);

INSERT INTO employee_project (employee_number,project_number,start_date,end_date) VALUES (1,1,'2019/01/12','2019/01/13');
INSERT INTO employee_project (employee_number,project_number,start_date,end_date) VALUES (7,2,'2019/01/12','2019/01/13');
INSERT INTO employee_project (employee_number,project_number,start_date,end_date) VALUES (6,3,'2016/05/20',null);
INSERT INTO employee_project (employee_number,project_number,start_date,end_date) VALUES (8,4,'2019/01/12','2019/01/13');
