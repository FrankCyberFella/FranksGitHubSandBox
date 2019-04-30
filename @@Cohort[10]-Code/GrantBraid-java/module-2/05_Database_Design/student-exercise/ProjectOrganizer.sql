--drop table if exists tester             cascade;
drop table if exists department         cascade;
drop table if exists employee           cascade;
drop table if exists job                cascade;
drop table if exists project            cascade;
drop table if exists employee_project   cascade;



--CREATE TABLE tester (
--        test_id serial not null,
--        tester_name varchar(40) not null,
--        
--        Constraint pk_tester_test_id primary key (test_id)
--        );

CREATE TABLE department (
        department_id serial not null,
        name varchar(40) not null,
        constraint pk_department_department_id primary key (department_id)
);

CREATE TABLE employee (
        employee_id serial not null,
        department_id integer not null,
        first_name varchar(40) not null,
        last_name varchar(40) not null,
        gender varchar(1) DEFAULT 'M' not null,
        birthday varchar(40),
        hire_date varchar(40),
        job_id integer not null,
        constraint pk_employee_employee_id primary key (employee_id),
        constraint ck_employee_gender check (gender in ('M','F'))
);

CREATE table job (
        job_id serial not null,
        name varchar(40) not null,
        constraint pk_job_job_id primary key (job_id)
);

CREATE TABLE project (
        project_id serial not null,
        name varchar(40) not null,
        start_date varchar(40),
        constraint pk_project_project_id primary key (project_id)
);

CREATE TABLE employee_project (
        employee_id integer not null,
        project_id  integer not null,
        constraint pk_employee_project_employee_id_project_id primary key (employee_id, project_id)
);

insert into department (department_id, name) values (1, 'Human Resources') ; 
insert into department (department_id, name) values (2, 'Business') ; 
insert into department (department_id, name) values (3, 'Consulting') ; 

insert into project (project_id, name, start_date) values (1,'Vending Machine', '12-1-2019') ; 
insert into project (project_id, name) values (2, 'Dog translator') ;
insert into project (project_id, name, start_date) values (3, 'Waterjet cutter' , '3-2-2016') ;
insert into project (project_id, name) values (4, 'Taco bell') ;


insert into job (job_id,name) values (1,'Janitor') ; -- could do a select from job and get the max job_id + 1 but just hardcoding for now
insert into job (job_id,name) values (2,'Software Developer') ;
insert into job (job_id,name) values (3,'Chef') ;
insert into job (job_id,name) values (4,'P.L.E.A.S.E') ;

insert into employee (employee_id, department_id, first_name, last_name, gender, job_id)
 values (1, (select department_id from department where name = 'Human Resources') , 'Lisa', 'Johnson', 'F', (select job_id from job where name = 'P.L.E.A.S.E'));

insert into employee (employee_id, department_id, first_name, last_name , hire_date, job_id)
 values (2, (select department_id from department where name = 'Consulting') , 'Steve', 'Bigsby' , '12-1-2011', (select job_id from job where name = 'Janitor'));
 
insert into employee (employee_id, department_id, first_name, last_name,gender, birthday, hire_date, job_id)
 values (3, (select department_id from department where name = 'Human Resources'), 'Tina', 'Fey', 'F', '4-3-1974', '7-3-2000', (select job_id from job where name = 'Software Developer'));
 
insert into employee (employee_id, department_id, first_name, last_name, gender, job_id)
 values (4, (select department_id from department where name = 'Business'), 'George', 'Hanama' , 'M', (select job_id from job where name = 'Chef'));
 
 insert into employee (employee_id, department_id, first_name, last_name, gender, job_id)
 values (5, (select department_id from department where name = 'Business'), 'Georgina', 'Hanamam' , 'F', (select job_id from job where name = 'Janitor'));
 
 insert into employee (employee_id, department_id, first_name, last_name, gender, job_id)
 values (6, (select department_id from department where name = 'Human Resources'), 'Tony', 'Stevens' , 'M', (select job_id from job where name = 'P.L.E.A.S.E'));
 
 insert into employee (employee_id, department_id, first_name, last_name, gender, job_id)
 values (7, (select department_id from department where name = 'Consulting'), 'Hannah', 'Lawk' , 'F', (select job_id from job where name = 'Chef'));
 
 insert into employee (employee_id, department_id, first_name, last_name, gender, job_id)
 values (8, (select department_id from department where name = 'Business'), 'Ira', 'Joelmintingle' , 'F', (select job_id from job where name = 'Janitor'));
 
 insert into employee_project (employee_id, project_id)
  values ((Select employee_id from employee where first_name = 'Tony'), (select project_id from project where name = 'Dog translator'));
  
   insert into employee_project (employee_id, project_id)
  values ((Select employee_id from employee where first_name = 'Lisa'), (select project_id from project where name = 'Vending Machine'));
  
   insert into employee_project (employee_id, project_id)
  values ((Select employee_id from employee where first_name = 'Ira'), (select project_id from project where name = 'Waterjet cutter'));
  
   insert into employee_project (employee_id, project_id)
  values ((Select employee_id from employee where first_name = 'Tina'), (select project_id from project where name = 'Dog translator'));
  
   insert into employee_project (employee_id, project_id)
  values ((Select employee_id from employee where first_name = 'Steve'), (select project_id from project where name = 'Taco bell'));
  
   insert into employee_project (employee_id, project_id)
  values ((Select employee_id from employee where first_name = 'Georgina'), (select project_id from project where name = 'Vending Machine'));
  
   insert into employee_project (employee_id, project_id)
  values ((Select employee_id from employee where first_name = 'George'), (select project_id from project where name = 'Taco bell'));
  
   insert into employee_project (employee_id, project_id)
  values ((Select employee_id from employee where first_name = 'Hannah'), (select project_id from project where name = 'Waterjet cutter'));
--YOU NEED TO MAKE FOREIGN KEYS!!!!

ALTER TABLE employee
ADD foreign key(department_id)
references department(department_id);

ALTER TABLE employee
add foreign key(job_id)
references job(job_id);

ALTER TABLE employee_project
add foreign key(employee_id)
references employee(employee_id);

ALTER TABLE employee_project
add foreign key(project_id)
references project(project_id);
--ALTER TABLE city
--ADD FOREIGN KEY(country_id)
--REFERENCES country(country_id);