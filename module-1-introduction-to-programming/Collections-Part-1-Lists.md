<link rel="stylesheet" type="text/css" media="all" href="./styles/style.css" />

# Collections Part 1 - Lists - Lecture Notes
###### (05/15/2018)

## [**Overview of Session**](http://book.techelevator.com/java/linear-data-structures/01-intro.html) 

We've seen that arrays are good at holding objects of the same type and how that can be useful in our programs. But they have a few downsides such as fixed-sizes and linear storage. Downsides that we should be able to solve now that we have objects.

If we can now group data and behavior together in an object, what are some possible ways that we could add some extra behavior to regular arrays to make them more powerful? We've already seen this in action with Strings. Strings are really just an array of characters, but by putting that array in an object, we can add functionality that makes sense for Strings, like finding substrings or uppercasing the String.

The Java and .NET framework gives us a library of code that will let us make more powerful arrays and other data structures. This library is called the collection library and provides us with a group of objects that makes dealing with collections of data easy.

## **Session Objectives:** 

* Students should be able to describe the purpose and use of Collections
* Students should be able to describe the differences between a List and an array and the different use-cases for them
* Students should be able to demonstrate an understanding of code libraries and the use of namespaces in C# or packages in Java to help organize them
* Students should be able to use the `for-each` loop to iterate through a collection
* Students should be able to describe what a Stack and Queue are and how they work
* Students should be able to identify from syntax what variables are arrays and what are Lists

## **Classroom Preparation**  
1. Write a `for` loop and a `for-each` loop on the whiteboard
2. **Java Only** Write up the primitive to object mapping table on the whiteboard

## **Agenda and Timing for Session** 

* Array Recap - [Java](http://book.techelevator.com/java/35-linear-data-structures/05-arrays.html) | [.NET](http://book.techelevator.com/.net/35-linear-data-structures/05-arrays.html) (0:10)
* Collections - [Java](http://book.techelevator.com/java/35-linear-data-structures/10-collections.html) | [.NET](http://book.techelevator.com/.net/35-linear-data-structures/10-collections.html) (0:15)
* Namespaces & Packages (0:15)
* `List<T>` - [Java](http://book.techelevator.com/java/35-linear-data-structures/15-list.html) | [.NET](http://book.techelevator.com/.net/35-linear-data-structures/15-list.html) (0:20)
* Break (0:10)
* **Java** Boxing & Unboxing Objects and Java Wrapper Objects (0:10)
* Foreach loops (0:10)
* `Queue<T>` - [Java](http://book.techelevator.com/java/35-linear-data-structures/25-queue.html) | [.NET](http://book.techelevator.com/.net/35-linear-data-structures/25-queue.html) (0:15)
* `Stack<T>` - [Java](http://book.techelevator.com/java/35-linear-data-structures/20-stack.html) | [.NET](http://book.techelevator.com/.net/35-linear-data-structures/20-stack.html) (0:15)


## **Topic List w/Notes** <div class=topicNote>(and <span class='link'>links</span> to e-book section when available)</div>

### [Array Recap](http://book.techelevator.com/java/35-linear-data-structures/05-arrays.html)
- Arrays are simple data structures that let us work with a collection of data
- Arrays aren't very flexible. Adding a new element to an array or modifying the array is often difficult.
- This is why collections were created, to make creating and modifying collections of data easier.

### [Collections Classes](http://book.techelevator.com/java/35-linear-data-structures/10-collections.html)

- Collections classes live in a package or namespace and come from the framework's standard library of classes
- These are written for you and generic enough that they are useful for lots of programmers
- Fundamentally, packages and namespaces are just ways of organizing code

### Namespaces & Packages

1. How do we get access to these classes?
2. The frameworks, Java and C#, each have thousands of classes within them. How are they organized?
    - Namespaces/packages    
3. Without namespaces, we need to type the full name.
    - We can add an `import` or `using` statement to indicate that we want to use classes from a particular library.
4. **Collections Namespace/Package**
    - In Java the Collections are located in the `java.util` package.
    - In .NET the Collections are located in the `System.Collections` and `System.Collections.Generic` namespace.

    <div class="definition note">A <strong>namespace/package</strong> is used to organize classes within libraries. It creates scope to prevent two classes with the same name from overlapping with each other (i.e. a naming collision).</div>

    <div class="analogy note">
        <p>Let's say that you and I have two mutual friends, both named "Josh". If I said to you, "Guess what Josh told me yesterday?", and you didn't know which Josh I was talking about, how might you resolve the ambiguity?</p> 
        <p>A common way would be to ask me to clarify whether I was talking about "Josh Tucholski" or "Josh Jones".  After the clarification, we could carry on talking about Josh without further need for the last name.</p>
    </div>

#### java.lang and System (.NET)

In Java, the `java.lang` package is imported by default, which is why we can use `String firstName = "David";` instead of `java.lang.String firstName = "David";`

In C#, the `System` namespace is included by default which is why we can write `string firstName = "Josh";` instead of `System.String firstName = "Josh";`

### [List<T>](http://book.techelevator.com/java/35-linear-data-structures/15-list.html)

* A List is:
    * Zero-indexed like an array
    * An ordered set of elements accessible by index
    * Allows duplicates
    * BUT it can grow and shrink as you add and remove items
        - You can add and remove from the middle even
* **Java** We use an ArrayList in Java because List is an interface and ArrayList is an actual class we can make objects out of. Will be explained later this week and next week why this is important.

<div class="note caution">Students will just have arrays down right when they get hit with this. They are going to confuse syntax and terms a lot, so take your time now to make sure you say List when you mean List and array when you mean array. Also, be sure to let them know that this will be a struggle.</div>

<div class="note instructorDirective">Use instructor code to show how a LIST works</div>

### Primitive Wrapper Objects (Java Only)

- Lists and other collections can only hold other objects!
- What if we want a List of `int`s?
- A wrapper class exists that encapsulates the primitive types so they can be interacted with as objects.

<div class="definition note">A <strong>primitive wrapper</strong> is a wrapper class that wraps data types from the primitive data types so they can be instantiated objects with methods or in other classes.</div>
<br/>

| Java Primitive Type | Wrapper Class | Constructor Argument |
|---------------------|---------------|----------------------|
| `byte` | `Byte` | `byte` or `String` |
| `short` | `Short` | `short` or `String` |
| `int` | `Integer` | `int` or `String` |
| `long` | `Long` | `long` or `String` |
| `float` | `Float` | `float`, `double`, or `String` |
| `double` | `Double` | `double` or `String` |
| `char` | `Character` | `char` |
| `boolean` | `Boolean` | `boolean` or `String` |

<div class="definition note"><strong>Autoboxing</strong> is the automatic process of converting a primitive type to a reference type.</div>

<div class="definition note"><strong>Unboxing</strong> is when an object is moved off of the heap and converted back into a primitive type or value type.</div>

<div class="note instructorDirective">Use instructor code to show how PRIMITIVE WRAPPERS work</div>

#### Foreach

- Convenience method to iterate through collection
- Cannot modify the contents during iteration
- Really only useful if you just want to work with the elements, don't need the index and want to go through each one
    - which is most of the time

<div class="note instructorDirective">Walk students through the FOREACH syntax using the lecture code</div>

### Queue<T> - [Java](http://book.techelevator.com/java/35-linear-data-structures/25-queue.html) | [.NET](http://book.techelevator.com/.net/35-linear-data-structures/25-queue.html)

- Queues are just Lists, but used in a certain way to get a certain result
- A very common data structure in programming
- FIFO - First in, First out
- **Java** Use a `LinkedList` in Java, because it implements the Queue interface

<div class="note analogy">

Real world example would be a print queue, where documents need to be printed in the order received or call center where calls are taken in the order received.

</div>

<div class="note instructorDirective">Demonstrate code to instantiate a QUEUE and add/remove items with it.</div>

### Stack<T> - [Java](http://book.techelevator.com/java/35-linear-data-structures/20-stack.html) | [.NET](http://book.techelevator.com/.net/35-linear-data-structures/20-stack.html)

- Stacks are, again, Lists of elements but with different behavior
- Another very common data structure in programming
- LIFO - Last in, First out
- **Java** Use an actual `Stack` object. Why? Because Java is stupid and this is the only one that uses the same name.

<div class="note analogy">

Real world example would be a the undo feature of an edit, where we want to first undo the latest change, or a browser, where the back button goes to the latest page visited.

</div>

<div class="note instructorDirective">Demonstrate code to instantiate a STACK and add/remove items with it.</div>

## Instructor Led Exercises

- Lecture Code - [Java](https://bitbucket.org/te-curriculum/module-1-introduction-to-java/src/master/lecture/collections-part1-lecture/) | [.NET](https://bitbucket.org/te-curriculum/module-1-introduction-to-c/src/master/lecture/collections-part1-lecture/)

## Student Exercises (Individual & Pair)

- Exercises - [Java](https://bitbucket.org/te-curriculum/module-1-introduction-to-java/src/master/exercises/collections-part1-exercises/) | [.NET](https://bitbucket.org/te-curriculum/module-1-introduction-to-c/src/master/exercises/collections-part1-exercises/)
- Exercises Solutions - [Java](https://bitbucket.org/te-curriculum/module-1-introduction-to-java/src/master/solutions/collections-part1-solutions/) | [.NET](https://bitbucket.org/te-curriculum/module-1-introduction-to-c/src/53624499c2a1bf501c3b861ac1d411513effd30a/solutions/collections-part1-solution/)
