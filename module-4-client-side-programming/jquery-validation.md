# Client Side Validation w/jQuery

## Problem Statement

Javascript's most common use is providing client-side validation, indicating to users that their submission data is incorrect before it gets submitted.

## Classroom Preparation

* Javascript Object Literal

## Daily Objectives

* Javascript Objects
* Client Side Validation
* Cover Common Validation Techniques
* jQuery.Validation library
* Create Custom Validation 

## Notes and Objectives

### Javascript Objects

The validation library we use and many other libraries are reliant on this concept of Javascript Object Literals.

<div class="definition note">

Javascript objects are a collection or properties and a property is an association between a name (key) and value. A value can be:
- primitive type
- another object
- a function
</div>

1. Creating objects
    * use the `new` operator
    * declaring an object literal

<div class="definition note">

A **Javascript object literal** is a comma-separated list of name-value pairs wrapped in curly-braces.</div>

2. Rules for working with objects
    * Properties are accessed and set using dot notation.
    * Unassigned properties are `undefined`
    * Properties can be accessed or set using bracket notation.        

3. Iterating through an object's properties using `for (var i in obj)`

### Client Side Validation

<div class="definition note">
    Any type of validation typically checks for at least one of the following conditions to be true
    <ol>
        <li>Required data for a field has been provided.</li>
        <li>Data is in an acceptible input format.</li>
    </ol>
</div>    

1. *Why would we validate client-side if we are already validating server-side?*
    * make it easy for users to resolve improper data
    * limit number of invalid requests the client sends to the web server

<div class="caution note">

**Client side validation does not protect against everything**. Disabled client validation, HTTP requests, or man in the middle attacks can still serve a threat.</div>

<div class="definition note">

A **man in the middle attack** occurs when the HTTP request is tampered with after client-side validation has occurred.</div>

[**What It's Like Only Offering Client Side Validation**](http://i.imgur.com/GluNcro.jpg)

### Common Validation Methods & Techniques

1. What are some common validation methods?
    * Required field has a value
    * Field has max/min length met
    * Date/Time is correct format
    * Date/Time is in correct range
    * Numbers Only
    * Letters Only


#### Applying Validation
    
```javascript
$("#form").submit(function(e)) {
    //check at each field for required
    //code to check each field for format
    //if fail then prevent form submission
});
```

* after fields change values
```javascript
$(".phone").blur(function(event)) {
    // get the value
    var value = $(this).val();
    // apply phone validation logic    
});
```    

1. **What's the challenge here?**
    * repetitive code
    * tedious
    * prone to error

### jQuery Validation Library

* Including the jQuery Validation Library via the CDN
    1. http://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.js
    2. http://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.js for additional validation methods     

* [jQuery Validation Library Reference][3]

<div class="definition note">A <strong>validation rule</strong> associates an element with a method of validation (e.g. "#primary-email" is <em>required</em> and <em>a valid email</em>)</div>

Link to **[jQuery Validation Home Page][1]**

### Extending the jQuery Library

In the jQuery library, the `validate()` method returns a `Validator` object. This object has a public method `addMethod()` that can be used to add a custom validation method

`$.validator.addMethod`


### Extending the jQuery Validation Library

We can easily extend the library with our own validation rules should one not exist that we need.

In the jQuery library, the `validate()` method returns a `Validator` object. This object has a public method `addMethod()` that can be used to add a custom validation method

Link to **[jQuery Additional Library Reference][2]**


## Instructor Led Exercises

- [Lecture Examples](https://bitbucket.org/te-curriculum/m4-client-side-validation-lecture)

## Individual/Pair Exercises

- [Java Exercises - History Geek](https://bitbucket.org/te-curriculum/m4-java-historygeek-exercises)
- [C# Exercises - History Geek](https://bitbucket.org/te-curriculum/m4-csharp-history-geek-starter)




[1]:http://jqueryvalidation.org/
[2]:https://github.com/jzaefferer/jquery-validation/tree/master/src/additional
