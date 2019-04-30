# Selenium

## Problem Statement

Most software applications are written as web-based applications. Many companies are requiring
that test automation be implemented for projects.

We've learned how to write
- unit tests for single classes
- integration tests for components that integrate with dependencies

We also want the ability to perform repeatable tests (regression) on our web applications.

**Test Automation** lets us use a software tool to write these repeatable tests.

## Lesson Objectives

- Selenium
    - WebDriver
    - Reading a Web Page
    - Simulating User Actions
- Page Object Pattern

## Notes and Examples

### Selenium

<div class="definition note">

Selenium is a **tool suite** used to automate web applications.</div>

Its primary purpose is for testing purposes but it is also useful for automating administrative tasks.

It has support from major browsers and operating systems including
- Firefox
- Internet Explorer
- Safari
- Chrome

It is supported by many programming languages including C#, Java, JavaScript

#### WebDriver

<div class="definition note">

**Selenium WebDriver** exposes an API that allows programs to drive a browser the way a user would.</div>

- Webdriver easily integrates with unit testing frameworks.

- There are multiple implementations of the `WebDriver` interface. There is a driver implementation available for each major web browser: Chrome, Firefox, Safari, Internet Explorer, and Edge.

    - For Java there is also the HtmlUnit driver which is a Java library that provides a "headless" browser which is *much* faster than any of the other drivers.

**Example:**
```
WebDriver driver = new FirefoxDriver();
```

> ##### Java
> To install the ChromeDriver on Mac OSX:
> 
> ```
> cd ~/dev-tools/;mkdir chromedriver;cd chromedriver;curl -O http://chromedriver.storage.googleapis.com/2.25/chromedriver_mac64.zip
> unzip chromedriver_mac64.zip 
> rm chromedriver_mac64.zip 
> ```

> ##### .NET
> To install the ChromeDriver:
> 
> ```
> install-package Selenium.Webdriver
> install-package Selenium.Chrome.Webdriver
> install-package Selenium.Support
> ```

#### Reading a Web Page
- **Fetching a Page**

    ```
    driver.get("http://www.techelevator.com");
    ```

- **Locating an element**
    - By Id
    - By Class Name
    - By Tag Name
    - By Name
    - By Link Text
    - By XPath
- **Reading Element Content**

#### Simulating User Actions

- Clicking a link
- Entering text into a form
- Submitting a form

### Page Object Pattern

- **Challenges with developing one-off test automations**
    1. Changing a web page can require many different tests to update
    2. Tests that extend a lot of effort interacting with web driver can be brittle

<div class="definition note">

Page Object design pattern uses a "page object" to serve as an object-oriented interface to a web page for your application.</div>

- **Advantages**

    1. Clean separation between test code and page specific code.
    2. Creates a single repository of operations offered by the page.
    3. Allows all modifications to the UI to be made in one place in our code base. 

- **Page Object Pattern Guidelines**

    1. Public Methods represent the *services* that the page offers.
    2. Avoid exposing the internals of the web page.
        - Internals of the page are likely to change more than the service it offers.
    3. Methods can return other page objects (e.g. another page)
        - This should simulate a user progressing page by page.
    4. The page object doesn't need to represent the entire page
    5. When there are different results for the same action, then create different/separate methods.

**Reference**: http://www.seleniumhq.org/docs/06_test_design_considerations.jsp#page-object-design-pattern

### Installing ChromeDriver

All major web browsers have built-in support for Selenium automation. To use Chrome with Selenium, you need to install a ChromeDriver executable.

#### Java

To install the Selenium ChromeDriver:

1. [Download](https://sites.google.com/a/chromium.org/chromedriver/downloads) the ChromeDriver executable.
2. Create a directory `~/dev-tools/chromedriver` and extract the ChromeDriver executable into that directory.

## Code

### Lecture

- [Java Lecture](https://bitbucket.org/te-curriculum/m3-java-selenium-lecture)
- [.NET Lecture](https://bitbucket.org/te-curriculum/m3-csharp-selenium-lecture)

### Student Exercises

- [Java Individual Exercises](https://bitbucket.org/te-curriculum/m3-java-ssg-test-exercises)
- [C# Pair Exercises](https://bitbucket.org/te-curriculum/m4-csharp-history-geek-starter)