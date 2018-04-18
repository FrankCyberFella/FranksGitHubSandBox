<link rel="stylesheet" type="text/css" media="all" href="./styles/style.css" />

# Command-Line Programs - Lecture Notes
###### (04/12/2018)

## Classroom Preparation

* None

## [**Overview of Session**](http://book.techelevator.com/java/command-line-programs/01-intro.html) 

The programs we've written up until now have been one-way, we haven't allowed the user to enter any input of their own and process it.

One of the ways that we can improve upon this is by allowing the user to enter commands or inputs from the keyboard that influence the execution
of our programs.

## **Customary schedule for session:** 

* [Stdin / Console.ReadLine()](http://book.techelevator.com/java/command-line-programs/05-using-standard-streams.html)
* [Parsing Strings](http://book.techelevator.com/java/command-line-programs/15-parsing-strings.html)
* [A Fun Program!](http://book.techelevator.com/java/command-line-programs/25-pulling-it-together.html)

## **Session Objectives:** 

## **Topic List w/Notes** <div class=topicNote>(and <span class='link'>links</span> to e-book section when available)</div>

### [Standard I/O](http://book.techelevator.com/java/command-line-programs/05-using-standard-streams.html)

### Reading from StdIn / Console.ReadLine()

Often we may want to pause the execution of the program and wait for the user to provide input. Another approach to allowing user input is by using
`StdIn` or `Console.ReadLine()`. 

<div class="java note">Stdin and Stdout refer to the standard input and output streams. The stdin is the keyboard and the stdout is the monitor/terminal.</div>

<div class="csharp note">Console.ReadLine and Console.WriteLine are abstractions that exist in order to interact with the standard input/output stream.</div>

[Reading Intellisense](http://book.techelevator.com/java/command-line-programs/10-reading-intellisense.html)

### [Parsing Strings](http://book.techelevator.com/java/command-line-programs/15-parsing-strings.html)

* What data type is the input from the command line?
* How do we allow users to enter numbers, dates, times, decimals, etc.?

<div class="definition note">Computers <strong>parse</strong> input and look for symbols that follow an expected syntax or set of rules.</div><br/>

A parse method is available to Java and C# developers that is able to convert a string into the correct data type.

<div class="caution note">If the input string cannot resolve the input to the correct data type, then our program fails and display an error msg to the user</div><br/>

```
//Java
Integer.parseInt(string s);
Long.parseLong(string s);
Double.parseDouble(string s);
Boolean.parseBoolean(string s);

//C#
int.Parse(string s);
bool.Parse(string s);
double.Parse(string s);
decimal.Parse(string s);
char.Parse(string s);
```

> ## Instructor Led Exercise
> 1. Build an application that allows the user to enter a bunch of numbers and calculate the age.
>
>## Instructor Led Exercise
>- [This Link Does not seem to work - .NET Lecture](https://bitbucket.org/te-curriculum/m1-csharp-command-line-input-lecture/)
>

## Student Exercises (Individual & Pair)
- [Java Individual Exercises](https://bitbucket.org/te-curriculum/m1-java-command-line-programs-exercises)
- [Java Pairs Exercises](https://bitbucket.org/te-curriculum/m1-java-command-line-programs-exercises-pair)
- [Java Individual Exercises Solutions](https://bitbucket.org/te-curriculum/m1-java-command-line-programs-solutions)
- [.NET Individual Exercises](https://bitbucket.org/te-curriculum/m1-csharp-command-line-input-exercises)
- [.NET Pairs Exercises](https://bitbucket.org/te-curriculum/m1-csharp-command-line-input-exercises-pair)
- [.NET Individual Exercises Solutions](https://bitbucket.org/te-curriculum/m1-csharp-command-line-input-solution)



## References
N/A