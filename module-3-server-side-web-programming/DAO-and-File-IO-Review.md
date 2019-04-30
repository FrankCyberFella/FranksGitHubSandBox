# Data Access Objects

## Problem Statement

* *What problems do we have with just storing data in session or generating them from controllers?*    
    - Lack a permanent persistence mechanism

## Objectives

* What is a DAO
* Designing DAO interface
* Implementing a DAO
* How to Develop/Design an MVC Application

## Outline

1. **What is a DAO**

    - Web applications rely on permanent persistance mechanisms to record transactions that occur
    - Web applications also rely on persistance to provide dyanmic data inputs
    - When developing applications that interact with a persistance mechanism we build them in layers so that no part of our application has too much responsibility

    <div class="definition note">A **data access object** is an abstract portion of our program that encapsulates the logic necessary for accessing data from a storage mechanism.</div>

    - A data access layer in our application is comprised of data access objects, each of which have the responsibility of creating, reading/searching, updating, and deleting various entities
    - Data access objects are often designed with interfaces in mind.
    
    - *What types of entities can we come up with that we might act on using CRUD*?

    - *What might be the benefits of designing software using a layered approach with a data access object?*
        - Simple and clear separation between mvc code and data access code
        - Changes to the underlying persistance mechanism should not have effects to the website
        - DAOs act as an intermediary
        - Unit Tests become easier to perform

2. **Designing the DAO Interface**

    - DAOs are often aligned with a single data entity or model object
    - DAOs use an interface to indicate which behaviors should exist (e.g.)
        - `void Create(Product p)`
        - `Product GetById(string id)`
        - `Product GetByName(string name)`
        - `List<Product> GetAllProducts()`
        - `void Update(Product p)`
        - `void Delete(string id)`

3. **Implementing a DAO**

    - Walk the students through an example (i.e. Shopping Cart of an implemented project using a DAO)

4. **Developing an MVC Application**

    - After presenting the exercises, suggest walking the students through the steps necessary to developing a full MVC Application

    > ** Steps **
    > 1. Map out a full site layout. 
    >   * What pages are displayed on the site?
    >   * What is the user flow for the site?
    >   * What are the controller names and model names?
    >   * What does the DAL interface need to achieve?
    > 2. Define the Controllers
    >   * What **Http Get** actions need to exist?
    >   * What **Http Post** actions need to exist?
    >   * Make the controllers do the absolute minimum necessary to return the view or redirect the user.
    > 3. Create empty Views
    >   * For form submissions create an empty form that submits data 
    >   * At this point we should have a site with a navigation flow (albeit lacking functionality)
    > 4. Create the model
    >   * Bind a view to the model
    >   * Mock or hard-code the controller action to return that model
    > 5. Modify the view to render a model
    > 6. Define the DAO/DAL interface
    >   * Implement the minimum necessary to make the website fully functional
    > 7. Update the controller to use new implemented DAO/DAL methods.
    > 8. Then add validation.
     

## Real World Usage Scenarios

## Individual/Pair Exercises


## Student Reading

### Required Reading
| Applies To | Reading Link |
|------------|--------------|
| | |



### Cheat Sheets & References
| Applies To | Reading Link |
|------------|--------------|
| | |


## Instructor References



## Quiz

| Class | Socrative Quiz | Answer Sheet |
| ----- | -------------- | ------------ | 
| C#  | SOC-22950703 | [Answer Sheet](quizzes/csharp/Answer Sheet - Module 2 Week 2 Review.pdf)  |
| Java  |    |   |