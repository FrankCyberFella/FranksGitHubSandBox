<link rel="stylesheet" type="text/css" media="all" href="./styles/style.css" />

# Introduction to Developer Tools - Lecture Notes 
###### (04/09/2018)

## **Classroom Preparation**  

<div class='purpose'>(What needs to be done before session starts)</div><br/>

1. Write Unix Shell Commands on the Whiteboard
2. Write Git Commands on the Whiteboard


## **Overview of Session** 
<div class='purpose'>(Brief description of session and content)_</div></br>

[Link to Session Overview in e-book](http://book.techelevator.com/java/introduction-to-tools/1_intro.html)

## **Customary schedule for session:** 
<div class='purpose'>(General order of topics and timing (minutes))</div>

1. (:45) Become familiar with the laptop they will be using in class

2. (:30) Break to fill out StrengthsFinder

3. (:60) Identify the tools installed on the laptop to perform the various tasks

4. (:30) Gain a basic understanding of Source Control

5. (:30) Explain purpose and benefit of using source control

6. (:75) Perform selected tasks using  Git and Bitbucket

## **[Session Objectives](http://book.techelevator.com/java/introduction-to-tools/1_intro.html):** 
<div class='purpose'>(What do we want the students to be able to do upon completion)</div>
  
* Become familiar with the laptop they will be using in class:

    * For Mac/OS X:

        * Be able to perform the following tasks:

            * Dock

            * Change the password

            * Finding right-click

            * Using launchpad to open an application

            * Leverging multiple monitors	

            * Moving the monitor positioning

            * Mirroring displays

            * Moving windows between displays

        * Leveraging Safari or Chrome

        * Using Finder to explore the file system

        * Using Visual Studio Code as a text editor

    * For PC/Windows 10

        * Changing the Password

        * Leverging multiple monitors

            * Moving the monitor positioning

            * Mirroring displays

            * Moving windows between displays

* Identify the tools installed on the laptop to perform the following tasks:

    * Program editor / IDE

        * Eclipse (Java)

        * Visual Studio (Windows)

    * File System and Shell Commands

        * Understand hierarchical structure

        * Navigation Through the file system 

        * Basic file manipulation

    * Windows / Mac OS

        * Accessing the file system (Windows Explorer, Finder)

        * Launching an application (Launchpad)

        * Managing windows

        * Using multiple monitors

        * Using a text editor (Visual Studio Code)

* Gain a basic understanding of Source Control 

* Explain purpose and benefit of using source control

    * Understand "local" vs. "remote" repository

* Perform the following tasks using  Git and Bitbucket

    * Local add/init/commit & remotes *(Frank: not sure what remotes means here)*

    * Bitbucket Setup

    * Cloning a repository

    * Pushing code changes to a remote repository (stage, commit, push)

    * Updating local repository with changes from remote (pull)



  
## **Topic List w/Notes** <div class=topicNote>(and <span class='link'>links</span> to e-book section when available)</div>
<div class='purpose'>(What will we teach them in order to successfully meet Module Objectives)</div>

- ###  Windows 10 / Mac OS

    - #### Mac OS

        * Dock
        * Settings
        * Right Click - Context Menu
        * Launchpad
        * Safari & Chrome
        * Resizing Windows
        * Multiple windows for same program
        * Application menu
        * Change Password
        * Multi-Monitor Support
        * Finder

    -   ####  Windows 10

        * Start Menu & Search Bar
        * Right Click - Context Menu
        * Windows 10 Updates
        * Multi-Monitor Support
            * Finding Display Settings
            * Moving windows between displays      
        * Settings App & Control Panel
        * Internet Explorer & Chrome


- ### <a id="ShellFileSystem"></a>[Shell and File System](http://book.techelevator.com/java/introduction-to-tools/shell-and-file-system/1_intro.html)
  <!-- File System -->
    <div class="definition note"><h4>File System Definition:</h4> The <span>file system</span> is a method for storing and organizing files and the data that they contain. The are organized into tree structures. Drives contain folders and folders contain files.</div>

    <!-- Analogy -->
    <div class="analogy note"><h5>Analogy</h5>A hard drive is like a file cabinet. File cabinets have folders which serve as containers to various files.</div>

    - ### <a id="FileSystem"></a>[File System](http://book.techelevator.com/java/introduction-to-tools/shell-and-file-system/2_file-system.html)

    - ### <a id="WhatzaShell"></a>[What is a Shell](http://book.techelevator.com/java/introduction-to-tools/shell-and-file-system/3_what-is-a-shell.html)

    - ### <a id="NavigatingFileSystem"></a>[Navigating the File System](http://book.techelevator.com/java/introduction-to-tools/shell-and-file-system/4_file-system-and-shell.html)

        - #### Changing Directories
        - #### Print Working Directory
        - #### List Directory Contents
        - #### Working with Files and Folders
            - ##### Moving Files and Folders
            - ##### Copying Files and Folders
            - ##### Making Folders
            
        > <h4>Instructor Led Exercise</h4>
        > <h5><span style="color:blue"> <em>(Exercise performed by the instructor with students following along their laptops)</em> </span></h5> 
        >
        >
        > Walk the student through navigating the file system by opening **Explorer** or **Finder**
        > 
        > <h5>Points to Make</h5>
        >
        >Folders and Files have multiple properties that the operating system keeps track of for us.

    - ### <a id=NextSteps></a>[Additional Shell Commands / References](http://book.techelevator.com/java/introduction-to-tools/shell-and-file-system/5_next-steps.html)




-   ### <a id="ShellCommands"></a>Shell Commands

    <div class="definition note"><h4>Shell Definition</h4>The <strong>shell</strong> provides a text-based interface to interacting with the file system.</div>

    On the Mac we will be using the <strong>Terminal</strong> application and the PC will use a program called <strong>Git Bash</strong>. 

    >
    > <h4>Instructor Led Exercise</h4>  
    > <h5><span style="color:blue"> <em>(Exercise performed by the instructor with students following along their laptops)</em> </span></h5> 
    >
    >
    >
    >Walk through opening the Terminal or Bash window up.
    > 
    > We use the following commands
    >
    > | Command                 | Description                                 |
    > |-------------------------|---------------------------------------------|
    > | pwd                     | Prints out the current working directory    |         
    > | ls                      | List the contents of a particular directory |
    > | cd `<name>`             | Change directory                            |
    > | cd `<name>/<subfolder>` | Changes directory to a specific folder / subfolder |
    > | cd `..`                 | Go up a directory                           |
    > | cd `~`                  | Navigates back to the user's home directory |
    > | mkdir `<name>`          | Creates a new directory                     |
    > | rmdir `<name>`          | Removes a directory                         |
    > | rm `<file-name>`        | Removes a file by name                      |
    >
    > We also have a few additional shortcuts that can be used
    > 
    > 1. Press the up arrow (&uarr;) to cycle through previous commands instead of retyping
    > 2. Use the `tab` key to automatically complete the path.
    >
    >
    >From the PC we can also open a Git Bash window directly from the file explorer. The benefit of doing this is that it will take us directly to our intended location.
    >
    > <h4>Instructor Led Exercise</h4>
    > <h5><span style="color:blue"> <em>(Exercise performed by the instructor with students following along their laptops)</em> </span></h5> 
    >
    >
    > Walk the student through the opening the shell (Terminal or Git Bash) 
    >
    > 1. Practice using the `ls` command
    > 2. Use the `cd` command to change directories. Enter sub-folders, go back up a level, etc.
    > 3. Use the `cd ~` command and find your way back to the previous location.
    > 4. Create a directory and subdirectory to use as a workspace using `mkdir`.
    > 5. Practice removing the directory with `rmdir` and creating it again with `mkdir`. 

- ### <a id="TextEditor"></a>Text Editor

    A text editor is a program that allows you to open, view, and edit plain text files. It does not apply formatting like a word processor.

    - #### Mac OS

        The text editor used for Mac OS will be Visual Studio Code.

    
    - #### Windows 10

        The default Notepad application that comes bundled with Windows is functional but not adequate for our text editing needs. Each of the laptops has Notepad++ installed. 
        <h4>Notepad++ Features</h4>

         * It supports multiple different programming languages making it a great source code editor.

        * It can provide many tabs which often we will have open at a single point in time.
        * It detects changes in the file ensuring that they get saved (**Ctrl+S**)
 



- ### <a id="SourceControl"></a>[Git](http://book.techelevator.com/java/introduction-to-tools/version-control/3_what-is-github.html)

    <!-- Version Control -->
    <div class="definition note"><h5>Version Control Definition</h5><span>Version Control</span> systems record changes to a file or sets of files so that previous versions can be recalled at a later point in time.</div>

    <div class="analogy note"><h5>Analogy</h5><span>Version Control</span> is analogous to a save point in a video game. We create checkpoints so that we can return to them at a later point in time if something goes wrong.</div>

    <!-- Git -->
    <div class="definition note"><h5>Git Definition</h5><span>Git</span> is a distributed version control system that keeps a copy of its changes and file sets in a repository.<br><br></div>

    ><h4>Instructor Led Exercise</h4>
    >    **Walk the students through creating a Bitbucket Account if need be** and invite them to the Team Cohort.
    >
    > **Walk the students through the process of setting Git up on their computer by running the automated machine setup script.** 
    >   


    When working with Git we follow a workflow of steps.

        1. Clone - Create the repository
        2. Add - Identify files that we changed and want to save.
        3. Commit - Save the change by creating a checkpoint or *changeset*.
        4. Push - Copying changes into a *remote* repository.

- ### <a id="GitWorkflow"></a>[The Git Workflow](http://book.techelevator.com/java/introduction-to-tools/version-control/5_git-workflow.html)
     ![The Git Workflow](resources/git-workflow.png)

-   #### <a id="GitCommands"></a>Git Commands

    1. **Check Status using `git status`**

    2. **[Stage Changes](http://book.techelevator.com/java/introduction-to-tools/version-control/7_staging-changes.html) using `git add`**

        >   <h5>Instructor Note: </h5>Be sure to show `git add >file-name>`, `git add <folder-name>`, and `git add .`

        > <div class="caution note"><h5>CAUTION NOTE</h5>At no point when a file is staged is it spatially moved from one location to another. Staging only indicates that the changes made to this particular file should be included next time we commit.</div>

    3. **[Committing Changes](http://book.techelevator.com/java/introduction-to-tools/version-control/8_committing-changes.html) using `git commit`** 

    4. **View History using `git log`**

    5. **<a id="GitRepos"></a>Git Remotes using `git remote`**    
        - <div class="definition note"><h5>Local Repository Definition</h5>A <span>local repository</span> refers to the copy of code on our workstation.</div>
        - <div class="definition note"><h5>Remore Repository Definition</h5>A <span>remote repository or git remote</span> is another location where Git source code is stored. It is accessible by a URL and alias.</div>
  
    6. **[Pushing and Pulling](http://book.techelevator.com/java/introduction-to-tools/version-control/9_pushing-pulling-changes.html) using `git push` or `git pull`**
        -    **Push** - the act of copying our local committed changesets to the remote repository.
        -   **Pull** - the act of downloading any new changesets from the remote repository to our local copy.


- <h4>Git Remote Repositories</h4>
![Git Remote Repositories](resources/git-remotes.png)

><h4>Instructor Led Exercise</span></h4>
>
>* Explain the idea of local and remote repositories and the purpose of each remote
>* Walk students through adding a folder and committing to it
>* Walk students through pushing their changes to Bitbucket and observing that they are online

## Student Exercises (Individual)
<div class='purpose'>(Exercises to be performed by individual students)</div><br/>

| Applies To | Link |
|------------|------|
| Java | [m1-java-intro-to-tools-exercises](https://bitbucket.org/te-curriculum/m1-java-intro-to-tools-exercises) |
| .NET | [m1-csharp-intro-to-tools-exercises](https://bitbucket.org/te-curriculum/m1-csharp-intro-to-tools-exercises) |


## Instructor References
<div class='purpose'>(Information and Links to Assist the Instructor in Doing the Lecture)</div><br/>


| Git Command | Description |
|-------------|-------------|
| **`git remote`** | List remote connections to another repository |
| **`git remote -v`** | List remote repositories and their URLs |
| **`git remote add <name> <url>`** | Create a new connection to a remote repository|
| **`git remote rm <name>`** | Remove a connection from a remote repository |
| **`git push <name> <branch>`** | Copies all committed changes to the remote repository |
| **`git pull <name> <branch>`** | Copies all changes in remote repository to your local |
  


## Cheat Sheets & References
<div class='purpose'>(Summmaries or Links to Reference Material/Cheat Sheets)</div><br/>

| Reference | Description |
|-----------|-------------|
| [Git Cheat Sheet](https://drive.google.com/open?id=0Bz4DHj0l-C66QjRfN05LWWZIRGs) | GitHub cheat sheet. |
| [Shell Command Cheat Sheet](https://drive.google.com/open?id=0Bz4DHj0l-C66ak9ZZVc0cjNZZU0) | Shell command cheat sheet. |
| [Apple OS X Command Line Reference](http://ss64.com/osx/) | Comprehensive index of commands for the OS X command line |
