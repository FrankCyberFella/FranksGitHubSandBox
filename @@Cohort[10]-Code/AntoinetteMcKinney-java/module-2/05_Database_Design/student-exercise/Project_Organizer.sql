drop table if exists project                      cascade;
drop table if exists department                       cascade;
drop table if exists employee                       cascade;

BEGIN TRANSACTION;

CREATE TABLE department
(
	department_id serial,
	department_name varchar(100)not null,
	
	constraint pk_department_id primary key (department_id)
);

CREATE TABLE project
(
	project_number serial,
	project_name  varchar(100) not null,
	startdate date,
	
	constraint pk_project_number primary key (project_number)	
);

CREATE TABLE employee
(
	employee_id serial, 
	department_id int not null,
	project_number int,
	job_title varchar(100) not null, 
	last_name varchar(100) not null, 
	first_name varchar(100) not null, 
	gender varchar(100),  
	birthdate date not null,
	hiredate date,
	
	constraint pk_employee_id primary key (employee_id),
	constraint fk_department_id foreign key (department_id) references department(department_id),
	constraint fk_project_number foreign key (project_number) references project(project_number)	
);

INSERT INTO department(department_name) 
VALUES('finance');
INSERT INTO department(department_name)
VALUES('logistics');
INSERT INTO department(department_name)
VALUES('security');
INSERT INTO department(department_name)
VALUES('human resources');
INSERT INTO department(department_name)
VALUES('automotive');

INSERT INTO project(project_name, startdate) 
VALUES('educational travel','08-01-18');
INSERT INTO project(project_name, startdate) 
VALUES('retail delivery','01-08-18');
INSERT INTO project(project_name, startdate)  
VALUES('entertainment touring', '03-09-18');
INSERT INTO project(project_name, startdate) 
VALUES('corporate limos','06-10-18');

INSERT INTO employee(department_id, project_number, job_title, first_name, last_name, gender, birthdate, hiredate)
VALUES(1, 1, 'account manager', 'Micheal', 'Miller','male','01-02-68','01-02-94');
INSERT INTO employee(department_id, project_number, job_title, first_name, last_name, gender, birthdate, hiredate)
VALUES(2, 2, 'travel coordinator', 'John', 'Drake', 'male','05-03-78','01-02-98');
INSERT INTO employee(department_id, project_number, job_title, first_name, last_name, gender, birthdate, hiredate)
VALUES(3, 3, 'private security officer', 'Julie','Roberts','female','03-02-66','09-23-88');
INSERT INTO employee(department_id, project_number, job_title, first_name, last_name, gender, birthdate, hiredate)
VALUES(4, 4, 'personnel coordinator', 'Jade','Smith','male','11-14-45','07-07-98');
INSERT INTO employee(department_id, project_number, job_title, first_name, last_name, gender, birthdate, hiredate)
VALUES(5, 1, 'service mechanic', 'Brandie','Washington','FMALE','01-02-68','09-08-80');
INSERT INTO employee(department_id, project_number, job_title, first_name, last_name, gender, birthdate, hiredate)
VALUES(1, 2, 'accountant', 'Mandy','Frost','female','04-07-50','07-17-97');
INSERT INTO employee(department_id, project_number, job_title, first_name, last_name, gender, birthdate, hiredate)
VALUES(2, 3, 'driver', 'Sammie','Davidson','male','06-06-58','05-02-99');
INSERT INTO employee(department_id, project_number, job_title, first_name, last_name, gender, birthdate, hiredate)
VALUES(3, 4, 'front desk security','Donald','Gloves','male','01-02-98','01-02-98');

--ROLLBACK;
COMMIT TRANSACTION;
END TRANSACTION;