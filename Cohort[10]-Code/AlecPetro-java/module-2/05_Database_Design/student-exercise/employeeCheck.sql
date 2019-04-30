SELECT employee_id, last_name, first_name, department.department_name, project.project_name
FROM employee
        inner join department
        on department.department_id = employee.department_id
        inner join department_project
        on department.department_id = department_project.department_id
        inner join project
        on project.project_id = department_project.project_id
        ;