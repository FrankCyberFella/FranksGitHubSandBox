<link rel="stylesheet" type="text/css" media="all" href="./styles/style.css" />

# Inheritance - Lecture Notes
###### (04/17/2018)


## **Session Objectives** 

* Describe the purpose and use of inheritance in an Object Oriented Programming environment.
* Given and existing set of classes, properly identify  subclasses and a superclasses
* Properly define and use superclasses and subclasses in an inheritance hierarchy

## **Classroom Preparation** 
* None

## [Overview of Session](http://book.techelevator.com/java/inheritance/01_intro.html)

Different kinds of objects often have  properties and methods in common with each other. 
This leads to code duplication as we implement the same functionality in multiple places.

## **Customary schedule for session:** 
* Define Inheritance

## **Topic List w/Notes** <div class=topicNote>(and <span class='link'>links</span> to e-book section when available)</div>

### Inheritance

1. **The Lecture notes have you create an auction**<br/>
	- Students are provided with an initial auction class that will eventually become the base class
	- Start with demonstrating the capability of the program
	- Discuss how we could build on this and get a reserve or a buyout auction
	- Demonstrate "duplicate code"
<br/>
	<div class="definition note"><strong>Inheritance</strong> enables a class to take on the properties and methods defined in another class. A subclass will inherit visible properties and methods from the superclass while adding members of its own.</div>
	<div class="definition note"><strong>A subclass</strong> is the derived class acquiring the properties and behaviors from another class.</div>
	<div class="definition note"><strong>A superclass</strong> is the <em>base</em> class whose members are being passed down.</div>

2. **Specializations** and **is a**
	- Derived class are specializations of a base class
	- A ReserveAuction or BuyoutAuction *is a* special type of Auction
	- A GraphingCalculator is a special type of Calculator

3. **Establishing Inheritance**
	- Inheritance operator
	- `base` / `super`
	- Constructor inheritance
	- Property inheritance (private vs. protected)
	- Method overloading
	
    - <div class="caution note">Inheritance is: 
       
	   - Single Inheritance Only,  
       - Transitive 
       - Constructors are not inherited and must be invoked with base</div>

4. **Is-A Relationship**
	- Specialization classes can be referred to by their base class
	- `Auction auction = new ReserveAuction()`
	- this promotes polymorphic code

5. **Implicit Inheritance**
	- Implicit inheritance from `object` and `System.Object`

6. **Blocking Inheritance**




## Instructor Led Exercise

Building an Auction, Buyout Auction, and Reserved Auction. This example is directly relatable to the Bank Account exercise they will work on later.

## Pair Exercise

1. [Java Exercises - Pair](https://bitbucket.org/te-curriculum/m1-java-inheritance-exercises-pair)
2. [C# Exercises - Pair](https://bitbucket.org/te-curriculum/m1-csharp-inheritance-exercises-pair)
3. [Java Exercises - Solution](https://bitbucket.org/te-curriculum/m1-java-inheritance-part1-solutions)
4. [C# Exercises - Solution](https://bitbucket.org/te-curriculum/m1-csharp-inheritance-exercises-solution)
