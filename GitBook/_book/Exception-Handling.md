<link rel="stylesheet" type="text/css" media="all" href="./styles/style.css" />

# Exception Handling

## Problem Statement
We have seen that Visual Studio prevents us from introducing bugs in the code that are “compile” time errors.

Sometimes our code is syntactically correct, but it contains incorrect assumptions that aren’t discovered until the program is running.
- Logical Assumptions
- Networking Assumptions
- Memory Assumptions
- Filesystem Assumptions

## Definitions
- **Exception Handling** is the process of responding to the occurrence of an exception during runtime. The conditions that take place often change normal program flow and require special processing.
- **Call Stack** stores information about the active functions of our computer programs.  The stack keeps track of the point for each active function and returns control when it finishes executing.
- **Exception Propagate** - exceptions travel from method to method, up the call stack, until they are *caught* by some sort of code that will correctly handle it and clean it up.
- **Stack trace** is a report of active stack frames (or functions) at a certain point in time during program execution.


## Analogies
- We use signals in real life to indicate that an error has occurred. In football, if a penalty is committed, a referee will throw a flag on the ground and whistle the play dead. The penalty is assessed and executed. Once the penalty is addressed, play continues as normal.

- **Burying Exceptions** A man is shot and wounded. He hides the wound, climbs on the bus and rides across town. There he dies of blood loss. Police find him 10 miles from where he is shot with no clues to the cause and the case is never solved.

**Maybe the man should have laid down and died** this would have provided the most clues.

- **The equivalent of laying down** is sloppy and lazy because our programs just die and never attempt to take care of themselves.

- **Try to handle the exception (trivial occurrence)** The man is playing paintball and just got paint on his goggles. He wipes it off and carries on playing. *Self healing, our program can take care of itself.*

- **Try to handle exception 2** The man realized he was shot but isn’t fatally wounded. He writes down a description of the attacker and dials 911 and phones for an ambulance. *We consider writing the exception to a log file to indicate that it took place and follow up later.*

- **Try to handle exception 3** The man is shot and dies instantly. He collapses in a messy heap. *Our application encountered something fatal and realistically has no chances of recovering.*

- Exceptions should never be used to change flow intentionally or return a return value.

## Visualization
![Exception Propagation](http://i.stack.imgur.com/Hu2Fp.gif)

## New Syntax or Classes
- `try` - code that may cause an exception is put within a try block
- `catch` - catch clauses are used to handle specific exceptions
- `throw` - throw is used to signal that an anomaly or undesired situation occurred during execution
- `finally` - we will cover this next week

## Notes and Examples
- Exceptions are *thrown* by code that encounters an error.
- Exceptions are *caught* by code that can correct the error.
- Exceptions are thrown by the .NET framework or by code in a program.
- Once an exception is thrown execution of the current function stops and the exception *propagates* up the call stack until a **catch** statement for the exception is found.

- Exceptions are represented by a class that derives from **Exception**
- This class identifies the type of exception and contains properties with details about the exception.

- When an exception is thrown the runtime checks the current statement to see whether it takes place within a **try** block. If it is, any **catch** blocks associated are checked to see if they can catch the exception.

- A **try** statement can contain more than one **catch** block. The first **catch** statement that can handle the exception is executed. 
- Catch blocks are often orders from most specific to least specific.
- Only one catch block is executed.

- We should catch exceptions when we have a good understanding of why the exception may occur and can recover (e.g. ask for filename input and we may get a FileNotfoundException).

- The **finally** block is executed last. The finally block runs regardless of whether the exception is thrown or not.
	- Writing to a file, close the file when done, whether there was an error or not.

- Not all code gets try-catch blocks. Only ones that we see have potential to fail, have external dependencies, etc.

### Common Exception Types
- `*NullReferenceException*`
- `*IndexOutOfRangeException*`
- `NotImplementedException`
- `FileNotFoundException`
- `InvalidOperationException`
- `ArgumentException`
- `DivideByZeroException`
- `InvalidCastException`
- `StackOverflow`
- `ArgumentOutOfRangeException`

### Sample Try-Catch
```csharp
try
{
	// code to try goes here
}
catch (SomeSpecificException ex)
{
	// Code to handle the exception goes here
	// Only catch ones we know how to handle
}
```

### Sample Try-Finally
```csharp
try
{
	// code to try goes here
}
finally
{
	// Code to execute after try block goes here
}
```

### Sample Try-Catch-Finally
```csharp
try
{
	// code to try goes here
}
finally
{
	// Code to execute after try block goes here
}
```

## Instructor Led Exercise

## Individual Pair Exercise

## Supplementary Materials and Reading 
1. Read (C# Yellow Book)[http://static1.squarespace.com/static/5019271be4b0807297e8f404/t/55e8091ee4b0b7a615665de5/1441270046307/CSharp+Book+2015+Final.pdf] Section 3.4 and 3.5
1. Reference http://www.davidarno.org/2010/12/06/exception-handling-some-thoughts-on-good-practices/
2. (MSDN Compiler Generated Exceptions)[https://msdn.microsoft.com/en-us/library/ms173164.aspx]