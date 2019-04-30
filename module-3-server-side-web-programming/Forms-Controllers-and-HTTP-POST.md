# Forms - Controllers and HTTP POST

## Problem Statement

When we submit data through our forms, the browser automatically adds it to the querystring. This happens because it is used as HTTP GET.

This has worked well for us since we are searching for records or submitting inputs to calculators. These actions can be performed
multiple times.    

*If we wanted to actually modify data and we used HTTP GET, what could go wrong with this?*
- Sensitive data is made available
- Request can be bookmarked potentially making the data get modified multiple times
- Request may remain in the browser history and the user can go back to it
- Some browsers (older ones) limit URLs to 2083 characters. How would we complete a job employment application?

## Objectives

* HTTP POST
* Post-Redirect-Get
* Dependency Injection Review

## Outline

1. **HTTP POST**

    - POST is a request used to change data (add, update, delete) on the server
    
    - Changing the `<form method="post">` instructs the browser to set the request to the server via HTTP POST. 

    <div class="caution note">Repeatedly applying the same POST request could have an undesirable effect (e.g. ordering two of the same item)</div>

    - The structure of a POST request is similar to an HTTP GET except instead of using querystring parameters it uses a **request body**.

    <div class="definition note">A <b>request body or payload</b> is the data that is sent to the server by POST.</div>

    *Sample HTTP POST Request*
    ```
    POST /account/login HTTP/1.1
    Host: www.techelevator.com
    User-Agent: Mozilla/5.0
    Accept: text/html
    Content-Type: application/x-www-form-urlencoded
    Content-Length: 46

    username=john@techelevator.com&password=coding
    ``` 

-------

2. **Post Redirect Get**

    - Users are likely to reload the page

        - The browser notifies the user but they might still do this. They might have good reason 
            - Maybe they are waiting for a sale to occur
            - Maybe they're watching price updates occur

    <div class="definition note">

    **Post/Redirect/Get (PRG)** is a web design pattern that is intended to prevent duplicate form submissions.</div>

![PRG](resources/Post-Redirect-Get.jpg)

-------

3. **Implementing Post Redirect Get**

    - Create 3 Controller Methods/Actions
        - 2 Views
        - 1 Redirect

    - Use Attributes to indicate what type of request the Controller should expect (GET vs. POST)
    



## Real World Usage Scenarios

1. Login Form
2. Application Form (Loan, etc.)
3. Employment Application Form
4. Social Media Status Post


