<link rel="stylesheet" type="text/css" media="all" href="./styles/style.css" />

# Introduction to Classes - Lecture Notes
###### (05/15/2018)

## **Overview of Session** [Java](http://book.techelevator.com/java/45-introduction-to-classes/01-intro.html) | [.Net](http://book.techelevator.com/.net/45-introduction-to-classes/01-intro.html)

So we've learned about some of the standard classes that are included in the standard library and how to create and use objects from those classes.

But one of the powers of these languages is that we can create our own classes and make objects out of those as well. We can start to think of our programs not as a series of instructions to run through in order, but more as a group of objects working together to get the job done.

This mode of thinking is called Object Oriented Programming and it's what we'll talk about over the next week and a half.

**CAUTION** This is traditionally a pretty packed day. Things at the end can be skipped if you feel it's too much for the students. Just remember that we are going over a lot of these concepts again in future lessons and don't need to get it all packed in now.

## **Session Objectives:** 

* Students should be able to explain the concept of classes and their use in Object Oriented Programming
* Students should be able to create a proper class definition
* Students should be able to effectively use class variables, methods and properties
* Students should be able to create and call Constructors
* Students should be able to describe the difference with `public` and `private` access modifiers
* Students should be able to create instances of a class
* Students should be able to explain the concept of properties and correctly define and use them in a class
* Students should be able to define member methods in a class and use them in an object of that class
* Students should be able to state the concept of overloading as it pertains to classes

## Classroom Preparation
1. Write the three OOP principles on the board


## **Agenda and Timing for Session** 

* Defining Classes & Namespaces (0:10)
* 3 Fundamental Concepts of OOP (0:15)
* Creating a Class (0:10)
* Class Members and **this**
    * Member Variables (0:10)
    * Access Modifiers [Java](http://book.techelevator.com/java/45-introduction-to-classes/25-access-modifiers.html) | [.Net](http://book.techelevator.com/.net/45-introduction-to-classes/25-access-modifiers.html) (0:15)
    * Properties [Java](http://book.techelevator.com/java/45-introduction-to-classes/10-properties.html) | [.Net](http://book.techelevator.com/.net/45-introduction-to-classes/10-properties.html) (0:20)   
        * Derived properties [Java](http://book.techelevator.com/java/45-introduction-to-classes/11-derived-properties.html) | [.Net](http://book.techelevator.com/.net/45-introduction-to-classes/11-derived-properties.html)
* Break (0:10)
    * Member Functions
        * Methods [Java](http://book.techelevator.com/java/45-introduction-to-classes/15-methods.html) | [.Net](http://book.techelevator.com/.net/45-introduction-to-classes/15-methods.html) (0:20)   
        * Constructors [Java](http://book.techelevator.com/java/45-introduction-to-classes/20-constructors.html) | [.Net](http://book.techelevator.com/.net/45-introduction-to-classes/20-constructors.html) (0:20)
* Overloading [Java](http://book.techelevator.com/java/45-introduction-to-classes/30-overloading.html) | [.Net](http://book.techelevator.com/.net/45-introduction-to-classes/30-overloading.html) (0:20)
    * Method Overloading [Java](http://book.techelevator.com/java/45-introduction-to-classes/31-method-overloading.html) | [.Net](http://book.techelevator.com/.net/45-introduction-to-classes/31-method-overloading.html)
    * Constructor Overloading [Java](http://book.techelevator.com/java/45-introduction-to-classes/32-constructor-overloading.html) | [.Net](http://book.techelevator.com/.net/45-introduction-to-classes/32-constructor-overloading.html)
* Object Equality and Stringification (0:20)

## **Topic List w/Notes** <div class=topicNote>(and <span class='link'>links</span> to e-book section when available)</div>

<div class="note caution">Let the students know that this is an overview day. They don't have to get all of this down exactly today, but there are a lot of concepts being introduced today that will be revisited a lot. They have the potential to really get down on themselves today if you're not careful.

</div>

### [Defining Classes and Namespaces](http://book.techelevator.com/java/45-introduction-to-classes/05-what-are-classes.html)

<div class="definition note">A <span><strong>class</strong></span> is a blueprint or model that defines state with fields (aka variables) and behavior with methods. We create new <span>instances</span> of a class that follow the blueprint but may have different property values.</div>

### Three Fundamental Principles of OOP

<div class="definition note"><span><strong>Encapsulation</strong></span>  - the concept of hiding values or state of data within a class, limiting the points of access.</div>
<div class="definition note"><span><strong>Polymorphism</strong></span> - the ability for our code to take on different forms</div>

<div class="definition note"><span><strong>Inheritance</strong></span> - the practice of creating a hierarchy for classes in which descendants obtain the attributes and behaviors from other classes classes.</div>

* Benefits of OOP are:
    - A natural way of expressing real-world objects in code
    - Modular and reliable, allowing changes to be made in one part of the code without affecting another
    - Discrete units of reusable code 
    - Units of code can communicate with each other by sending and receiving messages and processing data    
* We will be talking about these more over the next week and a half

### [Defining Classes and Namespaces](http://book.techelevator.com/java/45-introduction-to-classes/05-what-are-classes.html)

<div class="definition note">A <span><strong>class</strong></span> is a blueprint or model that defines state with fields (aka variables) and behavior with methods. We create new <span>instances</span> of a class that follow the blueprint but may have different property values.</div>

* Class Naming
    - Use *nouns or noun phrases*, not verbs
    - Try to use the *singular form* of a class name
    - Class name should match the file name
    - Follow Pascal Casing
        * <div class="definition note">

           <span><strong>Pascal case</strong> </span> is a subset of Camel Case where the first letter is capitalized. That is, `userAccount` is a camel case and `UserAccount` is a Pascal case. The conventions of using these are different. You use camel case for variables and Pascal case for Class names or Constructors. It is easy to remember.
        </div>

<div class="note instructorDirective">

Show the `PaintCalc` command line application and then show how it doesn't do anything right now. You could add in variables and arrays to solve the problems, but that doesn't let you work at the layer of a Rectangle that handles all its own stuff. To fix this, you will focus first on creating a class the models a `Rectangle`.

1. Create the `Rectangle` file
2. Define an empty `Rectangle` class

</div>
    
<div class="definition note"> The <span>Fully Qualified Name</span> is an unambiguous name referencing a specific class type. It includes the namespace (or package) and the class name.</div> 

### [Instance Variables](http://book.techelevator.com/java/45-introduction-to-classes/10-properties.html)

#### Access Modifiers

<div class="note instructorDirective">

3. Define `private` length and width variables

</div>

#### Getters and Setters

<div class="note instructorDirective">

4. Talk about how `public` member variables are bad because they a) allow direct access to object internals and b) don't allow the object to verify or modify data before it gets into the object state. (Don't go too deep. More will be said tomorrow.)
5. Create getters and setters.
6. Show how you can now add code to setter to prevent negative numbers (which is fine for an int, but would make an invalid rectangle)

</div>

### [Derived Properties](http://book.techelevator.com/java/45-introduction-to-classes/11-derived-properties.html)

### [Methods](http://book.techelevator.com/java/45-introduction-to-classes/15-methods.html)

- Apply functions to simplify repetitive actions that we perform against an objects

<div class="definition note">A <span><strong>function</strong></span> or method, is like a mathematical function (e.g. `f(n) = n^2` ). Methods can have multiple parameters but <span>can only return one value</span>.</div>

<div class="definition note">

A <span>derived property</span> is a getter that, instead of returning a member variable, returns a calculation taken from member variables. If we have `width` and `height`, we can calculate `area` and don't need to store it in the object. If we have `firstName` and `lastName`, we don't need to also store `fullName`, we can derive it from what we already have.

</div>

 <div class="note instructorDirective">

7. Define and implement a `getArea()` method
8. Explain how `getArea()` is a derived property, a property that is calculated from other member variables
9. Show how this can be wired up to the PaintCalc application to provide the functionality for width, length and area.

</div>

- Methods help by
    - making the code base manageable with smaller chunks
    - reducing code into small units of work, making debugging simpler
    - and introducing reuse.

- Method Signature 
    - All methods have a name (that is usually a verb)
    - All methods have a return type (or output)
    - Methods can be parameterless or can include parameters (or inputs).

<div class="note instructorDirective">

10. Define an `isLargerThan(Rectangle other)` method (note to the students that this isn't required for the paint calculator, it's just for demonstration purposes)    

</div>

- Create a local variable scope. Class member variables can be accessed with `this`. 
    - `this` is optional in C#.

- Overloaded Functions<br/>

    <div class="definition note">An <span>overloaded function</span> is the ability to create multiple functions with the same name and return type. The parameter signature must be different.</div>

<div class="note instructorDirective">
 
11. Define an `isLargerThan(int length, int width)` (again, not necessary for paint calculator)

</div>

#### Constructors

1. Constructors
    - Help when member variables are required
    - Help when certain steps need to occur during initializing

    <div class="definition note">A <span> constructor </span> is a special type of method that runs every time a new object is instantiated. The default constructor exists without any special code that needs to be written by us.</div>

2. Constructors
    - It is a method whose name must match the exact spelling and casing of the class.
    - It has no return type defined.

<div class="note instructorDirective">

12. Define a no-arg constructor
13. Define a `Rectangle(int length, int width)` constructor

</div>

### Object Equality and Stringification

<div class="instructorDirective note">

Implement an `equals()` method and show how to compare two complex object to see if they're equal.

Talk about how this and `toString()` is an overload of a base method from the `Object` class.

</div>

## Instructor Led Exercises

- [Java Lecture](https://bitbucket.org/te-curriculum/module-1-introduction-to-c/src/master/lecture/introduction-to-classes-lecture/)
- [.NET Lecture](https://bitbucket.org/te-curriculum/module-1-introduction-to-c/src/master/lecture/introduction-to-classes-lecture/)

## Student Exercises (Individual & Pair)

- [Java Exercises](https://bitbucket.org/te-curriculum/module-1-introduction-to-java/src/master/exercises/introduction-to-classes-exercises/)
- [.NET Exercises](https://bitbucket.org/te-curriculum/module-1-introduction-to-c/src/master/exercises/introduction-to-classes-exercises/)