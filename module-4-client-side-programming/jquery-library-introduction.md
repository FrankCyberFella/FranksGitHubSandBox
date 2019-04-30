# Javascript Library & jQuery Introduction

## Problem Statement

JavaScript is more useful when it allows us to interact with the content on the page, hiding and showing elements, toggling them on and off.

## Lesson Objectives

* The DOM
* Manipulating the DOM (w/JavaScript & jQuery)
* $() functions

## Notes and Examples

1. **The DOM**

    - It's not the page source
        - The best representation is the markup that shows up in the Chrome Debugger

    - As developers we need to often
        - look for an element with JavaScript
        - find an element's parents, siblings, children
        - add/remove css classes via JavaScript
        - add/remove elements from the page
        - **this is manipulating the DOM**

    - Sometimes demonstrating this through the debugger and the console shows how it can be manipulated

<div class="definition note">

The Document Object Model (DOM) is the programming interface for HTML documents that are loaded into the browser. It provides us a way for 
accessing and manipulating the structure, style, and content once loaded.</div>
    

2. **Manipulating the DOM w/ jQuery**

```javascript
const element = document.querySelector("#main-content"); //<-- element representing #main-content
element.innerText = "Hello World!";
```

- Modifying the DOM can be verbose with vanilla javascript

- JavaScript libraries exist to make this easier to do
    - A **library** is a set of organized functions that help us solve a specific problem

- One of the more common JavaScript libraries is jQuery. 
    - It's used by bootstrap so you are likely to run into it on the job
    - jQuery receives support from IBM, Wordpress, Mozilla, Adobe, etc. Angular.

<div class="caution note">

One problem area that we have seen often is that we are introducing jQuery at students before they full understanding JavaScript. This is an area we are trying to experiment with and get them more comfortable. Focus on making sure that they realize they are still writing JavaScript</div>

3. **Including jQuery**

    1. Self-Hosted by downloading from [jQuery.org](http;//www.jQuery.org)
    2. Included Reference to a hosted CDN.

<div class="definition note">A Content Delivery Network (CDN) is a global distributed network of web servers that provide faster delivery of content.</div>

4. **$()**

    - The `jQuery()` method was aliased as `$()`
        - sometimes called the bling function
    - Accepts any argument that is a CSS selector and returns a jQuery DOM element(s) that represents that selector

    - The element can have any HTML or CSS property set on it
        - `.text()`
        - `.html()`
        - `.val()`
        - `.addClass('name')`
        - `.removeClass('name')`
        - `.hasClass('name')`
    
    - Creating a DOM element can be done with `$("<div>")`
        - Elements can be added/removed from the DOM
        - `.append()` adds the element as the last child in the jQuery collection (**inside**)
        - `.prepend()` adds as the first child in the jQuery collection. (**inside**)
        - `.before()` adds before each element in the set of matched elements. (**outside**)
        - `.after()` adds after each element in the set of matched elements (**outside**)
        - `.remove()` removes matched elements from the DOM
        - `.empty()` removes all child nodes from the DOM
        - `.detach()` removes from the DOM to be attached later




## Instructor Led Exercises

This lecture example involves the students filling in a set of functions that allow them to practice locating elements and then using the DOM to manipulate the identified element(s).

- [Lecture Examples](https://bitbucket.org/te-curriculum/m4-intro-jquery-and-dom-lecture)

## Individual/Pair Exercises

- [Java Exercises - History Geek](https://bitbucket.org/te-curriculum/m4-java-historygeek-exercises)
- [C# Exercises - History Geek](https://bitbucket.org/te-curriculum/m4-csharp-history-geek-starter)
