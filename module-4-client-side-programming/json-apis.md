# Javascript AJAX and External APIs 

## Problem Statement

Some web applications leverage the ability to communicate with other websites in order to create much more interactive experiences for the user.

Full web applications can be built leveraging another application's data without having to create the functionality ourselves.


## Daily Objectives

- Using JavaScript to call an API
- What is JSON?
- What is the difference between asynchronous and synchronous? 

## Notes and Examples


### 1. APIs

<div class="definition note">

An **API** is a programmatic interface that allows a system to encapsulate behavior and expose the ability to invoke it through a URL. Most APIs receive and respond with pure data, ignoring the overhead of responding with HTML.</div>

#### Example Applications that use APIs

1. A mobile application that relies on real-time data provided from a hosted Web API.
2. A web application that integrates with calendars may integrate with Google Calendar via its API.
3. A web or mobile application that focuses around location-based capabilities may rely on Google Maps or Google Directions API.

#### Example APIs

1. [**Microsoft Cognitive Services Face API**](https://www.microsoft.com/cognitive-services/en-us/face-api)
2. [**Microsoft Cognitive Services Emotion API**](https://www.microsoft.com/cognitive-services/en-us/emotion-api)
3. [**Microsoft Computer Vision API**](https://www.microsoft.com/cognitive-services/en-us/computer-vision-api)
4. [**Public List of APIs**](https://github.com/toddmotto/public-apis)


### 2. JSON

1. APIs often return data in the form of JSON.

<div class="definition note">

**JSON**, JavaScript Object Notation creates a minimal, readable format for structuring data and is primarily used to transmit data between a client and a server.</div>

**Representing JSON**

```javascript
var people = [{
    "name":"John Smith",
    "hometown":"Toledo, OH",      
},
{
    "name":"Jane Doe",
    "hometown":"Cleveland, OH"  
}];
```

* `JSON.stringify(object)` converts a Javascript value to a JSON string.
* `JSON.parse(text)` converts a JSON string to a Javascript value/object.

2. JSON creates properties using the **`"name":"value"`** and separates them by commas. 

3. Accessing these properties via JavaScript is similar to accessing JavaScript objects.


### 3. AJAX

1. Often it is not efficient for a computer to perform coding tasks sequentially.
    1. A program may need to wait for a long running operation to complete.
    2. The program may not need the operation to complete in order to proceed.


<div class="definition note">

**Asynchronous programming** allows code to run in parallel. Code blocks separate from the main application run and then notify the main *thread* upon their completion. **Synchronous programming** means the main *thread* will wait for a separate code block to complete before resuming.</div>

2. JavaScript sends HTTP request asychronously to a web server and then is notified when a response is received.

3. This term may sometimes be referred to as **AJAX**.

4. If provides:
    * a responsive experience for users (the screen doesn't freeze)
    * users don't need to manually refresh the screen to see changes
    * a small portion of the page can be updated



<div class="caution note">

A **cross-origin** HTTP request is a resource that requests a resource from a different domain than the one which the first resource itself serves.
Browsers restrict cross-origin HTTP requests initiated from within scripts. 

[Http Access Control (CORS)](https://developer.mozilla.org/en-US/docs/Web/HTTP/Access_control_CORS)
</div>

## Instructor Led Exercises

- [Lecture Code](https://bitbucket.org/te-curriculum/m4-json-apis-lecture)

##Individual/Pair Exercises

- [Java Exercises - History Geek](https://bitbucket.org/te-curriculum/m4-java-historygeek-exercises)
- [C# Exercises - History Geek](https://bitbucket.org/te-curriculum/m4-csharp-history-geek-starter)

