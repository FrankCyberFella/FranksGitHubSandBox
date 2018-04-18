<link rel="stylesheet" type="text/css" media="all" href="./styles/style.css" />

# Collections Part 1 - Lists - Lecture Notes
###### (04/13/2018)

## **Classroom Preparation**  
* None

## [**Overview of Session**](http://book.techelevator.com/java/linear-data-structures/01-intro.html) 

We've seen that arrays are good at holding objects for the same type. They have a few downsides such as fixed-sizes and linear storage.

The Java and .NET framework provides a group of classes that are good for working with collections of data, called the *collections framework*.

## **Customary schedule for session:** 

* [Array Recap](http://book.techelevator.com/java/linear-data-structures/05-arrays.html)
* [Collections](http://book.techelevator.com/java/linear-data-structures/10-collections.html) & ForEach
    * [`List<T>`](http://book.techelevator.com/java/linear-data-structures/15-list.html)
    * [`Queue<T>`](http://book.techelevator.com/java/linear-data-structures/25-queue.html)
    * [`Stack<T>`](http://book.techelevator.com/java/linear-data-structures/20-stack.html)
* Namespaces & Packages
* Boxing & Unboxing Objects
* Java Wrapper Objects

## **Session Objectives:** 
* Describe the purpose and use of Collections
* Demonstrate an understanding of code libraries ane the use of namespaces in C# or packages in Java to help organize them.
* Use the `for-each` look to iterate through a collection


## **Topic List w/Notes** <div class=topicNote>(and <span class='link'>links</span> to e-book section when available)</div>

### [Array Recap](http://book.techelevator.com/java/linear-data-structures/05-arrays.html)

### [Collections Classes](http://book.techelevator.com/java/linear-data-structures/10-collections.html)

### [List<T>](http://book.techelevator.com/java/linear-data-structures/15-list.html)

* A generic list is:

* Zero-indexed like an array
* An ordered set of elements accessible by index
* Allows duplicates 

> Use instructor code to show how a List works

#### Foreach

1. Convenience method to iterate through collection
1. Cannot modify the contents during iteration

> Walk students through the foreach syntax using the `List<T>` examples  

### Namespaces & Packages

1. How do we get access to these classes?
2. The frameworks, Java and C#, each have thousands of classes within them. How are they organized?
    - Namespaces/packages    
3. Without namespaces, we need to type the full name.
    - We can add an `import` or `using` statement to indicate that we want to use classes from a particular library .
4. **Collections Namespace/Package**
    - In Java the Collections are located in the `java.util` package
    - In .NET the Collections are located in the `System.Collections` and `System.Collections.Generic` namespace


    <div class="definition note">A <strong>namespace/package</strong> is used to organize classes within libraries. It creates scope to prevent two classes with the same name from overlapping with each other (i.e. a naming collision).</div>

    <div class="analogy note">
    <p>Let's say that you and I have two mutual friends, both named "Josh". If I said to you, "Guess what Josh told me yesterday.", and you didn't know which Josh I was talking about, how might you resolve the ambiguity?</p> 
    <p>A common way would be to ask me to clarify whether I was talking about "Josh Tucholski" or "Josh Jones".  After the clarification, we could carry on talking about Josh without further need for the last name.</p>
</div>


#### java.lang and System (.NET)

    In Java, the `java.lang` package is imported by default, which is why we can use `String firstName = "David";` instead of `java.lang.String firstName = "David";`

    In C#, the `System` namespace is included by default which is why we can write `string firstName = "Josh";` instead of `System.String firstName = "Josh";`


### [Queue<T>](http://book.techelevator.com/java/linear-data-structures/25-queue.html)

> Demonstrate code to instantiate a queue and add/remove items with it.

### [Stack<T>](http://book.techelevator.com/java/linear-data-structures/20-stack.html)

> Demonstrate code to instantiate a stack and add/remove items with it.

### Primitive Wrapper Objects (Java Only)

A wrapper class exists that encapsulates the primitive types so that they can be interacted with as objects.

<div class="definition note">A <strong>primitive wrapper</strong> is a wrapper class that wraps data types from the primitive data types so that they can be instantiated objects with methods or in other classes..</div>
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

## Instructor Led Exercises
- [Java Lecture Code](https://bitbucket.org/te-curriculum/m1-java-collections-part-1-lecture)
- [.NET Lecture Code](https://bitbucket.org/te-curriculum/m1-csharp-collections-part1-lecture)

## Student Exercises (Individual & Pair)

- [Java Exercises](https://bitbucket.org/te-curriculum/m1-java-collections-part-1-exercises)
- [Java Exercises Solutions](https://bitbucket.org/te-curriculum/m1-java-collections-part-1-solutions)
- [.NET Exercises](https://bitbucket.org/te-curriculum/m1-csharp-collections-part1-exercise)
- [.NET Exercises Solutions](https://bitbucket.org/te-curriculum/m1-csharp-collections-part1-solution)



