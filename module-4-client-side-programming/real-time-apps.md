# Real Time Applications 

## Problem Statement

What are the limitations of the out of the box client-server architecture? With request/response we rely on the clients to check the server periodically for updates. Perhaps we want the clients to receive this information as soon as it is available.

## Daily Objectives

* Polling
* Web Sockets


## Notes and Examples

### Long Polling

<div class="definition note">

With **long polling** the client application sends a request to the server via HTTP. The web application repeatedly checks the 
database until the status changes or update appears. When the state change the client gets the server responose.

</div>

**Pros**

* Single request from client to server
* Client receives immediate response from server when update occurs

**Cons**

* Server keeps the request active the entire time, consuming resources
* Client may abandon leaving the server processing the request

### Short Polling

<div class="definition note">

With **short polling** the client application will use a timer and asynchronously send requests to the server. The server always responsds. The response may include updated content or no content.

</div>

**Pros**

* simple request/response format
* consumes less server resources than long polling if the server response is fast

**Cons**

* high latency
* finding optimal interval to send requests

> Example
>
> `setInterval(function() { }, 3000);`

### Web Sockets

<div class="definition note">

**Websockets** are bi-directional, full-duplex, persistent connections that a client and a server. The browser can send data to clients without being solicited while allowing the client to send requests to the server as well.

</div>

After the handshake, if approved:

- the connection is upgraded from HTTP Connection to a Websocket Connection
- data is transferred through an open socket as *messages*

**Pros**

* Allows server ability to trigger messages to send to connected clients on demand
* Application data is always up to date
* No more polling

**Cons**

* Server needs to support clients for the duration they are on a web page
* Requires in the largest sense to scale out, not up

http://blog.teamtreehouse.com/an-introduction-to-websockets

## Instructor Led Exercises

- [Java](https://bitbucket.org/te-curriculum/m4-java-realtime-apps)
- [.NET](https://bitbucket.org/te-curriculum/m4-realtime-apps)

##Individual/Pair Exercises

- [Java Exercises - History Geek](https://bitbucket.org/te-curriculum/m4-java-historygeek-exercises)
- [C# Exercises - History Geek](https://bitbucket.org/te-curriculum/m4-csharp-history-geek-starter)

