# Database Design Exercise

### Implement a database to hold the contents of simple Project Organizer.

The Project Organizer tracks what department and individual employees are working on a given project.

Each employee has the following attributes:

* employee number
* job title
* lastname
* firstname
* gender
* birthday
* hiredate
* belongs to a department

Each department has the following attributes:

* department number
* name
* zero-to-many employees

Each project has the following attributes:

* project number
* name
* startdate
* zero-to-many employees

**Requirements**

**NOTE:** You may use the default user account, and do **not** need to create a separater user for this 
exercise.

All tables are required to have a primary key.

Populate the tables with data for at least four projects, three departments, and eight employees. 

Make sure each project has at least one employee assigned to it, and each department has at least two employees in it.

**Design Tips:**
	
Questions you should ask yourself.

* Is a natural key available for the primary key, or will you need a surrogate?
* What data type should be used for each column?
* What attribues are required? Which are optional?
* Are there additional constraints such as length, data format, or restricted values for any columns?
* What table columns will the user likely search?
* Is there an official list of valid job titles?

Don't forget to normalize.
