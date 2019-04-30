# Sessions

## Problem Statement

HTTP is a "stateless protocol". This means that no state is maintained between requests. Each time a request is made, it's like the web server has amnesia has no 
memory of any prior requests it received from a client.

- *What challenges could this present if we never remember anything from our client*
    - Clients need to repeatedly provide credentials
    - A website never recalls our user preferences (preferred language, location)

## Objectives

- Stateless & Session
- How Sessions Work
- Using Sessions


## Outline

1. **What is Session?**

    - HTTP is "stateless"

    <div class="definition note">

    **Each request is an independent transaction** and is unrelated to previous requests.</div>

    - **Benefits**
        - limits storage
        - enables scalability
        - limits request size
    - **Disadvantages**
        - server needs to be told information with every request

2. **How is Sessions Used?**

    - Sessions are available inside of many web application frameworks.
    
    - Sessions typically work like a Dictionary, Map, Associative Array, etc.
    
    - Access to Session State is exclusive per session.


3. **How Session Works**

    <div class="definition note">

    An **HTTP session** is a sequence of HTTP request-response transactions.</div>   

    - Sessions are:
        - established when a user first connects to a website
        - torn down after a period of inactivity (i.e. auto-logout banking)      

    <div class="definition note">

    A **session token** is a unique identifier generated from the server and provided to the client to include throughout the interaction session.</div>


    <div class="analogy note">

    Session is like a coat check. You're given a coat check id so that when you come back to claim "your coat" you don't get someone else's. 
    
    Servers provide the clients with a token so that they automatically get the right session data.</div>

    <div class="definition note">

    A **cookie** is a small piece of data sent from a website and stored in the user's web browser while the user browses the site.</div>

    <div class="definition note">

    Many frameworks have a default time after which session expires. This is called **Session Timeout**</div>  

4. **What is Session Used For?**

    - Current logged in user
    - Current items in the shopping cart
    - Preferred customizations




## Real World Usage Scenarios

1. Shopping Cart
2. Login Remember Me
3. Multi-Page Web Form
4. Auto-Logout Banking




