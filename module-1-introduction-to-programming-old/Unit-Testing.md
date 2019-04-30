<link rel="stylesheet" type="text/css" media="all" href="./styles/style.css" />

# Unit Testing - Lecture Notes
###### (04/17/2018)

## **Session Objectives:** 

* Be aware of the pros and cons associated with Manual and Automated testing
* State the difference bewtween Exploratory and Regression testing
* Describe the relationship between Unit, Integration and Acceptance testing
* Explain the components and characteristics of good Unit Testing
* Effectively perform Unit Testing on code they develop
* Utilize a testing framework such as JUnit in the performance of Unit Testing
* Discuss the concept of code coverage

## **Classroom Preparation**  
* None

## **Overview of Session** 
Large software systems can get complex and the smallest changes can have unintended consequences. At the same time, agile software development requires rapid iteration and an ability to change.

*How do we verify that the components of code that we write are correct and that changes don’t cause unintended consequences?*

## **Customary schedule for session:** 

* Software Development Lifecycle
* Testing Overview
* Unit Testing
* Tests With xUnit
* Code Coverage

## **Topic List w/Notes** <div class=topicNote>(and <span class='link'>links</span> to e-book section when available)</div>

### Software Development Lifecycle

Typically before beginning the lecture on Testing, it is important to indicate to students the > full SDLC and the various phases.

Indicate the difference between Waterfall and Agile mainly. ([Link that comparess Waterfall vs Agile](https://www.guru99.com/waterfall-vs-agile.html))


### Software Testing Overview
    
1. **Manual vs Automated Testing**    [Link to comparision](http://www.base36.com/2013/03/automated-vs-manual-testing-the-pros-and-cons-of-each/)
- *What are the strengths of human testers?*
- *What are the strengths of computers?*
        
2. **Manual Testing**
    - Creativity
    - Can evaluate subjective qualities (e.g. user friendly)
        
3. ***Automated Testing***
    - Speed / Efficiency
    - Lower cost of execution
    - Accuracy
    - Dependability / Repeatability


4. **Exploratory vs Regression**
      
    <div class="definition note"><span><strong>Exploratory Testing</strong></span> explores the functionality of the system looking for defects, missing features, or other opportunities for improvement.  Almost always manual.</div><br/>

    <div class="definition note"><span><strong>Regression Testing</strong></span> validates that existing functionality continues to operate as expected. </div>
      
5. **Unit, Integration, and Acceptance Testing**
    - As you progress from Unit Testing -> Integration Testing -> Acceptance Testing:
    - longer runtime 
    - more expensive to write
    - harder to troubleshoot
    <br/><br/>
    <div class="definition note"><span><strong>Acceptance Testing</strong></span> is performed from the perspective of a user of the system in order to verify that the functionality of the system satisfies user needs.</div><br/>
      
    <div class="definition note"><span><strong>Integration Testing</strong></span> is a broad category of tests that validate the integration between units of code or code and outside dependencies such as databases or network resources.</div><br/>
      
    <div class="definition note"><span><strong>Unit Testing</strong></span> is low level of testing performed by programmers that validates individual “*units*” of code *function as intended by the programmer*.  Always automated.</div>    
      

6. **Other Types of Testing**
    - Discussion: *What kinds of things other than application functionality might we test for?*
    - Performance / Scalability
    - Security
    - Usability
    - Accessibility
    - Portability / Compatibility

7. **Who Does Testing?**
    Dedicated software testers, different skill sets, QA vs. QC

### Introduction to Unit Testing

1. **Reasons for Unit Testing**
   - Large software systems can get complex
   - Encourages programmers to think of corner cases
   - Changes can have unintended consequences
   - Agile software development requires rapid iteration and ability to change
        
2. **Unit Tests Should Be:**
    - Fast - elapsed time of running a unit test should be measured in milliseconds
    - Reliable / Repeatable - if a passed/failed once, it should pass/fail again, assuming no code changes
    - Independent - a test should be able to be run independently of other tests and tests should not have interactions with one another
    - Obvious - easy to determine why it failed

3. **General Structure of a Test**
    - Arrange begin by arranging the conditions of the test, such as setting up test data
    - Act  perform the action of interest, i.e. the thing we're testing
    - Assert validate that the expected outcome occurred by means of an assertion (e.g. a certain value was returned, a file exists, etc)
    
4. **Unit Testing Best Practices**
    - No external dependencies
    - One *logical* assertion per test (i.e. each test should only contain one "concept")
    - Test code should be of the same quality as production code
        
### Implementing Tests With xUnit


- Introduce unit testing framework
- How to organize tests
- Each method is a test
- Naming conventions
    
### Code Coverage
[Link to description of Code Coverage](https://confluence.atlassian.com/clover/about-code-coverage-71599496.html)

## Instructor Led Exercises

- [Java Lecture Code](https://bitbucket.org/te-curriculum/m1-java-unit-testing-lecture)
- [.NET Lecture Code](https://bitbucket.org/te-curriculum/m1-csharp-unit-testing-lecture)

## Student Exercises (Individual & Pair) 

- [Java Exercises](https://bitbucket.org/te-curriculum/m1-java-unit-testing-exercises)
- [.NET Exercises](https://bitbucket.org/te-curriculum/m1-csharp-unit-testing-exercises)



## References
N/A
