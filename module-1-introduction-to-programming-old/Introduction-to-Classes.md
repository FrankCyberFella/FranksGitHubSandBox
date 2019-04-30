<link rel="stylesheet" type="text/css" media="all" href="./styles/style.css" />

# Introduction to Classes - Lecture Notes
###### (04/13/2018)

## **Session Objectives:** 

* Explain the concept of classes and their use in Object Oriented Programming
* Create a proper class definition
* Effectively use class variables, methods and properties
* Create constructor(s) for a class
* Describe the difference with `public` and `private` access modifiers
* Successfully create instances of a class
* Explain the concept of properties and correctly define and sue them in a class
* Describe the use of derived properties in a class
* Define correct and appropriat methods for a class
* State the concept of overloading as it pertains to classes
* Explain object equality as it pertains to multiple objects of the same class.

## Classroom Preparation
 * None

## [**Overview of Session**](http://book.techelevator.com/java/introduction-to-classes/01-intro.html) 

## **Customary schedule for session:** 

* [What are classes](http://book.techelevator.com/java/introduction-to-classes/05-what-are-classes.html) 
* Defining Classes & Namespaces
* 3 Fundamental Concepts of OOP
* Creating a Class
* Class Members and **this**
    * Member Variables
    * Access Modifiers
    * [Properties](http://book.techelevator.com/java/introduction-to-classes/10-properties.html)    
        * [Derived properties](http://book.techelevator.com/java/introduction-to-classes/11-derived-properties.html)
    * Member Functions
        * [Methods](http://book.techelevator.com/java/introduction-to-classes/15-methods.html)    
        * [Constructors](http://book.techelevator.com/java/introduction-to-classes/20-constructors.html)
* [Access Modifiers](http://book.techelevator.com/java/introduction-to-classes/25-access-modifiers.html)
* [Overloading](http://book.techelevator.com/java/introduction-to-classes/30-overloading.html)
    * [Method Overloading](http://book.techelevator.com/java/introduction-to-classes/31-method-overloading.html)
    * [Constructor Overloading](http://book.techelevator.com/java/introduction-to-classes/32-constructor-overloading.html)
* Object Equality
* View the "Building a Real Application Video"

## **Topic List w/Notes** <div class=topicNote>(and <span class='link'>links</span> to e-book section when available)</div>

### [Defining Classes and Namespaces](http://book.techelevator.com/java/introduction-to-classes/05-what-are-classes.html)

<div class="definition note">A <span><strong>class</strong></span> is a blueprint or model that defines state with fields (aka variables) and behavior with methods. We create new <span>instances</span> of a class that follow the blueprint but may have different property values.</div>
<br>

* Three Fundamental Principles of OOP
<br/><br/>
    - Encapsulation
    - Polymorphism
    - Inheritance

<div class="definition note"><span><strong>Encapsulation</strong></span>  - the concept of hiding values or state of data within a class, limiting the points of access.</div>
<br>
<div class="definition note"><span><strong>Polymorphism</strong></span> - the ability for our code to take on different forms</div>
<br>

<div class="definition note"><span><strong>Inheritance</strong></span> - the practice of creating a hierarchy for classes in which descendants obtain the attributes and behaviors from other classes classes.</div>

* Benefits of OOP are:
    - A natural way of expressing real-world objects in code
    - modular and reliable, allowing changes to be made in one part of the code without affecting another
    - discrete unitsof reusable code 
    - units of code can communicate with each other by sending and receiving messages and processing data    
    
* Class Naming
    * Use *nouns or noun phrases*, not verbs
    * Try to use the *singular form* of a class name
    * Class name should match the file name
    * Follow Pascal Casing

        * <div class="definition note"><span><strong>Pascal case</strong> </span> is a subset of Camel Case where the first letter is capitalized. That is, `userAccount` is a camel case and `UserAccount` is a Pascal case. The conventions of using these are different. You use camel case for variables and Pascal case for Class names or Constructors. It is easy to remember.</div>
<br>

    Instructor

    1. Create the `Rectangle` class
    2. Define an empty `Rectangle` class
    3. Create a `RectangleDemo` file with a `main` method to show how the `Rectangle` can get instantiated and prints it to the screen.
    
>    <div class="definition note"> The <span>Fully Qualified Name </span> is an unambiguous name referencing a specific class type. It includes the namespace (or package) and the class name.</div> 

### [Instance Variables](http://book.techelevator.com/java/introduction-to-classes/10-properties.html)
    Instructor

    5. Define `public` length and width variables
    6. Modify `RectangleDemo` to create an array of `Rectangle` objects, loop over them, and print the area of each.

### Getters and Setters

     Instructor

     7. Talk about how `public` member variables are bad because they a) allow direct access to object internals and b) don't allow the object to verify or modify data before it gets into the object state.
     8. Create a getter and setter and use it to convert any negative width or height to positive.

### [Derived Properties](http://book.techelevator.com/java/introduction-to-classes/11-derived-properties.html)

### [Methods](http://book.techelevator.com/java/introduction-to-classes/15-methods.html)

1. Apply functions to simplify repetitive actions that we perform against an objects

    <div class="definition note">A <span><strong>function</strong></span> or method, is like a mathematical function (e.g. `f(n) = n^2` ). Methods can have multiple parameters but <span>can only return one value</span>.</div>
###

    Instructor

    9. define a `getArea()` method


2. Methods help by
    - making the code base manageable with smaller chunks
    - reducing code into small units of work, making debugging simpler
    - and introducing reuse.

3. Method Signature 
    - All Functions have a name (that is usually a verb)
    - All Functions have a return type (or output)
    - Functions can be parameterless or can include parameters (or inputs).
###
    Instructor

    10. define an `isLargerThan(Rectangle other)` method (note to  the students that this isn't required for the paint calculator, it's just for demonstration purposes)    

4. Create a local variable scope. Class member variables can be accessed with `this`. 
    - `this` is optional in C#.
###
    Instructor

    11. define an `isLargerThan(int length, int width)` (again, not necessary for paint calculator)

5. Overloaded Functions<br/>

    <div class="definition note">An <span>overloaded function</span> is the ability to create multiple functions with the same name and return type. The parameter signature must be different.</div>


#### Constructors

1. Constructors
    - help when member variables are required
    - help when certain steps need to occur during initializing<br/><br/>

    <div class="definition note">A <span> `constructor` </span> is a special type of method that runs every time a new object is instantiated. The default constructor exists without any special code that needs to be written by us.</div>

2. Constructors
    - It is a method whose name must match the exact spelling and casing of the class.
    - It has no return type defined.
###
    Instructor

    12. define a no-arg constructor
    13. define a `Rectangle(int length, int width)` constructor

### Object Equality

<div class="caution note">Create two instances of the same object on the board and assign their properties the same values. Make sure that students are clearly able to understand that the two separate instances are not naturally equal.</div>

## Instructor Led Exercises

- Java Lecture - N/A
- [.NET Lecture](https://bitbucket.org/te-curriculum/m1-csharp-introduction-to-classes-lecture)

## Student Exercises (Individual & Pair)

- [Java Exercises](https://bitbucket.org/te-curriculum/m1-java-introduction-to-classes-exercises)
- Java Exercises Solutions - **TODO**
- [.NET Exercises](https://bitbucket.org/te-curriculum/m1-csharp-introduction-to-classes-exercise)
- [.NET Exercises Solutions](https://bitbucket.org/te-curriculum/m1-csharp-introduction-to-classes-solution)


## References
N/A
