<link rel="stylesheet" type="text/css" media="all" href="./styles/style.css" />

# File I/O - Writing Files - Lecture Notes
###### (04/18/2018)

## **Session Objectives:** 

* Successfully write to stream file
* Explain the concept of buffering as it applies to stream output files
* Be aware of the necessity to releasing resources when performing stream output.

## **Class Preparation**
* None

## **Overview of Session** 

This is a short day. It builds on top of the day prior when working with Reading File I/O.

There is an opportunity to get students to better understand the idea of an underlying stream, but for most they'll pick up the concept of writing out to a stream pretty easily.

Continuing on yesterday's discussion, when we work with files there are three basic operations:


## **Customary schedule for session:** 

1. Reading
2. Writing
3. Seeking

## **Topic List w/Notes** <div class=topicNote>(and <span class='link'>links</span> to e-book section when available)</div>

1. **Writing File I/O**
    - The most common class used to write content out to a file is the **StreamWriter** and the **PrintWriter**.
    - Other types of writers also exist: binary data, network data via memory stream

2. **Orders of Magnitude Performance**
    - In computing there is a significant difference (not always noticeable) between varying operations
    - [Computers are Fast](https://computers-are-fast.github.io/)
        - Demo: Computers are much faster with memory than RAM, which is faster than file and network
        

3. **File I/O Limitations**
    - Content is buffered and not saved (or cannot be seen) until the stream is *flushed* or *disposed*.

<div class="definition note">

Flushing a buffer means transmitting any accumulated character output to a file.
</div><br/>

4. **Forgetting to Close the Stream**
    - Forgetting to close the stream leaves it open in write mode.
    
<div class="analogy note">

Have you ever tried deleting a file only to be told that *this file is opened in another program*?
</div>


## Real World Usage Scenarios

* Logging
* Cleaning and sanitizing data inputs
* Transmitting data to external systems