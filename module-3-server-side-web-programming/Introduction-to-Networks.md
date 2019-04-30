# Introduction to Networks

## Problem Statement

How does the internet work? When I type a URL in the browser, what is the process?

## Lesson Objectives

- URLs
- Internet Protocol
- Domain Name System
- Port Numbers
- HTTP vs. HTTPS
    - GET Request
    - Querystring Parameters
- Anchors

Break

- Hosting Provider
    - Self-Hosted
    - Shared
    - Dedicated
    - Cloud
- Web Servers
    - Web Server
    - Application Server
- Domain Registrar



## Notes and Examples

1. **What happens when I type in `www.google.com` in a browser?**
    - What is the structure of a URL?
    - ![Anatomy of a URL](resources/anatomy-of-a-url.png)
    - Important points: protocol, domain, tld
    - How does our computer determine where to go to access that file?

------

2. **Internet Protocol**
    - When a client makes a request, it needs to know where to send it.
    - An **IP Address** identifies a host on a network.    
    
    <div class="analogy note">
    IPv4 is 32 bits allowing for 4,294,967,296 addresses.

    IPv6 is 128 bits allowing for 3.4 * 10<sup>38</sup> addresses.
    </div>

    Sample IPv4 Address: 192.168.51.81

    Sample IPv6 Address:  fe80:0000:0000:0000:c0b5:30b7:3fd7:e2a4
    Two colons (::) represent consecutive sets of zeroes: fe80::c0b5:30b7:3fd7:e2a4

    - How do we check our local IP?
    - [What's My IP?](http://www.whatsmyip.org/)
    - ipconfig via command line
    - `127.0.0.1`

------

3. **Domain Name System**
    - A Domain Name System (DNS) service is used because IP Addresses are not easy to remember.
    - The domain name is composed of several parts, each delimited from one another by a `.` (period).
    - `ping www.techelevator.com` and see the IP Address is **198.49.23.144**
    - `.com, .net, .org`, etc are referred to as **Top Level Domains (TLD)**. These used to be carefully regulated, but it was opened up to anyone who wanted to create a TLD now can. There are hundreds of there now.
    - The parts preceding the TLD are referred to as **subdomains**.
    - Each subdomain can reference a different IP address.

------

4. **Port Numbers**
<div class="definition note"><span>Port numbers</span> are used to identify which program is supposed to handle a request.</div>
    - Range is 0 - 65535.
    - Added after ":" in IPv4
    - In IPv6, wrap address in [], then add colon and port -- [fe80::c0b5:30b7:3fd7:e2a4]:80
    - Ports in the range of 1023 are *well-known* by specific applications
        - Port 80 for HTTP		(web server)
        - Port 443 for HTTPS	(secure web sever - HTTP over SSL)
        - Port 25 for SMTP		(Simple Mail Transport Protocol)
        - Port 21 for FTP		(File Transfer Protocol)
    - We could specify the port in the URL, but we don't have to. Why not?

------

5. **HTTP & HTTPS**
    - HTTP (HyperText Transfer Protocol) is how browsers and web servers communicate with one another.
    - Defines a simple request/response protocol, **inherently over port 80 or 443**
    - **Key Elements of an HTTP Request**
        - The HTTP Method (GET, PUT, POST, DELETE)
        - The Page to Access
        - Form Parameters
    - **Key Elements of the Response Stream**
        - An HTTP status Code
            - 1xx Informational
            - 2xx Success (200 OK)
            - 3xx Redirect (301 Moved Permanently)
            - 4xx Client Error (400 Bad Request, 401 Unauthorized, 403 Forbidden, 404 Not Found)
                - [Google Error Page](https://www.google.com/intl/en/landing/nose/help.html)
                - [AirBnB](https://www.airbnb.com/404)
                - [Magnt](http://www.magnt.com/404/)
                - [Random Russian Site](http://proteys.info/404/)
            - 5xx Server Error (500 Internal Server Error, 501 Not Implemented)
        - Content-Type (picture, text, html, etc.)
        - Content (HTML, image, etc.)        
    - **`telnet www.w3.org 80`**
        - Notice its all text that comes back.
    - Browsers create HTTP GET requests anytime you enter a URL, click on a link, view an image, PDF, etc.
    - GET is likely the most common HTTP method used on the Web.
    - When you type a URL into your web browser, it executes an HTTP GET.
    - By convention, GET is a *safe method*, because the server takes no further action other than simply returning the requested information.    
    

<div class="definition note">
<span>Resources</span> can be HTML pages, images, sound files, stylesheets, PDF documents, etc. Anything served from a server.
</div>

<div class="definition note">
<span>URL</span> is a *uniform resource locator* and is used to retrieve any published resource on the web.
</div>

--------

6. **Querystring Parameters**
    - How does our Google Search input get to Google?
    - Querystring parameters allow us to add additional inputs.
    - **Parameters** are represented in key/value pairs with the & symbol.
    - **Anchor** the anchor is a specific part of the resource and represents a bookmark in the document. Also abstracted by front end frameworks, much like the file path.

-------

7. **Hosting Providers**
    - A hosting provider is used to allow us to *serve* up content over a network.
        - Self Host
        - Shared Hosting Provider
        - Dedicated Host
        - Cloud Host    
    - What are the upsides/downsides?
    - What are some examples? 
        - Amazon, Azure, Google, GoDaddy, HostGator, Wordpress, SquareSpace
    

<div class="definition note"><span>Client</span> a generic term used to describe anything making a request.</div>
<div class="definition note"><span>Web Servers</span> receive the <b>request</b>, finds the resource, and returns a response to the user.</div>  

-------

8. **Web Servers & Application Servers**

    - **Web Servers** are good for serving up web resources that are static content
    - **Appliation Servers** are for generating dynamic web pages
        - IIS, Tomcat, Apache
    
-------

9. **Domain Registrar**
    - A domain name can be leased from a DNS Registrar. Popular and easy to use registrars are godaddy.com, hover.com or Google's domains.google.
        - What you lease is a subdomain of the TLD you choose. Tech Elevator leases the domain techelevator.com. 
        - You can then create as many subdomains of that leased domain as you want. Tech Elevator can now create www.techelevator.com, blog.techelevator.com, demo.techelevator.com, instructors.techelevator.com; all of those pointing to different IP addresses.
    - google domains, hostgator, godaddy

<div class="definition note"><span>Top-Level Domain</span> refers to the last part of the domain such as .net, .com, .gov, etc.</div>


## Instructor Led Exercises

n/a

## Individual/Pair Exercises

Set up a GitHub page. If you also want to get a domain, you can point that to the GitHub page as well. This is independent study, so go look up the documentation and get a simple webpage or your HTML resume up on the internet and then submit the link to your instructor.


## References
- [HTTP Request](https://www.w3.org/Protocols/rfc2616/rfc2616-sec5.html)

