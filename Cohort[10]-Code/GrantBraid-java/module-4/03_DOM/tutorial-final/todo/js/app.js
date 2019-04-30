/*********************************************************************
 * JavaScript - DOM - app.js - Tutorial Final
 *********************************************************************/
const todoList = document.getElementById('todos');
const endingBit = document.getElementById('endingBit');
const tableTest = document.getElementById('tbl');

let todos = [];
let pageTitle = '';

function init() {
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
      completed: false
    },
    {
      id: 4,
      task: 'Get Dressed',
      completed: false
    },
    {
      id: 5,
      task: 'Drive to work',
      completed: false
    },
    {
      id: 6,
      task: 'Work',
      completed: false
    },
    {
      id: 7,
      task: 'Drive home from work',
      completed: false
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

function addPageTitle() {
  const heading = document.createElement('h1');
  heading.innerText = pageTitle;
  todoList.appendChild(heading);
}

function addTodos() {
  let colors = ['orange','yellow','black','red'];
  const ul = document.createElement('ul');
 
//  colors.forEach((color) => {
//    const li = document.createElement('li');
//    li.innerText = color;
//    ul.appendChild(li);
//  } );
  todos.forEach((todo) => {                 // loop thru the todos array 0 call the current element
    const li = document.createElement('li');// create a li tag
    li.innerText = todo.task + ': ' + todo.completed; //assign the current array element to li tag
    ul.appendChild(li);                               // add li to ul tag we created
  }); 
  todoList.appendChild(ul);
}



function ending() {
  pageEnding = 'This is the end';
  const ender = document.createElement('h2');
  ender.innerText = pageEnding;
  endingBit.append(ender);
}

// setup our page title and tasks
init();
// // add page title to the DOM
addPageTitle();
// // add the task to the DOM
addTodos();       // add the ul and all it's li's to DOM
ending();
