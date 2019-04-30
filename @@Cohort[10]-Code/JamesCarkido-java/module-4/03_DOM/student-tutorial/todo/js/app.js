/******************************************************
 ***JavaScript - DOM - app.js - Tutorial - Todo List***
 ******************************************************/

 const todoList = document.getElementById('todos');

 let todos = [];
 let pageTitle = '';

 // this function creates variables
 function init(){
     pageTitle = 'My Morning Routine';
     todos = [{
         id: 1,
         task: 'Wake up',
         completed: false
     },
     {
         id: 2,
         task: 'Brush Teeth',
         completed: false
     },
     {
         id: 3,
         task: 'Shower',
         completed: false,
     },
     {
         id: 4,
         task: 'Get Dressed',
         completed: false,
     },
     {
         id: 5, 
         task: 'Drive to work',
         completed:false, 
     },
     {
         id: 6,
         task: 'Work',
         completed: false
     },
     {
         id: 7,
         task: ' Drive home from work',
         completed: false,
     },
     {
         id: 8,
         task: 'Dinner',
         completed: false
     },
     {
         id: 9,
         task: 'Brush Teeth',
         completed: false
     },
    {
        id: 10,
        task: 'Go to bed',
        completed: false
    }

    ];
 }

function addPageTitle(){
    const heading = document.createElement('h1');

}
function addPageTitle() {
    const heading = document.createElement('h1');
    heading.innerText = pageTitle;
    todoList.appendChild(heading);
  }

function addTodos(){
    const newUl = document.createElement('ul');
    todos.forEach((todo) => {   // loop through todos[] and call the element todo
        const newLi = document.createElement('li'); // create a list item for each todo in the array
        li.innerText = todo.task; // assign the current task from the array to the li text
        newUl.appendChild(newLi); // add the list item to the ul tag we created
        //the result of the above anonymous function is a new UL tag with a list from our todo array
    });
    todoList.appendChild(newUl); // adds the new ul to the todoList(connects to the dom)
}

// setup our page title and tasks
intit();
// add page title to the DOM
addPageTitle();
//add the task to the DOM
addTodos();