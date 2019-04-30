<link rel="stylesheet" type="text/css" media="all" href="./styles/style.css" />

# Introduction to Collections (Part 2) - Lecture Notes
###### (05/15/2018)

## [**Overview of Session**](http://book.techelevator.com/java/40-non-linear-data-structures/01-intro.html) 

Yesterday, we learned about data structures that are a lot like arrays but have some different behavior that makes working with them easier. 

Today we'll be learning about some other data structures and how to think about data structures and your own code in terms of performance.

## **[Session Objectives:](http://book.techelevator.com/java/40-non-linear-data-structures/01-intro.html)** 
* Students should be aware of performance/optimization considerations of various data structures
* Students should be able to describe "Big O" (Big Omicron) notation and common examples for the basic Big O categories
* Students should be able to effectively use objects of the following collection classes:
    - Map/Dictionary
    - Set/HashSet
    
## Classroom Preparation

1. List out on the whiteboard the basic Big O levels:
    
    | O(1) | O(n) | O(n^2) |
    |------|------|--------|

## **Agenda and Timing for Session** 
* [`Map<T,T>` or `Dictionary<T,T>`](http://book.techelevator.com/java/non-linear-data-structures/10-associative-collections.html) (0:45)
* [`HashSet<T>` or `Set<T>`](http://book.techelevator.com/java/non-linear-data-structures/15-sets.html) (0:15)
* Break
* [Algorithmic Complexity](http://book.techelevator.com/java/non-linear-data-structures/05-algorithmic-complexity.html) (0:45)

## **Topic List w/Notes** <div class=topicNote>(and <span class='link'>links</span> to e-book section when available)</div>

### [Map<T,T> (Java) and Dictionary<T,T> (.NET)](http://book.techelevator.com/java/non-linear-data-structures/10-associative-collections.html)

<div class="definition note">A map/dictionary is an indexed collection that allows values to be located using user-defined keys.</div>

<div class="note analogy">This is like a snack machine. The key is something like `A5`, which will get me the value at that key, a bag of chili cheese Fritos.</div>

<div class="note caution">Students have a hard time with this concept of a key relating to a value. Don't directly relate it to a List's index, because that can cause more confusion at times. Be sure to explain clearly that the key is what labels a specific location in the Map/Dictionary and then you put the value at that location.</div>

> **Instructor Exercise** (Use lecture code or your own code)
>
> 1. Declare and initialize a Dictionary/Map
> 2. Add an Item to a Dictionary using the Add/put() method
> 3. Get an Item from a Dictionary using the Get/get() method
> 4. Check to see if an Item already exists in the dictionary by its key.
> 5. **C#** Add an Item to a Dictionary using the Array Indexer
> 6. **C#** Get an Item from the Dictionary using the Array Indexer
> 7. Replace an Item in the Dictionary
> 8. Iterate through the KeyValuePairs in the Dictionary 

### [Set<T> (Java) & HashSet<T> (C#)](http://book.techelevator.com/java/non-linear-data-structures/15-sets.html)

- A collection where:
    - elements are not kept in order
    - elements are unique to the set
        - adding it again does nothing

<div class="note instructorDirective">Walk students through the SET using the lecture code or your own code</div>

### [Algorithmic Complexity](http://book.techelevator.com/java/non-linear-data-structures/05-algorithmic-complexity.html)

<div class="note instructorDirective">

This is a good time to take a break and discuss and interesting topic while letting off the gas a bit. Tell them that this is something they may hear on a job interview but is really just a discussion that different solutions have different performance and to keep that in mind. It's always more important to find a correct solution and then look at it for performance improvements.

</div>

Reference: [A Beginners Guide to Big O Notation](https://rob-bell.net/2009/06/a-beginners-guide-to-big-o-notation/)

Reference: Student Book on Algorithm Complexity


1. Try opening with an example of an algorithm on the board such as:
```java
public boolean isLastElementEven(int[] array) {
    return array[array.length - 1] % 2 == 0;
}
```
```csharp
public bool IsLastElementEven(int[] array)
{
    return array[array.Length - 1] % 2 == 0;
}
```
- **How long will it take this to run?** What if the array has 100 elements, 1000, 10000, 100000?
- This is a Big O of O(1) because it doesn't matter how big the array is, we can go directly to an index.

2. **What if we wrote code to look through an entire array instead?**
```java
public boolean doesArrayContain10(int[] array) {
    boolean hasATen = false;
    for(int i = 0; i < array.length; i++) {
        if (array[i] == 10){
            hasATen = true;
        }
    }

    return hasATen;
}
```
```csharp
public bool DoesArrayContain10(int[] array)
{
    bool hasATen = false;
    for(int i = 0; i < array.Length; i++) {
        if (array[i] == 10){
            hasATen = true;
        }
    }

    return hasATen;
}
```
- This is a Big O of O(n) because it will run once for each element in the array
- Loops are always, worst case, O(n)

3. **What about looking through an array for duplicates?**
```java
public boolean doesArrayContainDuplicates(int[] array) {
    boolean duplicate = false;
    for (int i = 0; i < array.length; i++){
        for (int j = 0; j < array.length; j++) {
            if (i == j){
                continue;
            }

            if (array[i] == array[j]){
                duplicate = true;
            }
        }
    }

    return duplicate;
}
```
```csharp
public bool DoesArrayContainDuplicates(int[] array) {
    bool duplicate = false;
    for (int i = 0; i < array.Length; i++){
        for (int j = 0; j < array.Length; j++) {
            if (i == j){
                continue;
            }

            if (array[i] == array[j]){
                duplicate = true;
            }
        }
    }

    return duplicate;
}
```
- This is O(n^2). We have to run through the array for each element of the array.
- Nested loops are always, worst case, O(n^2)

<div class="definition note">Algorithmic complexity is concerned about how fast or slow a particular algorithm performs. Computer scientists often quantify  this with Big O notation.</div>
<br/>

![Time Complexity](resources/Time_Complexity.png)

2. **Discuss Algorithm Complexity for Collections Classes from yesterday**
    - Insert (at end, middle)
    - Searching
    - Retrieval
    - Removal (from end, middle)
    - [Big O Notation for Data Structures and Sorting](https://github.com/ro31337/bigoposter)

## Instructor Led Exercises

- [Java Lecture](https://bitbucket.org/te-curriculum/module-1-introduction-to-java/src/master/lecture/collections-part2-lecture/)
- [.NET Lecture](https://bitbucket.org/te-curriculum/module-1-introduction-to-c/src/master/lecture/collections-part2-lecture/)

## Student Exercises (Individual & Pair)

- [Java Exercises](https://bitbucket.org/te-curriculum/module-1-introduction-to-java/src/master/exercises/collections-part2-exercises/)
- [.NET Exercises](https://bitbucket.org/te-curriculum/module-1-introduction-to-c/src/master/exercises/collections-part2-exercises/)