SELECT first_name, last_name
FROM project_employee JOIN employee
ON project_employee.employee_id = employee.employee_id
WHERE project_id = 6
;
