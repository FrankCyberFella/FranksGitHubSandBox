<link rel="stylesheet" type="text/css" media="all" href="./styles/style.css" />

# Encapsulation - Lecture Notes
###### (05/17/2018)

## **Overview of Session** 

We've learned that we can define classes that consist of: constructors, methods, and properties. Properties represent state, methods act as behaviors
and constructors are part of the initialization process. With classes we can write modules of code that are self-contained pieces of 
functionality that can be re-used throughout our project and shared with other developers. 

* How do we make sure that other developers know how to use our classes? 
* How can we make sure that they are used the right way?

Today we'll dive deeply into one of the principles of object oriented programming called **encapsulation**.

## **Session Objectives:** 

* Students should be able to define encapsulation, give a good example of it, how it is implemented, and describe why it is used
* Students should be able to define "loosely coupled" and explain the characteristics of a loosely coupled system
* Students should be able to describe constant variables, how to create them, and their use
* Students should be able to define and use static methods and be able to describe what they are for

## Classroom Preparation
* None

## **Agenda and Timing for Session** 

*(For timing, most of the class will be taken up doing the group lecture exercise and talking about class design. The following topics will come up organically as you go through and you stop to talk about them)*

* Encapsulation
* Access Modifiers
* Final & Constants (Java) / Readonly (C#)
* Static Properties/Methods


## **Topic List w/Notes** <div class=topicNote>(and <span class='link'>links</span> to e-book section when available)</div>

<div class="note instructorDirective">

**Instructor should use the Deck of Cards as Lecture Code** for this day. Don't push the lecture code to students but show them how to create a new empty project and create the classes with their input.

</div>

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
    public int Property { get; set; }         //public set
    public int Property { get; }              //readonly set w/in constructor
    public int Property { get; private set; } //private set
    ```
* **Goal of Encapsulation**
    - makes code extendable
    - makes code maintainable
    - promotes "loose coupling"
<div class="definition note">A <span>loosely coupled</span> system is one in which each of its components has, or makes use of, little or no knowledge of the definitions of other separate components. </div>

* **Composition**
    - A deck has many cards that it maintains

* **Static**
    - Static indicates it belongs to the class and not an instance
    - What might be valid static properties? Suits? Values?

* **Shuffle**
    - Leave it up to the students to implement a shuffle algorithm.

## Instructor Led Exercises

- [Java Lecture](https://bitbucket.org/te-curriculum/module-1-introduction-to-java/src/master/lecture/oop-with-encapsulation-lecture/)
- [.NET Lecture](https://bitbucket.org/te-curriculum/module-1-introduction-to-c/src/master/lecture/oop-with-encapsulation-lecture/)

## Student Exercises (Individual & Pair)

- [Java Exercises](https://bitbucket.org/te-curriculum/module-1-introduction-to-java/src/master/exercises/oop-with-encapsulation-exercises/)
- [Java Pair Exercises](https://bitbucket.org/te-curriculum/module-1-introduction-to-java/src/master/exercises/oop-with-encapsulation-exercises-pair/)
- [.NET Exercises](https://bitbucket.org/te-curriculum/module-1-introduction-to-c/src/master/exercises/oop-with-encapsulation-exercises/)
- [.Net Pair Exercises](https://bitbucket.org/te-curriculum/module-1-introduction-to-c/src/master/exercises/oop-with-encapsulation-exercises-pair/)

