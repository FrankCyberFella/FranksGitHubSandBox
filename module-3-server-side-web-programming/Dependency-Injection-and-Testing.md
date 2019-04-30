# Data Access Objects

## Problem Statement
We have already seen that programming to interfaces can lead to flexible and reusable code:

- The `transfer` method of `BankAccount` could be applied to either `SavingsAccount` or `CheckingAccount` instances.
- The Spring MVC `ViewResolver` can be replaced by different implementations transparently
- The Spring MVC model is provided as a `Map`, but we don't know or care what implementing class of `Map` it is.

How is this accomplished?  

Discussion: *Review of Polymorphism and it's benefits.  Namely, how Polymorphism allows us to solve problems in a generalized way.*

Discussion: *Consider the DAO pattern. We have seen several examples of a DAO object encapsulating the code related to reading and writing to a file. This has decoupled other code (e.g. our controllers) from the details of storing and retrieving data from a file.*

Discussion: *We have learned that unit testing is supposed to be done in isolation of external dependencies.  What about the case of our controllers that call a DAO, are there any complications to unit testing there? How might we make our controller more testable?*

## Lesson Objectives
- Define Inversion of Control (IoC) and Dependency Injection
- DI Example
- Finish Shopping Cart Application
- Design Single Product Page
- DAO Pattern
- Spring Dependency Injection

## Outline

1. **Dependency Injection**
    - **Inversion of Control**
        <div class="analogy note">"Don't call us, we'll call you." - Hollywood Principle</div>

        - [Inversion of Control](http://martinfowler.com/bliki/InversionOfControl.html) is a design principle utilized by many frameworks. In fact, it is the fundamental difference between a *framework* and a *library*.
        
        - Refers to the fact that *outside code* is in control in the sense that it invokes the code we write, rather than the other way around.
        
        - Example: *The MVC framework invokes our controllers in response to HTTP requests. Our code does not invoke the framework.

        - Tightly coupled code with dependencies is a liability.
        
    - **Dependency Injection**
        <div class="definition note"><span>Dependency Injection</span> is an application of *Inversion of Control* to the instantiation of a class's dependencies. Rather than instantiating it's dependencies directly (i.e. with the `new` operator), dependencies are *injected* at runtime.</div>

        - Classes that are designed to be used with Dependency Injection do not instantiate collaborator objects.  Instead, these collaborators are instantiated by the "Depedency Injection Container" and provided as contstructor arguments or by calling *setter* methods.
        
        - The benefit of this with regard to testing is that versions of the collaborator objects suitable for testing can be injected for purposes of unit testing. This can help to decouple a class from outside resources.

        <div class="analogy note">CD Players are *dependent* on CDs but they are not built in mind for a single specific CD. That would get boring quickly. You can *inject* the CD into a CD player and each injection will result in a different song heard. The only requirement is that you must inject a CD</div>        

2. **Dependency Injection By Hand**

3. **Dependency Injection By Container**

    - When code is complex enough, we look to leverage a dependency inversion container library

    - A DI container can create objects for us on demand. It is plugged into the instantiation process.

    <div class="csharp note">At this point **NuGet packages need to be introduced**. Indicate that the entire MVC framework is built on packages as application dependencies. Whenever the application is built, any missing dependencies are downloaded.</div> 

## Individual/Pair Exercises


## Student Reading

### Required Reading
| Applies To | Reading Link |
|------------|--------------|
| .NET | Read [Creating Unit Tests for ASP.NET MVC Applications](http://www.asp.net/mvc/overview/older-versions-1/unit-testing/creating-unit-tests-for-asp-net-mvc-applications-cs) |
| Both | Read [A Beginners Guide to DI](http://www.theserverside.com/news/1321158/A-beginners-guide-to-Dependency-Injection) 



### Cheat Sheets & References
| Applies To | Reading Link |
|------------|--------------|
| | |


## Instructor References



## Quiz

| Class | Socrative Quiz | Answer Sheet |
| ----- | -------------- | ------------ | 
| C#  |  |   |
| Java  |    |   |