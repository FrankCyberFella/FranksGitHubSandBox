# Intro to Ordering, Grouping, and database functions

## Problem Statement
Information in isolation is only so useful. We can group our information and provide it back in an order that makes the information easily comparable.

Database functions to count, sum, average, and otherwise massage the data can further enrich the information. 

## Lesson Objectives

* Ordering
* Limiting Results
* String operations functions
* Aggregate functions
* Grouping Results
* Subqueries

## Notes and Examples

### **Ordering Results**

- A result set can be sorted using the **`ORDER BY`** syntax.

    ```
    SELECT col1, col2 
    FROM tablename
    WHERE col1 = 'value'
    ORDER BY col1 [ASC | DESC], col2 [ASC | DESC] 
    ```  
- Sort columns must exist in the table being queried or can be aliased columns
- Multiple column names can be provided which assigns a priority sort

### **Limiting Results**

- We can reduce the size of our result set to *N results*.
    - Postgres uses **LIMIT N** at the end of query.
    - SQL Server uses **SELECT TOP N** in the beginning of the query.

### **String Operations**

- * We can concatenate the values across multiple columns into a single field.
    - **In Postgres** we can use the || operator to concatenate strings. **`SELECT (column1 || ', ' || column2) FROM table`**
    - **In SQL Server** we can use the + operator to concatenate strings. **`SELECT (column1 + ', ' + column2) FROM table`**

### **Aggregate Functions**

* **`AVG`** returns the average value of a numeric column
* **`SUM`**  returns the total sum of a numeric column
* **`COUNT`** returns the number of rows matching criteria
* **`MIN`** returns the smallest value of the selected column
* **`MAX`** returns the largest value of the selected column    

### **Grouping Results**

<div class="definition note">

**GROUP BY** statements group records into summary rows and return one record for each group.</div>
   
- Grouping data is the process of combining columns with duplicate values.
    - For example a database may contain information about employees; many employees may live in different cities. Supposed you wanted to figure the average salary paid to employees within each city. We would use the aggregate function `AVG` and `GROUP BY` the city.
    - The **GROUP BY** clause can be used in conjunction with a SELECT statement and aggregate functions to collect data across multiple records.
    - The signature of the statement follows:

    ```sql
    SELECT expression1, expression2, ... expression_n, 
        aggregate_function (aggregate_expression)
    FROM tables
    [where condition_expression]
    GROUP BY expression1, expression2, ... expression_n
    ORDER BY;
    ```    

### **Subqueries**

We don't offer explicit exercises for this, but this day is typically lighter and gives us the chance to present the idea that queries can "span" multiple tables.

<div class="definition note">A <b>subquery</b> is referred to as an inner query and can provide the results of one query as input to another.</div>

- Often used in the WHERE clause
- Can only return one item in the SELECT clause	

	```
	SELECT column_name [, column_name]
	FROM table1 [, table2]
	WHERE column_name (IN | NOT IN)
		(SELECT column_name FROM table [WHERE])
	```