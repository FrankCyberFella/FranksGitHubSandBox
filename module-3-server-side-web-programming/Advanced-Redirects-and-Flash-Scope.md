# Advanced Redirects with Redirect Data

## Problem Statement

In certain circumstances, we need to display a notification or screen to the user after they've performed a certain action.

- After placing an order, I should see the order confirmation screen.

HTTP is mean to be as stateless as possible, so when the browser implements the POST-REDIRECT-GET pattern because the server indicates REDIRECT. When the user is redirected to the 
confirmation page, how does the server know which page to display to them?

## Objectives

- Post/Redirect/Get
- Temporary Data / Flash Scope

## Notes and Examples

### **Post Redirect Get**

- *When we modify state through HTTP POST, what types of things could go wrong?*
    - Double form submission (credit card, purchase, transfer, etc.)

<div class="definition note">

**Post/Redirect/Get (PRG)** is a web design pattern that is intended to prevent duplicate form submissions.</div>

![PRG](resources/Post-Redirect-Get.jpg)

### Temporary Data / Flash Scope

1. HTTP is stateless and therefore all data must be sent through the HTTP GET request as route values for the URL.

2. Session can preserve state if necessary but a web application should avoid abusing them and be as stateless as possible.
    1. **Not Guaranteed** - not guaranteed because they time out
    2. **Session Pollution** - developers might store values that contradict in session
    3. **Gained Savings** - good when there is opportunity to save database queries looking up same data over and over

| Temporary Data / Flash Scope | Session |
|------------------------------|---------|
| Persists data for the duration of a single request. | Stores data until the user session expires. |
| Valid only for subsequent request | Valid for all requests |
| Internally stored in a hidden session variable | |
| Used for storing one time messages, order ids, redirect information that can't be exposed with the GET request | Used to store long life data like user name, role permission, data which is user specific and required throughout the session |

<div class="caution note">

Temporary data and Session data <strong>both require type-casting and null checks</strong> to avoid run-time exceptions.</div>

## Important Links

1. [ASP.NET MVC In Practice](https://www.exceptionnotfound.net/mvc-in-practice-tempdata/)