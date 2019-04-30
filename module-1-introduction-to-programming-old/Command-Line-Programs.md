<link rel="stylesheet" type="text/css" media="all" href="./styles/style.css" />

# Command-Line Programs - Lecture Notes
###### (05/08/2018)

## [**Overview of Session**](http://book.techelevator.com/java/25-command-line-programs/01-intro.html) 

The programs we've written up until now have been self-contained, with all the data already specified in the program. But what if we want to interact with a user?

So how do we ask the user for information, turn that into data we can use and process and then send an answer back to the user for them to see?

## **Session Objectives:** 

* Students should be able to use System.in/System.out/Console.ReadLine() to perform console I/O in a program
* Students should be able to correctly parse input from the input to primitive data types
* Students should be able to explain the process of a command line application (Take input, calculate data, give output)
* Students should be able to run their command line apps in their IDE

## Classroom Preparation

* Think of a simple command line application that you can build in the class. Examples could be a program that takes three prices and a discount and tells you what the new prices are or a program that takes three words and turns them into Pig Latin. You can start with this example right from the beginning of class.
* Today is about reiterating this weeks major concepts, so feel free to throw in arrays and loops and if statements to help flesh that out.

## **Agenda and Timing for Session** 

* [System.in / Console.ReadLine()](http://book.techelevator.com/java/25-command-line-programs/05-using-standard-streams.html) (0:20)
* [Parsing Strings](http://book.techelevator.com/java/25-command-line-programs/15-parsing-strings.html) (0:10)
* System.out / Console.WriteLine() (0:20)
* [A Fun Program!](http://book.techelevator.com/java/25-command-line-programs/25-pulling-it-together.html) (The rest of class)

## **Topic List w/Notes** <div class=topicNote>(and <span class='link'>links</span> to e-book section when available)</div>

### [Standard I/O](http://book.techelevator.com/java/25-command-line-programs/05-using-standard-streams.html)

### Reading from System.in / Console.ReadLine()

Often we may want to pause the execution of the program and wait for the user to provide input. Another approach to allowing user input is by using
`System.in` or `Console.ReadLine()`. 

<div class="java note">

**Java:** System.in and System.out refer to the standard input and output streams. The System.in is the keyboard and the System.out is the monitor/terminal.

In Java for the class, we use `Scanner inputReader = new Scanner(System.in);` and then read lines from the Scanner object using `inputReader.nextLine()`.

**Caution**: Some enterprising student will decide that they can use `.nextInt()` or similar and then wonder why their code keeps acting up. `nextLine()` will remove a `\n` from the stream when it's done reading, but none of the other `next...()` methods will, which means that a subsequent call to a `next...()` method will hit that `\n` on reading input.

Quick solution: Always call `nextLine()` right after one of the other `next...()` methods so that the `\n` is gotten rid of.

</div>

<div class="csharp note">

**C#:** Console.ReadLine and Console.WriteLine are abstractions that exist in order to interact with the standard input/output stream.</div>

[Reading Intellisense](http://book.techelevator.com/java/25-command-line-programs/10-reading-intellisense.html)

<div class="note instructorDirective">

As you write your command line application in the IDE, show how standard methods from the input and output streams show up in the intellisense and how important it is to use those as an initial attempt at figuring out what method to use.

</div>

### [Parsing Strings](http://book.techelevator.com/java/25-command-line-programs/15-parsing-strings.html)

* What data type is the input from the command line? *Always Strings!*
* How do we allow users to enter numbers, dates, times, decimals, etc.?

<div class="definition note">Computers <strong>parse</strong> input and look for symbols that follow an expected syntax or set of rules.</div><br/>

A parse method is available to Java and C# developers that is able to convert a string into the correct data type.

<div class="caution note">If the input string cannot resolve the input to the correct data type, then our program fails and display an error msg to the user</div><br/>

Java:
``` java
Integer.parseInt(String s);
Long.parseLong(String s);
Double.parseDouble(String s);
Boolean.parseBoolean(String s);
```

C#:
``` csharp
int.Parse(string s);
bool.Parse(string s);
double.Parse(string s);
decimal.Parse(string s);
char.Parse(string s);
```

## System.out / Console.WriteLine()

You can print back to the screen a message when your calculation is done. To do that, you'll use the standard output.

Java can use `System.out.println()` to print out a new line or `System.out.printf()` to print out a formatted String.

## Student Exercises (Individual & Pair)
- [Java Individual Exercises](https://bitbucket.org/te-curriculum/module-1-introduction-to-java/src/master/exercises/command-line-programs-exercises/)
- [Java Pairs Exercises](https://bitbucket.org/te-curriculum/module-1-introduction-to-java/src/master/exercises/command-line-programs-exercises-pair/)
- [.NET Individual Exercises](https://bitbucket.org/te-curriculum/module-1-introduction-to-c/src/master/exercises/command-line-programs-exercises/)
- [.NET Pairs Exercises](https://bitbucket.org/te-curriculum/module-1-introduction-to-c/src/master/exercises/command-line-programs-exercises-pair/)