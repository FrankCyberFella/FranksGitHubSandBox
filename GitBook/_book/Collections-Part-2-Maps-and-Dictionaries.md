<link rel="stylesheet" type="text/css" media="all" href="./styles/style.css" />

# Introduction to Collections (Part 2) - Lecture Notes
###### (04/13/2018)

## Classroom Preparation

1. UML Class Diagram for `Map<T,T>/Dictionary<T,T>`
2. list item 2 _(Frank: ????)_
3. list item 3 _(Frank: ????)_

## [**Overview of Session**](http://book.techelevator.com/java/non-linear-data-structures/01-intro.html) 

We've learned some linear data structures that store items in a very specific sequential fashion (e.g. order that they were added, the position that they were added at).

There is another type of data structure, that allows us to associate an element or value to a particular key. 

## **Customary schedule for session:** 

* [`Map<T,T>` or `Dictionary<T,T>`](http://book.techelevator.com/java/non-linear-data-structures/10-associative-collections.html)
* [`HashSet<T>` or `Set<T>`](http://book.techelevator.com/java/non-linear-data-structures/15-sets.html)
* [Algorithmic Complexity](http://book.techelevator.com/java/non-linear-data-structures/05-algorithmic-complexity.html)
* [What's Next](http://book.techelevator.com/java/non-linear-data-structures/20-whats-next.html)

## **[Session Objectives:](http://book.techelevator.com/java/non-linear-data-structures/01-intro.html)** 
* Be aware of performance/optimization considerations of various data structures
* State the fundamental concept of of "Big O" (Big Omicron) notation for expression algorithmic complexity
* Effectively use object of the following collection classes:
    - Map/Dictionary
    - Set/HashSet
* [Be aware of additional collection classes such as Trees and Graphs.](http://book.techelevator.com/java/non-linear-data-structures/20-whats-next.html)

## **Topic List w/Notes** <div class=topicNote>(and <span class='link'>links</span> to e-book section when available)</div>

### [Map<T,T> (Java) and Dictionary<T,T> (.NET)](http://book.techelevator.com/java/non-linear-data-structures/10-associative-collections.html)

<div class="definition note">A map/dictionary is an indexed collection that allows values to be located using user-defined keys.</div>
<br/>

* Creating a new Map/Dictionary
* Accessing Map/Dictionary values
* Adding values to a Map/Dictionary
* Validating the existance of a Key-Value pair
* Removing values from a Map/Dictionary
* Iterating through a Map/Dictionary
    * `foreach` loop

> **Instructor Exercise** 
>
> 1. Declare and initialize a Dictionary/Map
> 2. Add an Item to a Dictionary using the Add method
> 3. Get an Item from a Dictionary using the Get method
> 4. Check to see if an Item already exists in the dictionary by its key.
> 5. Add an Item to a Dictionary using the Array Indexer
> 6. Get an Item from the Dictionary using the Array Indexer
> 7. Replace an Item in the Dictionary
> 8. Iterate through the KeyValuePairs in the Dictionary 

### [Set<T> (Java) & HashSet<T> (C#)](http://book.techelevator.com/java/non-linear-data-structures/15-sets.html)

<div class="definition note">A set is an unordered collection containing unique elements. It calculates an object's hashcode to determine its uniqueness.</div><br/>

* Creating a new Set/HashSet
* Adding items to a Set/HashSet
* Removing items from a Set/HashSet
* Iterating through a Set/HashSet

### [Algorithmic Complexity](http://book.techelevator.com/java/non-linear-data-structures/05-algorithmic-complexity.html)

Reference: [A Beginners Guide to Big O Notation](https://rob-bell.net/2009/06/a-beginners-guide-to-big-o-notation/)

Reference: Student Book on Algorithm Complexity


1. Try opening with an example of an algorithm on the board such as:
```
public bool IsFirstElementEven(int[] array)
{
    return array[0] % 2 == 0;
}
```
- **How long will it take this to run?** What if the array has 100 elements, 1000, 10000, 100000?

2. **What if we wrote code to look through an entire array instead?**
```
public bool DoesArrayContain10(int[] array)
{
    for(int i = 0; i < array.Length; i++) {
        if (array[i] == 10){
            return true;
        }
    }

    return false;
}
```

3. **What about looking through an array for duplicates?**
```
public bool DoesArrayContainDuplicates(int[] array) {
    for (int i = 0; i < array.Length; i++){
        for (int j = 0; j < array.Length; j++) {
            if (i == j){
                continue;
            }

            if (array[i] == array[j]){
                return true;
            }
        }
    }

    return false;
}
```


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

- [Java Lecture](https://bitbucket.org/te-curriculum/m1-java-collections-part-2-lecture)
- [.NET Lecture](https://bitbucket.org/te-curriculum/m1-csharp-collections-part2-lecture)

## Student Exercises (Individual & Pair)

- [Java Exercises](https://bitbucket.org/te-curriculum/m1-java-collections-part-2-exercises)
- [Java Exercises Solutions](https://bitbucket.org/te-curriculum/m1-java-collections-part-2-solutions)
- [.NET Exercises](https://bitbucket.org/te-curriculum/m1-csharp-collections-part2-exercise)
- [.NET Exercises Solutions](https://bitbucket.org/te-curriculum/m1-csharp-collections-part2-solution)

## References
N/A
