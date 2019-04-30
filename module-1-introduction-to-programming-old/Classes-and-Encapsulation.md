<link rel="stylesheet" type="text/css" media="all" href="./styles/style.css" />

# Encapsulation - Lecture Notes
###### (04/16/2018)

## **Session Objectives:** 

* Describe the ideal properties 
concepts and goals of encapsulation and how it is used in Object Oriented Programming
* Explain the characteristics of a loosely coupled system
* Describe Final/COnstant/Readonly variables and their use
* Properly define use the static variables, properties and methods in a program

## Classroom Preparation
* None

## **Overview of Session** 

We've learned that we can define classes that consist of: constructors, methods, and properties. Properties represent state, methods act as behaviors
and constructors are part of the initialization process. With classes we can write modules of code and allow them to self-contain pieces of 
functionality that can be re-used throughout our project and shared with other developers. 

* How do we make sure that other developers know how to use our classes? 
* How can we make sure that they are set up and used in the proper order?

Today we'll learn about one of the principles of object oriented programming called **encapsulation**.

## **Customary schedule for session:** 

* Encapsulation
* Access Modifiers
* Final & Constants (Java) / Readonly (C#)
* Static Properties/Methods


## **Topic List w/Notes** <div class=topicNote>(and <span class='link'>links</span> to e-book section when available)</div>

> **Instructor should use the Deck of Cards as Lecture Code** for this day.

- Introduce class design
    - What are ideal properties and values for a card/deck?
    - What are the kinds of data types that we could use?
- Encapsulation
    - Do we want the value of suit of the card to be accessible?
    - Do we want the cards in the deck to be accessible?
    - `private` and `public`            
    <div class="definition note">
    <strong>Encapsulation</strong> is: 
    <br/><br/>        
    <ul>
        <li>the packaging of data and functions into a single component</li>
        <li>hiding the implementation details of a class to prevent other parties from setting the data to an invalid or inconsistent state and also reduce coupling.</li>
    </ul>
</div>

* **.NET Only** Properties
    - Difference between 
    ```csharp
    public int Property { get; set; }       //public set
    public int Property { get; }            //readonly set w/in constructor
    public int Property { get; private set;}//private set
    ```
*. **Goal of Encapsulation**
    - makes code extendable
    - makes code maintainable
    - promotes "loose coupling"
<div class="definition note">A <span>loosely coupled</span> system is one in which each of its components has, or makes use of, little or no knowledge of the definitions of other separate components. </div>

* **Composition**
    - A deck has cards that it maintains

* **Static**
    - Static indicates it belongs to the class and not an instance
    - What might be valid static properties? Suits? Values?

* **Shuffle**
    - Leave it up to the students to implement a shuffle algorithm.

## Student Exercises (Individual & Pair)

- [Java Exercises](https://bitbucket.org/te-cohort-2/m1-w2d5-java-oop-with-encapsulation-exercises)
- Java Exercises Solutions - **TODO**
- [.NET Exercises](https://bitbucket.org/te-curriculum/m1-csharp-oop-with-encapsulation-exercises)
- [.NET Exercises Solutions](https://bitbucket.org/te-curriculum/m1-csharp-oop-with-encapsulation-solution) 

