<link rel="stylesheet" type="text/css" media="all" href="./styles/style.css" />

# Polymorphism - Lecture Notes

## **Session Objectives:** 
* Explain the concept of polymorphism and how it is useful
* Demonstrate an understanding of where inheritence can assist in writing polymorphic code
* State the purpose of interfaces and how they are used
* Successfully implement polymorphism through inheritence
* Successfully implement polymorphism through interfaces 

## **Classroom Preparation** 
* None

[## **Overview of Session**](http://book.techelevator.com/java/polymorphism/01-intro.html) 
- Imagine a class where each Shape defines a function for `GetArea()` and `GetPerimeter()`. 
	- How would we support the ability to get a perimeters and areas for all shapes?
	- Would we have to use `GetArea()` and `GetPerimeter()` on each of these instances?
- How do we attempt to explain an action regardless of the objects we develop applications with?

## **Customary schedule for session:** 

1. Polymorphism through Inheritance
2. Polymorphism through Interfaces
3. View ["Building a Real Application" video](http://book.techelevator.com/java/inheritance/20_building_a_real_application.html) in e-book

## **Topic List w/Notes** <div class=topicNote>(and <span class='link'>links</span> to e-book section when available)</div>

<div class="caution note">Students may have read about this topic in advance, but it doesn't add value "diving straight in with definitions.". Instead rely on the lecture code to motivate discussion.</div>

1. **Instructor Lecture Code**	
	[- Using Old MacDonald Lecture Code](#OldMacDonaldCode)

2. **Polymorphism through Inheritance**
	- Demonstrate that we've got code duplication problems (with the Cow, Chicken, and Duck)
	- Create a base `FarmAnimal` class that these classes derive from.
		- `FarmAnimal`, for now, has a Name, MakeSoundOnce(), and MakeSoundTwice() method
	- Create a List of `FarmAnimal` and demonstrate any animal that "is-a" Farm Animal can be added to it.

	<div class="definition note">In object-oriented programming, polymorphism is the idea that something can be assigned a different meaning or usage based on the context it is referred to as.</div>
<br/>

3. **What Something Can Do**
	- What if we want to sing about something that isn't a Farm Animal? What if its our tractor?
	- In code we can also generalize objects and not think of *what they are* but *what they can do*.
	
		<div class="analogy note">I once asked a class, "stand up if you are a musician". Of all the students that stood up, when asked what made them a musician, they all had different answers. One indicated they were a vocalist, another a drummer, another a trumpeter, etc. No musician was alike. When they were asked to "play their instruments", they know exactly what to do and didn't need to be told to "sing" or "drum", or "strum a guitar". We were able to create a generalization of this group based on something they could do. <span>Interfaces</span> allow us to do this with objects. Another student then said they wanted to be a musician and the only thing needed was for them to specify an instrument.</div>	

		<div class="analogy note">I also was able to create another generalization. Students that speak multiple languages. One of them also happened to be a musician, so this also helped us get into the idea of multiple interfaces.</div>	

4. **Interfaces**
	- Define *what something can do* but *not how it does it*.
	- An **interface** is a **contract** that defines what **expectations** a user of the interface can expect
	- Cannot be instantiated
	- Multiple Interfaces
	- if Class A implements interface B, then A "is-a" B

		<div class="analogy note"><strong>Other Analogies</strong>
		<ul>
			<li>gas pumps (dispense gas to car, truck, motorcycle)</li>
			<li>shirts (two arms, neck, etc)</li>
			<li>HDMI (connects to laptop to monitor, projector, television)</li>
			<li>phone chargers</li>
		</ul>
</div>


5. **Polymorphism through Interfaces**
	- Create an interface, a singable item
	- Have another class implement the interface, along with Farm Animal
	- Modify the program logic to use the interface instead of the Farm Animal
		
   	
## Instructor Led Exercise
<a name="OldMacDonaldCode">1. Old MacDonald


- [Java Lecture Code](https://bitbucket.org/te-curriculum/m1-java-polymorphism-lecture)
- [.NET Lecture Code](https://bitbucket.org/te-curriculum/m1-csharp-polymorphism-lecture)

## Individual/Pair Exercise

Polymorphism Exercise

- [Java Pair Exercises](https://bitbucket.org/te-curriculum/m1-java-polymorphism-exercises-pair)
- [Java Individual Exercises](https://bitbucket.org/te-curriculum/m1-java-polymorphism-exercises)
- [.NET Pair Exercises](https://bitbucket.org/te-curriculum/m1-csharp-polymorphism-exercise-pair)
- [.NET Individual Exercises](https://bitbucket.org/te-curriculum/m1-csharp-polymorphism-exercise-individual)
