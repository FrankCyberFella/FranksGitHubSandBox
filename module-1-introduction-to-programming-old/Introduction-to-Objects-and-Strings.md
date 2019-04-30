<link rel="stylesheet" type="text/css" media="all" href="./styles/style.css" />

# Introduction to Objects Using Strings - Lecture Notes
###### (04/13/2018)

## **Session Objectives:** 
* Explain the concept of an object as it relates to the programming universe
* Describe the difference between objects and classes and how their relationship
* Create and use objects
* Understand how objects are stored
* Explain how the Stack and Heap are used with objects and primitives
* Describe the String class, it's purpose and use
* Create and use String objects
* Explain object equality and why it is important

## Classroom Preparation

1. Write various string methods on board

## [**Overview of Session**](http://book.techelevator.com/java/introduction-to-objects/01_intro.html) 

Until now we've primarily worked with the primitive data types. These data types are simple because they only hold a literal value and require a fixed amount of memory but lack the ability to add any additional complexity.

This week we will begin learning about objects which are used to model real world objects. 

## **Customary schedule for session:** 

* [Objects](http://book.techelevator.com/java/introduction-to-objects/05_what-is-an-object.html) & [Classes](http://book.techelevator.com/java/introduction-to-objects/10_what-is-a-class.html)
* Reference & Value Types
* Immutability
* [String Equality](http://book.techelevator.com/java/introduction-to-objects/25_object-equality.html)
* [String Methods](http://book.techelevator.com/java/introduction-to-objects/30_strings.html)

## **Topic List w/Notes** <div class=topicNote>(and <span class='link'>links</span> to e-book section when available)</div>

### [What is an Object](http://book.techelevator.com/java/introduction-to-objects/05_what-is-an-object.html)

### [What is a Class](http://book.techelevator.com/java/introduction-to-objects/10_what-is-a-class.html)

### [Creating Objects](http://book.techelevator.com/java/introduction-to-objects/15_creating-objects.html)

### [Objects in Memory](http://book.techelevator.com/java/introduction-to-objects/20_stack-versus-heap.html)

- Reference vs. Value Types

    - All of the simple/primitive types that we have worked with are considered primitive types. 

        <div class="definition note">A <strong>value type</strong> references a single static space in memory to hold the value. This memory is allocated on the <em>stack</em></div>

        <div class="definition note">The stack is a region of computer memory that manages temporary variables created by each function.</div>

        <div class="definition note">A <strong>reference type</strong> is a data type whose value is a pointer to a memory location that holds the data. This memory location is on the <em>heap</em>. Multiple variables can point to the same memory location and thus modify the underlying object.</div> 

        <div class="definition note">The heap is a free-floating region of memory managed by the computer and referenced by pointers.</div>

        <div class="analogy note">Sending an attachment via email is an example of a value type. Sending a link to an attachment hosted on Dropbox/Google Drive would be an example of a reference type.</div>

   - Immutability

     <div class="caution note">While strings are reference types, they are also  <strong>immutable</strong>. They are unable to be changed or altered and thus performing any operation on a string creates a new string.</div>

- Intializing an Object

    - All objects need to be initialized or *instantiated*. 
    - We won't cover this flow today because strings are a special form of object and support the ability to type in the *literal* value.
    - Objects can be declared and the value can be left as `null`.

### [Object Equality (JAVA only)](http://book.techelevator.com/java/introduction-to-objects/25_object-equality.html)


### [Strings](http://book.techelevator.com/java/introduction-to-objects/30_strings.html)
- The `String` class
- String methods
    - `length()'
    - `substring()`
    - `contains()`
    - `startsWith()` and `endsWith()`
    - `indexOf()`
    - `replace()`
    - `toLower()` and `toUpper()`
    - `equals()` and `equalsIgnoreCase()`
    - `split()`
    - `String.join()`



| Reference |
|-----------|
|[C# String Reference](https://msdn.microsoft.com/en-us/library/system.string(v=vs.110).aspx)|

### DateTime & Math Instance and Static Methods

The Java and .NET Framework provides two other classes that are useful to work with: The DateTime and Math classes.

## Instructor Led Exercises

- [Java Lecture Code](https://bitbucket.org/te-curriculum/m1-java-introduction-to-objects-lecture)
- [.NET Lecture Code](https://bitbucket.org/te-curriculum/m1-csharp-strings-lecture)

## Student Exercises (Individual & Pair)

- [Java Exercises](https://bitbucket.org/te-curriculum/m1-java-introduction-to-objects-exercises)
- [Java Exercise Solutions](https://bitbucket.org/te-curriculum/m1-java-introduction-to-objects-solutions)
- [.NET Exercises](https://bitbucket.org/te-curriculum/m1-csharp-strings-exercises)
- [.NET Exercise Solutions](https://bitbucket.org/te-curriculum/m1-csharp-strings-solution)

