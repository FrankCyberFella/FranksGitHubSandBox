<link rel="stylesheet" type="text/css" media="all" href="./styles/style.css" />

# Inheritance - Part 2 - Lecture Notes

## **Classroom Preparation**  
* None

## **Overview of Session** 

Suppose we wanted to model a class for playing the game of Monopoly. 

How might we describe the process for playing the game?

<div class="instructorDirective">Write name of alogrithm on white board and write steps solicited from students"</div><br/>

<div class="exampleProblem">

 * Monopoly Algorithm
   1. Assign tokens to players
   2. Distribute money
   3. Each player takes a turn until the game is over
   4. Display name of winning player</div>

Now, consider the algorithm for playing another game, such as Chess:

<div class="exampleProblem">

* Chess Algorithm
   1. Setup chess pieces
   2. Assign sides (i.e. black and white)
   3. Each player takes a turn until one player achieves "checkmate" or there is a draw
   4. Display the name of winning player</div>

Do you notice the similarities?  How could we design a generic solution for multiple different kinds of games?

## **Customary schedule for session:** 
1. Games!
2. Template Method Pattern
3. Constructor Inheritance
4. Abstract Classes
5. Subclass Member Access

## **Session Objectives:** 
* Describe the purpose and use of the Template Method Pattern


## **Topic List w/Notes** <div class=topicNote>(and <span class='link'>links</span> to e-book section when available)</div>

### Games!
1. Lead students through identifying a generic algorithm for a turn-based game
    - Prepare to Play    
    - While the game is not over
        - Next player takes a turn
    - Display winner
   
2. Draw the algorithm as a flow chart and lead class discussion how we would implement this
          
### Template Method Pattern
<div class="definition note">The <span>Template Method pattern</span> defines the steps of an algorithm and allows subclasses to provide the implementation for one or more steps</div><br/>

[Link to description of Template Method Pattern](http://www.oodesign.com/template-method-pattern.html)

1. Lead the class through defining something like the following class:
``` 
    public class Game {

        private int numberOfPlayers;
    
        public Game(int numberOfPlayers) {
            this.numberOfPlayers = numberOfPlayers;   
        }
    
        public void playOneGame() {
            prepareToPlay();
            for(int i = 0; !endOfGame(); i = (i + 1) % numberOfPlayers) {
                makePlay(i);
            }  
            displayWinner(); 
        }
    
        public void prepareToPlay() { }
    
        public boolean endOfGame() { return false; }
    
        public void makePlay(int player) { }
    
        public void displayWinner() { }
    }
```
2. Note that `prepareToPlay`, `endOfGame`, `makePlay`, and `displayWinner` are intended to be overridden by subclasses<br/>

<div class="discussion">   

- Discussion: "What visibility is appropriate?" (If anyone objects to `public`, note that you will discuss later)
- Discussion: "How are subclasses supposed to know which methods they are expected to override?"
- Discussion: "What should the default implementations be for these methods?"
- Discussion: "Does it make sense to create an instance of `Game`?"
</div>

3. **Constructor Inheritance**
   - Implement a `Monopoly` class that extends `Game`
        - Demonstrate that `Monopoly` is forced to invoke the superclass constructor
   - superclass constructors are invoked with `super(...)` in Java and `base(...)` in C#
   - `Monopoly` class should look something like this in C#:

```
   public class Monopoly : Game
    {
    public Monopoly(int numberOfMonopolyPlayers)
        : base(numberOfMonopolyPlayers)
    {
    }

    private List<string> players;
    private Random rnd = new Random();

    protected override bool EndOfGame()
    {
        return players.Count == 1;
    }

    protected override void InitializeGame()
    {
        players = new List<string>();

        for (int i = 1; i <= playersCount; i++)
        {
            players.Add("Player " + i);
            Console.WriteLine("Player " + i + " joined the game and was given $1000");
        }
        
        Console.WriteLine();
    }

    protected override void ProclaimWinner()
    {
        Console.WriteLine("The remaining player " + players[0] + " is the winner!");
        Console.WriteLine();
    }

    protected override void TakeTurn(int playerNumber)
    {
        //Randomly make a player get eliminated
        int random = rnd.Next(100);

        // Eliminate the player if the random number 
        // is divisible by 7
        if (random % 7 == 0)
        {
            Console.WriteLine();
            Console.Write("ELIMINATED  ------ ");
            Console.WriteLine(players[playerNumber] + " ran out of $ eliminated!");
            Console.WriteLine();
            
            // Remove player fromthe lineup
            players.RemoveAt(playerNumber);
            playersCount--;
            CurrentPlayer = CurrentPlayer - 1;
        }
        else //let them keep playing
        {
            Console.WriteLine(players[playerNumber] + " just took their turn");
        }
    }
}
```

4. **Abstract Classes**
    <div class="definition note">An <span>abstract class</span> is a class that cannot be instantiated. It exists solely for purposes of inheritance and polymorphism.  An <span>abstract method/function</span> is a method/function that does not have an implementation and must be overridden by subclasses.</div>
<div class="discussion">

- Discussion: "Why not declare an abstract class as an interface?"        - We would need to continually implement the same methods (i.e. code duplication) when it may make more sense to inherit the implementation.
</div>
<div class="instructorDirective">

- Demonstration: Modify the `Game` class to be `abstract` and demonstrate that you can no longer create an instance of `Game`
</div>
<br/>
<div class="instructorDirective">

- Demonstration: Modify the `prepareToPlay`, `endOfGame`, `makePlay`, and `displayWinner` methods/functions and demonstrate that subclasses must implement them
</div><br/>

- If a class does not override an abstract method from it's parent, it must also be abstract.<br/><br/>

5. **Subclass Member Access**
<div class="discussion">

- Discussion:** Is there a problem with the `prepareToPlay`, `endOfGame`, `makePlay`, and `displayWinner` methods/functions having `public` visibility?
</div>

- We are breaking encapsulation, these should really be internal implementation details
- We can't make them `private` because then our subclasses couldn't override them.
- Introduce `protected` and Java default member access
- `protected` members may be accessed by subclasses and other classes in the same package
- in Java, default (i.e. no modifier) member access only allows classes in the same package to have access.

<div class="instructorDirective">

- Demonstration: Modify `prepareToPlay`, `endOfGame`, `makePlay`, and `displayWinner` to be `protected` visibility and demonstrate that outside classes can no longer invoke those methods
</div>

## Instructor Led Exercise
Template Method Pattern Game <div class="questionAboutContent">???(Frank: Not sure what this is or where to find it)???</div>



