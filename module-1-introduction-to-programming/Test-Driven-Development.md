<link rel="stylesheet" type="text/css" media="all" href="./styles/style.css" />

# Test Driven Development - Lecture Notes
###### (04/18/2018)

## **Session Objectives:** 

* State the potential disadvantages of conducting unit testing at the end of the development cycle
* Describe the concept of [Test Driven Development (TDD)](http://agiledata.org/essays/tdd.html) and it's benefits
* Be aware of the "Circle of Life" for Test Driven Development
* Explain the concept of refactoring and some simple techniques for its accomplishment
* Design a basic strategy for Test Driven Development

## **Classroom Preparation** 

* None

## **Overview of Session** 

When faced with a complex or difficult feature to develop, thinking about the problem entirely up front can consume a significant amount of time.

The agile mantra focuses on rapid iterative changes to see progress in the right direction. If we write code that we "think is right" 100% and then 
write unit tests, what are we likely to do? 

Could we take a different approach and develop a test first that dictates what outcome we want to occur or expect?

## **Customary schedule for session:** 

* Test Driven Development
* Refactoring
* TDD Strategy
* Katas


## Instructor Led Problem
>
>1. Convert Arabic to Roman Numerals
>
><div class="questionAboutContent" >???Frank: Is there a model solution for this somewhere>???</div>

## **Topic List w/Notes** <div class=topicNote>(and <span class='link'>links</span> to e-book section when available)</div>

1. **Unit Testing**
<div class="definition note">

**Unit Testing** relies on code that validates the correctness of our program using some assumptions.
</div>

2. **What are outcomes of unit testing last?**
    - biased results
    - run of time
    - likely to ignore or miss some of the tests

3. **Test Driven Development**
    
<div class="definition note">

**Test Driven Development** is a development methodology where developers write a feature test that initially fails before writing production
code that implements the feature.
</div><br/>

[Link to information on Test Driven Development](http://agiledata.org/essays/tdd.html)

3. **TDD Benefits**
    - Program for specific conditions 
    - Baby steps towards solving a problem, incrementally adding code
    - Refactoring with new patterns
    - Previous tests hold value with each modification

4. **TDD Circle of Life**
    1. Write failing test
    2. Make test pass with minimum code
    3. Refactor

![TDD Circle of Life](resources/tdd-circle-of-life.png)


5. **About Refactoring**

<div class="definition note">

**Refactoring** introduces modifications to the code intended to improve the structure or design without changing functionality.</div><br/>
[Link to Refactoring Techniques](http://agiledata.org/essays/tdd.html)

 
6. **Simple Ways to refactor**
    * Eliminate duplicate code
    * Extract a method by breaking down long difficult methods
    * Extract complex operations to variables
    * Introduce constants for magic numbers
    * Simplify conditional expressions

### A General Strategy for TDD

1. Create a list of tests needed. 
2. Start by writing just enough test code
3. Always run the test to see it fail in the way you expect
3. Write enough code to make the test build
4. Write enough code to make that test pass (possibly by faking it).
5. When the implementation is obvious then that can be typed in but go back to #4 if not
5. Generalizing the code by eliminating code duplication or reducing dependencies

TDD allows developers to write code in ultra-small steps. Its not necessarily practical but it helps when trying to troubleshoot or develop a complex feature.


## Instructor References

* [Refactoring Techniques](https://sourcemaking.com/refactoring) 
