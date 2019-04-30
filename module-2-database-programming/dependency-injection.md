# Dependency Injection

## Problem Statement

We have already seen that programming to interfaces can lead to flexible and reusable code:

- The `transfer` method of `BankAccount` could be applied to either `SavingsAccount` or `CheckingAccount` instances.

- A vending machine that gets its stock for inventory from either a file or a database

How is this accomplished?  

Discussion: *Review of Polymorphism and it's benefits.  Namely, how Polymorphism allows us to solve problems in a generalized way.*

Discussion: *Consider the DAO pattern. We have seen several examples of a class leveraging a DAO object which encapsulates the code related to reading and writing to a file. This has decoupled other code (e.g. our CLI classes) from the details of storing and retrieving data from a file.*

Discussion: *We have learned that unit testing is supposed to be done in isolation of external dependencies.  What about the case of our CLI code and classes that call a DAO, are there any complications to unit testing there? How might we make our code more testable?*

## Objectives

- Review Polymorphism
- Define Inversion of Control (IoC) and Dependency Injection
- DI Example

## Notes and Examples

### Review Polymorphism

- Instructor should review a simple understanding of polymorphism using either interfaces or base classes.

### Dependency Injection

**Inversion of Control**
- [Inversion of Control](http://martinfowler.com/bliki/InversionOfControl.html) is a design principle utilized by many frameworks. In fact, it is the fundamental difference between a *framework* and a *library*.
- Refers to the fact that *outside code* is in control in the sense that it invokes the code we write, rather than the other way around.
- Tightly coupled code with dependencies is a liability.
- Example: *The MVC framework invokes our controllers in response to HTTP requests. Our code does not invoke the framework.

<div class="analogy note">"Don't call us, we'll call you." - Hollywood Principle</div>

**Dependency Injection**
- Classes that are designed to be used with Dependency Injection do not instantiate collaborator objects.  Instead, these collaborators are instantiated by an outside class (the "Depedency Injection Container") and provided as contstructor arguments or by calling *setter* methods.
- The benefit of this with regard to testing is that versions of the collaborator objects suitable for testing can be injected for purposes of unit testing. This can help to decouple a class from outside resources.

<div class="definition note">
<span>Dependency Injection</span> is an application of *Inversion of Control* to the instantiation of a class's dependencies. Rather than instantiating it's dependencies directly (i.e. with the `new` operator), dependencies are *injected* at runtime.</div>

<div class="analogy note">
CD Players are *dependent* on CDs but they are not built in mind for a single specific CD. That would get boring quickly. You can *inject* the CD into a CD player and each injection will result in a different song heard. The only requirement is that you must inject a CD</div>
        

**Demonstrate Dependency Injection By Hand**                                

- Demonstrate that the class initially holding the dependency cannot be easily unit tested.
- Using constructor injection, demonstrate dependency injection by passing in the dependency as an argument. 
- Demonstrate testing a class using DI by passing in a *Test Double* class.

**Dependency Injection Container**

<div class="definition note">
A <span>dependency injection (DI) container</span> is an object that knows how to instantiate and configure another object and its dependent objects.</div>

- When we set up a DI container, then everytime our code uses a constructor that calls for a particular type of interface, a pre-determined instance of a class impmlementing that interface is passed in.
- We will use DI containers during Module 3.
